package com.gabedouda.intoxicatinginquiry.client;

import com.gabedouda.intoxicatinginquiry.shared.User;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {

	User loginAndGetUser(String username, String password) throws Exception;

}
