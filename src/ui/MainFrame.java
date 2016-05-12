package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import rmi.RemoteHelper;

public class MainFrame extends JFrame {
	// private JTextArea textArea;
	// private JLabel resultLabel;
	private JPanel contentPane;
	private JTextArea textArea_1;
	private JTextArea textArea_2;
	private JTextArea textArea;
	private String user_ID="Admin";
	private String fileName="code";

	public MainFrame() {
		// 创建窗体
		// JFrame frame = new JFrame("BF Client");
		// frame.setLayout(new BorderLayout());
		//
		// JMenuBar menuBar = new JMenuBar();
		// JMenu fileMenu = new JMenu("File");
		// menuBar.add(fileMenu);
		// JMenuItem newMenuItem = new JMenuItem("New");
		// fileMenu.add(newMenuItem);
		// JMenuItem openMenuItem = new JMenuItem("Open");
		// fileMenu.add(openMenuItem);
		// JMenuItem saveMenuItem = new JMenuItem("Save");
		// fileMenu.add(saveMenuItem);
		// JMenuItem runMenuItem = new JMenuItem("Run");
		// fileMenu.add(runMenuItem);
		// frame.setJMenuBar(menuBar);
		//
		// newMenuItem.addActionListener(new MenuItemActionListener());
		// openMenuItem.addActionListener(new MenuItemActionListener());
		// saveMenuItem.addActionListener(new SaveActionListener());
		// runMenuItem.addActionListener(new MenuItemActionListener());
		//
		// textArea = new JTextArea();
		// textArea.setMargin(new Insets(10, 10, 10, 10));
		// textArea.setBackground(Color.LIGHT_GRAY);
		// frame.add(textArea, BorderLayout.CENTER);
		//
		// // 显示结果
		// resultLabel = new JLabel();
		// resultLabel.setText("result");
		// frame.add(resultLabel, BorderLayout.SOUTH);
		//
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setSize(500, 400);
		// frame.setLocation(400, 200);
		// frame.setVisible(true);
		// }
		//
		// class MenuItemActionListener implements ActionListener {
		// /**
		// * 子菜单响应事件
		// */
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// String cmd = e.getActionCommand();
		// if (cmd.equals("Open")) {
		// textArea.setText("Open");
		// } else if (cmd.equals("Save")) {
		// textArea.setText("Save");
		// } else if (cmd.equals("Run")) {
		// resultLabel.setText("Hello, result");
		// }
		// }
		// }
		//
		// class SaveActionListener implements ActionListener {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// String code = textArea.getText();
		// try {
		// RemoteHelper.getInstance().getIOService().writeFile(code, "admin",
		// "code");
		// } catch (RemoteException e1) {
		// e1.printStackTrace();
		// }
		// }
		//
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);

		// 设置菜单
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// Login：register,login,logout
		JMenu mnLogin = new JMenu("");
		mnLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		mnLogin.setIcon(new ImageIcon("me.png"));
		menuBar.add(mnLogin);

		JMenuItem mntmRegister = new JMenuItem("Register");
		mntmRegister.setMnemonic('R');
		mnLogin.add(mntmRegister);
		mntmRegister.addActionListener(new RegisterActionListener());

		JMenuItem mntmLogin = new JMenuItem("Login");
		mnLogin.add(mntmLogin);
		mntmLogin.setMnemonic('L');
		mntmLogin.addActionListener(new LoginActionListener());

		JMenuItem mntmLogout = new JMenuItem("Logout");
		mnLogin.add(mntmLogout);
		mntmLogout.setMnemonic('L');
		;

		// File:new,open,save,exit
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmNew = new JMenuItem("New", 'N');
		mntmNew.setIcon(new ImageIcon(MainFrame.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
		mnFile.add(mntmNew);

		JMenuItem mntmOpen = new JMenuItem("Open", 'O');
		mntmOpen.setIcon(
				new ImageIcon(MainFrame.class.getResource("/com/sun/java/swing/plaf/windows/icons/TreeOpen.gif")));
		mnFile.add(mntmOpen);

		JMenuItem mntmSave = new JMenuItem("Save", 'S');
		mntmSave.setIcon(
				new ImageIcon(MainFrame.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		mntmSave.addActionListener(new SaveActionListener());
		mnFile.add(mntmSave);

		JMenuItem mntmExit = new JMenuItem("Exit", 'E');
		mntmExit.setIcon(new ImageIcon(MainFrame.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		mnFile.add(mntmExit);

		// Run:execute
		JMenu mnRun = new JMenu("Run");
		menuBar.add(mnRun);

		JMenuItem mntmExecute = new JMenuItem("Execute");
		mntmExecute.setIcon(new ImageIcon(
				MainFrame.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));
		mnRun.add(mntmExecute);
		mntmExecute.addActionListener(new ExecuteActionListener());

		// version
		JMenu mnVersion = new JMenu("Version");
		menuBar.add(mnVersion);

		JMenuItem menuItem = new JMenuItem("2016.5.9.19:22:16");
		menuItem.setIcon(new ImageIcon(
				MainFrame.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-more-details.png")));
		mnVersion.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		ImageIcon user = new ImageIcon("user.jpg");

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setPreferredSize(new Dimension(300, (int) (this.getHeight() * 0.3)));
		panel_1.setLayout(null);

		// 输入区域
		textArea_1 = new JTextArea("Please input here...");
		textArea_1.setLineWrap(true);
		// textArea_1.addFocusListener(new FocusAdapter(){
		// public void focusGained(FocusEvent e){
		// textArea_1.setText("");
		// }
		// public void focusLost(FocusEvent e){
		// textArea_1.setText("Please input here...");
		// }
		// });
		JScrollPane scrollPane_1 = new JScrollPane(textArea_1);
		scrollPane_1.setBounds(0, 0, (int) (this.getWidth() * 0.5), (int) (this.getHeight() * 0.3));
		panel_1.add(scrollPane_1);

		// 结果区域
		textArea_2 = new JTextArea("Please wait a second...");
		textArea_2.setLineWrap(true);
		// textArea_2.addFocusListener(new FocusAdapter(){
		// public void focusGained(FocusEvent e){
		// textArea_2.setText("");
		// }
		// public void focusLost(FocusEvent e){
		// textArea_2.setText("Please wait a second...");
		// }
		// });
		JScrollPane scrollPane_2 = new JScrollPane(textArea_2);
		scrollPane_2.setBounds((int) (this.getWidth() * 0.5), 0, (int) (this.getWidth() * 0.5),
				(int) (this.getHeight() * 0.3));
		panel_1.add(scrollPane_2);

		// 代码区域
		textArea = new JTextArea("Please code here...");
		textArea.setLineWrap(true);
		// textArea.addFocusListener(new FocusAdapter(){
		// public void focusGained(FocusEvent e){
		// textArea.setText("");
		// }
		//
		// });
		JScrollPane scrollPane = new JScrollPane(textArea);
		contentPane.add(scrollPane, BorderLayout.CENTER);

	}

	//显示注册窗口
	class RegisterActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JDialog jd = new JDialog();
			jd.setBounds(320, 180, 300, 200);
			jd.setTitle("Login");
			jd.getContentPane().setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

			jd.add(new JLabel("UserID"));
			JTextField userID = new JTextField(16);
			jd.add(userID);
			jd.add(new JLabel("Password"));
			JPasswordField password = new JPasswordField(16);
			jd.add(password);
			jd.add(new JLabel("Password Again"));
			JPasswordField password2 = new JPasswordField(16);
			jd.add(password2);

			JButton jb1 = new JButton("OK");
			JButton jb2 = new JButton("Cancel");
			jb1.setSize(100, 80);
			jb2.setSize(100, 80);
			jd.add(jb1);
			jd.add(jb2);
			jb1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jd.setVisible(false);
					user_ID = userID.getText();
					String pass_word = new String(password.getPassword());
					try {
						if (RemoteHelper.getInstance().getUserService().login(user_ID, pass_word)) {
							JOptionPane.showMessageDialog(null, "Register success!", "Register Success",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "Account already exists, register failed!",
									"Register Failed", JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}

				}
			});
			jb2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jd.setVisible(false);
				}
			});

			jd.setModal(true);// 确保弹出的窗口在其他窗口前面
			jd.setVisible(true);
		}

	}
	
	// 显示登录窗口
	class LoginActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JDialog jd = new JDialog();
			jd.setBounds(320, 180, 300, 200);
			jd.setTitle("Login");
			jd.getContentPane().setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

			jd.add(new JLabel("UserID"));
			JTextField userID = new JTextField(16);
			jd.add(userID);
			jd.add(new JLabel("Password"));
			JPasswordField password = new JPasswordField(16);
			jd.add(password);

			JButton jb1 = new JButton("OK");
			JButton jb2 = new JButton("Cancel");
			jb1.setSize(100, 80);
			jb2.setSize(100, 80);
			jd.add(jb1);
			jd.add(jb2);
			jb1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jd.setVisible(false);
					user_ID = userID.getText();
					String pass_word = new String(password.getPassword());
					try {
						if (RemoteHelper.getInstance().getUserService().login(user_ID, pass_word)) {
							JOptionPane.showMessageDialog(null, "Login success!", "Login Success",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "Account or password error, login failed",
									"Login Failed", JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}

				}
			});
			jb2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jd.setVisible(false);
				}
			});

			jd.setModal(true);// 确保弹出的窗口在其他窗口前面
			jd.setVisible(true);
		}

	}

	// 保存程序
	class SaveActionListener implements ActionListener {
			
		public void actionPerformed(ActionEvent e) {
		String code = textArea.getText();
		try {
			 if (RemoteHelper.getInstance().getIOService().writeFile(code,user_ID,fileName)){
			       JOptionPane.showMessageDialog(null, "Save success!", "Save Success",
							JOptionPane.INFORMATION_MESSAGE);	 
			 }else{
				   JOptionPane.showMessageDialog(null, "File already exists, save failed!",
							"Save Failed", JOptionPane.INFORMATION_MESSAGE);
			 }
		} catch (RemoteException e1) {
			 e1.printStackTrace();
			 }
		}
	}
	
	//运行程序
    class ExecuteActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		
			String code= textArea.getText();
			String param =textArea_1.getText();
		
			try {
				String result = RemoteHelper.getInstance().getExecuteService().execute(code, param);
				textArea_2.setText(result);
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			
		}
    	
    }


}
