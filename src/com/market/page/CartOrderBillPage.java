package com.market.page;

import com.market.bookitem.BookInit;
import com.market.cart.Cart;
import com.market.member.UserInit;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CartOrderBillPage extends JPanel {
	
	Cart mCart;
	JPanel shippingPanel;
	JPanel radioPanel;
	
	public CartOrderBillPage(JPanel panel, Cart cart) {
		
		setLayout(null);
		
		Rectangle rect = panel.getBounds();
		System.out.println(rect);
		setPreferredSize(rect.getSize());
		
		this.mCart = cart;
		
		shippingPanel = new JPanel();
		// shippingPanel.setBounds(200, 50, 700, 500);
		shippingPanel.setBounds(0, 0, 700, 500);
		shippingPanel.setLayout(null);
		// add(shippingPanel);
		panel.add(shippingPanel);
		
		printBillInfo(UserInit.getmUser().getName(), String.valueOf(UserInit.getmUser().getPhone()), UserInit.getmUser().getAddress());
		
	}
	
	public void printBillInfo(String name, String phone, String address) {
		
		Font ft = new Font("함초롬돋음", Font.BOLD, 15);
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String strDate = formatter.format(date);
		
		JPanel panel01 = new JPanel();
		panel01.setBounds(0, 0, 500, 30);
		// panel01.setBackground(Color.GRAY);
		JLabel lbl01 = new JLabel("------배송 받은 고객 정보------");
		lbl01.setFont(ft);
		panel01.add(lbl01);
		shippingPanel.add(panel01);
		
		JPanel panel02 = new JPanel();
		panel02.setBounds(0, 30, 500, 30);
		JLabel lbl02 = new JLabel("고객명: " + name + "      연락처: " + phone);
		lbl02.setHorizontalAlignment(JLabel.LEFT);
		lbl02.setFont(ft);
		panel02.add(lbl02);
		shippingPanel.add(panel02);
		
		JPanel panel03 = new JPanel();
		panel03.setBounds(0, 60, 500, 30);
		JLabel lbl03 = new JLabel("배송지: " + address + "      발송일: " + strDate);
		lbl03.setHorizontalAlignment(JLabel.LEFT);
		lbl03.setFont(ft);
		panel03.add(lbl03);
		shippingPanel.add(panel03);
		
		JPanel printPanel = new JPanel();
		printPanel.setBounds(0, 100, 500, 300);
		printCart(printPanel);
		shippingPanel.add(printPanel);
		
	}
	
	public void printCart(JPanel panel) {
		
		Font ft = new Font("함초롬돋음", Font.BOLD, 15);
		
		JPanel panel01 = new JPanel();
		panel01.setBounds(0, 0, 500, 0);
		JLabel lbl01 = new JLabel("     장바구니 상품 목록: ");
		lbl01.setFont(ft);
		panel01.add(lbl01);
		panel.add(panel01);
		
		JPanel panel02 = new JPanel();
		panel02.setBounds(0, 20, 500, 5);
		JLabel lbl02 = new JLabel("--------------------");
		lbl02.setFont(ft);
		panel02.add(lbl02);
		panel.add(panel02);
		
		JPanel panel03 = new JPanel();
		panel03.setBounds(0, 25, 500, 5);
		JLabel lbl03 = new JLabel(" 도서ID | 수량 | 합계 ");
		lbl03.setFont(ft);
		panel03.add(lbl03);
		panel.add(panel03);
		
		JPanel panel04 = new JPanel();
		panel04.setBounds(0, 30, 500, 5);
		JLabel lbl04 = new JLabel("--------------------");
		lbl04.setFont(ft);
		panel04.add(lbl04);
		panel.add(panel04);
		
		for (int i = 0; i < mCart.mCartItem.size(); i++) {
			JPanel panel05 = new JPanel();
			panel05.setBounds(0, 35+(i*5), 500, 5);
			JLabel lbl05 = new JLabel("          " +
				mCart.mCartItem.get(i).getBookID() + "          " +
				mCart.mCartItem.get(i).getQuantity() + "          " +
				mCart.mCartItem.get(i).getTotalPrice()
			);
			lbl05.setFont(ft);
			panel05.add(lbl05);
			panel.add(panel05);
		}
		
		JPanel panel06 = new JPanel();
		panel06.setBounds(0, 35+(mCart.mCartItem.size()*5), 500, 5);
		JLabel lbl06 = new JLabel("--------------------");
		lbl06.setFont(ft);
		panel06.add(lbl06);
		panel.add(panel06);
		
		int sum = 0;
		
		for (int i = 0; i < mCart.mCartCount; i++) {
			sum += mCart.mCartItem.get(i).getTotalPrice();
		}
		System.out.println("----------" + mCart.mCartCount);
		
		JPanel panel07 = new JPanel();
		panel07.setBounds(0, 40+(mCart.mCartItem.size()*5), 500, 5);
		JLabel lbl07 = new JLabel("     주문 총금액: " + sum + "원");
		// lbl07.setHorizontalAlignment(JLabel.CENTER);
		lbl07.setFont(ft);
		panel07.add(lbl07);
		panel.add(panel07);
	}

	/*
	public static void main(String[] args) {

		Cart mCart = new Cart();
		JFrame frame = new JFrame();
		frame.setBounds(0, 0, 1000, 750);
		frame.setLayout(null);
		
		JPanel mPagePanel = new JPanel();
		mPagePanel.setBounds(0, 150, 1000, 750);
		
		frame.add(mPagePanel);
		BookInit.init();
		mPagePanel.add("주문하기", new CartOrderBillPage(mPagePanel, mCart));
		frame.setVisible(true);

	}
	*/
}
