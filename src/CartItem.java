public class CartItem {
	// 변수
	private String[] itemBook = new String[7];
	private String bookID;
	private int quantity;
	private int totalPrice;
	// 생성자
	public CartItem() { }
	public CartItem(String[] book) {
		this.itemBook = book;
		this.bookID = book[0];
		this.quantity = 1;
		updateTotalPrice();
	}
	// Getter 메서드
	public String[] getItemBook() { return itemBook; }
	public String getBookID() { return bookID; }
	public int getQuantity() { return quantity; }
	public int getTotalPrice() { return totalPrice; }
	
	// Setter 메서드
	public void setItemBook(String[] itemBook) { this.itemBook = itemBook;}
	public void setBookID(String bookID) { this.bookID = bookID; }
	public void setQuantity(int quantity) { this.quantity = quantity; }
	public void updateTotalPrice() {
		totalPrice = Integer.parseInt(this.itemBook[2]) * this.quantity;
	}
}
