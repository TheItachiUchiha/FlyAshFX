package com.fnz.UI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainWindow extends Application {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(MainWindow.class, args);
    }
    
    @Override
    public void start(Stage stage) {


// Use a border pane as the root for scene
        BorderPane border = new BorderPane();
        
        border.setTop(addHBox());
        border.setLeft(addVBox());
        border.setCenter(addGridPane());
        Scene scene = new Scene(border);
        stage.setScene(scene);
        stage.setTitle("FlyAsh Automation");
        stage.show();
    }
    
    /*
     * Creates an HBox with two buttons for the top region
     */
        
        private HBox addHBox() {

        	javafx.scene.layout.
            HBox hbox = new HBox();
            hbox.setPadding(new Insets(15, 12, 15, 12));
            hbox.setSpacing(10);   // Gap between nodes
            hbox.setStyle("-fx-background-color: #336699;");

            Button inventoryButton = new Button("Inventory");
            inventoryButton.setPrefSize(100, 50);

            Button ordersButton = new Button("Orders");
            ordersButton.setPrefSize(100, 50);
            
            Button accountButton = new Button("Accounts");
            accountButton.setPrefSize(100, 50);
            
            hbox.getChildren().addAll(inventoryButton, ordersButton, accountButton);
            
            return hbox;
        }
        
        /*
         * Creates a VBox with a list of links for the left region
         */
            private VBox addVBox() 
            {
                
                VBox vbox = new VBox();
                vbox.setPadding(new Insets(10)); // Set all sides to 10
                vbox.setSpacing(8);              // Gap between nodes

                
                /*TreeItem<String> inventoryRM = new TreeItem<String> ("Raw Materials");
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
                
                vbox.getChildren().addAll(treeRM,treeFinished);*/

                return vbox;
            }
            
            /*
             * Creates a grid for the center region with four columns and three rows
             */
                private GridPane addGridPane() {

                    GridPane grid = new GridPane();
                    grid.setHgap(10);
                    grid.setVgap(10);
                    grid.setPadding(new Insets(300));
                    return grid;
                }
}