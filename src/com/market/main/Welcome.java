package com.market.main;
import java.util.Scanner;

import com.market.bookitem.Book;
import com.market.cart.Cart;
import com.market.member.Admin;
import com.market.member.User;

public class Welcome {
	
	// 정적 상수와 변수 (프로그램에서 아무 범위에 쓸 수 있어요)
	static final int NUM_BOOK = 3;
	static final int NUM_ITEM = 7;
	// static CartItem[] mCartItem = new CartItem[NUM_BOOK];
	// static int mCartCount = 0;
	static Cart mCart = new Cart();
	static User mUser;

	public static void main(String[] args) {
		
		// String[][] mBook = new String[NUM_BOOK][NUM_ITEM]; // [3][7] = 책: 3, 모든 책의 속성: 7
		Book[] mBookList = new Book[NUM_BOOK]; // 9장
		
		// 사용자 입력받기
		Scanner input = new Scanner(System.in);
		System.out.print("당신의 이름을 입력하세요: ");
		String name = input.next();
		System.out.print("연락처를 입력하세요: ");
		int phone = input.nextInt(); // 숫자만 입력
		
		// 새로운 사용자 만들기
		mUser = new User(name, phone);
		
		// 환영 메시지를 출력하기
		String greeting = "Welcome to Shopping Mall!";
		String tagline = "Welcome to Book Market!!";
		
		// #### 메인 프로그램 루프 ############
		boolean quit = false;
		
		while(!quit) {
			
			System.out.println("*****************************");
			System.out.println("\t" + greeting);
			System.out.println("\t" + tagline);
			
			// 밑에 있는 첫 번째 함수
			menuIntro();
			
//			System.out.println("*****************************");
//			System.out.println("1. 고객 정보 확인하기\t5. 장바구니에 항목 추가하기");
//			System.out.println("2. 장바구니 상품 목록 보기\t6. 장바구니의 항목 수량 줄이기");
//			System.out.println("3. 장바구니 비우기\t7. 장바구니의 항목 삭제하기");
//			System.out.println("4. 영수증 표시하기\t8. 종료");
//			System.out.println("9. 관리자 로그인");
//			System.out.println("*****************************");
		
			// 사용자가 메뉴 옵션을 선택하기
			System.out.println("메뉴 번호를 선택하세요: ");
			int choice = input.nextInt(); // 숫자만 입력
			
			if(choice < 1 || choice > 9) { // 메뉴 선택 잘 못 하면
				System.out.println("1부터 9까지의 숫자를 입력하세요.");
			} else {
				switch(choice) {
				case 1:
					menuGuestInfo(name, phone);
					break;
				case 2:
					menuCartItemList();
					break;
				case 3:
					menuCartClear();
					break;
				case 4:
					menuCartBill();
					break;
				case 5:
					menuCartAddItem(mBookList); // 9장
					break;
				case 6:
					menuCartRemoveItemCount();
					break;
				case 7:
					menuCartRemoveItem();
					break;
				case 8:
					menuCartExit();
					input.close(); // 추가
					quit = true;
					break;
				case 9:
					menuAdminLogin();
					break;
				} // switch 끝
			} // if-else 끝
		} // while 끝
	} // main 함수 끝
	
	/**
	 * 설명: Print Menu
	 * 매게변수: 
	 * 반환값: 
	 */
	public static void menuIntro() {
		System.out.println("*****************************");
		System.out.println("1. 고객 정보 확인하기\t5. 장바구니에 항목 추가하기");
		System.out.println("2. 장바구니 상품 목록 보기\t6. 장바구니의 항목 수량 줄이기");
		System.out.println("3. 장바구니 비우기\t7. 장바구니의 항목 삭제하기");
		System.out.println("4. 영수증 표시하기\t8. 종료");
		System.out.println("9. 관리자 로그인");
		System.out.println("*****************************");
	} // menuIntro() 끝
	
	/**
	 * 설명: 고객님 정보 출력
	 * 매게변수: 
	 * 	- String	name	고객님의 이름
	 * 	- int		phone	휴대 전화 번호
	 * 반환값: 
	 */
	public static void menuGuestInfo(String name, int phone) {
		System.out.println("1. 현재 고객 정보: ");
		System.out.println("이름: " + mUser.getName() + " 연락처: " + mUser.getPhone());
	} // menuGuestInfo() 끝
	
	/**
	 * 설명: 2번 
	 * 매게변수: 
	 * 반환값: 
	 */
	public static void menuCartItemList() {
		/*
		System.out.println("장바구니 상품 목록 :");
		System.out.println("---------------------------------------------");
		System.out.println("    도서ID \t|     수량 \t|      합계");
		for (int i = 0; i < mCartCount; i++) {
			System.out.print("    " + mCartItem[i].getBookID() + " \t| ");
			System.out.print("    " + mCartItem[i].getQuantity() + " \t| ");
			System.out.print("    " + mCartItem[i].getTotalPrice());
			System.out.println("  ");
		} // for 끝
		System.out.println("---------------------------------------------");	
		*/
		if (mCart.mCartCount >= 0) {
			mCart.printCart();
		}
	} // menuCartItemList() 끝
	
	public static void menuCartClear() {
		// System.out.println("3. 장바구니 비우기: ");
		if (mCart.mCartCount == 0 ) {
			System.out.println("장바구니에 항목이 없습니다.");
		} else {
			System.out.println("장바구니의 모든 항목을 삭제하겠습니까? Y | N");
			Scanner input = new Scanner(System.in);
			String str = input.nextLine();
			
			if (str.toUpperCase().equals("Y")) {
				System.out.println("장바구니의 모든 항목을 삭제했습니다.");
				mCart.deleteBooks();
			}
		}
	} // menuCartClear() 끝
	
	public static void menuCartAddItem(Book[] booklist) {
		// System.out.println("장바구니에 항목 추가하기 : ");

		BookList(booklist);
		/*
		for (int i = 0; i < NUM_BOOK; i++) {
			for (int j = 0; j < NUM_ITEM; j++)
				System.out.print(book[i][j] + " | ");
			System.out.println("");
		} // for 끝
		*/
		mCart.printBookList(booklist);

		boolean quit = false;

		while (!quit) {
			System.out.print("장바구니에 추가할 도서의 ID를 입력하세요 : ");

			Scanner input = new Scanner(System.in);
			String str = input.nextLine();

			boolean flag = false;
			int numId = -1;

			for (int i = 0; i < NUM_BOOK; i++) {
				if (str.equals(booklist[i].getBookId())) {
					numId = i;
					flag = true;
					break;
				} // if 끝
			} // for 끝

			if (flag) {
				System.out.println("장바구니에 추가하겠습니까?  Y  | N ");
				str = input.nextLine();

				if (str.toUpperCase().equals("Y")) {
					System.out.println(booklist[numId].getBookId() + " 도서가 장바구니에 추가되었습니다.");
					// 장바구니에 넣기
					if (!isBookInCart(booklist[numId].getBookId()))
						// mCartItem[mCartCount++] = new CartItem(book[numId]);
						mCart.insertBook(booklist[numId]);
				} // if 끝
				quit = true;
				input.close(); // 추가
			} else {
				System.out.println("다시 입력하세요.");
			} // if-else 끝
		} // while 끝
	} // menuCartAddItem() 끝
	
	public static void menuCartRemoveItemCount() {
		System.out.println("6. 장바구니의 항목 수량 줄이기: ");
	} // menuCartRemoveItemCount() 끝
	
	public static void menuCartRemoveItem() {
		// System.out.println("7. 장바구니의 항목 삭제하기: ");
		if (mCart.mCartCount == 0)
			System.out.println("장바구니에 항목이 엾습니다.");
		else {
			menuCartItemList();
			boolean quit = false;
			
			while(!quit) {
				System.out.println("장바구니에서 삭제할 도서의 ID를 입력하세요.");
				
				Scanner input = new Scanner(System.in);
				String str = input.nextLine();
				
				boolean flag = false;
				int numId = -1;
				
				for (int i = 0; i < mCart.mCartCount; i++) {
					if (str.equals(mCart.mCartItem[i].getBookID())) {
						numId = i;
						flag = true;
						break;
					}
				}
				
				if (flag) {
					System.out.println("장바구니의 항목을 삭제하겠습니까? Y | N");
					str = input.nextLine();
					if (str.toUpperCase().equals("Y")) {
						System.out.println(mCart.mCartItem[numId].getBookID() + 
						                                  "장바구니에서 도서가 삭제되었습니다.");	
					}
					quit = true;
				} else
					System.out.println("다시 입력해 주세요.");
			}
		}
	} // menuCartRemoveItem() 끝
	
	public static void menuCartBill() {
		// System.out.println("4. 영수증 표시하기:");
		if(mCart.mCartCount == 0) 
			System.out.println("장바구니에 항목이 없습니다.");
		else {
			System.out.println("배송받을 분은 고객 정보와 같습니까? Y | N");
			Scanner input = new Scanner(System.in);
			String str = input.nextLine();
			
			if (str.toUpperCase().equals("Y")) {
				System.out.println("배송지를")
			}
		}
	} // menuCartBill() 끝
	
	public static void menuCartExit() {
		System.out.println("8. 종료");
	} // menuCartExit() 끝
	
	public static void menuAdminLogin() {
		System.out.println("관리자 정보를 입력하세요.");
		
		Scanner input = new Scanner(System.in);
		System.out.println("아이디: ");
		String adminId = input.next();
		
		System.out.println("비밀번호: ");
		String adminPw = input.next();
		
		Admin admin = new Admin(mUser.getName(), mUser.getPhone());
		
		if (adminId.equals(admin.getId())
				&& adminPw.equals(admin.getPw())) {
			System.out.println("이름: " + admin.getName() + "  연락차: " + admin.getPhone());
			System.out.println("아이디: " + admin.getId() + "  비밀번호: " + admin.getPw());
		} else {
			System.out.println("관리자 정보가 일치하지 않습니다.");
		} // if 끝
	} // menuAdminLogin() 끝
	
	/* ###################################
	 */
	public static void BookList(Book[] booklist) {

		booklist[0] = new Book("ISBN1234", "쉽게 배우는 JSP 웹 프로그래밍", 27000); // 27,000
		booklist[0].setAuthor("송미영");
		booklist[0].setDescription("단계별로 쇼핑몰 구현하며 배우는 JSP 웹 프로그래밍");
		booklist[0].setCategory("IT전문서");
		booklist[0].setReleaseDate("2018/10/08");

		booklist[1] = new Book("ISBN1235", "안드로이드 프로그래밍", 33000); // 33,000
		booklist[1].setAuthor("우재남");
		booklist[1].setDescription("실습 단계별 명쾌한 멘토링!");
		booklist[1].setCategory("IT전문서");
		booklist[1].setReleaseDate("2022/01/22");

		booklist[2] = new Book("ISBN1236", "스크래치", 22000); // 22,000
		booklist[2].setAuthor("고광일");
		booklist[2].setAuthor("컴퓨팅 사고력을 키우는 블록 코딩");
		booklist[2].setAuthor("컴퓨터입문");
		booklist[2].setAuthor("2019/06/10");
	}

	public static boolean isBookInCart(String bookId) {
		/*
		boolean flag = false;
		for (int i = 0; i < mCartCount; i++) {
			if (bookId == mCartItem[i].getBookID()) {
				mCartItem[i].setQuantity(mCartItem[i].getQuantity() + 1);
				flag = true;
			}
		}
		return flag;
		*/
		return mCart.isBookInCart(bookId);
	}
	
	
} // Welcome 클래스 끝 







