package com.market.page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import com.market.cart.Cart;
import com.market.member.UserInit;

public class CartShippingPage extends JPanel {
	
	Cart mCart;
	JPanel shippingPanel;
	JPanel radioPanel;
	
	public CartShippingPage(JPanel panel, Cart cart) {
		
		Font ft = new Font("함초롬돋음", Font.BOLD, 15);
		setLayout(null);
		
		Rectangle rect = panel.getBounds();
		System.out.println(rect);
		setPreferredSize(rect.getSize());
		
		radioPanel = new JPanel();
		radioPanel.setBounds(300, 0, 700, 50);
		radioPanel.setLayout(new FlowLayout());
		add(radioPanel);
		
		JLabel radioLbl = new JLabel("배송받을 분은 고객 정보와 같습니까?");
		radioLbl.setFont(ft);
		JRadioButton radioOk = new JRadioButton("예");
		radioOk.setFont(ft);
		JRadioButton radioNo = new JRadioButton("아니요");
		radioNo.setFont(ft);
		radioPanel.add(radioLbl);
		radioPanel.add(radioOk);
		radioPanel.add(radioNo);
		
		shippingPanel = new JPanel();
		shippingPanel.setBounds(200, 50, 700, 500);
		shippingPanel.setLayout(null);
		add(shippingPanel);
		
		radioOk.setSelected(true);
		radioNo.setSelected(false);
		UserShippingInfo(true);
		
		// Chp 15 (p. 711)
		this.mCart = cart;
		
		radioOk.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if (radioOk.isSelected()) {
					shippingPanel.removeAll();
					UserShippingInfo(true);
					shippingPanel.revalidate();
					shippingPanel.repaint();
					radioNo.setSelected(false);
				}
			}
		});
		
		radioNo.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if (radioNo.isSelected()) {
					shippingPanel.removeAll();
					UserShippingInfo(false);
					shippingPanel.revalidate();
					shippingPanel.repaint();
					radioOk.setSelected(false);
				}
			}
		});
	}
	
	public void UserShippingInfo(boolean select) {
		
		Font ft = new Font("함초롬돋음", Font.BOLD, 15);
		
		// 이름
		JPanel namePanel = new JPanel();
		namePanel.setBounds(0, 100, 700, 50);
		// namePanel.setBackground(Color.GRAY);
		JLabel nameLbl = new JLabel("고객명:");
		nameLbl.setFont(ft);
		namePanel.add(nameLbl);
		
		JTextField nameLbl2 = new JTextField(15);
		nameLbl2.setFont(ft);
		if (select) {
			nameLbl2.setBackground(Color.LIGHT_GRAY);
			// nameLbl2.setText("입력된 고객 이름");
			nameLbl2.setText(UserInit.getmUser().getName());
		}
		namePanel.add(nameLbl2);
		shippingPanel.add(namePanel);
		
		// 연락처
		JPanel phonePanel = new JPanel();
		phonePanel.setBounds(0, 150, 700, 50);
		JLabel phoneLbl = new JLabel("연락처:");
		phoneLbl.setFont(ft);
		phonePanel.add(phoneLbl);
		
		JTextField phoneLbl2 = new JTextField(15);
		phoneLbl2.setFont(ft);
		if (select) {
			phoneLbl2.setBackground(Color.LIGHT_GRAY);
			// phoneLbl2.setText("입력된 고객 연락처");
			phoneLbl2.setText(String.valueOf(UserInit.getmUser().getPhone()));
		}
		phonePanel.add(phoneLbl2);
		shippingPanel.add(phonePanel);
		
		// 주소
		JPanel addressPanel = new JPanel();
		addressPanel.setBounds(0, 200, 700, 50);
		JLabel addressLbl = new JLabel("배송지:");
		addressLbl.setFont(ft);
		addressPanel.add(addressLbl);
		
		JTextField addressText = new JTextField(15);
		addressText.setFont(ft);
		addressPanel.add(addressText);
		shippingPanel.add(addressPanel);
		
		// 주소
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 300, 700, 100);
		JLabel buttonLbl = new JLabel("주문 완료");
		buttonLbl.setFont(ft);
		JButton orderBtn = new JButton();
		orderBtn.add(buttonLbl);
		buttonPanel.add(orderBtn);
		shippingPanel.add(buttonPanel);
		
		// Chp15 (p. 712)
		orderBtn.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				radioPanel.removeAll();
				radioPanel.revalidate();
				radioPanel.repaint();
				shippingPanel.removeAll();
				shippingPanel.add("주문 배송지", new CartOrderBillPage(shippingPanel, mCart));
				mCart.deleteBooks();
				shippingPanel.revalidate();
				shippingPanel.repaint();
			}
		});
	}

	/*
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setBounds(0, 0, 1000, 750);
		frame.setLayout(null);
		
		JPanel mPagePanel = new JPanel();
		mPagePanel.setBounds(0, 150, 1000, 750);
		frame.add(mPagePanel);
		
		mPagePanel.add("주문 배송지", new CartShippingPage(mPagePanel));
		
		frame.setVisible(true);
		
	}
	*/
}
