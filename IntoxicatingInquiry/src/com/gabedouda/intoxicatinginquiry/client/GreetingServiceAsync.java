package com.gabedouda.intoxicatinginquiry.client;

import java.util.ArrayList;

import com.gabedouda.intoxicatinginquiry.shared.InventoryIngredient;
import com.gabedouda.intoxicatinginquiry.shared.User;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {

	void loginAndGetUser(String username, String password, AsyncCallback<User> callback);
	
	void getInventoryIngredientsForUserId(int userId, AsyncCallback<ArrayList<InventoryIngredient>> callback);
}
