package com.market.page;

import com.market.bookitem.Book;
import com.market.bookitem.BookInit;
import com.market.cart.Cart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CartAddItemPage extends JPanel {
	
	ImageIcon imgBook;
	int mSelectRow = 0;
	
	Cart mCart;
	
	public CartAddItemPage(JPanel panel, Cart cart) {
		Font ft = new Font("함초롬돋음", Font.BOLD, 15);
		
		setLayout(null);
		
		Rectangle rect = panel.getBounds();
		System.out.println(rect);
		setPreferredSize(rect.getSize());
		
		mCart = cart;
		
		JPanel imgPanel = new JPanel();
		imgPanel.setBounds(20, 0, 300, 400);
		imgBook = new ImageIcon("./images/ISBN1234.jpg");
		imgBook.setImage(imgBook.getImage().getScaledInstance(250, 300, Image.SCALE_DEFAULT));
		JLabel lbl = new JLabel(imgBook);
		imgPanel.add(lbl);
		add(imgPanel);
		
		JPanel tblPanel = new JPanel();
		tblPanel.setBounds(300, 0, 700, 400);
		add(tblPanel);
		
		ArrayList<Book> booklist = BookInit.getmBookList();
		Object[] tblHeader = {"도서ID", "도서명", "가격", "저자", "설명", "분야", "출판일"};
		Object[][] content = new Object[booklist.size()][tblHeader.length];
		
		for (int i = 0; i < booklist.size(); i++) {
			Book bookitem = booklist.get(i);
			
			content[i][0] = bookitem.getBookId();
			content[i][1] = bookitem.getName();
			content[i][2] = bookitem.getUnitPrice();
			content[i][3] = bookitem.getAuthor();
			content[i][4] = bookitem.getDescription();
			content[i][5] = bookitem.getCategory();
			content[i][6] = bookitem.getReleaseDate();
		}
		
		JTable bookTbl = new JTable(content, tblHeader);
		bookTbl.setRowSelectionInterval(0, 0);
		bookTbl.getSelectedColumn();
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setPreferredSize(new Dimension(600, 350));
		jScrollPane.setViewportView(bookTbl);
		tblPanel.add(jScrollPane);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setBounds(0, 400, 1000, 400);
		add(btnPanel);
		JLabel btnLbl = new JLabel("장바구니에 담기");
		btnLbl.setFont(ft);
		JButton addBtn = new JButton();
		addBtn.add(btnLbl);
		btnPanel.add(addBtn);
		
		// Chp15
		bookTbl.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				int row = bookTbl.getSelectedRow();
				int col = bookTbl.getSelectedColumn();
				mSelectRow = row;
				
				Object value = bookTbl.getValueAt(row, 0);
				String str = value + ".jpg";
				imgBook = new ImageIcon("./images/" + str);
				imgBook.setImage(imgBook.getImage().getScaledInstance(250, 300, Image.SCALE_DEFAULT));
				JLabel lbl = new JLabel(imgBook);
				
				imgPanel.removeAll();
				imgPanel.add(lbl);
				imgPanel.revalidate();
				imgPanel.repaint();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO
			}
		});
		
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Book> booklist = BookInit.getmBookList();
				int select = JOptionPane.showConfirmDialog(addBtn, "장바구니에 추가하겠습니까?");
				
				if (select == 0) {
					int numId = mSelectRow;
					if (!isBookInCart(booklist.get(numId).getBookId())) {
						mCart.insertBook(booklist.get(numId));
					}
					JOptionPane.showMessageDialog(addBtn, "추가했습니다");
				}
			}
		});
	}
	
	public boolean isBookInCart(String bookId) {
		return mCart.isBookInCart(bookId);
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
		mPagePanel.add("장바구니에 항목 추가하기", new CartAddItemPage(mPagePanel, mCart));
		
		frame.setVisible(true);
	}
	*/
}
