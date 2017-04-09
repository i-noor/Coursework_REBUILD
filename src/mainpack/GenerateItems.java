/**
 * объявление пакета 
 */
package mainpack;
/**
 * подключение пакета с классами для работы с компонентами экранной формы
 */
import java.awt.*;
/**
 * подключение пакета с классами для обработки событий
 */
import java.awt.event.*;
/**
 * подключение пакета с классами для работы с файлами
 */
import java.io.File;
/**
 * подключение пакета с классами для работы с компонентами экранной формы
 */
import javax.swing.*;
/**
 * объявление класса, генерирующего элементы экранной формы
 */
class GenerateItems {
	/**
	 *метод, создающий текстовое поле в соответствии с указанными параметрами
	 */
	public static JTextField CreateTField(JPanel pane, String text ,int x,int y,int wid,int hei) {
		/**
		 * инициализация нового текстового поля
		 */
		JTextField tfield = new JTextField(text);
		/**
		 * определение границ текстового поля
		 */
		tfield.setBounds(x, y, wid, hei);
		/**
		 * добавление текстового поля на панель
		 */
		pane.add(tfield);
		/**
		 * установка шрифта для текстового поля
		 */
		tfield.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		/**
		 * задаем количество символов в поле
		 */
		tfield.setColumns(10);
		/**
		 * возвращаем созданное в методе текстовое поле
		 */
		return tfield;	}
	/**
	 *метод, создающий надпись в соответствии с указанными параметрами
	 */
	public static JLabel CreateLabel(JPanel pane, String text ,int x,int y,int wid,int hei) {
		/**
		 * инициализация новой надписи
		 */
		JLabel label = new JLabel(text);
		/**
		 * установка выравнивания содержимого надписи по центру
		 */
		label.setHorizontalAlignment(SwingConstants.CENTER);
		/**
		 * определение границ надписи
		 */
		label.setBounds(x, y, wid, hei);
		/**
		 * установка шрифта для надписи
		 */
		label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		/**
		 * добавление надписи на панель
		 */
		pane.add(label);
		/**
		 * возвращаем созданную в методе надпись
		 */
		return label;	}
	/**
	 *метод, создающий кнопку в соответствии с указанными параметрами
	 */
	public static JButton CreateButton(ActionListener listener, JPanel pane, String text,int x,int y,int wid,int hei){
		/**
		 * инициализация новой кнопки
		 */
		JButton button = new JButton(text);
		/**
		 * задаем обработку событий для создаваемой кнопки
		 */
		button.addActionListener(listener);
		/**
		 * определение границ кнопки
		 */
		button.setBounds(x, y, wid, hei);
		/**
		 * добавление кнопки на панель
		 */
		pane.add(button);
		/**
		 * возвращаем созданную в методе кнопку
		 */
		return button;	}
	/**
	 *метод, создающий панель в соответствии с указанными параметрами
	 */
	public static JPanel CreatePanel(JPanel contentPane, int x,int y,int wid,int hei, boolean flag){
		/**
		 * инициализация новой панели
		 */
		JPanel panel = new JPanel();
		/**
		 * определение границ панели
		 */
		panel.setBounds(x, y, wid, hei);
		/**
		 * установка ручного размещения компонентов на создаваемой панели
		 */
		panel.setLayout(null);
		/**
		 * установка видимости панели в зависимости от указанного параметра
		 */
		panel.setVisible(flag);
		/**
		 * добавление создаваемой панели на панель содержимого
		 */
		contentPane.add(panel);
		/**
		 * возвращаем созданную в методе панель
		 */
		return panel;	}
	/**
	 * метод, считывающий названия элементов из файла
	 */
	public static String[] GenerateItemNames(){
		/**
		 * инициализация массива для хранения названий элементов
		 */
		String itemnames[];
		/**
		 * инициализация переменной, хранящей путь к файлу
		 */
		String path;
		/**
		 * указание файла с названиями элементов
		 */
		File file = new File("./itemnames.txt");
		/**
		 * указание полного пути к файлу
		 */
		path = file.getPath();
		/**
		 * считывание количества строк и столбцов
		 */
		int rowcolnum[] = FileWorker.count(path);
		/**
		 * считывание названий элементов из файла
		 */
		String str[][] = FileWorker.read(path, rowcolnum[0], rowcolnum[1]);
		/**
		 * занесение считанных элементов в массив, возвращаемый методом
		 */
		itemnames = new String[rowcolnum[0]];
		int i;
		for (i=0;i<rowcolnum[0];i++)
		{
			itemnames[i]="";
			itemnames[i]=str[i][0];
		}
		return itemnames;
	}
	/**
	 * закрытие фигурных  скобок после описания класса
	 */
}