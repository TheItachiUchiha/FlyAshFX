package com.fnz.Validation;

/**
 * 
 */

import java.util.regex.*;

import com.mytdev.javafx.scene.control.AutoCompleteTextField;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

/**
 * @author Pragati
 *
 */
public class Validation 
{
	
	static int i=0;
	public boolean isEmpty(String temp){
	Pattern p =Pattern.compile(" ");
	 Matcher m = p.matcher(temp);
	temp=m.replaceAll("");
	
		if ((temp==null)||("".equals(temp))){
			return true;
		}
		
		else{
			
		
		return false;
		}
	}
	
public boolean isWord(String temp){
	  Pattern p = Pattern.compile("[a-zA-Z ]+");
	  Matcher m = p.matcher(temp);
	  return m.matches();
	}
public boolean isEmail(String temp){
	  Pattern p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	  Matcher m = p.matcher(temp);
	  return m.matches();
	}

public void allowDigit(final TextField fieldName){
	
	fieldName.lengthProperty().addListener(new ChangeListener<Number>(){
		 
		@Override
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {              
			 
			 if(newValue.intValue() > oldValue.intValue()){
				char ch = fieldName.getText().charAt(oldValue.intValue());
				//System.out.println("Length:"+ oldValue+"  "+ newValue +" "+ch);                   
	 
				//Check if the new character is the number or other's
				if(!(ch >= '0' && ch <= '9' )){       
	                 
					//if it's not number then just setText to previous one
					fieldName.setText(fieldName.getText().substring(0,fieldName.getText().length()-1)); 
				}
			}
		}
		
	});
}
public void allowAsEmail(final TextField fieldName){
	
	fieldName.lengthProperty().addListener(new ChangeListener<Number>(){
		 
		@Override
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {              
			 
			 if(newValue.intValue() > oldValue.intValue()){
				char ch = fieldName.getText().charAt(oldValue.intValue());
				//System.out.println("Length:"+ oldValue+"  "+ newValue +" "+ch);                   
	 
				//Check if the new character is the number or other's
				if((isEmail(fieldName.getText()))){       
	                 
					//if it's not number then just setText to previous one
					fieldName.setText(fieldName.getText().substring(0,fieldName.getText().length()-1)); 
				}
			}
		}
		
	});
}
public void allowCharacters(final TextField fieldName){
	
	fieldName.lengthProperty().addListener(new ChangeListener<Number>(){
		 
		@Override
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {              
			 
			 if(newValue.intValue() > oldValue.intValue()){
				char ch = fieldName.getText().charAt(oldValue.intValue());
				//System.out.println("Length:"+ oldValue+"  "+ newValue +" "+ch);                   
	 
				//Check if the new character is the number or other's
				if(!((ch >= 'a' && ch <= 'z' )||(ch >= 'A' && ch <= 'Z' )||(ch == ' '))){       
	                 
					//if it's not number then just setText to previous one
					fieldName.setText(fieldName.getText().substring(0,fieldName.getText().length()-1)); 
				}
			}
		}
		
	});
}


public void allowAsPhoneNumber(final TextField fieldName){
	
	fieldName.lengthProperty().addListener(new ChangeListener<Number>(){
		 
		@Override
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {              
			 
			 if(newValue.intValue() > oldValue.intValue()){
				char ch = fieldName.getText().charAt(oldValue.intValue());
				//System.out.println("Length:"+ oldValue+"  "+ newValue +" "+ch);                   
	 
				//Check if the new character is the number or other's
				if(!((ch >= '0' && ch <= '9' )&&(fieldName.getText().length()<=10))){       
	                 
					//if it's not number then just setText to previous one
					fieldName.setText(fieldName.getText().substring(0,fieldName.getText().length()-1)); 
				}
			}
		}
		
	});
}
public void allowAsAmount(final TextField fieldName){
	
	fieldName.lengthProperty().addListener(new ChangeListener<Number>(){
		 
		@Override
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {              
			 
			 if(newValue.intValue() > oldValue.intValue()){
				char ch = fieldName.getText().charAt(oldValue.intValue());
				//System.out.println("Length:"+ oldValue+"  "+ newValue +" "+ch);                   
	 
				//Check if the new character is the number or other's
				if(fieldName.getText().indexOf('.')!=fieldName.getText().lastIndexOf('.'))
                {
					fieldName.setText(fieldName.getText().substring(0,fieldName.getText().length()-1)); 
                }
				else if(fieldName.getText().contains("."))
				{
					if(fieldName.getText().length()-fieldName.getText().lastIndexOf('.')>3)
	                {
						fieldName.setText(fieldName.getText().substring(0,fieldName.getText().length()-1)); 
	                }
				}
						
				
				else if(!((ch >= '0' && ch <= '9' )||(ch=='.')))
				{       
					
	                	
	                
	                	 fieldName.setText(fieldName.getText().substring(0,fieldName.getText().length()-1)); 
	                 
					//if it's not number then just setText to previous one
	                
				}
                
				
			}
		}
		
	});
}



}
