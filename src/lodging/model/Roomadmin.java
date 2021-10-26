package lodging.model;

public class Roomadmin {
	private int room_no;
	private String room_name;
	private int room_price;
	private int room_personnel;
	private String room_configuration;
	private String room_service;
	private int lodging_no;
	private String room_image;
	
	public Roomadmin() {}
	
	public Roomadmin(int room_no, String room_name, int room_price, int room_personnel, String room_configuration,
			String room_service, int lodging_no, String room_image) {
		super();
		this.room_no = room_no;
		this.room_name = room_name;
		this.room_price = room_price;
		this.room_personnel = room_personnel;
		this.room_configuration = room_configuration;
		this.room_service = room_service;
		this.lodging_no = lodging_no;
		this.room_image = room_image;
	}
	
	public Roomadmin(String room_name, int room_price, int room_personnel, String room_configuration, String room_service,
			int lodging_no, String room_image) {
		super();
		this.room_name = room_name;
		this.room_price = room_price;
		this.room_personnel = room_personnel;
		this.room_configuration = room_configuration;
		this.room_service = room_service;
		this.lodging_no = lodging_no;
		this.room_image = room_image;
	}

	@Override
	public String toString() {
		return "room [room_no=" + room_no + ", room_name=" + room_name + ", room_price=" + room_price
				+ ", room_personnel=" + room_personnel + ", room_configuration=" + room_configuration
				+ ", room_service=" + room_service + ", lodging_no=" + lodging_no + ", room_image=" + room_image + "]";
	}
	public int getRoom_no() {
		return room_no;
	}
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public int getRoom_price() {
		return room_price;
	}
	public void setRoom_price(int room_price) {
		this.room_price = room_price;
	}
	public int getRoom_personnel() {
		return room_personnel;
	}
	public void setRoom_personnel(int room_personnel) {
		this.room_personnel = room_personnel;
	}
	public String getRoom_configuration() {
		return room_configuration;
	}
	public void setRoom_configuration(String room_configuration) {
		this.room_configuration = room_configuration;
	}
	public String getRoom_service() {
		return room_service;
	}
	public void setRoom_service(String room_service) {
		this.room_service = room_service;
	}
	public int getLodging_no() {
		return lodging_no;
	}
	public void setLodging_no(int lodging_no) {
		this.lodging_no = lodging_no;
	}
	public String getRoom_image() {
		return room_image;
	}
	public void setRoom_image(String room_image) {
		this.room_image = room_image;
	}
	
	
	
}
