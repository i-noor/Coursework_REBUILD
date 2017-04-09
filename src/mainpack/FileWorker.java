package mainpack;

import java.io.*;
import java.util.Scanner;

class FileWorker {
	static int[] count (String path){
		String str;
		int i;
		int num[] = {1,1};
		File file = new File(path);
        Scanner scanner;
		try {
			scanner = new Scanner(file);
			str = scanner.nextLine();
			for  (i=0;i<str.length();i++) {if (str.charAt(i)==',') num[1]++;}
			while (scanner.hasNext()) {
				scanner.nextLine();
			    num[0]++;            
			}
			scanner.close();
			return num;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}		
	}
	static String[][] read (String path, int rows, int columns){
		String filecontent[][] = new String[rows][columns];
		String str;
		int i=0,j,symb;
		File file = new File(path);
        Scanner scanner;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNext()) {
	        	str = scanner.nextLine();
	        	for (j=0;j<columns;j++) filecontent[i][j]="";
	        	j=0;
	        	symb=0;
				while (j<columns-1)
			    {
					while (symb<str.length()) {					
						if (str.charAt(symb)==',') {
							j++;
							symb++;}
						filecontent[i][j] = filecontent[i][j] + str.charAt(symb);
						symb++;
						if (symb==str.length()) j=columns;
					}
			    }
				i++;
	        }
	        scanner.close();
			return filecontent; 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	static void write (String path, String str) {
		FileWriter writeFile = null;
		try {
		    File file = new File(path);
		    writeFile = new FileWriter(file);
		    writeFile.write(str+System.getProperty("line.separator"));
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    if(writeFile != null) {
		        try {
		            writeFile.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		}
	}
}