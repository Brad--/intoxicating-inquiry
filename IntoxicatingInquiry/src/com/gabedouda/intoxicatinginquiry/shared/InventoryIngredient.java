package com.gabedouda.intoxicatinginquiry.shared;

import java.io.Serializable;

public class InventoryIngredient implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String INGREDIENT_SCOTCH = "Scotch";
	public static final String INGREDIENT_BOURBON = "Bourbon";
	public static final String INGREDIENT_GIN = "Gin";
	public static final String INGREDIENT_VODKA = "Vodka";
	public static final String INGREDIENT_RUM = "Rum";
	public static final String INGREDIENT_TEQUILA = "Tequila";

	private int inventoryIngredientId;
	private int userId;
	private String ingredient;
	
	public int getInventoryIngredientId() {
		return inventoryIngredientId;
	}
	public void setInventoryIngredientId(int inventoryIngredientId) {
		this.inventoryIngredientId = inventoryIngredientId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	
}
