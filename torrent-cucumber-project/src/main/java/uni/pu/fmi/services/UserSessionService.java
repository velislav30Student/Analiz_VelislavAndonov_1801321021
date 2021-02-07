package uni.pu.fmi.services;

import uni.pu.fmi.User;

public class UserSessionService {
	private static User currentUser = null;
	
	public static User getCurrentUser() {
		return currentUser;
	}

	public static void LogIn() {
		currentUser = new User();
	}
	
	public static void LogOut() {
		currentUser = null;
	}

	public static void PromoteUser() {
		if(currentUser!=null) {
			currentUser.setIsAdmin(true);
		}
	}
	
	public static void DemoteUser() {
		if(currentUser!=null) {
			currentUser.setIsAdmin(false);
		}
	}
}
