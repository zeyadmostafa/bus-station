
public class Bus extends Vehicle
{   
	public int getNumberOfSeats() {
		return 50; 
	}
	public String getType ()
	{
		return "Bus" ;
	}
	
	public void addNewVehicle (String liscenceNumber,int index, Vehicle[] vehicle)
	{   
		vehicle[index].setIsAvailable(true);
		vehicle[index].setLiscenceNumber(liscenceNumber);
		vehicle[index].setAvailableSeats(getNumberOfSeats());
	}
	
	
	
	
}
