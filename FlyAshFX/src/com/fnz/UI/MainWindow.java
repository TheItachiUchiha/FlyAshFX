package com.fnz.UI;



import np.com.ngopal.control.AutoFillTextBox;

import com.fnz.dao.DBInteraction;
import com.fnz.dao.InventoryDAO;
import com.sai.javafx.calendar.demo.FXCalendarDemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        border.setTop(addHBox());
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
        
        
        HBox hbox = new HBox();
        Button upload = new Button();
        upload.setId("upload");
        Image img1 = new Image(getClass().getResourceAsStream("upload.png"),40,40,false,false);
        upload.setGraphic(new ImageView(img1));
        upload.setContentDisplay(ContentDisplay.TOP);
        hbox.getChildren().add(upload);
        
        border.setRight(hbox);
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
    private HBox addHBox() 
    {

    	javafx.scene.layout.
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);   // Gap between nodes
       // hbox.setStyle("-fx-background-color: #336699;");
        hbox.getStyleClass().add("styleBg");
        
        DropShadow effect = new DropShadow();
        effect.setColor(Color.DARKKHAKI);
      effect.setBlurType(BlurType.GAUSSIAN);
        effect.setSpread(0.8);
        effect.setRadius(12);
        
        Text t= new Text("Inventory");
        t.setEffect(effect);
        
       
        
        Button inventoryButton = new Button("Inventory");
        inventoryButton.setId("inventoryButton");
        inventoryButton.setEffect(effect);
        
        
        
               
        Image img1 = new Image(getClass().getResourceAsStream("icon_inventory.png"),72,72,false,false);
        inventoryButton.setGraphic(new ImageView(img1));
        inventoryButton.setContentDisplay(ContentDisplay.TOP);
        inventoryButton.setMaxSize(5, 5);

        Button ordersButton = new Button("Orders");
        //ordersButton.setId("ordersButton");
        ordersButton.setPrefSize(100, 80);
        
        Button accountButton = new Button("Accounts");
        //accountButton.setId("accountButton");
        accountButton.setPrefSize(100, 80);
        
        //DropShadow effect
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);
       
        //Adding text and DropShadow effect to it
        Text text = new Text("               FlyAsh Corp.\n             	 Cuttack");
        text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
        text.setEffect(dropShadow);
        text.setX(600); //useless
        
        hbox.getChildren().addAll(inventoryButton, ordersButton, accountButton,text);
        
        ordersButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) 
			{
				border.setLeft(new Orders().addVBox(border));
				border.setRight(null);
			}
		});
        
        inventoryButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) 
			{
				border.setLeft(new Inventory().addVBox(border));
				border.setRight(null);
			}
		});
        
        accountButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) 
			{
				try {
					//System.out.println(new InventoryDAO().fetchProduction().get(1));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
        
        return hbox;
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