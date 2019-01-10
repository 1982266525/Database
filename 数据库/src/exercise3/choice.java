package exercise3;


import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;



class BackgroundPanel1 extends JPanel  
{  
    Image im;  
    public BackgroundPanel1(Image im)  
    {  
        this.im=im;  
        this.setOpaque(false);                    //���ÿؼ���͸��,����false,��ô����͸��
    }  
    //Draw the background again,�̳���Jpanle,��Swing�ؼ���Ҫ�̳�ʵ�ֵķ���,������AWT�е�Paint()
    public void paintComponent(Graphics g)       //��ͼ��
    {  
        super.paintComponents(g);  
        g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);  //����ָ��ͼ���е�ǰ���õ�ͼ��ͼ������Ͻ�λ�ڸ�ͼ������������ռ�� (x, y)��ͼ���е�͸�����ز�Ӱ��ô��Ѵ��ڵ�����

    }  
}

public class choice {
	
	private static BackgroundPanel1 contentPane;	
public static void choose(){
	
	final JFrame choice=new JFrame("����ѡ��");
	choice.setBounds(600, 200, 260, 400);
	choice.setLocationRelativeTo(choice.getOwner());

	choice.setLayout(null);
	choice.setVisible(true);
	
	 contentPane=new BackgroundPanel1((new ImageIcon("F:\\ѧϰ����\\JAVA\\calculator\\���ݿ�\\src\\exercise3\\2YAB{QYGYN5]$R9X%UR]Y2Y.png")).getImage());
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    contentPane.setLayout(null);
	    contentPane.setSize( 260, 400);
	
    choice.add(contentPane);
	
	JButton addStaff=new JButton("��Ա���������� ");
	JButton change=new JButton(" Ա�����±�� ");
	JButton refer=new JButton("Ա��������ѯ�޸�");
	JButton referRecord=new JButton("���±����¼");
	addStaff.setBounds(50, 50, 160, 35);
	change.setBounds(50, 120, 160, 35);
	refer.setBounds(50, 190, 160, 35);
	referRecord.setBounds(50, 260, 160, 35);
	contentPane.add(addStaff);
	contentPane.add(change);
	contentPane.add(refer);
	contentPane.add(referRecord);
	
	
	addStaff.addMouseListener(new MouseAdapter(){
    	public void mouseClicked(MouseEvent e){
    		choice.setVisible(false);
    		AddStaff.toAdd(choice);
    	}
    	});
	
	change.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
		choice.setVisible(false);
		Change.changes(choice);
		}
	});
	
	refer.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
		choice.setVisible(false);
		Refer.referStaff(choice);
		}
	});
	
	referRecord.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
		choice.setVisible(false);
		ReferRecord.referRecord(choice);
		}
	});
	
	 choice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
