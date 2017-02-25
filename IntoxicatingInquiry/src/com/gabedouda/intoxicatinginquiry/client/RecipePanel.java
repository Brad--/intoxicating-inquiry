package com.gabedouda.intoxicatinginquiry.client;

import java.util.ArrayList;

import com.gabedouda.intoxicatinginquiry.shared.Recipe;
import com.gabedouda.intoxicatinginquiry.shared.RecipeIngredient;
import com.gabedouda.intoxicatinginquiry.shared.RecipeWrapper;
import com.gabedouda.intoxicatinginquiry.shared.Utilities;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class RecipePanel extends VerticalContentAsyncPanel {
	
	private final VerticalPanel contentPanel = new VerticalPanel();

	public RecipePanel() {
		init();
	}
	
	private void init() {
		add(getContentPanel());
		loadContentPanel();
	}
	
	private void loadContentPanel() {
		final LoadingPopup loadingPopup = new LoadingPopup();
		getGreetingService().getAllRecipeWrappers(new AsyncCallback<ArrayList<RecipeWrapper>>() {

			@Override
			public void onFailure(Throwable caught) {
				loadingPopup.hide();
				Utilities.showAlert(caught.getMessage());
			}

			@Override
			public void onSuccess(ArrayList<RecipeWrapper> result) {
				loadingPopup.hide();
				getContentPanel().clear();
				for(final RecipeWrapper recipeWrapper : result) {
					Recipe recipe = recipeWrapper.getRecipe();
					ArrayList<RecipeIngredient> recipeIngredients = recipeWrapper.getRecipeIngredients();
					
					if(recipe != null && recipeIngredients != null) {
						DisclosurePanel disclosurePanel = new DisclosurePanel(recipe.getRecipeName());
						
						FlexTable recipeIngredientTable = new FlexTable();
				        int row = 0;
						for(RecipeIngredient recipeIngredient : recipeIngredients) {
							if(recipeIngredient != null) {
								int col = 0;
								
								Label ingredientLabel = new Label(recipeIngredient.getIngredient());
								Label amountLabel = new Label(recipeIngredient.getAmount());
								
								recipeIngredientTable.setWidget(row, col++, ingredientLabel);
								recipeIngredientTable.setWidget(row++, col, amountLabel);
							}
						}
						disclosurePanel.add(recipeIngredientTable);
						getContentPanel().add(disclosurePanel);
					}

				}

			}});
	}
	
	public VerticalPanel getContentPanel() {
		return contentPanel;
	}
}
