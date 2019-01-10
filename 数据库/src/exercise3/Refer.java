package exercise3;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



class BackgroundPanel5 extends JPanel  
{  
    Image im;  
    public BackgroundPanel5(Image im)  
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




public class Refer {
	
	
	private static BackgroundPanel contentPane;	
	static String Selectfield="����";
	static int count=0;
	

	
	public static void referStaff(final JFrame choice){
			contentPane=new BackgroundPanel((new ImageIcon("F:\\ѧϰ����\\JAVA\\calculator\\���ݿ�\\src\\exercise3\\e54791eab7d801a2ac93627b27086831_51t58PICVvI_1024.jpg")).getImage());
		    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		    contentPane.setLayout(null);
		    contentPane.setSize( 1020, 550);
		final JFrame referStaff=new JFrame("Ա����Ϣ��ѯ�޸�");
		referStaff.setBounds(200, 200,1020, 550);
		referStaff.setLocationRelativeTo(referStaff.getOwner());

		referStaff.setVisible(true);
		JLabel title=new JLabel("Ա������",JLabel.CENTER);
		JLabel SelectField =new JLabel("ѡ���ѯ�ֶ�");    //ѡ���ѯ�ֶ�
		JLabel boring =new JLabel("=");         //=
		
		/*  ����ֵ���  */
		JLabel Id=new JLabel("Ա �� ��",JLabel.CENTER);
		JLabel Name=new JLabel("��        �� ",JLabel.CENTER);
		JLabel Sex=new JLabel("    ��      ��",JLabel.CENTER);
		JLabel Passwd=new JLabel("��ǰ����",JLabel.CENTER);
		JLabel Authority=new JLabel("�� �� Ȩ ��",JLabel.CENTER);
		
		JLabel Department=new JLabel("���ڲ���",JLabel.CENTER);
		JLabel Job=new JLabel("ְ        �� ",JLabel.CENTER);
		JLabel Edulevel=new JLabel("�ܽ����̶�",JLabel.CENTER);
		JLabel Spcialty=new JLabel("רҵ����",JLabel.CENTER);
		JLabel Birthday=new JLabel("��        ��",JLabel.CENTER);
		
		JLabel Address=new JLabel("��ͥסַ",JLabel.CENTER);
		JLabel Tel=new JLabel("��ϵ�绰",JLabel.CENTER);
		JLabel Email=new JLabel("�����ʼ�",JLabel.CENTER);
		JLabel State=new JLabel("��ǰ״̬",JLabel.CENTER);
		JLabel Remark=new JLabel("��        ע",JLabel.CENTER);
		
		
		
		
		/*  ���������    */
		final JTextField id=new JTextField(10);
		id.setEditable(false);
		final JTextField passwd=new JTextField(10);
		final JTextField authority=new JTextField(10);
		final JTextField name=new JTextField(10);
		final JTextField sex=new JTextField(10);
		final JTextField birthday=new JTextField(10);
		final JTextField department=new JTextField(10);
		department.setEditable(false);
		final JTextField job=new JTextField(10);
		job.setEditable(false);
		final JTextField edulevel=new JTextField(10);
		final JTextField spcialty=new JTextField(10);
		
		final JTextField address=new JTextField(10);
		final JTextField tel=new JTextField(10);
		final JTextField email=new JTextField(10);
		final JTextField state=new JTextField(10);
		state.setEditable(false);
		final JTextField remark=new JTextField(10);
		
		JButton found=new JButton("��ѯ");
		JButton foundAll=new JButton("��ѯ���м�¼");
		JButton insert=new JButton("���������Ϣ");
		 insert.setVisible(false);
		JButton update=new JButton("���¸�����Ϣ");
	//	JButton delete=new JButton("ɾ��������Ϣ");
		JButton back=new JButton("����");
		
		
		
		JComboBox<String> Select = new JComboBox<String>();
		Select.addItem("����");
		Select.addItem("����");
		Select.addItemListener(new ItemListener() {//�������¼�����  
	        public void itemStateChanged(ItemEvent event) {  
	            switch (event.getStateChange()) {  
	            case ItemEvent.SELECTED:  
	            	Selectfield = (String) event.getItem();  
	                System.out.println("ѡ�У�" + Selectfield);  
	                break;  
	            case ItemEvent.DESELECTED:  
	                System.out.println("ȡ��ѡ�У�" + event.getItem());  
	                break;  
	            }  
	        }  
	    });
		
		final JTextField selectItem=new JTextField(10);
		
		Vector titleVector = new Vector();       //��ά����ⲿ��
		final Vector staffVector = new Vector();     //��ά���²���
		titleVector.add("Ա����");
		titleVector.add("����");
		titleVector.add("�Ա�");
		titleVector.add("��ǰ����");
		titleVector.add("�û�Ȩ��");
		titleVector.add("���ڲ���");
		titleVector.add("ְ��");
		titleVector.add("�ܽ����̶�");
		titleVector.add("רҵ����");
		titleVector.add("����");
		titleVector.add("��ͥסַ");
		titleVector.add("��ϵ");
		titleVector.add("�����ʼ�");
		titleVector.add("��ǰ״̬");
		titleVector.add("��ע");
		
		
		final JTable StaffJTable = new JTable(staffVector, titleVector);
		StaffJTable.setPreferredScrollableViewportSize(new Dimension(1000,250));
		JScrollPane staffJScrollPane = new JScrollPane(StaffJTable);
		//�ֱ�����ˮƽ�ʹ�ֱ�������Զ�����
		staffJScrollPane.setHorizontalScrollBarPolicy(                
	            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);   // ����Ҫʱ����ֹ�����
		staffJScrollPane.setVerticalScrollBarPolicy(                
	            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		StaffJTable.addMouseListener(new MouseAdapter()
		{ 
			public void mouseClicked(MouseEvent e) 
			{ 
				int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // �����λ��
				System.out.println("mouseClicked(). row = " + row);
				Vector v = new Vector();
				v = (Vector) staffVector.get(row);

				id.setText((String) v.get(0));// ѧ��
				name.setText((String) v.get(1));// ����
				sex.setText((String) v.get(2));// �Ա�
				passwd.setText((String) v.get(3));// ����
				authority.setText((String) v.get(4));// רҵ
				department.setText((String) v.get(5));// סַ
				job.setText((String) v.get(6));// סַ
				edulevel.setText((String) v.get(7));// סַ
				spcialty.setText((String) v.get(8));// סַ
				birthday.setText((String) v.get(9));// סַ
				address.setText((String) v.get(10));// סַ
				tel.setText((String) v.get(11));// סַ
				email.setText((String) v.get(12));// סַ
				state.setText((String) v.get(13));// סַ
				remark.setText((String) v.get(14));// סַ
				
			}
		});
		
		
	
		JPanel division1=new JPanel();
		JPanel division2=new  JPanel();
		JPanel division3=new  JPanel();
		JPanel division4=new  JPanel();
		JPanel division5=new  JPanel();
		JPanel division6=new  JPanel ();
		JPanel division7=new  JPanel ();
		
		
		JPanel top=new  JPanel();
		JPanel bottom=new  JPanel();
		
		
		division1.add(title,BorderLayout.SOUTH);
		division2.add(staffJScrollPane);
		
		division3.setLayout(new FlowLayout(FlowLayout.LEFT,15,0));
		division3.add(SelectField);
		division3.add(Select);
		division3.add(boring);
		division3.add(selectItem);
		division3.add(found);
		division3.add(foundAll);
		
		
		division4.setLayout(new FlowLayout(FlowLayout.CENTER,12,10));
		division4.add(Id);
		division4.add(id);
		division4.add(Name);
		division4.add(name);
		division4.add(Sex);
		division4.add(sex);
		division4.add(Passwd);
		division4.add(passwd);
		division4.add(Authority);
		division4.add(authority);
		
		division5.setLayout(new FlowLayout(FlowLayout.CENTER,12,10));
		division5.add(Department);
		division5.add(department);
		division5.add(Job);
		division5.add(job);
		division5.add(Edulevel);
		division5.add(edulevel);
		division5.add(Spcialty);
		division5.add(spcialty);
		division5.add(Birthday);
		division5.add(birthday);
		
		division7.setLayout(new FlowLayout(FlowLayout.CENTER,12,10));
		division7.add(Address);
		division7.add(address);
		division7.add(Tel);
		division7.add(tel);
		division7.add(Email);
		division7.add(email);
		division7.add(State);
		division7.add(state);
		division7.add(Remark);
		division7.add(remark);
	  
		division6.setLayout(new FlowLayout(FlowLayout.RIGHT,30,10));
		division6.add(insert);
		division6.add(update);
	//	division6.add(delete);
		
		division6.add(back);
		division6.setVisible(true);
		
		
		
		top.add(division1);
		top.add(division2);
		bottom.setLayout(new GridLayout(5, 1));
		bottom.add(division3);
		bottom.add(division4);
		bottom.add(division5);
		bottom.add(division7);
		bottom.add(division6);
	

	  // bottom.add(division6);
	   //bottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		contentPane.setLayout(new GridLayout(2,1,20,0));
		contentPane.add(top);
		contentPane.add(bottom);
		//referStaff.setLayout(new GridLayout(2,1,20,0));
		//referStaff.add(top);
		//referStaff.add(bottom);
		referStaff.add(contentPane);
		top.setOpaque(false);
		division1.setOpaque(false);
		division2.setOpaque(false);
		bottom.setOpaque(false);
		division3.setOpaque(false);
		division4.setOpaque(false);
		division5.setOpaque(false);
		division6.setOpaque(false);
		division7.setOpaque(false);
		staffJScrollPane.setOpaque(false);
		StaffJTable.setOpaque(false);
		
		
		referStaff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		found.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e){
	    		if(!selectItem.getText().isEmpty()){
	    	    	String sQueryField = selectItem.getText().trim(); 
	    	    	
	    	    	queryProcess(sQueryField,staffVector,StaffJTable);  
	    		}
	    	}
	    });
		
		foundAll.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e){
	    		
	    	    	String sQueryField = selectItem.getText().trim(); 
	    	    	
	    	    	queryAllProcess(staffVector,StaffJTable);  
	    		
	    	}
	    });
		
		insert.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e){
	    		if(!name.getText().isEmpty()){
	    			count=refercount()+1;
	    			String pId =String.valueOf(count);
	    			String pName = name.getText().trim(); 
	    	    	String pSex= sex.getText().trim(); 
	    	    	String pPasswd = passwd.getText().trim(); 
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
	    			
	    	    	addProcess(pId,pName,pSex,pPasswd,pAuthority,pDepartment,pJob,pEdulevel,pSpcialty,pBitrhday,pAddress,pTel,pEmail,pState,pRemark);
	    	    	queryAllProcess(staffVector,StaffJTable);  
	    		}
	    		
	    	}
	    });
		
		update.addMouseListener(new MouseAdapter(){
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
	    	    	
	    	    	UpdateProcess(pName,pSex,pPasswd,pAuthority,pDepartment,pJob,pEdulevel,pSpcialty,pBitrhday,pAddress,pTel,pEmail,pState,pRemark);
	    	    	queryAllProcess(staffVector,StaffJTable);
	    	    	JOptionPane.showMessageDialog(null, "���³ɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE); 
	    	    	name.setText("");
	    	    	sex.setText("");
	    	    	passwd.setText("");
	    	    	authority.setText("");
	    	    	department.setText("");
	    	    	job.setText("");
	    	    	edulevel.setText("");
	    	    	spcialty.setText("");
	    	    	birthday.setText("");
	    	    	address.setText("");
	    	    	tel.setText("");
	    	    	email.setText("");
	    	    	state.setText("");
	    	    	remark.setText("");
	    	    	
	    	    	
	    		}
	    		else
	    			JOptionPane.showMessageDialog(null, "��ȷ���޸����","��ʾ",JOptionPane.ERROR_MESSAGE); 	
	    	}
	    });
		
		
		 back.addMouseListener(new MouseAdapter(){
		    	public void mouseClicked(MouseEvent e){
		    		referStaff.setVisible(false);
		    		choice.setVisible(true);
		    		}
		    	});
		 
		 
	}
	
	public static void queryProcess(String sQueryField,Vector staffVector,JTable StaffJTable){
		try{
			String sql=null;
			if(Selectfield.equals("����")){
			sql = "select pId,pName,pSex,pPasswd,pAuthority,pDepartment,pJob,pEdulevel,pSpcialty,pBirthday,pAddress,pTel,pEmail,pState,pRemark from person where ";
			sql = sql + "pId";
				sql = sql + " like ";
				sql = sql + "'" +'%' +sQueryField +'%' +"';";
		
			
			System.out.println("queryProcess(). sql = " + sql);
			}
			else if(Selectfield.equals("����")){
				sql = "select pId,pName,pSex,pPasswd,pAuthority,pDepartment,pJob,pEdulevel,pSpcialty,pBirthday,pAddress,pTel,pEmail,pState,pRemark from person where ";
				sql = sql + "pName";
				sql = sql + " like ";
				sql = sql + "'" +'%' +sQueryField +'%' +"';";
			
				
				System.out.println("queryProcess(). sql = " + sql);		
			}
	
			DbProcess.connect();
			
			 DbProcess.executeQuery(sql);   //�����ResultSet
		
		//	while(DbProcess.rs.next()){
			//	System.out.println(DbProcess.rs.getString("pName"));
				//}
			
			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
			staffVector.clear();    
	while(DbProcess.rs.next()){
				Vector v = new Vector();
				System.out.println(DbProcess.rs.getString("pName"));
				v.add(DbProcess.rs.getString("pId"));
				v.add(DbProcess.rs.getString("pName"));
				v.add(DbProcess.rs.getString("pSex"));
				v.add(DbProcess.rs.getString("pPasswd"));
				v.add(DbProcess.rs.getString("pAuthority"));
				v.add(DbProcess.rs.getString("pDepartment"));
				v.add(DbProcess.rs.getString("pJob"));
				v.add(DbProcess.rs.getString("pEdulevel"));
				v.add(DbProcess.rs.getString("pSpcialty"));
				v.add(DbProcess.rs.getString("pBirthday"));
				v.add(DbProcess.rs.getString("pAddress"));
				v.add(DbProcess.rs.getString("pTel"));
				v.add(DbProcess.rs.getString("pEmail"));
				v.add(DbProcess.rs.getString("pState"));
				v.add(DbProcess.rs.getString("pRemark"));
				
				
				staffVector.add(v);
			}
	StaffJTable.updateUI();
			DbProcess.disconnect();
		}catch(SQLException sqle){
			System.out.println("sqle = " + sqle);
			JOptionPane.showMessageDialog(null,
				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
		}
}
	
	public static void queryAllProcess(Vector staffVector,JTable StaffJTable)
	{
		try{
			// ������ѯ����
			String sql = "select * from person;";
			System.out.println("queryAllProcess(). sql = " + sql);
	
			DbProcess.connect();
			

			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
		
			
			 DbProcess.executeQuery(sql);   //�����ResultSet
		
		//	while(DbProcess.rs.next()){
			//	System.out.println(DbProcess.rs.getString("pName"));
				//}
			
			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
			staffVector.clear();    
			while(DbProcess.rs.next()){
				Vector v = new Vector();
				System.out.println(DbProcess.rs.getString("pName"));
				v.add(DbProcess.rs.getString("pId"));
				v.add(DbProcess.rs.getString("pName"));
				v.add(DbProcess.rs.getString("pSex"));
				v.add( MD5.decrypt(DbProcess.rs.getString("pPasswd"))); 
				v.add(DbProcess.rs.getString("pAuthority"));
				v.add(DbProcess.rs.getString("pDepartment"));
				v.add(DbProcess.rs.getString("pJob"));
				v.add(DbProcess.rs.getString("pEdulevel"));
				v.add(DbProcess.rs.getString("pSpcialty"));
				v.add(DbProcess.rs.getString("pBirthday"));
				v.add(DbProcess.rs.getString("pAddress"));
				v.add(DbProcess.rs.getString("pTel"));
				v.add(DbProcess.rs.getString("pEmail"));
				v.add(DbProcess.rs.getString("pState"));
				v.add(DbProcess.rs.getString("pRemark"));
				
				staffVector.add(v);
			}
	StaffJTable.updateUI();
			DbProcess.disconnect();
		}catch(SQLException sqle){
			System.out.println("sqle = " + sqle);
			JOptionPane.showMessageDialog(null,
				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			System.out.println("e = " + e);
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

public static void  addProcess(String pId,String pName,String pSex,String pPasswd,String pAuthority,String pDepartment,String pJob,String pEdulevel,String pSpcialty,String pBirthday,String pAddress,String pTel,String pEmail,String pState,String pRemark)
{   
	String sql="insert into person values('";
	sql=sql+pId+"','";
	sql=sql+pName+"','";
	sql=sql+pSex+"','";
	sql=sql+pBirthday+"','";
	sql=sql+pDepartment+"','";
	sql=sql+pAuthority+"','";
	sql=sql+pPasswd+"','";
	sql=sql+pJob+"','";
	sql=sql+pEdulevel+"','";
	sql=sql+pSpcialty+"','";
	sql=sql+pAddress+"','";
	sql=sql+pTel+"','";
	sql=sql+pEmail+"','";
	sql=sql+pState+"','";
	sql = sql +pRemark + "');";
	
	
	
	System.out.println("addProcess().sql="+sql);
	try{
		if (DbProcess.executeUpdate(sql) < 1) {
			System.out.println("addProcess(). add database failed.");
		}
		else
			{System.out.println("����ɹ�������");
			
			
	       }
	}catch(Exception e){
		System.out.println("e = " + e);
		JOptionPane.showMessageDialog(null,
			"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
	}
	       }


public static  int refercount(){
	try{
		// ������ѯ����
		String sql = "select * from person;";
		System.out.println("queryAllProcess(). sql = " + sql);

		DbProcess.connect();
		ResultSet rs = DbProcess.executeQuery(sql);

		// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
		
		while(rs.next()){
			count++;
		}
		System.out.println("����Ա���� "+(count));
	
	}catch(SQLException sqle){
		System.out.println("sqle = " + sqle);
		JOptionPane.showMessageDialog(null,
			"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
	}
	return count;
}

}
