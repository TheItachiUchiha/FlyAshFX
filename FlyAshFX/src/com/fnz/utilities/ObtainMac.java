package com.fnz.utilities;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
 
public class ObtainMac{
 
   public String getMac(){
	StringBuilder sb = null;
	InetAddress ip;
	String MacAdd;
	try {
 
		ip = InetAddress.getLocalHost();
	//	System.out.println("Current IP address : " + ip.getHostAddress());
 
		NetworkInterface network = NetworkInterface.getByInetAddress(ip);
 
		byte[] mac = network.getHardwareAddress();
 
		//System.out.print("Current MAC address : ");
 
		sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) 
		{
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
		}
		
 
	} catch (UnknownHostException e) {
 
		e.printStackTrace();
 
	} catch (SocketException e){
 
		e.printStackTrace();
 
	}
	return sb.toString();
   }
 
}