package com.fnz.UI;

import javafx.geometry.Insets;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Inventory 
{
	 @SuppressWarnings("unchecked")
	public VBox addVBox(BorderPane border) 
     {
         border.setCenter(null);
         VBox vbox = new VBox();
         vbox.setPadding(new Insets(10)); // Set all sides to 10
         vbox.setSpacing(8);              // Gap between nodes

         
         TreeItem<String> inventoryRM = new TreeItem<String> ("Raw Materials");
         inventoryRM.setExpanded(false);
        
         
         
         TreeItem<String> itemRM1 = new TreeItem<String> ("Add Raw Material");            
         inventoryRM.getChildren().add(itemRM1);
         TreeItem<String> itemRM2 = new TreeItem<String> ("Edit Raw Material");            
         inventoryRM.getChildren().add(itemRM2);
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

         return vbox;
     }
}
