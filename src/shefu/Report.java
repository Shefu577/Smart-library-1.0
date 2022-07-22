package shefu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Report extends JFrame {

	private JPanel contentPane;
	private JTable table;
	int xx , xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report frame = new Report();
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
	public Report() {
		Connect();
		Report_Load();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 478);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
			int x=arg0.getXOnScreen();
			int y=arg0.getYOnScreen();
			Report.this.setLocation(x-xx, y-xy);
			}
			});
			contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			xx=e.getX();
			xy=e.getY();
			}
			});
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x=arg0.getXOnScreen();
				int y=arg0.getYOnScreen();
				Report.this.setLocation(x-xx, y-xy);
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
		
		JLabel lblNewLabel = new JLabel("REPORT");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setBounds(240, 11, 124, 44);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 352, 540, -297);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setToolTipText("Close");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_5.setBounds(799, 11, 32, 44);
		ImageIcon img =new ImageIcon(this.getClass().getResource("/close.png"));
		lblNewLabel_5.setIcon(img);
		contentPane.add(lblNewLabel_5);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("TABLE");
		scrollPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		scrollPane.setBounds(44, 54, 522, 342);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.orange);
		table.setForeground(Color.white);
		table.setSelectionBackground(Color.black);
		table.setSelectionForeground(Color.yellow);
		table.setFont(new Font("Arial Rounded MT Bold",Font.ITALIC,14));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Defaulter Report");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="SELECT id,name FROM RETURNBOOK WHERE fine>0";
		            pst = con.prepareStatement(query);
		            rs = pst.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		            	
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		ImageIcon img9 =new ImageIcon(this.getClass().getResource("/view.png"));
		btnNewButton_1.setIcon(img9);
		btnNewButton_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_1.setBounds(224, 407, 193, 44);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e1) {
			
			
			try {
				String query="SELECT SUM(fine) FROM RETURNBOOK WHERE fine > 0";
	            pst = con.prepareStatement(query);
	            rs = pst.executeQuery();
	           
	        	if(rs.next()) {
	        		String add1=rs.getString("SUM(fine)");
					txtfine1.setText(add1);		
	        	}
	            } catch (SQLException e ) {
	            JOptionPane.showMessageDialog(null, e);

	        }

			
		}
	});
		ImageIcon img14 =new ImageIcon(this.getClass().getResource("/calculator.png"));
		btnNewButton.setIcon(img14);
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton.setBounds(616, 262, 158, 44);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		panel.setBounds(590, 87, 205, 150);
		panel.setBackground(new Color(176, 196, 222));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Total Fine Calculator");
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(10, 22, 185, 43);
		panel.add(lblNewLabel_1);
		
		txtfine1 = new JTextField();
		txtfine1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtfine1.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtfine1.setBounds(76, 76, 107, 34);
		panel.add(txtfine1);
		txtfine1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("=");
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD, 32));
		lblNewLabel_2.setBounds(34, 76, 46, 27);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Main m=new Main();
				m.setVisible(true);
			}
		});
		ImageIcon img15 =new ImageIcon(this.getClass().getResource("/back-icon.png"));
		btnNewButton_2.setIcon(img15);
		btnNewButton_2.setForeground(Color.DARK_GRAY);
		btnNewButton_2.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		btnNewButton_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_2.setBounds(707, 410, 124, 44);
		
		contentPane.add(btnNewButton_2);
		
		setUndecorated(true);
	}
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JScrollPane scrollPane;
	private JTextField txtfine1;
	

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

	public void Report_Load() {
		int a;
		
		try {
			
			Statement st= con.createStatement();
			rs=st.executeQuery("select * from ISSUEBOOK");
	         	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
