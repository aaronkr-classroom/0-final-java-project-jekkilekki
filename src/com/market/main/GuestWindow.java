package com.market.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.market.member.UserInit;

public class GuestWindow extends JFrame {

	public GuestWindow(String title, int x, int y, int width, int height) {
		initContainer(title, x, y, width, height);
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(new ImageIcon("./images/shop.png").getImage());
	}
	
	public void initContainer(String title, int x, int y, int width, int height) {
		setTitle(title);
		setBounds(x, y, width, height);
		setLayout(null);
		
		Font ft = new Font("함초롬돋음", Font.BOLD, 15);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - 1000) / 2, 
				(screenSize.height - 750) / 2);
		JPanel userPanel = new JPanel();
		userPanel.setBounds(0, 100, 1000, 256);
		
		ImageIcon imgIcon = new ImageIcon("./images/user.png");
		imgIcon.setImage(imgIcon.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH));
		JLabel userLbl = new JLabel(imgIcon);
		userPanel.add(userLbl);
		add(userPanel);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 350, 1000, 50);
		add(titlePanel);
		
		JPanel namePanel = new JPanel();
		namePanel.setBounds(0, 400, 1000, 50);
		add(namePanel);
		
		JLabel nameLbl = new JLabel("이 름: ");
		nameLbl.setFont(ft);
		namePanel.add(nameLbl);
		
		JTextField nameField = new JTextField(10);
		nameField.setFont(ft);
		namePanel.add(nameField);
		
		JPanel phonePanel = new JPanel();
		phonePanel.setBounds(0, 450, 1000, 50);
		add(phonePanel);
		
		JLabel phoneLbl = new JLabel("연락처: ");
		phoneLbl.setFont(ft);
		phonePanel.add(phoneLbl);
		
		JTextField phoneField = new JTextField(10);
		phoneField.setFont(ft);
		phonePanel.add(phoneField);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 500, 1000, 100);
		add(buttonPanel);
		
		JLabel buttonLbl = new JLabel("쇼핑하기", 
				new ImageIcon("./images/shop.png"), JLabel.LEFT);
		buttonLbl.setFont(ft);
		JButton enterBtn = new JButton();
		enterBtn.add(buttonLbl);
		buttonPanel.add(enterBtn);
		
		// Chp15
		enterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel msg = new JLabel("고객 정보를 입력하세요.");
				msg.setFont(ft);
				
				if (nameField.getText().isEmpty() ||
					phoneField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(enterBtn,
							msg, "고객 정보",
							JOptionPane.ERROR_MESSAGE);
				} else {
					UserInit.init(nameField.getText(), Integer.parseInt(phoneField.getText()));
					dispose(); // 대화상자 닫기
					
					new MainWindow("온라인 서점", 0, 0, 1000, 750);
				}
			}
		});
	}
	
	/*
	public static void main(String[] args) {
		new GuestWindow("고객 정보 입력", 0, 0, 1000, 750);
	}
	*/
}
