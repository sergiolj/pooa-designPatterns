package designpatterns.adapter.notification.util;

public class UserId {
	
	private UserId() {
		   /* This utility class should not be instantiated */
	}
	
	public static boolean isValid(String userId) {
		// Simple validation: check if the user ID is not null and not empty
		return userId != null && !userId.trim().isEmpty();
	}

}
