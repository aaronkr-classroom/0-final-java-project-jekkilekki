package com.market.page;

import javax.swing.*;
import java.awt.*;

import com.market.member.UserInit;

public class GuestInfoPage extends JPanel {

	public GuestInfoPage(JPanel panel) {
		Font ft = new Font("함초롬돋음", Font.BOLD, 15);
		
		setLayout(null);
		
		Rectangle rect = panel.getBounds();
		System.out.println(rect);
		setPreferredSize(rect.getSize());
		
		JPanel namePanel = new JPanel();
		namePanel.setBounds(0, 100, 1000, 50);
		add(namePanel);
		JLabel nameLbl = new JLabel("이  름: ");
		nameLbl.setFont(ft);
		nameLbl.setBackground(Color.BLUE);
		
		JLabel nameField = new JLabel();
		// nameField.setText("입력된 고객 이름");
		nameField.setText(UserInit.getmUser().getName());
		nameField.setFont(ft);
		
		namePanel.add(nameLbl);
		namePanel.add(nameField);
		
		JPanel phonePanel = new JPanel();
		phonePanel.setBounds(0, 150, 1000, 100);
		add(phonePanel);
		JLabel phoneLbl = new JLabel("연락처: ");
		phoneLbl.setFont(ft);
		JLabel phoneField = new JLabel();
		// phoneField.setText("입력된 고객 연락처");
		phoneField.setText(String.valueOf(UserInit.getmUser().getPhone()));
		phoneField.setFont(ft);
		
		phonePanel.add(phoneLbl);
		phonePanel.add(phoneField);
	}
	
	/*
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(0, 0, 1000, 750);
		frame.setLayout(null);
		
		JPanel mPagePanel = new JPanel();
		mPagePanel.setBounds(0, 150, 1000, 750);
		
		frame.add(mPagePanel);
		mPagePanel.add("고객 정보 확인하기", new GuestInfoPage(mPagePanel));
		
		frame.setVisible(true);
	}
	*/
}
