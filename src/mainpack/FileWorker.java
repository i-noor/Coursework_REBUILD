/**
 * Указывает, к какому пакету принадлежит файл
 */
package mainpack;
/**
 * импорт необходимых библиотек
 */
import java.io.*;
import java.util.Scanner;
/**
 * объявление класса для работы с файлами
 */
class FileWorker {
	/**
	 * Метод отвечает за подсчет числа строк и числа столбцов в файле
	 */
	static int[] count (String path){
		/**
		 * Объявление необходимых для работы метода переменных
		 */
		String str;		
		int i;
		int num[] = {1,1};
		/**
		 * Создание объекта файла, расположенного по переданному в метод пути
		 */
		File file = new File(path);
		/**
		 * Объявление переменной считывателя
		 */
        Scanner scanner;
		/**
		 * Блок, реализующий основную функцию метода. Защищен от исключений
		 */
		try {
			/**
			 * Инициализируется объект, отвечающий за считывание информации из файла 
			 */			
			scanner = new Scanner(file);
			/**
			 * Из файла считывается очередная строка
			 */
			str = scanner.nextLine();
			/**
			 * Подсчитывает число столбцов в файле. Символ ",", встреченный в файле, указываает на конец столбца
			 */
			for  (i=0;i<str.length();i++) {if (str.charAt(i)==',') num[1]++;}
			/**
			 * Подсчитывает количество строк в файле
			 */
			while (scanner.hasNext()) {
				scanner.nextLine();
			    num[0]++;            
			}
			scanner.close();
			return num;
		
		}
		/**
		* Обработка исключений
		*/
		catch (FileNotFoundException e) {
			/**
			 * Вывод информации о возникшем исключении
			 */
			e.printStackTrace();
			return null;
		}		
	}
	/**
	 * Отвечает за считывание данных из файла
	 */
	static String[][] read (String path, int rows, int columns){
		/**
		 * объявление переменных, необходимых для работы
		 */
		String filecontent[][] = new String[rows][columns];
		String str;
		int i=0,j,symb;
		/**
		 * Создание объекта файла, расположенного по переданному в метод пути
		 */
		File file = new File(path);
		/**
		 * Объявление переменной считывателя
		 */
        	Scanner scanner;
		/**
		 * Блок, реализующий основную функцию метода. Защищен от исключений
		 */
		try {
			/**
			 * Инициализируется объект, отвечающий за считывание информации из файла
			 */	
			scanner = new Scanner(file);
			/**
			 * Цикл, переписывающий данные из файла в возвращаемую переменную
			 */
			while (scanner.hasNext()) {
			/**
			 * Очередная строка из файла временно заносится в переменную
			 */
	        str = scanner.nextLine();
			/**
			 * Значение каждого столбца текущей строки возвращаемой переменной приводится к пустой строке
			 */
        	for (j=0;j<columns;j++) filecontent[i][j]="";
        	j=0;
        	symb=0;
			/**
			 * Заполняются столбцы текущей строки возвращаемой переменной
			 */
			while (j<columns-1)
		    {
				/**
				 * Считанная из файла строка перебирается и переписывается в возвращаемую переменную
				 */
				while (symb<str.length()) {
					/**
					 * Символ "," - разделитель, указывающий на необходимость перехода к следующему столбцу
					 */
					if (str.charAt(symb)==',') {
						j++;
						symb++;}
					/**
					 * Каждый символ строки переписывается в один из столбцов возвращаемой переменной 
					 */
					filecontent[i][j] = filecontent[i][j] + str.charAt(symb);
					symb++;
					if (symb==str.length()) j=columns;
				}
		    }
			/**
			 * переход на следующую строку
			 */
			i++;
	        }
	        scanner.close();
			return filecontent;
		} 
		/**
		* Обработка исключений
		*/
		catch (FileNotFoundException e) {
			/**
			 * Вывод информации о возникшем исключении
			 */
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * Метод, отвечающий за запись данных в файл
	 */
	static void write (String path, String str) {
		/**
		 * Создается пустой объект, отвечающий за запись данных в файл
		 */
		FileWriter writeFile = null;
		/**
		 * Блок, реализующий основную функцию метода. Защищен от исключений
		 */
		try {
		/**
		 * Создание объекта файла, расположенного по переданному в метод пути
		 */
	    File file = new File(path);
		/**
		 * В объект, отвечающий за запись данных в файл, передается файл
		 */
	    writeFile = new FileWriter(file);
	    writeFile.write(str+System.getProperty("line.separator"));
		} 
		/**
		* Обработка исключений
		*/
		catch (IOException e) {
			/**
			 * Вывод информации о исключении		 
			 */
			 e.printStackTrace();
		/**
		 * завершение начатых операций при любом варианте развития событий			 
		 */
		} finally {
		    if(writeFile != null) {
			 /**
			 * задание блока программного кода, который требуется защитить от исключений
			 */
		        try {
		            writeFile.close();
		        }
		        /**
				* Обработка исключений
				*/
		        catch (IOException e) {
				/**
				 * Вывод информации о исключении
				 */
		            	e.printStackTrace();
		        }
		    }
		}
	}
}
