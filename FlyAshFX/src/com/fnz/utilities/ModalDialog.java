package com.fnz.utilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ModalDialog {
	Button UploadButton, DownloadButton, CancelButton, OkButton;
	String ftpServer = "ftp.DriveHQ.com";
	String User="panther999";
	String password="seahawk123";
	String MacAdd= new ObtainMac().getMac();
	String filename="\\VirtualDatabaseBackup\\"+MacAdd+",flyash.db";
	String filepath="c:/FlyAsh/flyash.db";
	Boolean flag=true;
	GridPane grid;
	
	
	
	  public void ModalDialogUpload(final Stage stg,String title, String message) {
		  
	        
	        final  Stage stage = new Stage(StageStyle.UTILITY);           
	            //Initialize the Stage with type of modal
	       
	            stage.initModality(Modality.APPLICATION_MODAL);
	            stage.setResizable(false);
	            //Set the owner of the Stage 
	            stage.initOwner(stg);
	            stage.setTitle(title);
	            
	            Group root = new Group();
	             Scene scene = new Scene(root);
	            // scene.setFill(Color.rgb(139,104,139));
	            root.setId("baseModal");
	            scene.getStylesheets().addAll(this.getClass().getResource("/com/fnz/styles/gui.css").toExternalForm()); 
	         
	          //  DropShadow dropShadow = new DropShadow();
              //  dropShadow.setOffsetX(5);
              //  dropShadow.setOffsetY(5);
	             final Text text = new Text(message);
	             text.setFont(Font.font("Courier New", 18));
	           //  text.setEffect(dropShadow);
	             text.setX(600); 
	             
	            
	             
	             BorderPane borderPane = new BorderPane();
	             borderPane.setPadding(new Insets(25,20,20,20));
	             
	             final HBox btnHBox = new HBox(15);
	             btnHBox.setPadding(new Insets(20,5,20,5));
	             btnHBox.setAlignment(Pos.CENTER);
	             
	            DropShadow effect = new DropShadow();
	             
	           
	            	 UploadButton = new Button();
	               	  Image uploadImage = new Image("upload.png",30,30,false,false);
	            	  UploadButton.setGraphic(new ImageView(uploadImage));
	            	  UploadButton.setPrefSize(50, 50);
	            	  final Tooltip tooltipupload = new Tooltip();
	                  tooltipupload.setText("Backup your database\n");
	                  UploadButton.setOpacity(0.8);
	                
	                  UploadButton.setTooltip(tooltipupload);
	                  UploadButton.setId("uploaddownload");
	                  
	                  DownloadButton = new Button();
	                  Image downloadImage = new Image("download.png",30,30,false,false);
	                  DownloadButton.setGraphic(new ImageView(downloadImage));
	                  DownloadButton.setPrefSize(50, 50);
	            	  final Tooltip tooltipdownload = new Tooltip();
	            	  tooltipdownload.setText("Restores the database\n");
	                  DownloadButton.setOpacity(0.8);
	                
	                  DownloadButton.setTooltip(tooltipdownload);
	                  DownloadButton.setId("uploaddownload");
	                 
	            	
	            	 btnHBox.getChildren().addAll(UploadButton,DownloadButton);
	         
	            
	     		//borderPane.setTop(topAnchorPane);
	            	 
	     		borderPane.setCenter(text);
	     		borderPane.setBottom(btnHBox);
	     		final FileUploadDownload fileUpload=new FileUploadDownload();
	     		UploadButton.setOnAction(new EventHandler<ActionEvent>() {
	     
	                public void handle(ActionEvent event) {
	                	
	                	
	                File file= new File(filepath);
	               try {
	            	   String checkUpload=new String();
					checkUpload=fileUpload.upload(ftpServer, User,password,filename,file);
					text.setText(checkUpload);
					Button doneButton= new Button("Done");
					
					btnHBox.getChildren().removeAll(UploadButton,DownloadButton);
					btnHBox.getChildren().addAll(doneButton);
					 
					stage.setHeight(150);
					stage.setWidth(230);
					doneButton.setOnAction(new EventHandler<ActionEvent>() {
					     
		                public void handle(ActionEvent event) {
		                	stage.close();
		                		}
		            });
		               
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    
	                }
	            });
	             
	     		final FileUploadDownload fileDownload=new FileUploadDownload();
	     		DownloadButton.setOnAction(new EventHandler<ActionEvent>() {
	     		     
	                public void handle(ActionEvent event) {
	                	
	                	
	                File file= new File(filepath);
	               try {
	            	   String checkDownload= new String();
	            	   
	            	   
	            	   checkDownload=fileDownload.download(ftpServer, User,password,filename,file);
	            	    text.setText(checkDownload);
						Button doneButton= new Button("Done");
						btnHBox.getChildren().removeAll(UploadButton,DownloadButton);
						btnHBox.getChildren().addAll(doneButton);
						
						doneButton.setOnAction(new EventHandler<ActionEvent>() {
						     
			                public void handle(ActionEvent event) {
			                	stage.close();
			                		}
			            });
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	                
	                 
	                 
	                    
	                }
	            });
	            root.getChildren().add(borderPane);   
	            stage.setScene(scene);        
	            stage.show();
	     
	        
	        }
	  
	  
	  
	  public void ModalDialogConfigure(final Stage stg,String title, String message) {
		  
	        
	        final  Stage stage = new Stage(StageStyle.UTILITY);           
	            //Initialize the Stage with type of modal
	       
	            stage.initModality(Modality.APPLICATION_MODAL);
	            stage.setResizable(false);
	            //Set the owner of the Stage 
	            stage.initOwner(stg);
	            stage.setTitle(title);
	            
	            Group root = new Group();
	             Scene scene = new Scene(root);
	           
	            scene.getStylesheets().addAll(this.getClass().getResource("/com/fnz/styles/gui.css").toExternalForm()); 
	         
	      
	             BorderPane borderPane = new BorderPane();
	             borderPane.setPadding(new Insets(5,5,5,5));
	             
	           
	                 
	            	
	            	
	         
	            
	     		try {
					borderPane.setCenter(AddGridConfig());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            	 
	     		
	     		
	     		
	            root.getChildren().add(borderPane);   
	            stage.setScene(scene);        
	            stage.show();
	     
	        
	        }
	  
	  public GridPane AddGridConfig() throws Exception
		{
		 try
		 {
			Text msg=new Text("troll");
			Text Successmsg=new Text("troll");
			grid = new GridPane();
			grid.setHgap(1);
          grid.setVgap(8);
          grid.setPadding(new Insets(30));
          
			/*Label message = new Label("Please Enter Details");
			grid.add(message,1,1);*/
			
			Label selectCompanyName = new Label("Company Name");
			grid.add(selectCompanyName,1,2);
			
			final TextField companyName = new TextField();
			grid.add(companyName,2,2);
			
			Label lCompanyAdd = new Label("Your Address");
			grid.add(lCompanyAdd,1,3);
			final TextField companyAdd = new TextField();
			grid.add(companyAdd,2,3);
			
			Label lCompanyPin = new Label("Your Pin");
			grid.add(lCompanyPin,1,4);
			final TextField companyPin = new TextField();
			grid.add(companyPin,2,4);
			
			Label lCompanyPhone = new Label("Your Phone");
			grid.add(lCompanyPhone,1,5);
			final TextField companyPhone = new TextField();
			grid.add(companyPhone,2,5);
			
			Label lCompanyTin = new Label("Your Tin");
			grid.add(lCompanyTin,1,6);
			final TextField companyTin = new TextField();
			grid.add(companyTin,2,6);
			
			
			Button submit = new Button("Configure");
			grid.add(submit, 2, 8);
			
			

			/*grid.add(msg,2,7);
			grid.add(Successmsg,2,7);*/
		    
		    
		    grid.setAlignment(Pos.CENTER);
		   
		    
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		    return grid;
		}
	  
	  
	  
}
