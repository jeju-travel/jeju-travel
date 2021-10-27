package model.Lodging;

public class Lodging_reserve {
	private int lodging_reserve_no;
	private String check_in;
	private String check_out;
	private int lodging_no;
	
	public Lodging_reserve() {}
	
	public Lodging_reserve(int lodging_reserve_no, String check_in, String check_out, int lodging_no) {
		super();
		this.lodging_reserve_no = lodging_reserve_no;
		this.check_in = check_in;
		this.check_out = check_out;
		this.lodging_no = lodging_no;
	}
	
	public Lodging_reserve(String check_in, String check_out, int lodging_no) {
		super();
		this.check_in = check_in;
		this.check_out = check_out;
		this.lodging_no = lodging_no;
	}

	public int getLodging_reserve_no() {
		return lodging_reserve_no;
	}
	public void setLodging_reserve_no(int lodging_reserve_no) {
		this.lodging_reserve_no = lodging_reserve_no;
	}
	public String getCheck_in() {
		return check_in;
	}
	public void setCheck_in(String check_in) {
		this.check_in = check_in;
	}
	public String getCheck_out() {
		return check_out;
	}
	public void setCheck_out(String check_out) {
		this.check_out = check_out;
	}
	public int getLodging_no() {
		return lodging_no;
	}
	public void setLodging_no(int lodging_no) {
		this.lodging_no = lodging_no;
	}
	
	@Override
	public String toString() {
		return "Lodging_reserve [lodging_reserve_no=" + lodging_reserve_no + ", check_in=" + check_in + ", check_out="
				+ check_out + ", lodging_no=" + lodging_no + "]";
	}
	
	
	
}
