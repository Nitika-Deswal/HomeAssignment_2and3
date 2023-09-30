package HomeAssignment_Assignment3;

class Manufacturer {
	public String Make;
	private String Model;
	private int Year_of_Manufacture;
	private String Color;
	private double Price;
	private String Registration_Number;

	// Get and set functions of attributes of class
	public String getMake() {
		return Make;
	}

	public void setMake(String make) {
		Make = make;
	}

	public int getYear_of_Manufacture() {
		return Year_of_Manufacture;
	}

	public void setYear_of_Manufacture(int year_of_Manufacture) {
		Year_of_Manufacture = year_of_Manufacture;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public String getRegistration_Number() {
		return Registration_Number;
	}

	public void setRegistration_Number(String registration_Number) {
		Registration_Number = registration_Number;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}
}
