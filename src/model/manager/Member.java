package model.manager;

public class Member {

	private int no;
	private String id;
	private String pw;
	private String name;
	private String hint;
	private String answer;
	private String phone;
	private String email;
	
	
	public Member() {
		
	}

	public Member(int no, String id, String pw, String name, String hint, String answer, String phone, String email) {
		super();
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.hint = hint;
		this.answer = answer;
		this.phone = phone;
		this.email = email;
	}
	
	
	public Member(String id, String pw, String name, String hint, String answer, String phone, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.hint = hint;
		this.answer = answer;
		this.phone = phone;
		this.email = email;
	}
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Member [no=" + no + ", id=" + id + ", pw=" + pw + ", name=" + name + ", hint=" + hint + ", answer="
				+ answer + ", phone=" + phone + ", email=" + email + "]";
	}
	
	
}
