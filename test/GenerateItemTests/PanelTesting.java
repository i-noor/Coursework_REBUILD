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

public class PanelTesting { 
	/**
	 * Аннотация указывает на то, что за ней следует метод тестирования
	 */	
	@Test
	public void test() { 
		/**
		 * создаем панель содержимого, на которой будет располагаться тестируемая панель
		 */
		JPanel contentPane = new JPanel(); 
		/**
		 * с помощью тестируемого метода создаем панель в соответствии с заданными параметрами
		 */
		JPanel panel = GenerateItems.CreatePanel(contentPane, 10, 15, 100, 80, true); 
		/** 
		* Проверяется, соответствуют ли координаты панели ожидаемым
		*/ 
		assertEquals(panel.getX(), 10);
		assertEquals(panel.getY(), 15); 
		/** 
		* Проверяется, соответствуют ли размеры панели ожидаемым
		*/ 
		assertEquals(panel.getWidth(),100);
		assertEquals(panel.getHeight(),80);
	}
}