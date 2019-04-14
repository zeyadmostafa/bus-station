
public interface ClientAccessibility { 
	//void CalculateSeatNo();

	void CancelReservation(String MobileNumber,int tripNo,int NumberOfTickets);
    void SearchforRound();
	double AddClientInfo(String firstname, String lastname, String mobilenumber, int numberOfTickets, int ticketno);
	double RoundTrip(String firstname, String lastname, String mobilenumber, int numberOfTickets, int tripno1,
			int tripno2);
	
}
