/**
 * объявление пакета
 */
package mainpack;
/**
 * подключение библиотеки для работы с файлами
 */
import java.io.*;
/**
 * подключение библиотеки для работы с потоками ввода-вывода данных
 */
import java.util.Scanner;
/**
 * объявление класса для работы с файлами
 */
class FileWorker {
	/**
	 * создание метода для считывания количества строк и столбцов
	 */
	static int[] count (String path){
		/**
		 * объявление переменных
		 */
		String str;		
		int i;		
		int num[] = {1,1};
		/**
		 * создание экземпляра файла file, находящегося по заданному пути path
		 */
		File file = new File(path);
		/**
		 * объявление переменной типа Scanner
		 */
        	Scanner scanner;
		/**
		 * задание блока программного кода, который требуется защитить от исключений
		 */
		try {
			/**
			 * создание экземпляра класса Scanner
			 */			
			scanner = new Scanner(file);
			/**
			 * запись строки в переменную str
			 */
			str = scanner.nextLine();
			/**
			 * цикл для подсчета количества столбцов
			 */
			for  (i=0;i<str.length();i++) {if (str.charAt(i)==',') num[1]++;}
			/**
			 * цикл для подсчета количества строк
			 */
			while (scanner.hasNext()) {
				scanner.nextLine();
			    num[0]++;            
			}
			scanner.close();
			return num;
		/**
		* обработка возникающих исключений
		*/
		} catch (FileNotFoundException e) {
			/**
			 * печать информации относительно исключения, как оно произошло и в какой строке кода. 
			 */
			e.printStackTrace();
			return null;
		}		
	}
	/**
	 * создание метода для чтения данных из файла
	 */
	static String[][] read (String path, int rows, int columns){
		/**
		 * объявление переменных
		 */
		String filecontent[][] = new String[rows][columns];
		String str;
		int i=0,j,symb;
		/**
		 * создание экземпляра файла file, находящегося по заданному пути path
		 */
		File file = new File(path);
		/**
		 * объявление переменной типа Scanner
		 */
        	Scanner scanner;
		/**
		 * задание блока программного кода, который требуется защитить от исключений
		 */
		try {
			/**
			 * создание экземпляра класса Scanner
			 */	
			scanner = new Scanner(file);
			/**
			 * цикл для перебора всех строк
			 */
			while (scanner.hasNext()) {
			/**
			 * запись строки в переменную str
			 */
	        	str = scanner.nextLine();
			/**
			 * цикл для очистки значений массива filecontent
			 */
	        	for (j=0;j<columns;j++) filecontent[i][j]="";
	        	j=0;
	        	symb=0;
			/**
			 * цикл для перебора столбцов
			 */
				while (j<columns-1)
			    {
					/**
					 * цикл для перебора символов строки
					 */
					while (symb<str.length()) {
						/**
						 * если текущий символ - запятая, переходим на следующий столбец
						 */
						if (str.charAt(symb)==',') {
							j++;
							symb++;}
						/**
						 * добавляем текущий символ в массив 
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
		/**
		* обработка возникающих исключений
		*/
		} catch (FileNotFoundException e) {
			/**
			 * печать информации относительно исключения, как оно произошло и в какой строке кода. 
			 */
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * создание метода для записи данных в файл
	 */
	static void write (String path, String str) {
		/**
		 * создание переменной типа FileWriter
		 */
		FileWriter writeFile = null;
		/**
		 * задание блока программного кода, который требуется защитить от исключений
		 */
		try {
		/**
		 * создание экземпляра файла file, находящегося по заданному пути path
		 */
		    File file = new File(path);
			/**
			 * присвоение файла переменной типа FileWriter
			 */
		    writeFile = new FileWriter(file);
		    writeFile.write(str+System.getProperty("line.separator"));
		/**
		* обработка возникающих исключений
		*/
		} catch (IOException e) {
			/**
			 * печать информации относительно исключения, как оно произошло и в какой строке кода. 			 
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
			/**
			* обработка возникающих исключений
			*/
		        } catch (IOException e) {
				/**
				 * печать информации относительно исключения, как оно произошло и в какой строке кода. 
				 */
		            	e.printStackTrace();
		        }
		    }
		}
	}
}
