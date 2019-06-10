

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.PrintJob;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class z2 extends JFrame implements ActionListener{
	LinkedList list = null;
	public JFrame f;
	PrintJob p = null;
	Graphics g = null;
	public Container con;
	Object position[]= {"经理","技术员","销售员","销售经理"};
	
	JComboBox combobox_position = new JComboBox(position);
	Object sex[]= {"男","女"};
	
	JComboBox combobox_sex = new JComboBox(sex);
	JLabel L1 = new JLabel("ID:",JLabel.CENTER),
	L2 = new JLabel("姓   名：",JLabel.CENTER),
	L3 = new JLabel("岗  位：",JLabel.CENTER),
	L4 = new JLabel("性  别：",JLabel.CENTER),
	L5 = new JLabel("年  龄：",JLabel.CENTER),
	L6 = new JLabel("销售额 ：",JLabel.CENTER),
	L7 = new JLabel("工作时间：",JLabel.CENTER),
	L8 = new JLabel("总工资：",JLabel.CENTER);
	JTextField T1 =  new JTextField("编号"),
	T2 = new JTextField("姓名"),
	T3 = new JTextField(),
	T4 = new JTextField(),
	T5 = new JTextField("0"),
	T6 = new JTextField("0"),
	T7 = new JTextField("0"),		
	T8 = new JTextField("0");
	JLabel L9 = new JLabel("职工工资管理系统",JLabel.CENTER);
	JTextArea showT = new JTextArea(12,33);
	JButton b_add = new JButton("添加");
	JButton b_move = new JButton("删除");
	JButton b_modify = new JButton("修改");
	JButton b_xun = new JButton("查询");
	JButton b_back = new JButton("退出");
	JButton b_writer = new JButton("关于");
	
   
	public z2(){
		
		super("职工工资管理窗口");

		list = new LinkedList();
		con=getContentPane();
		JScrollPane pane = new JScrollPane(showT);
		showT.setEditable(false);
		T8.setEditable(false);
		JPanel save = new JPanel(),
				p2 = new JPanel(),
				p3 = new JPanel(),
				p4 = new JPanel(),
				p5 = new JPanel(),
				p6 = new JPanel();
		save.setLayout(new GridLayout(4,5));
		save.add(L1);
		save.add(T1);
		save.add(L2);
		save.add(T2);
		save.add(L3);
		save.add(combobox_position);
		save.add(L4);
		save.add(combobox_sex);
		save.add(L5);
		save.add(T5);
		save.add(L6);
		save.add(T6);
		save.add(L7);
		save.add(T7);
		save.add(L8);
		save.add(T8);
		save.add(L9);
		p6.add(L9);
		p2.setLayout(new GridLayout(2,2));
		p3.setLayout(new GridLayout(2,2));
		p4.setLayout(new GridLayout(8,1));
		p4.add(b_add);
		p4.add(b_move);
		p4.add(b_xun);
		p4.add(b_modify);
		p4.add(b_back);
		p4.add(b_writer);
		p5.add(pane);
		JSplitPane split_one,split_two,split_three,split_four;
		split_one = new JSplitPane(JSplitPane.VERTICAL_SPLIT,p6,p4);
		split_two = new JSplitPane(JSplitPane.VERTICAL_SPLIT,p4,save);
		split_three = new JSplitPane(JSplitPane.VERTICAL_SPLIT,save,p3);
		split_four = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,split_three,p5);
		con.add(split_one, BorderLayout.NORTH);
		con.add(split_two, BorderLayout.CENTER);
		con.add(split_three, BorderLayout.SOUTH);
		con.add(split_four, BorderLayout.EAST);
		b_add.addActionListener(this);
		b_xun.addActionListener(this);
		b_move.addActionListener(this);
		b_modify.addActionListener(this);
		b_back.addActionListener(this);
		b_writer.addActionListener(this);
		
		
		
        
        
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == b_writer) {
			JOptionPane.showMessageDialog(null,
					"系统名称：工资管理系统"+
							"\n"+"系统简介"+"\n"+"略");
		}
		if(e.getSource() == b_add) {
			String ss1,ss2,ss3,ss4 = null;
			ss1 = T1.getText();
			ss2 = T2.getText();
			ss3 = T3.getText();
			ss4 = T4.getText();
			String s1= T5.getText();
			int s2= Integer.parseInt(T6.getText());
			int s3= Integer.parseInt(T7.getText());
			int s4= Integer.parseInt(T8.getText());
			if(combobox_position.getSelectedItem().equals("经理")) {
			s4 += s2*100+s3*10;
			}else if(combobox_position.getSelectedItem().equals("技术员")){
			s4 += s2*50+s3*5;
			}else if(combobox_position.getSelectedItem().equals("销售经理")) {
			s4 += s2*150+s3*5;
			}

			Wage cus = new Wage(ss1,ss2,ss3,ss4,s1,
				s2,s3,s4+5000);
			if(cus.s1.equals("编号")) {
				JOptionPane.showMessageDialog(null, "请输入职工信息！！！");				
			}else {
				try {
					FileInputStream come_in11 = new FileInputStream("zhigong1.txt");
					ObjectInputStream in11 = new ObjectInputStream(come_in11);
					list=(LinkedList)in11.readObject();
					in11.close();
				}catch(ClassNotFoundException event) {
					
				}catch(IOException event) {}
					boolean b =true;
					int number11 = list.size();
					P:for(int i = 0; i<number11; i++) {
						Wage cus_1=(Wage)list.get(i);
						if(cus_1.s1.equals(ss1)) {
							b=false;
							break P;
						}
					}
					if(b == false) {
						JOptionPane.showMessageDialog(null,"此id存在请认真核对");
						
					}else {
						list.add(cus);
						JOptionPane.showMessageDialog(null, "此员工信息已经录入");
						try {
							FileOutputStream file1 = new FileOutputStream("zhigong1.txt");
							ObjectOutputStream out1 = new ObjectOutputStream(file1);
							out1.writeObject(list);
							out1.close();
						}catch(IOException event) {}
								
					}
			}
			T1.setText("编号");
			T2.setText("姓名");
			T3.setText("");
			T4.setText("");
			T5.setText("0");
			T6.setText("0");
			T7.setText("0");
			
		}
		if(e.getSource() == b_move) {
			showT.setText(null);
			String ss10 = JOptionPane.showInputDialog(z2.this,
					"输入您需要删除职工信息的ID");
			try {
				FileInputStream come_in22 = new FileInputStream("zhigong1.txt");
				ObjectInputStream in22 = new ObjectInputStream(come_in22);
				list = (LinkedList)in22.readObject();
				boolean b2 = true;
				int a2 = 0;
				int number2 = list.size();
				P:for(int i=0;i<number2;i++) {
					Wage cus_2=(Wage)list.get(i);
					if(cus_2.s1.equals(ss10)) {
						a2=i;
						list.remove(a2);
						JOptionPane.showMessageDialog(null,"此职工工资信息已经删除!!!");
						in22.close();
						FileOutputStream file1 = new FileOutputStream("zhigong1.txt");
						ObjectOutputStream out1 = new ObjectOutputStream(file1);
						out1.writeObject(list);
						out1.close();
						b2=false;
						break P;
					}
				}
				if(b2 == true) {
					JOptionPane.showMessageDialog(null,
							"没有此职工编号为"+ss10+"的工资信息!!!");
					in22.close();
				}
			}
			catch(Exception e1) {
				
			}}
			else if(e.getSource() == b_modify) {
				showT.setText(null);
				String ss10 = JOptionPane.showInputDialog(z2.this,"请输入您要修改的职工信息ID");
				try {
					FileInputStream come_in=new FileInputStream("zhigong1.txt");
					ObjectInputStream in = new ObjectInputStream(come_in);
					list=(LinkedList)in.readObject();
					in.close();
				}catch(ClassNotFoundException event) {
					
				}catch(IOException event) {}
					boolean b4 =true;
					int number4 = list.size();
					P:for(int i = 0; i<number4; i++) {
						Wage cus_4=(Wage)list.get(i);
						if(cus_4.s1.equals(ss10)) {
							b4=false;
							break P;
						}
					}
					if(b4 == true) {
						JOptionPane.showMessageDialog(null,"没有此职工编号为"+ss10+"的工资");
					}else {
					}
					
			}
		if(e.getSource() == b_xun) {
			showT.setText(null);
			String ss10 = JOptionPane.showInputDialog(z2.this,"请输入您要查询的职工信息ID");
			try {
				FileInputStream come_in42 = new FileInputStream("zhigong1.txt");
				ObjectInputStream in42 = new ObjectInputStream(come_in42);
				list=(LinkedList)in42.readObject();
				in42.close();
			}catch(ClassNotFoundException event) {
				
			}catch(IOException event) {}
				boolean b4 = true;
				int a4 = 0;
				int number4 = list.size();
				P:for(int i = 0; i<number4; i++) {
					Wage cus_4=(Wage)list.get(i);
					if(cus_4.s1.equals(ss10)) {
						a4=i;
						b4=false;
						break P;
					}
				
				}
				if(b4 == true) {
					JOptionPane.showMessageDialog(null,"没有此职工编号为"+ss10+"的工资");
				
				}else {
					Wage cha=(Wage)list.get(a4);
					showT.append("\t职工工资条");
					showT.append("\n");
					showT.append("ID:"+cha.s1);
					showT.append("\t姓	名"+cha.s2);
					showT.append("\n");
					showT.append("岗位:"+combobox_position.getSelectedItem());
					showT.append("\t性别:"+combobox_sex.getSelectedItem());
					showT.append("\n");
					showT.append("年龄:"+cha.s5);
					showT.append("\t销售额"+cha.s6);
					showT.append("\n");
					showT.append("工作时间"+cha.s7);
					showT.append("\t总工资:"+cha.s8);
					
					
				}
				
		}
		else if(e.getSource() == b_back) {
			 int result = JOptionPane.showConfirmDialog(this,
			            "您确定要退出程序吗", "退出",
			            JOptionPane.YES_NO_OPTION);
			        if (result == JOptionPane.YES_OPTION)
			          System.exit(1);
			        else if (result == JOptionPane.NO_OPTION)
			        	this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			      }
			
		}
}