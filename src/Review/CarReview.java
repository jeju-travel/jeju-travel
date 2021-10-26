package Review;

public class CarReview {

	private int reviewNo;
	private String reContent;
	private int reStar;
	private int resNo;
	
	
	
	
	public CarReview(int reviewNo, String reContent, int reStar, int resNo) {
		super();
		this.reviewNo = reviewNo;
		this.reContent = reContent;
		this.reStar = reStar;
		this.resNo = resNo;
	}
	
	

	public CarReview(String reContent, int reStar, int resNo) {
		super();
		
		this.reContent = reContent;
		this.reStar = reStar;
		this.resNo = resNo;
	}
	
	

	public CarReview() {
		super();

	}
	
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getReContent() {
		return reContent;
	}
	public void setReContent(String reContent) {
		this.reContent = reContent;
	}
	public int getReStar() {
		return reStar;
	}
	public void setReStar(int reStar) {
		this.reStar = reStar;
	}
	public int getResNo() {
		return resNo;
	}
	public void setResNo(int resNo) {
		this.resNo = resNo;
	}
	
	
	
}
