package com.fnz.UI;

import javafx.geometry.Insets;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;

public class Orders 
{
	private VBox addVBox() 
    {
        
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10)); // Set all sides to 10
        vbox.setSpacing(8);              // Gap between nodes

        
        TreeItem<String> itemClient = new TreeItem<String> ("Client");
        itemClient.setExpanded(true);
       
        TreeItem<String> itemClient1 = new TreeItem<String> ("Place Order");            
        itemClient1.getChildren().add(itemClient1);
        TreeItem<String> itemClient2 = new TreeItem<String> ("Edit Order");            
        itemClient2.getChildren().add(itemClient2);
        TreeItem<String> itemClient3 = new TreeItem<String> ("Cancel Order");            
        itemClient3.getChildren().add(itemClient3);
        
        TreeItem<String> itemVendor = new TreeItem<String> ("Vendor");
        itemVendor.setExpanded(true);
       
        TreeItem<String> itemVendor1 = new TreeItem<String> ("Place Order");            
        itemVendor1.getChildren().add(itemVendor1);
        TreeItem<String> itemVendor2 = new TreeItem<String> ("Edit Order");            
        itemVendor1.getChildren().add(itemVendor1);
        TreeItem<String> itemVendor33 = new TreeItem<String> ("Cancel Order");            
        itemVendor1.getChildren().add(itemVendor1);
        

        TreeView<String> treeClient = new TreeView<String> (itemClient);
        TreeView<String> treeVendor = new TreeView<String> (itemVendor1);
        
        vbox.getChildren().addAll(treeClient,treeVendor);

        return vbox;
    }
}
