package shefu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Returnbook extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtbook;
	private JTextField txtrdate;
	private JTextField txtday;
	private JTextField txtfine;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Returnbook frame = new Returnbook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Returnbook() {
		setUndecorated(true);
		Connect();
	    Returnbook_Load();
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 530);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
			int x=arg0.getXOnScreen();
			int y=arg0.getYOnScreen();
			Returnbook.this.setLocation(x-xx, y-xy);
			}
			});
			contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			xx=e.getX();
			xy=e.getY();
			}
			});
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Toolkit toolkit = getToolkit();
		Dimension size=toolkit.getScreenSize();
		setLocation(size.width/2-getWidth()/2,size.height/2-getHeight()/2);
		
		JLabel lblNewLabel = new JLabel("RETURN BOOK");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setBounds(312, 22, 222, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MEMBER ID");
		ImageIcon img5 =new ImageIcon(this.getClass().getResource("/Category Pic1.png"));
		lblNewLabel_1.setIcon(img5);
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(14, 79, 130, 32);
		contentPane.add(lblNewLabel_1);
		
		txtid = new JTextField();
		txtid.setToolTipText("Enter Member ID");
		txtid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(Character.isLetter(c))
				{
					txtid.setEditable(false);
					JOptionPane.showMessageDialog(Returnbook.this,"Enter Numbers Only");
					
				}else {
					txtid.setEditable(true);		
				}
			}
		});
		txtid.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtid.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtid.setBounds(181, 79, 84, 32);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("MEMBER NAME");
		ImageIcon img6 =new ImageIcon(this.getClass().getResource("/Author Name.png"));
		lblNewLabel_2.setIcon(img6);
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(14, 121, 164, 33);
		contentPane.add(lblNewLabel_2);
		
		txtname = new JTextField();
		txtname.setToolTipText("Enter Member Name");
		txtname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt1) {
				char n=evt1.getKeyChar();
				if(Character.isDigit(n))
				{
					txtname.setEditable(false);
					JOptionPane.showMessageDialog(Returnbook.this,"Enter Aphabets Only");	
				}else {
					txtname.setEditable(true);		
				}
			}
		});
		txtname.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtname.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtname.setBounds(180, 122, 218, 32);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("BOOK");
		ImageIcon img7 =new ImageIcon(this.getClass().getResource("/Main Pic4.png"));
		lblNewLabel_3.setIcon(img7);
		lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setBounds(14, 164, 104, 34);
		contentPane.add(lblNewLabel_3);
		
		txtbook = new JTextField();
		txtbook.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt1) {
				char n=evt1.getKeyChar();
				if(Character.isDigit(n))
				{
					txtbook.setEditable(false);
					JOptionPane.showMessageDialog(Returnbook.this,"Enter Aphabets Only");	
				}else {
					txtbook.setEditable(true);		
				}
			}
		});
		txtbook.setToolTipText("Enter Book Name");
		txtbook.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtbook.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtbook.setBounds(181, 165, 217, 32);
		contentPane.add(txtbook);
		txtbook.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("RETURN DATE");
		ImageIcon img8 =new ImageIcon(this.getClass().getResource("/Return Date.png"));
		lblNewLabel_4.setIcon(img8);
		lblNewLabel_4.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_4.setBounds(14, 209, 151, 31);
		contentPane.add(lblNewLabel_4);
		
		txtrdate = new JTextField();
		txtrdate.setToolTipText("Enter Return Date");
		txtrdate.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtrdate.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtrdate.setBounds(181, 208, 217, 32);
		contentPane.add(txtrdate);
		txtrdate.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("DAYS ELAP");
		ImageIcon img9 =new ImageIcon(this.getClass().getResource("/Days Elap.png"));
		lblNewLabel_5.setIcon(img9);
		lblNewLabel_5.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_5.setBounds(14, 251, 130, 38);
		contentPane.add(lblNewLabel_5);
		
		txtday = new JTextField();
		txtday.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(Character.isLetter(c))
				{
					txtday.setEditable(false);
					JOptionPane.showMessageDialog(Returnbook.this,"Enter Numbers Only");
					
				}else {
					txtday.setEditable(true);		
				}
			}
		});
		txtday.setToolTipText("Enter Days Elap");
		txtday.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtday.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtday.setBounds(181, 254, 217, 32);
		contentPane.add(txtday);
		txtday.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("FINE");
		ImageIcon img10 =new ImageIcon(this.getClass().getResource("/fine.png"));
		lblNewLabel_6.setIcon(img10);
		lblNewLabel_6.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_6.setBounds(14, 300, 71, 32);
		contentPane.add(lblNewLabel_6);
		
		txtfine = new JTextField();
		txtfine.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(Character.isLetter(c))
				{
					txtfine.setEditable(false);
					JOptionPane.showMessageDialog(Returnbook.this,"Enter Numbers Only");
					
				}else {
					txtfine.setEditable(true);		
				}
			}
		});
		txtfine.setToolTipText("Enter Fine");
		txtfine.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtfine.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtfine.setBounds(181, 300, 63, 32);
		contentPane.add(txtfine);
		txtfine.setColumns(10);
		
		JButton btnNewButton = new JButton("RETURN");
		btnNewButton.setToolTipText("Click to ADD Details");
		btnNewButton.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img =new ImageIcon(this.getClass().getResource("/add.png"));
		btnNewButton.setIcon(img);
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = txtid.getText();
				String name = txtname.getText();
				String book = txtbook.getText();
				String retdate = txtrdate.getText();
				String dayselap = txtday.getText();
				String fine = txtfine.getText();
				
				try {
					String query="select * from RETURNBOOK where id='"+id+"'";
		            pst = con.prepareStatement(query);
		            rs = pst.executeQuery();
		            if(rs.next()) {
		            	JOptionPane.showMessageDialog(null,"Data exist already");
		            	txtid.setText("");
						txtname.setText(""); 
						txtbook.setText("");
						txtrdate.setText("");
						txtday.setText("");
						txtfine.setText("");
		            }
		            else {
					pst = con.prepareStatement("insert into RETURNBOOK(id,name,book,retdate,dayselap,fine) values(?,?,?,?,?,?)");
		            pst.setString(1,id);
					pst.setString(2,name);
					pst.setString(3,book);
					pst.setString(4,retdate);
					pst.setString(5,dayselap);
					pst.setString(6,fine);
					
					int k = pst.executeUpdate();
					
					if(k==1)
					{
						JOptionPane.showMessageDialog(Returnbook.this,"Book Returned");
						
						txtid.setText("");
						txtname.setText(""); 
						txtbook.setText("");
						txtrdate.setText("");
						txtday.setText("");
						txtfine.setText("");
						txtname.requestFocus();						
					}
					else
					{
						JOptionPane.showMessageDialog(Returnbook.this,"Error");
					}
		            }
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}	
			}
		});
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton.setBounds(38, 370, 127, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.setToolTipText("Click to UPDATE Details");
		btnNewButton_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img1 =new ImageIcon(this.getClass().getResource("/update.png"));
		btnNewButton_1.setIcon(img1);
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = txtid.getText();
				String name = txtname.getText();
				String book = txtbook.getText();
				String retdate = txtrdate.getText();
				String dayselap = txtday.getText();
				String fine = txtfine.getText();
				
				try {
					pst = con.prepareStatement("update RETURNBOOK set name=?, book=?, retdate=?, dayselap=?, fine= ? where id=?");
						pst.setString(1,name);
						pst.setString(2,book);
						pst.setString(3,retdate);
						pst.setString(4,dayselap);
						pst.setString(5,fine);
					    pst.setString(6,id);
					int k = pst.executeUpdate();
					
					if(k==1)
					{
                        JOptionPane.showMessageDialog(Returnbook.this,"Returnbook Updated");
						
                        txtid.setText("");
						txtname.setText(""); 
						txtbook.setText("");
						txtrdate.setText("");
						txtday.setText("");
						txtfine.setText("");
						txtname.requestFocus();							
					}
					else
					{
						JOptionPane.showMessageDialog(Returnbook.this,"Error");
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}		
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_1.setBounds(196, 370, 127, 45);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.setToolTipText("Click to DELETE Details");
		btnNewButton_2.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img2 =new ImageIcon(this.getClass().getResource("/trash.png"));
		btnNewButton_2.setIcon(img2);
		btnNewButton_2.setForeground(Color.DARK_GRAY);
		btnNewButton_2.setBackground(SystemColor.inactiveCaption);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                
                String id = txtid.getText();
				
				try {
					pst = con.prepareStatement("delete from ISSUEBOOK where id=?");
		           
					pst.setString(1,id);
					int k = pst.executeUpdate();
					if(k==1)
					{
						JOptionPane.showMessageDialog(Returnbook.this,"IssueBook Deleted");
						txtid.setText("");
						txtname.setText(""); 
						txtbook.setText("");
						txtrdate.setText("");
						txtday.setText("");
						txtfine.setText("");
						txtname.requestFocus();						
					}
					else
					{
						JOptionPane.showMessageDialog(Returnbook.this,"Error");
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				} 
				
			}
		});
		btnNewButton_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_2.setBounds(38, 426, 127, 45);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("BACK");
		btnNewButton_3.setToolTipText("Click to go back to main menu");
		btnNewButton_3.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img3 =new ImageIcon(this.getClass().getResource("/back-icon.png"));
		btnNewButton_3.setIcon(img3);
		btnNewButton_3.setForeground(Color.DARK_GRAY);
		btnNewButton_3.setBackground(SystemColor.inactiveCaption);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Main m=new Main();
				m.setVisible(true);
				
			}
		});
		btnNewButton_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_3.setBounds(196, 426, 127, 45);
		contentPane.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("TABLE");
		scrollPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		scrollPane.setBounds(415, 60, 456, 355);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.orange);
		table.setForeground(Color.white);
		table.setSelectionBackground(Color.black);
		table.setSelectionForeground(Color.yellow);
		table.setFont(new Font("Arial Rounded MT Bold",Font.ITALIC,14));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_4 = new JButton("VIEW DATA");
		btnNewButton_4.setToolTipText("Click to VIEW TABLE");
		btnNewButton_4.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img4 =new ImageIcon(this.getClass().getResource("/view.png"));
		btnNewButton_4.setIcon(img4);
		btnNewButton_4.setForeground(Color.DARK_GRAY);
		btnNewButton_4.setBackground(SystemColor.inactiveCaption);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query="select * from RETURNBOOK";
		            pst = con.prepareStatement(query);
		            rs = pst.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		            	
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_4.setBounds(561, 431, 164, 35);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setToolTipText("Close");
		lblNewLabel_8.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x=arg0.getXOnScreen();
				int y=arg0.getYOnScreen();
				Returnbook.this.setLocation(x-xx, y-xy);
			}
		});
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				xy=e.getY();
			}
		});
		ImageIcon img11 =new ImageIcon(this.getClass().getResource("/close.png"));
		lblNewLabel_8.setIcon(img11);
		lblNewLabel_8.setBounds(851, 11, 33, 38);
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton_6 = new JButton("SEARCH");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="select * from ISSUEBOOK where id=?";
				try {
					
					pst = con.prepareStatement(sql);
					pst.setString(1, txtid.getText());
					rs=pst.executeQuery();
					if(rs.next()) {
						
						String add1=rs.getString("name");
						txtname.setText(add1);
						String add2=rs.getString("book");
						txtbook.setText(add2);
						
						
						rs.close();
						pst.close();	
					}
					else {
						
						JOptionPane.showMessageDialog(null, "IssueBook ID not Found");
					}					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					
				}
			}
		});
		btnNewButton_6.setForeground(Color.DARK_GRAY);
		ImageIcon img16 =new ImageIcon(this.getClass().getResource("/Zoom-icon.png"));
		btnNewButton_6.setIcon(img16);
		btnNewButton_6.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		btnNewButton_6.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_6.setBounds(275, 79, 125, 32);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("CALCULATE");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int dayselap, fine;
				 dayselap = Integer.parseInt(txtday.getText());			
				
				try {
				 if(dayselap>0) {
					
					fine = dayselap*10;
					
				}
				else
				{
					fine = 0;
					
				}
				
				txtfine.setText(String.valueOf(fine));
				
				} catch(NumberFormatException e1) {
					e1.printStackTrace();
				}
		   }
		});
		btnNewButton_5.setForeground(Color.DARK_GRAY);
		ImageIcon img15 =new ImageIcon(this.getClass().getResource("/calculator.png"));
		btnNewButton_5.setIcon(img15);
		btnNewButton_5.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		btnNewButton_5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_5.setBounds(254, 300, 151, 32);
		contentPane.add(btnNewButton_5);
	}
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTable table;
	
	public void Connect()
	
	{
		
		try{
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public void Returnbook_Load() {
		int r;
		
		try {
			
			Statement st= con.createStatement();
			rs=st.executeQuery("select * from ISSUEBOOK");
	         	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
