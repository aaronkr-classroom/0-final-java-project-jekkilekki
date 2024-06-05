package com.market.page;

import com.market.member.Admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AdminLoginDialog extends JDialog {

	JTextField pwField, idField;
	public boolean isLogin = false;
	
	public AdminLoginDialog(JFrame frame, String str) {
		super(frame, "관리자 로그인", true);
		
		Font ft = new Font("함초롬돋움", Font.BOLD, 15);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - 400) / 2, (screenSize.height - 300) / 2);
		setSize(400, 300);
		setLayout(null);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 20, 400, 50);
		add(titlePanel);
		JLabel titleLbl = new JLabel("관리자 로그인");
		titleLbl.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		titlePanel.add(titleLbl);
		
		JPanel idPanel = new JPanel();
		idPanel.setBounds(0, 70, 400, 50);
		add(idPanel);
		JLabel idLbl = new JLabel("아이디: ");
		idLbl.setFont(ft);
		idPanel.add(idLbl);
		idField = new JTextField(10);
		idPanel.add(idField);
		
		JPanel pwPanel = new JPanel();
		pwPanel.setBounds(0, 120, 400, 50);
		add(pwPanel);
		JLabel pwLbl = new JLabel("비밀번호: ");
		pwLbl.setFont(ft);
		pwPanel.add(pwLbl);
		pwField = new JTextField(10);
		pwPanel.add(pwField);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setBounds(0, 170, 400, 50);
		add(btnPanel);
		JLabel okLbl = new JLabel("확인");
		okLbl.setFont(ft);
		JButton okBtn = new JButton();
		okBtn.add(okLbl);
		btnPanel.add(okBtn);
		
		JLabel cancelLbl = new JLabel("취소");
		cancelLbl.setFont(ft);
		JButton cancelBtn = new JButton();
		cancelBtn.add(cancelLbl);
		btnPanel.add(cancelBtn);
		
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin admin = new Admin("", -1);
				System.out.println(idField.getText() + ":" + pwField.getText());
				System.out.println(admin.getId() + ":" + admin.getPw());
				
				if (admin.getId().equals(idField.getText()) && admin.getPw().equals(pwField.getText())) {
					isLogin = true;
					dispose();
				} else {
					JOptionPane.showMessageDialog(okBtn, "관리자 정보가 일치하지 않습니다");
				}
			}
		});
		
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isLogin = false;
				dispose();
			}
		});
	}
}
