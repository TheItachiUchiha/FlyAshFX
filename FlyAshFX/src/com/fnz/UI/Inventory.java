package com.fnz.UI;


import com.fnz.VO.FinshedProductVO;
import com.fnz.dao.DBInteraction;
import com.fnz.service.InventoryService;
import com.sai.javafx.calendar.FXCalendar;
import com.sai.javafx.calendar.demo.FXCalendarDemo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Callback;

public class Inventory 
{
	GridPane grid;
	InventoryService inventoryService;
	public Inventory()
	{
		inventoryService = new InventoryService();
	}
	
	
	/*Create Method <function name><return type><comments>
	 * <Creator Name><Date Of Creation MM-dd-yyyy>
	 * 
	 * <addVBox(BorderPane)><VBox><Vertical pane to be placed on the LHS>
	 * <Abhinay Agarwal><12-10-2012>
	 * 
	 * */
	/**Modification Log
	 * 
	 * <Date> <Name> <Comments>
	 * 
	 */
	@SuppressWarnings("unchecked")
	public VBox addVBox(final BorderPane border) 
     {
		 VBox vbox = new VBox();;
		 try
		 {
			
         border.setCenter(null);
         
         vbox.setPadding(new Insets(10)); // Set all sides to 10
         vbox.setSpacing(8);              // Gap between nodes

         
         TreeItem<String> inventoryRM = new TreeItem<String> ("Raw Materials");
         inventoryRM.setExpanded(false);
        
         
         
         final TreeItem<String> itemRM1 = new TreeItem<String> ("Add Raw Material");            
         inventoryRM.getChildren().add(itemRM1);
         //TreeItem<String> itemRM2 = new TreeItem<String> ("Edit Raw Material");            
         //inventoryRM.getChildren().add(itemRM2);
         final TreeItem<String> itemRM3 = new TreeItem<String> ("Delete Raw Material");            
         inventoryRM.getChildren().add(itemRM3);
         
         final TreeItem<String> inventoryFinished = new TreeItem<String> ("Finished Product");
         inventoryFinished.setExpanded(false);
        
         final TreeItem<String> itemF1 = new TreeItem<String> ("Add");            
         inventoryFinished.getChildren().add(itemF1);
         

         TreeItem<String> rootNode = new TreeItem<String>("");
         rootNode.getChildren().addAll(inventoryRM, inventoryFinished);
         

         TreeView<String> tree = new TreeView<String> (rootNode);
         tree.setShowRoot(false);
         
         vbox.getChildren().addAll(tree);
         
         tree.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
         
         tree.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
      	   @Override
      	   public void changed(ObservableValue<? extends TreeItem<String>> observable, TreeItem<String> oldValue, TreeItem<String> newValue) {
      	      System.out.println("Selection: " + newValue);
      	      // Add your stuff here
      	      if(newValue.equals(itemRM1))
				  {
      	    	  try {
					border.setCenter(AddRawMaterial());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  }
      	   /* else if(newValue.equals(itemRM2))
			  {
	    	  border.setCenter(EditRawMaterial()());
			  }*/
      	      else if(newValue.equals(itemRM3))
			  {
      	    	  try 
      	    	  {
					border.setCenter(DeleteRawMaterial());
				  } 
      	    	  catch (Exception e) 
      	    	  {
					e.printStackTrace();
				  }  
			  }
      	      else if(newValue.equals(inventoryFinished))
			  {
    	    	  border.setCenter(viewFinishedProduct());
			  }
      	      else if(newValue.equals(itemF1))
			  {
      	    	  border.setCenter(AddFinishedProduct());
			  }
      	   }
      	});

		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
         return vbox;
     }
	 
	
	/*Create Method <function name><return type><comments>
	 * <Creator Name><Date Of Creation MM-dd-yyyy>
	 * 
	 * <AddRawMaterial()><GridPane><Grid pane to be placed on the center for adding raw materials>
	 * <Abhinay Agarwal><12-10-2012>
	 * 
	 * */
	/**Modification Log
	 * 
	 * <Date> <Name> <Comments>
	 * 
	 */
	 public GridPane AddRawMaterial() throws Exception
		{
		 try
		 {
			grid = new GridPane();
			grid.setHgap(10);
            grid.setVgap(8);
            grid.setPadding(new Insets(30));
			Label selectOrder = new Label("Enter Name of Raw Material");
			grid.add(selectOrder,1,1);
			
			final TextField rawMaterialName = new TextField();
			grid.add(rawMaterialName,3,1);
			
			Label selectUnit = new Label("Enter Default Unit");
			grid.add(selectUnit,1,2);
			
			
			final ChoiceBox<String> cb = new ChoiceBox<String>(inventoryService.fetchUnit());
			grid.add(cb,3,2);
			
			Button submit = new Button("Add");
			grid.add(submit, 2, 5);
		    
		    
		    submit.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0)
				{
					try
					{
						if("".equals(rawMaterialName.getText())||rawMaterialName.getText().equals(null))
						{
							Label msg = new Label("Cannot be Empty");
							msg.setTextFill(Color.RED);
							grid.add(msg,4,1);
						}
						/*else if("".equals(cb.getValue())||cb.getValue().equals(null))
						{
							Label msg = new Label("Please select one Unit");
							msg.setTextFill(Color.RED);
							grid.add(msg,4,2);
						}*/
						else
						{
							inventoryService.insertRawMaterials(rawMaterialName.getText(), cb.getValue());
							Label msg = new Label("Successfully Added !!!");
							msg.setTextFill(Color.RED);
							grid.add(msg,2,7);
						}
					} catch (Exception e) 
					{
						e.printStackTrace();
					}
				}
			});
		    grid.setAlignment(Pos.CENTER);
		   
		    
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		    return grid;
		}
	 
	 
	 /*Create Method <function name><return type><comments>
		 * <Creator Name><Date Of Creation MM-dd-yyyy>
		 * 
		 * <DeleteRawMaterial()><GridPane><Grid pane to be placed on the center for deleting raw materials>
		 * <Abhinay Agarwal><12-10-2012>
		 * 
		 * */
		/**Modification Log
		 * 
		 * <Date> <Name> <Comments>
		 * 
		 */
	 	public GridPane DeleteRawMaterial() throws Exception
		{
	 		try
	 		{
	 			
			grid = new GridPane();
			grid.setHgap(10);
			grid.setVgap(8);
			grid.setPadding(new Insets(30));
			
			
			
			Label selectUnit = new Label("Select Raw Material");
			grid.add(selectUnit,1,1);
			
			final ChoiceBox<String> cb = new ChoiceBox<String>(inventoryService.fetchRawMaterials());
			grid.add(cb,3,1);
			
			Button submit = new Button("Delete");
			grid.add(submit, 2, 5);
			
			submit.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0)
				{
					try
					{
						inventoryService.deleteRawMaterial(cb.getValue());
						Label msg = new Label("Raw Material Deleted Added !!!");
						msg.setTextFill(Color.RED);
						grid.add(msg,2,7);
					} catch (Exception e) 
					{
						e.printStackTrace();
					}
				}
			});
			
		    grid.setAlignment(Pos.CENTER);
		    //grid.add(servicesPercent, 3, 2);
		    
	 		}
	 		catch(Exception e)
	 		{
	 			e.printStackTrace();
	 		}
		    return grid;
		}
	 	
	 	
	 	/*Create Method <function name><return type><comments>
		 * <Creator Name><Date Of Creation MM-dd-yyyy>
		 * 
		 * <AddFinishedProduct()><GridPane><Grid pane to be placed on the center for adding finished products>
		 * <Abhinay Agarwal><12-10-2012>
		 * 
		 * */
		/**Modification Log
		 * 
		 * <Date> <Name> <Comments>
		 * 
		 */
	 	public GridPane AddFinishedProduct()
		{
			grid = new GridPane();
			grid.setHgap(10);
            grid.setVgap(8);
            grid.setPadding(new Insets(30));
			
            Label labelProduct = new Label("Bricks Produced");
			grid.add(labelProduct,1,1);
			
			final TextField bricksProduced = new TextField();
			grid.add(bricksProduced,3,1);
			
			Label labelLocation = new Label("Enter Storage Location");
			grid.add(labelLocation,1,2);
			
			final TextField storageLocation = new TextField();
			grid.add(storageLocation,3,2);
			
			Label labelDate = new Label("Date of Production");
			grid.add(labelDate,1,3);
			
			final FXCalendar dateProduction = new FXCalendar(); 
			grid.add(dateProduction,3,3);
			//dateProduction.getStylesheets().add(FXCalendarDemo.class.getResource("/com/fnz/styles/calendar_styles.css").toExternalForm());
			
			Button submit = new Button("Add");
			grid.add(submit, 2, 5);
			
			
			submit.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0)
				{
					Label msg=null;
					try
					{
						if("".equals(bricksProduced.getText())||bricksProduced.getText().equals(null))
						{
							msg = new Label("Cannot be Empty");
							msg.setTextFill(Color.RED);
							grid.add(msg,4,1);
						}
						else if("".equals(storageLocation.getText())||storageLocation.getText().equals(null))
						{
							msg = new Label("Cannot be Empty");
							msg.setTextFill(Color.RED);
							grid.add(msg,4,2);
						}
						else if("".equals(dateProduction.getTextField().getText())||dateProduction.getTextField().getText().equals(null))
						{
							msg = new Label("Cannot be Empty");
							msg.setTextFill(Color.RED);
							grid.add(msg,4,3);
						}
						else
						{
							inventoryService.addProduction(Integer.parseInt(bricksProduced.getText()),storageLocation.getText(),dateProduction.getTextField().getText());
							msg = new Label("Production Added Successfully !!!");
							msg.setTextFill(Color.RED);
							grid.add(msg,2,7);
						}
						
					}
					catch (Exception e) 
					{
						e.printStackTrace();
					}
				}
			});
			
			
			
		    grid.setAlignment(Pos.CENTER);
		    //grid.add(servicesPercent, 3, 2);
		    
		    return grid;
		}
	 	
	 	
	 	/*Create Method <function name><return type><comments>
		 * <Creator Name><Date Of Creation MM-dd-yyyy>
		 * 
		 * <viewFinishedProduct()><GridPane><Grid pane/ Table to be placed on the center for viewing finished products>
		 * <Abhinay Agarwal><12-10-2012>
		 * 
		 * */
		/**Modification Log
		 * 
		 * <Date> <Name> <Comments>
		 * 
		 */
	 	@SuppressWarnings("unchecked")
		public GridPane viewFinishedProduct()
		{
	 		ObservableList<FinshedProductVO> dataTable;
	 				
			grid = new GridPane();
			grid.setHgap(10);
            grid.setVgap(8);
            grid.setPadding(new Insets(30));
	 	
            try
            {
            	dataTable = FXCollections.observableArrayList();
            	dataTable = InventoryService.viewFinishedProduct();
        
			 	final Label label = new Label("Finished Product");
			 	label.setFont(new Font("Arial", 20));
			 	grid.add(label,1,1);
			 	
			 	TableView<FinshedProductVO> table = new TableView<FinshedProductVO>();
			 	table.setEditable(false);
			 	//table.setPrefSize(1000, 1000);
			 	
			 	TableColumn dateOfProduction = new TableColumn("Date Of Production");
			 	dateOfProduction.setMinWidth(200);
			 	dateOfProduction.setCellValueFactory(
			 			new PropertyValueFactory<FinshedProductVO, String>("dateOfProduction"));
			 	TableColumn bricksProduced = new TableColumn("No. Of Bricks Produced");
			 	bricksProduced.setMinWidth(200);
			 	bricksProduced.setCellValueFactory(
			 			new PropertyValueFactory<FinshedProductVO, String>("bricksProduced"));
			 	TableColumn curingDays = new TableColumn("No Of Days Cured");
			 	curingDays.setMinWidth(200);
			 	curingDays.setCellValueFactory(
			 			new PropertyValueFactory<FinshedProductVO, String>("daysCured"));
			 	TableColumn storageSection = new TableColumn("Storage Section");
			 	storageSection.setMinWidth(200);
			 	storageSection.setCellValueFactory(
			 			new PropertyValueFactory<FinshedProductVO, String>("storageSection"));
			 	TableColumn status = new TableColumn("Status");
			 	status.setMinWidth(200);
			 	status.setCellValueFactory(
			 			new PropertyValueFactory<FinshedProductVO, String>("status"));
			 	
			 	table.setItems(dataTable);
			 	table.getColumns().addAll(dateOfProduction, bricksProduced, curingDays, storageSection, status);
			 	
			 	grid.setAlignment(Pos.TOP_LEFT);
			 	
			 	grid.add(table,1,3);
            }
            catch(Exception e)
            {
            	e.printStackTrace();
            }
		 	
		 	return grid;
		}
}
