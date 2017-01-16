package com.gabedouda.intoxicatinginquiry.client;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class HomePanel extends BasePanel {

	public HomePanel() {
		super();
		init();
	}
	
	private void init() {
		VerticalPanel backingPanel = new VerticalPanel();
		backingPanel.addStyleName("backingPanel");
		backingPanel.addStyleName("loggedInBackingPanel");
		
		HorizontalPanel navigationPanel = new HorizontalPanel();
		Anchor viewRecipesAnchor = new Anchor("View Recipes");
		
		
		
		add(backingPanel);
	}
}
