package com.gabedouda.intoxicatinginquiry.shared;

import java.io.Serializable;

public class Recipe implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int recipeId;
	private String recipeName;
	
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	
}
