
public class Limousine extends Vehicle {

	public int getNumberOfSeats() {
		return 4; 
	}
	public String getType ()
	{
		return "Limousine" ;
	}
	
	public void addNewVehicle (String liscenceNumber,int index, Vehicle[] vehicle)
	{   
		vehicle[index].setIsAvailable(true);
		vehicle[index].setLiscenceNumber(liscenceNumber);	
		vehicle[index].setAvailableSeats(getNumberOfSeats());
	}
}
