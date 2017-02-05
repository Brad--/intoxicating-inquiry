package com.gabedouda.intoxicatinginquiry.client;

import java.util.ArrayList;

import com.gabedouda.intoxicatinginquiry.shared.InventoryIngredient;
import com.gabedouda.intoxicatinginquiry.shared.Utilities;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class InventoryPanel extends VerticalContentAsyncPanel {
	
	private int userId;
	private final VerticalPanel contentPanel = new VerticalPanel();

	public InventoryPanel(int userId) {
		setUserId(userId);
		init();
	}
	
	private void init() {
		add(getContentPanel());
		loadContentPanel();
	}
	
	private void loadContentPanel() {
		final LoadingPopup loadingPopup = new LoadingPopup();
		getGreetingService().getInventoryIngredientsForUserId(getUserId(), new AsyncCallback<ArrayList<InventoryIngredient>>() {

			@Override
			public void onFailure(Throwable caught) {
				loadingPopup.hide();
				Utilities.showAlert(caught.getMessage());
			}

			@Override
			public void onSuccess(ArrayList<InventoryIngredient> result) {
				loadingPopup.hide();
				getContentPanel().clear();
				for(InventoryIngredient inventoryIngredient : result) {
					getContentPanel().add(new InventoryIngredientDisplayWidget(inventoryIngredient));
				}
			}});
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public VerticalPanel getContentPanel() {
		return contentPanel;
	}

}
