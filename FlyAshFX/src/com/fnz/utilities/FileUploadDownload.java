package com.fnz.utilities;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.fnz.UI.MainWindow;
 
/**
 * This class is used to upload a file to a FTP server.
 *
 * @author Pragati
 */

	

public class FileUploadDownload
{
 
   /**
    * Upload a file to a FTP server. A FTP URL is generated with the
    * following syntax:
    * ftp://user:password@host:port/filePath;type=i.
    *
    * @param ftpServer , FTP server address (optional port ':portNumber').
    * @param user , Optional user name to login.
    * @param password , Optional password for user.
    * @param fileName , Destination file name on FTP server (with optional
    *            preceding relative path, e.g. "myDir/myFile.txt").
    * @param source , Source file to upload.
 * @throws IOException 
    * @throws MalformedURLException, IOException on error.
    */
	
   public static String upload( String ftpServer, String user, String password,
         String fileName, File source ) throws MalformedURLException,
         IOException
   {
      if (ftpServer != null || fileName != null || source != null)
      {
         StringBuffer sb = new StringBuffer( "ftp://" );
         // check for authentication else assume its anonymous access.
         if (user != null || password != null)
         {
            sb.append( user );
            sb.append( ':' );
            sb.append( password );
            sb.append( '@' );
         }
         sb.append( ftpServer );
         sb.append( '/' );
         sb.append( fileName );
         /*
          * type ==&gt; a=ASCII mode, i=image (binary) mode, d= file directory
          * listing
          */
         sb.append( ";type=i" );
 
         BufferedInputStream bis = null;
         BufferedOutputStream bos = null;
         try
         {
            URL url = new URL( sb.toString() );
            URLConnection urlc = url.openConnection();
 
            bos = new BufferedOutputStream( urlc.getOutputStream() );
            bis = new BufferedInputStream( new FileInputStream( source ) );
 
            int i;
            // read byte by byte until end of stream
            while ((i = bis.read()) != -1)
            {
               bos.write( i );
            }
          }
         catch(Exception e)
         {
        	 return "Error! \nDatabase NOT found";
         }
         finally
         {
            if (bis != null)
               try
               {
                  bis.close();
               }
               catch (IOException ioe)
               {
                  ioe.printStackTrace();
               }
            if (bos != null)
               try
               {
                  bos.close();
               }
               catch (IOException ioe)
               {
                  ioe.printStackTrace();
               }
         }
         return "Upload Successful";
      }
      else
      {
        return "Some problem occured";
      }
   }
 
   /**
    * Download a file from a FTP server. A FTP URL is generated with the
    * following syntax:
    * ftp://user:password@host:port/filePath;type=i.
    *
    * @param ftpServer , FTP server address (optional port ':portNumber').
    * @param user , Optional user name to login.
    * @param password , Optional password for user.
    * @param fileName , Name of file to download (with optional preceeding
    *            relative path, e.g. one/two/three.txt).
    * @param destination , Destination file to save.
    * @throws MalformedURLException, IOException on error.
    */
   public String download( String ftpServer, String user, String password,
         String fileName, File destination ) throws MalformedURLException,
         IOException
   {
	   boolean flag=true;
      if (ftpServer != null || fileName != null || destination != null)
      {
         StringBuffer sb = new StringBuffer( "ftp://" );
         // check for authentication else assume its anonymous access.
         if (user != null || password != null)
         {
            sb.append( user );
            sb.append( ':' );
            sb.append( password );
            sb.append( '@' );
         }
         sb.append( ftpServer );
         sb.append( '/' );
         sb.append( fileName );
         /*
          * type ==&gt; a=ASCII mode, i=image (binary) mode, d= file directory
          * listing
          */
         sb.append( ";type=i" );
         BufferedInputStream bis = null;
         BufferedOutputStream bos = null;
         try
         {
            URL url = new URL( sb.toString() );
            URLConnection urlc = url.openConnection();
           
            bis = new BufferedInputStream( urlc.getInputStream() );
            bos = new BufferedOutputStream( new FileOutputStream(
                  destination.getName() ) );
 
            int i;
            while ((i = bis.read()) != -1)
            {
               bos.write( i );
            }
            	
            	
         }
         catch(Exception e)
         {
        	 return "Error! \nNo Database found";
         }
         finally
         {
            if (bis != null)
            {
                  bis.close();
            }
            if (bos != null)
            {
                  bos.close();
            }
         }
         return "Download Successful";
      }
      else
      {
         return "Input not available";
      }
   }
   
   
   
   /************************* Check File Exists *****************************/
   public boolean exists( String ftpServer, String user, String password,
	         String fileName) throws MalformedURLException,
	         IOException
	   {
	      if (ftpServer != null || fileName != null )
	      {
	         StringBuffer sb = new StringBuffer( "ftp://" );
	         // check for authentication else assume its anonymous access.
	         if (user != null || password != null)
	         {
	            sb.append( user );
	            sb.append( ':' );
	            sb.append( password );
	            sb.append( '@' );
	         }
	         sb.append( ftpServer );
	         sb.append( '/' );
	         sb.append( fileName );
	         /*
	          * type ==&gt; a=ASCII mode, i=image (binary) mode, d= file directory
	          * listing
	          */
	         sb.append( ";type=i" );
	         BufferedInputStream bis = null;
	         BufferedOutputStream bos = null;
	        
	            URL url = new URL( sb.toString() );
	            URLConnection urlc = url.openConnection();
	            bis = new BufferedInputStream( urlc.getInputStream() );
	            //System.out.println(urlc);	
	            System.out.println(bis);
	            return true;
	   }
	      return false;
	   }
	            
}
