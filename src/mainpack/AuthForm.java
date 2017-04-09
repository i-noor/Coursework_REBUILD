/**
 * объявление пакета и классов, необходимых для работы
 */
package mainpack;

import javax.swing.*; 
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
/**
 * объявление класса, необходимого для создания формы аутентификации
 */
class AuthForm extends JFrame{
	/**
	 * инициализация массива для хранения названий элементов
	 */
	private String itemnames[];
	/**
	 * устанавливаем идентификатор версии сериализованного класса
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * инициализация панели, на которой будут располагаться компоненты экранной формы
	 */
	private JPanel contentPane;
	/**
	 * объявление главного класса
	 */
	public static void main(String[] args) {
		/**
		 * доставка операции в главный поток
		 */
		EventQueue.invokeLater(new Runnable() {
			/**
			 * определение метода, с помощью которого код передается в другой класс для выполнения
			 */
			public void run() {
				/**
				 * задание блока программного кода, который требуется защитить от исключений
				 */
				try {
					/**
					 * создание экземпляра класса с экранной формой и установка видимости рамки
					 */
					AuthForm frame = new AuthForm();
					frame.setVisible(true);
					/**
				        * обработка возникающих исключений
				        */
				} catch (Exception e) {
					/**
					 * печать информации относительно исключения, как оно произошло и в какой строке кода. 
					 */
					e.printStackTrace();}
			}
		});
	}
	/**
	 * конструктор класса, создающий экранную форму
	 */
	public AuthForm(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 260, 220);
		/**
		 * создание новой панели, на которой будут размещены компоненты экранной формы
		 */
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/**
		 * вызов метода, генерирующего названия элементов
		 */
		itemnames = GenerateItems.GenerateItemNames();
		/**
		 * инициализация текстовых полей для ввода логина и пароля
		 */
		JTextField loginField = GenerateItems.CreateTField(contentPane, "",101, 74, 118, 20);
		JTextField passwordField = GenerateItems.CreateTField(contentPane, "",101, 105, 118, 20);
		/**
		 * инициализация надписей
		 */
		JLabel labelMessages = GenerateItems.CreateLabel(contentPane, "", 31, 55, 188, 14);
		JLabel labelAuth = GenerateItems.CreateLabel(contentPane, itemnames[0], 31, 30, 188, 14);
		JLabel labelLogin = GenerateItems.CreateLabel(contentPane, itemnames[6], 31, 77, 60, 14);
		JLabel labelPassword = GenerateItems.CreateLabel(contentPane, itemnames[7], 31, 108, 60, 14);
		/**
		 * задаем обработку событий для кнопки выхода
		 */
		ActionListener ExitButListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * удаление формы
				 */
				dispose();
			}
		};
		/**
		 * инициализация кнопки выхода
		 */
		JButton buttonExit = GenerateItems.CreateButton(ExitButListener,contentPane, itemnames[1], 130, 136, 89, 23);
		/**
		 * задаем обработку событий для кнопки ввода
		 */
		ActionListener AuthButListener = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * проверка соответствия логина и пароля для первого пользователя
				 */
			if (loginField.getText().equals("1") && passwordField.getText().equals("1")) { 
				/**
				 * создание экземпляра класса с экранной формой для первого пользователя и установка видимости формы
				 */
				FirstForm fr1 = new FirstForm(1);
				fr1.setVisible(true); 	}
			/**
			 * проверка соответствия логина и пароля для второго пользователя
			 */
			else if (loginField.getText().equals("2") && passwordField.getText().equals("2")) 	{ 
				/**
				 * создание экземпляра класса с экранной формой для второго пользователя и установка видимости формы
				 */
				FirstForm fr1 = new FirstForm(2);
				fr1.setVisible(true); }
			/**
			 * обработка неверно введенных данных
			 */
			else
				/**
				 * вывод сообщения о несоответствии данных
				 */
				{labelMessages.setText(itemnames[8]);}
			}
		};
		/**
		 * инициализация кнопки входа
		 */
		JButton buttonAuth = GenerateItems.CreateButton(AuthButListener, contentPane, itemnames[0], 31, 136, 89, 23);
		
	}
}