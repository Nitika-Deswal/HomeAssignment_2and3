package HomeAssignment_Assignment2;


import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.time.*;

//class Car with all setters and getter function
class Car {

	private int id;
	private String Make;
	private String Model;
	private int Year_of_Manufacture;
	private String Color;
	private double Price;
	private String Registration_Number;

	Car(int id, String make, String model, int year, String color, double price, String RegNum) { // constructor
		this.id = id;
		this.Make = make;
		this.Model = model;
		this.Year_of_Manufacture = year;
		this.Color = color;
		this.Price = price;
		this.Registration_Number = RegNum;
	}

	public String getMake() {
		return Make;
	}

	public int getyear() {
		return Year_of_Manufacture;
	}

	public String getmodel() {
		return Model;
	}

	public double getprice() {
		return Price;
	}

	public String getCarDetail() {
		return "Make is: " + Make + " and model is: " + Model;
	}
}


class HomeAssignment_Assignment2 {
	static String pathname = "/Users/apple/Desktop/"; // path defined to location where file will be created

	
	//Main function
	public static void main(String[] args) throws IOException {

		Car car[] = new Car[6]; 							// Array object of class Car

		car[0] = new Car(1, "Mercedes-Benz", "A-Class", 1998, "Blue", 25000.00, "reg-abc123");
		car[1] = new Car(2, "Audi", "A3", 2014, "Blue", 895000.00, "reg-asd2121");
		car[2] = new Car(3, "Audi", "A5", 2008, "Black", 89000.00, "reg-456gfh");
		car[3] = new Car(4, "Honda", "Accord", 2008, "Red", 465000.00, "reg-567ytr");
		car[4] = new Car(5, "Honda", "Accord Hybrid", 1998, "White", 789000.00, "reg-1234edrf");
		car[5] = new Car(6, "Volkswagen", "Areton", 2021, "Blue", 456000.00, "reg-erfd4567");

		OptionstoUser(car); 							// Function call. provides Menu to user with different options

	}

	
	/*Function "OptionstoUser" that provides 4 options to user with appropriate messages for different entries and performs operation based on input provided by user.
	  
	 Options 1 is to print list of cars for user-chosen make.
	 Option 2 is to print a list of cars of a given Model that have been in use for more than n years entered by user.
	 Option 3 is to print a list of cars of a given manufacturer, price higher than that provided by user
	 Option 4 is to exit the program. */
	
	public static void OptionstoUser(Car[] car) throws IOException {
		Scanner scanner = new Scanner(System.in);
		String choice;
		DisplayMenu();									//Display the options to user

		do {											//Read the input by user and calls the function according to input provided.		

			choice = scanner.nextLine();

			switch (choice) {
			case "1":
				String UserEnteredMake = getMakeName();				//Get the make from user
				ListofCars_byMake(car, UserEnteredMake);			//prints list of cars in ".txt" for the user entered make at location specified.
				break;
			case "2":
				String ModelName = ModelName();						//Get model name from user	
				String year = NumberofYear();						//get number of years from user
				Filter_cars_by_year(car, ModelName, year);			//print a list of cars in ".txt" of a given Model that have been in use for more than n years entered by user.
				break;
			case "3":
				String year2 = Year();								//Get Year from user
				String price = Price();								//Get price from user	
				Filter_cars_by_price(car, year2, price);			//print a list of cars in ".txt" of a given manufacturer, price higher than that provided by user
				break;
			case "4":
				System.out.println("Exiting the program");			//Exit the program
				System.exit(0);
			default:
				System.out.println("Please select a valid option");			//throws message if any option other than 1-4 is selected
				break;
			}

			String choice2 = "";											//Asks the user if they want to enter another choice between Yes or No. If no is selected, program is exited. If 'yes' is entered then 4 options are provided again. Else, message of 'invalid choice' is thrown
			do {
				System.out.println("Do you want to select another option? - select y or n");
				choice2 = scanner.nextLine().toLowerCase();
				if (choice2.equals("y") || choice2.equals("yes")) {
					DisplayMenu();
					break;
				} else if (choice2.equals("n") || choice2.equals("no")) {
					System.out.println("You selected that you do not want to continue. Exiting the program");
					System.exit(0);
				} else {
					System.out.println("Invalid input. Either select 'yes' or 'no'. Let's try again!");
				}
			} while (!choice2.equals("y") || !choice2.equals("yes") || !choice2.equals("n") || !choice2.equals("no"));

		} while (!choice.equals("4"));
	}

	
	public static void DisplayMenu() {									//Displays the main Menu option 
		System.out.println("Please enter between 1-4 based on the operation you want to perform from option below:\n"
				+ "option 1: Save List of cars of a given brand\n"
				+ "option 2: list of cars of a given model that have been in use for more than n years\n"
				+ "option 3: List of cars of a given year of manufacture, the price of which is higher than the specified one\n"
				+ "option 4: Exit the menu");
	}
	
	
	/*Function Filter_cars_by_year filters the cars based on model and year and prepare data to be written to the text file. Also, if no such data based
	filters added by user, the no file is created, but message is thrown that no such data exists to user. It prints the desired list to text file*/
	public static void Filter_cars_by_year(Car[] car, String Model, String year) {
		int year2 = Integer.parseInt(year);
		String DatatobeEnteredtoFile = "";

		for (Car car2 : car) {
			int carYear = (int) Math.round(2023 - car2.getyear());
			if (car2.getmodel().equalsIgnoreCase(Model) && (carYear > year2)) {
				DatatobeEnteredtoFile += (car2.getCarDetail());
				DatatobeEnteredtoFile += "\n";
			}
		}
		if (DatatobeEnteredtoFile == "") {										//Message thrown if no such record exists as per filter
			System.out.println("There is no car for the model " + Model + " which have been in use for more than "
					+ year + " years");
		} else
			PrintDatainFile(DatatobeEnteredtoFile, "List_by_year.txt");					//function called to create text file with desired output
	}

	
	
	/*Function Filter_cars_by_price filters the cars based on price and year and prepare data to be written to the text file. Also, if no such data based
	filters added by user, the no file is created, but message is thrown that no such data exists to user. It prints the desired list to text file*/
	public static void Filter_cars_by_price(Car[] car, String year2, String price) {

		int year3 = Integer.parseInt(year2);
		double price2 = Double.parseDouble(price);

		String DatatobeEnteredtoFile = "";

		for (Car car2 : car) {
			if (car2.getyear() == year3 && (car2.getprice() > price2)) {
				DatatobeEnteredtoFile += (car2.getCarDetail());
				DatatobeEnteredtoFile += "\n";
			}
		}
		if (DatatobeEnteredtoFile == "") {												//Message thrown if no such record exists as per filter	
			System.out.println("There is no car made in " + year2 + " whose price is more than " + price + "Euros");
		} else
			PrintDatainFile(DatatobeEnteredtoFile, "List_by_price.txt");				//function called to create text file with desired output
	}

	
	//Function "ListofCars_byMake" prints list of cars of specific make
	public static void ListofCars_byMake(Car[] car, String UserEnteredMake) {
		String DatatobeEnteredtoFile = "";
		for (Car car1 : car) {
			if (car1.getMake().equalsIgnoreCase(UserEnteredMake)) {
				DatatobeEnteredtoFile += (car1.getCarDetail());
				DatatobeEnteredtoFile += "\n";
			}
		}
		PrintDatainFile(DatatobeEnteredtoFile, "ListofCars.txt"); 		//Calls PrintDatainFile() along with data to be entered and name of file
	}


	
	//Function "getMakeName" to ask user to enter make from choices(1-4) provided. Else, message is thrown and user is entered to write choice again
	public static String getMakeName() {
		Scanner scanner = new Scanner(System.in);

		String choice = "";
		String MakeName = null;

		do {
			System.out.println("Please enter between 1-4 based on the make you want to select from option below:\n"
					+ "option 1: Mercedes-Benz\n" + "option 2: Audi\n" + "option 3: Honda\n"
					+ "option 4: Volkswagen\n");
			choice = scanner.nextLine();

			if (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4")) {
				System.out.println("Thank you for entering your choice. You entered option: " + choice);
			} else {
				System.err.println("Number is not between 1 and 4. Please re-enter your choice ");
			}
		} while (!(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4")));

		switch (choice) {								//Make is set based on option selected by user
		case "1":
			MakeName = "Mercedes-Benz";
			break;
		case "2":
			MakeName = "Audi";
			break;
		case "3":
			MakeName = "Honda";
			break;
		case "4":
			MakeName = "Volkswagen";
			break;
		}
		return MakeName;

	}

	
	//Function "ModelName" to ask user to enter make from choices(1-4) provided. Else, message is thrown and user is entered to write choice again
	public static String ModelName() {
		Scanner scanner = new Scanner(System.in);

		String choice = "";
		String ModelName = null;

		do {

			System.out.println("Please enter between 1-5 based on the make you want to select from option below:\n"
					+ "option 1: A-Class\n" + "option 2: A3\n" + "option 3: A5\n" + "option 4: Accord\n"
					+ "option 5: Accord Hybrdi\n");
			choice = scanner.nextLine();

			if (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4")
					|| choice.equals("5")) {
				System.out.println("Thank you for entering your choice. You entered option: " + choice);
			} else {
				System.err.println("Number is not between 1 and 5. Please re-enter your choice ");
			}
		} while (!(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4")
				|| choice.equals("5")));

		switch (choice) {							//Model is set based on choice entered by user
		case "1":
			ModelName = "A-Class";
			break;
		case "2":
			ModelName = "A3";
			break;
		case "3":
			ModelName = "A5";
			break;
		case "4":
			ModelName = "Accord";
			break;
		case "5":
			ModelName = "Accord Hybrdi";
			break;

		}
		return ModelName;

	}

	public static String Price() {						//input of price is taken from user
		System.out.println(
				"Enter a price for which you want to enter:\nPlease enter either whole number or decimals without comma");
		Scanner scanner = new Scanner(System.in);

		String price = scanner.nextLine();

		return price;

	}

	public static String NumberofYear() {					//Input of number of years taken from user
		System.out.println("Enter number of year for which you want to enter:");
		Scanner scn = new Scanner(System.in);

		String year = scn.nextLine();
		return year;
	}

	public static String Year() {					//input of year taken from user
		System.out.println("Enter year for which you want to check the data:\nPlease enter only a whole number");

		Scanner scn = new Scanner(System.in);

		String year = scn.nextLine();
		return year;
	}

	
	public static void PrintDatainFile(String DatatoEnterToFile, String FileName) {        //Function to create text file and save data in it
		try {
			File path = new File(pathname + FileName); // instance of file
			FileWriter wr = new FileWriter(path);
			wr.write(DatatoEnterToFile);
			wr.flush();
			wr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("The data has been entered into the file at path: " + pathname + FileName);
	}

	
	

}
