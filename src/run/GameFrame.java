package src.run;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import src.run.GamePanel;

/**
 * 
 * ��Ϸ�����棺��ʾ���壬������Ϸ���������
 */

public class GameFrame extends JFrame {
	//���ô���������
	public static final int WIDTH=1500;
	public static final int HEIGHT=900;
	public GameFrame() {
		//2.4������Ϸ�����󣬲���ӵ�������ȥ
		GamePanel panel = new GamePanel();
		panel.action();//���������ķ���
		this.addKeyListener(panel);//˭ʵ�־ͼ���˭
		this.add(panel);
		
		/**1.���ô����������*/
		this.setSize(WIDTH,HEIGHT);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon("Image/115.png").getImage());
		this.setUndecorated(true);
		this.setVisible(true);	
		
		while(true){
			if(panel.isGameOver){//��ΪisGameOver֮ǰ��static����,���Ա���
				dispose();//�رմ���
				}
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
	}
	public static void main(String[] args) {
		new GameFrame();
	}
}
