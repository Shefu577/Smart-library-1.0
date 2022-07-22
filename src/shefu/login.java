package shefu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JCheckBox;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField txtusername;
	private JPasswordField txtpassword;
	int xx,xy;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 388);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
			int x=arg0.getXOnScreen();
			int y=arg0.getYOnScreen();
			login.this.setLocation(x-xx, y-xy);
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
		contentPane.setForeground(new Color(192, 192, 192));
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		
		Toolkit toolkit = getToolkit();
		Dimension size=toolkit.getScreenSize();
		setLocation(size.width/2-getWidth()/2,size.height/2-getHeight()/2);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setBounds(69, 202, 129, 31);
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		ImageIcon img =new ImageIcon(this.getClass().getResource("/Login Pic 1.png"));
		lblNewLabel.setIcon(img);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setBounds(69, 244, 129, 24);
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		ImageIcon img1 =new ImageIcon(this.getClass().getResource("/Login Pic 2.png"));
		lblNewLabel_1.setIcon(img1);
		contentPane.add(lblNewLabel_1);
		
		txtusername = new JTextField();
		txtusername.setToolTipText("Enter Username");
		txtusername.setBounds(245, 201, 213, 32);
		txtusername.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtusername.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		contentPane.add(txtusername);
		txtusername.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setToolTipText("Click here to Login");
		btnNewButton.setBounds(86, 320, 130, 38);
		btnNewButton.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img3 =new ImageIcon(this.getClass().getResource("/FrontPage.png"));
		btnNewButton.setIcon(img3);
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = txtusername.getText();
				String password = txtpassword.getText();
				
				boolean status = login.validate(username, password);
				if(status) 
				{
					dispose();
					Main m = new Main();
					m.setVisible(true);	
					txtusername.setText("");
					txtpassword.setText("");
				}
				
				else
				{
					JOptionPane.showMessageDialog(login.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
					txtusername.setText("");
					txtpassword.setText("");
					txtusername.requestFocus();
				}	
			}			
		});
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setToolTipText("Click here to Exit");
		btnNewButton_1.setBounds(314, 322, 130, 35);
		btnNewButton_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img4 =new ImageIcon(this.getClass().getResource("/exit.png"));
		btnNewButton_1.setIcon(img4);
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Library l = new Library();
				login.this.setVisible(false);
				l.setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setBounds(119, 25, 302, 31);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 28));
		contentPane.add(lblNewLabel_2);
		
		txtpassword = new JPasswordField();
		txtpassword.setToolTipText("Enter Password");
		txtpassword.setBounds(245, 244, 213, 32);
		txtpassword.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtpassword.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		contentPane.add(txtpassword);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		ImageIcon img5 =new ImageIcon(this.getClass().getResource("/Login Pic 3.png"));
		lblNewLabel_3.setIcon(img5);
		lblNewLabel_3.setBounds(194, 67, 136, 114);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
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
				login.this.setLocation(x-xx, y-xy);
			}
		});
		ImageIcon img6 =new ImageIcon(this.getClass().getResource("/close.png"));
		lblNewLabel_4.setIcon(img6);
		lblNewLabel_4.setBounds(485, 11, 34, 45);
		contentPane.add(lblNewLabel_4);
		
		JCheckBox c = new JCheckBox("SHOW PASSWORD");
		c.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		c.setOpaque(false);
		c.setForeground(Color.BLACK);
		c.setBackground(Color.WHITE);
		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (c.isSelected())
				{
				 txtpassword.setEchoChar((char)0);	
				}
				else
				{
				 txtpassword.setEchoChar('*');
				}
			}
		});
		c.setBounds(245, 283, 213, 23);
		contentPane.add(c);
	}
	
	public static boolean validate(String username,String password){
		
		boolean status=false;
		try{
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			PreparedStatement ps=con.prepareStatement("select * from AdminSection where username=? and password=?");
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}
