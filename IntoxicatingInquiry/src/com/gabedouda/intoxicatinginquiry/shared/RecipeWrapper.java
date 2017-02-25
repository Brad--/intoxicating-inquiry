package com.gabedouda.intoxicatinginquiry.shared;

import java.io.Serializable;
import java.util.ArrayList;

public class RecipeWrapper implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Recipe recipe;
	private ArrayList<RecipeIngredient> recipeIngredients;
	
	public Recipe getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	public ArrayList<RecipeIngredient> getRecipeIngredients() {
		return recipeIngredients;
	}
	public void setRecipeIngredients(ArrayList<RecipeIngredient> recipeIngredients) {
		this.recipeIngredients = recipeIngredients;
	}
}
