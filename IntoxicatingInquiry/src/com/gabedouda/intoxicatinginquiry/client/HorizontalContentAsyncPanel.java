package com.gabedouda.intoxicatinginquiry.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class HorizontalContentAsyncPanel extends HorizontalPanel {

	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	
	public GreetingServiceAsync getGreetingService() {
		return greetingService;
	}
	
}
