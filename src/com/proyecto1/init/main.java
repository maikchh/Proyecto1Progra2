package com.proyecto1.init;

import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatXcodeDarkIJTheme;
import com.proyecto1.mvc.controllers.ControllerPrincipal;

public class main {

	public static void main(String[] args) {
		FlatXcodeDarkIJTheme.setup();
		ControllerPrincipal controller = new ControllerPrincipal();
		controller.starting();
	}

}
