package Payloads;

public class SuperAdmnLoginPayload {

	

	public static String SuperAdLoginDetails(){
		

		String TicketPayload = "{\r\n" + 
				"  \"password\": \"112233\",\r\n" + 
				"  \"username\": \"admin\"\r\n" + 
				"}";
		
		return TicketPayload;
		
	}



}
