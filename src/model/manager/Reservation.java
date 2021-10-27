package model.manager;

public class Reservation {
	
	private int resNo;
	private int memNo;
	private String startDay;
	private String endDay;
	private String state;
	private String items;
	private int airResNo;
	private int carResNo;
	private int roomResNo;
	private int price;
	
	
	
	
	public int getairResNo() {
		return airResNo;
	}

	public void setairResNo(int airResNo) {
		this.airResNo = airResNo;
	}

	public int getcarResNo() {
		return carResNo;
	}

	public void setcarResNo(int carResNo) {
		this.carResNo = carResNo;
	}

	public int getroomResNo() {
		return roomResNo;
	}

	public void setroomResNo(int roomResNo) {
		this.roomResNo = roomResNo;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public Reservation() {
		
	}
	
	
	
	public Reservation(int resNo, int memNo, String startDay, String endDay, String state, String items, int airResNo,
			int carResNo, int roomResNo, int price) {
		super();
		this.resNo = resNo;
		this.memNo = memNo;
		this.startDay = startDay;
		this.endDay = endDay;
		this.state = state;
		this.items = items;
		this.airResNo = airResNo;
		this.carResNo = carResNo;
		this.roomResNo = roomResNo;
		this.price = price;
	}

	public Reservation(int resNo, int memNo, String startDay, String endDay, String state, int price) {
		super();
		this.resNo = resNo;
		this.memNo = memNo;
		this.startDay = startDay;
		this.endDay = endDay;
		this.state = state;
		this.price = price;
	}
	
	public Reservation( int memNo, String startDay, String endDay, String state, int price) {
		super();
		
		this.memNo = memNo;
		this.startDay = startDay;
		this.endDay = endDay;
		this.state = state;
		this.price = price;
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
				+ ", state=" + state + ", items=" + items + ", airResNo=" + airResNo + ", carResNo=" + carResNo + ", roomResNo="
				+ roomResNo + ", price=" + price + "]";
	}
	
	

	public void setPrice(int price) {
		this.price = price;
		
	}
	
	public int getPrice() {
		return price;
	}


	
	
	
	
}
