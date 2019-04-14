import javax.swing.JOptionPane;

public class Manager implements ManagerInterface {

	TripsManagement tripsmanagement = new TripsManagement();

	public void addNewDriver(String firstName,String lastName,double salary,String ID)
	{	tripsmanagement.LoadDrivers();
	    if(DriverExist(ID))
	    {
	    	JOptionPane.showMessageDialog(null, "Driver ID already exist");
	    }
	    else if (tripsmanagement.getDriverNumber()>=50)
	    	JOptionPane.showMessageDialog(null, "Sorry No Available Places for a new driver");
	    else {
		tripsmanagement.setDriverNumber(tripsmanagement.getDriverNumber()+1);	
		tripsmanagement.drivers[tripsmanagement.getDriverNumber()]=new Driver();
		tripsmanagement.drivers[tripsmanagement.getDriverNumber()].setDriverFirstName(firstName);
		tripsmanagement.drivers[tripsmanagement.getDriverNumber()].setDriverLastName(lastName);
		tripsmanagement.drivers[tripsmanagement.getDriverNumber()].setIdNumber(ID);
		tripsmanagement.drivers[tripsmanagement.getDriverNumber()].setSalary(salary);
		tripsmanagement.drivers[tripsmanagement.getDriverNumber()].setAvailable(true);
		tripsmanagement.SaveDrivers();
	    }
	}
	
	private boolean DriverExist(String ID)

	{	
		for(int i=0;i<=tripsmanagement.getDriverNumber();i++)
		{
			if (tripsmanagement.drivers[i].getIdNumber().equals(ID))
				return true;
		}
		return false;
	}
	
	public void SetNewVehicle(String type,String liscenceNumber)
	
	{  tripsmanagement.LoadVehicles();
    if (VehicleExist(liscenceNumber))
    {
    	JOptionPane.showMessageDialog(null, "Vehicle liscence already exist");
    }
    else if (tripsmanagement.getNumberOfVehicles()>=50)
    	JOptionPane.showMessageDialog(null, "Sorry No Available places to add vehicles ");
		
    else {	
		if(type=="Bus")
		{  
			tripsmanagement.setNumberOfVehicles(tripsmanagement.getNumberOfVehicles()+1);
			tripsmanagement.Vehicles[tripsmanagement.getNumberOfVehicles()]=new Bus();
		}
		
		else if(type=="Limousine")
		{
			tripsmanagement.setNumberOfVehicles(tripsmanagement.getNumberOfVehicles()+1);
			tripsmanagement.Vehicles[tripsmanagement.getNumberOfVehicles()]=new Limousine();
		}
		else if(type=="Minibus")
		{ 
			tripsmanagement.setNumberOfVehicles(tripsmanagement.getNumberOfVehicles()+1);
			tripsmanagement.Vehicles[tripsmanagement.getNumberOfVehicles()]=new Minibus();
		}
		
		tripsmanagement.Vehicles[tripsmanagement.getNumberOfVehicles()].addNewVehicle(liscenceNumber, tripsmanagement.getNumberOfVehicles(), tripsmanagement.Vehicles);
		tripsmanagement.SaveVehicles(tripsmanagement.getNumberOfVehicles());
	}}
	
	private boolean VehicleExist(String liscenceNumber ) {
		for(int i=0; i<=tripsmanagement.getNumberOfVehicles();i++)
		{
			if(tripsmanagement.Vehicles[i].getLiscenceNumber().equals(liscenceNumber))
				return true;
				
		}
		return false;
	}
	
	private int SearchForCars(String type )
	{  for (int i=0;i<=tripsmanagement.getNumberOfVehicles();i++)
	{
		if (tripsmanagement.Vehicles[i].getType()==type && tripsmanagement.Vehicles[i].getIsAvailable()==true)
			return i;
	}
		return -1;
	}
	
	public void SetNewTrip (String type,String Origin,String Destination,double Price , String Date,String Time ,String externalInternal, String flavor )
{   tripsmanagement.LoadFromFile();
    tripsmanagement.LoadDrivers();
    tripsmanagement.LoadVehicles();
   	int VehicleIndex=SearchForCars(type);
	int DriverIndex=SearchForDriver();
	
   	if(Origin.equals(Destination)) {
   		JOptionPane.showMessageDialog(null, "Error ! Origin is the same as Destination ,try again");
   	}
   	else if (VehicleIndex==-1)
   	JOptionPane.showMessageDialog(null, "Vehicle Not Found");
   	else if (DriverIndex==-1)
   		JOptionPane.showMessageDialog(null,"Driver Not Found");
    else if (tripsmanagement.TripNumber>=100)
    	JOptionPane.showMessageDialog(null, "Sorry No Available places to add Trips");
   	else
   	{
   		tripsmanagement.Vehicles[VehicleIndex].setIsAvailable(false );
   	   	tripsmanagement.drivers[DriverIndex].setAvailable(false);
   	   	tripsmanagement.TripNumber++;
   		tripsmanagement.Trips[tripsmanagement.TripNumber].setOrigin(Origin);
   		tripsmanagement.Trips[tripsmanagement.TripNumber].setDestination(Destination);
   		tripsmanagement.Trips[tripsmanagement.TripNumber].setPrice(Price);
   		tripsmanagement.Trips[tripsmanagement.TripNumber].setTripNo(tripsmanagement.TripNumber+1);
   		tripsmanagement.Trips[tripsmanagement.TripNumber].setDate(Date);
   		tripsmanagement.Trips[tripsmanagement.TripNumber].setTime(Time);
   		tripsmanagement.Trips[tripsmanagement.TripNumber].setLiscenceNumber(tripsmanagement.Vehicles[VehicleIndex].getLiscenceNumber());
   		tripsmanagement.Trips[tripsmanagement.TripNumber].setDriverID(tripsmanagement.drivers[DriverIndex].getIdNumber());
   		tripsmanagement.Trips[tripsmanagement.TripNumber].setInternalExternal(externalInternal);
   		tripsmanagement.Trips[tripsmanagement.TripNumber].setTripFlavor(flavor);
   		tripsmanagement.SaveToFile();
   	   	tripsmanagement.SaveDrivers();
   	   	tripsmanagement.SaveVehicles(tripsmanagement.getNumberOfVehicles());
   	}
}

	private int SearchForDriver()
{   for(int i=0;i<=tripsmanagement.getDriverNumber();i++)
	{  
		if(tripsmanagement.drivers[i].isAvailable==true)
			return i;
	}
	return -1;
}

	public void DeleteTrip(int tripno) {
		tripsmanagement.LoadFromFile();
		if (TripNotExist(tripno)) {
			JOptionPane.showMessageDialog(null, " Trip number  already exist");
		}
		else {
		
	int index=SearchForTrip(tripno);
	tripsmanagement.LoadDrivers();
	tripsmanagement.LoadVehicles();
	String driverId=tripsmanagement.Trips[index].getDriverID();
	String LiscenceNum=tripsmanagement.Trips[index].getLiscenceNumber();
	    while(index<(tripsmanagement.TripNumber))
	    {
	        tripsmanagement.Trips[index]=tripsmanagement.Trips[index+1];
	        index++;
	    }
	   
	
		for(int i=0;i<=tripsmanagement.getDriverNumber();i++)
		{
			if(tripsmanagement.drivers[i].getIdNumber().equals(driverId))
				tripsmanagement.drivers[i].setAvailable(true);
		}
		for (int i=0; i<=tripsmanagement.getNumberOfVehicles();i++) {
			if (tripsmanagement.Vehicles[i].getLiscenceNumber().equals(LiscenceNum))
				tripsmanagement.Vehicles[i].setIsAvailable(true);
		}
		
	    tripsmanagement.TripNumber=tripsmanagement.TripNumber-1;
	    tripsmanagement.SaveToFile();
	    tripsmanagement.SaveDrivers();
	    tripsmanagement.SaveVehicles(tripsmanagement.getNumberOfVehicles());
	}}
	
	private boolean  TripNotExist(int tripno) {
		for(int i=0; i<=tripsmanagement.TripNumber;i++) 
		{	if(tripsmanagement.Trips[i].getTripNo()==tripno)
				return true;			
	}	
		 return false;
	}
	
	public void DeleteVehicle(String LiscenceNumber) {
		int index=SearchToDeleteCar(LiscenceNumber);
		while(index<(tripsmanagement.getNumberOfVehicles()))
	    {
			tripsmanagement.Vehicles[index]=tripsmanagement.Vehicles[index+1];
	        index++;
	    }
	    tripsmanagement.setNumberOfVehicles(tripsmanagement.getNumberOfVehicles()-1);
	    tripsmanagement.SaveVehicles(tripsmanagement.getNumberOfVehicles());
		}

	private boolean VehicleNotExist (String liscenceNumber)
{
	tripsmanagement.LoadVehicles();
	for(int i=0;i<=tripsmanagement.getNumberOfVehicles();i++)
	{
		if(tripsmanagement.Vehicles[i].getLiscenceNumber().equals(liscenceNumber))
			return true;
	}
	return false;
}

	private int SearchToDeleteCar(String LiscenceNumber)
	{	tripsmanagement.LoadVehicles();
		for (int i=0;i<=tripsmanagement.getNumberOfVehicles();i++)
		{
			if(tripsmanagement.Vehicles[i].getLiscenceNumber().equals(LiscenceNumber))
				return i;
		}
		if(VehicleNotExist(LiscenceNumber))
      	return -1;
		return -1;
	}
	
	private int SearchForTrip(int tripNo)
{   tripsmanagement.LoadFromFile();
	for(int i=0;i<=tripsmanagement.TripNumber;i++)
	{   
		if (tripsmanagement.Trips[i].getTripNo()==tripNo)	
			return i;
	}
	return -1;
}

	public void DeleteDriver(String DriverId) {
		int index=SearchDeleteDriver(DriverId);
		while(index<(tripsmanagement.getDriverNumber()))
	    {
			tripsmanagement.drivers[index]=tripsmanagement.drivers[index+1];
	        index++;
	    }
	    tripsmanagement.setDriverNumber(tripsmanagement.getDriverNumber()-1);
	    tripsmanagement.SaveDrivers();
		}
	
	private int SearchDeleteDriver(String ID) {
		tripsmanagement.LoadDrivers();
			for (int i=0;i<=tripsmanagement.getDriverNumber();i++)
			{		
				if(tripsmanagement.drivers[i].getIdNumber().equals(ID))
					return i;
			}
			return -1;
	}
	
	
	

}
