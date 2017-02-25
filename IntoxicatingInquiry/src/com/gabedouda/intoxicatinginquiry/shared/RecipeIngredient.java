package com.gabedouda.intoxicatinginquiry.shared;

import java.io.Serializable;

public class RecipeIngredient implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int recipeIngredientId;
	private int recipeId;
	private String amount;
	private String ingredient;
	
	public int getRecipeIngredientId() {
		return recipeIngredientId;
	}
	public void setRecipeIngredientId(int recipeIngredientId) {
		this.recipeIngredientId = recipeIngredientId;
	}
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	
}
