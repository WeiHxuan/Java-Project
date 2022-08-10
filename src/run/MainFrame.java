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
	//设置窗体的基本属性	大小
	/**
	 *  1、设置窗体基本属性大小 居中 边框隐藏 默认关闭按钮 logo图标
		2、创建背景面板MainPanel，实现背景图片功能
		
		图片按钮功能
	 */
	//创建开始按钮 帮助按钮 离开按钮 组件
	JLabel start,help,exit;
	
	JPanel MainPanel;
	
	public MainFrame() {//无参构造，创建对象。并在main函数中调用
		//start按钮的设置
		start = new JLabel(new ImageIcon("Image/hh1.png"));//ImageIcon:开始游戏图标
		start.setBounds(175,600,150,40);//图标的坐标、宽度、高度
		start.setEnabled(false);//false按钮为灰色		
		start.addMouseListener(this);//鼠标监听
		this.add(start);
		//help按钮的设置
		help = new JLabel(new ImageIcon("Image/hh2.png"));//ImageIcon:帮助图标
		help.setBounds(525,600,150,40);//图标的坐标、宽度、高度
		help.setEnabled(false);//false按钮为灰色
		help.addMouseListener(this);//鼠标监听
		this.add(help);
		//help按钮的设置
		exit = new JLabel(new ImageIcon("Image/hh3.png"));//ImageIcon:退出图标
		exit.setBounds(875, 600, 150, 40);//图标的坐标、宽度、高度
		exit.setEnabled(false);//false按钮为灰色
		exit.addMouseListener(this);//鼠标监听
		this.add(exit);
			
		
		/**1.实现背景图片及窗体属性*/
		MainPanel panel = new MainPanel();
		this.add(panel);
		
		//设置窗体基本属性大小 居中 边框隐藏 默认关闭按钮 logo图标
		this.setSize(1200,730);//大小
		this.setLocationRelativeTo(null);//居中
		this.setUndecorated(true);//边框隐藏
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//默认关闭
		this.setIconImage(new ImageIcon("Image/115.png").getImage());//logo图像
		this.setVisible(true);			
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
	
	//2、创建背景面板MainPanel，实现背景图片功能
	class MainPanel extends JPanel{//创建的MainPanel类，在MainFrame中调用
	Image background;		
	public MainPanel() {
		try {
			background = ImageIO.read(new File("Image/main.png"));//插入主界面背景图片
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override//重写paint方法
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(background, 0, 0,1200,730, null);//背景图片的坐标、宽度、高度
		}
	}
	
	

//以下五个方法均为添加 implements MouseListener 后，快捷出来的
	@Override
	public void mouseClicked(MouseEvent e) {
		//鼠标点击监听
		if(e.getSource().equals(start)){
			//关闭当前界面
			dispose();
			//跳转到下一界面
			new WindowFrame().Start();

		}else if(e.getSource().equals(exit)){
			/*JOptionPane.showMessageDialog(,);设置弹窗
			第一个参数是parentComponent -确定Frame在其中显示的对话框; 如果null ，或者如果parentComponent没有Frame ，则使用默认值Frame，这里我使用的是null
			第二个参数message - 要显示的 Object ，message就是我们要在提示框里显示的信息，我使用的是字符串
			*/
			JOptionPane.showMessageDialog(null, "欢迎下次登陆，再见");
			System.exit(0);
		}else if(e.getSource().equals(help)){
			JOptionPane.showMessageDialog(null, "有疑问请联系开发者们：韦洪炫 林诗然 张尧宁 蒋俐 魏兴普");
		}
		
	}




	@Override//重写当用户按下鼠标按钮时发生的方法
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override//重写当用户松开鼠标按钮时发生的方法.
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override//重写当鼠标离开当前组件并进入你所监听的组件时激活事件的方法.
	public void mouseEntered(MouseEvent e) {
		// 鼠标移入
		if(e.getSource().equals(start)){//e指一个事件。e.getSource()获取事件
			//如果鼠标移入到（start）组件（图片按钮）
			start.setEnabled(true);
		}else if(e.getSource().equals(help)){
			help.setEnabled(true);
		}else if(e.getSource().equals(exit)){
			exit.setEnabled(true);
		}
	}




	@Override//重写当鼠标离开你所监听的组件时发生的方法.
	public void mouseExited(MouseEvent e) {
		//鼠标移出
			if(e.getSource().equals(start)){
				start.setEnabled(false);
		}else if(e.getSource().equals(help)){
			help.setEnabled(false);
		}else if(e.getSource().equals(exit)){
			exit.setEnabled(false);
		}
	}
}


