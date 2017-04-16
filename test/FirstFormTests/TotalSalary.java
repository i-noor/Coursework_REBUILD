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

public class TotalSalary {
	/**
	 * Аннотация указывает на то, что за ней следует метод тестирования
	 */
	@Test
    public void TotalSalaryTest() {
            /**
             * Вызывается метод, вычисляющий размер конечной зарплаты сотрудника
             */            
            String s = FirstForm.TotalSalary(15000,1950);
            /**
             * Сверяются результат работы вызванной ранее функции с ожидаемым результатом, в случае несоответствия выводит сообщение о ошибке
             */
            assertEquals("Ошибка при вычислении размера выплаты по НДФЛ.","13050",s);
	}
}
