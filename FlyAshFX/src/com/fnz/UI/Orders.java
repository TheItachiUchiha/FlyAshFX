package com.fnz.UI;


import com.sun.javafx.scene.layout.region.Border;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Callback;

public class Orders 
{
	GridPane grid;
	@SuppressWarnings("unchecked")
	public VBox addVBox(final BorderPane border) 
    {
        border.setCenter(null);
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10)); // Set all sides to 10
        vbox.setSpacing(8);              // Gap between nodes

        
        TreeItem<String> itemClient = new TreeItem<String> ("Client");
        itemClient.setExpanded(false);
       
        final TreeItem<String> itemClient1 = new TreeItem<String> ("Place Order");            
        itemClient.getChildren().add(itemClient1);
        final TreeItem<String> itemClient2 = new TreeItem<String> ("Edit Order");            
        itemClient.getChildren().add(itemClient2);
        final TreeItem<String> itemClient3 = new TreeItem<String> ("Cancel Order");            
        itemClient.getChildren().add(itemClient3);
        
        final TreeItem<String> itemVendor = new TreeItem<String> ("Vendor");
        itemVendor.setExpanded(false);
       
        final TreeItem<String> itemVendor1 = new TreeItem<String> ("Place Order");            
        itemVendor.getChildren().add(itemVendor1);
        final TreeItem<String> itemVendor2 = new TreeItem<String> ("Edit Order");            
        itemVendor.getChildren().add(itemVendor2);
        final TreeItem<String> itemVendor3 = new TreeItem<String> ("Cancel Order");            
        itemVendor.getChildren().add(itemVendor3);
        

        TreeItem<String> rootNode = new TreeItem<String>("");
        rootNode.getChildren().addAll(itemClient, itemVendor);
        

        TreeView<String> tree = new TreeView<String> (rootNode);
        tree.setShowRoot(false);
        
        vbox.getChildren().addAll(tree);
        
        
        
        tree.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        
        tree.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
        	   @Override
        	   public void changed(ObservableValue<? extends TreeItem<String>> observable, TreeItem<String> oldValue, TreeItem<String> newValue) {
        	      System.out.println("Selection: " + newValue);
        	      // Add your stuff here
        	      if(newValue.equals(itemClient1))
				  {
        	    	  border.setCenter(ClientPlaceOrder());
				  }
        	      else if(newValue.equals(itemClient2))
				  {
        	    	  border.setCenter(ClientEditOrder());
				  }
        	      else if(newValue.equals(itemClient3))
				  {
        	    	  border.setCenter(ClientCancelOrder());
				  }
        	      else if(newValue.equals(itemVendor1))
				  {
        	    	  border.setCenter(VendorPlaceOrder());
				  }
        	      else if(newValue.equals(itemVendor2))
				  {
        	    	  border.setCenter(VendorEditOrder());
				  }
        	      else if(newValue.equals(itemVendor3))
				  {
        	    	  border.setCenter(VendorCancelOrder());
				  }
        	   }
        	});
        
        

        return vbox;
    }
	
	public GridPane addGridPane()
	{
	    return grid;
	}
	
	
	public GridPane ClientPlaceOrder()
	{
		grid = new GridPane();
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(0, 10, 0, 10));

	    
	    Label nameLabel = new Label("Client Name");
	    //nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(nameLabel, 1, 2); 

	    
	    TextField nameText = new TextField();
	    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(nameText, 2, 2);
	    
	    Label addressLabel = new Label("Client Address");
	    //nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(addressLabel, 1, 3); 

	    
	    TextField addText = new TextField();
	    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(addText, 2, 3);
	    
	    Label phoneLabel = new Label("Client Phone");
	    //phoneLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(phoneLabel, 1, 4); 

	    
	    TextField phoneText = new TextField();
	    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(phoneText, 2, 4);
	    
	    Label emailLabel = new Label("Client Email");
	    //emailLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(emailLabel, 1, 5); 

	    
	    TextField emailText = new TextField();
	    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(emailText, 2, 5);
	    
	    Label quantityLabel = new Label("Quantity");
	    //quantityLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(quantityLabel, 1, 6); 

	    
	    TextField quantityText = new TextField();
	    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(quantityText, 2, 6);
	    
	    Label amountLabel = new Label("Amount");
	    //amountLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(amountLabel, 1, 7); 

	    
	    TextField amountText = new TextField();
	    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(amountText, 2, 7);
	    
	    Label advanceLabel = new Label("Adavance Received");
	    //advanceLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(advanceLabel, 1, 8); 

	    
	    TextField advText = new TextField();
	    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(advText, 2, 8);
	     	 	
	    Label eddLabel = new Label("Expected Delivery Date");
	    //eddLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(eddLabel, 1, 9); 

	    
	    TextField eddText = new TextField();
	    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(eddText, 2, 9);
	    
	    Button submit = new Button("Accept Order");
	    grid.add(submit,1,11);

	    Button cancel = new Button("Cancel");
	    grid.add(cancel,2,11);

	    // Right label in column 4 (top), row 3
	    //Text servicesPercent = new Text("Services\n20%");
	    grid.setAlignment(Pos.CENTER);
	    //grid.add(servicesPercent, 3, 2);
	    
	    return grid;
	}
	
	public GridPane ClientEditOrder()
	{
		grid = new GridPane();
		grid.setHgap(10);
        grid.setVgap(8);
        grid.setPadding(new Insets(30));
        
		Label selectOrder = new Label("Select Order");
		grid.add(selectOrder,1,1);
		
		ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList(
				"First", "Second", "Third")
				);
		grid.add(cb,3,1);
		
		Button submit = new Button("Submit");
		grid.add(submit, 2, 5);
	    grid.setAlignment(Pos.CENTER);
	    //grid.add(servicesPercent, 3, 2);
	    
	    return grid;
	}
	
	public GridPane ClientCancelOrder()
	{
		grid = new GridPane();
		grid.setHgap(10);
        grid.setVgap(8);
        grid.setPadding(new Insets(30));
        
		Label selectOrder = new Label("Select Order");
		grid.add(selectOrder,1,1);
		
		ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList(
				"First", "Second", "Third")
				);
		grid.add(cb,3,1);
		
		Button submit = new Button("Canel Order");
		grid.add(submit, 2, 5);
	    grid.setAlignment(Pos.CENTER);
	    //grid.add(servicesPercent, 3, 2);
	    
	    return grid;
	}
	
	
	
	
	
	
	
	
	public GridPane VendorPlaceOrder()
	{
		grid = new GridPane();
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(0, 10, 0, 10));

	    
	    Label nameLabel = new Label("Vendor Name");
	    //nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(nameLabel, 1, 2); 

	    
	    TextField nameText = new TextField();
	    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(nameText, 2, 2);
	    
	    Label addressLabel = new Label("Vendor Address");
	    //nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(addressLabel, 1, 3); 

	    
	    TextField addText = new TextField();
	    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(addText, 2, 3);
	    
	    Label phoneLabel = new Label("Vendor Phone");
	    //phoneLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(phoneLabel, 1, 4); 

	    
	    TextField phoneText = new TextField();
	    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(phoneText, 2, 4);
	    
	    Label emailLabel = new Label("Vendor Email");
	    //emailLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(emailLabel, 1, 5); 

	    
	    TextField emailText = new TextField();
	    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(emailText, 2, 5);
	    
	    Label quantityLabel = new Label("Quantity");
	    //quantityLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(quantityLabel, 1, 6); 

	    
	    TextField quantityText = new TextField();
	    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(quantityText, 2, 6);
	    
	    Label amountLabel = new Label("Amount");
	    //amountLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(amountLabel, 1, 7); 

	    
	    TextField amountText = new TextField();
	    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(amountText, 2, 7);
	    
	    Label advanceLabel = new Label("Adavance Given");
	    //advanceLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(advanceLabel, 1, 8); 

	    
	    TextField advText = new TextField();
	    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(advText, 2, 8);
	     	 	
	    Label eddLabel = new Label("Expected Delivery Date");
	    //eddLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(eddLabel, 1, 9); 

	    
	    TextField eddText = new TextField();
	    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(eddText, 2, 9);
	    
	    Button submit = new Button("Place Order");
	    grid.add(submit,1,11);

	    Button cancel = new Button("Cancel");
	    grid.add(cancel,2,11);

	    // Right label in column 4 (top), row 3
	    //Text servicesPercent = new Text("Services\n20%");
	    grid.setAlignment(Pos.CENTER);
	    //grid.add(servicesPercent, 3, 2);
	    
	    return grid;
	}
	
	public GridPane VendorEditOrder()
	{
		grid = new GridPane();
		grid.setHgap(10);
        grid.setVgap(8);
        grid.setPadding(new Insets(30));
        
		Label selectOrder = new Label("Select Order");
		grid.add(selectOrder,1,1);
		
		ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList(
				"First", "Second", "Third")
				);
		grid.add(cb,3,1);
		
		Button submit = new Button("Submit");
		grid.add(submit, 2, 5);
	    grid.setAlignment(Pos.CENTER);
	    //grid.add(servicesPercent, 3, 2);
	    
	    return grid;
	}
	
	public GridPane VendorCancelOrder()
	{
		grid = new GridPane();
		grid.setHgap(10);
        grid.setVgap(8);
        grid.setPadding(new Insets(30));
        
		Label selectOrder = new Label("Select Order");
		grid.add(selectOrder,1,1);
		
		ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList(
				"First", "Second", "Third")
				);
		grid.add(cb,3,1);
		
		Button submit = new Button("Canel Order");
		grid.add(submit, 2, 5);
	    grid.setAlignment(Pos.CENTER);
	    //grid.add(servicesPercent, 3, 2);
	    
	    return grid;
	}
	
	
	
	
	
	
	
	
	
	
}
