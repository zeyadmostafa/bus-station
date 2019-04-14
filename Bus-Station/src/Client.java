public class Client {
private int tripNo;
private String FirstName;
private String LastName;
private String MobileNumber;
private int NumberOfTickets;

public Client(String firstname2, String lastname2, String mobilenumber2, int numberOfTickets2, int tripno2) {
	this.FirstName=firstname2;
	this.LastName=lastname2;
	this.MobileNumber=mobilenumber2;
	this.NumberOfTickets=numberOfTickets2;
	this.tripNo=tripno2;
}
public Client() {
	// TODO Auto-generated constructor stub
}
public int getTripNo() {
	return tripNo;
}
public void setTripNo(int tripNo) {
	this.tripNo = tripNo;
}
public String getFirstName() {
	return FirstName;
}
public void setFirstName(String firstName) {
	FirstName = firstName;
}
public String getLastName() {
	return LastName;
}
public void setLastName(String lastName) {
	LastName = lastName;
}
public String getMobileNumber() {
	return MobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	MobileNumber = mobileNumber;
}
public int getNumberOfTickets() {
	return NumberOfTickets;
}
public void setNumberOfTickets(int numberOfTickets) {
	NumberOfTickets = numberOfTickets;
}

}
