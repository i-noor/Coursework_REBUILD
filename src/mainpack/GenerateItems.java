package mainpack;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

class GenerateItems {
	public static JTextField CreateTField(JPanel pane, String text ,int x,int y,int wid,int hei) {
		JTextField tfield = new JTextField(text);
		tfield.setBounds(x, y, wid, hei);
		pane.add(tfield);
		tfield.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		tfield.setColumns(10);
		return tfield;
	}
	public static JLabel CreateLabel(JPanel pane, String text ,int x,int y,int wid,int hei) {
		JLabel label = new JLabel(text);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(x, y, wid, hei);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pane.add(label);
		return label;
	}
	public static JButton CreateButton(ActionListener listener, JPanel pane, String text,int x,int y,int wid,int hei){
		JButton button = new JButton(text);
		button.addActionListener(listener);
		button.setBounds(x, y, wid, hei);
		pane.add(button);
		return button;
	}
	public static JPanel CreatePanel(JPanel contentPane, int x,int y,int wid,int hei, boolean flag){
		JPanel panel = new JPanel();
		panel.setBounds(x, y, wid, hei);
		panel.setLayout(null);
		panel.setVisible(flag);
		contentPane.add(panel);
		return panel;
	}
	public static String[] GenerateItemNames(){
		String itemnames[];
		String path;
		File file = new File("./itemnames.txt");
		path = file.getPath();
		int rowcolnum[] = FileWorker.count(path);
		String str[][] = FileWorker.read(path, rowcolnum[0], rowcolnum[1]);
		itemnames = new String[rowcolnum[0]];
		int i;
		for (i=0;i<rowcolnum[0];i++)
		{
			itemnames[i]="";
			itemnames[i]=str[i][0];
		}
		return itemnames;
	}
}