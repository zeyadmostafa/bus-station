
public abstract class Vehicle {
private int NumberOfSeats;
private String LiscenceNumber;
private int AvailableSeats;
private boolean IsAvailable;
private String Type; 

public void addNewVehicle(String liscenceNumber,int index, Vehicle[] vehicle)
{
	
}

public int getAvailableSeats() {
	return AvailableSeats;
}

public void setAvailableSeats(int availableSeats) {
	AvailableSeats = availableSeats;
}

public boolean getIsAvailable() {
	return IsAvailable;
}

public void setIsAvailable(boolean isAvailable) {
	IsAvailable = isAvailable;
}

public int getNumberOfSeats() {
	return NumberOfSeats;
}

public void setNumberOfSeats(int numberOfSeats) {
	NumberOfSeats = numberOfSeats;
}

public String getType() {
	return Type;
}

public void setType(String type) {
	Type = type;
}

public String getLiscenceNumber() {
	return LiscenceNumber;
}

public void setLiscenceNumber(String liscenceNumber) {
	LiscenceNumber = liscenceNumber;
}

}
