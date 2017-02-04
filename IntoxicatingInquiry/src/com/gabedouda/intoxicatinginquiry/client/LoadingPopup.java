package com.gabedouda.intoxicatinginquiry.client;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LoadingPopup extends PopupPanel {

	public LoadingPopup() {
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.addStyleName("loadingPopup");
		
		setWidget(verticalPanel);
		
		Image loadingImage = new Image("img/loading/Loading_Glass.gif");
		loadingImage.addStyleName("loadingImage");
		verticalPanel.add(loadingImage);
		
		setGlassEnabled(true);
		center();
	}
}
