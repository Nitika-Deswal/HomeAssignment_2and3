package HomeAssignment_Assignment3;

abstract class Vehicle {

	Manufacturer manufacturer1;
	Engine engine1;

	public Vehicle(Manufacturer manfacturer, Engine engine) { // Constructor of class Vehicle
		this.manufacturer1 = manfacturer;
		this.engine1 = engine;
	}

	public abstract void showcharacteristics(); // abstract method of class Vehicle
}

class ICEV extends Vehicle {

	public ICEV(Manufacturer manfacturer, Engine engine) {					//Constructor of class ICEV
		super(manfacturer, engine);
	}

	public void showcharacteristics() {										//Definition of abstract method
		System.out.println("Manufacturer:" + manufacturer1.getMake());
		System.out.println("\nModel of Engine by this manufacturer is:" + manufacturer1.getModel());
		System.out.println(
				"\nYear of Manufacture of Engine by this manufacturer is:" + manufacturer1.getYear_of_Manufacture());
		System.out.println("\nColor of Engine is by this manufacturer:" + manufacturer1.getColor());
		System.out.println("\nPrice of Engine is by this manufacturer:" + manufacturer1.getPrice());
		System.out.println(
				"\nRegistration Number of Engine is by this manufacturer:" + manufacturer1.getRegistration_Number());
		System.out.println("\nID of the Engine is :" + engine1.getID());
		System.out.println("\nEngine type is:" + engine1.getEngineType());
		System.out.println("\nFuel Intake of Engine is:" + ((CombustionEngine) engine1).getFuelIntake() + " litres");

	}
}

class BEV extends Vehicle {

	public BEV(Manufacturer manfacturer, Engine engine) {					//Constructor of class BEV
		super(manfacturer, engine);
	}

	public void showcharacteristics() {										//Definition of abstract method
		System.out.println("Manufacturer:" + manufacturer1.getMake());
		System.out.println("\nModel of Engine by this manufacturer is:" + manufacturer1.getModel());
		System.out.println(
				"\nYear of Manufacture of Engine by this manufacturer is:" + manufacturer1.getYear_of_Manufacture());
		System.out.println("\nColor of Engine is by this manufacturer:" + manufacturer1.getColor());
		System.out.println("\nPrice of Engine is by this manufacturer:" + manufacturer1.getPrice());
		System.out.println(
				"\nRegistration Number of Engine is by this manufacturer:" + manufacturer1.getRegistration_Number());
		System.out.println("\nID of the Engine is :" + engine1.getID());
		System.out.println("\nEngine type is:" + engine1.getEngineType());
		System.out.println("\nEnergy Intake of Engine is:" + ((ElectricEngine) engine1).getElectricIntake() + " kWH");

	}
}

class HybridV extends Vehicle {

	public HybridV(Manufacturer manfacturer, Engine engine) {					//Constructor of class HybridV
		super(manfacturer, engine);
	}

	public void showcharacteristics() {											//Definition of abstract method
		System.out.println("Manufacturer:" + manufacturer1.getMake());
		System.out.println("\nModel of Engine by this manufacturer is:" + manufacturer1.getModel());
		System.out.println(
				"\nYear of Manufacture of Engine by this manufacturer is:" + manufacturer1.getYear_of_Manufacture());
		System.out.println("\nColor of Engine is by this manufacturer:" + manufacturer1.getColor());
		System.out.println("\nPrice of Engine is by this manufacturer:" + manufacturer1.getPrice());
		System.out.println(
				"\nRegistration Number of Engine is by this manufacturer:" + manufacturer1.getRegistration_Number());
		System.out.println("\nID of the Engine is :" + engine1.getID());
		System.out.println("\nEngine type is:" + engine1.getEngineType());
		System.out.println("\nEnergy Intake of Engine is:" + ((HybridEngine) engine1).getElectricIntake() + " kWH");
		System.out.println("\nFuel Intake of Engine is:" + ((HybridEngine) engine1).getFuelIntake() + " litres");

	}
}

