package mainpack;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

class FirstForm extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int rownumber=0;
	private String path, filecontent;
	private String data[][];
	private String columnnames[];	
	public FirstForm(int flag) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		JPanel panelWork = GenerateItems.CreatePanel(contentPane, 10, 11, 414, 239, false);		
		JPanel panelDownload = GenerateItems.CreatePanel(contentPane, 10, 11, 414, 239, true);		
		ActionListener CloseButListener = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelWork.setVisible(false);
				panelDownload.setVisible(true);
				filecontent = ""; path = null;
			}
		};
		JButton buttonClose =  GenerateItems.CreateButton(CloseButListener, panelWork, "Close", 10, 205, 89, 23);		
		JTable table = new JTable();		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 394, 183);
		panelWork.add(scrollPane);		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		table.setBounds(10, 191, 394, -179);		
		ActionListener SaveButListener = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = ""; 
				int i;
				if (flag == 1) {
					for (i=0;i<5;i++) 
					{ 
						if (i!=4) { str = str + columnnames[i] + ","; } 
							 else { str = str + columnnames[i]; }
					}
					SaveFile(table, 5, str);
				}
				else {
					for (i=0;i<12;i++) 
					{
						if (i!=11) {str = str + columnnames[i] + ",";} 
							  else {str = str + columnnames[i];}
					}
					SaveFile(table, 12, str);
				}
			}
		};
		JButton buttonSave = GenerateItems.CreateButton(SaveButListener, panelWork, "Save", 289, 205, 115, 23);		
		ActionListener DownloadButListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int columnnum=0, colforfill=0;
				panelDownload.setVisible(false);
				panelWork.setVisible(true);
				if (flag == 1) {
					columnnum = 5;
					colforfill = 2;
				}
				else if (flag==2) {
					table.setEnabled(false);
					columnnum = 12;
					colforfill = 5;
				}
				JFileChooser fileopen = new JFileChooser();				
		        int ret = fileopen.showDialog(null, "Открыть файл");                
		        if (ret == JFileChooser.APPROVE_OPTION) {
					File file = fileopen.getSelectedFile();
					path = file.getPath();
					try {
						filecontent = FileWorker.read(path);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}					
					int symb=0,j=0,k=0, i; 
					rownumber = 0;
					for (k=0;k<filecontent.length();k++) {if (filecontent.charAt(k)=='\n') {rownumber++;}}
					rownumber--;
					data = new String[rownumber][columnnum];
					for (k=0;k<rownumber;k++) {
						j=0;
						for (i=0;i<colforfill;i++) data[k][i]="";
						while (j<colforfill)
					    {
					    	data[k][j] = data[k][j] + filecontent.charAt(symb); 
					    	symb++;
					    	if (filecontent.charAt(symb)=='\r') symb++;
					    	if (filecontent.charAt(symb)==',' || filecontent.charAt(symb)=='\n' || filecontent.charAt(symb)==-1) {symb++; j++;}
					    }
					}
					if (flag==1) {
						columnnames = new String[5];
						columnnames[0] = "ФИО";
						columnnames[1] = "Должность"; 
						columnnames[2] = "Оклад"; 
						columnnames[3] = "Всего рабочих дней"; 
						columnnames[4] = "Отработано дней";
					}
					else if (flag == 2) {
						columnnames = new String[12];
						columnnames[0] = "ФИО";
						columnnames[1] = "Должность"; 
						columnnames[2] = "Оклад"; 
						columnnames[3] = "Всего рабочих дней"; 
						columnnames[4] = "Отработано дней";
						columnnames[5] = "Зарплата";
						columnnames[6] = "НДФЛ";
						columnnames[7] = "ПФР";
						columnnames[8] = "ФФОМС";
						columnnames[9] = "ФСС";
						columnnames[10] = "ФСС (Несчастные случаи)";
						columnnames[11] = "К выплате";
						for (i=0;i<rownumber;i++) { 
							data[i][5] = String.valueOf((int)(Float.valueOf(data[i][2])*(Float.valueOf(data[i][4])/Float.valueOf(data[i][3]))));
							data[i][6] = String.valueOf((int)(Float.valueOf(data[i][5])*0.13));
							data[i][7] = String.valueOf((int)(Float.valueOf(data[i][5])*0.22));
							data[i][8] = String.valueOf((int)(Float.valueOf(data[i][5])*0.051));
							data[i][9] = String.valueOf((int)(Float.valueOf(data[i][5])*0.029));
							data[i][10] = String.valueOf((int)(Float.valueOf(data[i][5])*0.002));
							data[i][11] = String.valueOf((int)(Float.valueOf(data[i][5])-Float.valueOf(data[i][6])));
						}
					}
					table.setModel(new DefaultTableModel(data,columnnames));
		        }
			}
		};
		JButton buttonDownload = GenerateItems.CreateButton(DownloadButListener, panelDownload, "Download", 68, 103, 260, 23);		
		ActionListener ExitButListener = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AuthForm fr = new AuthForm();
				fr.setVisible(true);	
				dispose();
			}
		};
		JButton buttonExit = GenerateItems.CreateButton(ExitButListener, contentPane, "Exit", 172, 261, 89, 23);		
	}

	void SaveFile(JTable table, int columnnum, String columnnames){
		int i,j;
		String writtext;
		writtext = columnnames + "\r\n";
		for (i=0;i<rownumber;i++) {
			for (j=0;j<columnnum;j++) {
				if (j!=columnnum-1) { writtext = writtext + String.valueOf(table.getValueAt(i, j)) + ","; }
				else { writtext = writtext + String.valueOf(table.getValueAt(i, j)) + "\r\n"; }
			}
		}
		FileWorker.write(path, writtext);
		JOptionPane.showMessageDialog(null, "Успешно сохранено", "Сохранение", JOptionPane.INFORMATION_MESSAGE);
	}
}