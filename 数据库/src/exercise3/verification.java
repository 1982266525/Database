package exercise3;


import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

class BackgroundPanel3 extends JPanel  
{  
    Image im;  
    public BackgroundPanel3(Image im)  
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

public class verification {
	
        
		private static BackgroundPanel1 contentPane;	
		static  int count=0;
		static String Count;
		static JLabel Id=new JLabel("Ա����",JLabel.CENTER);
		static JLabel Name=new JLabel("��        �� ",JLabel.CENTER);
		static JLabel Sex=new JLabel("��        ��",JLabel.CENTER);
		static JLabel Passwd=new JLabel("��        ��",JLabel.CENTER);
		static JLabel Authority=new JLabel("�û�Ȩ��",JLabel.CENTER);
		
		static JLabel Department=new JLabel("���ڲ���",JLabel.CENTER);
		static JLabel Job=new JLabel("ְ        �� ",JLabel.CENTER);
		static JLabel Edulevel=new JLabel("�ܽ����̶�",JLabel.CENTER);
		static JLabel Spcialty=new JLabel("רҵ����",JLabel.CENTER);
		static JLabel Birthday=new JLabel("��        ��",JLabel.CENTER);
		
		static JLabel Address=new JLabel("��ͥסַ",JLabel.CENTER);
		static JLabel Tel=new JLabel("��ϵ�绰",JLabel.CENTER);
		static JLabel Email=new JLabel("�����ʼ�",JLabel.CENTER);
		static JLabel State=new JLabel("��ǰ״̬",JLabel.CENTER);
		static JLabel Remark=new JLabel("��        ע",JLabel.CENTER);
		
		static	JTextField id=new JTextField(10);
		
		static	JTextField passwd=new JTextField(10);
		static	JTextField authority=new JTextField(10);
		static	JTextField name=new JTextField(10);
		static	JTextField sex=new JTextField(10);
		static	JTextField birthday=new JTextField(10);
		static	JTextField department=new JTextField(10);
		static	JTextField job=new JTextField(10);
		static	JTextField edulevel=new JTextField(10);
		static	JTextField spcialty=new JTextField(10);
		static	JTextField address=new JTextField(10);
		static	JTextField tel=new JTextField(10);
		static	JTextField email=new JTextField(10);
		static JTextField state=new JTextField(10);
		static	JTextField remark=new JTextField(10);

	    
		
		
		static JLabel title=new JLabel("Ա��������ѯ",JLabel.CENTER);
		
		
		
	public static void toAdd(final JFrame Login,String pid){
		final JFrame addWindows=new JFrame("Ա��������ѯ");
		addWindows.setBounds(400, 200,1000, 450);
		addWindows.setVisible(true);
		addWindows.setLocationRelativeTo(addWindows.getOwner());

		//addWindows.setLayout(new GridLayout(3,1));
		addWindows.setPreferredSize(new Dimension(20,20)); 
		
		 contentPane=new BackgroundPanel1((new ImageIcon("F:\\ѧϰ����\\JAVA\\calculator\\���ݿ�\\src\\exercise3\\timgCAANQAXH.jpg")).getImage());
		    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		    contentPane.setLayout(null);
		    contentPane.setSize( 1000, 450);
		    contentPane.setLayout(new GridLayout(3,1));
		
		title.setFont(new Font("Dialog",1,30));
		id.setEditable(false);
		name.setEditable(false);
		department.setEditable(false);
		authority.setEditable(false);
		job.setEditable(false);
		edulevel.setEditable(false);
		state.setEditable(false);
		//System.out.println("count="+refercount());
		
//		Count=String.valueOf(refercount()+1);
		id.setText(pid);
	//	count=0;
		
		 
		 JPanel centre=new  JPanel();
		 centre.setLayout(new GridLayout(3,1,20,25));
		 JPanel centre1=new  JPanel();
		 centre1.add(Id);
		 centre1.add(id);
		 centre1.add(Name);
		 centre1.add(name);
		 centre1.add(Sex);
		 centre1.add(sex);
		 centre1.add(Birthday);
		 centre1.add(birthday);
		 centre1.add(Department);
		 centre1.add(department);
		 
		 JPanel centre2=new  JPanel();
		 centre2.add(Authority);
		 centre2.add(authority);
		 centre2.add(Passwd);
		 centre2.add(passwd);
		 centre2.add(Job);
		 centre2.add(job);
		 centre2.add(Edulevel);
		 centre2.add(edulevel);
		 centre2.add(Spcialty);
		 centre2.add(spcialty);
		 
		 JPanel centre3=new  JPanel();
		 centre3.add(Address);
		 centre3.add(address);
		 centre3.add(Tel);
		 centre3.add(tel);
		 centre3.add(Email);
		 centre3.add(email);
		 centre3.add(State);
		 centre3.add(state);
		 centre3.add(Remark);
		 centre3.add(remark);
		 
		 centre.add(centre1);
		 centre.add(centre2);
		 centre.add(centre3);
		 
		 
		 JPanel bottom=new JPanel();
		 bottom.setLayout(new FlowLayout(FlowLayout.RIGHT,50,30));
		 
		 JButton btn1=new JButton("�޸�");
		 JButton btn2=new JButton("����");
	 
		 btn1.addMouseListener(new MouseAdapter(){
		    	public void mouseClicked(MouseEvent e){
		    		if(!name.getText().isEmpty()){
		    	    	String pName = name.getText().trim(); 
		    	    	String pSex= sex.getText().trim(); 
		    	    	String pPasswd = MD5.encrypt(passwd.getText().trim()); 
		    	    	String pAuthority = authority.getText().trim();
		    	    	
		    	    	String pDepartment = department.getText().trim();
		    	    	String pJob = job.getText().trim(); 
		    	    	String pEdulevel= edulevel.getText().trim(); 
		    	    	String pSpcialty = spcialty.getText().trim(); 
		    	    	String pBitrhday = birthday.getText().trim(); 
		    	    	
		    	    	String pAddress = address.getText().trim();
		    	    	String pTel = tel.getText().trim(); 
		    	    	String pEmail= email.getText().trim(); 
		    	    	String pState = state.getText().trim(); 
		    	    	String pRemark = remark.getText().trim(); 
		    	    	//System.out.println(pPasswd);
		    	    	UpdateProcess(pName,pSex,pPasswd,pAuthority,pDepartment,pJob,pEdulevel,pSpcialty,pBitrhday,pAddress,pTel,pEmail,pState,pRemark);
		    	    	JOptionPane.showMessageDialog(null, "���³ɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE); 
		    	    	
		    	    	
		    	    	
		    		}
		    	}
		    });
		 
	 
		 btn2.addMouseListener(new MouseAdapter(){
		    	public void mouseClicked(MouseEvent e){
		    		addWindows.setVisible(false);
		    		Login.setVisible(true);
		    		
		    		}

				
		    });
		 
	
		 
		 bottom.add(btn1);
		 bottom.add(btn2);
		
		 title.setOpaque(false);
		 centre.setOpaque(false);
		 centre1.setOpaque(false);
		 centre2.setOpaque(false);
		 centre3.setOpaque(false);
		 bottom.setOpaque(false);
		
		 
		 contentPane.add(title);
		 contentPane.add(centre);
		 contentPane.add(bottom);
		 
		 addWindows.add(contentPane);
		 
		 System.out.println(pid);
		 referSet(pid);
		 addWindows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
public static void referSet(String pid){
	try{
		// ������ѯ����
		 System.out.println(pid+"   2");
		String sql = "select * from person where pId='";
		sql=sql+pid+"'";
		System.out.println("queryAllProcess(). sql = " + sql);

		DbProcess.connect();
		ResultSet rs = DbProcess.executeQuery(sql);

		// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
		
		while(rs.next()){
			id.setText(pid);
			name.setText(rs.getString("pName"));
			sex.setText(rs.getString("pSex"));
			birthday.setText(rs.getString("pBirthday"));
			department.setText(rs.getString("pDepartment"));
			authority.setText(rs.getString("pAuthority"));
			//decrypt(String s)
			passwd.setText(MD5.decrypt(rs.getString("pPasswd")));
			job.setText(rs.getString("pJob"));
			edulevel.setText(rs.getString("pEdulevel"));
			spcialty.setText(rs.getString("pSpcialty"));
			address.setText(rs.getString("pAddress"));
			tel.setText(rs.getString("pTel"));
			email.setText(rs.getString("pEmail"));
			state.setText(rs.getString("pState"));
			remark.setText(rs.getString("pRemark"));
			
			
			
		}
		System.out.println("����Ա���� "+(count));
	
	}catch(SQLException sqle){
		System.out.println("sqle = " + sqle);
		JOptionPane.showMessageDialog(null,
			"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
	}
	
}

public static void  UpdateProcess(String pName,String pSex,String pPasswd,String pAuthority,String pDepartment,String pJob,String pEdulevel,String pSpcialty,String pBirthday,String pAddress,String pTel,String pEmail,String pState,String pRemark)
{   
	//int QNo=AddStaff.refercount();
   // String qNo=String.valueOf(QNo+1);
	String sql = "update person set pSex = '";
	sql = sql + pSex + "', pPasswd = '";
	sql = sql + pPasswd + "', pAuthority = '";
	sql = sql + pAuthority + "', pDepartment = '";
	sql = sql + pDepartment + "', pJob = '";
	sql = sql + pJob + "', pEdulevel = '";
	sql = sql + pEdulevel + "', pSpcialty = '";
	sql = sql + pSpcialty + "', pBirthday = '";
	sql = sql + pBirthday + "', pAddress = '";
	sql = sql + pAddress + "', pEmail = '";
	sql = sql + pEmail + "', pState = '";
	sql = sql + pState + "', pRemark = '";
	sql = sql + pRemark + "'";
	sql = sql + " WHERE pName = '" + pName + "';";
	System.out.println("updateProcess(). sql = " + sql);
	try{
		if (DbProcess.executeUpdate(sql) < 1) {
			System.out.println("updateProcess(). update database failed.");
		}
	}catch(Exception e){
		System.out.println("e = " + e);
		JOptionPane.showMessageDialog(null,
			"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
	}

}


	}


