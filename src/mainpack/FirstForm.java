package mainpack;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

class FirstForm extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int rowcolnum[];
	private String path;
	private String filecont[][];
	private String data[][];
	private String columnnames[];	
	public FirstForm(int flag) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String itemnames[] = GenerateItems.GenerateItemNames();
		JPanel panelWork = GenerateItems.CreatePanel(contentPane, 10, 11, 414, 239, false);		
		JPanel panelDownload = GenerateItems.CreatePanel(contentPane, 10, 11, 414, 239, true);		
		JTable table = new JTable();		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 394, 183);
		panelWork.add(scrollPane);		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		table.setBounds(10, 191, 394, -179);		
		ActionListener CloseButListener = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelWork.setVisible(false);
				panelDownload.setVisible(true);
				data = new String[0][0];
				columnnames = new String[0];
				table.setModel(new DefaultTableModel(data,columnnames));
				path = null;
			}
		};
		JButton buttonClose =  GenerateItems.CreateButton(CloseButListener, panelWork, itemnames[2], 10, 205, 89, 23);		
		ActionListener SaveButListener = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = ""; 
				int i,j;
				for (i=0;i<rowcolnum[1];i++) 
				{ 
					if (i!=rowcolnum[1]-1) { str = str + columnnames[i] + ","; } 
						 else { str = str + columnnames[i]; }
				}
				str = str + System.getProperty("line.separator");
				for (i=0;i<rowcolnum[0]-1;i++) {
					for (j=0;j<rowcolnum[1];j++) {
						if (j!=rowcolnum[1]-1) { str = str + String.valueOf(table.getValueAt(i, j)) + ","; }
						else { str = str + String.valueOf(table.getValueAt(i, j)) + System.getProperty("line.separator"); }
					}
				}
				FileWorker.write(path, str);
				JOptionPane.showMessageDialog(null, itemnames[9], itemnames[11], JOptionPane.INFORMATION_MESSAGE);
			}
		};
		JButton buttonSave = GenerateItems.CreateButton(SaveButListener, panelWork, itemnames[3], 289, 205, 115, 23);		
		ActionListener DownloadButListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDownload.setVisible(false);
				panelWork.setVisible(true);
				JFileChooser fileopen = new JFileChooser();				
		        int ret = fileopen.showDialog(null, itemnames[10]);                
		        if (ret == JFileChooser.APPROVE_OPTION) {
					File file = fileopen.getSelectedFile();
					path = file.getPath();
					rowcolnum = FileWorker.count(path);
					filecont = FileWorker.read(path, rowcolnum[0], rowcolnum[1]);
					columnnames = new String[rowcolnum[1]];
					data = new String[rowcolnum[0]-1][rowcolnum[1]];
					int i,j;
					for (j=0;j<rowcolnum[1];j++) columnnames[j]=filecont[0][j];
					for (i=0;i<rowcolnum[0]-1;i++)
					{
						for (j=0;j<rowcolnum[1];j++)
						{
							data[i][j] = filecont[i+1][j];
						}
					}
					if (flag == 2) {
						table.setEnabled(false);
						for (i=0;i<rowcolnum[0]-1;i++) { 
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
		JButton buttonDownload = GenerateItems.CreateButton(DownloadButListener, panelDownload, itemnames[4], 68, 103, 260, 23);		
		ActionListener ExitButListener = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AuthForm fr = new AuthForm();
				fr.setVisible(true);	
				dispose();
			}
		};
		JButton buttonExit = GenerateItems.CreateButton(ExitButListener, contentPane, itemnames[1], 172, 261, 89, 23);		
	}
}