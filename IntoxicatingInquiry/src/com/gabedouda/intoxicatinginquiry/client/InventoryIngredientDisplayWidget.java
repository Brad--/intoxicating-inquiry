package com.gabedouda.intoxicatinginquiry.client;

import com.gabedouda.intoxicatinginquiry.shared.InventoryIngredient;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;

public class InventoryIngredientDisplayWidget extends HorizontalContentAsyncPanel {

	private InventoryIngredient inventoryIngredient;
	
	public InventoryIngredientDisplayWidget(InventoryIngredient inventoryIngredient) {
		setInventoryIngredient(inventoryIngredient);
		
		Label ingredientLabel = new Label(inventoryIngredient.getIngredient());
		ingredientLabel.addStyleName("ingredientLabel");
		
		Button removeButton = new Button("Remove");
		removeButton.addStyleName("baseButton");
		removeButton.addStyleName("ingredientRemoveButton");
		
		add(ingredientLabel);
		add(removeButton);
		
	}

	public InventoryIngredient getInventoryIngredient() {
		return inventoryIngredient;
	}

	public void setInventoryIngredient(InventoryIngredient inventoryIngredient) {
		this.inventoryIngredient = inventoryIngredient;
	}
}
