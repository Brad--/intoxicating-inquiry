package com.gabedouda.intoxicatinginquiry.shared;

import com.gabedouda.intoxicatinginquiry.client.AlertPopup;

public class Utilities {
	
	private static User loggedInUser;

	public static void showAlert(String message) {
		AlertPopup alert = new AlertPopup(message);
		alert.center();
	}
	
	public static boolean isNotEmpty(String str) {
		boolean notEmpty = false;
		if(str != null && !str.isEmpty()) {
			notEmpty = true;
		}
		return notEmpty;
	}

	public static User getLoggedInUser() {
		return loggedInUser;
	}

	public static void setLoggedInUser(User loggedInUser) {
		Utilities.loggedInUser = loggedInUser;
	}
}
