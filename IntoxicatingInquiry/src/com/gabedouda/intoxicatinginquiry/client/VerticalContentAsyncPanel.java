package com.gabedouda.intoxicatinginquiry.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.VerticalPanel;

public class VerticalContentAsyncPanel extends VerticalPanel {

	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	
	public GreetingServiceAsync getGreetingService() {
		return greetingService;
	}
	
}
