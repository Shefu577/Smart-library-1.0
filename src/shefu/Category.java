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
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class Category extends JFrame {

	private JPanel contentPane;
	private JTextField txtcategory;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Category frame = new Category();
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
	public Category() {
		setUndecorated(true);
		
		Connect();
		Category_Load();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 426);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
			int x=arg0.getXOnScreen();
			int y=arg0.getYOnScreen();
			Category.this.setLocation(x-xx, y-xy);
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
		
		JLabel lblNewLabel = new JLabel("CATEGORY");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setBounds(317, 26, 172, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CATEGORY NAME");
		ImageIcon img7 =new ImageIcon(this.getClass().getResource("/Main Pic1.png"));
		lblNewLabel_1.setIcon(img7);
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(22, 177, 178, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("STATUS");
		ImageIcon img8 =new ImageIcon(this.getClass().getResource("/Category Pic2.png"));
		lblNewLabel_2.setIcon(img8);
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(54, 232, 117, 23);
		contentPane.add(lblNewLabel_2);
		
		txtcategory = new JTextField();
		txtcategory.setToolTipText("Enter Category Name");
		txtcategory.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt1) {
				char n=evt1.getKeyChar();
				if(Character.isDigit(n))
				{
					txtcategory.setEditable(false);
					JOptionPane.showMessageDialog(Category.this,"Enter Aphabets Only");	
				}else {
					txtcategory.setEditable(true);		
				}
			}
		});
		txtcategory.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtcategory.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtcategory.setBounds(201, 172, 227, 32);
		contentPane.add(txtcategory);
		txtcategory.setColumns(10);
		
		JComboBox txtstatus = new JComboBox();
		txtstatus.setToolTipText("Select the status");
		txtstatus.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtstatus.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtstatus.setModel(new DefaultComboBoxModel(new String[] {"Available", "Not Available"}));
		txtstatus.setBounds(201, 227, 227, 32);
		contentPane.add(txtstatus);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img2 =new ImageIcon(this.getClass().getResource("/add.png"));
		btnNewButton.setIcon(img2);
		btnNewButton.setToolTipText("Click to ADD Details");
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 
				String id = txtid.getText();
				String category = txtcategory.getText();
				String status = txtstatus.getSelectedItem().toString();
				
				try {
					String query="select * from CATEGORY where id='"+id+"'";
		            pst = con.prepareStatement(query);
		            rs = pst.executeQuery();
		            if(rs.next()) {
		            	JOptionPane.showMessageDialog(null,"Data exist already");
		            	txtid.setText("");
						txtcategory.setText(""); 
						txtstatus.setSelectedIndex(-1);
		            }
		            else {
					pst = con.prepareStatement("insert into CATEGORY(Id,Category_name,Status) values(?,?,?)");
		            pst.setString(1,id);
					pst.setString(2,category);
					pst.setString(3,status);
					int k = pst.executeUpdate();
					if(k==1)
					{
						JOptionPane.showMessageDialog(Category.this,"Category Created");
						txtid.setText("");
						txtcategory.setText(""); 
						txtstatus.setSelectedIndex(-1);
						txtcategory.requestFocus();						
					}
					else
					{
						JOptionPane.showMessageDialog(Category.this,"Error");
					}
		            }
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}				
			}
		});
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton.setBounds(56, 309, 127, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img3 =new ImageIcon(this.getClass().getResource("/update.png"));
		btnNewButton_1.setIcon(img3);
		btnNewButton_1.setToolTipText("Click to UPDATE Details");
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = txtid.getText();
				String category = txtcategory.getText();
				String status = txtstatus.getSelectedItem().toString();
				
				try {
					pst = con.prepareStatement("update CATEGORY set Category_name=?, Status=? where id=?");
		            pst.setString(1,category);
					pst.setString(2,status);
					pst.setString(3,id);
					int k = pst.executeUpdate();
					if(k==1)
					{
						JOptionPane.showMessageDialog(Category.this,"Category Updated");
						txtid.setText("");
						txtcategory.setText(""); 
						txtstatus.setSelectedIndex(-1);
						txtcategory.requestFocus();	
					}
					else
					{
						JOptionPane.showMessageDialog(Category.this,"Error");
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}				
			}
		});
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_1.setBounds(228, 309, 127, 45);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img4 =new ImageIcon(this.getClass().getResource("/trash.png"));
		btnNewButton_2.setIcon(img4);
		btnNewButton_2.setToolTipText("Click to DELETE Details");
		btnNewButton_2.setBackground(SystemColor.inactiveCaption);
		btnNewButton_2.setForeground(Color.DARK_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = txtid.getText();
								
				try {
					pst = con.prepareStatement("delete from CATEGORY where id=?");
		           
					pst.setString(1,id);
					int k = pst.executeUpdate();
					if(k==1)
					{
						JOptionPane.showMessageDialog(Category.this,"Category Deleted");
						txtid.setText("");
						txtcategory.setText(""); 
						txtstatus.setSelectedIndex(-1);
						txtcategory.requestFocus();	
					}
					else
					{
						JOptionPane.showMessageDialog(Category.this,"Error");
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}					
			}
		});
		btnNewButton_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_2.setBounds(56, 365, 127, 45);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("BACK");
		btnNewButton_3.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img5 =new ImageIcon(this.getClass().getResource("/back-icon.png"));
		btnNewButton_3.setIcon(img5);
		btnNewButton_3.setToolTipText("Click to go back to main menu");
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
		btnNewButton_3.setBounds(228, 365, 127, 45);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("ID");
		ImageIcon img6 =new ImageIcon(this.getClass().getResource("/Category Pic1.png"));
		lblNewLabel_3.setIcon(img6);
		lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setBounds(57, 119, 46, 23);
		contentPane.add(lblNewLabel_3);
		
		
		txtid = new JTextField();
		txtid.setToolTipText("Enter Category ID");
		txtid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(Character.isLetter(c))
				{
					txtid.setEditable(false);
					JOptionPane.showMessageDialog(Category.this,"Enter Numbers Only");
					
				}else {
					txtid.setEditable(true);		
				}
			}
		});
		txtid.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtid.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtid.setBounds(201, 114, 96, 32);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("TABLE");
		scrollPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		scrollPane.setBounds(438, 70, 436, 294);
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
		ImageIcon img1 =new ImageIcon(this.getClass().getResource("/view.png"));
		btnNewButton_4.setIcon(img1);
		btnNewButton_4.setBackground(SystemColor.inactiveCaption);
		btnNewButton_4.setForeground(Color.DARK_GRAY);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query="select * from CATEGORY";
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
		btnNewButton_4.setBounds(585, 370, 164, 35);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setToolTipText("Close");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
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
		lblNewLabel_4.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x=arg0.getXOnScreen();
				int y=arg0.getYOnScreen();
				Category.this.setLocation(x-xx, y-xy);
			}
		});
		ImageIcon img =new ImageIcon(this.getClass().getResource("/close.png"));
		lblNewLabel_4.setIcon(img);
		lblNewLabel_4.setBounds(853, 11, 32, 37);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_5 = new JButton("SEARCH");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="select * from CATEGORY where id=?";
				try {
					
					pst = con.prepareStatement(sql);
					pst.setString(1, txtid.getText());
					rs=pst.executeQuery();
					if(rs.next()) {
						
						String add1=rs.getString("category_name");
						txtcategory.setText(add1);
						String add2=rs.getString("status");
						txtstatus.setSelectedItem(add2);
						rs.close();
						pst.close();	
					}
					else {
						
						JOptionPane.showMessageDialog(null, "Category ID not Found");
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
		btnNewButton_5.setBounds(303, 114, 125, 32);
		contentPane.add(btnNewButton_5);
		
		
	}
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txtid;
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
	
	public void Category_Load() {
		int c;
		
		try {
			
			Statement st= con.createStatement();
			rs=st.executeQuery("select * from CATEGORY");		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
	
