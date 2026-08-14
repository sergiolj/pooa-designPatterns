package designpatterns.adapter.notification.util;

public class PhoneNumber {
	
	
 private PhoneNumber() {
   /* This utility class should not be instantiated */
 }

	public static boolean isValid(String phoneNumber) {
		// Simple validation: check if the phone number has 10 digits
		return phoneNumber != null && phoneNumber.matches("\\d{11}");
	}

}
