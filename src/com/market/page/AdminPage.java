package com.market.page;

import javax.swing.*;

import com.market.bookitem.BookInit;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.FileWriter;

public class AdminPage extends JPanel {
	
	public AdminPage(JPanel panel) {
		
		Font ft = new Font("함초롬돋음", Font.BOLD, 15);
		setLayout(null);
		
		Rectangle rect = panel.getBounds();
		System.out.println(rect);
		setPreferredSize(rect.getSize());
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMddhhmmss");
		String strDate = formatter.format(date);
		
		JPanel idPanel = new JPanel();
		idPanel.setBounds(100, 0, 700, 50);
		JLabel idLbl = new JLabel("도서ID: ");
		idLbl.setFont(ft);
		JLabel idTxtField = new JLabel();
		idTxtField.setFont(ft);
		idTxtField.setPreferredSize(new Dimension(290, 50));
		idTxtField.setText("ISBN" + strDate);
		idPanel.add(idLbl);
		idPanel.add(idTxtField);
		add(idPanel);
		
		JPanel namePanel = new JPanel();
		namePanel.setBounds(100, 50, 700, 50);
		JLabel nameLbl = new JLabel("도서명: ");
		nameLbl.setFont(ft);
		JTextField nameTxtField = new JTextField(20);
		nameTxtField.setFont(ft);
		namePanel.add(nameLbl);
		namePanel.add(nameTxtField);
		add(namePanel);
		
		JPanel pricePanel = new JPanel();
		pricePanel.setBounds(100, 100, 700, 50);
		JLabel priceLbl = new JLabel("가  격: ");
		priceLbl.setFont(ft);
		JTextField priceTxtField = new JTextField(20);
		priceTxtField.setFont(ft);
		pricePanel.add(priceLbl);
		pricePanel.add(priceTxtField);
		add(pricePanel);
		
		JPanel authorPanel = new JPanel();
		authorPanel.setBounds(100, 150, 700, 50);
		JLabel authorLbl = new JLabel("저  자: ");
		authorLbl.setFont(ft);
		JTextField authorTxtField = new JTextField(20);
		authorTxtField.setFont(ft);
		authorPanel.add(authorLbl);
		authorPanel.add(authorTxtField);
		add(authorPanel);
		
		JPanel descPanel = new JPanel();
		descPanel.setBounds(100, 200, 700, 50);
		JLabel descLbl = new JLabel("설  명: ");
		descLbl.setFont(ft);
		JTextField descTxtField = new JTextField(20);
		descTxtField.setFont(ft);
		descPanel.add(descLbl);
		descPanel.add(descTxtField);
		add(descPanel);
		
		JPanel categoryPanel = new JPanel();
		categoryPanel.setBounds(100, 250, 700, 50);
		JLabel categoryLbl = new JLabel("분  야: ");
		categoryLbl.setFont(ft);
		JTextField categoryTxtField = new JTextField(20);
		categoryTxtField.setFont(ft);
		categoryPanel.add(categoryLbl);
		categoryPanel.add(categoryTxtField);
		add(categoryPanel);
		
		JPanel datePanel = new JPanel();
		datePanel.setBounds(100, 300, 700, 50);
		JLabel dateLbl = new JLabel("출판일: ");
		dateLbl.setFont(ft);
		JTextField dateTxtField = new JTextField(20);
		dateTxtField.setFont(ft);
		datePanel.add(dateLbl);
		datePanel.add(dateTxtField);
		add(datePanel);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setBounds(100, 350, 700, 50);
		add(btnPanel);
		
		JLabel okLbl = new JLabel("추가");
		okLbl.setFont(ft);
		JButton okBtn = new JButton();
		okBtn.add(okLbl);
		btnPanel.add(okBtn);
		
		// Chp15 (p. 719)
		okBtn.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String[] writeBook = new String[7];
				writeBook[0] = idTxtField.getText();
				writeBook[1] = nameTxtField.getText();
				writeBook[2] = priceTxtField.getText();
				writeBook[3] = authorTxtField.getText();
				writeBook[4] = descTxtField.getText();
				writeBook[5] = categoryTxtField.getText();
				writeBook[6] = dateTxtField.getText();
				
				try {
					FileWriter fw = new FileWriter("books.txt", true);
					
					for (int i = 0; i < 7; i++)
						fw.write(writeBook[i] + "\n");
					
					fw.close();
					
					JOptionPane.showMessageDialog(okBtn, "새 도서 정보가 저장되었습니다");
					
					Date date = new Date();
					SimpleDateFormat formatter = new SimpleDateFormat("yyMMddhhmmss");
					String strDate = formatter.format(date);
					
					idTxtField.setText("ISBN" + strDate);
					nameTxtField.setText("");
					priceTxtField.setText("");
					authorTxtField.setText("");
					descTxtField.setText("");
					categoryTxtField.setText("");
					dateTxtField.setText("");
					
					System.out.println("새 도서 정보가 저장되었습니다");
				} catch(Exception ex) {
					System.out.println(ex);
				}
			}
		});
		
		JLabel noLbl = new JLabel("취소");
		noLbl.setFont(ft);
		JButton noBtn = new JButton();
		noBtn.add(noLbl);
		btnPanel.add(noBtn);
		
		// Chp15 (p. 720)
		noBtn.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				nameTxtField.setText("");
				priceTxtField.setText("");
				authorTxtField.setText("");
				descTxtField.setText("");
				categoryTxtField.setText("");
				dateTxtField.setText("");
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
		mPagePanel.add("주문하기", new AdminPage(mPagePanel));
		frame.setVisible(true);

	}
	*/
}
