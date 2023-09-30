
/* The program prints information of manufacturer and Engine for each vehicle amongst BEV, ICEV and HybdridV.  
The program stores details of Engine in objects of CombustionEngine, ElectricEngine and Hybrid Engine. Manufacturer details are stored in objects of manufacturer.
Objects of vehicle subclasses BEV, ICEV, HybridV are created and attributes of Engine and Manufacturer are passed using relevant objects of each.

The showCharacteristic function in vehicle sub-class prints details of each vehicle type based on manufacturer and Engine object passed.
*/

package HomeAssignment_Assignment3;

import java.io.*;
import java.util.*;

public class MainClass {
	// main function
	public static void main(String[] args) {

		// Object of class CombustionEngine
		CombustionEngine CombustionEgngine1 = new CombustionEngine("Combustion", "Co-1234", 2000);
		CombustionEngine CombustionEgngine2 = new CombustionEngine("Combustion", "Co-12456", 9000);

		// Object of class ElectricEngine
		ElectricEngine ElectricEngine1 = new ElectricEngine("Electric", "El-1234", 2500);
		ElectricEngine ElectricEngine2 = new ElectricEngine("Electric", "El-12456", 9100);

		// Object of class HybridEngine
		HybridEngine HybridEngine1 = new HybridEngine("Hybrid", "Hy-1234", 1900, 2400);
		HybridEngine HybridEngine2 = new HybridEngine("Hybrid", "Hy-1236", 1930, 2800);

		// Object of class Manufacturer
		Manufacturer manufacturer1 = new Manufacturer();
		manufacturer1.setMake("Siemens");
		manufacturer1.setYear_of_Manufacture(2023);
		manufacturer1.setColor("blue");
		manufacturer1.setPrice(2400.90);
		manufacturer1.setRegistration_Number("Reg_1234");
		manufacturer1.setModel("Av909");

		Manufacturer manufacturer2 = new Manufacturer();
		manufacturer2.setMake("Eversource");
		manufacturer2.setYear_of_Manufacture(2019);
		manufacturer2.setColor("yellow");
		manufacturer2.setPrice(26780.90);
		manufacturer2.setRegistration_Number("Reg_2234");
		manufacturer2.setModel("Av9890");

		Manufacturer manufacturer3 = new Manufacturer();
		manufacturer3.setMake("TATA");
		manufacturer3.setYear_of_Manufacture(1991);
		manufacturer3.setColor("orange");
		manufacturer3.setPrice(2678.90);
		manufacturer3.setRegistration_Number("Reg_3456");
		manufacturer3.setModel("A567ty");

		int i = 1; // defined i to save the number of records

		// Objects of abstract class Vehicle
		Vehicle vehicle1 = new ICEV(manufacturer1, CombustionEgngine1);
		Vehicle vehicle2 = new ICEV(manufacturer1, CombustionEgngine1);
		Vehicle vehicle3 = new BEV(manufacturer2, ElectricEngine1);
		Vehicle vehicle4 = new BEV(manufacturer2, ElectricEngine2);
		Vehicle vehicle5 = new HybridV(manufacturer3, HybridEngine1);
		Vehicle vehicle6 = new HybridV(manufacturer3, HybridEngine2);

		Vehicle[] vehicleArr = { vehicle1, vehicle2, vehicle3, vehicle4, vehicle5, vehicle6 }; // Array of objects of class Vehicle

		for (Vehicle vehicle : vehicleArr) { // Loop to iterate through each record and print details of manufacturer and Engine for each Vehicle type
			System.out.println("\n***********************Record number : " + i + "********************************\n");
			vehicle.showcharacteristics();
			i++;
		}
	}

}
