package com.proyecto1.mvc.controllers;

import com.proyecto1.mvc.views.ViewPrincipal;

public class ControllerPrincipal {
	
	private ViewPrincipal vp;
	
	public ControllerPrincipal() {
		 vp = new ViewPrincipal();
	}
	
	public void starting() {
		vp.init();
	}

}
