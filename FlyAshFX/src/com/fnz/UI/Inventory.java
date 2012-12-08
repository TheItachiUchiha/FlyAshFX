package com.fnz.UI;


import com.sai.javafx.calendar.FXCalendar;

import javafx.collections.FXCollections;
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
import javafx.util.Callback;

public class Inventory 
{
	GridPane grid;
	 @SuppressWarnings("unchecked")
	public VBox addVBox(final BorderPane border) 
     {
         border.setCenter(null);
         VBox vbox = new VBox();
         vbox.setPadding(new Insets(10)); // Set all sides to 10
         vbox.setSpacing(8);              // Gap between nodes

         
         TreeItem<String> inventoryRM = new TreeItem<String> ("Raw Materials");
         inventoryRM.setExpanded(false);
        
         
         
         TreeItem<String> itemRM1 = new TreeItem<String> ("Add Raw Material");            
         inventoryRM.getChildren().add(itemRM1);
         //TreeItem<String> itemRM2 = new TreeItem<String> ("Edit Raw Material");            
         //inventoryRM.getChildren().add(itemRM2);
         TreeItem<String> itemRM3 = new TreeItem<String> ("Delete Raw Material");            
         inventoryRM.getChildren().add(itemRM3);
         
         TreeItem<String> inventoryFinished = new TreeItem<String> ("Finished Product");
         inventoryFinished.setExpanded(false);
        
         TreeItem<String> itemF1 = new TreeItem<String> ("Add");            
         inventoryFinished.getChildren().add(itemF1);
         

         TreeItem<String> rootNode = new TreeItem<String>("");
         rootNode.getChildren().addAll(inventoryRM, inventoryFinished);
         

         TreeView<String> tree = new TreeView<String> (rootNode);
         tree.setShowRoot(false);
         
         vbox.getChildren().addAll(tree);
         
         tree.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
         tree.setCellFactory(new Callback<TreeView<String>, TreeCell<String>>() {
      	   @Override
      	   public TreeCell<String> call(TreeView<String> paramP) {
      		return new TreeCell<String>(){
      			@Override
      			protected void updateItem(String paramT, boolean paramBoolean) {
      				super.updateItem(paramT, paramBoolean);
      				if(!isEmpty()){
      					setGraphic(new Label(paramT));
      					final TreeCell<String> this$ = this;
      					
      					//if(this$.getParent().equals(itemVendor1.getParent()))
      					//{
 	     					if(this$.getItem()=="Add Raw Material")
 	     					{
 	     						this.setOnMouseClicked(new EventHandler<MouseEvent>(){
 		     						@Override
 		     						public void handle(MouseEvent event) 
 		     						{
 		     								border.setCenter(AddRawMaterial());
 		     						}
 	     						});
 	     					}
 	     					else if(this$.getItem()=="Delete Raw Material")
 	     					{
 	     						this.setOnMouseClicked(new EventHandler<MouseEvent>(){
 		     						@Override
 		     						public void handle(MouseEvent event) 
 		     						{
 		     								border.setCenter(DeleteRawMaterial());
 		     						}
 	     						});
 	     					}
 	     					else if(this$.getItem()=="Add")
 	     					{
 	     						this.setOnMouseClicked(new EventHandler<MouseEvent>(){
 		     						@Override
 		     						public void handle(MouseEvent event) 
 		     						{
 		     								border.setCenter(AddFinishedProduct());
 		     						}
 	     						});
 	     					}
      					//}
      				}
      			}
      		};
      		
      	   }
      	  
      	});

         return vbox;
     }
	 
	 public GridPane AddRawMaterial()
		{
			grid = new GridPane();
			grid.setHgap(10);
            grid.setVgap(8);
            grid.setPadding(new Insets(30));
			Label selectOrder = new Label("Enter Name of Raw Material");
			grid.add(selectOrder,1,1);
			
			TextField rawMaterialName = new TextField();
			grid.add(rawMaterialName,3,1);
			
			Label selectUnit = new Label("Enter Default Unit");
			grid.add(selectUnit,1,2);
			
			ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList(
					"Kilograms", "Bags", "No")
					);
			grid.add(cb,3,2);
			
			Button submit = new Button("Add");
			grid.add(submit, 2, 5);
		    grid.setAlignment(Pos.CENTER);
		    //grid.add(servicesPercent, 3, 2);
		    
		    return grid;
		}
	 
	 
	 	public GridPane DeleteRawMaterial()
		{
			grid = new GridPane();
			grid.setHgap(10);
			grid.setVgap(8);
			grid.setPadding(new Insets(30));
			
			
			
			Label selectUnit = new Label("Select Raw Material");
			grid.add(selectUnit,1,1);
			
			ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList(
					"Kilograms", "Bags", "No")
					);
			grid.add(cb,3,1);
			
			Button submit = new Button("Delete");
			grid.add(submit, 2, 5);
		    grid.setAlignment(Pos.CENTER);
		    //grid.add(servicesPercent, 3, 2);
		    
		    return grid;
		}
	 	
	 	public GridPane AddFinishedProduct()
		{
			grid = new GridPane();
			grid.setHgap(10);
            grid.setVgap(8);
            grid.setPadding(new Insets(30));
			
            Label labelProduct = new Label("Bricks Produced");
			grid.add(labelProduct,1,1);
			
			TextField bricksProduced = new TextField();
			grid.add(bricksProduced,3,1);
			
			Label labelLocation = new Label("Enter Storage Location");
			grid.add(labelLocation,1,2);
			
			TextField storageLocation = new TextField();
			grid.add(storageLocation,3,2);
			
			Label labelDate = new Label("Date of Production");
			grid.add(labelDate,1,3);
			
			FXCalendar dateProduction = new FXCalendar(); 
			grid.add(dateProduction,3,3);
			
			Button submit = new Button("Add");
			grid.add(submit, 2, 5);
		    grid.setAlignment(Pos.CENTER);
		    //grid.add(servicesPercent, 3, 2);
		    
		    return grid;
		}
}
