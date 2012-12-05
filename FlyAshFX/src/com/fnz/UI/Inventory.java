package com.fnz.UI;

import javafx.geometry.Insets;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;

public class Inventory 
{
	 private VBox addVBox() 
     {
         
         VBox vbox = new VBox();
         vbox.setPadding(new Insets(10)); // Set all sides to 10
         vbox.setSpacing(8);              // Gap between nodes

         
         TreeItem<String> inventoryRM = new TreeItem<String> ("Raw Materials");
         inventoryRM.setExpanded(true);
        
         TreeItem<String> itemRM1 = new TreeItem<String> ("Add Raw Material");            
         inventoryRM.getChildren().add(itemRM1);
         TreeItem<String> itemRM2 = new TreeItem<String> ("Edit Raw Material");            
         inventoryRM.getChildren().add(itemRM2);
         TreeItem<String> itemRM3 = new TreeItem<String> ("Delete Raw Material");            
         inventoryRM.getChildren().add(itemRM3);
         
         TreeItem<String> inventoryFinished = new TreeItem<String> ("Finished Product");
         inventoryFinished.setExpanded(true);
        
         TreeItem<String> itemF1 = new TreeItem<String> ("Add");            
         inventoryFinished.getChildren().add(itemF1);
         

         TreeView<String> treeRM = new TreeView<String> (inventoryRM);
         TreeView<String> treeFinished = new TreeView<String> (inventoryFinished);
         
         vbox.getChildren().addAll(treeRM,treeFinished);

         return vbox;
     }
}
