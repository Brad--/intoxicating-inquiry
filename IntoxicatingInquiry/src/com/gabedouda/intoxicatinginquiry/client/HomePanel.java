package com.gabedouda.intoxicatinginquiry.client;

import com.gabedouda.intoxicatinginquiry.shared.User;
import com.gabedouda.intoxicatinginquiry.shared.Utilities;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class HomePanel extends BasePanel {
	
	private final VerticalPanel contentPanel = new VerticalPanel();
	private final Label contentHeaderLabel = new Label();

	public HomePanel() {
		super();
		init();
	}
	
	private void init() {
		final User user = Utilities.getLoggedInUser();
		
		getContentHeaderLabel().addStyleName("contentHeaderLabel");
		getContentPanel().addStyleName("contentPanel");
		
		VerticalPanel backingPanel = new VerticalPanel();
		backingPanel.addStyleName("backingPanel");
		backingPanel.addStyleName("loggedInBackingPanel");
		
		VerticalPanel mainPanel = new VerticalPanel();
		
		HorizontalPanel navigationPanel = new HorizontalPanel();
		navigationPanel.addStyleName("navigationPanel");
		
		Anchor inventoryAnchor = new Anchor("Inventory");
		inventoryAnchor.addStyleName("navigationAnchor");
		inventoryAnchor.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				swapContentPanel("Inventory", new InventoryPanel(user.getUserId()));
			}
		});
		
		Anchor inventorySearchAnchor = new Anchor("Inventory Search");
		inventorySearchAnchor.addStyleName("navigationAnchor");
		
		Anchor ingredientSearchAnchor = new Anchor("Ingredient Search");
		ingredientSearchAnchor.addStyleName("navigationAnchor");
		
		Anchor recipesAnchor = new Anchor("Recipes");
		recipesAnchor.addStyleName("navigationAnchor");
		recipesAnchor.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				swapContentPanel("Recipes", new RecipePanel());
			}
		});
		
		Anchor logoutAnchor = new Anchor("Logout");
		logoutAnchor.addStyleName("navigationAnchor");
		logoutAnchor.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				logout();
			}
		});
		navigationPanel.add(inventoryAnchor);
		navigationPanel.add(inventorySearchAnchor);
		navigationPanel.add(ingredientSearchAnchor);
		navigationPanel.add(recipesAnchor);
		navigationPanel.add(logoutAnchor);
		
		mainPanel.add(navigationPanel);
		mainPanel.add(getContentHeaderLabel());
		mainPanel.add(getContentPanel());
		
		backingPanel.add(mainPanel);
		
		swapContentPanel("Inventory", new InventoryPanel(user.getUserId()));
		
		add(backingPanel);
	}
	
	private void swapContentPanel(String title, VerticalContentAsyncPanel panel) {
		getContentHeaderLabel().setText(title);
		getContentPanel().clear();
		getContentPanel().add(panel);
	}
	
	private void logout() {
		clear();
		LoginPanel login = new LoginPanel();
	}

	public VerticalPanel getContentPanel() {
		return contentPanel;
	}

	public Label getContentHeaderLabel() {
		return contentHeaderLabel;
	}
}
