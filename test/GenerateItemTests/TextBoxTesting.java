/**
 * Указывает, к какому пакету принадлежит класс
 */
package GenerateItemTests; 
/**
 * Импортируются необходимые для работы теста библиотеки
 */
import static org.junit.Assert.*;
import javax.swing.*;
import org.junit.Test;
import mainpack.GenerateItems;

public class TextBoxTesting { 
	/**
	 * Аннотация указывает на то, что за ней следует метод тестирования
	 */	
	@Test
	public void test() { 
		/**
		 * создаем панель, на которой будет располагаться тестируемое текстовое поле
		 */
		JPanel panel = new JPanel(); 
		/**
		 * с помощью тестируемого метода создаем текстовое поле в соответствии с заданными параметрами
		 */
		JTextField TextboxTest = GenerateItems.CreateTField(panel, "Текст", 10, 10, 15, 15); 
		/** 
		* Проверяется, соответствуют ли координаты текстового поля ожидаемым
		*/ 
		assertEquals(TextboxTest.getX(), 10);
		assertEquals(TextboxTest.getY(), 10); 
		/** 
		* Проверяется, соответствуют ли размеры текстового поля ожидаемым
		*/ 
		assertEquals(TextboxTest.getWidth(), 15);
		assertEquals(TextboxTest.getHeight(), 15);
		/**
		 * Проверяется, соответствует ли текст текстового поля ожидаемому
		 */
		assertEquals(TextboxTest.getText(),"Текст");
	}
}