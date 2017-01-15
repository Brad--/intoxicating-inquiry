package com.gabedouda.intoxicatinginquiry.server;

import com.gabedouda.intoxicatinginquiry.client.GreetingService;
import com.gabedouda.intoxicatinginquiry.shared.User;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {
	
	@Override
	public User loginAndGetUser(String username, String password) throws Exception {
		
		return null;
	}
}
