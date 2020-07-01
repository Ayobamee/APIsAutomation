package Payloads;

public class AddCardPayload {

	public static String CardDetails(){
		
		String ClusterPayload = "{\r\n" + 
				"  \"cardNumber\": \"5531886652142950\",\r\n" + 
				"  \"cvv\": \"564\",\r\n" + 
				"  \"expirationDate\": \"09/32\"\r\n" + 
				"}";
		
		return ClusterPayload;
		
	}



}
