package HomeAssignment_Assignment3;


class Engine {
	private String EngineType; // Store the type of Engine
	private String ID; // store the ID of Engine

	public Engine(String EngineType, String ID) { // Constructor of Engine
		this.setEngineType(EngineType);
		this.setID(ID);
	}

	public String getEngineType() { // getter of EngineType
		return EngineType;
	}

	public void setEngineType(String engineType) { // setter of EngineType
		EngineType = engineType;
	}

	public String getID() { // getter of ID
		return ID;
	}

	public void setID(String iD) { // setter of ID
		ID = iD;
	}
}

class CombustionEngine extends Engine { // subclass of superclassEngine
	private int FuelIntake;

	public CombustionEngine(String EngineType, String ID, int fuelintake) { // Constructor
		super(EngineType, ID);
		this.FuelIntake = fuelintake;
	}

	public int getFuelIntake() {
		return FuelIntake;
	}
}

class ElectricEngine extends Engine { // subclass of superclassEngine
	private int ElectricIntake;

	public ElectricEngine(String EngineType, String ID, int ElectricIntake) { // Constructor
		super(EngineType, ID);
		this.ElectricIntake = ElectricIntake;
	}

	public int getElectricIntake() {
		return ElectricIntake;
	}
}

class HybridEngine extends Engine { // subclass of superclassEngine
	private int FuelIntake;
	private int ElectricIntake;

	public HybridEngine(String EngineType, String ID, int fuelintake, int ElectricIntake) { // Constructor
		super(EngineType, ID);
		this.ElectricIntake = ElectricIntake;
		this.FuelIntake = fuelintake;
	}

	public int getFuelIntake() {
		return FuelIntake;
	}

	public int getElectricIntake() {
		return ElectricIntake;
	}

}

