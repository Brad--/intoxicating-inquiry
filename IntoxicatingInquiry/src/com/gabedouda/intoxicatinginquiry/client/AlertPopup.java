package com.gabedouda.intoxicatinginquiry.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AlertPopup extends PopupPanel {

	public AlertPopup(String message) {
		addStyleName("alertPopupBackground");
		
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.addStyleName("alertPopupVerticalPanel");
		
		Label messageLabel = new Label(message);
		messageLabel.addStyleName("alertPopupMessageText");
		Button closeButton = new Button("Close");
		closeButton.addStyleName("baseButton");
		closeButton.addStyleName("alertPopupCloseButton");
		closeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				close();
			}
		});
		
		setGlassEnabled(true);
		
		verticalPanel.add(messageLabel);
		verticalPanel.add(closeButton);
		
		setWidget(verticalPanel);
	}
	
	protected void close() {
		hide();
	}
}
