package com.gabedouda.intoxicatinginquiry.client;

import com.gabedouda.intoxicatinginquiry.shared.Constants;
import com.google.gwt.user.client.ui.TextBox;

public class RestrictedTextBox extends TextBox {
	
	public RestrictedTextBox() {
		super();
		setMaxLength(Constants.MAX_CHARACTER_LENGTH);
	}

}
