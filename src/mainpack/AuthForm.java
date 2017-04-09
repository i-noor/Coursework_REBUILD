/**
 * объявление пакета
 */
package mainpack;
/**
 * подключение пакета с классами для работы с компонентами экранной формы
 */
import javax.swing.*; 
/**
 * подключение пакета с классами для настройки границ формы
 */
import javax.swing.border.EmptyBorder;
/**
 * подключение пакета с классами для работы с компонентами экранной формы
 */
import java.awt.*;
/**
 * подключение пакета с классами для обработки событий
 */
import java.awt.event.*;
/**
 * объявление класса, наследующего члены класса JFrame, для создания формы аутентификации
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
			 * определение метода, с помощью которого код передается в другой класс
			 *  для выполнения
			 */
			public void run() {
				/**
				 * задание блока программного кода, который требуется защитить от исключений
				 */
				try {
					/**
					 * создание экземпляра класса с экранной формой
					 */
					AuthForm frame = new AuthForm();
					/**
					 * установка видимости рамки
					 */
					frame.setVisible(true);
					/**
				        * обработка возникающих исключений
				        */
				} catch (Exception e) {
					/**
					 * печать информации относительно исключения, как оно произошло и в какой строке кода. 
					 */
					e.printStackTrace();}
				/**
				 * закрытие фигурных скобок после описания метода
				 */
			}
			/**
			 * Закрытие фигурных скобок после описания операции, доставляемой в главный поток
			 */
		});
		/**
		 * закрытие фигурных скобок после описания главного класса
		 */
	}
	/**
	 * конструктор класса, создающий экранную форму
	 */
	
	public AuthForm(){
		/**
		 * определение операции, закрывающей экранную форму
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**
		 * задание границ экранной формы
		 */
		setBounds(100, 100, 260, 220);
		/**
		 * создание новой панели, на которой будут размещены компоненты экранной формы
		 */
		contentPane = new JPanel();
		/**
		 * задание границ и разрывов между ними на панели содерджимого
		 */
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		/**
		 * определение панели содержимого
		 */
		setContentPane(contentPane);
		/**
		 * установка ручного размещения компонентов
		 */
		contentPane.setLayout(null);
		/**
		 * вызов метода, генерирующего названия элементов
		 */
		itemnames = GenerateItems.GenerateItemNames();
		/**
		 * инициализация нового текстового поля для ввода логина
		 */
		JTextField loginField = GenerateItems.CreateTField(contentPane, "",101, 74, 118, 20);
		/**
		 * инициализация нового текстового поля для ввода пароля
		 */
		JTextField passwordField = GenerateItems.CreateTField(contentPane, "",101, 105, 118, 20);
		/**
		 * инициализация новой надписи для вывода сообщения
		 */
		JLabel labelMessages = GenerateItems.CreateLabel(contentPane, "", 31, 55, 188, 14);
		/**
		 * инициализация новой надписи для вывода пояснений
		 */
		JLabel labelAuth = GenerateItems.CreateLabel(contentPane, itemnames[0], 31, 30, 188, 14);
		/**
		 * инициализация новой надписи для вывода пояснений к текстовому полю для ввода логина
		 */
		JLabel labelLogin = GenerateItems.CreateLabel(contentPane, itemnames[6], 31, 77, 60, 14);
		/**
		 * инициализация новой надписи для вывода пояснений к текстовому полю для ввода пароля
		 */
		JLabel labelPassword = GenerateItems.CreateLabel(contentPane, itemnames[7], 31, 108, 60, 14);
		/**
		 * задаем обработку событий для кнопки выхода
		 */
		ActionListener ExitButListener = new ActionListener() {
			/**
			 * инициализация метода для обработки нажатия кнопки
			 */
			public void actionPerformed(ActionEvent e) {
				/**
				 * удаление формы
				 */
				dispose();
				 /**
				  * закрываем скобку после описания метода для обработки нажатия кнопки
				  */ 
			}
			/**
			 * закрытие скобок после описания обработчика события 
			 */
		};
		/**
		 * инициализация кнопки выхода
		 */
		JButton buttonExit = GenerateItems.CreateButton(ExitButListener,contentPane, itemnames[1], 130, 136, 89, 23);
		/**
		 * задаем обработку событий для кнопки ввода
		 */
		ActionListener AuthButListener = new ActionListener() {
			/**
			 * инициализация метода для обработки нажатия кнопки
			 */
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * проверка соответствия логина и пароля для первого пользователя
				 */
			if (loginField.getText().equals("1") && passwordField.getText().equals("1")) { 
				/**
				 * создание экземпляра класса с экранной формой для первого пользователя
				 */
				FirstForm fr1 = new FirstForm(1);
				/**
				 * установка видимости формы
				 */
				fr1.setVisible(true); 	}
			/**
			 * проверка соответствия логина и пароля для второго пользователя
			 */
			else if (loginField.getText().equals("2") && passwordField.getText().equals("2")) 	{ 
				/**
				 * создание экземпляра класса с экранной формой для второго пользователя
				 */
				FirstForm fr1 = new FirstForm(2);
				/**
				 * установка видимости формы
				 */
				fr1.setVisible(true); }
			/**
			 * обработка неверных данных
			 */
			else
				/**
				 * вывод сообщения о несоответствии данных
				 */
				{labelMessages.setText(itemnames[8]);}
			 /**
			  * закрываем скобку после описания метода для обработки нажатия кнопки
			  */ 
			}
			/**
			 * закрытие скобок после описания обработчика события
			 */
		};
		/**
		 * инициализация кнопки входа
		 */
		JButton buttonAuth = GenerateItems.CreateButton(AuthButListener, contentPane, itemnames[0], 31, 136, 89, 23);
		/**
		 * закрытие фигурных скобок после описания метода, создающего экранную форму
		 */
	}
	/**
	 * закрытие фигурных  скобок после описания конструктора класса
	 */
}