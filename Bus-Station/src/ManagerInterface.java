import javax.swing.JOptionPane;

public interface ManagerInterface {
	public void addNewDriver(String firstName,String lastName,double salary,String ID);
	public void SetNewVehicle(String type,String liscenceNumber);
	public void SetNewTrip (String type,String Origin,String Destination,double Price , String Date,String Time ,String externalInternal, String flavor );
	public void DeleteTrip(int tripno);
	public void DeleteVehicle(String LiscenceNumber);
	public void DeleteDriver(String DriverId);
}
