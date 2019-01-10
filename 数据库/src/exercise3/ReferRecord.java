package exercise3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

class BackgroundPanel8 extends JPanel  
{  
    Image im;  
    public BackgroundPanel8(Image im)  
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






public class ReferRecord {
	private static BackgroundPanel8 contentPane;
	static String Selectfield="��¼���";
	
	public static void referRecord(final JFrame choice){
		
		
		contentPane=new BackgroundPanel8((new ImageIcon("F:\\ѧϰ����\\JAVA\\calculator\\���ݿ�\\src\\exercise3\\56565656.jpg")).getImage());
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    contentPane.setLayout(null);
	    contentPane.setSize( 700, 450);
	    
	    
		final JFrame referRecord=new JFrame("���±����¼");
		referRecord.setBounds(200, 200,814, 516);
		referRecord.setLocationRelativeTo(referRecord.getOwner());

		referRecord.setVisible(true);
		JLabel title=new JLabel("���±����¼",JLabel.CENTER);
		
		Vector titleVector = new Vector();       //��ά����ⲿ��
		final Vector RecordVector = new Vector();     //��ά���²���
		titleVector.add("��¼���");
		titleVector.add("Ա����");
		titleVector.add("�䶯");
		titleVector.add("��ϸ����");
		
		
		JLabel Id=new JLabel("��¼���",JLabel.CENTER);
		JLabel pId=new JLabel("Ա����",JLabel.CENTER);
		JLabel pChange=new JLabel("�������",JLabel.CENTER);
		JLabel pDescription=new JLabel("��ϸ��¼",JLabel.CENTER);
		
		final JTextField id=new JTextField(15);
		final JTextField pid=new JTextField(15);
		final JTextField pchange=new JTextField(15);
		final JTextField pdescription=new JTextField(15);
		
		final JTable StaffJTable = new JTable(RecordVector, titleVector);
		StaffJTable.setPreferredScrollableViewportSize(new Dimension(690,130));
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
				v = (Vector) RecordVector.get(row);

				id.setText((String) v.get(0));// 
				pid.setText((String) v.get(1));// 
				pchange.setText((String) v.get(2));// 
				pdescription.setText((String) v.get(3));// 
				
				
			}
		});
		
		
		JLabel SelectField =new JLabel("ѡ���ѯ�ֶ�");    //ѡ���ѯ�ֶ�
		JComboBox<String> Select = new JComboBox<String>();
		Select.addItem("��¼���");
		Select.addItem("Ա����");
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
		JLabel boring =new JLabel("=");         //=
		final JTextField selectItem=new JTextField(10);
		JButton found=new JButton("��ѯ");
		JButton foundAll=new JButton("��ѯ���м�¼");
		JButton back=new JButton("����");
		
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
		
		
		division4.setLayout(new FlowLayout(FlowLayout.CENTER,50,10));
		division4.add(Id);
		division4.add(id);
		division4.add(pId);
		division4.add(pid);
		
		division5.setLayout(new FlowLayout(FlowLayout.CENTER,50,10));
		division5.add(pChange);
		division5.add(pchange);
		division5.add(pDescription);
		division5.add(pdescription);
		
		division6.setLayout(new FlowLayout(FlowLayout.RIGHT,30,10));
		division6.add(back);
		
		top.add(division1);
		top.add(division2);
		
		bottom.setLayout(new GridLayout(4, 1,0,0));
		bottom.add(division3);
		bottom.add(division4);
		bottom.add(division5);
		bottom.add(division6);
		
	//	referRecord.setLayout(new GridLayout(2,1,20,0));
	//	referRecord.add(top);
	//	referRecord.add(bottom);
		
		contentPane.setLayout(new GridLayout(2,1,10,0));
		contentPane.add(top);
		contentPane.add(bottom);
		//referStaff.setLayout(new GridLayout(2,1,20,0));
		//referStaff.add(top);
		//referStaff.add(bottom);
		referRecord.add(contentPane);
		top.setOpaque(false);
		division1.setOpaque(false);
		division2.setOpaque(false);
		bottom.setOpaque(false);
		division3.setOpaque(false);
		division4.setOpaque(false);
		division5.setOpaque(false);
		division6.setOpaque(false);
		division7.setOpaque(false);
		

		
		found.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e){
	    		if(!selectItem.getText().isEmpty()){
	    	    	String sQueryField = selectItem.getText().trim(); 
	    	    	
	    	    	queryProcess(sQueryField,RecordVector,StaffJTable);  
	    		}
	    	}
	    });
		
		foundAll.addMouseListener(new MouseAdapter(){
	    	public void mouseClicked(MouseEvent e){
	    		
	    	    	String sQueryField = selectItem.getText().trim(); 
	    	    	
	    	    	queryAllProcess(RecordVector,StaffJTable);  
	    		
	    	}
	    });
		
		 back.addMouseListener(new MouseAdapter(){
		    	public void mouseClicked(MouseEvent e){
		    		referRecord.setVisible(false);
		    		choice.setVisible(true);
		    		}
		    	});
		
	}
	
	
	public static void queryProcess(String sQueryField,Vector RecordVector,JTable StaffJTable){
		try{
			String sql=null;
			if(Selectfield.equals("��¼���")){
			sql = "select Id,pId,pChange,pDescription from personnel where ";
			sql = sql + "Id";
			sql = sql + " like ";
			sql = sql + "'" +'%' +sQueryField +'%' +"';";
		
			
			System.out.println("queryProcess(). sql = " + sql);
			}
			else if(Selectfield.equals("Ա����")){
				sql = "select Id,pId,pChange,pDescription from personnel where ";
				sql = sql + "pId";
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
			 RecordVector.clear();    
	while(DbProcess.rs.next()){
				Vector v = new Vector();
				System.out.println(DbProcess.rs.getString("Id"));
				v.add(DbProcess.rs.getString("Id"));
				v.add(DbProcess.rs.getString("pId"));
				v.add(DbProcess.rs.getString("pChange"));
				v.add(DbProcess.rs.getString("pDescription"));
			
				
				RecordVector.add(v);
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
	
	public static void queryAllProcess(Vector RecordVector,JTable StaffJTable)
	{
		try{
			// ������ѯ����
			String sql = "select * from personnel;";
			System.out.println("queryAllProcess(). sql = " + sql);
	
			DbProcess.connect();
			

			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
			
			
			 DbProcess.executeQuery(sql);   //�����ResultSet
		
		//	while(DbProcess.rs.next()){
			//	System.out.println(DbProcess.rs.getString("pName"));
				//}
			
			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
			 RecordVector.clear();    
			while(DbProcess.rs.next()){
				Vector v = new Vector();
				System.out.println(DbProcess.rs.getString("Id"));
				v.add(DbProcess.rs.getString("Id"));
				v.add(DbProcess.rs.getString("pId"));
				v.add(DbProcess.rs.getString("pChange"));
				v.add(DbProcess.rs.getString("pDescription"));
				
				RecordVector.add(v);
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
}
