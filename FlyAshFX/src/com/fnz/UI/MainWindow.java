package com.fnz.UI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainWindow extends Application 
{
	private BorderPane border;
	private Stage stage;
	private Scene scene;

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
        border = new BorderPane();
        
        border.setTop(addHBox());
        border.setLeft(addVBox());
        border.setCenter(addGridPane());
        scene = new Scene(border);
        stage.setX(0);
	    stage.setY(0);
	    stage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
	    stage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
	    stage.setScene(this.scene);
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
            
            ordersButton.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent e) {
					
					border.setLeft(new Orders().addVBox(border));
					//border.setCenter(new Orders().addGridPane());
				}
			});
            
            inventoryButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					border.setLeft(new Inventory().addVBox(border));
				}
			});
            
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
                return vbox;
            }
            
            /*
             * Creates a grid for the center region with four columns and three rows
             */
                private GridPane addGridPane() 
                {
                    GridPane grid = new GridPane();
                    grid.setHgap(10);
                    grid.setVgap(10);
                    grid.setPadding(new Insets(300));
                    return grid;
                }
}