
public class Driver {
private String DriverFirstName;
private String DriverLastName;
private double Salary;
private String IdNumber;
boolean isAvailable;


public String getIdNumber() {
	return IdNumber;
}
public void setIdNumber(String idNumber) {
	IdNumber = idNumber;
}


public String getDriverFirstName() {
	return DriverFirstName;
}
public void setDriverFirstName(String driverFirstName) {
	DriverFirstName = driverFirstName;
}
public String getDriverLastName() {
	return DriverLastName;
}
public void setDriverLastName(String driverLastName) {
	DriverLastName = driverLastName;
}
public double getSalary() {
	return Salary;
}
public void setSalary(double salary) {
	Salary = salary;
}

public void setAvailable(boolean isAvailable) {
	this.isAvailable = isAvailable;
}

}
