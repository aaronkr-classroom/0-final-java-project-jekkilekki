package com.market.bookitem;

import java.io.*;
import java.util.ArrayList;

public class BookInit {
	private static ArrayList<Book> mBookList;
	private static int mTotalBook = 0;
	
	public static void init() {
		mTotalBook = totalFileToBookList();
		mBookList = new ArrayList<Book>();
		setFileToBookList(mBookList);
	}
}
