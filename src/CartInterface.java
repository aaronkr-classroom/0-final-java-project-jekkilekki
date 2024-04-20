public interface CartInterface {
	void printBookList(Book[] p);
	boolean isBookInCart(String id); // 책의 함수 이름은 isCartInBook()
	void insertBook(Book p);
	void removeFromCart(int numId);
	void deleteBooks();
}
