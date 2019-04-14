import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.io.*;
import java.util.*;

public class ReservationProcess implements ClientAccessibility {
	public boolean isString(String str) {
		char[] chars = str.toCharArray();
		for (char c : chars ) {
			if (!Character.isLetter(c)) {
				return false;
			}
		}
		
		return true;
	} 
	public boolean isNumber(String str) {
		char[] chars = str.toCharArray();
		for (char c : chars ) {
			if (Character.isLetter(c)) {
				return false;
			}
		}
		return true;
	}
	
	Client Clients= new Client();
	ArrayList<Client> clientsArray= new ArrayList<Client>();
	TripsManagement tripsmanagement= new TripsManagement();
	
	void SaveClient() {
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("Clients.txt");
		} catch (IOException e) {
			//  Auto-generated catch block
			e.printStackTrace();
		}
		bw = new BufferedWriter(fw);
		for(Client clients:clientsArray)
		{	String tickets =Integer.toString(clients.getNumberOfTickets());
			String TripNo=Integer.toString(clients.getTripNo());
			try {
				bw.write(clients.getFirstName()+","+clients.getLastName()+","+clients.getMobileNumber()+","+tickets+","+TripNo);
				bw.newLine();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			bw.close();
			fw.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

 	 void LoadToFile() {
 			//ArrayList<String> strings = new ArrayList<>(clientsArray.size());
 	 		//for (Object object : clientsArray) {
 	 		    //strings.add(object != null ? object.toString() : null);
 			FileReader fr=null;
 			try {
				fr= new FileReader("Clients.txt");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 			BufferedReader br= new BufferedReader (fr);
 			String line ;
 				try {
					while((line =br.readLine())!=null)
					{
					 String [] list = line.split(",");
					 clientsArray.add(new Client(list[0],list[1],list[2],Integer.parseInt(list[3]),Integer.parseInt(list[4])));
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally
 				{
					try {
						fr.close();
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
 				}
 		}
 			
	public double  AddClientInfo(String firstname,String lastname,String mobilenumber,int numberOfTickets,int tripno) {
		tripsmanagement.LoadFromFile();
		LoadToFile();
	    String tripLiscence=tripsmanagement.Trips[tripno-1].getLiscenceNumber();
	    int vehicleIndex=getVehicleIndex(tripLiscence);
	    int x=tripsmanagement.Vehicles[vehicleIndex].getAvailableSeats();
	    if(x<numberOfTickets)
	  {
		
		  return -1;
		
	  }
	  else {  
		   x=x-numberOfTickets;
		  tripsmanagement.Vehicles[vehicleIndex].setAvailableSeats(x);
		  tripsmanagement.SaveVehicles(tripsmanagement.getNumberOfVehicles());
		  Client clients=new Client (firstname,lastname,mobilenumber,numberOfTickets,tripno);
		  clientsArray.add(clients);
		  double price=tripsmanagement.Trips[tripno-1].getPrice()*numberOfTickets;
		  SaveClient();
		  return price;
		  }
	}
	
	boolean tripExist(int tripno)
	{
		tripsmanagement.LoadFromFile();
		for(int i=0;i<=tripsmanagement.TripNumber;i++)
		{
			if(tripsmanagement.Trips[i].getTripNo()==tripno)
				return true;
		}
		return false;
	}
   
	private int SearchInClients (String MobileNumber,int tripNo)
	{
		LoadToFile();
		for(int i=0;i<clientsArray.size();i++)
		{
			if(clientsArray.get(i).getMobileNumber().equals(MobileNumber)&&clientsArray.get(i).getTripNo()==tripNo)
				return i;
		}
		return -1;
	}
	
	private int getVehicleIndex(String Liscence)
	{ 
		tripsmanagement.LoadVehicles();
		for(int i=0;i<=tripsmanagement.getNumberOfVehicles();i++)
		{  
			if(Liscence.equals(tripsmanagement.Vehicles[i].getLiscenceNumber()))
			{ 
				return i;
			}
		}
		return -1;
	}
	
	public void CancelReservation(String MobileNumber,int tripNo,int numberOfTickets) 
	{	int index=SearchInClients(MobileNumber, tripNo);
	   	if(index==-1)
	   		JOptionPane.showMessageDialog(null, "Client Doesn't Exist");
	   	else {
		int decrement=clientsArray.get(index).getNumberOfTickets()-numberOfTickets;
		clientsArray.get(index).setNumberOfTickets(decrement);
		if(clientsArray.get(index).getNumberOfTickets()==0)
			clientsArray.remove(index);
		SaveClient();
	   	}
	}

	public double RoundTrip(String firstname,String lastname,String mobilenumber,int numberOfTickets,int tripno1,int tripno2) {
		TripsManagement tripsmanagement= new TripsManagement();
		tripsmanagement.LoadFromFile();
		tripsmanagement.LoadVehicles();
		LoadToFile();
	    String tripLiscence1=tripsmanagement.Trips[tripno1-1].getLiscenceNumber();
	    String tripLiscence2=tripsmanagement.Trips[tripno2-1].getLiscenceNumber();
	    int vehicleIndex1=getVehicleIndex(tripLiscence1);
	    int vehicleIndex2=getVehicleIndex(tripLiscence2);
	    int x=tripsmanagement.Vehicles[vehicleIndex1].getAvailableSeats();
	    int y=tripsmanagement.Vehicles[vehicleIndex2].getAvailableSeats();
	    
	    if(x<numberOfTickets||y<numberOfTickets)
	  {
		  return -1;
	  }
	  else {  
		   x=x-numberOfTickets;
		   y=y-numberOfTickets;
		  tripsmanagement.Vehicles[vehicleIndex1].setAvailableSeats(x);
		  tripsmanagement.Vehicles[vehicleIndex2].setAvailableSeats(y);
		  tripsmanagement.SaveVehicles(tripsmanagement.getNumberOfVehicles());
		  Client client1=new Client (firstname,lastname,mobilenumber,numberOfTickets,tripno1);
		  Client client2=new Client (firstname,lastname,mobilenumber,numberOfTickets,tripno2);
		  clientsArray.add(client1);
		  clientsArray.add(client2);
		  double price1=tripsmanagement.Trips[tripno1-1].getPrice();
		  double price2=tripsmanagement.Trips[tripno2-1].getPrice();
		 double price=(price1+price2)*numberOfTickets;
		 SaveClient();
		  return price;
		  }
		
	}

	public void SearchforRound() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
	ReservationProcess noha=new ReservationProcess();
	noha.CancelReservation("012",5,1);
	}
}