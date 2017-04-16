/**
 * Указывает, к какому пакету принадлежит файл
 */
package mainpack;
/**
 * импорт необходимых библиотек
 */
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
/**
 * объявление класса, содержащего методы генерации графических элементов и их названий
 */
public class GenerateItems {
	/**
	 *метод, создающий текстовое поле в соответствии с указанными параметрами
	 */
	public static JTextField CreateTField(JPanel pane, String text ,int x,int y,int wid,int hei) {
		JTextField tfield = new JTextField(text);
		tfield.setBounds(x, y, wid, hei);
		pane.add(tfield);
		tfield.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		tfield.setColumns(10);
		return tfield;	}
	/**
	 *метод, создающий надпись в соответствии с указанными параметрами
	 */
	public static JLabel CreateLabel(JPanel pane, String text ,int x,int y,int wid,int hei) {
		JLabel label = new JLabel(text);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(x, y, wid, hei);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pane.add(label);
		return label;	}
	/**
	 *метод, создающий кнопку в соответствии с указанными параметрами
	 */
	public static JButton CreateButton(ActionListener listener, JPanel pane, String text,int x,int y,int wid,int hei){
		JButton button = new JButton(text);
		/**
		 * задаем обработку событий для создаваемой кнопки
		 */
		button.addActionListener(listener);
		button.setBounds(x, y, wid, hei);
		pane.add(button);
		return button;	}
	/**
	 *метод, создающий панель в соответствии с указанными параметрами
	 */
	public static JPanel CreatePanel(JPanel contentPane, int x,int y,int wid,int hei, boolean flag){
		JPanel panel = new JPanel();
		panel.setBounds(x, y, wid, hei);
		panel.setLayout(null);
		panel.setVisible(flag);
		contentPane.add(panel);
		return panel;	}
	/**
	 * метод, считывающий названия элементов из файла
	 */
	public static String[] GenerateItemNames(){
		/**
		 * инициализация массива для хранения названий элементов
		 */
		String itemnames[];
		String path;
		/**
		 * указание файла с названиями элементов
		 */
		File file = new File("./itemnames.txt");
		/**
		 * В случае, если файл не существует, возвращается пустой массив строк. Размер массива выбран для гарантированного избежания ошибок
		 */
		if (!file.exists()) {
			itemnames = new String[99];
			return itemnames;
		}
		/**
		 * указание полного пути к файлу
		 */
		path = file.getPath();
		/**
		 * считывание количества строк, столбцов и названий элементов из файла
		 */
		int rowcolnum[] = FileWorker.count(path);
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
}