
public class Minibus extends Vehicle{
	public int getNumberOfSeats() {
		return 12; 
	}
	public String getType ()
	{
		return "Minibus" ;
	}
	
	public void addNewVehicle (String liscenceNumber,int index, Vehicle[] vehicle)
	{ 
		vehicle[index].setIsAvailable(true);
		vehicle[index].setLiscenceNumber(liscenceNumber);	
		vehicle[index].setAvailableSeats(getNumberOfSeats());
	}
}
