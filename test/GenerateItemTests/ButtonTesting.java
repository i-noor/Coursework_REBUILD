/**
 * Указывает, к какому пакету принадлежит класс
 */
package GenerateItemTests; 
/**
 * Импортируются необходимые для работы теста библиотеки
 */
import static org.junit.Assert.*;
import java.awt.event.*;
import javax.swing.*;
import org.junit.Test;
import mainpack.GenerateItems;

public class ButtonTesting { 
	/**
	 * Аннотация указывает на то, что за ней следует метод тестирования
	 */
	@Test
	public void test() { 
		/**
		 * создаем панель, на которой будет располагаться тестируемая кнопка
		 */
		JPanel panel = new JPanel(); 
		/**
		 * задаем обработку событий для тестируемой кнопки
		 */
		ActionListener TestListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {	}};
		/**
		 * с помощью тестируемого метода создаем кнопку в соответствии с заданными параметрами
		 */
		JButton ButtonTest = GenerateItems.CreateButton(TestListener, panel, "Кнопка", 40, 30, 50,50); 
		/** 
		* Проверяется, соответствуют ли координаты кнопки ожидаемым
		*/ 
		assertEquals(ButtonTest.getX(), 40);
		assertEquals(ButtonTest.getY(), 30); 
		/** 
		* Проверяется, соответствуют ли размеры кнопки ожидаемым
		*/ 
		assertEquals(ButtonTest.getWidth(),50);
		assertEquals(ButtonTest.getHeight(),50);
		/**
		 * Проверяется, соответствует ли текст в кнопке ожидаемому
		 */
		assertEquals(ButtonTest.getText(),"Кнопка");
	}
}