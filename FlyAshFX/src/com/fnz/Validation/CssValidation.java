package com.fnz.Validation;

import javafx.scene.control.TextField;

public class CssValidation {

	public void removeCssErrorStyle(Object...args){
		int noOfArgs;
		TextField tmpTextField;
		
		noOfArgs = args.length;
		for (int d=0;d<noOfArgs;d++){
			tmpTextField = (TextField) args[d];
			tmpTextField.getStyleClass().remove("error");
		}
	}
	
}
