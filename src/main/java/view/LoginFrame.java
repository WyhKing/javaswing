package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import util.ChkCode;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2468719791156400022L;

	int xOld = 0;
	int yOld = 0;
	private JTextField accountField;
	private JPasswordField pwdField;
	private JTextField chkCodeField;
	private JLabel loginBGLable;
	private JButton loginButton;
	private JLabel chkCodeLabel;
	private JButton exitButton;
	private String chkCode;

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/images/logo.jpg")));
		
		
		getContentPane().setBackground(Color.WHITE);
		setTitle("登录窗口");
		setSize(600, 400);
		setUndecorated(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		accountField = new JTextField("请输入账号");
		accountField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (accountField.getText().trim().equals("请输入账号"))
				{
					accountField.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (accountField.getText().trim().equals(""))
				{
					accountField.setText("请输入账号");
				}
			}
		});
		accountField.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		accountField.setBounds(357, 137, 200, 39);
		getContentPane().add(accountField);
		accountField.setColumns(10);
		
		pwdField = new JPasswordField("请输入密码");
		pwdField.setEchoChar((char)0);
		pwdField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (pwdField.getText().trim().equals("请输入密码"))
				{
					pwdField.setText("");
					pwdField.setEchoChar('*');
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (pwdField.getText().trim().equals(""))
				{
					pwdField.setText("请输入密码");
					pwdField.setEchoChar((char)0);
				}
			}
		});
		pwdField.setColumns(10);
		pwdField.setBounds(357, 200, 200, 39);
		getContentPane().add(pwdField);
		
		chkCodeField = new JTextField("请输入验证码");
		chkCodeField.setBounds(357, 249, 100, 39);
		getContentPane().add(chkCodeField);
		chkCodeField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (chkCodeField.getText().trim().equals("请输入验证码"))
				{
					chkCodeField.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (chkCodeField.getText().trim().equals(""))
				{
					chkCodeField.setText("请输入验证码");
				}
			}
		});
		
		chkCodeLabel = new JLabel();
		Object[] obj = ChkCode.createImage();
		chkCode = (String) obj[0];
		System.out.println(chkCode);
		chkCodeLabel.setIcon(new ImageIcon((BufferedImage)obj[1]));
		chkCodeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				chkCodeLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				chkCodeLabel.setCursor(new Cursor(Cursor.MOVE_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Object[] obj = ChkCode.createImage();
				chkCode = (String) obj[0];
				chkCodeLabel.setIcon(new ImageIcon((BufferedImage)obj[1]));
				System.out.println(chkCode);
			}
			
		});
		chkCodeLabel.setBounds(467, 249, 90, 39);
		getContentPane().add(chkCodeLabel);
		
		loginButton = new JButton("");
		loginButton.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/loginButton.jpg")));
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				loginButton.setCursor(new Cursor(Cursor.MOVE_CURSOR));
			}
		});
		loginButton.setFont(new Font("楷体", Font.BOLD, 14));
		loginButton.setForeground(Color.WHITE);
		loginButton.setBackground(Color.GREEN);
		loginButton.setBounds(357, 323, 200, 39);
		getContentPane().add(loginButton);
		
		JLabel themeLabel = new JLabel("WELCOME");
		themeLabel.setForeground(Color.RED);
		themeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		themeLabel.setFont(new Font("楷体", Font.BOLD, 20));
		themeLabel.setBounds(357, 64, 200, 39);
		getContentPane().add(themeLabel);
		
		loginBGLable = new JLabel("               ");
		
		loginBGLable.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/loginLeft.jpg")));
		loginBGLable.setBounds(0, 0, 320, 400);
		getContentPane().add(loginBGLable);
		this.addEventHandler();
		this.setVisible(true);
		setFocusTraversalPolicyProvider(true);
		getContentPane().setFocusTraversalPolicyProvider(true);
		
		exitButton = new JButton();
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(LoginFrame.this, "确定退出吗？","退出提示", 2);
				if (0 == result)
				{
					System.exit(0);
				}else {
					return;
				}
				
			}
		});
		exitButton.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/exit.jpg")));
		exitButton.setBounds(570, 10, 20, 20);
		getContentPane().add(exitButton);
		this.getContentPane().requestFocus();

	}

	private void addEventHandler() {
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				xOld = e.getX();
				yOld = e.getY();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				LoginFrame.this.requestFocusInWindow();
			}
			
			
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				int xOnScreen = e.getXOnScreen();
				int yOnScreen = e.getYOnScreen();
				int xx = xOnScreen - xOld;
				int yy = yOnScreen - yOld;
				LoginFrame.this.setLocation(xx, yy);
			}
		});
	}
}
