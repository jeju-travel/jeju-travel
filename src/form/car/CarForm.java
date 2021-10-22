package form.car;

public class CarForm {
	private String car_name;
	private String car_type;
	private String car_price;
	private String capacity;
	private String car_fuel;
	private String car_loc;
	
	public CarForm() {}

	public CarForm(String car_name, String car_type, String car_price, String capacity, String car_fuel,
			String car_loc) {
		super();
		this.car_name = car_name;
		this.car_type = car_type;
		this.car_price = car_price;
		this.capacity = capacity;
		this.car_fuel = car_fuel;
		this.car_loc = car_loc;
	}

	public String getCar_name() {
		return car_name;
	}

	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}

	public String getCar_type() {
		return car_type;
	}

	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}

	public String getCar_price() {
		return car_price;
	}

	public void setCar_price(String car_price) {
		this.car_price = car_price;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getCar_fuel() {
		return car_fuel;
	}

	public void setCar_fuel(String car_fuel) {
		this.car_fuel = car_fuel;
	}

	public String getCar_loc() {
		return car_loc;
	}

	public void setCar_loc(String car_loc) {
		this.car_loc = car_loc;
	}

	@Override
	public String toString() {
		return "CarForm [car_name=" + car_name + ", car_type=" + car_type + ", car_price=" + car_price + ", capacity="
				+ capacity + ", car_fuel=" + car_fuel + ", car_loc=" + car_loc + "]";
	}
	
	
	
	
}
