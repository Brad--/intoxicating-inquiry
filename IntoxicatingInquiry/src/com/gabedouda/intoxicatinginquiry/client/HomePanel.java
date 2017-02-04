package com.gabedouda.intoxicatinginquiry.client;

import com.gabedouda.intoxicatinginquiry.shared.User;
import com.gabedouda.intoxicatinginquiry.shared.Utilities;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class HomePanel extends BasePanel {

	public HomePanel() {
		super();
		init();
	}
	
	private void init() {
		User user = Utilities.getLoggedInUser();
		
		VerticalPanel backingPanel = new VerticalPanel();
		backingPanel.addStyleName("backingPanel");
		backingPanel.addStyleName("loggedInBackingPanel");

		HorizontalPanel navigationPanel = new HorizontalPanel();
		
		Anchor viewRecipesAnchor = new Anchor("Recipes");
		viewRecipesAnchor.addStyleName("navigationAnchor");
		
		Anchor ingredientSearchAnchor = new Anchor("Ingredient Search");
		ingredientSearchAnchor.addStyleName("navigationAnchor");
		
		Anchor inventorySearchAnchor = new Anchor("Inventory Search");
		inventorySearchAnchor.addStyleName("navigationAnchor");
		
		Anchor inventoryAnchor = new Anchor("Inventory");
		inventoryAnchor.addStyleName("navigationAnchor");
		
		Anchor logoutAnchor = new Anchor("Logout");
		logoutAnchor.addStyleName("navigationAnchor");
		logoutAnchor.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				LoginPanel login = new LoginPanel();
			}
		});
		
		navigationPanel.add(viewRecipesAnchor);
		navigationPanel.add(ingredientSearchAnchor);
		navigationPanel.add(inventorySearchAnchor);
		navigationPanel.add(inventoryAnchor);
		navigationPanel.add(logoutAnchor);
		
		backingPanel.add(navigationPanel);
		
		add(backingPanel);
	}
}
