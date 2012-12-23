package com.fnz.UI;



import np.com.ngopal.control.AutoFillTextBox;

import com.fnz.dao.DBInteraction;
import com.fnz.dao.InventoryDAO;
import com.fnz.utilities.ModalDialog;
import com.sai.javafx.calendar.demo.FXCalendarDemo;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
	static DropShadow effect2 = new DropShadow();
	static DropShadow effect1 = new DropShadow();
	static DropShadow effect3 = new DropShadow();
	public boolean flag;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(MainWindow.class, args);
       
        
        
        
       
    }
    
    @Override
    public void start(Stage stage)
    {
    	try{

// Use a border pane as the root for scene
    	new DBInteraction().createDB();
        border = new BorderPane();
        border.setTop(upperPart());
        border.setLeft(addVBox());
        border.setCenter(addGridPane());
        border.setRight(addVBox());
        border.setBottom(addBBox());
        scene = new Scene(border);
        scene.getStylesheets().add(FXCalendarDemo.class.getResource("/com/fnz/styles/calendar_styles.css").toExternalForm());
        scene.getStylesheets().add(FXCalendarDemo.class.getResource("/com/fnz/styles/gui.css").toExternalForm());
        scene.getStylesheets().add("com\\fnz\\styles\\control.css");
        stage.setX(0);
	    stage.setY(0);
	    //stage.getIcons().add(new Image(getClass().getResourceAsStream("/com/fnz/styles/Two-storied house.png")));
	    stage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
	    stage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
	    stage.setScene(this.scene);
        stage.setTitle("FlyAsh Automation");
        stage.show();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    private BorderPane addBBox(){
    	javafx.scene.layout.
        BorderPane border = new BorderPane();
    	border.setPadding(new Insets(15, 12, 15, 12));
       // hbox.setSpacing(10);   // Gap between nodes
       // hbox.setStyle("-fx-background-color: #336699;");
    	border.getStyleClass().add("styleBg");
        Label lName=new Label("copyright © something");
        border.setLeft(lName);
        
        
        /*HBox hbox = new HBox();
       
        Button upload = new Button();
        upload.setId("upload");
        Image img1 = new Image("upload.png");
        upload.setGraphic(new ImageView(img1));
        upload.setContentDisplay(ContentDisplay.TOP);
        hbox.getChildren().add(upload);
        
        border.setRight(hbox);*/
        return border;
    }
    
    /*Create Method <function name><return type><comments>
	 * <Creator Name><Date Of Creation MM-dd-yyyy>
	 * 
	 * <addHBox()><HBox><Horizontal pane to be placed on the top>
	 * <Abhinay Agarwal><12-10-2012>
	 * 
	 * */
	/**Modification Log
	 * 
	 * <Date> <Name> <Comments>
	 * 
	 */    
    private BorderPane upperPart() 
    {

    	BorderPane upperBorder = new BorderPane();
        
    	
    	HBox leftHbox = new HBox();
    	HBox centerHbox = new HBox();
    	HBox rightHbox = new HBox();
    	
    	leftHbox.setPadding(new Insets(15, 12, 15, 12));
    	leftHbox.setSpacing(10);   // Gap between nodes
        // hbox.setStyle("-fx-background-color: #336699;");
    	upperBorder.getStyleClass().add("styleBg");
    	
    	centerHbox.setPadding(new Insets(15, 12, 15, 250));
    	centerHbox.setSpacing(10);   // Gap between nodes
        // hbox.setStyle("-fx-background-color: #336699;");
    	//centerHbox.getStyleClass().add("styleBg");
    	
    	rightHbox.setPadding(new Insets(50, 12, 15, 12));
    	rightHbox.setSpacing(10);   // Gap between nodes
        // hbox.setStyle("-fx-background-color: #336699;");
    	//rightHbox.getStyleClass().add("styleBg");
        
        
        effect2.setColor(Color.DARKGOLDENROD);
        effect2.setBlurType(BlurType.GAUSSIAN);
        effect2.setSpread(0.8);
        effect2.setRadius(12);
      
        effect1.setColor(Color.DARKCYAN);
        effect1.setBlurType(BlurType.GAUSSIAN);
        effect1.setSpread(0.8);
        effect1.setRadius(12);
       
        flag=false;
        
       ToggleGroup g1 = new ToggleGroup();
        
        final ToggleButton inventoryButton = new ToggleButton();
        inventoryButton.setToggleGroup(g1);
        final Tooltip tooltip = new Tooltip();
        tooltip.setText("Inventory\n");
        inventoryButton.setTooltip(tooltip);
        inventoryButton.setId("inventoryButton");
        inventoryButton.setEffect(effect1);   
        Image img1 = new Image("icon_inventory.png",40,40,false,false);
        inventoryButton.setGraphic(new ImageView(img1));
        inventoryButton.setContentDisplay(ContentDisplay.TOP);
        inventoryButton.setMaxSize(5, 5);
        changeBackgroundOnHoverUsingEventsInven(inventoryButton);

        final ToggleButton ordersButton = new ToggleButton();
        ordersButton.setToggleGroup(g1);
        ordersButton.setId("ordersButton");
        ordersButton.setEffect(effect1);
        Image img3 = new Image("icon-leadsbox.png",40,40,false,false);
        ordersButton.setGraphic(new ImageView(img3));
        ordersButton.setContentDisplay(ContentDisplay.TOP);
        ordersButton.setMaxSize(5, 5);
        changeBackgroundOnHoverUsingEventsOrder(ordersButton);
        
        
        final ToggleButton accountButton = new ToggleButton();
        accountButton.setToggleGroup(g1);
        accountButton.setId("accountButton");
        accountButton.setEffect(effect1);
        Image img2 = new Image("Rupee_Order.png",40,40,false,false);
        accountButton.setGraphic(new ImageView(img2));
        accountButton.setContentDisplay(ContentDisplay.TOP);
        accountButton.setMaxSize(5, 5);
        //changeBackgroundOnHoverUsingEvents(accountButton);
        
        //DropShadow effect
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);
        
        ordersButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) 
			{
				inventoryButton.setEffect(effect1);
				accountButton.setEffect(effect1);
				ordersButton.setEffect(effect2);
				border.setLeft(new Orders().addVBox(border));
				border.setRight(null);
			}
		});
        
        
        inventoryButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) 
			{
				inventoryButton.setEffect(effect2);
				accountButton.setEffect(effect1);
				ordersButton.setEffect(effect1);
				border.setLeft(new Inventory().addVBox(border));
				border.setRight(null);
			}
		});
        
        accountButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) 
			{
				
				inventoryButton.setEffect(effect1);
				   accountButton.setEffect(effect2);
				   ordersButton.setEffect(effect1);
				     
			        
					//System.out.println(new InventoryDAO().fetchProduction().get(1));
			
			}
		});
        
        leftHbox.getChildren().addAll(inventoryButton, ordersButton, accountButton);
        upperBorder.setLeft(leftHbox);
        
      
        //Adding text and DropShadow effect to it
        Text text = new Text("FlyAsh Corp.\nCuttack");
        text.setFont(Font.font("Courier New", 28));
        text.setEffect(dropShadow);
        text.setX(600); //useless
        
        
        centerHbox.setAlignment(Pos.CENTER_LEFT);
        centerHbox.getChildren().addAll(text);
        upperBorder.setCenter(centerHbox);
        
        MenuButton setting = new MenuButton();
        Image settingImage = new Image("setting.png",30,30,false,false);
        setting.setGraphic(new ImageView(settingImage));
        setting.setPrefSize(50, 50);
        MenuItem Backup = new MenuItem("Backup/Restore");
        MenuItem Configure = new MenuItem("Configure");
        Backup.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) 
			{
				
				ModalDialog m = new ModalDialog();
				   m.ModalDialogUpload(stage, "Make a Back Up / Restore Database", "Choose your option: ");  
			        
					//System.out.println(new InventoryDAO().fetchProduction().get(1));
			
			}
		});
        
        Configure.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) 
			{
				
				ModalDialog m = new ModalDialog();
				   m.ModalDialogConfigure(stage, "Configure", "Software Configuration: ");  
			        
					//System.out.println(new InventoryDAO().fetchProduction().get(1));
			
			}
		});
        
        setting.getItems().addAll(Backup,Configure);
        rightHbox.getChildren().addAll(setting);
        upperBorder.setRight(rightHbox);
        
        return upperBorder;
    }
        
        
        
    

      public void changeBackgroundOnHoverUsingEventsInven(final Node node) {
     
        node.setOnMouseEntered(new EventHandler<MouseEvent>() {
          @Override public void handle(MouseEvent mouseEvent) {
            node.setEffect(effect2);
            
          }
        });
        
        node.setOnMouseClicked(new EventHandler<MouseEvent>() {
        	 @Override public void handle(MouseEvent mouseEvent) {
            node.setEffect(effect2);
            flag=true;
          }
        });
        node.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
            	if (flag==true) {
            		
            		node.setEffect(effect2);
            	}
            	else{
            		node.setEffect(effect1);
            	}
            	
            }
          });
      }    
      public void changeBackgroundOnHoverUsingEventsOrder(final Node node) {
    	     
          node.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
              node.setEffect(effect2);
              
            }
          });
          node.setOnMouseClicked(new EventHandler<MouseEvent>() {
         	 @Override public void handle(MouseEvent mouseEvent) {
             node.setEffect(effect2);
             flag=true;
           }
         });
         
          node.setOnMouseExited(new EventHandler<MouseEvent>() {
              @Override public void handle(MouseEvent mouseEvent) {
              	if (flag==true) {
              		
              		node.setEffect(effect2);
              	}
              	else{
              		node.setEffect(effect1);
              	}
              	
              }
            });
        }       

	/*Create Method <function name><return type><comments>
	 * <Creator Name><Date Of Creation MM-dd-yyyy>
	 * 
	 * <addVBox()><VBox><Vertical pane to be placed on the left>
	 * <Abhinay Agarwal><12-10-2012>
	 * 
	 * */
	/**Modification Log
	 * 
	 * <Date> <Name> <Comments>
	 * 
	 */    
    private VBox addVBox() 
    {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10)); // Set all sides to 10
        vbox.setSpacing(8);              // Gap between nodes
        return vbox;
    }
        
    /*Create Method <function name><return type><comments>
  	 * <Creator Name><Date Of Creation MM-dd-yyyy>
  	 * 
  	 * <addGridPane()><GridPane><Grid pane to be placed on the center>
  	 * <Abhinay Agarwal><12-10-2012>
  	 * 
  	 * */
  	/**Modification Log
  	 * 
  	 * <Date> <Name> <Comments>
  	 * 
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