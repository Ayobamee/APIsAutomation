package Payloads;

public class AddCard3DSecurePayload {

	public static String CardDetails(){
		
		String ClusterPayload = "{\r\n" + 
				"  \"cardNumber\": \"4187427415564246\",\r\n" + 
				"  \"cvv\": \"828\",\r\n" + 
				"  \"expirationDate\": \"09/32\"\r\n" + 
				"}";
		
		return ClusterPayload;
		
	}



}
