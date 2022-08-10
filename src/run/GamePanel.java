package run;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import run.DBUtils;
import run.Barrs_1;
import run.Barrs_2;
import run.Barrs_3;
import run.Barrs_4;
import run.Barrs_5;
import run.Person;
import run.EndFrame;
import run.GameFrame;

/**
 *
 * ��Ϸ������࣬�����߼���
 *           1������ͼƬ����Ч��
 *           2����Ҷ�̬Ч��
 *           3�������ϰ���ĳ���
 *           4����Һ��ϰ������ײ�߼�
 *           5����ͣ�������߼�
 *           6�������߼�
 */
/*implements����ʵ�ֶ���ӿڣ��ö��ŷֿ�������
	����:class A extends B implements C,D,E*/
public class GamePanel extends JPanel implements KeyListener{
	/**2�����ɶ�̬�ı���ͼƬ***/
	//2.1��������ͼƬ����
	Image background;
	//����һ������͸��ɫ��BufferedImage����
	BufferedImage score;//�÷ֱ���
	Image pause;//��ͣ
	Image  proceed;//��Ծ
	
	
	/***3.ʵ����ҵĶ�̬Ч�����ƶ�����***/
	//������Ҷ������ʵ������
	Person person;//����
	Barrs_2 barrs_2;//����
	Barrs_4 barrs_4;//�㹳���ϰ���
	Barrs_5 barrs_5;//���
	/**4.ʵ���ϰ���*/
	Barrs_1[]barrs1 = {};//�洢�з���飨û��Ԫ�أ��������ݣ�
	Barrs_3[]barrs3 ={};//����
	Barrs_4[]barrs4={};//�㹳
	Barrs_5[]barrs5 = {};//���
	
	public GamePanel() {
		person = new Person();//����Person��Ĺ��췽�����������󲢸�ֵ
		barrs_2 = new Barrs_2();//����Barrs_2��Ĺ��췽�����������󲢸�ֵ
		//��ȡͼƬ�ļ�
		try{
			//���ض��ļ�����
			background =ImageIO.read(new File("Image/cc.png"));//�ܿᱳ��
			score =ImageIO.read(new File("Image/a12.png"));//�÷ֱ���
			pause = ImageIO.read(new File("Image/b2.png"));//��ͣͼ��
			proceed = ImageIO.read(new File("Image/b1.png"));//��Ծͼ��
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	int x=0;//����ͼƬ��ʼλ��

public void paint(Graphics g) { 
	super.paint(g);
	if(flag){
		x-=20;//ͼƬ�������ٶ�
	}
		//���Ʊ���ͼƬ(��̬�л�������)
		g.drawImage(background, x, 0, GameFrame.WIDTH, GameFrame.HEIGHT, null);
		g.drawImage(background, x+GameFrame.WIDTH, 0, GameFrame.WIDTH, GameFrame.HEIGHT,null);
		if(x<=-GameFrame.WIDTH){//ʵ������ͼƬ֮����л�
			x = 0;
		}
	
	//���� ���
	person.paintPerson(g);
	//�����з
	for(int i =0;i<barrs1.length;i++){
		barrs1[i].paintBarrs(g);
	}
	//���Ƴ���
	barrs_2.paintBarrs(g);
	//���Ƶ���
	for(int i =0;i<barrs3.length;i++){
		barrs3[i].paintBarrs(g);
	}
	//��������㹳�ϰ���
	for(int i =0;i<barrs4.length;i++){
		barrs4[i].paintBarrs(g);
	}
	//������ƽ��
	for(int i = 0;i<barrs5.length;i++){
		barrs5[i].paintBarrs(g);
	}
	
	
	//λ��Խ���£�ͼ��Խ����
	//������ҷ���
	g.drawImage(score, 120, 50,null);//ͼƬ����
	g.setColor(Color.ORANGE);//�÷�������ɫ
	//���������ʾЧ�� Font mf = new Font(String ���壬int ���int �ֺ�);
	g.setFont(new Font("����",Font.BOLD,30 ));
	g.drawString("��ҵ÷֣�"+person.getScore()+"��", 133, 95);//��ʾ���ּ���λ��
	
	//������ͣ����Ծ��ʶͼƬ
	if(flag){
		//drawImage(Image ͼƬ,int x,int y,int ͼƬ���,int ͼƬ�߶�,ImageObserver ��ת���˸���ͼ��ʱҪ֪ͨ�Ķ���)
					g.drawImage(proceed, 200, 800, 90,90,null);//��Ծ
	}else{
				g.drawImage(pause, 200, 800, 90, 90, null);//��ͣ
	}
	
}

//��		��	��	��	��	��	��	��
int index =0;
public void enteredAction(){//ʵ��ԴԴ���������ϰ����Ч��
	index++;
	//ÿ��index�ƶ�100����һ��ͬ�����͵��ϰ���
	if(index%100==0){
		Barrs_1 b1 = new Barrs_1();//�����з
		Barrs_3 b3 = new Barrs_3();//���ɵ���
		Barrs_4 b4 = new Barrs_4();//��������ϰ���
		
		barrs1 =Arrays.copyOf(barrs1,barrs1.length+1);//��������+1
		barrs1[barrs1.length-1]= b1;//�ŵ��������һ��Ԫ�ص�λ��
		//System.out.println("����"+barrs1.length);		
		barrs3 =Arrays.copyOf(barrs3,barrs3.length+1);
		barrs3[barrs3.length-1]= b3;
		barrs4 =Arrays.copyOf(barrs4,barrs4.length+1);
		barrs4[barrs4.length-1]= b4;
	}
	//ÿ��index�ƶ�15����һ�����
	if(index%15==0){
		Barrs_5 b5 = new Barrs_5();
		barrs5 = Arrays.copyOf(barrs5, barrs5.length +1);
		barrs5[barrs5.length-1] = b5;
	}
}


//��		��	��	��
public void stepAction(){
		person.step();//�л���ҵ�ͼƬ��>������
		person.drop();//���ﲻ����׹
		barrs_2.drop();//���ﲻ����׹
		
	for(int i =0;i<barrs1.length;i++){
		//�з�ϰ����ƶ�
		barrs1[i].step();
		//�жϵ�ǰ�ϰ����Ƿ�Խ�磬����Խ�紦��
		if(barrs1[i].outofBounds()){
			//ɾ��Խ����з�ϰ���
			barrs1[i] = barrs1[barrs1.length - 1];//���з�������һ��Ԫ�أ�����Խ����з�������ˣ��൱�ڼ��ɾ���ˡ�
			barrs1= Arrays.copyOf(barrs1, barrs1.length - 1);//��������
		}
	}
	
	barrs_2.step();//�����ƶ�
	
	for(int i =0;i<barrs3.length;i++){
		//�����ϰ�����ƶ�
		barrs3[i].step();
		//�жϵ�ǰ�ϰ����Ƿ�Խ�磬����Խ�紦��
		if(barrs3[i].outofBounds()){
			//ɾ��Խ��ĵ����ϰ���
			barrs3[i] = barrs3[barrs3.length - 1];//�������������һ��Ԫ�أ�����Խ��ĵ����������ˣ��൱�ڼ��ɾ���ˡ�
			barrs3 = Arrays.copyOf(barrs3, barrs3.length - 1);//��������
		}
	}
	
	for(int i =0;i<barrs4.length;i++){
		//����ϰ�����ƶ�
		barrs4[i].step();
		//�жϵ�ǰ�ϰ����Ƿ�Խ�磬����Խ�紦��
		if(barrs4[i].outofBounds()){
		//ɾ��Խ�������ϰ���
		barrs4[i] = barrs4[barrs4.length - 1];//������������һ��Ԫ�أ�����Խ�����棬�����ˣ��൱�ڼ��ɾ���ˡ�
		barrs4 = Arrays.copyOf(barrs4, barrs4.length - 1);//��������
		}
	}
	for(int i = 0;i<barrs5.length;i++){
		//����ϰ�����ƶ�
		barrs5[i].step();
		//�жϵ�ǰ�ϰ����Ƿ�Խ�磬����Խ�紦��
		if(barrs5[i].outofBounds()){
			//ɾ��Խ��Ľ��
			barrs5[i] = barrs5[barrs5.length - 1];//������������һ��Ԫ�أ�����Խ�����棬�����ˣ��൱�ڼ��ɾ���ˡ�
			barrs5 = Arrays.copyOf(barrs5, barrs5.length - 1);//��������
		}
	}
}

//��Һ��ϰ�����ײ�Ĵ�����
public void pengAction(){
	//�ж�����Ƿ���з�ϰ��������ײ
	for(int i = 0;i<barrs1.length;i++){//�������Ҷ�д�ˣ������ò�����
		if(person.getX() + Person.WIDTH >= barrs1[i].getX() &&//��
		person.getX() <= barrs1[i].getX()	 + Barrs_1.WIDTH  &&//��
		person .getY() +Person.getHeight() >= barrs1[i].getY() &&//��
		person.getY()	<= barrs1[i].getY () + Barrs_1.HEIGHT){//��
			//��ײ��Ĵ����ڵ����ϰ��
			if(person.getX() + Person.WIDTH <= barrs1[i].getX() + Barrs_1.WIDTH){//��ֹ�����ұߣ���ײ����Դ����ϰ���
				//����ײ
				person.setX(barrs1[i].getX()  - Barrs_1.WIDTH);//��ײ�����ﱻ�ϰ���������
				barrs_2.setX(barrs1[i].getX()  - Barrs_1.WIDTH+210);//������������ƶ�
			}else{
				//����ײ
				person.setX(barrs1[i].getX()+ Barrs_1.WIDTH	);//��ײ�����ﱻ�ϰ���������
				barrs_2.setX(barrs1[i].getX()+ Barrs_1.WIDTH+210);//������������ƶ�
			}						
		}
	}
	//�ж�����Ƿ�͵����ϰ��������ײ
	for(int i = 0;i<barrs3.length;i++){
		if(person.getX() + Person.WIDTH >= barrs3[i].getX() &&//��
		person.getX() <= barrs3[i].getX()	 + Barrs_3.WIDTH  &&//��
		person .getY() +Person.getHeight() >= barrs3[i].getY() &&//��
		person.getY()	<= barrs3[i].getY () + Barrs_3.HEIGHT){//��
			if(person.getX() + Person.WIDTH <= barrs3[i].getX() + Barrs_3.WIDTH){//��ҵĿ�ȣ�120px���Ǳ��ϰ���С��
				//����ײ
				person.setX(barrs3[i].getX()  - Barrs_3.WIDTH);//��ײ�����ﱻ�ϰ���������
				barrs_2.setX(barrs3[i].getX()  - Barrs_3.WIDTH+210);//������������ƶ�
			}else{
				//����ײ
				person.setX(barrs3[i].getX()+ Barrs_3.WIDTH	);//��ײ�����ﱻ�ϰ���������
				barrs_2.setX(barrs3[i].getX() + Barrs_3.WIDTH+210);//������������ƶ�

			}	
		}
	}
	//�ж�����Ƿ������ϰ��������ײ
	for(int i = 0;i<=barrs4.length -1;i++){//С������Խ�磡
		if(person.getX() + Person.WIDTH >= barrs4[i].getX() &&//��
		person.getX() <= barrs4[i].getX() + Barrs_4.WIDTH &&//��
		person.getY() + Person.HEIGHT >= barrs4[i].getY() &&//��
		person.getY() <= barrs4[i].getY() + Barrs_4.HEIGHT	){//��
			if(person.getX() + Person.WIDTH <= barrs4[i].getX() + Barrs_4.WIDTH){//��ֹ�����ұߣ���ײ����Դ����ϰ���
				//����ײ
				person.setX(barrs4[i].getX() - Barrs_4.WIDTH);//��ײ�����ﱻ�ϰ���������
				barrs_2.setX(barrs4[i].getX()  - Barrs_4.WIDTH+210);//������������ƶ�
			}else{
				//����ײ
				person.setX(barrs4[i].getX()+ Barrs_4.WIDTH	);//��ײ�����ﱻ�ϰ���������
				barrs_2.setX(barrs4[i].getX()  + Barrs_4.WIDTH+210);//������������ƶ�
			}	
		}
	}
	//��һ����ͽ�ҵ���ײ
	for(int i = 0;i<barrs5.length;i++){
		if(person.getX() + Person.WIDTH >= barrs5[i].getX() &&//������
		person.getX() <= barrs5[i].getX()	 + Barrs_5.WIDTH  &&//������
		person .getY() +Person.getHeight() >= barrs5[i].getY() &&//������
		person.getY()	<= barrs5[i].getY () + Barrs_5.HEIGHT||//������
		barrs_2.getX() + Barrs_2.WIDTH >= barrs5[i].getX() &&//������
		barrs_2.getX() <= barrs5[i].getX()	 + Barrs_5.WIDTH  &&//������
		barrs_2 .getY() +Barrs_2.getHeight() >= barrs5[i].getY() &&//������
		barrs_2.getY()	<= barrs5[i].getY () + Barrs_5.HEIGHT){//������
			//�ж���һ�������ҵ���ײ
			if(person.getX() + Person.WIDTH <= barrs5[i].getX() + Barrs_5.WIDTH||
				barrs_2.getX() + Barrs_2.WIDTH <= barrs5[i].getX() + Barrs_5.WIDTH){
				//ɾ����ǰ���
				barrs5[i]	= barrs5[barrs5.length - 1];//������������һ��Ԫ�أ�����Խ��Ľ�ң������ˣ��൱�ڼ��ɾ���ˡ�
				barrs5 = Arrays.copyOf(barrs5, barrs5.length - 1);	//�����������
				//��Ҽӷ�
				int score = person.getScore();
				person.setScore(score + 10);
		   }
		}
	}
		
}
//�����߼�
	public  void gameOverAction() throws SQLException{
		if(person.outOfBounds()){
			//�������
			/*��ʦ��û�����ǵ����ݿ⣬Ҫ���Ǵ�
			//����������ݼ������ݿ�
			DBUtils utils=DBUtils.getInstance();
			Connection conn=utils.getConn();
			String sql="insert into runday(name,score,distance,totalscore) values(?,?,?,?)";
			PreparedStatement ps=null;
			try {
				 ps=conn.prepareStatement(sql);
				ps.setString(1, "��giao");
				ps.setInt(2, person.getScore());
				ps.setInt(3, person.getDistance());
				ps.setInt(4, person.getTotalScore());
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
			
				utils.closeAll(null, ps, conn);
			}*/
			isGameOver = true;
			//�������ݣ������������棩
			new EndFrame(person);//�������˼��
			//�������
			person = new Person();
			barrs1 = new Barrs_1[]{};
			barrs3 = new Barrs_3[]{};
		}	
	}
	
	public boolean isGameOver = false;
	boolean flag = true; 
//	��	��	һ	��	��	��	��	��	�� 	��	��
public void action(){
	new Thread(){//�����ڲ���
		//��дrun����
		public void run() {
			while(!isGameOver){
				if(flag){
						enteredAction();//���������ϰ����������ܵ����ƶ��ϰ���ķ���
						stepAction();//�ϰ����ƶ��ķ���
						pengAction();//��Һ��ϰ�����ײ
						try {
							gameOverAction();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				}
				//�ػ淽��
				repaint();
				//�߳�����
				try {
					//60s����һ��
					Thread.sleep(60);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
		};
	}.start();//����һ���̲߳�����

	}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyPressed(KeyEvent e) {//���̼����ķ���
	//��ȡ��ҵ�ǰλ������
	 int x = person.getX();
	 int y = person.getY();
	 int x1 = barrs_2.getX();
	 int y1 = barrs_2.getY();

	 	//��
		if(e.getKeyCode() == KeyEvent.VK_UP	&&		y > 10	&&		y1 > 10){
			person.setY(y-200);
			barrs_2.setY(y-200);
		}
		//��
		if(e.getKeyCode()== KeyEvent.VK_DOWN	&&		y<=560		&&		y1<560){
			person.setY(y+50);
			barrs_2.setY(y-30);
		}
		//��
		if(e.getKeyCode()==KeyEvent.VK_LEFT		&& 	x>=0	){
			person.setX(x-50);
			barrs_2.setX(x1-50);
			
		}
		//��
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			person.setX(x+22);
			barrs_2.setX(x1+22);
			if(x>=GameFrame.WIDTH-Person.WIDTH){//������ﵽ���ұ߽�
				person.setX(GameFrame.WIDTH-Person.WIDTH);
			}
			if(x1>=GameFrame.WIDTH-barrs_2.WIDTH){//������ﵽ���ұ߽�
				barrs_2.setX(GameFrame.WIDTH - barrs_2.WIDTH);
			}
		}
		//��ͣ ��������
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
				flag = !flag;
		}
		
	}

@Override//��д���û��ɿ����̰�ťʱ�����ķ���.
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
}
}