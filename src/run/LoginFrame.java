package run;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginFrame extends JFrame{
	JLabel userLabel;
	JTextField userField;
	JLabel userLabel2;
	JPasswordField userField2;
	JButton Login,Cancel;

	public LoginFrame() {
		userLabel = new JLabel("�û���");	
		userLabel.setFont(new Font("΢���ź�",Font.BOLD,18));				
		userLabel2 = new JLabel("��  ��");
		userLabel2.setFont(new Font("΢���ź�",Font.BOLD,18));
			
		userLabel.setBounds(20, 220, 100, 30);
		this.add(userLabel);
		userLabel2.setBounds(20, 280, 100, 30);
		this.add(userLabel2);

		userField = new JTextField();
		userField.setBounds(80, 220, 100, 30);
		userField.setBorder(BorderFactory.createLoweredBevelBorder());
		userField.setOpaque(false);
		this.add(userField);
		
		userField2 = new JPasswordField();
		userField2.setBounds(80, 280, 100, 30);
		userField2.setBorder(BorderFactory.createLoweredBevelBorder());
		userField2.setOpaque(false);
		this.add(userField2);
		
		
		Login = new JButton("��¼");
		Login.setBounds(45,350,60,36);
		Login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String userName = userField.getText();
				String passWord = userField2.getText();
				if("123".equals(userName) && "123".equals(passWord)){
					JOptionPane.showMessageDialog(null, "��ӭ"+userName+"�������������Ϸ");
					new MainFrame();
					dispose();
				}else if("".equals(userName) || "".equals(passWord)){
					JOptionPane.showMessageDialog(null, "�û��� / ���벻��Ϊ�գ����������룡");
				}else{
					JOptionPane.showMessageDialog(null, "�û��� / ��������������������룡");
				}
				
			}
		});
		this.add(Login);
		
		Cancel = new JButton("ȡ��"); 
		Cancel.setBounds(135,350,60,36);
		this.add(Cancel);
		Cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		

		LoginPanel panel = new LoginPanel();
		this.add(panel);	
		
		this.setSize(900,530);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		
		this.setIconImage(new ImageIcon("Image/115.png").getImage());
		this.setVisible(true);
	}
	
	
	

	public static void main(String[] args) {
		new LoginFrame();
	}
	
	class LoginPanel extends JPanel{
		Image background;
		public LoginPanel() {
			try {
				background = ImageIO.read(new File("Image/login.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(background, 0, 0,900,530, null);//900,530Ϊ���
		}
	}
}