package model.Lodging;

public class Lodgingadmin {
	private int lodging_no;
	private String lodging_name;
	private String lodging_loc;
	private String lodging_phone;
	private int lodging_price;
	private String lodging_image;
	
	public Lodgingadmin() {}

	public Lodgingadmin(int lodging_no, String lodging_name, String lodging_loc, String lodging_phone,
			int lodging_price, String lodging_image) {
		super();
		this.lodging_no = lodging_no;
		this.lodging_name = lodging_name;
		this.lodging_loc = lodging_loc;
		this.lodging_phone = lodging_phone;
		this.lodging_price = lodging_price;
		this.lodging_image = lodging_image;
	}

	public Lodgingadmin(String lodging_name, String lodging_loc, String lodging_phone, int lodging_price,
			String lodging_image) {
		super();
		this.lodging_name = lodging_name;
		this.lodging_loc = lodging_loc;
		this.lodging_phone = lodging_phone;
		this.lodging_price = lodging_price;
		this.lodging_image = lodging_image;
	}
	
	@Override
	public String toString() {
		return "Lodgingadmin [lodging_no=" + lodging_no + ", lodging_name=" + lodging_name + ", lodging_loc="
				+ lodging_loc + ", lodging_phone=" + lodging_phone + ", lodging_price=" + lodging_price
				+ ", lodging_image=" + lodging_image + "]";
	}

	public int getLodging_no() {
		return lodging_no;
	}

	public void setLodging_no(int lodging_no) {
		this.lodging_no = lodging_no;
	}

	public String getLodging_name() {
		return lodging_name;
	}

	public void setLodging_name(String lodging_name) {
		this.lodging_name = lodging_name;
	}

	public String getLodging_loc() {
		return lodging_loc;
	}

	public void setLodging_loc(String lodging_loc) {
		this.lodging_loc = lodging_loc;
	}

	public String getLodging_phone() {
		return lodging_phone;
	}

	public void setLodging_phone(String lodging_phone) {
		this.lodging_phone = lodging_phone;
	}

	public int getLodging_price() {
		return lodging_price;
	}

	public void setLodging_price(int lodging_price) {
		this.lodging_price = lodging_price;
	}

	public String getLodging_image() {
		return lodging_image;
	}

	public void setLodging_image(String lodging_image) {
		this.lodging_image = lodging_image;
	}
	
	
	
	
}
