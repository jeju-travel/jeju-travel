package knh.model;

public class AirReserve {

	private int airReserveNo;
	private String takeOff;
	private String landing;
	private int personnel;
	private int reserveNo;
	private int airNo;
	
	
	public AirReserve() {
		super();
	}
	
	public int getAirReserveNo() {
		return airReserveNo;
	}
	public void setAirReserveNo(int airReserveNo) {
		this.airReserveNo = airReserveNo;
	}
	public String getTakeOff() {
		return takeOff;
	}
	public void setTakeOff(String takeOff) {
		this.takeOff = takeOff;
	}
	public String getLanding() {
		return landing;
	}
	public void setLanding(String landing) {
		this.landing = landing;
	}
	
	public int getPersonnel() {
		return personnel;
	}

	public void setPersonnel(int personnel) {
		this.personnel = personnel;
	}

	public int getReserveNo() {
		return reserveNo;
	}
	public void setReserveNo(int reserveNo) {
		this.reserveNo = reserveNo;
	}
	public int getAirNo() {
		return airNo;
	}
	public void setAirNo(int airNo) {
		this.airNo = airNo;
	}

	@Override
	public String toString() {
		return "AirReserve [airReserveNo=" + airReserveNo + ", takeOff=" + takeOff + ", landing=" + landing
				+ ", reserveNo=" + reserveNo + ", airNo=" + airNo + "]";
	}
}
