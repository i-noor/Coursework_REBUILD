/**
 * Указывает, к какому пакету принадлежит файл
 */
package mainpack;
/**
 * импорт необходимых библиотек
 */
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
/**
 * объявление класса, создающего форму пользователя
 */
public class FirstForm extends JFrame {
	/**
	 * устанавливаем идентификатор версии сериализованного класса
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * инициализация панели содержимого, на которой будут располагаться компоненты экранной формы
	 */
	private JPanel contentPane;
	/**
	 * инициализация переменных, используемых в нескольких методах
	 */
	private String path;
	private int rowcolnum[];
	private String filecont[][];
	private String data[][];
	private String columnnames[];	
	/**
	 * конструктор класса, создающий экранную форму
	 */
	public FirstForm(int flag) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 335);
		/**
		 * создание новой панели содержимого, на которой будут размещены компоненты экранной формы
		 */
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/**
		 * Загрузка названий элементов из файла через специальный метод
		 */
		String itemnames[] = GenerateItems.GenerateItemNames();
		/**
		 * генерация рабочих панелей и создание таблицы, отвечающей за вывод основной информации
		 */
		JPanel panelWork = GenerateItems.CreatePanel(contentPane, 10, 11, 414, 239, false);		
		JPanel panelDownload = GenerateItems.CreatePanel(contentPane, 10, 11, 414, 239, true);		
		JTable table = new JTable();		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 394, 183);
		panelWork.add(scrollPane);		
		/**
		 * задаем возможность ручной корректировки ширины колонок
		 */
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		table.setBounds(10, 191, 394, -179);	
		/**
		 * Обработчик события, происходящего при нажатии на кнопку
		 */
		ActionListener CloseButListener = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * изменяем видимость панелей для появления панели загрузки
				 */
				panelWork.setVisible(false);
				panelDownload.setVisible(true);
				/**
				 * Обнуляются массивы для хранения данных таблицы и для хранения названий заголовков
				 */
				data = new String[0][0];
				columnnames = new String[0];
				/**
				 * задаем интерфейс и данные таблицы и обнуляем переменную для обозначения пути к файлу
				 */
				table.setModel(new DefaultTableModel(data,columnnames));
				path = null;
			}
		};
		/**
		 * инициализация кнопки закрытия файла
		 */
		JButton buttonClose =  GenerateItems.CreateButton(CloseButListener, panelWork, itemnames[2], 10, 205, 89, 23);		
		/**
		 * задаем обработку событий для кнопки сохранения данных
		 */
		ActionListener SaveButListener = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * запись названий колонок таблицы в строку для последующей записи в файл
				 */
				String str = ""; 
				int i,j;
				for (i=0;i<rowcolnum[1];i++) 
				{ 
					if (i!=rowcolnum[1]-1) { str = str + columnnames[i] + ","; } 
						 else { str = str + columnnames[i]; }
				}
				/**
				 * Дополнение строки значениями ячеек таблицы
				 */
				str = str + System.getProperty("line.separator");
				for (i=0;i<rowcolnum[0]-1;i++) {
					for (j=0;j<rowcolnum[1];j++) {
						if (j!=rowcolnum[1]-1) { str = str + String.valueOf(table.getValueAt(i, j)) + ","; }
						else { str = str + String.valueOf(table.getValueAt(i, j)) + System.getProperty("line.separator"); }
					}
				}
				/**
				 * запись строки в файл по указанному пути и вывод сообщения об успешном сохранении
				 */
				FileWorker.write(path, str);
				JOptionPane.showMessageDialog(null, itemnames[9], itemnames[11], JOptionPane.INFORMATION_MESSAGE);
			}
		};
		/**
		 * инициализация кнопки сохранения данных в файл
		 */
		JButton buttonSave = GenerateItems.CreateButton(SaveButListener, panelWork, itemnames[3], 289, 205, 115, 23);		
		/**
		 * задаем обработку событий для кнопки загрузки
		 */
		ActionListener DownloadButListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * изменяем видимость панелей для появления панели работы с файлами
				 */
				panelDownload.setVisible(false);
				panelWork.setVisible(true);
				/**
				 * создание объекта, отвечающего за открытие меню выбора файла для загрузки
				 */
				JFileChooser fileopen = new JFileChooser();
				/**
				* открытие окна выбора файла
				*/			
				int ret = fileopen.showDialog(null, itemnames[10]);                
				if (ret == JFileChooser.APPROVE_OPTION) {
				/**
				 * создание экземпляра выбранного файла
				 */
				File file = fileopen.getSelectedFile();
				/**
				 * получение полного пути к файлу
				 */
				path = file.getPath();
				/**
				 * использование специального метода для подсчета количества строк и столбцов в файле
				 */
				rowcolnum = FileWorker.count(path);
				/**
				 * использование специальногшо метода для считывания данных из файла
				 */
				filecont = FileWorker.read(path, rowcolnum[0], rowcolnum[1]);
				/**
				 * задание размерности массива названий столбцов
				 */
				columnnames = new String[rowcolnum[1]];
				/**
				 * задание размерности массива данных ячеек таблицы
				 */
				data = new String[rowcolnum[0]-1][rowcolnum[1]];
				int i,j;
				/**
				 * Заполнение массива названий столбцов
				 */
				for (j=0;j<rowcolnum[1];j++) columnnames[j]=filecont[0][j];
				/**
				 * Заполнение массива данных ячеек таблицы
				 */
				for (i=0;i<rowcolnum[0]-1;i++)
				{
					for (j=0;j<rowcolnum[1];j++)
					{
						/**
						 * запись данных в массив
						 */
						data[i][j] = filecont[i+1][j];
					}
				}
				if (flag == 2) {
					/**
					 * Запрещаем пользователю редактировать таблицу
					 */
					table.setEnabled(false);
					/**
					 * вычисление суммы заработной платы и налогов
					 */
					for (i=0;i<rowcolnum[0]-1;i++) { 
						data[i][5] = SalaryCount(Float.valueOf(data[i][3]), Float.valueOf(data[i][4]), Float.valueOf(data[i][2]));
						data[i][6] = NDFL(Float.valueOf(data[i][5]));
						data[i][7] = PFR(Float.valueOf(data[i][5]));
						data[i][8] = FFOMS(Float.valueOf(data[i][5]));
						data[i][9] = FSS(Float.valueOf(data[i][5]));
						data[i][10] = FSSNS(Float.valueOf(data[i][5]));
						data[i][11] = TotalSalary(Integer.valueOf(data[i][5]),Integer.valueOf(data[i][6]));
					}
				}
				/**
				 * задаем модель таблицы и заголовки столбцов
				 */
				table.setModel(new DefaultTableModel(data,columnnames));
		        }
			}
		};
		/**
		 * инициализация кнопки загрузки из файла
		 */
		JButton buttonDownload = GenerateItems.CreateButton(DownloadButListener, panelDownload, itemnames[4], 68, 103, 260, 23);		
		/**
		 * задаем обработку событий для кнопки выхода
		 */
		ActionListener ExitButListener = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * открытие формы авторизации и освобождение ресурсов текущей формы
				 */
				AuthForm fr = new AuthForm();
				fr.setVisible(true);	
				dispose();
			}
		};
		/**
		 * инициализация кнопки выхода
		 */
		JButton buttonExit = GenerateItems.CreateButton(ExitButListener, contentPane, itemnames[1], 172, 261, 89, 23);		
	}
	/**
	 * Метод, вычисляющий номинальный размер заработной платы
	 */
	public static String SalaryCount(float totaldays,float days, float sal){
		String str;
		str = String.valueOf((int)(sal*(days/totaldays)));
		return str;
	}
	/**
	 * Метод, вычисляющий размер выплаты по НДФЛ
	 */
	public static String NDFL(float salary){
		String str;
		str = String.valueOf((int)(salary*0.13));
		return str;
	}
	/**
	 * Метод, вычисляющий размер выплаты по ПФР
	 */
	public static String PFR(float salary){
		String str;
		str = String.valueOf((int)(salary*0.22));
		return str;
	}
	/**
	 * Метод, вычисляющий размер выплаты по ФФОМС
	 */
	public static String FFOMS(float salary){
		String str;
		str = String.valueOf((int)(salary*0.051));
		return str;
	}
	/**
	 * Метод, вычисляющий размер выплаты по ФСС
	 */
	public static String FSS(float salary){
		String str;
		str = String.valueOf((int)(salary*0.029));
		return str;
	}
	/**
	 * Метод, вычисляющий размер выплаты по ФСС (Несчастные случаи)
	 */
	public static String FSSNS(float salary){
		String str;
		str = String.valueOf((int)(salary*0.002));
		return str;
	}
	/**
	 * Метод, вычисляющий размер заработной платы к выплате
	 */
	public static String TotalSalary(int salary, int NDFL){
		String str;
		str = String.valueOf(salary-NDFL);
		return str;
	}
}
