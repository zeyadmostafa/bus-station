import java.io.*;
import java.util.*;



public class TripsManagement {
	public int TripNumber=-1;
	Driver drivers[]=new Driver[50];
	private int DriverNumber=-1;
	TripInfo [] Trips=new TripInfo[100];
	private Scanner x;
	private Formatter y;
	private Scanner Driverx;
	private Formatter Drivery;
	Bus buses = new Bus();
	Limousine limousines=new Limousine();
	Minibus minibuses=new Minibus();
	Vehicle Vehicles[]=new Vehicle[50];
	private int NumberOfVehicles=-1;
	private Scanner vehiclex;
	private Formatter vehicley;
	
	
	public int getNumberOfVehicles() {
		return NumberOfVehicles;
	}

	public void setNumberOfVehicles(int numberOfVehicles) {
		NumberOfVehicles = numberOfVehicles;
	}

	public int getDriverNumber() {
		return DriverNumber;
	}

	public void setDriverNumber(int driverNumber) {
		DriverNumber = driverNumber;
	}
	
	void LoadVehicles()


	{     
		try {
			vehiclex=new Scanner(new File("Vehicles.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(vehiclex.hasNext())
		{	NumberOfVehicles++;
			String TypeOfVeh=vehiclex.next();
			if(TypeOfVeh.equals("Bus"))
			{
				Vehicles[NumberOfVehicles]=new Bus();
			}
			else if (TypeOfVeh.equals("Limousine"))
			{
			Vehicles[NumberOfVehicles]=new Limousine();
			}
			else if (TypeOfVeh.equals("Minibus"))
			Vehicles[NumberOfVehicles]=new Minibus();
		
			Vehicles[NumberOfVehicles].setLiscenceNumber(vehiclex.next());
			Vehicles[NumberOfVehicles].setAvailableSeats(vehiclex.nextInt());
			Vehicles[NumberOfVehicles].setNumberOfSeats(vehiclex.nextInt());
			Vehicles[NumberOfVehicles].setIsAvailable(vehiclex.nextBoolean());
		}
	}
	
	public void LoadDrivers()
	{	
		try {
			Driverx=new Scanner(new File("Drivers.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(Driverx.hasNext())
		{	DriverNumber++;
			drivers[DriverNumber]=new Driver();
			drivers[DriverNumber].setDriverFirstName(Driverx.next());
			drivers[DriverNumber].setDriverLastName(Driverx.next());
			drivers[DriverNumber].setIdNumber(Driverx.next());
			drivers[DriverNumber].setSalary(Driverx.nextDouble());
			drivers[DriverNumber].setAvailable(Driverx.nextBoolean());
		}
	}
	
	void SaveVehicles(int lastindex)
	{
		try {
		vehicley= new Formatter ("Vehicles.txt");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	for(int i=0;i<=lastindex;i++)
	{   vehicley.format("%s %s %d %d %s %n",Vehicles[i].getType(),Vehicles[i].getLiscenceNumber(),Vehicles[i].getAvailableSeats(),Vehicles[i].getNumberOfSeats(),Boolean.toString(Vehicles[i].getIsAvailable()));
	}
	vehicley.close();
	}
	
	public void SaveDrivers()
	{

		try {
		Drivery= new Formatter ("Drivers.txt");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	for(int i=0;i<=DriverNumber;i++)
	{   Drivery.format("%s %s %s %f %s  %n",drivers[i].getDriverFirstName(),drivers[i].getDriverLastName(),drivers[i].getIdNumber(),drivers[i].getSalary(),drivers[i].isAvailable);
	   
	}
		Drivery.close();
	}

	
	void SaveToFile()
	{
		try {
		y= new Formatter ("Trips.txt");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	for(int i=0;i<=TripNumber;i++)
	{   y.format("%d %s %s %s %s %f %s %s %s %s %n",Trips[i].getTripNo(),Trips[i].getOrigin(),Trips[i].getDestination(),Trips[i].getInternalExternal(),Trips[i].getTripFlavor(),Trips[i].getPrice(),Trips[i].getDate(),Trips[i].getTime(),Trips[i].getLiscenceNumber(),Trips[i].getDriverID());
	   
	}
		y.close();
	}
	
	
	void LoadFromFile()
	{  
		for(int i=0;i<Trips.length;i++)
		{
			Trips[i]=new TripInfo();
		}
		
		try {
			x=new Scanner(new File("Trips.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(x.hasNext())
		{	TripNumber++;
			x.nextInt();
			Trips[TripNumber].setTripNo(TripNumber+1);
			Trips[TripNumber].setOrigin(x.next());
			Trips[TripNumber].setDestination(x.next());
			Trips[TripNumber].setInternalExternal(x.next());
			Trips[TripNumber].setTripFlavor(x.next());
			Trips[TripNumber].setPrice(x.nextDouble());
			Trips[TripNumber].setDate(x.next());
			Trips[TripNumber].setTime(x.next());
			Trips[TripNumber].setLiscenceNumber(x.next());
			Trips[TripNumber].setDriverID(x.next());
		}
	}
	
	
	public static void main(String[] args) {
	TripsManagement noha =new TripsManagement();
	noha.LoadDrivers();
	noha.SaveDrivers();
		
	}
	}
