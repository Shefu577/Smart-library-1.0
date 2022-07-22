 package shefu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class Library extends JFrame {

	private JPanel contentPane;
	int xx,xy;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Library frame = new Library();
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
	public Library() 
	{
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 379);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
			int x=arg0.getXOnScreen();
			int y=arg0.getYOnScreen();
			Library.this.setLocation(x-xx, y-xy);
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
		
		JLabel lblNewLabel = new JLabel("SMART LIBRARY 1.0");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setBounds(165, 25, 286, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setToolTipText("Close");
		lblNewLabel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
				public void mouseDragged(MouseEvent arg0){
					int x=arg0.getXOnScreen();
					int y=arg0.getYOnScreen();
					Library.this.setLocation(x-xx, y-xy);
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
		lblNewLabel_1.setBounds(539, 11, 36, 47);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("ADMIN LOGIN");
		btnNewButton.setToolTipText("Click to go to Admin Login Form");
		ImageIcon img1 =new ImageIcon(this.getClass().getResource("/FrontPage.png"));
		btnNewButton.setIcon(img1);
		btnNewButton.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin a = new AdminLogin();
				Library.this.setVisible(false);
				a.setVisible(true);
			}
		});
		btnNewButton.setBounds(59, 249, 217, 47);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LIBRARIAN LOGIN");
		btnNewButton_1.setToolTipText("Click to go to Librarian Login Form");
		ImageIcon img2 =new ImageIcon(this.getClass().getResource("/FrontPage.png"));
		btnNewButton_1.setIcon(img2);
		btnNewButton_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login l = new login();
				Library.this.setVisible(false);
				l.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(322, 249, 217, 47);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("EXIT");
		btnNewButton_2.setToolTipText("Click here to EXIT.");
		btnNewButton_2.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		btnNewButton_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_2.setForeground(Color.DARK_GRAY);
		btnNewButton_2.setBackground(SystemColor.inactiveCaption);
		btnNewButton_2.setBounds(460, 316, 115, 36);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		ImageIcon img3 =new ImageIcon(this.getClass().getResource("/exit.png"));
		btnNewButton_2.setIcon(img3);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		ImageIcon img4 =new ImageIcon(this.getClass().getResource("/admin.png"));
		lblNewLabel_2.setIcon(img4);
		lblNewLabel_2.setBounds(100, 99, 152, 128);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		ImageIcon img5 =new ImageIcon(this.getClass().getResource("/Teacher-icon.png"));
		lblNewLabel_3.setIcon(img5);
		lblNewLabel_3.setBounds(364, 110, 152, 119);
		contentPane.add(lblNewLabel_3);
		
		
		
		
		
		
	}
}