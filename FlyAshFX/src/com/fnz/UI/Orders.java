package com.fnz.UI;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import np.com.ngopal.control.AutoFillTextBox;

import com.fnz.Validation.Validation;
import com.fnz.Validation.CssValidation;
import com.fnz.VO.CustomerVO;
import com.fnz.VO.OrderVO;
import com.fnz.VO.VendorVO;
import com.fnz.common.CommonConstants;
import com.fnz.service.InventoryService;
import com.fnz.service.OrderService;
import com.mytdev.javafx.scene.control.AutoCompleteTextField;
import com.sai.javafx.calendar.FXCalendar;
import com.sun.javafx.scene.layout.region.Border;

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
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class Orders 
{
	GridPane grid;
	OrderService orderService;
	Validation tempvalidator;
	CssValidation tempCssValidator;
	Label msg = new Label("Cannot be Empty");
	Label successMsg = new Label("Added Successfully !");
	
   
	
	DecimalFormat df = new DecimalFormat("#.##");
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
	
	
	public Orders()
	{
		orderService = new OrderService();
		msg.setVisible(false);
		successMsg.setVisible(false);
		msg.setTextFill(Color.RED);
		successMsg.setTextFill(Color.BLUE);
		tempCssValidator=new CssValidation();
		tempvalidator = new Validation();
		
	}
	
	
	/*Create Method <function name><return type><comments>
	 * <Creator Name><Date Of Creation MM-dd-yyyy>
	 * 
	 * <addVBox()><VBox><Vertical pane to be placed on the LHS>
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
        border.setCenter(null);
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10)); // Set all sides to 10
        vbox.setSpacing(8);              // Gap between nodes

        
        final TreeItem<String> itemClient = new TreeItem<String> ("Client");
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
        	      if (newValue.equals(itemClient))
        	      {
        	    	  border.setCenter(viewOrder());
        	    	  border.setRight(null);
        	      }
        	      else if(newValue.equals(itemClient1))
				  {
        	    	  border.setCenter(ClientPlaceOrder());
        	    	  border.setRight(null);
				  }
        	      else if(newValue.equals(itemClient2))
				  {
        	    	  border.setCenter(ClientEditOrder(border));
        	    	  border.setRight(null);
				  }
        	      else if(newValue.equals(itemClient3))
				  {
        	    	  border.setCenter(ClientCancelOrder());
        	    	  border.setRight(null);
				  }
        	      else if(newValue.equals(itemVendor))
				  {
        	    	  border.setCenter(viewVendorOrder());
        	    	  border.setRight(null);
				  }
        	      else if(newValue.equals(itemVendor1))
				  {
        	    	  border.setCenter(VendorPlaceOrder());
        	    	  border.setRight(null);
				  }
        	      else if(newValue.equals(itemVendor2))
				  {
        	    	  border.setCenter(VendorEditOrder(border));
        	    	  border.setRight(null);
				  }
        	      else if(newValue.equals(itemVendor3))
				  {
        	    	  border.setCenter(VendorCancelOrder());
        	    	  border.setRight(null);
				  }
        	   }
        	});
        
        

        return vbox;
    }
	
	public GridPane addGridPane()
	{
	    return grid;
	}
	
	/*Create Method <function name><return type><comments>
	 * <Creator Name><Date Of Creation MM-dd-yyyy>
	 * 
	 * <ClientPlaceOrder()><GridPane><Grid to place client Order>
	 * <Abhinay Agarwal><12-10-2012>
	 * 
	 * */
	/**Modification Log
	 * 
	 * <Date> <Name> <Comments>
	 * @throws Exception 
	 * 
	 */
	public GridPane ClientPlaceOrder()
	{
		try
		{
			msg.setVisible(false);
			successMsg.setVisible(false);
			
			grid = new GridPane();
		    grid.setHgap(10);
		    grid.setVgap(10);
		    grid.setPadding(new Insets(0, 10, 0, 10));
		    
		    final ObservableList<String> clientList = FXCollections.observableArrayList();
		    clientList.clear();
		    
		    
		    final ObservableList<CustomerVO> customerList = FXCollections.observableArrayList();
		    customerList.clear();
		    customerList.addAll(orderService.fetchClientDetails());
		    
		    for(CustomerVO cust : customerList)
		    {
		    	clientList.add(cust.getCustomerName());
		    }
		    
		    Label nameLabel = new Label("Client Name");
		    //nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		     grid.add(nameLabel, 1, 2); 
		     
		    
		    //final AutoFillTextBox nameText = new AutoFillTextBox(clientList);
		     final AutoCompleteTextField<String> nameText = new AutoCompleteTextField<String>();
		     nameText.setItems(clientList);
		 
		   
		    // need to create a method for autoCompleteTextField
		     
		     // tempvalidator.allowCharacters((TextField)nameText));
		    
		     
		     //System.out.println(nameText.textbox.getPrefColumnCount());
		    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(nameText, 2, 2);
		    
		    //tempvalidator.allowCharacters(nameText);
		    
		    
		    Label addressLabel = new Label("Client Address");
		    //nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(addressLabel, 1, 3); 
	
		    
		    final TextField addText = new TextField();
		    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(addText, 2, 3);
		   
		 
		    
		    Label phoneLabel = new Label("Client Phone");
		    //phoneLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(phoneLabel, 1, 4); 
		    
		    
		    final TextField phoneText = new TextField();
		    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(phoneText, 2, 4);
		    tempvalidator.allowAsPhoneNumber(phoneText);
		    
		    Label emailLabel = new Label("Client Email");
		    //emailLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(emailLabel, 1, 5); 
	
		    
		    final TextField emailText = new TextField();
		    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(emailText, 2, 5);
		    tempvalidator.allowAsEmail(emailText);
		    
		    
		    
		    nameText.textProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(final ObservableValue<? extends String> observableValue, final String oldValue, final String newValue) {
		            
			        for(int i=0;i<customerList.size();i++)
			        {
			        	if(customerList.get(i).getCustomerName().equalsIgnoreCase(newValue))
			        	{
			            	nameText.setText(newValue);
			            	addText.setText(customerList.get(i).getCustomerAddress());
			            	phoneText.setText(customerList.get(i).getCustomerPhone());
			            	emailText.setText(customerList.get(i).getCustomerEmail());
			            }
			        	if(!customerList.get(i).getCustomerName().equalsIgnoreCase(newValue))
			        	{
			            	addText.setText("");
			            	phoneText.setText("");
			            	emailText.setText("");
			        	}
			        }
		        }
		    });
		    
		    
		    
		    
		    
		    Label quantityLabel = new Label("Quantity");
		    //quantityLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(quantityLabel, 1, 6); 
	
		    
		    final TextField quantityText = new TextField();
		    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(quantityText, 2, 6);
		    tempvalidator.allowDigit(quantityText);
		    
		    
		    
		    Label amountLabel = new Label("Amount (`)");
		    
		    //amountLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(amountLabel, 1, 7); 
		    
		   
		    
		    
		    
		    final TextField amountText = new TextField();
		    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(amountText, 2, 7);
		    tempvalidator.allowAsAmount(amountText);
		   
		    
		    Label advanceLabel = new Label("Advance Received (`)");
		    //advanceLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(advanceLabel, 1, 8); 
	
		    
		    final TextField advText = new TextField();
		    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(advText, 2, 8);
		    advText.setText("0000.00");
		    tempvalidator.allowAsAmount(advText); 
		   
		    
		    Label eddLabel = new Label("Expected Delivery Date");
		    //eddLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(eddLabel, 1, 9); 
	
		    
		    final FXCalendar eddText = new FXCalendar();
		    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(eddText, 2, 9);
		    
		    Label statusLabel = new Label("Status");
		    //eddLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(statusLabel, 1, 10); 
	
		    
		    final ToggleGroup group = new ToggleGroup();
		    RadioButton rb1 = new RadioButton("Pending");
		    rb1.setUserData("Pending");
		    rb1.setToggleGroup(group);
		    rb1.setSelected(true);
		    RadioButton rb2 = new RadioButton("Partially Delivered");
		    rb2.setUserData("Partially Delivered");
		    rb2.setToggleGroup(group);
		    RadioButton rb3 = new RadioButton("Delivered");
		    rb3.setUserData("Delivered");
		    rb3.setToggleGroup(group);
		    grid.add(rb1, 2, 10);
		    grid.add(rb2, 3, 10);
		    grid.add(rb3, 4, 10);
		    
		    Button submit = new Button("Accept Order");
		    grid.add(submit,1,11);
	
		    Button cancel = new Button("Cancel");
		    grid.add(cancel,2,11);
		    
		    grid.add(msg,2,13);
			grid.add(successMsg,2,13);
		    
		    grid.setAlignment(Pos.CENTER);
		    //grid.add(servicesPercent, 3, 2);
		    
		    submit.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0)
				{
					try
					{
						
						//tempCssValidator.removeCssErrorStyle(nameText.getTextbox(),quantityText,advText);
						
						msg.setVisible(false);
						
						if (tempvalidator.isEmpty(nameText.getText())){
						msg.setVisible(true);
						//nameText.textbox.getStyleClass().add("error");
						}	
						else if(tempvalidator.isEmpty(quantityText.getText())){
							msg.setVisible(true);
							quantityText.getStyleClass().add("error");
						}
						else if(tempvalidator.isEmpty(advText.getText())){
							msg.setVisible(true);
							advText.getStyleClass().add("error");
						}
						
						else
						{
							CustomerVO customerVO = new CustomerVO();
							customerVO.setCustomerName(nameText.getText());
							customerVO.setCustomerAddress(addText.getText());
							customerVO.setCustomerPhone(phoneText.getText());
							customerVO.setCustomerEmail(emailText.getText());
							
							OrderVO orderVO = new OrderVO();
							orderVO.setCustomerName(nameText.getText());
							orderVO.setOrderQuantity(Integer.parseInt(quantityText.getText()));
							orderVO.setOrderDelivered(CommonConstants.ZERO);
							orderVO.setAmount(Double.parseDouble(amountText.getText()));
							orderVO.setAdvance(Double.parseDouble(advText.getText()));
							orderVO.setDod(eddText.getTextField().getText());
							orderVO.setStatus(group.getSelectedToggle().getUserData().toString());
							
							
							orderService.addOrder(customerVO, orderVO, clientList);
							successMsg.setText("Added Successfully !");
							successMsg.setVisible(true);
						}
					} catch (Exception e) 
					{
						e.printStackTrace();
					}
				}
			});
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
	 * <ClientEditOrder()><GridPane><Grid to edit client Order>
	 * <Abhinay Agarwal><12-10-2012>
	 * 
	 * */
	/**Modification Log
	 * 
	 * <Date> <Name> <Comments>
	 * 
	 */
	public GridPane ClientEditOrder(final BorderPane border)
	{
		grid = new GridPane();
		grid.setHgap(10);
        grid.setVgap(8);
        grid.setPadding(new Insets(30));
        
        ObservableList<String> clientList = FXCollections.observableArrayList();
        final ObservableList<String> orderList = FXCollections.observableArrayList();
        clientList.clear();
        clientList.addAll(orderService.viewClients());
        
    	Label selectClient = new Label("Select Client");
		grid.add(selectClient,1,1);
		
		ChoiceBox<String> cbClient = new ChoiceBox<String>(clientList);
		grid.add(cbClient,3,1);
		
		cbClient.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
	      	   @Override
	      	   public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
	      	   {
	      	      
	      	      // Add your stuff here
	      		   
	      		   orderList.clear();
	      		   orderList.addAll(orderService.viewOrderList(newValue));
	      	   }
	      	   });
		
			
		Label selectOrder = new Label("Select Order");
		grid.add(selectOrder,1,2);
		
		final ChoiceBox<String> cbOrder = new ChoiceBox<String>(orderList);
		grid.add(cbOrder,3,2);
		
		
		Button submit = new Button("Edit Order");
		grid.add(submit, 2, 5);
	    grid.setAlignment(Pos.CENTER);
	    //grid.add(servicesPercent, 3, 2);
	    
	    submit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0)
			{
				try
				{
					border.setCenter(newEditPaneClient(cbOrder.getValue(),border));
					border.setRight(newRightPaneEditClient(cbOrder.getValue()));
					//successMsg.setVisible(true);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}

	    });
	    
	    return grid;
	}

	
	
	/*Create Method <function name><return type><comments>
	 * <Creator Name><Date Of Creation MM-dd-yyyy>
	 * 
	 * <ClientCancelOrder()><GridPane><Grid to cancel client Order>
	 * <Abhinay Agarwal><12-10-2012>
	 * 
	 * */
	/**Modification Log
	 * 
	 * <Date> <Name> <Comments>
	 * 
	 */
	public GridPane ClientCancelOrder()
	{
		grid = new GridPane();
		grid.setHgap(10);
        grid.setVgap(8);
        grid.setPadding(new Insets(30));
        
        ObservableList<String> clientList = FXCollections.observableArrayList();
        final ObservableList<String> orderList = FXCollections.observableArrayList();
        
        clientList = orderService.viewClients();
        
		Label selectVendor = new Label("Select Client");
		grid.add(selectVendor,1,1);
		
		final ChoiceBox<String> cbClient = new ChoiceBox<String>(clientList);
		grid.add(cbClient,3,1);
		
		cbClient.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
	      	   @Override
	      	   public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
	      	   {
	      	      
	      	      // Add your stuff here
	      		   orderList.clear();
						orderList.addAll(orderService.viewOrderList(newValue));
	      	   }
	      	   });
		
		
		Label selectOrder = new Label("Select Order");
		grid.add(selectOrder,1,2);
		
		final ChoiceBox<String> cbOrder = new ChoiceBox<String>(orderList);
		grid.add(cbOrder,3,2);
		
		
		Button submit = new Button("Cancel Order");
		grid.add(submit, 2, 5);
	    grid.setAlignment(Pos.CENTER);
	    
	    successMsg.setVisible(false);
	    successMsg.setText("Cancelled Successfully !");
	    grid.add(successMsg,2,7);
	    grid.add(msg,2,7);

	    
	    submit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0)
			{
				try
				{
					msg.setVisible(false);
					if(cbClient.getValue()==null){
						cbClient.getStyleClass().add("error");
						msg.setVisible(true);
					}
					else if(cbOrder.getValue()==null){
						cbClient.getStyleClass().remove("error");
						cbOrder.getStyleClass().add("error");
						msg.setVisible(true);
					}
					else{
					orderService.cancelClientOrder(cbOrder.getValue());
					cbClient.getStyleClass().remove("error");
					cbOrder.getStyleClass().remove("error");
					successMsg.setVisible(true);
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
	    });
				
	    return grid;
	}
	
	
	/*Create Method <function name><return type><comments>
	 * <Creator Name><Date Of Creation MM-dd-yyyy>
	 * 
	 * <VendorPlaceOrder()><GridPane><Grid to add vendor Order>
	 * <Abhinay Agarwal><12-10-2012>
	 * 
	 * */
	/**Modification Log
	 * 
	 * <Date> <Name> <Comments>
	 * 
	 */
	public GridPane VendorPlaceOrder()
	{
		try
		{
			msg.setVisible(false);
			successMsg.setVisible(false);
			
			grid = new GridPane();
		    grid.setHgap(10);
		    grid.setVgap(10);
		    grid.setPadding(new Insets(0, 10, 0, 10));
	
		    
		    final ObservableList<String> vendorList = FXCollections.observableArrayList();
		    vendorList.clear();
		    
		    
		    final ObservableList<VendorVO> vendorVOList = FXCollections.observableArrayList();
		    vendorVOList.clear();
		    vendorVOList.addAll(orderService.fetchVendorDetails());
		    
		    for(VendorVO vendorVO : vendorVOList)
		    {
		    	vendorList.add(vendorVO.getVendorName());
		    }
		    
		    Label nameLabel = new Label("Vendor Name");
		    //nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(nameLabel, 1, 2); 
	
		    
		    final AutoFillTextBox<String> nameText = new AutoFillTextBox<String>(vendorList);
		    //nameText.textbox.setPrefWidth(145);
		    tempvalidator.allowCharacters(nameText.getTextbox());
		    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(nameText, 2, 2);
		    //tempvalidator.allowCharacters(nameText);
		    
		    Label addressLabel = new Label("Vendor Address");
		    //nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(addressLabel, 1, 3); 
	
		    
		    final TextField addText = new TextField();
		    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(addText, 2, 3);
		    
		    Label phoneLabel = new Label("Vendor Phone");
		    //phoneLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(phoneLabel, 1, 4); 
	
		    
		    final TextField phoneText = new TextField();
		    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(phoneText, 2, 4);
		    tempvalidator.allowAsPhoneNumber(phoneText);
		    
		    Label emailLabel = new Label("Vendor Email");
		    //emailLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(emailLabel, 1, 5); 
	
		    
		    final TextField emailText = new TextField();
		    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(emailText, 2, 5);
		    
		    
		    
		    nameText.getTextbox().textProperty().addListener(new ChangeListener<String>() {
		        @Override
		        public void changed(final ObservableValue<? extends String> observableValue, final String oldValue, final String newValue) {
		            
			        for(int i=0;i<vendorVOList.size();i++)
			        {
			        	if(vendorVOList.get(i).getVendorName().equalsIgnoreCase(newValue))
			        	{
			            	nameText.getTextbox().setText(newValue);
			            	addText.setText(vendorVOList.get(i).getVendorAddress());
			            	phoneText.setText(vendorVOList.get(i).getVendorPhone());
			            	emailText.setText(vendorVOList.get(i).getVendorEmail());
			            }
			        	if(!vendorVOList.get(i).getVendorName().equalsIgnoreCase(newValue))
			        	{
			            	addText.setText("");
			            	phoneText.setText("");
			            	emailText.setText("");
			        	}
			        }
		        }
		    });
		    
		    Label quantityLabel = new Label("Quantity");
		    //quantityLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(quantityLabel, 1, 6); 
	
		    
		    final TextField quantityText = new TextField();
		    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(quantityText, 2, 6);
		    tempvalidator.allowDigit(quantityText);
		    
		    Label amountLabel = new Label("Amount (`)");
		    //amountLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(amountLabel, 1, 7); 
	
		    
		    final TextField amountText = new TextField();
		    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(amountText, 2, 7);
		    tempvalidator.allowAsAmount(amountText);
		    
		    Label advanceLabel = new Label("Adavance Given (`)");
		    //advanceLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(advanceLabel, 1, 8); 
	
		    
		    final TextField advText = new TextField();
		    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(advText, 2, 8);
		    advText.setText("0000.00");
		    tempvalidator.allowAsAmount(advText); 
		    
		    Label eddLabel = new Label("Expected Delivery Date");
		    //eddLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(eddLabel, 1, 9); 
	
		    
		    final FXCalendar eddText = new FXCalendar();
		    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		    grid.add(eddText, 2, 9);
		    
		    grid.add(msg,2,13);
		 	grid.add(successMsg,2,13);
		 	    
		    final ToggleGroup group = new ToggleGroup();
		    RadioButton rb1 = new RadioButton("Pending");
		    rb1.setUserData("Pending");
		    rb1.setToggleGroup(group);
		    rb1.setSelected(true);
		    RadioButton rb2 = new RadioButton("Partially Received");
		    rb2.setUserData("Partially Received");
		    rb2.setToggleGroup(group);
		    RadioButton rb3 = new RadioButton("Received");
		    rb3.setUserData("Received");
		    rb3.setToggleGroup(group);
		    grid.add(rb1, 2, 10);
		    grid.add(rb2, 3, 10);
		    grid.add(rb3, 4, 10);
		    
		    Button submit = new Button("Place Order");
		    grid.add(submit,1,11);
	
		    Button cancel = new Button("Cancel");
		    grid.add(cancel,2,11);
	
		    // Right label in column 4 (top), row 3
		    //Text servicesPercent = new Text("Services\n20%");
		    grid.setAlignment(Pos.CENTER);
		    //grid.add(servicesPercent, 3, 2);
		    
		    
		    submit.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0)
				{
					try
					{
						/*nameText.getStyleClass().remove("error");
						quantityText.getStyleClass().remove("error");*/
						tempCssValidator.removeCssErrorStyle(nameText.getTextbox(),quantityText,advText);
						msg.setVisible(false);
						
						if (tempvalidator.isEmpty(nameText.getText())){
						msg.setVisible(true);
						nameText.getTextbox().getStyleClass().add("error");
						}	
						else if(tempvalidator.isEmpty(quantityText.getText())){
							msg.setVisible(true);
							quantityText.getStyleClass().add("error");
						}
						else if(tempvalidator.isEmpty(amountText.getText())){
							msg.setVisible(true);
							amountText.getStyleClass().add("error");
						}
						else if(tempvalidator.isEmpty(advText.getText())){
							msg.setVisible(true);
							advText.getStyleClass().add("error");
						}
						else{
							msg.setVisible(false);
							VendorVO vendorVO = new VendorVO();
							vendorVO.setVendorName(nameText.getText());
							vendorVO.setVendorAddress(addText.getText());
							vendorVO.setVendorPhone(phoneText.getText());
							vendorVO.setVendorEmail(emailText.getText());
							
							OrderVO orderVO = new OrderVO();
							orderVO.setCustomerName(nameText.getText());
							orderVO.setOrderQuantity(Integer.parseInt(quantityText.getText()));
							orderVO.setOrderDelivered(CommonConstants.ZERO);
							orderVO.setAmount(Double.parseDouble(amountText.getText()));
							orderVO.setAdvance(Double.parseDouble(advText.getText()));
							orderVO.setDod(eddText.getTextField().getText());
							orderVO.setStatus(group.getSelectedToggle().getUserData().toString());
							orderService.addVendorOrder(vendorVO, orderVO,vendorList);
							successMsg.setText("Added Successfully !");
							successMsg.setVisible(true);
						}
						
						
						
					} catch (Exception e) 
					{
						e.printStackTrace();
					}
				}
			});
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	    return grid;
	}
	
	
	/*Create Method <function name><return type><comments>
	 * <Creator Name><Date Of Creation MM-dd-yyyy>
	 * 
	 * <VendorEditOrder()><GridPane><Grid to edit Order>
	 * <Abhinay Agarwal><12-10-2012>
	 * 
	 * */
	/**Modification Log
	 * 
	 * <Date> <Name> <Comments>
	 * 
	 */
	public GridPane VendorEditOrder(final BorderPane border)
	{
		grid = new GridPane();
		grid.setHgap(10);
        grid.setVgap(8);
        grid.setPadding(new Insets(30));
        
        ObservableList<String> clientList = FXCollections.observableArrayList();
        final ObservableList<String> orderList = FXCollections.observableArrayList();
        clientList.clear();
        clientList.addAll(orderService.viewVendors());
        
    	Label selectClient = new Label("Select Vendor");
		grid.add(selectClient,1,1);
		
		ChoiceBox<String> cbClient = new ChoiceBox<String>(clientList);
		grid.add(cbClient,3,1);
		
		cbClient.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
	      	   @Override
	      	   public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
	      	   {
	      	      
	      	      // Add your stuff here
	      		   
	      		   orderList.clear();
	      		   orderList.addAll(orderService.viewPurchaseList(newValue));
	      	   }
	      	   });
		
			
		Label selectOrder = new Label("Select Purchase");
		grid.add(selectOrder,1,2);
		
		final ChoiceBox<String> cbOrder = new ChoiceBox<String>(orderList);
		grid.add(cbOrder,3,2);
		
		
		Button submit = new Button("Edit Order");
		grid.add(submit, 2, 5);
	    grid.setAlignment(Pos.CENTER);
	    //grid.add(servicesPercent, 3, 2);
	    
	    submit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0)
			{
				try
				{
					border.setCenter(newEditPaneVendor(cbOrder.getValue(),border));
					border.setRight(newRightPaneEditVendor(cbOrder.getValue()));
					//successMsg.setVisible(true);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}

	    });
	    
	    return grid;
	}
	
	/*Create Method <function name><return type><comments>
	 * <Creator Name><Date Of Creation MM-dd-yyyy>
	 * 
	 * <VendorCancelOrder()><GridPane><Grid to view cancel Order>
	 * <Abhinay Agarwal><12-10-2012>
	 * 
	 * */
	/**Modification Log
	 * 
	 * <Date> <Name> <Comments>
	 * 
	 */
		public GridPane VendorCancelOrder()
		{
			msg.setVisible(false);
			successMsg.setVisible(false);
			
			grid = new GridPane();
			grid.setHgap(10);
	        grid.setVgap(8);
	        grid.setPadding(new Insets(30));
	        
	        ObservableList<String> vendorList = FXCollections.observableArrayList();
	        final ObservableList<String> orderList = FXCollections.observableArrayList();
	        
	        vendorList = orderService.viewVendors();
	        
			Label selectVendor = new Label("Select Vendor");
			grid.add(selectVendor,1,1);
			
			final ChoiceBox<String> cbVendor = new ChoiceBox<String>(vendorList);
					
			grid.add(cbVendor,3,1);
			
			cbVendor.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		      	   @Override
		      	   public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
		      	   {
		      	      
		      	      // Add your stuff here
		      		   orderList.clear();
							orderList.addAll(orderService.viewPurchaseList(newValue));
		      	   }
		      	   });
			
			
			Label selectOrder = new Label("Select Order");
			grid.add(selectOrder,1,2);
			
			final ChoiceBox<String> cbOrder = new ChoiceBox<String>(orderList);
			grid.add(cbOrder,3,2);
			
			
			Button submit = new Button("Cancel Order");
			grid.add(submit, 2, 5);
		    grid.setAlignment(Pos.CENTER);
		    //grid.add(servicesPercent, 3, 2);
		  
		    grid.add(msg, 2, 7);
		    grid.add(successMsg, 2, 7);
		    successMsg.setText("Cancelled Successfully !");
		    
		    submit.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0)
				{
					try
					{
						msg.setVisible(false);
						if(cbVendor.getValue()==null){
							cbVendor.getStyleClass().add("error");
							msg.setVisible(true);
						}
						else if(cbOrder.getValue()==null){
							cbVendor.getStyleClass().remove("error");
							cbOrder.getStyleClass().add("error");
							msg.setVisible(true);
						}
						else{
						orderService.cancelClientOrder(cbOrder.getValue());
						cbVendor.getStyleClass().remove("error");
						cbOrder.getStyleClass().remove("error");
						msg.setVisible(false);
						successMsg.setVisible(true);
						orderService.cancelVendorOrder(cbOrder.getValue());
						}
						
						
					
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
		    });
		    
		    return grid;
	}
	
	/*Create Method <function name><return type><comments>
	 * <Creator Name><Date Of Creation MM-dd-yyyy>
	 * 
	 * <viewOrder()><GridPane><Table to view Client Order>
	 * <Abhinay Agarwal><12-10-2012>
	 * 
	 * */
	/**Modification Log
	 * 
	 * <Date> <Name> <Comments>
	 * 
	 */
	public GridPane viewOrder()
	{
 		ObservableList<OrderVO> dataTable;
 				
		grid = new GridPane();
		grid.setHgap(10);
        grid.setVgap(8);
        grid.setPadding(new Insets(30));
 	
        try
        {
        	dataTable = FXCollections.observableArrayList();
        	dataTable = orderService.viewOrder();
        	BorderPane newBorderPane = new BorderPane();
        	
        	
		 	final Label label = new Label("Client Orders");
		 	newBorderPane.setLeft(label);
		 	grid.add(newBorderPane,1,1);
		 	
		 	TableView<OrderVO> table = new TableView<OrderVO>();
		 	table.setEditable(false);
		 	//table.setPrefSize(1250, 1250);
		 	
		 	TableColumn dateOfOrder = new TableColumn("Date Of Order");
		 	dateOfOrder.setMinWidth(125);
		 	dateOfOrder.setCellValueFactory(
		 			new PropertyValueFactory<OrderVO, String>("date"));
		 	TableColumn orderNo = new TableColumn("Order No");
		 	orderNo.setMinWidth(125);
		 	orderNo.setCellValueFactory(
		 			new PropertyValueFactory<OrderVO, String>("orderNo"));
		 	TableColumn customerName = new TableColumn("Customer Name");
		 	customerName.setMinWidth(125);
		 	customerName.setCellValueFactory(
		 			new PropertyValueFactory<OrderVO, String>("customerName"));
		 	TableColumn orderQuantity = new TableColumn("Order Quantity");
		 	orderQuantity.setMinWidth(125);
		 	orderQuantity.setCellValueFactory(
		 			new PropertyValueFactory<OrderVO, Integer>("orderQuantity"));
		 	
		 	TableColumn orderDelivered = new TableColumn("Order Delivered");
		 	orderDelivered.setMinWidth(125);
		 	orderDelivered.setCellValueFactory(
		 			new PropertyValueFactory<OrderVO, Integer>("orderDelivered"));
		 	
		 	TableColumn orderPending = new TableColumn("Order Pending");
		 	orderPending.setMinWidth(125);
		 	orderPending.setCellValueFactory(
		 			new PropertyValueFactory<OrderVO, Integer>("orderPending"));
		 	TableColumn amount = new TableColumn("Amount Received");
		 	amount.setMinWidth(125);
		 	amount.setCellValueFactory(
		 			new PropertyValueFactory<OrderVO, Double>("amount"));
		 	TableColumn advance = new TableColumn("Advance Received");
		 	advance.setMinWidth(125);
		 	advance.setCellValueFactory(
		 			new PropertyValueFactory<OrderVO, Double>("advance"));
		 	TableColumn dod = new TableColumn("Date Of Delivery");
		 	dod.setMinWidth(125);
		 	dod.setCellValueFactory(
		 			new PropertyValueFactory<OrderVO, String>("dod"));
		 	TableColumn status = new TableColumn("Status");
		 	status.setMinWidth(125);
		 	status.setCellValueFactory(
		 			new PropertyValueFactory<OrderVO, String>("status"));
		 	
		 	table.setItems(dataTable);
		 	table.getColumns().addAll(dateOfOrder,orderNo, customerName, orderQuantity,orderDelivered,orderPending,amount, advance, dod, status);
		 	
		 	grid.setAlignment(Pos.TOP_LEFT);
		 	//table.getSelectionModel().setCellSelectionEnabled(true);
		 	grid.add(table,1,3);
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
	 * <viewOrder()><GridPane><Table to view Client Order>
	 * <Abhinay Agarwal><12-10-2012>
	 * 
	 * */
	/**Modification Log
	 * 
	 * <Date> <Name> <Comments>
	 * 
	 */
	public GridPane viewVendorOrder()
	{
 		ObservableList<OrderVO> dataTable;
 				
		grid = new GridPane();
		grid.setHgap(10);
        grid.setVgap(8);
        grid.setPadding(new Insets(30));
 	
        try
        {
        	dataTable = FXCollections.observableArrayList();
        	dataTable = orderService.viewVendorOrder();
    
		 	final Label label = new Label("Vendor Orders");
		 	
		 	grid.add(label,1,1);
		 	
		 	TableView<OrderVO> table = new TableView<OrderVO>();
		 	table.setEditable(false);
		 	//table.setPrefSize(1250, 1250);
		 	
		// table.setId("my-custom");
		 
		 	
		 	TableColumn dateOfOrder = new TableColumn("Date Of Order");
		 	dateOfOrder.setMinWidth(125);
		 	dateOfOrder.setCellValueFactory(
		 			new PropertyValueFactory<OrderVO, String>("date"));
		 	TableColumn orderNo = new TableColumn("Purchase No");
		 	orderNo.setMinWidth(125);
		 	orderNo.setCellValueFactory(
		 			new PropertyValueFactory<OrderVO, String>("orderNo"));
		 	TableColumn customerName = new TableColumn("Vendor Name");
		 	customerName.setMinWidth(125);
		 	customerName.setCellValueFactory(
		 			new PropertyValueFactory<OrderVO, String>("customerName"));
		 	TableColumn orderQuantity = new TableColumn("Order Quantity");
		 	orderQuantity.setMinWidth(125);
		 	orderQuantity.setCellValueFactory(
		 			new PropertyValueFactory<OrderVO, String>("orderQuantity"));
		 	TableColumn orderDelivered = new TableColumn("Order Delivered");
		 	orderDelivered.setMinWidth(125);
		 	orderDelivered.setCellValueFactory(
		 			new PropertyValueFactory<OrderVO, String>("orderDelivered"));
		 	TableColumn orderPending = new TableColumn("Order Pending");
		 	orderPending.setMinWidth(125);
		 	orderPending.setCellValueFactory(
		 			new PropertyValueFactory<OrderVO, String>("orderPending"));
		 	TableColumn amount = new TableColumn("Amount To Be Paid");
		 	amount.setMinWidth(125);
		 	amount.setCellValueFactory(
		 			new PropertyValueFactory<OrderVO, String>("amount"));
		 	TableColumn advance = new TableColumn("Advance Paid");
		 	advance.setMinWidth(125);
		 	advance.setCellValueFactory(
		 			new PropertyValueFactory<OrderVO, String>("advance"));
		 	TableColumn dod = new TableColumn("Date Of Delivery");
		 	dod.setMinWidth(125);
		 	dod.setCellValueFactory(
		 			new PropertyValueFactory<OrderVO, String>("dod"));
		 	TableColumn status = new TableColumn("Status");
		 	status.setMinWidth(125);
		 	status.setCellValueFactory(
		 			new PropertyValueFactory<OrderVO, String>("status"));
		 	
		
		 	
		 	table.setItems(dataTable);
		 	table.getColumns().addAll(dateOfOrder,orderNo, customerName, orderQuantity,orderDelivered,orderPending, amount, advance, dod, status);
		 	
		 	
		 	
		 	grid.setAlignment(Pos.TOP_LEFT);
		 	
		 	grid.add(table,1,3);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
	 	
	 	return grid;
	}
	
	
	public GridPane newEditPaneClient(final String orderNo, final BorderPane border) throws Exception
	{
	
		msg.setVisible(false);
		successMsg.setVisible(false);
		
		grid = new GridPane();
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(0, 10, 0, 10));
	    
	   
	    
	    Label quantityLabel = new Label("Quantity Delivered");
	    //quantityLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(quantityLabel, 1, 2); 

	    
	    final TextField quantityText = new TextField();
	    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(quantityText, 3, 2);
	    tempvalidator.allowDigit(quantityText);
	     
	    Label paymentLabel1 = new Label("Payment Received (`)");
	    //quantityLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(paymentLabel1, 1, 3); 

	    
	    final TextField paymentText = new TextField();
	    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(paymentText, 3, 3);
	    tempvalidator.allowAsAmount(paymentText);
	    
	    
	    Button submit = new Button("Update Order");
		grid.add(submit, 2, 5);
	    grid.setAlignment(Pos.CENTER);
	    
	    successMsg.setVisible(false);
	    successMsg.setText("Updated Successfully !");
	    grid.add(successMsg,2,7);
	    grid.add(msg,2,7);

	    
	    submit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0)
			{
				try
				{
					msg.setVisible(false);
					if(quantityText.getText()==null){
						quantityText.getStyleClass().add("error");
						msg.setVisible(true);
					}
					else if(paymentText.getText()==null){
						quantityText.getStyleClass().remove("error");
						paymentText.getStyleClass().add("error");
						msg.setVisible(true);
					}
					else{
					orderService.editClientOrder(orderNo, Integer.parseInt(quantityText.getText()), Double.parseDouble((paymentText.getText())));
					quantityText.getStyleClass().remove("error");
					paymentText.getStyleClass().remove("error");
					border.setRight(newRightPaneEditClient(orderNo));
					successMsg.setVisible(true);
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
	    });
	    
	     
	     grid.setAlignment(Pos.CENTER);
	     return grid;
	}	

	
	
	public GridPane newRightPaneEditClient(String orderNo) throws Exception
	{
	
		msg.setVisible(false);
		successMsg.setVisible(false);
		
		grid = new GridPane();
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(0, 100, 0, 10));
	    
	    
	    OrderVO orderVO = new OrderVO();
	    
	    orderVO = orderService.fetchClientOrderDetails(orderNo);
	    
	    
	    Label orderLabel = new Label("Order Number : ");
	    orderLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(orderLabel, 1, 1);
	    
	    Label orderNumber = new Label(orderVO.getOrderNo());
	    orderNumber.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(orderNumber, 2, 1);
	    
	    Label customerLabel = new Label("Customer Name : ");
	    customerLabel.setFont(Font.font("Arial", 20));
	    grid.add(customerLabel, 1, 2);
	    
	    Label custName = new Label(orderVO.getCustomerName());
	    custName.setFont(Font.font("Arial", 20));
	    grid.add(custName, 2, 2);
	    
	    Label quantityLabel = new Label("Quantiy Order Recieved : ");
	    quantityLabel.setFont(Font.font("Arial", 20));
	    grid.add(quantityLabel, 1, 3);
	    
	    Label quantity = new Label(((Integer)orderVO.getOrderQuantity()).toString());
	    quantity.setFont(Font.font("Arial", 20));
	    grid.add(quantity, 2, 3);
	    
	    Label quantityDel = new Label("Quantity Delivered : ");
	    quantityDel.setFont(Font.font("Arial", 20));
	    grid.add(quantityDel, 1, 4);
	    
	    Label quantityDeivered = new Label(((Integer)orderVO.getOrderDelivered()).toString());
	    quantityDeivered.setFont(Font.font("Arial", 20));
	    grid.add(quantityDeivered, 2, 4);
	    
	    Label quantityP = new Label("Quantity Pending : ");
	    quantityP.setFont(Font.font("Arial", 20));
	    grid.add(quantityP, 1, 5);
	    
	    Label quantityPending = new Label(((Integer)orderVO.getOrderPending()).toString());
	    quantityPending.setFont(Font.font("Arial", 20));
	    grid.add(quantityPending, 2, 5);
	    
	    Label totalAmountLabel = new Label("Total Amount (`) : ");
	    totalAmountLabel.setFont(Font.font("Arial", 20));
	    grid.add(totalAmountLabel, 1, 6);
	    
	    Label totalAmount = new Label(df.format(((Double)orderVO.getAmount())).toString());
	    totalAmount.setFont(Font.font("Arial", 20));
	    grid.add(totalAmount, 2, 6);
	    
	    Label amountP = new Label("Amount Pending (`) : ");
	    amountP.setFont(Font.font("Arial", 20));
	    grid.add(amountP, 1, 7);
	    
	    Label amountPending = new Label(df.format(((Double)(orderVO.getAmount()-orderVO.getAdvance()))).toString());
	    amountPending.setFont(Font.font("Arial", 20));
	    grid.add(amountPending, 2, 7);
	     
	    
	    	     
	    grid.setAlignment(Pos.CENTER_LEFT);
	     return grid;
	}	

	
	public GridPane newEditPaneVendor(final String orderNo,final BorderPane border) throws Exception
	{
	
		msg.setVisible(false);
		successMsg.setVisible(false);
		
		grid = new GridPane();
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(0, 10, 0, 10));
	    
	   
	    
	    Label quantityLabel = new Label("Quantity Recieved");
	    //quantityLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(quantityLabel, 1, 2); 

	    
	    final TextField quantityText = new TextField();
	    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(quantityText, 3, 2);
	    tempvalidator.allowDigit(quantityText);
	     
	    Label paymentLabel1 = new Label("Payment Given (in `)");
	    //quantityLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(paymentLabel1, 1, 3); 

	    
	    final TextField paymentText = new TextField();
	    //nameText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(paymentText, 3, 3);
	    tempvalidator.allowAsAmount(paymentText);
	    
	    
	    Button submit = new Button("Update Order");
		grid.add(submit, 2, 5);
	    grid.setAlignment(Pos.CENTER);
	    
	    successMsg.setVisible(false);
	    successMsg.setText("Updated Successfully !");
	    grid.add(successMsg,2,7);
	    grid.add(msg,2,7);

	    
	    submit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0)
			{
				try
				{
					msg.setVisible(false);
					if(quantityText.getText()==null){
						quantityText.getStyleClass().add("error");
						msg.setVisible(true);
					}
					else if(paymentText.getText()==null){
						quantityText.getStyleClass().remove("error");
						paymentText.getStyleClass().add("error");
						msg.setVisible(true);
					}
					else{
					orderService.editVendorOrder(orderNo, Integer.parseInt(quantityText.getText()), Double.parseDouble((paymentText.getText())));
					quantityText.getStyleClass().remove("error");
					paymentText.getStyleClass().remove("error");
					border.setRight(newRightPaneEditClient(orderNo));
					successMsg.setVisible(true);
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
	    });
	    
	     
	     grid.setAlignment(Pos.CENTER);
	     return grid;
	}	

	
	
	public GridPane newRightPaneEditVendor(String orderNo) throws Exception
	{
	
		msg.setVisible(false);
		successMsg.setVisible(false);
		
		grid = new GridPane();
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(0, 100, 0, 10));
	    
	    
	    OrderVO orderVO = new OrderVO();
	    
	    orderVO = orderService.fetchVendorOrderDetails(orderNo);
	    
	    
	    Label orderLabel = new Label("Purchase Number : ");
	    orderLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(orderLabel, 1, 1);
	    
	    Label orderNumber = new Label(orderVO.getOrderNo());
	    orderNumber.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    grid.add(orderNumber, 2, 1);
	    
	    Label customerLabel = new Label("Vendor Name : ");
	    customerLabel.setFont(Font.font("Arial", 20));
	    grid.add(customerLabel, 1, 2);
	    
	    Label custName = new Label(orderVO.getCustomerName());
	    custName.setFont(Font.font("Arial", 20));
	    grid.add(custName, 2, 2);
	    
	    Label quantityLabel = new Label("Quantiy Order Given : ");
	    quantityLabel.setFont(Font.font("Arial", 20));
	    grid.add(quantityLabel, 1, 3);
	    
	    Label quantity = new Label(((Integer)orderVO.getOrderQuantity()).toString());
	    quantity.setFont(Font.font("Arial", 20));
	    grid.add(quantity, 2, 3);
	    
	    Label quantityDel = new Label("Quantity Received : ");
	    quantityDel.setFont(Font.font("Arial", 20));
	    grid.add(quantityDel, 1, 4);
	    
	    Label quantityDeivered = new Label(((Integer)orderVO.getOrderDelivered()).toString());
	    quantityDeivered.setFont(Font.font("Arial", 20));
	    grid.add(quantityDeivered, 2, 4);
	    
	    Label quantityP = new Label("Quantity Pending : ");
	    quantityP.setFont(Font.font("Arial", 20));
	    grid.add(quantityP, 1, 5);
	    
	    Label quantityPending = new Label(((Integer)orderVO.getOrderPending()).toString());
	    quantityPending.setFont(Font.font("Arial", 20));
	    grid.add(quantityPending, 2, 5);
	    
	    Label totalAmountLabel = new Label("Total Amount : ");
	    totalAmountLabel.setFont(Font.font("Arial", 20));
	    grid.add(totalAmountLabel, 1, 6);
	    
	    Label totalAmount = new Label(df.format(((Double)orderVO.getAmount())).toString());
	    totalAmount.setFont(Font.font("Arial", 20));
	    grid.add(totalAmount, 2, 6);
	    
	    Label amountP = new Label("Amount Debited : ");
	    amountP.setFont(Font.font("Arial", 20));
	    grid.add(amountP, 1, 7);
	    
	    Label amountPending = new Label(df.format(((Double)(orderVO.getAmount()-orderVO.getAdvance()))).toString());
	    amountPending.setFont(Font.font("Arial", 20));
	    grid.add(amountPending, 2, 7);
	     
	    
	    	     
	    grid.setAlignment(Pos.CENTER_LEFT);
	     return grid;
	}	
	
}
