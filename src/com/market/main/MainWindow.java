package com.market.main;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
	
	static JPanel mMenuPanel, mPagePanel;

	public MainWindow(String title, int x, int y, int width, int height) {
		initContainer(title, x, y, width, height);
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(new ImageIcon("./images/shop.png").getImage());
	}
	
	public static void main(String[] args) {

	}

}
