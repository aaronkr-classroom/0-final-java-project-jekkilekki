public class Admin extends Person {
	
	private String id = "admin";
	private String pw = "admin1234";
	
	public Admin(String name, int phone) {
		super(name, phone);
	}
	
	public String getId() {
		return id;
	}
	
	public String getPw() {
		return pw;
	}
}
