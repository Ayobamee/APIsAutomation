package Payloads;

public class AddCardWithPinPayload {

	public static String CardDetails(){
		
		String ClusterPayload = "{\r\n" + 
				"  \"cardNumber\": \"5531886652142950\",\r\n" + 
				"  \"cvv\": \"564\",\r\n" + 
				"  \"expirationDate\": \"09/32\",\r\n" + 
				"  \"pin\": \"3310\"\r\n" + 
				"}";
		
		return ClusterPayload;
		
	}



}
