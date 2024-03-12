import java.util.Scanner;

public class Welcome {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("당신의 이름을 입력하세요: ");
		String name = input.next();
		
		System.out.println("연락처를 입력하세요: ");
		int phone = input.nextInt(); // 숫자만 입력
		
		String greeting = "Welcome to Shopping Mall!";
		String tagline = "Welcome to Book Market!!";
		
		System.out.println("*****************************");
		System.out.println("\t" + greeting);
		System.out.println("\t" + tagline);
		System.out.println("*****************************");
		
		System.out.println("1. 고객 정보 확인하기\t5. 장바구니에 항목 추가하기");
		System.out.println("2. 장바구니 상품 목록 보기\t6. 장바구니의 항목 수량 줄이기");
		System.out.println("3. 장바구니 비우기\t7. 장바구니의 항목 삭제하기");
		System.out.println("4. 영수증 표시하기\t8. 종료");
		System.out.println("*****************************");
	
		System.out.println("메뉴 번호를 선택하세요: ");
		int choice = input.nextInt(); // 숫자만 입력
		System.out.println(choice + "번을 선택했습니다.");
	}

}
