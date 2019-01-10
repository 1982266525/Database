package exercise3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;



class BackgroundPanel extends JPanel  
{  
    Image im;  
    public BackgroundPanel(Image im)  
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


public class Login {

static int ver=0;
private static BackgroundPanel contentPane;	

public static void main(String[] args){
	final JFrame Login=new JFrame("��¼����");
    Login.setBounds(600, 200, 450, 350);
    Login.setLocationRelativeTo(Login.getOwner());

    
  //  Login.setBackground(new Color(255, 204, 153));  
    contentPane=new BackgroundPanel((new ImageIcon("F:\\ѧϰ����\\JAVA\\calculator\\���ݿ�\\src\\exercise3\\timg[10].jpg")).getImage());
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(null);
    contentPane.setSize( 400, 300);
    
    
    JLabel userid=new JLabel("���ţ�");
    final JTextField userid2=new JTextField(10);
    
    JPanel jP1 = new JPanel();
    jP1.add(userid);
    jP1.add(userid2);
    jP1.setLayout(new FlowLayout(FlowLayout.CENTER,0,45));
    //jP1.setOpaque(false);

    //jP1.setBackground(new Color(255, 204, 153));  
   
   
  
    JLabel userPassword=new JLabel("���룺");
    final JPasswordField userPassword2=new JPasswordField(10);
    JPanel jP2 = new JPanel();
    jP2.add(userPassword);
    jP2.add(userPassword2);
    jP2.setLayout(new FlowLayout(FlowLayout.CENTER,0,35));
   // jP2.setBackground(new Color(255, 204, 153)); 
    
    final JRadioButton users =new JRadioButton("�û���¼",true);
    final JRadioButton admin =new JRadioButton("����Ա��¼");
    ButtonGroup group=new ButtonGroup();
    group.add(users);
    group.add(admin);
   // users.setBackground(new Color(255, 204, 153));
   // admin.setBackground(new Color(255, 204, 153));
    final DefaultButtonModel model = (DefaultButtonModel) admin.getModel();
    
    JPanel jP4=new JPanel();
    jP4.add(users);
    jP4.add(admin);
    jP4.setLayout(new FlowLayout(FlowLayout.CENTER,35,20));
    //jP4.setBackground(new Color(255, 204, 153)); 
     final JButton enter=new JButton("��¼");
    JButton exit=new JButton("�˳�");
    JPanel jP3 = new JPanel();
    jP3.add(enter);
    jP3.add(exit);
    jP3.setLayout(new FlowLayout(FlowLayout.CENTER,25,0));
   // jP3.setBackground(new Color(255, 204, 153)); 
    Login.setVisible(true);
    jP1.setOpaque(false);
    jP2.setOpaque(false);
    jP3.setOpaque(false);
    jP4.setOpaque(false);
    users.setOpaque(false);
    userPassword2.setOpaque(false);
    admin.setOpaque(false);
    userid2.setOpaque(false);
    Login.add(contentPane);
    contentPane.setLayout(new GridLayout(4,1));
    contentPane.add(jP1);
    contentPane.add(jP2);
    contentPane.add(jP4);
    contentPane.add(jP3);                             //����
    
 
    
    enter.addMouseListener(new MouseAdapter(){
    	public void mouseClicked(MouseEvent e){
    		verification(userid2.getText(),MD5.encrypt(userPassword2.getText().trim()));
    	//	System.out.println(userid2.getText());
    	//	System.out.println(userPassword2.getText());
    		
    		//System.out.println(ver);
    		if(ver==2&&users.isSelected()){
    			System.out.println("��¼�ɹ�");
    			 Login.setVisible(false);
    			 verification.toAdd(Login,userid2.getText().trim());
    			
    		}
    		else if(ver==1&&admin.isSelected())
    		{
    			System.out.println("��¼�ɹ�");
   			 Login.setVisible(false);
   			 choice.choose();
    			
    		}
    		else{
    			choice.choose();     
    			Login.setVisible(false);    
    		//	JOptionPane.showMessageDialog(null, "          			�û��˺Ż��������","Error",JOptionPane.ERROR_MESSAGE); 
    		}
    	}
    });
    
    exit.addMouseListener(new MouseAdapter(){
    	public void mouseClicked(MouseEvent e){
    		System.exit(0);
    		Login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		}
});
    	
   
   Login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
}

public static int  verification(String pId,String pPasswd){
	try{
		// ������ѯ����
		String sql = "select pId,pPasswd,pAuthority from person;";
		System.out.println("queryAllProcess(). sql = " + sql);

		DbProcess.connect();
		ResultSet rs = DbProcess.executeQuery(sql);

		// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
		ver=0;
		while(rs.next()){
			if(pId.equals(rs.getString("pId"))==true&&pPasswd.equals(rs.getString("pPasswd"))==true)
		{   //System.out.println("�����˺�ƥ��ɹ�");
			if(rs.getString("pAuthority").equals("����Ա")){
				ver=1;
			}
			else if(rs.getString("pAuthority").equals("Ա��")){
				ver=2;
			}
		
		}
		
		
		}
	
	
	}catch(SQLException sqle){
		System.out.println("sqle = " + sqle);
		JOptionPane.showMessageDialog(null,
			"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
	}
	return ver;
	
}
}



