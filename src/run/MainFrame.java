package run;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class MainFrame extends JFrame implements MouseListener {
	//���ô���Ļ�������	��С
	/**
	 *  1�����ô���������Դ�С ���� �߿����� Ĭ�Ϲرհ�ť logoͼ��
		2�������������MainPanel��ʵ�ֱ���ͼƬ����
		
		ͼƬ��ť����
	 */
	//������ʼ��ť ������ť �뿪��ť ���
	JLabel start,help,exit;
	
	JPanel MainPanel;
	
	public MainFrame() {//�޲ι��죬�������󡣲���main�����е���
		//start��ť������
		start = new JLabel(new ImageIcon("Image/hh1.png"));//ImageIcon:��ʼ��Ϸͼ��
		start.setBounds(175,600,150,40);//ͼ������ꡢ��ȡ��߶�
		start.setEnabled(false);//false��ťΪ��ɫ		
		start.addMouseListener(this);//������
		this.add(start);
		//help��ť������
		help = new JLabel(new ImageIcon("Image/hh2.png"));//ImageIcon:����ͼ��
		help.setBounds(525,600,150,40);//ͼ������ꡢ��ȡ��߶�
		help.setEnabled(false);//false��ťΪ��ɫ
		help.addMouseListener(this);//������
		this.add(help);
		//help��ť������
		exit = new JLabel(new ImageIcon("Image/hh3.png"));//ImageIcon:�˳�ͼ��
		exit.setBounds(875, 600, 150, 40);//ͼ������ꡢ��ȡ��߶�
		exit.setEnabled(false);//false��ťΪ��ɫ
		exit.addMouseListener(this);//������
		this.add(exit);
			
		
		/**1.ʵ�ֱ���ͼƬ����������*/
		MainPanel panel = new MainPanel();
		this.add(panel);
		
		//���ô���������Դ�С ���� �߿����� Ĭ�Ϲرհ�ť logoͼ��
		this.setSize(1200,730);//��С
		this.setLocationRelativeTo(null);//����
		this.setUndecorated(true);//�߿�����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Ĭ�Ϲر�
		this.setIconImage(new ImageIcon("Image/115.png").getImage());//logoͼ��
		this.setVisible(true);			
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
	
	//2�������������MainPanel��ʵ�ֱ���ͼƬ����
	class MainPanel extends JPanel{//������MainPanel�࣬��MainFrame�е���
	Image background;		
	public MainPanel() {
		try {
			background = ImageIO.read(new File("Image/main.png"));//���������汳��ͼƬ
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override//��дpaint����
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(background, 0, 0,1200,730, null);//����ͼƬ�����ꡢ��ȡ��߶�
		}
	}
	
	

//�������������Ϊ��� implements MouseListener �󣬿�ݳ�����
	@Override
	public void mouseClicked(MouseEvent e) {
		//���������
		if(e.getSource().equals(start)){
			//�رյ�ǰ����
			dispose();
			//��ת����һ����
			new WindowFrame().Start();

		}else if(e.getSource().equals(exit)){
			/*JOptionPane.showMessageDialog(,);���õ���
			��һ��������parentComponent -ȷ��Frame��������ʾ�ĶԻ���; ���null ���������parentComponentû��Frame ����ʹ��Ĭ��ֵFrame��������ʹ�õ���null
			�ڶ�������message - Ҫ��ʾ�� Object ��message��������Ҫ����ʾ������ʾ����Ϣ����ʹ�õ����ַ���
			*/
			JOptionPane.showMessageDialog(null, "��ӭ�´ε�½���ټ�");
			System.exit(0);
		}else if(e.getSource().equals(help)){
			JOptionPane.showMessageDialog(null, "����������ϵ�������ǣ�Τ���� ��ʫȻ ��Ң�� ���� κ����");
		}
		
	}




	@Override//��д���û�������갴ťʱ�����ķ���
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override//��д���û��ɿ���갴ťʱ�����ķ���.
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override//��д������뿪��ǰ����������������������ʱ�����¼��ķ���.
	public void mouseEntered(MouseEvent e) {
		// �������
		if(e.getSource().equals(start)){//eָһ���¼���e.getSource()��ȡ�¼�
			//���������뵽��start�������ͼƬ��ť��
			start.setEnabled(true);
		}else if(e.getSource().equals(help)){
			help.setEnabled(true);
		}else if(e.getSource().equals(exit)){
			exit.setEnabled(true);
		}
	}




	@Override//��д������뿪�������������ʱ�����ķ���.
	public void mouseExited(MouseEvent e) {
		//����Ƴ�
			if(e.getSource().equals(start)){
				start.setEnabled(false);
		}else if(e.getSource().equals(help)){
			help.setEnabled(false);
		}else if(e.getSource().equals(exit)){
			exit.setEnabled(false);
		}
	}
}


