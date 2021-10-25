package reserve;

public class Reservation {
	
	private int resNo;
	private int memNo;
	private String startDay;
	private String endDay;
	private String state;
	private String items;
	
	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public Reservation() {
		
	}
	
	public Reservation(int resNo, int memNo, String startDay, String endDay, String state) {
		super();
		this.resNo = resNo;
		this.memNo = memNo;
		this.startDay = startDay;
		this.endDay = endDay;
		this.state = state;
	}
	
	public Reservation( int memNo, String startDay, String endDay, String state) {
		super();
		
		this.memNo = memNo;
		this.startDay = startDay;
		this.endDay = endDay;
		this.state = state;
	}
	
	public int getResNo() {
		return resNo;
	}
	public void setResNo(int resNo) {
		this.resNo = resNo;
	}
	public int getMemNo() {
		return memNo;
	}
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
	public String getStartDay() {
		return startDay;
	}
	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}
	public String getEndDay() {
		return endDay;
	}
	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Reservation [resNo=" + resNo + ", memNo=" + memNo + ", startDay=" + startDay + ", endDay=" + endDay
				+ ", state=" + state + "]";
	}


	
	
	
	
}
