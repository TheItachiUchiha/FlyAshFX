package com.fnz.utilities;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ModalDialog {
	Button okButton, yesButton, noButton;
	
	
	
	
	
	  public void ModalDialogUpload(final Stage stg,String title, String message) {
		  
	        
	        final  Stage stage = new Stage(StageStyle.UTILITY);           
	            //Initialize the Stage with type of modal
	        Font font = Font.font("Calibri", FontWeight.NORMAL, 14);
	            stage.initModality(Modality.APPLICATION_MODAL);
	            stage.setResizable(false);
	            //Set the owner of the Stage 
	            stage.initOwner(stg);
	            stage.setTitle(title);
	            Group root = new Group();
	             Scene scene = new Scene(root);
	             
	             Label label = new Label();
	             label.setText(message);
	             label.setFont(font);
	             label.setMinWidth(300);
	             
	             BorderPane borderPane = new BorderPane();
	             borderPane.setPadding(new Insets(25,20,20,20));
	             
	             HBox btnHBox = new HBox(15);
	             btnHBox.setPadding(new Insets(20,5,5,5));
	             btnHBox.setAlignment(Pos.CENTER);
	             
	            	 okButton = new Button("OK");
	            	okButton.setPrefWidth(70);
	            	 btnHBox.getChildren().addAll(okButton);
	         
	            
	     		//borderPane.setTop(topAnchorPane);
	     		borderPane.setCenter(label);
	     		borderPane.setBottom(btnHBox);
	     		okButton.setOnAction(new EventHandler<ActionEvent>() {
	     
	                public void handle(ActionEvent event) {
	                	
	                	
	                	
	                	
	                 stage.close();
	                 
	                 
	                    
	                }
	            });
	             
	            
	           
	            root.getChildren().add(borderPane);   
	            stage.setScene(scene);        
	            stage.show();
	     
	        
	        }
}
