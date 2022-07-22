package shefu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

public class Author extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtphone;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Author frame = new Author();
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
	public Author() {
		setUndecorated(true);
		Connect();
		Author_Load();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 476);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
			int x=arg0.getXOnScreen();
			int y=arg0.getYOnScreen();
			Author.this.setLocation(x-xx, y-xy);
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
		
		JLabel lblNewLabel = new JLabel("AUTHOR");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setBounds(327, 21, 137, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		ImageIcon img =new ImageIcon(this.getClass().getResource("/Category Pic1.png"));
		lblNewLabel_1.setIcon(img);
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(20, 111, 63, 32);
		contentPane.add(lblNewLabel_1);
		
		txtid = new JTextField();
		txtid.setToolTipText("Enter Author ID");
		txtid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(Character.isLetter(c))
				{
					txtid.setEditable(false);
					JOptionPane.showMessageDialog(Author.this,"Enter Numbers Only");
					
				}else {
					txtid.setEditable(true);		
				}
			}
		});
		txtid.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtid.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtid.setBounds(138, 111, 83, 32);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("NAME");
		ImageIcon img1 =new ImageIcon(this.getClass().getResource("/Author Name.png"));
		lblNewLabel_2.setIcon(img1);
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(20, 157, 96, 26);
		contentPane.add(lblNewLabel_2);
		
		txtname = new JTextField();
		txtname.setToolTipText("Enter Author Name");
		txtname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt1) {
				char n=evt1.getKeyChar();
				if(Character.isDigit(n))
				{
					txtname.setEditable(false);
					JOptionPane.showMessageDialog(Author.this,"Enter Aphabets Only");	
				}else {
					txtname.setEditable(true);		
				}
			}
		});
		txtname.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtname.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtname.setBounds(138, 154, 214, 32);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("ADDRESS");
		ImageIcon img2 =new ImageIcon(this.getClass().getResource("/Author Address.png"));
		lblNewLabel_3.setIcon(img2);
		lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setBounds(20, 208, 102, 32);
		contentPane.add(lblNewLabel_3);
		
		JTextArea txtaddress = new JTextArea();
		txtaddress.setToolTipText("Enter Author Address");
		txtaddress.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtaddress.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtaddress.setBounds(138, 197, 214, 60);
		contentPane.add(txtaddress);
		
		JLabel lblNewLabel_4 = new JLabel("PHONE");
		ImageIcon img3 =new ImageIcon(this.getClass().getResource("/Author Call.png"));
		lblNewLabel_4.setIcon(img3);
		lblNewLabel_4.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_4.setBounds(20, 268, 91, 32);
		contentPane.add(lblNewLabel_4);
		JLabel lblNewLabel_6 = new JLabel("");
		txtphone = new JTextField();
		txtphone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent evt2) {
				{
					String PATTERN="^[0-9]{10,10}$";
					Pattern patt=Pattern.compile(PATTERN);
					Matcher match=patt.matcher(txtphone.getText());
					if(!match.matches())
					{lblNewLabel_6.setText("incorrect");
					}else {lblNewLabel_6.setText(" ");}
					
				}
			}
			
		});
		txtphone.setToolTipText("Enter Author Phone no.");
		txtphone.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtphone.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtphone.setBounds(138, 268, 214, 32);
		contentPane.add(txtphone);
		txtphone.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setToolTipText("Click to ADD details");
		btnNewButton.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img4 =new ImageIcon(this.getClass().getResource("/add.png"));
		btnNewButton.setIcon(img4);
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = txtid.getText();
				String name = txtname.getText();
				String address = txtaddress.getText();
				String phone = txtphone.getText();
				
				try {
					String query="select * from AUTHOR where id='"+id+"'";
		            pst = con.prepareStatement(query);
		            rs = pst.executeQuery();
		            if(rs.next()) {
		            	JOptionPane.showMessageDialog(null,"Data exist already");
						txtid.setText("");
						txtname.setText(""); 
						txtaddress.setText(""); 
						txtphone.setText(""); 
		            }
		            else {
					pst = con.prepareStatement("insert into AUTHOR(id,name,address,phone) values(?,?,?,?)");
		            pst.setString(1,id);
					pst.setString(2,name);
					pst.setString(3,address);
					pst.setString(4,phone);
					int k = pst.executeUpdate();
					
					if(k==1)
					{
						JOptionPane.showMessageDialog(Author.this,"Author Created");
						
						txtid.setText("");
						txtname.setText(""); 
						txtaddress.setText(""); 
						txtphone.setText(""); 
						txtname.requestFocus();	
					}
					else
					{
						JOptionPane.showMessageDialog(Author.this,"Error");
					}
		            }
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
					
			}
		});
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton.setBounds(46, 355, 127, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.setToolTipText("Click to UPDATE details ");
		btnNewButton_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img5 =new ImageIcon(this.getClass().getResource("/update.png"));
		btnNewButton_1.setIcon(img5);
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = txtid.getText();
				String name = txtname.getText();
				String address = txtaddress.getText();
				String phone = txtphone.getText();
				
				try {
					pst = con.prepareStatement("update AUTHOR set name=?, address=?, phone=? where id=?");
		            pst.setString(1,name);
					pst.setString(2,address);
					pst.setString(3,phone);
					pst.setString(4,id);
					int k = pst.executeUpdate();
					
					if(k==1)
					{
						JOptionPane.showMessageDialog(Author.this,"Author Updated");
						txtid.setText("");
						txtname.setText(""); 
						txtaddress.setText(""); 
						txtphone.setText(""); 
						txtname.requestFocus();							
					}
					else
					{
						JOptionPane.showMessageDialog(Author.this,"Error");
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}						
			}
		});
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_1.setBounds(209, 355, 127, 45);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.setToolTipText("Click to DELETE details");
		btnNewButton_2.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img6 =new ImageIcon(this.getClass().getResource("/trash.png"));
		btnNewButton_2.setIcon(img6);
		btnNewButton_2.setForeground(Color.DARK_GRAY);
		btnNewButton_2.setBackground(SystemColor.inactiveCaption);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                String id = txtid.getText();
				
				
				try {
					pst = con.prepareStatement("delete from AUTHOR where id=?");
		           
					pst.setString(1,id);
					int k = pst.executeUpdate();
					if(k==1)
					{
						JOptionPane.showMessageDialog(Author.this,"Author Deleted");
						txtid.setText("");
						txtname.setText(""); 
						txtaddress.setText(""); 
						txtphone.setText(""); 
						txtname.requestFocus();							
					}
					else
					{
						JOptionPane.showMessageDialog(Author.this,"Error");
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_2.setBounds(46, 411, 127, 45);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("BACK");
		btnNewButton_3.setToolTipText("Click to go back to main menu");
		btnNewButton_3.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img7 =new ImageIcon(this.getClass().getResource("/back-icon.png"));
		btnNewButton_3.setIcon(img7);
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
		btnNewButton_3.setBounds(209, 411, 127, 45);
		contentPane.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("TABLE");
		scrollPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		scrollPane.setBounds(362, 76, 481, 324);
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
		ImageIcon img8 =new ImageIcon(this.getClass().getResource("/view.png"));
		btnNewButton_4.setIcon(img8);
		btnNewButton_4.setForeground(Color.DARK_GRAY);
		btnNewButton_4.setBackground(SystemColor.inactiveCaption);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query="select * from AUTHOR";
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
		btnNewButton_4.setBounds(532, 416, 164, 35);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setToolTipText("Close");
		lblNewLabel_5.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x=arg0.getXOnScreen();
				int y=arg0.getYOnScreen();
				Author.this.setLocation(x-xx, y-xy);
			}
		});
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				xy=e.getY(); 
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		ImageIcon img9 =new ImageIcon(this.getClass().getResource("/close.png"));
		lblNewLabel_5.setIcon(img9);
		lblNewLabel_5.setBounds(823, 11, 32, 42);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_5 = new JButton("SEARCH");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="select * from AUTHOR where id=?";
				try {
					
					pst = con.prepareStatement(sql);
					pst.setString(1, txtid.getText());
					rs=pst.executeQuery();
					if(rs.next()) {
						
						String add1=rs.getString("name");
						txtname.setText(add1);
						String add2=rs.getString("address");
						txtaddress.setText(add2);
						String add3=rs.getString("phone");
						txtphone.setText(add3);	
						rs.close();
						pst.close();	
					}
					else {
						
						JOptionPane.showMessageDialog(null, "Author ID not Found");
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
		btnNewButton_5.setBounds(227, 111, 125, 32);
		contentPane.add(btnNewButton_5);
		
		
		lblNewLabel_6.setBounds(138, 307, 83, 14);
		contentPane.add(lblNewLabel_6);
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
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	public void Author_Load() {
		int a;
		
		try {
			
			Statement st= con.createStatement();
			rs=st.executeQuery("select * from AUTHOR");
	         	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
