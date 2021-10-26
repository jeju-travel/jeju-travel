package lodging.model;

public class Lodging_review {
	private int lodging_review_no;
	private String lodging_content;
	private int lodging_horoscope;
	private int room_reserve_no;
	
	public Lodging_review() {}
	
	public Lodging_review(int lodging_review_no, String lodging_content, int lodging_horoscope, int room_reserve_no) {
		super();
		this.lodging_review_no = lodging_review_no;
		this.lodging_content = lodging_content;
		this.lodging_horoscope = lodging_horoscope;
		this.room_reserve_no = room_reserve_no;
	}
	
	public Lodging_review(String lodging_content, int lodging_horoscope, int room_reserve_no) {
		super();
		this.lodging_content = lodging_content;
		this.lodging_horoscope = lodging_horoscope;
		this.room_reserve_no = room_reserve_no;
	}

	@Override
	public String toString() {
		return "lodging_review [lodging_review_no=" + lodging_review_no + ", lodging_content=" + lodging_content
				+ ", lodging_horoscope=" + lodging_horoscope + ", room_reserve_no=" + room_reserve_no + "]";
	}
	
	public int getLodging_review_no() {
		return lodging_review_no;
	}
	public void setLodging_review_no(int lodging_review_no) {
		this.lodging_review_no = lodging_review_no;
	}
	public String getLodging_content() {
		return lodging_content;
	}
	public void setLodging_content(String lodging_content) {
		this.lodging_content = lodging_content;
	}
	public int getLodging_horoscope() {
		return lodging_horoscope;
	}
	public void setLodging_horoscope(int lodging_horoscope) {
		this.lodging_horoscope = lodging_horoscope;
	}
	public int getRoom_reserve_no() {
		return room_reserve_no;
	}
	public void setRoom_reserve_no(int room_reserve_no) {
		this.room_reserve_no = room_reserve_no;
	}
	
	
}
