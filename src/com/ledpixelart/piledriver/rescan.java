package com.ledpixelart.piledriver;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import ioio.lib.api.exception.ConnectionLostException;
import ioio.lib.util.BaseIOIOLooper;
import ioio.lib.util.IOIOLooper;
import ioio.lib.util.android.IOIOActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.provider.MediaStore.Images;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.graphics.Matrix;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.SensorManager;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient; 


public class rescan extends Activity  {

    //look into internet loads
	//make an ledalbum directory, copy some files in there
   	private final String tag = "LEDAlbum";	
	private RescanTimer rescanTimer; 
	private boolean scanAllPics;
	private int countdownCounter;
	private static final int countdownDuration = 30;
	private TextView countdown_;
       

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //force only portrait mode
        setContentView(R.layout.rescan);         
        countdown_ = (TextView)findViewById(R.id.countdown); 
        
        //launch the media scanner here
        sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED,Uri.parse("file//" + Environment.getExternalStorageDirectory()))); //this triggers a media scan on the whole sd card
        
        countdownCounter = countdownDuration -1; //reset the counter
               
        rescanTimer = new RescanTimer(countdownDuration*1000,1000); //pop up a message if it's not connected by this timer
 		rescanTimer.start(); //this timer will pop up a message box if the device is not found
 		 		
      
    }
    
       
          
    public class RescanTimer extends CountDownTimer
	{

		public RescanTimer(long startTime, long interval)
			{
				super(startTime, interval);
			}

		@Override
		public void onFinish()
			{
			
			finish();
				
			}

		@Override
		public void onTick(long millisUntilFinished)				{
			//showToastShort(getResources().getString(R.string.oneTimeSetupString) + " " + countdownCounter);
			setCountdown(Integer.toString(countdownCounter));
			countdownCounter--;
		}
	}
    
        
       
    private void showToast(final String msg) {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Toast toast = Toast.makeText(rescan.this, msg, Toast.LENGTH_LONG);
                toast.show();
			}
		});
	}  
    
    private void setCountdown(final String str) {
		runOnUiThread(new Runnable() {
			public void run() {
				countdown_.setText(str);
			}
		});
	}
    
    private void showToastShort(final String msg) {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Toast toast = Toast.makeText(rescan.this, msg, Toast.LENGTH_SHORT);
                toast.show();
			}
		});
	}  

    /**
     * Adapter for our image files.
     */
}

