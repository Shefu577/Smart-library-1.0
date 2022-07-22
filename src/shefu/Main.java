package shefu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JToggleButton;

public class Main extends JFrame {
	
	private JPanel contentPane;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() 
	{
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 527);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
			int x=arg0.getXOnScreen();
			int y=arg0.getYOnScreen();
			Main.this.setLocation(x-xx, y-xy);
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
		
		JButton btnNewButton = new JButton("CATEGORY");
		btnNewButton.setToolTipText("click here for Category Section");
		btnNewButton.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img1 =new ImageIcon(this.getClass().getResource("/Main Pic1.png"));
		btnNewButton.setIcon(img1);
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Category c = new Category();
				Main.this.setVisible(false);
				c.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(102, 78, 183, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("AUTHOR");
		btnNewButton_1.setToolTipText("click here for Author Section");
		btnNewButton_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img2 =new ImageIcon(this.getClass().getResource("/Main Pic2.png"));
		btnNewButton_1.setIcon(img2);
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Author a = new Author();
				Main.this.setVisible(false);
				a.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(102, 125, 183, 36);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("PUBLISHER");
		btnNewButton_2.setToolTipText("click here for Publisher Section");
		btnNewButton_2.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img3 =new ImageIcon(this.getClass().getResource("/MainPic3.png"));
		btnNewButton_2.setIcon(img3);
		btnNewButton_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_2.setForeground(Color.DARK_GRAY);
		btnNewButton_2.setBackground(SystemColor.inactiveCaption);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Publisher p = new Publisher();
				Main.this.setVisible(false);
				p.setVisible(true);	
				
			}
			
		});
		btnNewButton_2.setBounds(102, 172, 183, 36);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("BOOK");
		btnNewButton_3.setToolTipText("click here for Book Section");
		btnNewButton_3.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img4 =new ImageIcon(this.getClass().getResource("/Main Pic4.png"));
		btnNewButton_3.setIcon(img4);
		btnNewButton_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_3.setBackground(SystemColor.inactiveCaption);
		btnNewButton_3.setForeground(Color.DARK_GRAY);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Book b = new Book();
				Main.this.setVisible(false);
				b.setVisible(true);
				
			}
		});
		btnNewButton_3.setBounds(102, 219, 183, 36);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("MEMBER");
		btnNewButton_4.setToolTipText("click here for Member Section");
		btnNewButton_4.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img5 =new ImageIcon(this.getClass().getResource("/Main Pic5.png"));
		btnNewButton_4.setIcon(img5);
		btnNewButton_4.setBackground(SystemColor.inactiveCaption);
		btnNewButton_4.setForeground(Color.DARK_GRAY);
		btnNewButton_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Member m = new Member();
				Main.this.setVisible(false);
				m.setVisible(true);
				
			}
		});
		btnNewButton_4.setBounds(102, 266, 183, 36);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("ISSUE BOOK");
		btnNewButton_5.setToolTipText("Click here for Issue Book Section");
		btnNewButton_5.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img6 =new ImageIcon(this.getClass().getResource("/MainPic6.png"));
		btnNewButton_5.setIcon(img6);
		btnNewButton_5.setForeground(Color.DARK_GRAY);
		btnNewButton_5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_5.setBackground(SystemColor.inactiveCaption);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Issuebook i = new Issuebook();
				Main.this.setVisible(false);
				i.setVisible(true);
				
			}
		});
		btnNewButton_5.setBounds(103, 313, 182, 36);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("RETURN BOOK");
		btnNewButton_6.setToolTipText("click here for Return Book Section");
		btnNewButton_6.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img7 =new ImageIcon(this.getClass().getResource("/MainPic7.png"));
		btnNewButton_6.setIcon(img7);
		btnNewButton_6.setForeground(Color.DARK_GRAY);
		btnNewButton_6.setBackground(SystemColor.inactiveCaption);
		btnNewButton_6.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Returnbook r = new Returnbook();
				Main.this.setVisible(false);
				r.setVisible(true);
				
			}	
		});
		btnNewButton_6.setBounds(102, 360, 183, 36);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("LOGOUT");
		btnNewButton_7.setToolTipText("Click here for logout");
		btnNewButton_7.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img8 =new ImageIcon(this.getClass().getResource("/MainPic8.png"));
		btnNewButton_7.setIcon(img8);
		btnNewButton_7.setForeground(Color.DARK_GRAY);
		btnNewButton_7.setBackground(SystemColor.inactiveCaption);
		btnNewButton_7.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				login l = new login();
				Main.this.setVisible(false);
				l.setVisible(true);
				
			}	
		});
		btnNewButton_7.setBounds(102, 457, 183, 36);
		contentPane.add(btnNewButton_7);
		
		JLabel lblNewLabel = new JLabel("LIBRARIAN SECTION");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setBounds(52, 31, 301, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setToolTipText("Close");
		lblNewLabel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
				public void mouseDragged(MouseEvent arg0){
					int x=arg0.getXOnScreen();
					int y=arg0.getYOnScreen();
					Main.this.setLocation(x-xx, y-xy);
				}
		});
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
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
		ImageIcon img =new ImageIcon(this.getClass().getResource("/close.png"));
		lblNewLabel_1.setIcon(img);
		lblNewLabel_1.setBounds(361, 11, 36, 47);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_8 = new JButton("REPORT");
		btnNewButton_8.setToolTipText("click here to view the report");
		btnNewButton_8.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img15 =new ImageIcon(this.getClass().getResource("/view.png"));
		btnNewButton_8.setIcon(img15);
		btnNewButton_8.setForeground(Color.DARK_GRAY);
		btnNewButton_8.setBackground(SystemColor.inactiveCaption);
		btnNewButton_8.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Report r = new Report();
				Main.this.setVisible(false);
				r.setVisible(true);
				
			}
		});
		btnNewButton_8.setBounds(102, 407, 183, 39);
		contentPane.add(btnNewButton_8);
		
		
	}
}
