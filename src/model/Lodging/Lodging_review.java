package model.Lodging;

public class Lodging_review {
	private int lodging_review_no;
	private String lodging_content;
	private double lodging_horoscope;
	private int lodging_no;
	private String writer;
	
	public Lodging_review() {}
	
	public Lodging_review(int lodging_review_no, String lodging_content, double lodging_horoscope, int lodging_no,
			String writer) {
		super();
		this.lodging_review_no = lodging_review_no;
		this.lodging_content = lodging_content;
		this.lodging_horoscope = lodging_horoscope;
		this.lodging_no = lodging_no;
		this.writer = writer;
	}

	

	public Lodging_review(int lodging_review_no, String lodging_content, double lodging_horoscope, int lodging_no) {
		super();
		this.lodging_review_no = lodging_review_no;
		this.lodging_content = lodging_content;
		this.lodging_horoscope = lodging_horoscope;
		this.lodging_no = lodging_no;
	}
	
	public Lodging_review(String lodging_content, double lodging_horoscope, int lodging_no) {
		super();
		this.lodging_content = lodging_content;
		this.lodging_horoscope = lodging_horoscope;
		this.lodging_no = lodging_no;
	}

	@Override
	public String toString() {
		return "Lodging_review [lodging_review_no=" + lodging_review_no + ", lodging_content=" + lodging_content
				+ ", lodging_horoscope=" + lodging_horoscope + ", lodging_no=" + lodging_no + ", writer=" + writer
				+ "]";
	}
	
	
	
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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
	public double getLodging_horoscope() {
		return lodging_horoscope;
	}
	public void setLodging_horoscope(double lodging_horoscope) {
		this.lodging_horoscope = lodging_horoscope;
	}
	public int getlodging_no() {
		return lodging_no;
	}
	public void setlodging_no(int lodging_no) {
		this.lodging_no = lodging_no;
	}
	
	
}
