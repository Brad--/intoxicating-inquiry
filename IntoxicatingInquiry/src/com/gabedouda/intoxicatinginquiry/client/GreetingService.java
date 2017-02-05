package com.gabedouda.intoxicatinginquiry.client;

import java.util.ArrayList;

import com.gabedouda.intoxicatinginquiry.shared.InventoryIngredient;
import com.gabedouda.intoxicatinginquiry.shared.User;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {

	User loginAndGetUser(String username, String password) throws Exception;

	ArrayList<InventoryIngredient> getInventoryIngredientsForUserId(int userId) throws Exception ;

}
