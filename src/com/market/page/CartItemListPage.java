package com.market.page;

import com.market.bookitem.Book;
import com.market.cart.Cart;
import com.market.cart.CartItem;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CartItemListPage extends JPanel {
	
	JTable cartTable;
	Object[] tblHeader = {"도서ID", "도서명", "단가", "수량", "총가격"};
	
	Cart mCart = new Cart();
	public static int mSelectRow = -1;
	
	public CartItemListPage(JPanel panel, Cart cart) {
		Font ft = new Font("함초롬돋음", Font.BOLD, 15);
		this.mCart = cart;
		this.setLayout(null);
		
		Rectangle rect = panel.getBounds();
		System.out.println(rect);
		setPreferredSize(rect.getSize());
		
		JPanel bookPanel = new JPanel();
		bookPanel.setBounds(0, 0, 1000, 400);
		add(bookPanel);
		
		ArrayList<CartItem> cartItem = mCart.getmCartItem();
		Object[][] content = new Object[cartItem.size()][tblHeader.length];
		Integer totalPrice = 0;
		
		for (int i = 0; i < cartItem.size(); i++) {
			CartItem item = cartItem.get(i);
			
			content[i][0] = item.getBookID();
			content[i][1] = item.getItemBook().getName();
			content[i][2] = item.getItemBook().getUnitPrice();
			content[i][3] = item.getQuantity();
			content[i][4] = item.getTotalPrice();

			totalPrice += item.getQuantity() * item.getItemBook().getUnitPrice();
		}
		
		cartTable = new JTable(content, tblHeader);
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setPreferredSize(new Dimension(600, 350));
		jScrollPane.setViewportView(cartTable);
		bookPanel.add(jScrollPane);
		
		JPanel ttlPricePanel = new JPanel();
		ttlPricePanel.setBounds(0, 400, 1000, 50);
		// ttlPricePanel.setBackground(Color.RED);
		JLabel ttlPriceLbl = new JLabel("총금액: " + totalPrice + "원");
		ttlPriceLbl.setForeground(Color.red);
		ttlPriceLbl.setFont(ft);
		ttlPricePanel.add(ttlPriceLbl);
		add(ttlPricePanel);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());
		btnPanel.setBounds(0, 450, 1000, 50);
		add(btnPanel);
		
		JLabel btnLbl = new JLabel("장바구니 비우기");
		btnLbl.setFont(ft);
		JButton clearBtn = new JButton();
		clearBtn.add(btnLbl);
		btnPanel.add(clearBtn);
		
		JLabel rmLbl = new JLabel("장바구니의 항목 삭제하기");
		rmLbl.setFont(ft);
		JButton rmBtn = new JButton();
		rmBtn.add(rmLbl);
		btnPanel.add(rmBtn);
		
		JLabel refreshLbl = new JLabel("장바구니 새로 고침");
		refreshLbl.setFont(ft);
		JButton refreshBtn = new JButton();
		refreshBtn.add(refreshLbl);
		btnPanel.add(refreshBtn);
	}

	public static void main(String[] args) {
		Cart mCart = new Cart();
		JFrame frame = new JFrame();
		frame.setBounds(0, 0, 1000, 750);
		frame.setLayout(null);
		
		JPanel mPagePanel = new JPanel();
		mPagePanel.setBounds(0, 150, 1000, 750);
		
		frame.add(mPagePanel);
		mPagePanel.add("장바구니 상품 목록 보기", new CartItemListPage(mPagePanel, mCart));
		
		frame.setVisible(true);
	}

}
