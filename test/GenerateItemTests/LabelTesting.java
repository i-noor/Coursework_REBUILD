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

public class LabelTesting { 
	/**
	 * Аннотация указывает на то, что за ней следует метод тестирования
	 */	
	@Test
	public void test() { 
		/**
		 * создаем панель, на которой будет располагаться тестируемая надпись
		 */
		JPanel panel = new JPanel(); 
		/**
		 * с помощью тестируемого метода создаем надпись в соответствии с заданными параметрами
		 */
		JLabel LabelTest = GenerateItems.CreateLabel(panel, "Тестирование", 20, 20, 25,25); 
		/** 
		* проверяем, соответствует ли текст надписи предполагаемому
		*/ 
		assertEquals(LabelTest.getText(), "Тестирование");
		/** 
		* Проверяется, соответствуют ли координаты надписи ожидаемым
		*/ 
		assertEquals(LabelTest.getX(), 20);
		assertEquals(LabelTest.getY(), 20); 
		/** 
		* Проверяется, соответствуют ли размеры надписи ожидаемым
		*/ 
		assertEquals(LabelTest.getWidth(),25);
		assertEquals(LabelTest.getHeight(),25);
	}
}