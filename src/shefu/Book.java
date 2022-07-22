package shefu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Book extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtauthor;
	private JTextField txtpublisher;
	private JTextField txtcontent;
	private JTextField txtpage;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Book frame = new Book();
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
	public Book() {
		setUndecorated(true);
		Connect();
		Book_Load();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 961, 554);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
			int x=arg0.getXOnScreen();
			int y=arg0.getYOnScreen();
			Book.this.setLocation(x-xx, y-xy);
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
		
		JLabel lblNewLabel = new JLabel("BOOK");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 29));
		lblNewLabel.setBounds(369, 24, 101, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BOOK ID");
		ImageIcon img5 =new ImageIcon(this.getClass().getResource("/Category Pic1.png"));
		lblNewLabel_1.setIcon(img5);
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(23, 79, 117, 26);
		contentPane.add(lblNewLabel_1);
		
		txtid = new JTextField();
		txtid.setToolTipText("Enter Book ID");
		txtid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(Character.isLetter(c))
				{
					txtid.setEditable(false);
					JOptionPane.showMessageDialog(Book.this,"Enter Numbers Only");
					
				}else {
					txtid.setEditable(true);		
				}
			}
		});
		txtid.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtid.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtid.setBounds(164, 76, 93, 32);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("NAME");
		ImageIcon img6 =new ImageIcon(this.getClass().getResource("/Author Name.png"));
		lblNewLabel_2.setIcon(img6);
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(23, 122, 91, 26);
		contentPane.add(lblNewLabel_2);
		
		txtname = new JTextField();
		txtname.setToolTipText("Enter Book Name");
		txtname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt1) {
				char n=evt1.getKeyChar();
				if(Character.isDigit(n))
				{
					txtname.setEditable(false);
					JOptionPane.showMessageDialog(Book.this,"Enter Aphabets Only");	
				}else {
					txtname.setEditable(true);		
				}
			}
		});
		txtname.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtname.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtname.setBounds(164, 116, 228, 32);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CATEGORY");
		ImageIcon img7 =new ImageIcon(this.getClass().getResource("/Main Pic1.png"));
		lblNewLabel_3.setIcon(img7);
		lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setBounds(23, 162, 117, 20);
		contentPane.add(lblNewLabel_3);
		
		JComboBox txtcategory = new JComboBox();
		txtcategory.setToolTipText("Select Book Category");
		txtcategory.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtcategory.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtcategory.setModel(new DefaultComboBoxModel(new String[] {"Romance", "Action and Adventure", "Classics", "Comic Book", "Mystery", "Fantasy", "Historical Fiction", "Horror", "Literary Fiction", "Science Fiction (Sci-Fi)", "Short Stories", "Thrillers", "Biographies", "Cookbooks", "Essays", "Education"}));
		txtcategory.setBounds(164, 159, 228, 32);
		contentPane.add(txtcategory);
		
		JLabel lblNewLabel_4 = new JLabel("AUTHOR");
		ImageIcon img8 =new ImageIcon(this.getClass().getResource("/Main Pic2.png"));
		lblNewLabel_4.setIcon(img8);
		lblNewLabel_4.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_4.setBounds(23, 208, 117, 23);
		contentPane.add(lblNewLabel_4);
		
		txtauthor = new JTextField();
		txtauthor.setToolTipText("Enter Author Name");
		txtauthor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt1) {
				char n=evt1.getKeyChar();
				if(Character.isDigit(n))
				{
					txtauthor.setEditable(false);
					JOptionPane.showMessageDialog(Book.this,"Enter Aphabets Only");	
				}else {
					txtauthor.setEditable(true);		
				}
			}
		});
		txtauthor.setToolTipText("Enter Book Author");
		txtauthor.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtauthor.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtauthor.setBounds(164, 199, 228, 32);
		contentPane.add(txtauthor);
		txtauthor.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("PUBLISHER");
		ImageIcon img9 =new ImageIcon(this.getClass().getResource("/MainPic3.png"));
		lblNewLabel_5.setIcon(img9);
		lblNewLabel_5.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_5.setBounds(23, 241, 131, 34);
		contentPane.add(lblNewLabel_5);
		
		txtpublisher = new JTextField();
		txtname.setToolTipText("Enter Publisher Name");
		txtpublisher.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt1) {
				char n=evt1.getKeyChar();
				if(Character.isDigit(n))
				{
					txtpublisher.setEditable(false);
					JOptionPane.showMessageDialog(Book.this,"Enter Aphabets Only");	
				}else {
					txtpublisher.setEditable(true);		
				}
			}
		});
		txtpublisher.setToolTipText("Enter Book Publisher");
		txtpublisher.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtpublisher.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtpublisher.setBounds(164, 242, 228, 32);
		contentPane.add(txtpublisher);
		txtpublisher.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("CONTENTS");
		ImageIcon img10 =new ImageIcon(this.getClass().getResource("/Book Content.png"));
		lblNewLabel_6.setIcon(img10);
		lblNewLabel_6.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_6.setBounds(23, 286, 117, 28);
		contentPane.add(lblNewLabel_6);
		
		txtcontent = new JTextField();
		txtcontent.setToolTipText("Enter Book Content");
		txtcontent.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt1) {
				char n=evt1.getKeyChar();
				if(Character.isDigit(n))
				{
					txtcontent.setEditable(false);
					JOptionPane.showMessageDialog(Book.this,"Enter Aphabets Only");	
				}else {
					txtcontent.setEditable(true);		
				}
			}
		});
		txtcontent.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtcontent.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtcontent.setBounds(164, 285, 228, 32);
		contentPane.add(txtcontent);
		txtcontent.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("NO OF PAGES");
		ImageIcon img11 =new ImageIcon(this.getClass().getResource("/Book Pages.png"));
		lblNewLabel_7.setIcon(img11);
		lblNewLabel_7.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_7.setBounds(23, 330, 141, 28);
		contentPane.add(lblNewLabel_7);
		
		txtpage = new JTextField();
		txtpage.setToolTipText("Enter no. of pages");
		txtpage.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(Character.isLetter(c))
				{
					txtpage.setEditable(false);
					JOptionPane.showMessageDialog(Book.this,"Enter Numbers Only");
					
				}else {
					txtpage.setEditable(true);		
				}
			}
		});
		txtpage.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtpage.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtpage.setBounds(164, 328, 228, 32);
		contentPane.add(txtpage);
		txtpage.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD");
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
				String category = txtcategory.getSelectedItem().toString();
				String author = txtauthor.getText();
				String publisher = txtpublisher.getText();
				String content = txtcontent.getText();
				String pages = txtpage.getText();
				String edition = txtedition.getText();
				
				try {
					String query="select * from BOOK where id='"+id+"'";
		            pst = con.prepareStatement(query);
		            rs = pst.executeQuery();
		            if(rs.next()) {
		            	JOptionPane.showMessageDialog(null,"Data exist already");
		            	txtid.setText("");
						txtname.setText(""); 
						txtcategory.setSelectedIndex(-1);
						txtauthor.setText(""); 
						txtpublisher.setText("");
						txtcontent.setText("");
						txtpage.setText("");
						txtedition.setText("");
		            }
		            else {
					pst = con.prepareStatement("insert into BOOK(id,name,category,author,publisher,content,pages,edition) values(?,?,?,?,?,?,?,?)");
		            pst.setString(1,id);
					pst.setString(2,name);
					pst.setString(3,category);
					pst.setString(4,author);
					pst.setString(5,publisher);
					pst.setString(6,content);
					pst.setString(7,pages);
					pst.setString(8,edition);
					
					int k = pst.executeUpdate();
					
					if(k==1)
					{
						JOptionPane.showMessageDialog(Book.this,"Book Created");
						
						txtid.setText("");
						txtname.setText(""); 
						txtcategory.setSelectedIndex(-1);
						txtauthor.setText(""); 
						txtpublisher.setText("");
						txtcontent.setText("");
						txtpage.setText("");
						txtedition.setText("");
						txtname.requestFocus();						
					}
					else
					{
						JOptionPane.showMessageDialog(Book.this,"Error");
					}
		            }
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}	
			}
		});
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton.setBounds(48, 434, 127, 45);
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
				String category = txtcategory.getSelectedItem().toString();
				String author = txtauthor.getText();
				String publisher = txtpublisher.getText();
				String content = txtcontent.getText();
				String pages = txtpage.getText();
				String edition = txtedition.getText();
				
				try {
					pst = con.prepareStatement("update BOOK set name=?, category=?, author=?, publisher=?, content=?, pages=?, edition=? where id=?");
					 	pst.setString(1,name);
						pst.setString(2,category);
						pst.setString(3,author);
						pst.setString(4,publisher);
						pst.setString(5,content);
						pst.setString(6,pages);
						pst.setString(7,edition);
					    pst.setString(8,id);
					int k = pst.executeUpdate();
					
					if(k==1)
					{
						JOptionPane.showMessageDialog(Book.this,"Book Updated");
						txtid.setText("");
						txtname.setText(""); 
						txtcategory.setSelectedIndex(-1);
						txtauthor.setText(""); 
						txtpublisher.setText("");
						txtcontent.setText("");
						txtpage.setText("");
						txtedition.setText("");
						txtname.requestFocus();								
					}
					else
					{
						JOptionPane.showMessageDialog(Book.this,"Error");
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}		
			}
		});
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_1.setBounds(228, 434, 127, 45);
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
						pst = con.prepareStatement("delete from BOOK where id=?");
			           
						pst.setString(1,id);
						int k = pst.executeUpdate();
						if(k==1)
						{
							JOptionPane.showMessageDialog(Book.this,"Book Deleted");
							txtid.setText("");
							txtname.setText(""); 
							txtcategory.setSelectedIndex(-1);
							txtauthor.setText(""); 
							txtpublisher.setText("");
							txtcontent.setText("");
							txtpage.setText("");
							txtedition.setText("");
							txtname.requestFocus();						
						}
						else
						{
							JOptionPane.showMessageDialog(Book.this,"Error");
						}
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					} 
			}
		});
		btnNewButton_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_2.setBounds(48, 490, 127, 45);
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
		btnNewButton_3.setBounds(228, 490, 127, 45);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_8 = new JLabel("EDITION");
		ImageIcon img12 =new ImageIcon(this.getClass().getResource("/Book Edition.png"));
		lblNewLabel_8.setIcon(img12);
		lblNewLabel_8.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_8.setBounds(20, 374, 120, 32);
		contentPane.add(lblNewLabel_8);
		
		txtedition = new JTextField();
		txtedition.setToolTipText("Enter Book Edition");
		txtedition.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(Character.isLetter(c))
				{
					txtedition.setEditable(false);
					JOptionPane.showMessageDialog(Book.this,"Enter Numbers Only");
					
				}else {
					txtedition.setEditable(true);		
				}
			}
		});
		txtedition.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtedition.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtedition.setBounds(164, 374, 228, 32);
		contentPane.add(txtedition);
		txtedition.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("TABLE");
		scrollPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		scrollPane.setBounds(405, 69, 530, 413);
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
					String query="select * from BOOK";
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
		btnNewButton_4.setBounds(593, 495, 164, 35);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setToolTipText("Close");
		lblNewLabel_9.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x=arg0.getXOnScreen();
				int y=arg0.getYOnScreen();
				Book.this.setLocation(x-xx, y-xy);
			}
		});
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
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
		ImageIcon img13 =new ImageIcon(this.getClass().getResource("/close.png"));
		lblNewLabel_9.setIcon(img13);
		lblNewLabel_9.setBounds(919, 11, 32, 47);
		contentPane.add(lblNewLabel_9);
		
		JButton btnNewButton_5 = new JButton("SEARCH");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="select * from BOOK where id=?";
				try {
					
					pst = con.prepareStatement(sql);
					pst.setString(1, txtid.getText());
					rs=pst.executeQuery();
					if(rs.next()) {
						
						String add1=rs.getString("name");
						txtname.setText(add1);
						String add2=rs.getString("category");
						txtcategory.setSelectedItem(add2);
						String add3=rs.getString("author");
						txtauthor.setText(add3);
						String add4=rs.getString("publisher");
						txtpublisher.setText(add4);	
						String add5=rs.getString("content");
						txtcontent.setText(add5);	
						String add6=rs.getString("pages");
						txtpage.setText(add6);	
						String add7=rs.getString("edition");
						txtedition.setText(add7);
						rs.close();
						pst.close();	
					}
					else {
						
						JOptionPane.showMessageDialog(null, "Book ID not Found");
					}					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					
				}
			}
		});
		btnNewButton_5.setForeground(Color.DARK_GRAY);
		ImageIcon img14 =new ImageIcon(this.getClass().getResource("/Zoom-icon.png"));
		btnNewButton_5.setIcon(img14);
		btnNewButton_5.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		btnNewButton_5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_5.setBounds(267, 76, 125, 32);
		contentPane.add(btnNewButton_5);
	}
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txtedition;
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
	
	public void Book_Load() {
		int b;
		
		try {
			
			Statement st= con.createStatement();
			rs=st.executeQuery("select * from BOOK");
	         	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
