
package com.ledpixelart.pixel.hardware;

import ioio.lib.api.AnalogInput;
import ioio.lib.api.RgbLedMatrix;
import ioio.lib.api.exception.ConnectionLostException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

import com.ledpixelart.piledriver.MainActivity;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;


/**
 * @author rmarquez
 */
public class Pixel 
{

    public static RgbLedMatrix matrix;
    
    public static RgbLedMatrix.Matrix KIND;
    
    //public final RgbLedMatrix.Matrix KIND;
    
    public AnalogInput analogInput1;
    
    protected static byte[] BitmapBytes;
    
    protected InputStream BitmapInputStream;
    
    protected static short[] frame_;
    
    private static Bitmap canvasBitmap;
    
    private static Bitmap originalImage;
    
    static int resizedFlag = 0;
    
    private static Bitmap resizedBitmap;
    
	private static android.graphics.Matrix matrix2;
	
	private float fps;
	    
	private static String decodedDirPathExternal;
	
	public static int GIFSlideShowFrameCounter = 0;
    
    public Pixel(RgbLedMatrix matrix, RgbLedMatrix.Matrix KIND)
    {
    	this.matrix = matrix;
    	
		this.KIND = KIND;
		
		BitmapBytes = new byte[KIND.width * KIND.height * 2]; //512 * 2 = 1024 or 1024 * 2 = 2048
		
		frame_ = new short[KIND.width * KIND.height];
    }
    
  //*** Al added, this code is to support the SD card and local animations
    public void interactiveMode() {  //puts PIXEL into interactive mode
    	try {
			matrix.interactive();
		} catch (ConnectionLostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void writeMode(float frameDelay) {  //puts PIXEL into write mode
    	try {
    		 matrix.writeFile(frameDelay); //put PIXEL in write mode
		} catch (ConnectionLostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void playLocalMode() {  //tells PIXEL to play the local files
    	try {
    		matrix.playFile();
		} catch (ConnectionLostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public boolean GIFNeedsDecoding(String imagePath, String decodedDirPath, int currentResolution) {
    	
    	/*In this method we will first check if the decoded files are there
    	if they are present, then let's read them and make sure the resolution in the decoded file matches the current matrix
    	if no match, then we need to re-encode
    	if the files are not there, then we need to re-encode anyway*/
    	
    	/*GIFName will be tree
    	GIF Path will be c:\animations\tree.gif
    	decdoed path will be c:\animations\tree.gif\decoded\tree.rgb565 and tree.txt
    	*/
    	
    	//imagePath = (String) parent.getItemAtPosition(position);
    	//originalImagePath = (String) parent.getItemAtPosition(position);
        String gifName = imagePath;
        //here we need to get the file name to see if the file has already been decoded
        //file name will be in a format like this sdcard/pixel/pixerinteractive/rain.gif , we want to extra just rain
        String delims = "[/]";
        String[] aFileName = gifName.split(delims);
        int aFileNameLength = aFileName.length;
        gifName = aFileName[aFileNameLength-1];
        String fileType = aFileName[aFileNameLength-2];  //can be gif, png, userpng, usergif, png64, or gif64
        String delims2 = "[.]";
        String[] aFileName2 = gifName.split(delims2);
        int aFileNameLength2 = aFileName2.length;
        gifName = aFileName2[0];	//now we have just the short name with no extension
      //gifName = FilenameUtils.removeExtension(gifName); //with no extension
        
        //**** now let's handle the thumbnails
        String filenameArray[] = imagePath.split("\\.");
        String extension = filenameArray[filenameArray.length-1]; //.png
    	
    	System.out.println("PIXEL LED panel resolution is: " + currentResolution);  //decoded path is sdcard/pixel/gif/decoded
    	
    	String decodedGIFPathTXT = decodedDirPath + "/" + gifName + ".txt";   //sdcard/pixel/gif/tree.gif is image path
    	String decodedGIFPath565 = decodedDirPath + "/" + gifName + ".rgb565"; //but decoded path is sdcard/pixel/gif/decoded/tree.rgb565
    	
    	File filetxt = new File(decodedGIFPathTXT);
    	File file565 = new File(decodedGIFPath565);
    	
    	if (filetxt.exists() && file565.exists()) { //need to ensure both files are there
    		   
    			if (getDecodedresolution(decodedGIFPathTXT) == currentResolution) {  //does the resolution in the encoded txt file match the current matrix
    				
    				return false;
    			}
    			else {
    				return true;
    			}
    	}
    	else {
    		return true;
    	}
    }
        
       
public int getDecodedresolution(String decodedGIFPathTXT) {  //need to return the meta data
    	
	   // gifName = FilenameUtils.removeExtension(gifName); //with no extension
	    //String framestring = "animations/decoded/" + animation_name + ".rgb565";
	   // String gifNamePath = gifName + ".txt";
	   // String gifNamePath = currentDir + "/decoded/" + gifName + ".txt"; 
    	//File filemeta = new File(decodedGIFPathTXT);
    	
    	FileInputStream decodedFile = null; //fix this
    	try {
			decodedFile = new FileInputStream(decodedGIFPathTXT);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	String line = "";

		    try 
		    {
				InputStreamReader streamReader = new InputStreamReader(decodedFile);
				BufferedReader br = new BufferedReader(streamReader);
				line = br.readLine();
		    } 
		    catch (IOException e) 
		    {
			    //You'll need to add proper error handling here
		    }

		    String fileAttribs = line.toString();  //now convert to a string	 
		    String fdelim = "[,]"; //now parse this string considering the comma split  ie, 32,60,32  where last 32 is the resolution
		    String[] fileAttribs2 = fileAttribs.split(fdelim);
		    int resolution = Integer.parseInt(fileAttribs2[2].trim());	
		  
		   return (resolution);
	}
    
    
    public float getDecodedfps(String decodedGIFPathTXT) {  //need to return the meta data
        	
        	//gifName = FilenameUtils.removeExtension(gifName); //with no extension, ex. tree instead of tree.gif
        	//String gifNamePath = currentDir + "/decoded/" + gifName + ".txt"; 
        	//File filemeta = new File(gifNamePath);
        	
        	FileInputStream decodedFile = null; //fix this
        	try {
    			decodedFile = new FileInputStream(decodedGIFPathTXT);
    		} catch (FileNotFoundException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
        	
        	String line = "";

    		    try 
    		    {
    				InputStreamReader streamReader = new InputStreamReader(decodedFile);
    				BufferedReader br = new BufferedReader(streamReader);
    				line = br.readLine();
    		    } 
    		    catch (IOException e) 
    		    {
    			    //You'll need to add proper error handling here
    		    }

    		    String fileAttribs = line.toString();  //now convert to a string	 
    		    String fdelim = "[,]"; //now parse this string considering the comma split  ie, 32,60
    		    String[] fileAttribs2 = fileAttribs.split(fdelim);
    		    int selectedFileDelay = Integer.parseInt(fileAttribs2[1].trim());	
    		    
    		    if (selectedFileDelay != 0) {  //then we're doing the FPS override which the user selected from settings
    	    	    fps = 1000.f / selectedFileDelay;
    			} else { 
    	    		fps = 0;
    	    	}

    		   return (fps);
    	}
        
        public int getDecodednumFrames(String decodedGIFPathTXT) {  //need to return the meta data
        	
        	//gifName = FilenameUtils.removeExtension(gifName); //with no extension
        	//String framestring = "animations/decoded/" + animation_name + ".rgb565";
        	//String gifNamePath = gifName + ".txt";
        	//String gifNamePath = currentDir + "/decoded/" + gifName + ".txt"; 
        	//File filemeta = new File(gifNamePath);    	
        	
        	
        	FileInputStream decodedFile = null; //fix this
        	try {
    			decodedFile = new FileInputStream(decodedGIFPathTXT);
    		} catch (FileNotFoundException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
        	
        	String line = "";

    		    try 
    		    {
    				InputStreamReader streamReader = new InputStreamReader(decodedFile);
    				BufferedReader br = new BufferedReader(streamReader);
    				line = br.readLine();
    		    } 
    		    catch (IOException e) 
    		    {
    			    //You'll need to add proper error handling here
    		    }

    		    String fileAttribs = line.toString();  //now convert to a string	 
    		    String fdelim = "[,]"; //now parse this string considering the comma split  ie, 32,60
    		    String[] fileAttribs2 = fileAttribs.split(fdelim);
    		    int selectedFileTotalFrames = Integer.parseInt(fileAttribs2[0].trim());
    		  
    		   return (selectedFileTotalFrames);
    	}
        
    
        
        public int getDecodedframeDelay(String decodedGIFPathTXT) {  //need to return the meta data
        	
        	
        	//gifName = FilenameUtils.removeExtension(gifName); //with no extension
        	//String gifNamePath = currentDir + "/decoded/" + gifName + ".txt"; 
        	
        	//File filemeta = new File(gifNamePath);
        	
        	FileInputStream decodedFile = null; //fix this
        	try {
    			decodedFile = new FileInputStream(decodedGIFPathTXT);
    		} catch (FileNotFoundException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
        	
        	String line = "";

    		    try 
    		    {
    				InputStreamReader streamReader = new InputStreamReader(decodedFile);
    				BufferedReader br = new BufferedReader(streamReader);
    				line = br.readLine();
    		    } 
    		    catch (IOException e) 
    		    {
    			    //You'll need to add proper error handling here
    		    }

    		    String fileAttribs = line.toString();  //now convert to a string	 
    		    String fdelim = "[,]"; //now parse this string considering the comma split  ie, 32,60
    		    String[] fileAttribs2 = fileAttribs.split(fdelim);
    		    int selectedFileDelay = Integer.parseInt(fileAttribs2[1].trim());

    		   return (selectedFileDelay);
    	}
    
    
        public void SendPixelDecodedFrame(String decodedGIFPath565, int x, int selectedFileTotalFrames, int selectedFileResolution, int frameWidth, int frameHeight) {
   		 
        	BitmapBytes = new byte[frameWidth * frameHeight * 2]; //512 * 2 = 1024 or 1024 * 2 = 2048
    		frame_ = new short[frameWidth * frameHeight];
        	
        	//gifName = FilenameUtils.removeExtension(gifName); //with no extension
        	//String gifNamePath = currentDir + "/decoded/" + gifName + ".rgb565";  //  ex. c:\animations\decoded\tree.rgb565
        	
        	File file = new File(decodedGIFPath565);
    			if (file.exists()) {
    				
    			/*Because the decoded gif is one big .rgb565 file that contains all the frames, we need
    			to use the raf pointer and extract just a single frame at a time and then we'll move the 
    			pointer to get the next frame until we reach the end of the file*/
    				
         		RandomAccessFile raf = null;
    			
    			//let's setup the seeker object and set it at the beginning of the rgb565 file
    			try {
    				raf = new RandomAccessFile(file, "r");
    				try {
    					raf.seek(0);
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    				
    			} catch (FileNotFoundException e2) {
    				// TODO Auto-generated catch block
    				e2.printStackTrace();
    			}  // "r" means open the file for reading
    			
    			int frame_length;
    			
    			 switch (selectedFileResolution) {
    	            case 16: frame_length = 1024;
    	                     break;
    	            case 32: frame_length = 2048;
    	                     break;
    	            case 64: frame_length = 4096;
    	                     break;
    	            case 128: frame_length = 8192;
                    		break;
    	            default: frame_length = 2048;
    	                     break;
    	          }
    			
    			//now let's see forward to a part of the file
    			try {
    				raf.seek(x*frame_length);
    			} catch (IOException e2) {
    				// TODO Auto-generated catch block
    				e2.printStackTrace();
    			} 
    			
       			 
       			if (frame_length > Integer.MAX_VALUE) {
       			    try {
    					throw new IOException("The file is too big");
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
       			}
       			 
       			// Create the byte array to hold the data
       			BitmapBytes = new byte[(int)frame_length];
       			
       			// Read in the bytes
       			int offset = 0;
       			int numRead = 0;
       			try {
    				while (offset < BitmapBytes.length && (numRead=raf.read(BitmapBytes, offset, BitmapBytes.length-offset)) >= 0) {
    				    offset += numRead;
    				}
    			} catch (IOException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
       			 
       			// Ensure all the bytes have been read in
       			if (offset < BitmapBytes.length) {
       			    try {
    					throw new IOException("The file was not completely read: "+file.getName());
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
       			}
       			 
       			// Close the input stream, all file contents are in the bytes variable
       			try {
       				raf.close();
    			} catch (IOException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}	
       			
       			//now that we have the byte array loaded, load it into the frame short array
       			
       			int y = 0;
         		for (int i = 0; i < frame_.length; i++) {
         			frame_[i] = (short) (((short) BitmapBytes[y] & 0xFF) | (((short) BitmapBytes[y + 1] & 0xFF) << 8));
         			y = y + 2;
         		}
         		
    		   	try {
    		   		matrix.frame(frame_);
    				
    			} catch (ConnectionLostException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		  // 	x++;  //this al commented out for this class as I don't think we need it as i is being incremental in the place this class is getting called
    			}
    			
    			else {
    				//showToast("We have a problem, couldn't find the decoded file");
    				System.err.println("An error occured while trying to load " + decodedGIFPath565 + ".");
    	    	   // e.printStackTrace();
    			}
    	}
        
        
        public void decodeGIF(String gifNamePath, int currentResolution, int pixelMatrix_width, int pixelMatrix_height) {  //pass the matrix type
    		
              
        	  //from the gifpath, we need to derive just the gif name with no extension and the decoded path for .txt and rgb565
        		
        	 // String gifName = imagePath;
              //here we need to get the file name to see if the file has already been decoded
              //file name will be in a format like this sdcard/pixel/pixerinteractive/rain.gif , we want to extra just rain
              String delims = "[/]";
              String[] aFileName = gifNamePath.split(delims);
              int aFileNameLength = aFileName.length;
              String gifName = aFileName[aFileNameLength-1];  
              
              String path = "";                               //sd card / pixel / gif  / gifname.gif
              for (int y = 0; y < aFileNameLength-1 ; y++) {
            	  if ( y==0 ) {
            		  path = aFileName[y];   // sd card
            	  }
            	  else {
            		  path = path + "/" + aFileName[y];       // sd card/pixel/gif
            	  }
              }
              decodedDirPathExternal = path + "/decoded" ;   //  sdcard/pixel/gif/decoded
              
              String fileType = aFileName[aFileNameLength-2];  //can be gif, png, userpng, usergif, png64, or gif64
              String delims2 = "[.]";
              String[] aFileName2 = gifName.split(delims2);
              int aFileNameLength2 = aFileName2.length;
              gifName = aFileName2[0];	//now we have just the short name with no extension
        	
        	//we're going to decode a native GIF into our RGB565 format
    	    //we'll need to know the resolution of the currently selected matrix type: 16x32, 32x32, 32x64, or 64x64
    		//and then we will receive the gif accordingly as we decode
    		//we also need to get the original width and height of the gif which is easily done from the gif decoder class
    		//gifName = FilenameUtils.removeExtension(gifName); //with no extension
    		//String gifNamePath = currentDir + "/" + gifName + ".gif";  //   ex. c:\animation\tree.gif
    		
    		File file = new File(gifNamePath);
    		FileInputStream gifInputStream = null;
			try {
				gifInputStream = new FileInputStream(file);
				//System.out.println("Total file size to read (in bytes) : "
					//	+ fis.available());
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
    		
    		if (file.exists()) {
    			
    			  //since we are decoding, we need to first make sure the .rgb565 and .txt decoded file is not there and delete if so.
    			  String gifNameTXTPath = decodedDirPathExternal + "/" + gifName + ".txt";  //   ex. c:\animation\decoded\tree.txtString gifNameTXTPath = decodedDirPathExternal + gifName + ".txt";  //   ex. c:\animation\decoded\tree.txt
    			  String gifName565Path = decodedDirPathExternal + "/" + gifName + ".rgb565";  //   ex. c:\animation\decoded\tree.rgb565
    			  
    			  File fileTXT = new File(gifNameTXTPath);
    			  File file565 = new File(gifName565Path);
    			  
    			  if (file565.exists()) file565.delete();
    			  if (fileTXT.exists()) file565.delete();
    			  //*******************************************************************************************
    			
    			  GifDecoder d = new GifDecoder();
    	          d.read(gifInputStream);
    	          int numFrames = d.getFrameCount(); 
    	          int frameDelay = d.getDelay(1); //even though gifs have a frame delay for each frmae, pixel doesn't support this so we'll take the frame rate of the second frame and use this for the whole animation. We take the second frame because often times the frame delay of the first frame in a gif is much longer than the rest of the frames
    	          
    	          Bitmap gifBitmap = d.getBitmap();
    	        //  Dimension frameSize = d.getFrameSize();
    	          int width_original = gifBitmap.getWidth();
    	          int height_original = gifBitmap.getHeight();
    	         
    	          System.out.println("frame count: " + numFrames);
    	          System.out.println("frame delay: " + frameDelay);
    	          System.out.println("frame height: " + height_original);
    	          System.out.println("frame width: " + width_original);
    	          	          
    	          for (int i = 0; i < numFrames; i++) { //loop through all the frames
    	             Bitmap rotatedFrame = d.getFrame(i);  //need to validate we still need this?
    	               	             
    	             if (width_original != KIND.width || height_original != KIND.height) {
    	    			 resizedFlag = 1;
    	    			 //the iamge is not the right dimensions, so we need to re-size
    	    			 float scaleWidth = ((float) KIND.width) / width_original;
    	     		 	 float scaleHeight = ((float) KIND.height) / height_original;
    	     		 	 
    	    	   		 // create matrix for the manipulation
    	    	   		 matrix2 = new Matrix();
    	    	   		 // resize the bit map
    	    	   		 matrix2.postScale(scaleWidth, scaleHeight);
    	    	   		 resizedBitmap = Bitmap.createBitmap(originalImage, 0, 0, width_original, height_original, matrix2, false); //false means don't anti-alias which is what we want when re-sizing for super pixel 64x64
    	    	   		 canvasBitmap = Bitmap.createBitmap(KIND.width, KIND.height, Config.RGB_565); 
    	    	   		 Canvas canvas = new Canvas(canvasBitmap);
    	    	   		 canvas.drawRGB(0,0,0); //a black background
    	    	   	   	 canvas.drawBitmap(resizedBitmap, 0, 0, null);
    	    	   		 ByteBuffer buffer = ByteBuffer.allocate(KIND.width * KIND.height *2); //Create a new buffer
    	    	   		 canvasBitmap.copyPixelsToBuffer(buffer); //copy the bitmap 565 to the buffer		
    	    	   		 BitmapBytes = buffer.array(); //copy the buffer into the type array
    	    		 }
    	    		 else {
    	    			// then the image is already the right dimensions, no need to waste resources resizing
    	    			 resizedFlag = 0;
    	    			 canvasBitmap = Bitmap.createBitmap(KIND.width, KIND.height, Config.RGB_565); 
    	    	   		 Canvas canvas = new Canvas(canvasBitmap);
    	    	   	   	 canvas.drawBitmap(originalImage, 0, 0, null);
    	    	   		 ByteBuffer buffer = ByteBuffer.allocate(KIND.width * KIND.height *2); //Create a new buffer
    	    	   		 canvasBitmap.copyPixelsToBuffer(buffer); //copy the bitmap 565 to the buffer		
    	    	   		 BitmapBytes = buffer.array(); //copy the buffer into the type array
    	    		 }
    			   		    
    			   		 File decodeddir = new File(decodedDirPathExternal); //this could be gif, gif64, or usergif
    					    if(decodeddir.exists() == false)
    			             {
    					    	decodeddir.mkdirs();
    			             }
    					
    				   			try {
    							
    								appendWrite(BitmapBytes, decodedDirPathExternal + "/" + gifName + ".rgb565"); //this writes one big file instead of individual ones
    								
    								
    							} catch (IOException e1) {
    								// TODO Auto-generated catch block
    								//Log.e("PixelAnimate", "Had a problem writing the original unified animation rgb565 file");
    								e1.printStackTrace();
    							}
    				  
    	             
    	          } //end for, we are done with the loop so let's now write the file
    	          
    	           //********** now let's write the meta-data text file
    		   		
    		   		if (frameDelay == 0 || numFrames == 1) {  //we can't have a 0 frame delay so if so, let's add a 100ms delay by default
    		   			frameDelay = 100;
    		   		}
    		   		
    		   		String filetag = String.valueOf(numFrames) + "," + String.valueOf(frameDelay) + "," + String.valueOf(currentResolution); //current resolution may need to change to led panel type
    		   				
    	     		   File myFile = new File(decodedDirPathExternal + "/" + gifName + ".txt");  				       
    	     		   try {
    					myFile.createNewFile();
    					FileOutputStream fOut = null;
    					fOut = new FileOutputStream(myFile);
    			        OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
    					myOutWriter.append(filetag); 
    					myOutWriter.close();
    					fOut.close();	
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					System.out.println("ERROR, could not write " + gifName);
    					e.printStackTrace();
    				}
    		}
    		else {
    			System.out.println("ERROR  Could not write " + decodedDirPathExternal + "/" + gifName + ".txt");
    		}
    			
    	}  
              
        public static void decodeGIFSlideShow(String gifNamePath, int currentResolution) {  //pass the matrix type
    		
        	
        	
        	//this is for the slideshow, we have already taken care of the txt file, we only worry about the rgb565 here
            
      	  //from the gifpath, we need to derive just the gif name with no extension and the decoded path for .txt and rgb565
      		
      	    String delims = "[/]";
            String[] aFileName = gifNamePath.split(delims);
            int aFileNameLength = aFileName.length;
            String gifName = aFileName[aFileNameLength-1];  
            
            String path = "";                               //sd card / pixel / gif  / gifname.gif
            for (int y = 0; y < aFileNameLength-1 ; y++) {
          	  if ( y==0 ) {
          		  path = aFileName[y];   // sd card
          	  }
          	  else {
          		  path = path + "/" + aFileName[y];       // sd card/pixel/favgif
          	  }
            }
            //decodedDirPathExternal = path + "/decoded" ;   //  sdcard/pixel/favgif/decoded
            
            String fileType = aFileName[aFileNameLength-2];  //can be gif, png, userpng, usergif, png64, or gif64
            String delims2 = "[.]";
            String[] aFileName2 = gifName.split(delims2);
            int aFileNameLength2 = aFileName2.length;
            gifName = aFileName2[0];	//now we have just the short name with no extension
      	
      	//we're going to decode a native GIF into our RGB565 format
  	    //we'll need to know the resolution of the currently selected matrix type: 16x32, 32x32, 32x64, or 64x64
  		//and then we will receive the gif accordingly as we decode
  		//we also need to get the original width and height of the gif which is easily done from the gif decoder class
  		//gifName = FilenameUtils.removeExtension(gifName); //with no extension
  		//String gifNamePath = currentDir + "/" + gifName + ".gif";  //   ex. c:\animation\tree.gif
  		
  		File file = new File(gifNamePath);
  		FileInputStream gifInputStream = null;
			try {
				gifInputStream = new FileInputStream(file);
				//System.out.println("Total file size to read (in bytes) : "
					//	+ fis.available());
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
  		
  		if (file.exists()) {
  			
  			  //since we are decoding, we need to first make sure the .rgb565 and .txt decoded file is not there and delete if so.
  			  //String gifNameTXTPath = MainActivity.FavGIFPath + "decoded" + "/" + "slideshowgif" + ".txt";  //   ex. c:\animation\decoded\tree.txtString gifNameTXTPath = decodedDirPathExternal + gifName + ".txt";  //   ex. c:\animation\decoded\tree.txt
  			  //String gifName565Path = MainActivity.FavGIFPath + "decoded" + "/" + "slideshowgif" + ".rgb565";  //   ex. c:\animation\decoded\tree.rgb565
  			  
  			  //File fileTXT = new File(gifNameTXTPath);
  			  //File file565 = new File(gifName565Path);
  			  
  			 
  			  //*******************************************************************************************
  			
  			  GifDecoder d = new GifDecoder();
  	          d.read(gifInputStream);
  	          int numFrames = d.getFrameCount(); 
  	          int frameDelay = d.getDelay(1); //even though gifs have a frame delay for each frmae, pixel doesn't support this so we'll take the frame rate of the second frame and use this for the whole animation. We take the second frame because often times the frame delay of the first frame in a gif is much longer than the rest of the frames
  	          
  	          Bitmap gifBitmap = d.getBitmap();
  	        //  Dimension frameSize = d.getFrameSize();
  	          int width_original = gifBitmap.getWidth();
  	          int height_original = gifBitmap.getHeight();
  	         
  	          System.out.println("frame count: " + numFrames);
  	          System.out.println("frame delay: " + frameDelay);
  	          System.out.println("frame height: " + height_original);
  	          System.out.println("frame width: " + width_original);
  	          	          
  	          for (int i = 0; i < numFrames; i++) { //loop through all the frames
  	             Bitmap rotatedFrame = d.getFrame(i);  //need to validate we still need this?
  	               	             
  	             if (width_original != MainActivity.KIND.width || height_original != MainActivity.KIND.height) {
  	    			 resizedFlag = 1;
  	    			 //the iamge is not the right dimensions, so we need to re-size
  	    			 float scaleWidth = ((float) MainActivity.KIND.width) / width_original;
  	     		 	 float scaleHeight = ((float) MainActivity.KIND.height) / height_original;
  	     		 	 
  	    	   		 // create matrix for the manipulation
  	    	   		 matrix2 = new Matrix();
  	    	   		 // resize the bit map
  	    	   		 matrix2.postScale(scaleWidth, scaleHeight);
  	    	   		 resizedBitmap = Bitmap.createBitmap(rotatedFrame, 0, 0, width_original, height_original, matrix2, false); //false means don't anti-alias which is what we want when re-sizing for super pixel 64x64
  	    	   		 canvasBitmap = Bitmap.createBitmap(MainActivity.KIND.width, MainActivity.KIND.height, Config.RGB_565); 
  	    	   		 Canvas canvas = new Canvas(canvasBitmap);
  	    	   		 canvas.drawRGB(0,0,0); //a black background
  	    	   	   	 canvas.drawBitmap(resizedBitmap, 0, 0, null);
  	    	   		 ByteBuffer buffer = ByteBuffer.allocate(MainActivity.KIND.width * MainActivity.KIND.height *2); //Create a new buffer
  	    	   		 canvasBitmap.copyPixelsToBuffer(buffer); //copy the bitmap 565 to the buffer		
  	    	   		 BitmapBytes = buffer.array(); //copy the buffer into the type array
  	    		 }
  	    		 else {
  	    			// then the image is already the right dimensions, no need to waste resources resizing
  	    			 resizedFlag = 0;
  	    			 canvasBitmap = Bitmap.createBitmap(MainActivity.KIND.width, MainActivity.KIND.height, Config.RGB_565); 
  	    	   		 Canvas canvas = new Canvas(canvasBitmap);
  	    	   	   	 canvas.drawBitmap(rotatedFrame, 0, 0, null);
  	    	   		 ByteBuffer buffer = ByteBuffer.allocate(MainActivity.KIND.width * MainActivity.KIND.height *2); //Create a new buffer
  	    	   		 canvasBitmap.copyPixelsToBuffer(buffer); //copy the bitmap 565 to the buffer		
  	    	   		 BitmapBytes = buffer.array(); //copy the buffer into the type array
  	    		 }
  			   		    
  			   		 File decodeddir = new File(MainActivity.FavGIFPath + "decoded"); //this could be gif, gif64, or usergif
  					    if(decodeddir.exists() == false)
  			             {
  					    	decodeddir.mkdirs();
  			             }
  					
  				   			try {
  							
  								appendWrite(BitmapBytes, MainActivity.FavGIFPath + "decoded" + "/" + "slideshowgif" + ".rgb565"); //this writes one big file instead of individual ones
  								GIFSlideShowFrameCounter++; //we need this to count up all the frames in the combined gif slideshow
  								
  							} catch (IOException e1) {
  								// TODO Auto-generated catch block
  								//Log.e("PixelAnimate", "Had a problem writing the original unified animation rgb565 file");
  								e1.printStackTrace();
  							}
  				  
  	             
  	          } //end for, we are done with the loop so let's now write the file
  	          
  	          //normally we would write the frame delay here but we're not going to because we have one master frame delay/txt file in the main program
  		}
  		else {
  			System.out.println("ERROR  Could not write " + decodedDirPathExternal + "/" + "slideshowgif" + ".rgb565");
  		}
  			
  	}
        
        public static void appendWrite(byte[] data, String filename) throws IOException {
    	 FileOutputStream fos = new FileOutputStream(filename, true);  //true means append, false is over-write
         fos.write(data);
         fos.close();
      }    
        
        
    public void writeMessageToPixel(float x, String text, Paint paint, int y) throws ConnectionLostException 
    {  
    	//here we'll take a PNG, BMP, or whatever and convert it to RGB565 via a canvas, also we'll re-size the image if necessary
    	
    	//originalImage = Bitmap.createBitmap(64,  64, Bitmap.Config.RGB_565); //was this originally when hard coded for 32x32
    	originalImage = Bitmap.createBitmap( KIND.width * 2,  KIND.height* 2, Bitmap.Config.RGB_565);  //let's create the image we need
    	Canvas canvas = new Canvas(originalImage);  
    	
    	//float y = 50;
    	
    	
    	//y += (Math.abs(r.height()))/2;
    	//float y = (KIND.height - 32) + 25; //this controls the centering of the scrolling text, was originally 25 but this put the text too high 	  
    	//y = y * KIND.height/32; //TO DO not sure check this later if this is rigth
    	
    	//int paintheight = paint.
    	
    	canvas.drawText(text, x, y, paint);
	    canvasBitmap = Bitmap.createBitmap(KIND.width, KIND.height, Config.RGB_565); 
	    canvas = new Canvas(canvasBitmap);
	   	canvas.drawBitmap(originalImage, 0, 0, null);
	    ByteBuffer buffer = ByteBuffer.allocate(KIND.width * KIND.height *2); //Create a new buffer
	    canvasBitmap.copyPixelsToBuffer(buffer); //copy the bitmap 565 to the buffer		
	   	BitmapBytes = buffer.array(); //copy the buffer into the type array
		 
		loadImage();  
		matrix.frame(frame_);  //write to the matrix   
    }    
    
    public static void loadImage() 
    {
  		int y = 0;
  		for (int i = 0; i < frame_.length; i++) 
  		{
  			frame_[i] = (short) (((short) BitmapBytes[y] & 0xFF) | (((short) BitmapBytes[y + 1] & 0xFF) << 8));
  			y = y + 2;
  		}
  		
  		//we're done with the images so let's recycle them to save memory
	    canvasBitmap.recycle();
	    originalImage.recycle(); 
	    
	    if ( resizedFlag == 1) 
	    {
	    	resizedBitmap.recycle(); //only there if we had to resize an image
	    }	   		
  	}  
    
    public static void writeImagetoMatrix(String originalImagePath, int frameWidth, int frameHeight) throws ConnectionLostException  //not using this one right now    
    {        
	
    	 Bitmap originalImage = decodeSampledBitmapFromFile(originalImagePath, KIND.width,KIND.height);
    	 
    	//here we'll take a PNG, BMP, or whatever and convert it to RGB565 via a canvas, also we'll re-size the image if necessary
    	BitmapBytes = new byte[frameWidth * frameHeight * 2]; 
		frame_ = new short[frameWidth * frameHeight];
    	
    	int width_original = originalImage.getWidth();
        int height_original = originalImage.getHeight();
		 
		 if (width_original != KIND.width || height_original != KIND.height) {
			 resizedFlag = 1;
			 //the iamge is not the right dimensions, so we need to re-size
			 float scaleWidth = ((float) KIND.width) / width_original;
 		 	 float scaleHeight = ((float) KIND.height) / height_original;
 		 	 
	   		 // create matrix for the manipulation
	   		 matrix2 = new Matrix();
	   		 // resize the bit map
	   		 matrix2.postScale(scaleWidth, scaleHeight);
	   		 resizedBitmap = Bitmap.createBitmap(originalImage, 0, 0, width_original, height_original, matrix2, false); //false means don't anti-alias which is what we want when re-sizing for super pixel 64x64
	   		 canvasBitmap = Bitmap.createBitmap(KIND.width, KIND.height, Config.RGB_565); 
	   		 Canvas canvas = new Canvas(canvasBitmap);
	   		 canvas.drawRGB(0,0,0); //a black background
	   	   	 canvas.drawBitmap(resizedBitmap, 0, 0, null);
	   		 ByteBuffer buffer = ByteBuffer.allocate(KIND.width * KIND.height *2); //Create a new buffer
	   		 canvasBitmap.copyPixelsToBuffer(buffer); //copy the bitmap 565 to the buffer		
	   		 BitmapBytes = buffer.array(); //copy the buffer into the type array
		 }
		 else {
			// then the image is already the right dimensions, no need to waste resources resizing
			 resizedFlag = 0;
			 canvasBitmap = Bitmap.createBitmap(KIND.width, KIND.height, Config.RGB_565); 
	   		 Canvas canvas = new Canvas(canvasBitmap);
	   	   	 canvas.drawBitmap(originalImage, 0, 0, null);
	   		 ByteBuffer buffer = ByteBuffer.allocate(KIND.width * KIND.height *2); //Create a new buffer
	   		 canvasBitmap.copyPixelsToBuffer(buffer); //copy the bitmap 565 to the buffer		
	   		 BitmapBytes = buffer.array(); //copy the buffer into the type array
		 }	   		
		 
		loadImage(); 
		
		if(matrix != null)
		{
		    matrix.frame(frame_);
		}
    }
    
    public static String getNameOnly (String filepath) {
    	
    	   String delims = "[/]";
	       String[] aFileName = filepath.split(delims);
	       int aFileNameLength = aFileName.length;
	       String FileNameOnly = aFileName[aFileNameLength-1];
	       String fileType = aFileName[aFileNameLength-2];  //can be gif, png, userpng, usergif, png64, or gif64
	       String delims2 = "[.]";
	       String[] aFileName2 = FileNameOnly.split(delims2);
	       int aFileNameLength2 = aFileName2.length;
	       FileNameOnly = aFileName2[0];	//now we have just the short name with no extension
    	
    	return FileNameOnly;
    	
    }
    
    public static String getPixelDir (String filepath) {
    	
 	   	   String delims = "[/]";
	       String[] aFileName = filepath.split(delims);
	       int aFileNameLength = aFileName.length;
	       String FileNameOnly = aFileName[aFileNameLength-1];
	       String PixelDirName = aFileName[aFileNameLength-2];  //can be gif, png, userpng, usergif, png64, gif64, favgif, or favpng
	       
 	
 	return PixelDirName;
 	
 }
    
   
    
    
    public static String getExtension (String filepath) {
    	
    	String filenameArray[] = filepath.split("\\.");
    	
	    String extension = filenameArray[filenameArray.length-1]; //.png
    	
        return extension;	
    	
    }
    
    public static Bitmap decodeSampledBitmapFromFile(String filePath, 
	        int reqWidth, int reqHeight) {

	    // First decode with inJustDecodeBounds=true to check dimensions
	    final BitmapFactory.Options options = new BitmapFactory.Options();
	    options.inJustDecodeBounds = true;
	    BitmapFactory.decodeFile(filePath, options);

	    // Calculate inSampleSize
	    options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

	    // Decode bitmap with inSampleSize set
	    options.inJustDecodeBounds = false;
	    return BitmapFactory.decodeFile(filePath, options);
	}
    
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
    // Raw height and width of image
    final int height = options.outHeight;
    final int width = options.outWidth;
    int inSampleSize = 1;

    if (height > reqHeight || width > reqWidth) {

        final int halfHeight = height / 2;
        final int halfWidth = width / 2;

        // Calculate the largest inSampleSize value that is a power of 2 and keeps both
        // height and width larger than the requested height and width.
        while ((halfHeight / inSampleSize) > reqHeight
                && (halfWidth / inSampleSize) > reqWidth) {
            inSampleSize *= 2;
        }
    }

    return inSampleSize;
  }
    
    private void loadRGB565PNG() throws ConnectionLostException //not using this one
    {
	int y = 0;
	for (int f = 0; f < frame_.length; f++) 
	{   
	    frame_[f] = (short) (((short) BitmapBytes[y] & 0xFF) | (((short) BitmapBytes[y + 1] & 0xFF) << 8));
	    y = y + 2;
	}

//        matrix = PixelApp.getMatrix();
	if(matrix != null)
	{
	    matrix.frame(frame_);
	}
    }
        
}
