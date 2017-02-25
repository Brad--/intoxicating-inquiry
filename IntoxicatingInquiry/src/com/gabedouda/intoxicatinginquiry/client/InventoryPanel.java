package com.gabedouda.intoxicatinginquiry.client;

import java.util.ArrayList;

import com.gabedouda.intoxicatinginquiry.shared.InventoryIngredient;
import com.gabedouda.intoxicatinginquiry.shared.Utilities;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
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
				FlexTable flexTable = new FlexTable();
		        flexTable.setBorderWidth(0);
		        flexTable.setCellPadding(0);
		        flexTable.setCellSpacing(0);
				int row = 0;
				for(final InventoryIngredient inventoryIngredient : result) {
					int col = 0;
					Label ingredientLabel = new Label(inventoryIngredient.getIngredient());
					ingredientLabel.addStyleName("ingredientLabel");
					
					Button removeButton = new Button("Remove");
					removeButton.addStyleName("baseButton");
					removeButton.addStyleName("ingredientRemoveButton");
					removeButton.addClickHandler(new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							getGreetingService().deleteInventoryIngredientById(inventoryIngredient.getInventoryIngredientId(), new AsyncCallback<Void>() {

								@Override
								public void onFailure(Throwable caught) {
									Utilities.showAlert(caught.getMessage());
								}

								@Override
								public void onSuccess(Void result) {
									loadContentPanel();
								}});
						}
					});
					
					flexTable.setWidget(row, col++, ingredientLabel);
					flexTable.setWidget(row++, col, removeButton);
				}
				getContentPanel().add(flexTable);

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
