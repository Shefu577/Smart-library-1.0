package shefu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class FrontPage extends JFrame {

	private JPanel contentPane;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontPage frame = new FrontPage();
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
	public FrontPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 511);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Toolkit toolkit = getToolkit();
		Dimension size=toolkit.getScreenSize();
		setLocation(size.width/2-getWidth()/2,size.height/2-getHeight()/2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x=arg0.getXOnScreen();
				int y=arg0.getYOnScreen();
				FrontPage.this.setLocation(x-xx, y-xy);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				xy=e.getY();
			}
		});
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 513, 511);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(255, 255, 255)));
		lblNewLabel.setBounds(90, 128, 326, 275);
		panel.add(lblNewLabel);
		ImageIcon img =new ImageIcon(this.getClass().getResource("/book.png"));
		lblNewLabel.setIcon(img);
		
		JLabel lblNewLabel_1 = new JLabel("SMART LIBRARY 1.0");
		lblNewLabel_1.setForeground(new Color(245, 222, 179));
		lblNewLabel_1.setBorder(new MatteBorder(9, 9, 9, 9, (Color) new Color(255, 255, 255)));
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel_1.setBounds(21, 44, 469, 71);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("ENTER");
		btnNewButton.setToolTipText("Enter into Library");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Library l = new Library();
				FrontPage.this.setVisible(false);
				l.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
		btnNewButton.setBackground(new Color(255, 99, 71));
		btnNewButton.setBorder(new MatteBorder(6, 6, 6, 6, (Color) new Color(255, 255, 255)));
		btnNewButton.setBounds(156, 414, 186, 71);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("X");
		lblNewLabel_2.setToolTipText("CLOSE");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_2.setBorder(null);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_2.setBounds(472, 11, 18, 22);
		panel.add(lblNewLabel_2);
		
		setUndecorated(true);
		
		
		
		
	}
}
