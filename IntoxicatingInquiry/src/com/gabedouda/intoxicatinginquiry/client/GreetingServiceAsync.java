package com.gabedouda.intoxicatinginquiry.client;

import com.gabedouda.intoxicatinginquiry.shared.User;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {

	void loginAndGetUser(String username, String password, AsyncCallback<User> callback);
}
