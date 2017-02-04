package com.gabedouda.intoxicatinginquiry.client;

import com.gabedouda.intoxicatinginquiry.shared.Constants;
import com.gabedouda.intoxicatinginquiry.shared.User;
import com.gabedouda.intoxicatinginquiry.shared.Utilities;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LoginPanel extends BasePanel implements EntryPoint {

	final RestrictedTextBox usernameTextBox = new RestrictedTextBox();
	final PasswordTextBox passwordTextBox = new PasswordTextBox();
	
	public LoginPanel() {
		super();
	}
	
	@Override
	public void onModuleLoad() {
		VerticalPanel backingPanel = new VerticalPanel();
		backingPanel.addStyleName("backingPanel");
		backingPanel.addStyleName("loginBackingPanel");
		
		usernameTextBox.addStyleName("loginBox");
		usernameTextBox.getElement().setPropertyString("placeholder", "Username");
		
		passwordTextBox.addStyleName("loginBox");
		passwordTextBox.getElement().setPropertyString("placeholder", "Password");
		passwordTextBox.setMaxLength(Constants.MAX_CHARACTER_LENGTH);
		
		usernameTextBox.addKeyPressHandler(new KeyPressHandler() {
			
			@Override
			public void onKeyPress(KeyPressEvent event) {
                boolean enterPressed = KeyCodes.KEY_ENTER == event
                        .getNativeEvent().getKeyCode();
                if (enterPressed)
                {
                	doLoginIfCredentialsValid(usernameTextBox.getValue(), passwordTextBox.getValue());
                }
			}
		});
		
		passwordTextBox.addKeyPressHandler(new KeyPressHandler() {
			
			@Override
			public void onKeyPress(KeyPressEvent event) {
                boolean enterPressed = KeyCodes.KEY_ENTER == event
                        .getNativeEvent().getKeyCode();
                if (enterPressed)
                {
                	doLoginIfCredentialsValid(usernameTextBox.getValue(), passwordTextBox.getValue());
                }
			}
		});
		
		final Button loginButton = new Button("Login");
		loginButton.addStyleName("loginButton");
		loginButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				doLoginIfCredentialsValid(usernameTextBox.getValue(), passwordTextBox.getValue());
			}
		});
		
		backingPanel.add(usernameTextBox);
		backingPanel.add(passwordTextBox);
		backingPanel.add(loginButton);
		
		add(backingPanel);

		usernameTextBox.setFocus(true);
	}
	
	private void doLoginIfCredentialsValid(String username, String password) {
		if(Utilities.isNotEmpty(username) && Utilities.isNotEmpty(password)) {
			final LoadingPopup loadingPopup = new LoadingPopup();
			getGreetingService().loginAndGetUser(username, password, new AsyncCallback<User>() {
	
				@Override
				public void onFailure(Throwable caught) {
					loadingPopup.hide();
					Utilities.showAlert("Call to server failed. Please try again.");
				}
	
				@Override
				public void onSuccess(User result) {
					loadingPopup.hide();
					if(result != null) {
						Utilities.setLoggedInUser(result);
						clear();
						HomePanel homePanel = new HomePanel();
					} else {
						AlertPopup alert = new AlertPopup("Invalid login credentials. Please try again.") {
							@Override
							protected void close() {
								hide();
								usernameTextBox.setValue("");
								passwordTextBox.setValue("");
							}
						};
						alert.center();
					}
					
				}
			});
		} else {
			Utilities.showAlert("Username and password cannot be empty.");
		}
	}

}
