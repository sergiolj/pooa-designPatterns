package designpatterns.structural.adapter.notification.util;

public class EmailAddress {
	private EmailAddress() {
		/* This utility class should not be instantiated */
	}
	
	public static boolean isValid(String emailAddress) {
		// Simple validation: check if the email address contains "@" and "."
		return emailAddress != null && emailAddress.contains("@") && emailAddress.contains(".");
	}

}
