package lodging.model;

public class Room_reserve {
	private int room_reserve_no;
	private String check_in;
	private String check_out;
	private int reserve_no;
	private int room_no;
	
	public Room_reserve() {}
	
	public Room_reserve(int room_reserve_no, String check_in, String check_out, int reserve_no, int room_no) {
		super();
		this.room_reserve_no = room_reserve_no;
		this.check_in = check_in;
		this.check_out = check_out;
		this.reserve_no = reserve_no;
		this.room_no = room_no;
	}
	
	public Room_reserve(String check_in, String check_out, int reserve_no, int room_no) {
		super();
		this.check_in = check_in;
		this.check_out = check_out;
		this.reserve_no = reserve_no;
		this.room_no = room_no;
	}
	
	@Override
	public String toString() {
		return "room_reserve [room_reserve_no=" + room_reserve_no + ", check_in=" + check_in + ", check_out="
				+ check_out + ", reserve_no=" + reserve_no + ", room_no=" + room_no + "]";
	}
	public int getRoom_reserve_no() {
		return room_reserve_no;
	}
	public void setRoom_reserve_no(int room_reserve_no) {
		this.room_reserve_no = room_reserve_no;
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
	public int getReserve_no() {
		return reserve_no;
	}
	public void setReserve_no(int reserve_no) {
		this.reserve_no = reserve_no;
	}
	public int getRoom_no() {
		return room_no;
	}
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	
	
}
