public abstract class Item {
	String bookId;
	String name;
	int unitPrice;
	
	// 생성자
	public Item(String bookId, String name, int unitPrice) {
		this.bookId = bookId;
		this.name = name;
		this.unitPrice = unitPrice;
	}
	
	// 추상 메서드 선언 (getter 메서드)
	abstract String getBookId();
	abstract String getName();
	abstract int getUnitPrice();
	
	// 추상 메서드 선언 (setter 메서드)
	abstract void setBookId(String bookId);
	abstract void setName(String name);
	abstract void setUnitPrice(int unitPrice);
}
