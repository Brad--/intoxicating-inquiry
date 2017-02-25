package com.gabedouda.intoxicatinginquiry.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.gabedouda.intoxicatinginquiry.client.GreetingService;
import com.gabedouda.intoxicatinginquiry.shared.InventoryIngredient;
import com.gabedouda.intoxicatinginquiry.shared.Recipe;
import com.gabedouda.intoxicatinginquiry.shared.RecipeIngredient;
import com.gabedouda.intoxicatinginquiry.shared.RecipeWrapper;
import com.gabedouda.intoxicatinginquiry.shared.User;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {
	
	private Connection getNewConnection() throws Exception {
	    Context ctx = new InitialContext();
	    DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/intoxicatinginquiryDS");
	    Connection conn = ds.getConnection();
 
        return conn;
	}
	
	private void closeConnection(Connection conn) throws Exception {
		if (conn != null) {
			conn.close();
		}
	}
	
	@Override
	public User loginAndGetUser(String username, String password) throws Exception {
		User user = null;
		
		String sql = "SELECT * FROM user WHERE username=? AND password=?";
		
		Connection conn = null;
		
		conn = getNewConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			user = new User();
			user.setUserId(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setRole(rs.getString(4));
		}
		
		closeConnection(conn);
		
		return user;
	}
	
	@Override
	public ArrayList<InventoryIngredient> getInventoryIngredientsForUserId(int userId) throws Exception {
		ArrayList<InventoryIngredient> ingredientsList = new ArrayList<InventoryIngredient>();
		
		String sql = "SELECT * FROM inventory_ingredient WHERE userId=?";
		
		Connection conn = null;
		
		conn = getNewConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userId);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			InventoryIngredient inventoryIngredient = new InventoryIngredient();
			inventoryIngredient.setInventoryIngredientId(rs.getInt(1));
			inventoryIngredient.setUserId(rs.getInt(2));
			inventoryIngredient.setIngredient(rs.getString(3));
			ingredientsList.add(inventoryIngredient);
		}
		
		closeConnection(conn);
		
		return ingredientsList;
	}
	
	@Override
	public void deleteInventoryIngredientById(int inventoryIngredientId) throws Exception {
		
		String sql = "DELETE FROM inventory_ingredient WHERE inventoryIngredientId=?";
		
		Connection conn = getNewConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, inventoryIngredientId);
		
		ps.executeUpdate();
		
		closeConnection(conn);
	}
	
	@Override
	public ArrayList<RecipeWrapper> getAllRecipeWrappers() throws Exception {
		ArrayList<RecipeWrapper> recipeWrappers = new ArrayList<RecipeWrapper>();
		
		String sql = "SELECT * FROM recipe";
		
		Connection conn = null;
		
		conn = getNewConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
		while(rs.next()) {
			Recipe recipe = new Recipe();
			recipe.setRecipeId(rs.getInt(1));
			recipe.setRecipeName(rs.getString(2));
			recipeList.add(recipe);
		}
		
		closeConnection(conn);
		
		for(Recipe recipe : recipeList) {
			RecipeWrapper recipeWrapper = new RecipeWrapper();
			recipeWrapper.setRecipe(recipe);
			recipeWrapper.setRecipeIngredients(getRecipeIngredientsByRecipeId(recipe.getRecipeId()));
			recipeWrappers.add(recipeWrapper);
		}
		
		return recipeWrappers;
	}
	
	private ArrayList<RecipeIngredient> getRecipeIngredientsByRecipeId(int recipeId) throws Exception {
		ArrayList<RecipeIngredient> recipeIngredientList = new ArrayList<RecipeIngredient>();
		
		String sql = "SELECT * FROM recipe_ingredient WHERE recipeId=?";
		
		Connection conn = null;
		
		conn = getNewConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, recipeId);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			RecipeIngredient recipeIngredient = new RecipeIngredient();
			recipeIngredient.setRecipeIngredientId(rs.getInt(1));
			recipeIngredient.setRecipeId(rs.getInt(2));
			recipeIngredient.setAmount(rs.getString(3));
			recipeIngredient.setIngredient(rs.getString(4));
			recipeIngredientList.add(recipeIngredient);
		}
		
		closeConnection(conn);
		
		return recipeIngredientList;
	}
	
}
