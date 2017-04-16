/**
 * Указывает, к какому пакету принадлежит класс
 */
package FirstFormTests;
/**
 * Импортируются необходимые для работы теста библиотеки
 */
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import mainpack.FirstForm;

public class FSS {
	/**
	 * Аннотация указывает на то, что за ней следует метод тестирования
	 */
	@Test
    public void FSSTest() {
            /**
             * Вызывается метод, вычисляющий размер выплаты по ФСС
             */            
            String s = FirstForm.FSS(15000);
            /**
             * Сверяются результат работы вызванной ранее функции с ожидаемым результатом, в случае несоответствия выводит сообщение о ошибке
             */
            assertEquals("Ошибка при вычислении размера выплаты по НДФЛ.","435",s);
	}
}
