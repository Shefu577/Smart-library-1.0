 package shefu;

import java.awt.BorderLayout;
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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

public class Issuebook extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtbook;
	private JTextField txtdate;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Issuebook frame = new Issuebook();
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
	public Issuebook() {
		setUndecorated(true);
		Connect();
	    Issuebook_Load();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 472);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
			int x=arg0.getXOnScreen();
			int y=arg0.getYOnScreen();
			Issuebook.this.setLocation(x-xx, y-xy);
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
		
		JLabel lblNewLabel = new JLabel("ISSUE BOOK");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setBounds(299, 11, 179, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MEMBER ID");
		ImageIcon img5 =new ImageIcon(this.getClass().getResource("/Category Pic1.png"));
		lblNewLabel_1.setIcon(img5);
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(10, 95, 140, 32);
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
					JOptionPane.showMessageDialog(Issuebook.this,"Enter Numbers Only");
					
				}else {
					txtid.setEditable(true);		
				}
			}
		});
		txtid.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtid.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtid.setBounds(175, 95, 92, 32);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("MEMBER NAME");
		ImageIcon img6 =new ImageIcon(this.getClass().getResource("/Author Name.png"));
		lblNewLabel_2.setIcon(img6);
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(10, 143, 153, 23);
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
					JOptionPane.showMessageDialog(Issuebook.this,"Enter Aphabets Only");	
				}else {
					txtname.setEditable(true);		
				}
			}
		});
		txtname.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtname.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtname.setBounds(175, 138, 228, 32);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("BOOK");
		ImageIcon img7 =new ImageIcon(this.getClass().getResource("/Main Pic4.png"));
		lblNewLabel_3.setIcon(img7);
		lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setBounds(10, 181, 114, 32);
		contentPane.add(lblNewLabel_3);
		
		txtbook = new JTextField();
		txtbook.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt1) {
				char n=evt1.getKeyChar();
				if(Character.isDigit(n))
				{
					txtbook.setEditable(false);
					JOptionPane.showMessageDialog(Issuebook.this,"Enter Aphabets Only");	
				}else {
					txtbook.setEditable(true);		
				}
			}
		});
		txtbook.setToolTipText("Enter Book Name");
		txtbook.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtbook.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtbook.setBounds(175, 181, 228, 32);
		contentPane.add(txtbook);
		txtbook.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ISSUE DATE");
		ImageIcon img8 =new ImageIcon(this.getClass().getResource("/date.png"));
		lblNewLabel_4.setIcon(img8);
		lblNewLabel_4.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_4.setBounds(10, 224, 140, 32);
		contentPane.add(lblNewLabel_4);
		
		txtdate = new JTextField();
		txtdate.setToolTipText("Enter Issued Date");
		txtdate.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtdate.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtdate.setBounds(175, 224, 228, 32);
		contentPane.add(txtdate);
		txtdate.setColumns(10);
		
		
		JButton btnNewButton = new JButton("ISSUE");
		btnNewButton.setToolTipText("Click to ISSUE book");
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
				String issdate = txtdate.getText();
				String rdate = txtret_date.getText();
				
				
				try {
					String query="select * from ISSUEBOOK where id='"+id+"'";
		            pst = con.prepareStatement(query);
		            rs = pst.executeQuery();
		            if(rs.next()) {
		            	JOptionPane.showMessageDialog(null,"Data exist already");
		            	txtid.setText("");
						txtname.setText(""); 
						txtbook.setText("");
						txtdate.setText("");
						txtret_date.setText("");
		            }
		            else {
					pst = con.prepareStatement("insert into ISSUEBOOK(id,name,book,issdate,rdate) values(?,?,?,?,?)");
		            pst.setString(1,id);
					pst.setString(2,name);
					pst.setString(3,book);
					pst.setString(4,issdate);
					pst.setString(5,rdate);
					
					int k = pst.executeUpdate();
					
					if(k==1)
					{
						JOptionPane.showMessageDialog(Issuebook.this,"Book issued");
						
						txtid.setText("");
						txtname.setText(""); 
						txtbook.setText("");
						txtdate.setText("");
						txtret_date.setText("");
						txtname.requestFocus();						
					}
					else
					{
						JOptionPane.showMessageDialog(Issuebook.this,"Error");
					}
		            }
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}	
			}
		});
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton.setBounds(42, 338, 127, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.setToolTipText("Click to UPDATE Details");
		btnNewButton_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img1 =new ImageIcon(this.getClass().getResource("/update.png"));
		btnNewButton_1.setIcon(img1);
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = txtid.getText();
				String name = txtname.getText();
				String book = txtbook.getText();
				String issdate = txtdate.getText();
				String rdate = txtret_date.getText();
				
				try {
					pst = con.prepareStatement("update ISSUEBOOK set name=?, book=?, issdate=?, rdate=? where id=?");
						pst.setString(1,name);
						pst.setString(2,book);
						pst.setString(3,issdate);
					    pst.setString(4,rdate);
					    pst.setString(5,id);
					    
					int k = pst.executeUpdate();
					
					if(k==1)
					{
                        JOptionPane.showMessageDialog(Issuebook.this,"Issuebook Updated");
						
						txtid.setText("");
						txtname.setText(""); 
						txtbook.setText("");
						txtdate.setText("");
						txtret_date.setText("");
						txtname.requestFocus();								
					}
					else
					{
						JOptionPane.showMessageDialog(Issuebook.this,"Error");
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}		
			}	
		});
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_1.setBounds(214, 338, 127, 45);
		contentPane.add(btnNewButton_1);
		
		
		JButton btnNewButton_3 = new JButton("BACK");
		btnNewButton_3.setToolTipText("Click to go back to main menu");
		btnNewButton_3.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img3 =new ImageIcon(this.getClass().getResource("/back-icon.png"));
		btnNewButton_3.setIcon(img3);
		btnNewButton_3.setBackground(SystemColor.inactiveCaption);
		btnNewButton_3.setForeground(Color.DARK_GRAY);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Main m=new Main();
				m.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_3.setBounds(126, 404, 127, 45);
		contentPane.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("TABLE");
		scrollPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		scrollPane.setBounds(413, 74, 463, 337);
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
					String query="select * from ISSUEBOOK";
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
		btnNewButton_4.setBounds(558, 422, 164, 35);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setToolTipText("Close");
		lblNewLabel_6.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
				public void mouseDragged(MouseEvent arg0) {
					int x=arg0.getXOnScreen();
					int y=arg0.getYOnScreen();
					Issuebook.this.setLocation(x-xx, y-xy);
			}
		});
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
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
		lblNewLabel_6.setIcon(img11);
		lblNewLabel_6.setBounds(856, 11, 32, 32);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton_5 = new JButton("SEARCH");
		btnNewButton_5.addActionListener(new ActionListener() {
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
						String add3=rs.getString("issdate");
						txtdate.setText(add3);
						String add4=rs.getString("rdate");
						txtret_date.setText(add4);
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
		btnNewButton_5.setForeground(Color.DARK_GRAY);
		ImageIcon img10 =new ImageIcon(this.getClass().getResource("/Zoom-icon.png"));
		btnNewButton_5.setIcon(img10);
		btnNewButton_5.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		btnNewButton_5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_5.setBounds(278, 95, 125, 32);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_5 = new JLabel("RETURN DATE");
		ImageIcon img9 =new ImageIcon(this.getClass().getResource("/Return Date.png"));
		lblNewLabel_5.setIcon(img9);
		lblNewLabel_5.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_5.setBounds(10, 267, 153, 32);
		contentPane.add(lblNewLabel_5);
		
		txtret_date = new JTextField();
		txtret_date.setToolTipText("Enter return date");
		txtret_date.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtret_date.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtret_date.setBounds(175, 267, 228, 32);
		contentPane.add(txtret_date);
		txtret_date.setColumns(10);
	}
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTable table;
	private JTextField txtret_date;
	
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
	
	public void Issuebook_Load() {
		int i;
		
		try {
			
			Statement st= con.createStatement();
			rs=st.executeQuery("select * from ISSUEBOOK");
	         	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
