import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Worker extends JFrame{
	public JFrame frame;
	public Container c;
	public Worker(){
		frame = new JFrame("职工工资管理系统");
		c = frame.getContentPane();
		c.setLayout(null);
		frame.setResizable(false);
		JLabel information0= new JLabel("欢迎进入职工工资管理系统",
				JLabel.CENTER);
		information0.setFont(new Font("宋体",Font.BOLD,25));
		information0.setSize(350,50);
		information0.setLocation(0,0);
		c.add(information0);
		
		JLabel yonghuL=new JLabel("用户名:",JLabel.CENTER);
		yonghuL.setFont(new Font("宋体",Font.BOLD,18));
		yonghuL.setSize(80,30);
		yonghuL.setLocation(60,70);
		c.add(yonghuL);
		final TextField yonghuT = new TextField();
		yonghuT.setSize(90,25);
		yonghuT.setLocation(170,70);
		c.add(yonghuT);
		JLabel koulingL= new JLabel("口令：",JLabel.CENTER);
		koulingL.setFont(new Font("宋体",Font.BOLD,18));
		koulingL.setSize(80,30);
		koulingL.setLocation(60,110);
		c.add(koulingL);
		
		final TextField koulingT = new TextField();
		koulingT.setEchoChar('*');
		koulingT.setSize(90,25);
		koulingT.setLocation(170,110);
		c.add(koulingT);
		
		
		JButton registerButton = new JButton("登录");
		registerButton.addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String a,b;
						a=yonghuT.getText();
						b=koulingT.getText();
						if(a.equals("stysr")==true&&b.equals("123456")==true){
							z2 win = new z2();
							win.setSize(500,400);
							win.setVisible(true);
							win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							win.setResizable(false);
							win.setLocation(100,100);
							
						}else {
							JOptionPane.showMessageDialog(null,
									"对不起,你输入的信息有误!");
						}
					}});
		registerButton.setLocation(40,150);
		registerButton.setSize(80,30);
		registerButton.setFont(new Font("宋体",Font.BOLD,18));
		c.add(registerButton,BorderLayout.CENTER);
		
		JButton backButton = new JButton("退出");
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
			
		});
		backButton.setLocation(190,150);
		backButton.setSize(80,30);
		backButton.setFont(new Font("宋体",Font.BOLD,18));
		c.add(backButton,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350, 300);
		frame.setLocation(100, 100);
		frame.setVisible(true);
		
				
						
	}

	public static void main(String[] args) {
		new Worker();

	}

}