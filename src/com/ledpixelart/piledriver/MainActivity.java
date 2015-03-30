package com.ledpixelart.piledriver;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.StatFs;
//import android.os.Parcel;
//import android.os.Parcelable;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;

import ioio.lib.api.AnalogInput;
import ioio.lib.api.IOIO.VersionType;
import ioio.lib.api.exception.ConnectionLostException;
import ioio.lib.util.BaseIOIOLooper;
import ioio.lib.util.IOIOLooper;
import ioio.lib.util.android.IOIOActivity;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import alt.android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.provider.MediaStore.Images;
import android.provider.OpenableColumns;
import android.provider.Settings;
//import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Display;
//import android.view.GestureDetector;
//import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
//import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
//import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.graphics.Matrix;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;

import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import com.google.android.vending.expansion.downloader.IDownloaderClient;
import com.ledpixelart.pixel.hardware.Pixel;

import android.view.ContextMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;

import com.android.vending.expansion.zipfile.ZipResourceFile;
import com.android.vending.expansion.zipfile.ZipResourceFile.ZipEntryRO;
import com.google.android.vending.expansion.downloader.Constants;
import com.google.android.vending.expansion.downloader.DownloadProgressInfo;
import com.google.android.vending.expansion.downloader.DownloaderClientMarshaller;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.google.android.vending.expansion.downloader.Helpers;
import com.google.android.vending.expansion.downloader.IDownloaderClient;
import com.google.android.vending.expansion.downloader.IDownloaderService;
import com.google.android.vending.expansion.downloader.IStub;

//import android.widget.PopupMenu.OnMenuItemClickListener; //decided not to use this because does not work on Android Gingerbread
//import com.ledpixelart.piledriver.AsyncTaskFavoriteCopyGIFs;


/*TO DO
add a preference to choose led panel automatically, set default to on but the user can override
add art and default view for pixel 16 - DONE
auto set the led panel type based on firmeware / bootloader type - DONE
add message for adafruit panels not to show up for old board or better yet hide adafruit panels if not the right one - DONE
more columns for gif images for smaller res screens - DONE
auto select logic

PIXEL V2
Bootloader ID: IOIO0401
Hardware ID: PIXL0020
Firmware version: PIXL0008
Library version: PIXL0020

PIXEL V2.5
Bootloader ID: PIXL0025
Hardware ID: PIXL0025
Firmware version: 
Library Version: PIXL0025

0020 means the board can only support seeed panels
0025 means the board can support both seeed and adafruit panels
hardware id and bootloader id come from the firmware so we'll leave that common for the v2.5 family
we'll use the firmware to auto-detect the LED panel

In the firmware code, the 4 first digits will be PIXL
the fifth digital will be below which we'll use the auto-detect the panel
and digits 6,7, and 8 will be for the firmware version
ex. PIXLP009, PIXLQ009

PIXEL V2 supported panels
I: 32x16 adafruit
P: 32x32 seeed
S: 64x64 seeed
K: 32x32 seeed kiosk no writing
V: 64x64 seeed kiosk no writing

PIXEL V2.5 additional supported panels
Q: 32x32 adafruit d pin
C: 32x32 adafruit color swap
R: 64x32 adafruit d pin
T: 64x64 adafruit
X: 64x64 adafruit kiosk
Y: 32x32 adafruit d pin kiosk

L: 32x16 low power and 32x16
M: 32x32 low power and Seeed 32x32
N: 32x32 low power and Adafruit 32x32 D-Pin

Possible Hardware IDs: IOIO30 for PIXEL V2, PIXL16 for 16x32, PIXL32 for d-panel 32x32, PIXEL64 for d-panel super pixel
So auto-detect if one of these BUT let the user turn off auto-detection in the event another panel is needed
but don't auto-detect on PIXEL V2 because this would screw up super pixel users
 

*/


@SuppressLint("NewApi")
public class MainActivity extends IOIOActivity implements OnItemClickListener, OnItemLongClickListener, IDownloaderClient  {

	private static GifView gifView;
	static ioio.lib.api.RgbLedMatrix matrix_;
	public static ioio.lib.api.RgbLedMatrix.Matrix KIND = ioio.lib.api.RgbLedMatrix.Matrix.SEEEDSTUDIO_32x32; //v2;  //have to do it this way because there is a matrix library conflict
	private static android.graphics.Matrix matrix2;
    private static final String TAG = "PixelAnimations";	
	private static short[] frame_;
  	public static final Bitmap.Config FAST_BITMAP_CONFIG = Bitmap.Config.RGB_565;
  	public static byte[] BitmapBytes;
  	private static InputStream BitmapInputStream;
  	private static Bitmap canvasBitmap;
  	private static Bitmap IOIOBitmap;
  	private static Bitmap originalImage;
  	private static int width_original;
  	private static int height_original; 	  
  	private static float scaleWidth; 
  	private static float scaleHeight; 	  	
  	private static Bitmap resizedBitmap;  	
  	private static boolean deviceFound = false;
  	private static String extension_;
  	
  	private SharedPreferences prefs;
  	
	private String OKText;
	private Resources resources;
	private String app_ver;	
	private static  int matrix_model;
	private final String tag = "";	
	private final String LOG_TAG = "PixelAnimations";
	public static String imagePath;
	private static int resizedFlag = 0;
	
	private ConnectTimer connectTimer; 	
    private static DecodedTimer decodedtimer; 
	private Canvas canvas;
	private static Canvas canvasIOIO;
	
	private static String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
    private static String basepath = extStorageDirectory;
   
    public static String decodedDirPath =  Environment.getExternalStorageDirectory() + "/pixel/gif/decoded"; 
    
    public static String GIFPath =  Environment.getExternalStorageDirectory() + "/pixel/gif/"; //put the pngs (for display purposes) and the gifs together in this same dir, code should take the png if it exists, otherwise take the gif
    public static String PNGPath =  Environment.getExternalStorageDirectory() + "/pixel/png/"; //static pngs
    public static String PNG64Path =  Environment.getExternalStorageDirectory() + "/pixel/png64/"; //static pngs 64x64
    public static String GIF64Path =  Environment.getExternalStorageDirectory() + "/pixel/gif64/";  //gifs 64x64, there will be a decoded directory here
    public static String PNG16Path =  Environment.getExternalStorageDirectory() + "/pixel/png16/"; //static pngs 32x16
    public static String GIF16Path =  Environment.getExternalStorageDirectory() + "/pixel/gif16/";  //gifs 32x16, there will be a decoded directory here
    public static String userPNGPath =  Environment.getExternalStorageDirectory() + "/pixel/userpng/"; //user supplied pngs
    public static String userGIFPath =  Environment.getExternalStorageDirectory() + "/pixel/usergif/";  //user supplied gifs, there will be a decoded directory here
    public static String FavPNGPath =  Environment.getExternalStorageDirectory() + "/pixel/favpng/"; //user supplied pngs
    public static String FavGIFPath =  Environment.getExternalStorageDirectory() + "/pixel/favgif/";  //user supplied gifs, there will be a decoded directory here
   
    private static Context context;
    private Context frameContext;
	
	///********** Timers
	private boolean noSleep = false;	
	private int countdownCounter;
	private static final int countdownDuration = 30;
	private static final int REQUEST_CODE_CHOOSE_PICTURE_FROM_GALLERY = 22;
	private static final int WENT_TO_PREFERENCES = 1;
	private static final int REQUEST_PAIR_DEVICE = 10;
	private static final int REQUEST_IMAGE_CAPTURE = 40;
	private Display display;
	private Cursor cursor;
	private int size;  //the number of pictures
	private ProgressDialog pDialog = null;
	private int columnIndex; 
	private boolean debug_;
	private static int appAlreadyStarted = 0;
	private int FPSOverride_ = 0;
	public static float fps = 0;
	private static int x = 0;
	private static int downloadCounter = 0;
	private static String selectedFileName;
	private static int selectedFileTotalFrames;
	private static int selectedFileDelay;
	private static int StreamModePlaying = 0;
	private static int selectedFileResolution;
	public static int currentResolution;
	private static String pixelFirmware = "Not Connected";
	private static String pixelBootloader = "Not Connected";
	private static String pixelHardwareID = "Not Connected";
	private static String IOIOLibVersion = "Not Connected";
	private static VersionType v;
	private static  ByteBuffer buffer; //Create a new buffer
	private int appCode;
	private static boolean mRunning = true;
	private static boolean readyForLocalPlayBack = false;
	public static Context baseContext;
	//private static MainActivity mainActivity2 = new MainActivity();  //had to add this due some context requirements
	private  ProgressDialog progress;
	public static long frame_length;
    private RandomAccessFile raf = null;
	private File file;
	private int readytoWrite = 0;
	private static int matrix_number;
	public static createSlideShowAsync myCreateSlideShowAsync;
	
	private writePixelAsync writePixel;
	private GridView gridview;
	public ListAdapter list;
	public static int gridViewPosition = 0;
	private boolean kioskMode_ = false;
	public static String originalImagePath;
	public static String filename_no_extension;
	private boolean gifonly_ = false;
	private boolean only64_ = false;
	private boolean showStartupMsg_ = true;
	public static String gifPath_;
	private String downloadURL_32;
	private String downloadURL_64;
	private boolean saveMultipleCameraPics_;
	private boolean writeCameraFlag_ = false;
	private Bitmap cameraBMP;
	private Bitmap blackFrame_;
	
	private static File[] PNGFiles;
	private boolean scanAllPics;
	private String setupInstructionsString; 
	private String setupInstructionsStringTitle;
	private static final int SWIPE_MIN_DISTANCE = 120;
	private static final int SWIPE_MAX_OFF_PATH = 250;
	private static final int SWIPE_THRESHOLD_VELOCITY = 200;
	private GestureDetector gestureDetector;
	private  OnTouchListener gestureListener;
	
	public static int slideshowPosition = 0;
	private int slideShowRunning = 0;
	public static ImageDisplayDurationTimer imagedisplaydurationTimer;
	public static PauseBetweenImagesDurationTimer pausebetweenimagesdurationTimer;
	     
	public int imageDisplayDuration;
	
	public int pauseBetweenImagesDuration;
	
	private int z = 0;
	
	public static String SlideShowArray[] = new String[5000];
	
	public static String SlideShowArrayFavs[] = new String[5000];
	
	public static String SlideShowArrayAll[] = new String[5000];
	
	public static String SlideShowGIFFavs[] = new String[5000];
	
	public static ArrayList<String> items = new ArrayList<String>();
	
	public static File PNGPathFile = null;
	
	public static File GIFPathPNG = null;
	
	public static File GIFPathDecoded = null;
	
	public static File GIFPathtxt = null;
	
	public static File GIFPathSource = null;
	
	public static int SlideShowLength;
	
	public static int SlideShowLengthAll;
	
	public static int SlideShowLengthFavs;
	
	private static int SlideShowLengthGIFFavs;
	
	final String welcomeScreenShownPref = "welcomeScreenShown";
	
	private boolean slideShowAllPNGs_ = false;
	
	private boolean FavPNGHasFiles = false;
	
	private boolean FavGIFHasFiles = false;
	
	private boolean DisableNewArtCheck_ = false;

	private MediaPlayer mediaPlayer;
	
	private AssetFileDescriptor sinistarWAV;	
	
	private AssetFileDescriptor qbertWAV;	
	
	private int slideshowGIFFrameDelay;
	
	public static int targetScreenResolution = 0;
	
	boolean ExpandedFilesCopied = false;
	
	private String zipFilename = ""; 
     
    private String unzipLocation = Environment.getExternalStorageDirectory() + "/pixel/"; 
    private SharedPreferences.Editor editor;
    
    //Edit these variables when updating the patch APK expansion files
	//*********************************
	//to do add the byte file sizes too
	private int mainAPKExpNumFiles = 874;
    private int patchAPKExpNumFiles = 27;
    private static int APKExpMainVersion = 77;
    private static int APKExpPatchVersion = 81; //put the version of the APK exp file, not the current version of this code!
    private static Long APKExpMainFileSize = 44238062L; //old one 32279235L; 44238062
    private static Long APKExpPatchFileSize = 684093L;  //566985L new test one   502035L the original 63 is 268398L 6785
    private static Long ArtSpaceMB = 300L; //how much free space to check for
    //***********************************
    
	private long APKExpMainFileSizeSDCard;
	private long APKExpPatchFileSizeSDCard;
	private long mainAPKExpFileSizeLast;//the size when the user last exited the app of the APKExp files saved to prefs
	private long patchAPKExpFileSieLast; 
	private int DLCounter = 0;
	private int NumDownloadsRequired = 0;
	private String APKExpansionPathMain;
	private String APKExpansionPathPatch;
	private Boolean mainAPKUnzipped = false;
	private Boolean patchAPKUnzipped = false;
	private File APKExpansionPathMainFile;
	private File APKExpansionPathPatchFile;
    //***********************************
	
	private boolean AutoSelectPanel_ = true;
	
	
	/*this next set of code is for the APK expansion downloader service, 
	we need this because APK's in Android can only be 50 MB and
	with all the decoded pixel art, we're now over the 50 MB limit
	
	so here's how we'll handle things going forward:
		- assets will have all baseline gif and pngs (so the user can still be up and running if downloader service is not available)
		- the main apk expansion will have all baseline gif64, png64, gif16, and png16
		- the patch apk expansion will have incremental gif, gif64, gif16, png, png64, and png16
		- usergif, userpng, favgif, and favpng will continue to be generated on the fly
		
		- the main apk expansion zip we will unzip/inflate and overwrite whatever is their in our existing directory structure under /pixel
		- for the patch apk expansion zip, we will add incremental files into their own directories and not over-write anything currently in the directory
		- we'll need some preference flag that gets set letting us know that we actually completed the inflate after the download, one flag for main and one flag for patch
		- and then if a new apk expansion files comes in the future, then we'll need to reset this flag preference
		
		- and also we should add an Internet check and not try to download if the user is not on the Internet
		- we also need to add a sd card space check to ensure the user has enough sd card / intenral storage available
		
	 the program flow is as follows:
	 	1. first assets will inflat as it does now and also create all the directories: gif, gif64, png, png64, gif16, png16, etc, this will repeat if the gifs directory is missing
	 	2. then we copy from assets to gif and png as we do today and call ContinueonCreate()
	 	3. now here we check if the user has internet and sd card space
	 	4. if yes, then we'll do a check to see if they have the obb files and start the download if they do not
	 	5. do a quick verification of the downloaded files
	 	6. if download files are valid, then we unpack and unzip into our folder structure starting with the main apk
	 	7. now move on to patch apk and unzip into our folder structure, for patch make sure to unzip into the folder structure but do a merge and not over-write anything
	 	8. set a flag somewhere telling us that we have finished the unzip, do this because it's possible the user has the obbs but didn't have enough free space for the unzip and he/she free'd up some space later and therefore we should try again
	 	9. then in the future once the primary apk and expansion files are updated again, start from step 3
	 	10. we could also add a preference that the user can pick if they don't ever want to be prompted for updated art with the rational they will never have enough space?
	 	
	*/
	
	private ProgressBar mPB;

    private TextView mStatusText;
    private TextView mProgressFraction;
    private TextView mProgressPercent;
    private TextView mAverageSpeed;
    private TextView mTimeRemaining;

    private View mDashboard;
    private View mCellMessage;

    private Button mPauseButton;
    private Button mWiFiSettingsButton;

    private boolean mStatePaused;
    private int mState;

    private IDownloaderService mRemoteService;

    private IStub mDownloaderClientStub;
    
    public static int gridScale = 1;
    
    // The shared path of the OBB Expansion files
    private final static String EXP_PATH = "/Android/obb/";
    
    private void setState(int newState) {
        if (mState != newState) {
            mState = newState;
            mStatusText.setText(Helpers.getDownloaderStringResourceIDFromState(newState));
        }
    }

    private void setButtonPausedState(boolean paused) {
        mStatePaused = paused;
        int stringResourceID = paused ? R.string.text_button_resume :
                R.string.text_button_pause;
        mPauseButton.setText(stringResourceID);
    }

    /**
     * This is a little helper class that demonstrates simple testing of an
     * Expansion APK file delivered by Market. You may not wish to hard-code
     * things such as file lengths into your executable... and you may wish to
     * turn this code off during application development.
     */
    private static class XAPKFile {
        public final boolean mIsMain;
        public final int mFileVersion;
        public final long mFileSize;

        XAPKFile(boolean isMain, int fileVersion, long fileSize) {
            mIsMain = isMain;
            mFileVersion = fileVersion;
            mFileSize = fileSize;
        }
    }

    /**
     * Here is where you place the data that the validator will use to determine
     * if the file was delivered correctly. This is encoded in the source code
     * so the application can easily determine whether the file has been
     * properly delivered without having to talk to the server. If the
     * application is using LVL for licensing, it may make sense to eliminate
     * these checks and to just rely on the server.
     */
    private static final XAPKFile[] xAPKS = {
            new XAPKFile(
                    true, // true signifies a main file
                    APKExpMainVersion, // the version of the APK that the file was uploaded against
                    APKExpMainFileSize
            ),
            new XAPKFile(
                    false, // false signifies a patch file
                    APKExpPatchVersion, // the version of the APK that the patch file was uploaded against
                    APKExpPatchFileSize // the length of the patch file in bytes
            )            
    };

    /**
     * Go through each of the APK Expansion files defined in the structure above
     * and determine if the files are present and match the required size. Free
     * applications should definitely consider doing this, as this allows the
     * application to be launched for the first time without having a network
     * connection present. Paid applications that use LVL should probably do at
     * least one LVL check that requires the network to be present, so this is
     * not as necessary.
     * 
     * @return true if they are present.
     */
    
    public File[] GetFiles(String DirectoryPath) {
        File f = new File(DirectoryPath);
        f.mkdirs();
        File[] file = f.listFiles();
        return file;
    }

    public ArrayList<String> getFileNames(File[] file){
        ArrayList<String> arrayFiles = new ArrayList<String>();
         if (file.length == 0)
                return null;
            else {
                for (int i=0; i<file.length; i++) 
                    arrayFiles.add(file[i].getName());
            }

        return arrayFiles;
    }
    
    /* private void GetExpansionFileVersion() {
    	int ExpVersionInt = 0;
    	  //for (XAPKFile xf : xAPKS) {
         // 	String fileName = Helpers.getExpansionAPKFileName(this, xf.mIsMain, xf.mFileVersion);
          	StringTokenizer tokens = new StringTokenizer(fileName, ".");
          	String ExpType = tokens.nextToken();// this will contain "main or patch"
          	String ExpVersion = tokens.nextToken();// this will contain the version
          	ExpVersionInt = Integer.parseInt(ExpVersion);
          	Log.v("PixelAnimate2", ExpType + " " + ExpVersion);
          	//return ExpVersionInt;
          	
          	if (!Helpers.doesFileExist(this, fileName, xf.mFileSize, false)) {
                  return false;
              }    
         // }
    	  //return ExpVersionInt;
    }*/
    
    boolean expansionFilesDelivered() {
        for (XAPKFile xf : xAPKS) {
        	String fileName = Helpers.getExpansionAPKFileName(this, xf.mIsMain, xf.mFileVersion);
            if (!Helpers.doesFileExist(this, fileName, xf.mFileSize, false)) {
                return false;
            }    
        }
        return true;
    }

    /**
     * Calculating a moving average for the validation speed so we don't get
     * jumpy calculations for time etc.
     */
    static private final float SMOOTHING_FACTOR = 0.005f;
    
    /**
     * Used by the async task
     */
    private boolean mCancelValidation;

    /**
     * Go through each of the Expansion APK files and open each as a zip file.
     * Calculate the CRC for each file and return false if any fail to match.
     * 
     * @return true if XAPKZipFile is successful
     */
    private void CheckAndUnzipAPKExp() {
    	
	  if (Environment.getExternalStorageState()
	          .equals(Environment.MEDIA_MOUNTED) &&  getAvailableSpaceInMB() > ArtSpaceMB) { //there is an available SD card and we have 300 MB free
	        // Build the full path to the app's expansion files
		  
		  
		 // showToast(String.valueOf(getAvailableSpaceInMB()));
		  
		    String packageName = this.getPackageName();
	 	   
	 	    APKExpansionPathMain = Helpers.getExpansionAPKFileName(this, true, APKExpMainVersion); //just the name, NOT the full path!
	 	    APKExpansionPathPatch = Helpers.getExpansionAPKFileName(this, false, APKExpPatchVersion);
	 	   
	        File root = Environment.getExternalStorageDirectory();
	        APKExpansionPathMainFile = new File(root.toString() + EXP_PATH + packageName + "/" + APKExpansionPathMain);
	        APKExpansionPathPatchFile = new File(root.toString() + EXP_PATH + packageName + "/" + APKExpansionPathPatch);
	        
	        unzipLocation = Environment.getExternalStorageDirectory() + "/pixel/"; 
	        
	        mainAPKExpFileSizeLast = prefs.getLong("APKExpMainFileSizePref", 0);
	        patchAPKExpFileSieLast = prefs.getLong("APKExpPatchFileSizePref", 0);
	        
	    	/*  here let's do two checks:
	    	 *  Check #1 
	    	 *  the first check is that the unzip flag has been set to false which could be the case
	    	 *  if there was a download initiated from this code
	    	 */ 

	        mainAPKUnzipped = prefs.getBoolean("mainAPKUnzippedPref", false);
	        patchAPKUnzipped = prefs.getBoolean("patchAPKUnzippedPref", false);
	        
	       // mainAPKUnzipped = true;
	       // patchAPKUnzipped = true;
	        
	        
	        /*Check #2
	        for the second check, we will need to check if the download came automatically from Google Play
	        we will compare the APKExp file sizes that were there when the
	        user last exited that app which we saved in prefs. If the size now of the APKExp files is different,
	        then it means there was an update which most likely came from Google Play automatically, so if this
	        is the case, then we shall now reset the unzip flags too*/
	        
	    	//let's get the file size of the APKExp Main on the sd card right now
	        //File APKExpansionPathMainFile = new File(APKExpansionPathMain);
	        if(APKExpansionPathMainFile.exists()){
	    		 APKExpMainFileSizeSDCard = APKExpansionPathMainFile.length();
	    	}	
	       
	      //let's get the file size of the APKExp Patch on the sd card right now
	       //File APKExpansionPathPatchFile = new File(APKExpansionPathPatch);
	       if(APKExpansionPathPatchFile.exists()){
	    		APKExpPatchFileSizeSDCard = APKExpansionPathPatchFile.length();
	    	}	
	       
	       Log.v("PixelAnimate2", "mainAPKExpFileSizeLast=" + String.valueOf(mainAPKExpFileSizeLast));
	       Log.v("PixelAnimate2", "APKExpMainFileSizeSDCard=" + String.valueOf(APKExpMainFileSizeSDCard));
	       Log.v("PixelAnimate2", "patchAPKExpFileSieLast=" + String.valueOf(patchAPKExpFileSieLast));
	       Log.v("PixelAnimate2", "APKExpPatchFileSizeSDCard=" + String.valueOf(APKExpPatchFileSizeSDCard));
	       

	       //and then compare it to the file size that was on the SD card that last time the app was used that we saved in prefs upon exit
	       //if it's not the same, it means an upgrade came from Google Play so let's set our unzip flag on that file
	       if (mainAPKExpFileSizeLast != APKExpMainFileSizeSDCard)  {
	    	   editor = prefs.edit();
	    	   editor.putBoolean("mainAPKUnzippedPref", false); //to d
	           editor.commit(); // Very important to save the preference
	    	   mainAPKUnzipped = false;
	       }
	       
	       if (patchAPKExpFileSieLast != APKExpPatchFileSizeSDCard)  {
	    	   editor = prefs.edit();
	    	   editor.putBoolean("patchAPKUnzippedPref", false);
	           editor.commit(); // Very important to save the preference
	    	   patchAPKUnzipped = false;
	        }
	       
	       Log.v("PixelAnimate2", "MainAPKExp Unzipped = " + String.valueOf(mainAPKUnzipped));
	       Log.v("PixelAnimate2", "PathAPKExp Unzipped = " + String.valueOf(patchAPKUnzipped));
	       
	       //for testing the unzips
	       /*mainAPKUnzipped = false;
	       patchAPKUnzipped = false;*/
	      

	       if (!mainAPKUnzipped  || !patchAPKUnzipped) { //if either one of them have not been unzipped, then let's go here
	          
	    	  unZipAsync unZipAsync_ = new unZipAsync(root.toString() + EXP_PATH + packageName + "/" + APKExpansionPathMain,root.toString() + EXP_PATH + packageName + "/" + APKExpansionPathPatch,mainAPKExpNumFiles,patchAPKExpNumFiles ,unzipLocation); //String zipFileMain, String zipFilePatch, int zipFileMainNumFiles, int zipFilePatchNumFiles, String unzipLocation) { 
	          unZipAsync_.execute();
	       }
	       
	       else {
	    	   writeAPKSizesToPrefs();  //now let's write the size of the APK Exp that are on the SD card right now so we can compare for next time
	       }
	  }
	  else {
		  AlertDialog.Builder alert=new AlertDialog.Builder(this);
		  alert.setTitle(getResources().getString(R.string.noFreeSpace)).setIcon(R.drawable.icon).setMessage(getResources().getString(R.string.noFreeSpaceMsg)).setNeutralButton(getResources().getString(R.string.OKText), null).show();	
	  }
}

    /**
     * If the download isn't present, we initialize the download UI. This ties
     * all of the controls into the remote service calls.
     */
    private void initializeDownloadUI() {
        mDownloaderClientStub = DownloaderClientMarshaller.CreateStub
                (this, PIXELDownloaderService.class);
       
        mPB = (ProgressBar) findViewById(R.id.progressBar);
        mStatusText = (TextView) findViewById(R.id.statusText);
        mProgressFraction = (TextView) findViewById(R.id.progressAsFraction);
        mProgressPercent = (TextView) findViewById(R.id.progressAsPercentage);
        mAverageSpeed = (TextView) findViewById(R.id.progressAverageSpeed);
        mTimeRemaining = (TextView) findViewById(R.id.progressTimeRemaining);
        
        //mDashboard = findViewById(R.id.downloaderDashboard);
        mDashboard = findViewById(R.id.APKExpanderDownloader); //mdashboard is all the fields and views in the downloader 
        
        mDashboard.setVisibility(View.VISIBLE); //it was hidden by default in the layout
        
        mCellMessage = findViewById(R.id.approveCellular);
        mPauseButton = (Button) findViewById(R.id.pauseButton);
        mWiFiSettingsButton = (Button) findViewById(R.id.wifiSettingsButton);

        mPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStatePaused) {
                    mRemoteService.requestContinueDownload();
                } else {
                    mRemoteService.requestPauseDownload();
                }
                setButtonPausedState(!mStatePaused);
            }
        });

        mWiFiSettingsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
            }
        });

        Button resumeOnCell = (Button) findViewById(R.id.resumeOverCellular);
        resumeOnCell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRemoteService.setDownloadFlags(IDownloaderService.FLAGS_DOWNLOAD_OVER_CELLULAR);
                mRemoteService.requestContinueDownload();
                mCellMessage.setVisibility(View.GONE);
            }
        });

    }
    
    /*    void validateXAPKZipFiles() { //we're not using this one now, it checks that the APK Exp file downloaded is correct CRC check
    AsyncTask<Object, DownloadProgressInfo, Boolean> validationTask = new AsyncTask<Object, DownloadProgressInfo, Boolean>() {

        @Override
        protected void onPreExecute() {
            
        	String [] APKExpansionPath = getAPKExpansionFiles(context,APKExpMainVersion,APKExpPatchVersion); //50 and 50 are the version code versions of the APKs these were originally associated with
            
            APKExpansionPathMain = APKExpansionPath[0];
            APKExpansionPathPatch = APKExpansionPath[1];
            unzipLocation = Environment.getExternalStorageDirectory() + "/pixel/"; 
        	
        	mDashboard.setVisibility(View.VISIBLE);
            mCellMessage.setVisibility(View.GONE);
            mStatusText.setText(R.string.text_verifying_download);
            mPauseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCancelValidation = true;
                }
            });
            mPauseButton.setText(R.string.text_button_cancel_verify);
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Object... params) {
            for (XAPKFile xf : xAPKS) {
                String fileName = Helpers.getExpansionAPKFileName(
                        MainActivity.this,
                        xf.mIsMain, xf.mFileVersion);
                if (!Helpers.doesFileExist(MainActivity.this, fileName,
                        xf.mFileSize, false))
                    return false;
                fileName = Helpers
                        .generateSaveFileName(MainActivity.this, fileName);
                ZipResourceFile zrf;
                byte[] buf = new byte[1024 * 256];
                try {
                    zrf = new ZipResourceFile(fileName);
                    ZipEntryRO[] entries = zrf.getAllEntries();
                    *//**
                     * First calculate the total compressed length
                     *//*
                    long totalCompressedLength = 0;
                    for (ZipEntryRO entry : entries) {
                        totalCompressedLength += entry.mCompressedLength;
                    }
                    float averageVerifySpeed = 0;
                    long totalBytesRemaining = totalCompressedLength;
                    long timeRemaining;
                    *//**
                     * Then calculate a CRC for every file in the Zip file,
                     * comparing it to what is stored in the Zip directory.
                     * Note that for compressed Zip files we must extract
                     * the contents to do this comparison.
                     *//*
                    for (ZipEntryRO entry : entries) {
                        if (-1 != entry.mCRC32) {
                            long length = entry.mUncompressedLength;
                            CRC32 crc = new CRC32();
                            DataInputStream dis = null;
                            try {
                                dis = new DataInputStream(
                                        zrf.getInputStream(entry.mFileName));

                                long startTime = SystemClock.uptimeMillis();
                                while (length > 0) {
                                    int seek = (int) (length > buf.length ? buf.length
                                            : length);
                                    dis.readFully(buf, 0, seek);
                                    crc.update(buf, 0, seek);
                                    length -= seek;
                                    long currentTime = SystemClock.uptimeMillis();
                                    long timePassed = currentTime - startTime;
                                    if (timePassed > 0) {
                                        float currentSpeedSample = (float) seek
                                                / (float) timePassed;
                                        if (0 != averageVerifySpeed) {
                                            averageVerifySpeed = SMOOTHING_FACTOR
                                                    * currentSpeedSample
                                                    + (1 - SMOOTHING_FACTOR)
                                                    * averageVerifySpeed;
                                        } else {
                                            averageVerifySpeed = currentSpeedSample;
                                        }
                                        totalBytesRemaining -= seek;
                                        timeRemaining = (long) (totalBytesRemaining / averageVerifySpeed);
                                        this.publishProgress(
                                                new DownloadProgressInfo(
                                                        totalCompressedLength,
                                                        totalCompressedLength
                                                                - totalBytesRemaining,
                                                        timeRemaining,
                                                        averageVerifySpeed)
                                                );
                                    }
                                    startTime = currentTime;
                                    if (mCancelValidation)
                                        return true;
                                }
                                if (crc.getValue() != entry.mCRC32) {
                                    Log.e(Constants.TAG,
                                            "CRC does not match for entry: "
                                                    + entry.mFileName);
                                    Log.e(Constants.TAG,
                                            "In file: " + entry.getZipFileName());
                                    return false;
                                }
                            } finally {
                                if (null != dis) {
                                    dis.close();
                                }
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(DownloadProgressInfo... values) {
            onDownloadProgress(values[0]);
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {
                mDashboard.setVisibility(View.VISIBLE);
                mCellMessage.setVisibility(View.GONE);
                mStatusText.setText(R.string.text_validation_complete);
                mPauseButton.setVisibility(View.VISIBLE);
                
                mPauseButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    	mDashboard.setVisibility(View.GONE);
                        mCellMessage.setVisibility(View.GONE);
                        mStatusText.setText(R.string.text_validation_complete);
                        mPauseButton.setVisibility(View.GONE);
                    }
                });
                mPauseButton.setText(android.R.string.ok);
            	
            	 mDashboard.setVisibility(View.GONE);
                 mCellMessage.setVisibility(View.GONE);
               //  mStatusText.setText(R.string.text_validation_complete);
               //  mPauseButton.setVisibility(View.VISIBLE);
                 
                
                
            } else {
                mDashboard.setVisibility(View.VISIBLE);
                mCellMessage.setVisibility(View.GONE);
                mStatusText.setText(R.string.text_validation_failed);
                mPauseButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    	//to do download the new files here
                        //finish();
                    }
                });
                mPauseButton.setText(android.R.string.cancel);
            }
            
            //we've validated our obb's are good so now let's unzip them but let's not unzip if they have already been unzipped
           
             mainAPKUnzipped = prefs.getBoolean("mainAPKUnzippedPref", false);
             patchAPKUnzipped = prefs.getBoolean("patchAPKUnzippedPref", false);
             
            // for testing: mainAPKUnzipped = false;
            // patchAPKUnzipped = false;
            
         
            if (!mainAPKUnzipped  || !patchAPKUnzipped) { //if either one of them have not been unzipped, then let's go here
               	 unZipAsync unZipAsync_ = new unZipAsync(APKExpansionPathMain,APKExpansionPathPatch,mainAPKExpNumFiles,patchAPKExpNumFiles ,unzipLocation); //String zipFileMain, String zipFilePatch, int zipFileMainNumFiles, int zipFilePatchNumFiles, String unzipLocation) { 
               	 unZipAsync_.execute();
            }
            
            super.onPostExecute(result);
        }

    };
    validationTask.execute(new Object());
}*/
    
    

    /**
     * Called when the activity is first create; we wouldn't create a layout in
     * the case where we have the file and are moving to another activity
     * without downloading.
     */
	
	
	//**************************************
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		 setContentView(R.layout.main);
	      display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
	      
	      
	     //**** was added to due intermittent crashes http://stackoverflow.com/questions/24343563/avoiding-rejectedexecutionexception-in-android-4-4-when-app-uses-list 
	      try {
			AsyncTask.class.getMethod("setDefaultExecutor", Executor.class).invoke(null, AsyncTask.SERIAL_EXECUTOR);
		} catch (IllegalArgumentException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IllegalAccessException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (InvocationTargetException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (NoSuchMethodException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}	
	   
	      
	      this.prefs = PreferenceManager.getDefaultSharedPreferences(this);
	        //prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext()); //causing crash
	        
	        try
	        {
	            app_ver = this.getPackageManager().getPackageInfo(this.getPackageName(), 0).versionName;
	        }
	        catch (NameNotFoundException e)
	        {
	            Log.v(tag, e.getMessage());
	        }
	        
	        //******** preferences code
	        resources = this.getResources();
	        setPreferences();
	        //***************************
	      
	      
	     targetScreenResolution = getResources().getDisplayMetrics().widthPixels;
	     //showToast(String.valueOf(targetScreenResolution));
	     
	     //****new gridview and adapter code 
	     gridview = (GridView) findViewById(R.id.gridview);
	     list = new ListAdapter(this, items);
	     gridview.setAdapter(list);
	     
	     int numColumns = 2; //default
	     if (targetScreenResolution < 481) {  //my droidX is 480 width as an example, samsung gs4 and gs4 is 1080 width, nexus 4 is 768, nexus 7 original is 800
	    	 numColumns = targetScreenResolution / (128 / MainActivity.gridScale); //128
	    	 gridview.setNumColumns(numColumns);
	     }
	     else {
	    	 numColumns = targetScreenResolution / (256 / MainActivity.gridScale); //256
	    	 gridview.setNumColumns(numColumns);
	     }
	     
	     //note samsung gs4 and gs4 is 1080 width
	     //nexus4 is 800
	  
	    // gridview.setFastScrollEnabled(true);  //with this one, we're getting a CRASH
	     
	      gridview.setKeepScreenOn(false);
	      gifView = (GifView) findViewById(R.id.gifView); //gifview takes care of the gif decoding
	      gifView.setGif(R.drawable.zzzblank);  //code will crash if a dummy gif is not loaded initially
	      
	      gifView.setVisibility(View.GONE);
	      
	      blackFrame_ = BitmapFactory.decodeResource(getResources(), R.drawable.black_frame); 
	      
	     
	      
	     //let's get the app version so we'll know if we need to add new animations to the user's app   
	        PackageInfo pinfo;
			try {
				pinfo = this.getPackageManager().getPackageInfo(getPackageName(), 0);
				  appCode = pinfo.versionCode;
			     String appVersion = pinfo.versionName;
			      
			} catch (NameNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
      
        Boolean welcomeScreenShown = prefs.getBoolean(welcomeScreenShownPref, false);

        if (!welcomeScreenShown) {
            // here you can launch another activity if you like
        	// use this to announce new features in future apps
            // the code below will display a popup

            String whatsNewTitle = getResources().getString(R.string.whatsNewTitle);
            String whatsNewText = getResources().getString(R.string.whatsNewText);
            new AlertDialog.Builder(this).setIcon(R.drawable.ic_action_event).setTitle(whatsNewTitle).setMessage(whatsNewText).setPositiveButton(
                    R.string.OKText, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).show();
            editor = prefs.edit();
            editor.putBoolean(welcomeScreenShownPref, true);
            editor.commit(); // Very important to save the preference
        }
        
        if (noSleep == true) {        	      	
        	this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); //disables sleep mode
        }	
        
        connectTimer = new ConnectTimer(30000,5000); //pop up a message if it's not connected by this timer
 		connectTimer.start(); //this timer will pop up a message box if the device is not found
 		
 		context = getApplicationContext();
 		baseContext = getBaseContext();
 		
 		//TO DO add a preerence to disable this
 		/*  gestureDetector = new GestureDetector(new MyGestureDetector());
 	       gestureListener = new View.OnTouchListener() {
 	    	   public boolean onTouch(View v, MotionEvent event) { 
 	    		   return gestureDetector.onTouchEvent(event);
 	    		   }
 	    	   };*/
 		
 		 
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {

            extStorageDirectory = Environment.getExternalStorageDirectory().toString();
            	
            	File artdir = new File(GIFPath);
            	File PNGdir = new File(PNGPath);
            	
	            if (!artdir.exists() || !PNGdir.exists()) { //no directory so let's now start the one time setup
	            
	            	new copyFilesAsync().execute();
	            	//note that continueOnCreate() is called after this async task is done
	               
	            }
	            else { //the directory was already there so no need to copy files or do a media re-scan so just continue on
	            	
	            	//now let's check if our APK Exp files are in order
	            	//expansionFileVersion();
	            	
	            	if (DisableNewArtCheck_) {  //then the user doesn't want us to check for new art so just continue the program
	            		continueOnCreate();
	            	}
	            	else {
	            		LookForAPKExpFiles();
	            	}
	            }
   
        } else  {
        	AlertDialog.Builder alert=new AlertDialog.Builder(this);
 	      	alert.setTitle("No SD Card").setIcon(R.drawable.icon).setMessage("Sorry, your device does not have an accessible SD card, this app needs to copy some images to your SD card and will not work without it.\n\nPlease exit this app and go to Android settings and check that your SD card is mounted and available and then restart this app.\n\nNote for devices that don't have external SD cards, this app will utilize the internal SD card memory but you are most likely seeing this message because your device does have an external SD card slot.").setNeutralButton("OK", null).show();
           
        }
        
        
        // Get intent, action and MIME type
	      Intent intent = getIntent();
	      String action = intent.getAction();
	      String type = intent.getType();

	      if (Intent.ACTION_SEND.equals(action) && type != null) {
	        //  if ("text/plain".equals(type)) {
	        //      handleSendText(intent); // Handle text being sent
	        //  } 
	          
	       if (type.startsWith("image/")) {
	              handleSendImage(intent); // Handle single image being sent
	          }
	      } 
	      
	     else if (Intent.ACTION_SEND_MULTIPLE.equals(action) && type != null) {
	          if (type.startsWith("image/")) {
	              handleSendMultipleImages(intent); // Handle multiple images being sent
	          }
	      }
	      
	      /*else {
	          // Handle other intents, such as being started from the home screen
	      }  */
        
        
	}
	
	 protected void onResume() {
         super.onResume();
         
         this.prefs = PreferenceManager.getDefaultSharedPreferences(this);
         updatePrefs();
     }
	

	@SuppressLint("NewApi")
	private void handleSendImage(Intent intent) { //another app has passed us on image so let's copy it to our sd card directory
	    Uri imageUri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
	   
	   
	    if (imageUri != null) {
	        // Update UI to reflect image being shared
	    	String uriPath = imageUri.toString();
	    	//showToast(uriPath);
	    	//Log.d(LOG_TAG,"URI path is: " + uriPath);
	    	
	    	/*
	         * Get the file's content URI from the incoming Intent, then
	         * get the file's MIME type
	         */
	        //Uri returnUri = returnIntent.getData();
	        
	       // String uriNameExtensionArray[] = mimeType.split("\\/");
        //	String uriExtension = uriNameExtensionArray[uriNameExtensionArray.length-1]; //image
	        
	        String uriExtension = null;
	        String mimeType = getContentResolver().getType(imageUri); //this doesn't work for web calls, only works locally
	        String uriNameExtensionArray[] = null;
	        String uriNameArray[] = null;
	        String newfilename_no_extension = null;
	        
	        //here we're just getting the extension of the image file, png, gif, jpg, etc.
	        if (mimeType != null && !mimeType.isEmpty()) {
	        	uriNameExtensionArray = mimeType.split("\\/"); //image/gif
	        	uriExtension = uriNameExtensionArray[uriNameExtensionArray.length-1]; //gif
	        	uriNameArray = uriPath.split("\\/");
	        	newfilename_no_extension = uriNameArray[uriNameArray.length-1]; //tree, we want the filename
	        }
	        else {
	        	//showToast("it's null");
	        	uriNameExtensionArray = uriPath.split("\\.");
	        	uriExtension = uriNameExtensionArray[uriNameExtensionArray.length-1]; //gif
	        	uriNameArray = uriPath.split("\\.");
	        	newfilename_no_extension = uriNameArray[uriNameArray.length-2]; //tree, we want the filename   path/morestuff/tree
	        	//showToast(newfilename_no_extension); 
	        	//Log.d(LOG_TAG,newfilename_no_extension);
	        	uriNameExtensionArray = newfilename_no_extension.split("\\/");
	        	newfilename_no_extension = uriNameExtensionArray[uriNameExtensionArray.length-1]; 
	        	//showToast(newfilename_no_extension);
	        }
	    	
	    	ContentResolver cr = getContentResolver();
	    	InputStream incomingStream = null;
	    	OutputStream out = null;
	    	
	    	//before we copy, let's check if the file we're copying already exists and give it another name if it does
	    	
	    	if (uriExtension.equals("gif")) {
	    		File outPath = new File(userGIFPath);
	    		 if (!outPath.exists()) {  //create the dir if it does not exist
					  outPath.mkdirs();
				  }
	    		 
	    		 try {
	   			  incomingStream = cr.openInputStream(imageUri);
	   			  String newFile = userGIFPath + newfilename_no_extension + "." + uriExtension;
	   			  //to do think about adding a check if the file name is already there
	   			  
	   			  File newGIFfile = new File(userGIFPath + newfilename_no_extension + "." + uriExtension);
	   			  if (newGIFfile.exists()) {  //if the file is already there, then let's come up with a random filename, had to add this here because attachments in gmail always have the filename of false
	   				  //newFile = userGIFPath + newfilename_no_extension + "1" + "." + uriExtension;
	   				  String uuid = UUID.randomUUID().toString();
	   				  out = new FileOutputStream(userGIFPath  + uuid + "." + uriExtension);
	   				  newFile = userGIFPath  + uuid + "." + uriExtension;
	   			  }
	   			  else {
	   				 out = new FileOutputStream(userGIFPath + newfilename_no_extension + "." + uriExtension);
	   			  }
	   			  
	   			  copyFile(incomingStream, out);
	   			  incomingStream.close();
	   			  incomingStream = null;
	   			  out.flush();
	   			  out.close();
	   			  out = null;
	   			  //we've copied in the new file so now we need to add it to the gridview
	   			  //TO DO test and make sure this works
	   			 // myImageAdapter.add(newFile);
	   			  items.add(newFile);
	   			  
	   			  //TO DO now let's send it to PIXEL
	   			  
	   			} catch(Exception e) {
	   			    Log.e("tag", e.getMessage());
	   			}
	    		 
	    		 
	    	}
	    	else {
	    		File outPath = new File(userPNGPath);
	    		 if (!outPath.exists()) {  //create the dir if it does not exist
					  outPath.mkdirs();
				  }
	    		 
	    		 try {
		   			  incomingStream = cr.openInputStream(imageUri);
		   			
		   			  String newFile = userPNGPath + newfilename_no_extension + "." + uriExtension;
		   			  //to do think about adding a check if the file name is already there
		   			  
		   			  File newPNGfile = new File(userPNGPath + newfilename_no_extension + "." + uriExtension);
		   			  if (newPNGfile.exists()) {  //append to the file if it's already there
		   				  String uuid = UUID.randomUUID().toString();
		   				  out = new FileOutputStream(userPNGPath  + uuid + "." + uriExtension);
		   				  newFile = userPNGPath  + uuid + "." + uriExtension;
		   			  }
		   			  else {
		   				out = new FileOutputStream(userPNGPath + newfilename_no_extension + "." + uriExtension);
		   			  } 
		   			  
		   			  copyFile(incomingStream, out);
		   			  incomingStream.close();
		   			  incomingStream = null;
		   			  out.flush();
		   			  out.close();
		   			  out = null;
		   			  //we've copied in the new file so now we need to add it to the gridview
		   			 //TO DO test and make sure this works
			   		 // myImageAdapter.add(newFile);
			   		  items.add(newFile);
			   	
		   			  //showToast ("New file added");
		   			  showToast(getString(R.string.newFileAdded));
		   			  
		   			  //TO DO now let's send it to PIXEL
		   			  
		   			} catch(Exception e) {
		   			    Log.e("tag", e.getMessage());
		   			}
	    		 
	    		 continueOnCreate();
	    	}
	    }
	    
	    //TO DO now that we have the new file in gridview, let's send it to PIXEL in steaming mode
	}

	private void handleSendMultipleImages(Intent intent) {
	    ArrayList<Uri> imageUris = intent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
	    if (imageUris != null) {
	        // Update UI to reflect multiple images being shared
	    	for(int i=0; i<imageUris.size(); i++) {
	    	    	String uriPath = imageUris.get(i).toString();
	    	        String uriExtension = null;
	    	        String mimeType = getContentResolver().getType(imageUris.get(i)); //this doesn't work for web calls, only works locally
	    	        String uriNameExtensionArray[] = null;
	    	        String uriNameArray[] = null;
	    	        String newfilename_no_extension = null;
	    	        
	    	        //here we're just getting the extension of the image file, png, gif, jpg, etc.
	    	        if (mimeType != null && !mimeType.isEmpty()) {
	    	        	uriNameExtensionArray = mimeType.split("\\/"); //image/gif
	    	        	uriExtension = uriNameExtensionArray[uriNameExtensionArray.length-1]; //gif
	    	        	uriNameArray = uriPath.split("\\/");
	    	        	newfilename_no_extension = uriNameArray[uriNameArray.length-1]; //tree, we want the filename
	    	        }
	    	        else {
	    	        	uriNameExtensionArray = uriPath.split("\\.");
	    	        	uriExtension = uriNameExtensionArray[uriNameExtensionArray.length-1]; //gif
	    	        	uriNameArray = uriPath.split("\\.");
	    	        	newfilename_no_extension = uriNameArray[uriNameArray.length-2]; //tree, we want the filename   path/morestuff/tree
	    	        	uriNameExtensionArray = newfilename_no_extension.split("\\/");
	    	        	newfilename_no_extension = uriNameExtensionArray[uriNameExtensionArray.length-1]; 
	    	        }
	    	    	
	    	    	ContentResolver cr = getContentResolver();
	    	    	InputStream incomingStream = null;
	    	    	OutputStream out = null;
	    	    	
	    	    	//before we copy, let's check if the file we're copying already exists and give it another name if it does
	    	    	
	    	    	if (uriExtension.equals("gif")) {
	    	    		File outPath = new File(userGIFPath);
	    	    		 if (!outPath.exists()) {  //create the dir if it does not exist
	    					  outPath.mkdirs();
	    				  }
	    	    		 
	    	    		 try {
	    	   			  incomingStream = cr.openInputStream(imageUris.get(i));
	    	   			  String newFile = userGIFPath + newfilename_no_extension + "." + uriExtension;
	    	   			  //to do think about adding a check if the file name is already there
	    	   			  
	    	   			  File newGIFfile = new File(userGIFPath + newfilename_no_extension + "." + uriExtension);
	    	   			  if (newGIFfile.exists()) {  //if the file is already there, then let's come up with a random filename, had to add this here because attachments in gmail always have the filename of false
	    	   				  String uuid = UUID.randomUUID().toString();
	    	   				  out = new FileOutputStream(userGIFPath  + uuid + "." + uriExtension);
	    	   				  newFile = userGIFPath  + uuid + "." + uriExtension;
	    	   			  }
	    	   			  else {
	    	   				 out = new FileOutputStream(userGIFPath + newfilename_no_extension + "." + uriExtension);
	    	   			  }
	    	   			  
	    	   			  copyFile(incomingStream, out);
	    	   			  incomingStream.close();
	    	   			  incomingStream = null;
	    	   			  out.flush();
	    	   			  out.close();
	    	   			  out = null;
	    	   			  items.add(newFile);
	    	   			  
	    	   			} catch(Exception e) {
	    	   			    Log.e("tag", e.getMessage());
	    	   			}
	    	    		 
	    	    		 
	    	    	}
	    	    	else {
	    	    		File outPath = new File(userPNGPath);
	    	    		 if (!outPath.exists()) {  //create the dir if it does not exist
	    					  outPath.mkdirs();
	    				  }
	    	    		 
	    	    		 try {
	    		   			  incomingStream = cr.openInputStream(imageUris.get(i));
	    		   			
	    		   			  String newFile = userPNGPath + newfilename_no_extension + "." + uriExtension;
	    		   			  //to do think about adding a check if the file name is already there
	    		   			  
	    		   			  File newPNGfile = new File(userPNGPath + newfilename_no_extension + "." + uriExtension);
	    		   			  if (newPNGfile.exists()) {  //append to the file if it's already there
	    		   				  String uuid = UUID.randomUUID().toString();
	    		   				  out = new FileOutputStream(userPNGPath  + uuid + "." + uriExtension);
	    		   				  newFile = userPNGPath  + uuid + "." + uriExtension;
	    		   			  }
	    		   			  else {
	    		   				out = new FileOutputStream(userPNGPath + newfilename_no_extension + "." + uriExtension);
	    		   			  } 
	    		   			  
	    		   			  copyFile(incomingStream, out);
	    		   			  incomingStream.close();
	    		   			  incomingStream = null;
	    		   			  out.flush();
	    		   			  out.close();
	    		   			  out = null;
	    			   		  items.add(newFile);
	    		   			  
	    		   			} catch(Exception e) {
	    		   			    Log.e("tag", e.getMessage());
	    		   			}
	    	    	}
	    	}
	    	
	    	//showToast ("New files added");
	    	showToast(getString(R.string.newFilesAdded));
	    	continueOnCreate();
	    }
		//showToast("Sorry, only single file sharing is supported. Please share just one image."); //removed this because now we can support multiple files for sharing
	}
	
	 private class copyFilesAsync extends AsyncTask<Void, Integer, Void>{
		 
	     int progress_status;
	      
	     @Override
	  protected void onPreExecute() {
		   // update the UI immediately after the task is executed
		   super.onPreExecute();
		   
		   progress = new ProgressDialog(MainActivity.this);
	       progress.setTitle(getString(R.string.oneTimeCopyTitle));
	       progress.setMessage(getString(R.string.oneTimeCopyMessage));
	       progress.setCancelable(false);
		   progress.setIcon(R.drawable.ic_action_warning);
	       progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
	       progress.show();
	       progress_status = 0;
	    
	  }
	      
	  @Override
	  protected Void doInBackground(Void... params) {
		  
			File artdir = new File(GIFPath);
			artdir.mkdirs();
            File decodeddir = new File(GIFPath + "decoded");
		  	decodeddir.mkdirs();
		  	
		  	File PNGdir = new File(PNGPath);
		  	if (!PNGdir.exists()) {
		  		PNGdir.mkdirs();
		  	}
		  	
		  	File PNG64dir = new File(PNG64Path);
		  	if (!PNG64dir.exists()) {
		  		PNG64dir.mkdirs();
		  	}
		  	
		  	File GIF64dir = new File(GIF64Path);
		  	if (!GIF64dir.exists()) {
		  		GIF64dir.mkdirs();
		  	}
		  	
			File PNG16dir = new File(PNG16Path);
		  	if (!PNG16dir.exists()) {
		  		PNG16dir.mkdirs();
		  	}
		  	
		  	File GIF16dir = new File(GIF16Path);
		  	if (!GIF16dir.exists()) {
		  		GIF16dir.mkdirs();
		  	}
		  	
		  	File gif16Sourcedir = new File(GIF16Path + "gifsource");
			if (!gif16Sourcedir.exists()) {
				gif16Sourcedir.mkdirs();
		  	}
			
			File GIF16decodeddir = new File(GIF16Path + "decoded");
		  	if (!GIF16decodeddir.exists()) {
		  		GIF16decodeddir.mkdirs();
		  	}
		  	
		  	File gifSourcedir = new File(GIFPath + "gifsource");
			if (!gifSourcedir.exists()) {
				gifSourcedir.mkdirs();
		  	}
			
			File gif64Sourcedir = new File(GIF64Path + "gifsource");
			if (!gif64Sourcedir.exists()) {
				gif64Sourcedir.mkdirs();
		  	}
			
			File GIF64decodeddir = new File(GIF64Path + "decoded");
		  	if (!GIF64decodeddir.exists()) {
		  		GIF64decodeddir.mkdirs();
		  	}
			
		  	copyArt(); //copy the .png and .gif files (mainly png) because we want to decode first
		  	copyGIFDecoded();  //copy the decoded files
			copyPNG();  //copy the png files
			copyGIF64();
			copyGIF16();
			copyPNG64();
			copyGIFSource();
			copyGIF64Source();
			copyGIF64Decoded();
			
	   return null;
	  }
	  
	  @Override
	  protected void onProgressUpdate(Integer... values) {
	   super.onProgressUpdate(values);
	   progress.incrementProgressBy(1);
	    
	  }
	   
	  @Override
	  protected void onPostExecute(Void result) {
		  
		  
		  
	   super.onPostExecute(result);
	   progress.dismiss(); //we're done so now hide the progress update box
	   LookForAPKExpFiles(); //we've copied initial files, now need to check and unzip the APKExp
	  }
	  
		//********** the copy functions
	  
		private void copyArt() {
	    	
	    	AssetManager assetManager = getResources().getAssets();
	        String[] files = null;
	        try {
	           files = assetManager.list("gif");
	           //files = assetManager.list(GIFname); //not sure why but putting a variable here doesn't work, only works if you put the string, weird...
	        } catch (Exception e) {
	            Log.e("read clipart ERROR", e.toString());
	            e.printStackTrace();
	        }
	        
	        //let's get the total numbers of files here and set the progress bar
	        progress.setMax(files.length*3);
	        
	        for(int i=0; i<files.length; i++) {
	            InputStream in = null;
	            OutputStream out = null;
	            try {
	           
	             in = assetManager.open("gif/" + files[i]); //same thing, can't put a variable for gif
	             out = new FileOutputStream(GIFPath + files[i]);
	              
	              copyFile(in, out);
	              in.close();
	              in = null;
	              out.flush();
	              out.close();
	              out = null;    
	            
	           progress_status ++;
	  		   publishProgress(progress_status);  
	           
	            } catch(Exception e) {
	                Log.e("copy clipart ERROR", e.toString());
	                e.printStackTrace();
	            }       
	        }
	    }
		
		
		private void copyGIFDecoded() {
	    	
	    	AssetManager assetManager = getResources().getAssets();
	        String[] files = null;
	        try {
	            files = assetManager.list("gif/decoded");
	            //files2 = assetManager.list(GIFname + "/decoded");
	        } catch (Exception e) {
	            Log.e("read clipart ERROR", e.toString());
	            e.printStackTrace();
	        }
	        for(int i=0; i<files.length; i++) {
	        	progress_status ++;
		  		publishProgress(progress_status);  
	            InputStream in = null;
	            OutputStream out = null;
	            try {
	             in = assetManager.open("gif/decoded/" + files[i]);
	             out = new FileOutputStream(GIFPath + "decoded/" + files[i]);
	              copyFile(in, out);
	              in.close();
	              in = null;
	              out.flush();
	              out.close();
	              out = null;  
	              
	              //no need to register these with mediascanner as these are internal gifs , the workaround for the gifs with a black frame as the first frame
	           
	            } catch(Exception e) {
	                Log.e("copy clipart ERROR", e.toString());
	                e.printStackTrace();
	            }       
	        }
	    } //end copy gif decoded
		
		private void copyGIFSource() {
	    	
	    	AssetManager assetManager = getResources().getAssets();
	        String[] files = null;
	        try {
	            files = assetManager.list("gif/gifsource");
	        } catch (Exception e) {
	            Log.e("read clipart ERROR", e.toString());
	            e.printStackTrace();
	        }
	        for(int i=0; i<files.length; i++) {
	        	progress_status ++;
		  		publishProgress(progress_status);  
	            InputStream in = null;
	            OutputStream out = null;
	            try {
	             in = assetManager.open("gif/gifsource/" + files[i]);
	             out = new FileOutputStream(GIFPath + "gifsource/" + files[i]);
	              copyFile(in, out);
	              in.close();
	              in = null;
	              out.flush();
	              out.close();
	              out = null;
	           
	            } catch(Exception e) {
	                Log.e("copy clipart ERROR", e.toString());
	                e.printStackTrace();
	            }       
	        }
	    } //end copy gifsource
		
private void copyGIF64Source() {
	    	
	    	AssetManager assetManager = getResources().getAssets();
	        String[] files = null;
	        try {
	            files = assetManager.list("gif64/gifsource");
	        } catch (Exception e) {
	            Log.e("read clipart ERROR", e.toString());
	            e.printStackTrace();
	        }
	        for(int i=0; i<files.length; i++) {
	        	progress_status ++;
		  		publishProgress(progress_status);  
	            InputStream in = null;
	            OutputStream out = null;
	            try {
	             in = assetManager.open("gif64/gifsource/" + files[i]);
	             out = new FileOutputStream(GIF64Path + "gifsource/" + files[i]);
	              copyFile(in, out);
	              in.close();
	              in = null;
	              out.flush();
	              out.close();
	              out = null;
	           
	            } catch(Exception e) {
	                Log.e("copy clipart ERROR", e.toString());
	                e.printStackTrace();
	            }       
	        }
	    } //end copy gifsource
		
  private void copyGIF64Decoded() {
	    	
	    	AssetManager assetManager = getResources().getAssets();
	        String[] files = null;
	        try {
	            files = assetManager.list("gif64/decoded");
	            //files2 = assetManager.list(GIFname + "/decoded");
	        } catch (Exception e) {
	            Log.e("read clipart ERROR", e.toString());
	            e.printStackTrace();
	        }
	        for(int i=0; i<files.length; i++) {
	        	progress_status ++;
		  		publishProgress(progress_status);  
	            InputStream in = null;
	            OutputStream out = null;
	            try {
	             in = assetManager.open("gif64/decoded/" + files[i]);
	             out = new FileOutputStream(GIF64Path + "decoded/" + files[i]);
	              copyFile(in, out);
	              in.close();
	              in = null;
	              out.flush();
	              out.close();
	              out = null;  
	              
	              //no need to register these with mediascanner as these are internal gifs , the workaround for the gifs with a black frame as the first frame
	           
	            } catch(Exception e) {
	                Log.e("copy clipart ERROR", e.toString());
	                e.printStackTrace();
	            }       
	        }
	    } //end copy gif decoded
		
   private void copyPNG() {
	    	
	    	AssetManager assetManager = getResources().getAssets();
	        String[] files = null;
	        try {
	            files = assetManager.list("png");
	        } catch (Exception e) {
	            Log.e("read clipart ERROR", e.toString());
	            e.printStackTrace();
	        }
	        for(int i=0; i<files.length; i++) {
	        	progress_status ++;
		  		publishProgress(progress_status);  
	            InputStream in = null;
	            OutputStream out = null;
	            try {
	             in = assetManager.open("png/" + files[i]);
	             out = new FileOutputStream(PNGPath + files[i]); //PNGPath has the blackslash at the end
	              copyFile(in, out);
	              in.close();
	              in = null;
	              out.flush();
	              out.close();
	              out = null;  
	              
	              //no need to register these with mediascanner as these are internal gifs , the workaround for the gifs with a black frame as the first frame
	           
	            } catch(Exception e) {
	                Log.e("copy clipart ERROR", e.toString());
	                e.printStackTrace();
	            }       
	        }
	    } //end copyPNG
   
   private void copyPNG64() {
   	
   	AssetManager assetManager = getResources().getAssets();
       String[] files = null;
       try {
           files = assetManager.list("png64");
       } catch (Exception e) {
           Log.e("read clipart ERROR", e.toString());
           e.printStackTrace();
       }
       for(int i=0; i<files.length; i++) {
       	progress_status ++;
	  		publishProgress(progress_status);  
           InputStream in = null;
           OutputStream out = null;
           try {
            in = assetManager.open("png64/" + files[i]);
            out = new FileOutputStream(PNG64Path + files[i]); 
             copyFile(in, out);
             in.close();
             in = null;
             out.flush();
             out.close();
             out = null;  
             
             //no need to register these with mediascanner as these are internal gifs , the workaround for the gifs with a black frame as the first frame
          
           } catch(Exception e) {
               Log.e("copy clipart ERROR", e.toString());
               e.printStackTrace();
           }       
       }
   } //end copyPNG64
   
   private void copyGIF64() {
	   	
	   	AssetManager assetManager = getResources().getAssets();
	       String[] files = null;
	       try {
	           files = assetManager.list("gif64");
	       } catch (Exception e) {
	           Log.e("read clipart ERROR", e.toString());
	           e.printStackTrace();
	       }
	       for(int i=0; i<files.length; i++) {
	       	progress_status ++;
		  		publishProgress(progress_status);  
	           InputStream in = null;
	           OutputStream out = null;
	           try {
	            in = assetManager.open("gif64/" + files[i]);
	            out = new FileOutputStream(GIF64Path + files[i]); 
	             copyFile(in, out);
	             in.close();
	             in = null;
	             out.flush();
	             out.close();
	             out = null;  
	             
	             //no need to register these with mediascanner as these are internal gifs , the workaround for the gifs with a black frame as the first frame
	          
	           } catch(Exception e) {
	               Log.e("copy clipart ERROR", e.toString());
	               e.printStackTrace();
	           }       
	       }
	   } //end copyGIF64
   
   private void copyGIF16() {
	   	
	   	AssetManager assetManager = getResources().getAssets();
	       String[] files = null;
	       try {
	           files = assetManager.list("gif16");
	       } catch (Exception e) {
	           Log.e("read clipart ERROR", e.toString());
	           e.printStackTrace();
	       }
	       for(int i=0; i<files.length; i++) {
	       	progress_status ++;
		  		publishProgress(progress_status);  
	           InputStream in = null;
	           OutputStream out = null;
	           try {
	            in = assetManager.open("gif16/" + files[i]);
	            out = new FileOutputStream(GIF16Path + files[i]); 
	             copyFile(in, out);
	             in.close();
	             in = null;
	             out.flush();
	             out.close();
	             out = null;  
	             
	             //no need to register these with mediascanner as these are internal gifs , the workaround for the gifs with a black frame as the first frame
	          
	           } catch(Exception e) {
	               Log.e("copy clipart ERROR", e.toString());
	               e.printStackTrace();
	           }       
	       }
	   } //end copyGIF16
		
} //end async task
	 
    private void LookForAPKExpFiles() {
    
      /**
       * Before we do anything, are the files we expect already here and
       * delivered (presumably by Market) For free titles, this is probably
       * worth doing. (so no Market request is necessary)
       */
      if (!expansionFilesDelivered()) { //if files are not there and/or not the right size, we need to download them
    	  
    	  //ok we know that at least one of the APKExp files doesn't exist but now we need to find out which ones are missing so we know which to unzip later
    	  
    	  String packageName = this.getPackageName();
       	   
       	  APKExpansionPathMain = Helpers.getExpansionAPKFileName(this, true, APKExpMainVersion); //just the name, NOT the full path!
       	  APKExpansionPathPatch = Helpers.getExpansionAPKFileName(this, false, APKExpPatchVersion);
       	   
          File root = Environment.getExternalStorageDirectory();
          APKExpansionPathMainFile = new File(root.toString() + EXP_PATH + packageName + "/" + APKExpansionPathMain);
          APKExpansionPathPatchFile = new File(root.toString() + EXP_PATH + packageName + "/" + APKExpansionPathPatch);
        	  
    	  if (!APKExpansionPathMainFile.exists()) {
    		  	editor = prefs.edit(); //let's write the preference that we need to unzip the files again because a new one was downloaded
       	      	editor.putBoolean("mainAPKUnzippedPref", false); //to do for now, we'll unzip both but perhaps this is a more elegant way to unzip only the new one?
       	      	editor.commit();
       	      	NumDownloadsRequired++;
       	      	Log.v("PixelAnimate2","Main download required, total downloads = " + String.valueOf(NumDownloadsRequired));
    	  }
    	  
    	  if (!APKExpansionPathPatchFile.exists()) {
    		  	editor = prefs.edit(); //let's write the preference that we need to unzip the files again because a new one was downloaded
       	    	editor.putBoolean("patchAPKUnzippedPref", false);
       	    	editor.commit();
       	    	NumDownloadsRequired++;
       	    	Log.v("PixelAnimate2","Patch downloads required, total downloads =" + String.valueOf(NumDownloadsRequired));
    	  }
        	  
        	  LoadGridView(false); //let's load this so the user can interact with the assets file while the APK Expansion are downloading
        	  initializeDownloadUI();
              try {
                  Intent launchIntent = MainActivity.this
                          .getIntent();
                  Intent intentToLaunchThisActivityFromNotification = new Intent(
                  		MainActivity
                          .this, MainActivity.this.getClass());
                  intentToLaunchThisActivityFromNotification.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                          Intent.FLAG_ACTIVITY_CLEAR_TOP);
                  intentToLaunchThisActivityFromNotification.setAction(launchIntent.getAction());

                  if (launchIntent.getCategories() != null) {
                      for (String category : launchIntent.getCategories()) {
                          intentToLaunchThisActivityFromNotification.addCategory(category);
                      }
                  }

                  // Build PendingIntent used to open this activity from
                  // Notification
                  PendingIntent pendingIntent = PendingIntent.getActivity(
                          MainActivity.this,
                          0, intentToLaunchThisActivityFromNotification,
                          PendingIntent.FLAG_UPDATE_CURRENT);
                  // Request to start the download
                  int startResult = DownloaderClientMarshaller.startDownloadServiceIfRequired(this,
                          pendingIntent, PIXELDownloaderService.class);

                  if (startResult != DownloaderClientMarshaller.NO_DOWNLOAD_REQUIRED) {
                      // The DownloaderService has started downloading the files,
                      // show progress
                      initializeDownloadUI();
                      return;
                  }
                  else {
                  	// otherwise, download not needed so we fall through to
                  	LoadGridView(false);
                  	//gridview.setOnItemClickListener(MainActivity.this);
                      //gridview.setOnItemLongClickListener(MainActivity.this);
                  }
                    // starting the movie
              } catch (NameNotFoundException e) {
                  Log.e(LOG_TAG, "Cannot find own package! MAYDAY!");
                  e.printStackTrace();
              }

          } else { //the files are already there so let's just validate they are correct and unzipped
        	  //initializeDownloadUI();
        	 // validateXAPKZipFiles(); //on this post execute, we'll call the unzip routine
        	  
        	  CheckAndUnzipAPKExp(); //let's check if they were unzipped before and if not, unzip them
            
          } 
    }
	    
    private void writeAPKSizesToPrefs() {
    	  if (expansionFilesDelivered()) {
       	   
       	   String packageName = this.getPackageName();
             
              if (Environment.getExternalStorageState()
                    .equals(Environment.MEDIA_MOUNTED)) {
                  // Build the full path to the app's expansion files
           	   
           	   Log.v("PixelAnimate2","Went to APK section in before ContinueonCreate()");
           	   APKExpansionPathMain = Helpers.getExpansionAPKFileName(this, true, APKExpMainVersion); //just the name, NOT the full path!
           	   APKExpansionPathPatch = Helpers.getExpansionAPKFileName(this, false, APKExpPatchVersion);
           	   
               File root = Environment.getExternalStorageDirectory();
               APKExpansionPathMainFile = new File(root.toString() + EXP_PATH + packageName + "/" + APKExpansionPathMain);
               APKExpansionPathPatchFile = new File(root.toString() + EXP_PATH + packageName + "/" + APKExpansionPathPatch);
                  	  
           	 
       	       if (APKExpansionPathMainFile.exists()) {
       				 APKExpMainFileSizeSDCard = APKExpansionPathMainFile.length();
       				 editor = prefs.edit(); //let's write the preference that we need to unzip the files again because a new one was downloaded
       				 editor.putLong("APKExpMainFileSizePref", APKExpMainFileSizeSDCard); //add the actual size here
       				 editor.commit();
       				 Log.v("PixelAnimate2","before ContinueonCreate(), wrote APK Main File size");
       			}	
       		
       		   if (APKExpansionPathPatchFile.exists()) {
       				APKExpPatchFileSizeSDCard = APKExpansionPathPatchFile.length();
       				editor = prefs.edit(); //let's write the preference that we need to unzip the files again because a new one was downloaded
       				editor.putLong("APKExpPatchFileSizePref", APKExpPatchFileSizeSDCard); //add the actual size here
       				editor.commit();
       				Log.v("PixelAnimate2","before ContinueonCreate(), wrote APK Patch File size");
       				
       			}
              }  
          }
    	  continueOnCreate();
    }
    
    private void continueOnCreate() {
         
         //******** now we wait for the user to do something **************
    	
    	LoadGridView(false);
         
    }
    
    //this class is used to unzip the APK Expansion files into the pixel folder structure
    private class unZipAsync extends AsyncTask<Void, Integer, Void>{
		 
	     int progress_status;
	     private String _zipFileMain; 
	     private String _zipFilePatch;
	     private int _zipFileMainNumFiles;
	     private int _zipFilePatchNumFiles;
	     private String _unzipLocation; 
	     
	     boolean _mainAPK;

	      public unZipAsync (String zipFileMain, String zipFilePatch, int zipFileMainNumFiles, int zipFilePatchNumFiles, String unzipLocation) { 
	    	 _zipFileMain = zipFileMain; 
	    	 _zipFilePatch = zipFilePatch; 
	    	 _zipFileMainNumFiles = zipFileMainNumFiles;
	    	 _zipFilePatchNumFiles = zipFilePatchNumFiles;
	        _unzipLocation = unzipLocation;

	        _dirChecker(""); 
	      } 

	     
	      
	     @Override
	  protected void onPreExecute() {
		   // update the UI immediately after the task is executed
		   super.onPreExecute();
		   
		   //to do don't do the pop up here and instead leverage the same layout that the download uses
		   //mainAPKUnzipped = prefs.getBoolean("mainAPKUnzippedPref", false);
		   //patchAPKUnzipped = prefs.getBoolean("patchAPKUnzippedPref", false);
		   
		  /* 
		   * mainAPKUnzipped = false;
		   patchAPKUnzipped = false;*/
		   
		   progress = new ProgressDialog(MainActivity.this);
		   
		   int MaxValueTotal = 0;
		   int maxValue1 = 0;
		   int maxValue2 = 0;
		   
		   if (!mainAPKUnzipped) {
		   //if (!prefs.getBoolean("mainAPKUnzippedPref", false)) {
			    maxValue1 = _zipFileMainNumFiles;
		   }
		   else {
			   maxValue1 = 0;
		   }
		   
		   if (!patchAPKUnzipped) {
		   //if (!prefs.getBoolean("patchAPKUnzippedPref", false))	{
			    maxValue2 = _zipFilePatchNumFiles;
		   }
		   else {
			   maxValue2 = 0;
		   }
		   
		   MaxValueTotal = maxValue1 + maxValue2;
		   progress.setMax(MaxValueTotal);
		   
	       //progress.setTitle(getString(R.string.oneTimeCopyTitle));
	       progress.setTitle("New Art");
	      // progress.setMessage(getString(R.string.oneTimeCopyMessage));
	       progress.setMessage("Adding New Art");
	       progress.setCancelable(false);
		   progress.setIcon(R.drawable.ic_action_warning);
	       progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
	       progress.show();
	       progress_status = 0;
	  }
	      
	  @Override
	  protected Void doInBackground(Void... params) {
		  
		  // create target location folder if not exist
		  _dirChecker(_unzipLocation);
		  
		  if (!mainAPKUnzipped) {
		 // if (!prefs.getBoolean("mainAPKUnzippedPref", false)) {	  
	        try {
	            FileInputStream fin = new FileInputStream(_zipFileMain);
	            ZipInputStream zin = new ZipInputStream(fin);
	            ZipEntry ze = null;
	            while ((ze = zin.getNextEntry()) != null) {
	            	//i++;
	                // create dir if required while unzipping
	                if (ze.isDirectory()) {
	                	_dirChecker(ze.getName());
	                } else {
	                    FileOutputStream fout = new FileOutputStream(
	                    _unzipLocation + "/" + ze.getName());
	                    BufferedOutputStream bufout = new BufferedOutputStream(fout);
	                    byte[] buffer = new byte[1024];
	                    int read = 0;
	                    while ((read = zin.read(buffer)) != -1) {
	                        bufout.write(buffer, 0, read);
	                    }
	                    publishProgress(4);
	                    zin.closeEntry();
	                    bufout.close();
	                    fout.close();
	                }
	            }
	            zin.close();
	            editor = prefs.edit(); //let's write the preference that we unzipped the files successfully
	     	    editor.putBoolean("mainAPKUnzippedPref", true);
	     	    editor.commit();
	     	    Log.v("PixelAnimate2", "Unzipped Main APK Expansion");
	            
	           
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        
	        
		  }    
	        
	     if (!patchAPKUnzipped) {
	     //if (!prefs.getBoolean("patchAPKUnzippedPref", false)) {	  	
	        try {
	            FileInputStream fin = new FileInputStream(_zipFilePatch);
	            ZipInputStream zin = new ZipInputStream(fin);
	            ZipEntry ze = null;
	            while ((ze = zin.getNextEntry()) != null) {
	                if (ze.isDirectory()) {
	                	_dirChecker(ze.getName());
	                } else {
	                    FileOutputStream fout = new FileOutputStream(
	                    _unzipLocation + "/" + ze.getName());
	                    BufferedOutputStream bufout = new BufferedOutputStream(fout);
	                    byte[] buffer = new byte[1024];
	                    int read = 0;
	                    while ((read = zin.read(buffer)) != -1) {
	                        bufout.write(buffer, 0, read);
	                    }
	                    publishProgress(4);
	                    zin.closeEntry();
	                    bufout.close();
	                    fout.close();
	                }
	            }
	            zin.close();
	            editor = prefs.edit(); //let's write the preference that we unzipped the files successfully
	     	    editor.putBoolean("patchAPKUnzippedPref", true);
	     	    editor.commit();
	     	    Log.v("PixelAnimate2", "Unzipped Patch APK Expansion");
	           
	            
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        
	       
	    } 
			
	   return null;
	  }
	  
	  @Override
	  protected void onProgressUpdate(Integer... values) {
	   super.onProgressUpdate(values);
	   progress.incrementProgressBy(1);
	  }
	   
	  @Override
	  protected void onPostExecute(Void result) {
	   super.onPostExecute(result);
	   progress.dismiss(); //we're done so now hide the progress update box
	   
	   if (mDashboard != null) {
		   mDashboard.setVisibility(View.GONE);  //hide this guy as it may have been turned on from the download
	   }
	   
	   showToast(getString(R.string.newArtAdded));

	   // now we've set that the expansion files have been unziped so we don't keep unzipping everytime
	   writeAPKSizesToPrefs();   
	  }
	  
	  private void _dirChecker(String dir) { 
	        File f = new File(_unzipLocation + dir); 

	        if(!f.isDirectory()) { 
	          f.mkdirs(); 
	        } 
	      } 
	  
    }  
	  
		

   /* private static String[] getAPKExpansionFiles(Context ctx, int mainVersion,
          int patchVersion) {
        String packageName = ctx.getPackageName();
        Vector<String> ret = new Vector<String>();
        if (Environment.getExternalStorageState()
              .equals(Environment.MEDIA_MOUNTED)) {
            // Build the full path to the app's expansion files
            File root = Environment.getExternalStorageDirectory();
            File expPath = new File(root.toString() + EXP_PATH + packageName);

            // Check that expansion file path exists
            if (expPath.exists()) {
                if ( mainVersion > 0 ) {
                    String strMainPath = expPath + File.separator + "main." +
                            mainVersion + "." + packageName + ".obb";
                    File main = new File(strMainPath);
                    if ( main.isFile() ) {
                            ret.add(strMainPath);
                    }
                }
                if ( patchVersion > 0 ) {
                    String strPatchPath = expPath + File.separator + "patch." +
                            //mainVersion + "." + packageName + ".obb"; //found a Bug in Android's code, should be patchVersion
                            patchVersion + "." + packageName + ".obb"; 
                    File main = new File(strPatchPath);
                    if ( main.isFile() ) {
                            ret.add(strPatchPath);
                    }
                }
            }
        }
        String[] retArray = new String[ret.size()];
        ret.toArray(retArray);
        return retArray;
    }*/
 
    
//***** classes for APK expansion downloader *******
    
    /**
     * Connect the stub to our service on start.
     */
    @Override
    protected void onStart() {
        if (null != mDownloaderClientStub) {
            mDownloaderClientStub.connect(this);
        }
        super.onStart();
    }

    /**
     * Disconnect the stub from our service on stop
     */
    @Override
    protected void onStop() {
        if (null != mDownloaderClientStub) {
            mDownloaderClientStub.disconnect(this);
        }
        super.onStop();
    }

    /**
     * Critical implementation detail. In onServiceConnected we create the
     * remote service and marshaler. This is how we pass the client information
     * back to the service so the client can be properly notified of changes. We
     * must do this every time we reconnect to the service.
     */
    @Override
    public void onServiceConnected(Messenger m) {
        mRemoteService = DownloaderServiceMarshaller.CreateProxy(m);
        mRemoteService.onClientUpdated(mDownloaderClientStub.getMessenger());
    }

    /**
     * The download state should trigger changes in the UI --- it may be useful
     * to show the state as being indeterminate at times. This sample can be
     * considered a guideline.
     */
    @Override
    public void onDownloadStateChanged(int newState) {
        
    	setState(newState);
        boolean showDashboard = true;
        boolean showCellMessage = false;
        boolean paused;
        boolean indeterminate;
        switch (newState) {
            case IDownloaderClient.STATE_IDLE:
                // STATE_IDLE means the service is listening, so it's
                // safe to start making calls via mRemoteService.
                paused = false;
                indeterminate = true;
                break;
            case IDownloaderClient.STATE_CONNECTING:
            case IDownloaderClient.STATE_FETCHING_URL:
                showDashboard = true;
                paused = false;
                indeterminate = true;
                break;
            case IDownloaderClient.STATE_DOWNLOADING:
                paused = false;
                showDashboard = true;
                indeterminate = false;
                break;

            case IDownloaderClient.STATE_FAILED_CANCELED:
            case IDownloaderClient.STATE_FAILED:
            case IDownloaderClient.STATE_FAILED_FETCHING_URL:
            case IDownloaderClient.STATE_FAILED_UNLICENSED:
                paused = true;
                showDashboard = false;
                indeterminate = false;
                if (mDashboard != null) {
         		   mDashboard.setVisibility(View.GONE);  //hide this guy as it may have been turned on from the download
         	    }
                LoadGridView(false); //the download failed so let's not forget to load the gridview or the user will not be able to click anything
                break;
            case IDownloaderClient.STATE_PAUSED_NEED_CELLULAR_PERMISSION:
            case IDownloaderClient.STATE_PAUSED_WIFI_DISABLED_NEED_CELLULAR_PERMISSION:
                showDashboard = false;
                paused = true;
                indeterminate = false;
                showCellMessage = true;
                LoadGridView(false);
                break;

            case IDownloaderClient.STATE_PAUSED_BY_REQUEST:
                paused = true;
                indeterminate = false;
                LoadGridView(false);
                break;
            case IDownloaderClient.STATE_PAUSED_ROAMING:
            case IDownloaderClient.STATE_PAUSED_SDCARD_UNAVAILABLE:
                paused = true;
                indeterminate = false;
                LoadGridView(false);
                break;
            case IDownloaderClient.STATE_COMPLETED: //IMPORTANT: we can go here twice because there are two files to download and hence we need to handle for that
            	DLCounter++;
            	Log.v("PixelAnimate2", "successfully downloaded an APK Expansion File, download number " + DLCounter);
            	showDashboard = false;
                paused = false;
                indeterminate = false;
                //since we now have just downloaded new files, we'll need to tell the app to unzip the new obb files
                
                //validateXAPKZipFiles(); //we'll load the gridview after validation
         	    //what we can do here to prevent a double call is first check and know how many files need to be re-downloaded
         	    if (DLCounter == NumDownloadsRequired) { //we do this because the unzip async task can only run once and cannot run sequentially
         	    	CheckAndUnzipAPKExp();
         	    	DLCounter = 0;
         	    }
                return;
            default:
                paused = true;
                indeterminate = true;
                showDashboard = true;
        }
        int newDashboardVisibility = showDashboard ? View.VISIBLE : View.GONE;
        if (mDashboard.getVisibility() != newDashboardVisibility) {
            mDashboard.setVisibility(newDashboardVisibility);
        }
        int cellMessageVisibility = showCellMessage ? View.VISIBLE : View.GONE;
        if (mCellMessage.getVisibility() != cellMessageVisibility) {
            mCellMessage.setVisibility(cellMessageVisibility);
        }

        mPB.setIndeterminate(indeterminate);
        setButtonPausedState(paused);
    }

    /**
     * Sets the state of the various controls based on the progressinfo object
     * sent from the downloader service.
     */
    @Override
    public void onDownloadProgress(DownloadProgressInfo progress) {
        mAverageSpeed.setText(getString(R.string.kilobytes_per_second,
                Helpers.getSpeedString(progress.mCurrentSpeed)));
        mTimeRemaining.setText(getString(R.string.time_remaining,
                Helpers.getTimeRemaining(progress.mTimeRemaining)));

        progress.mOverallTotal = progress.mOverallTotal;
        mPB.setMax((int) (progress.mOverallTotal >> 8));
        mPB.setProgress((int) (progress.mOverallProgress >> 8));
        mProgressPercent.setText(Long.toString(progress.mOverallProgress
                * 100 /
                progress.mOverallTotal) + "%");
        mProgressFraction.setText(Helpers.getDownloadProgressString
                (progress.mOverallProgress,
                        progress.mOverallTotal));
    }

   /* @Override
    protected void onDestroy() {
        this.mCancelValidation = true;
        super.onDestroy();
    }*/
    
    
//*************************************************
	    
   public static void copyFile(InputStream in, OutputStream out) throws IOException {
	        byte[] buffer = new byte[1024];
	        int read;
	        while((read = in.read(buffer)) != -1){
	          out.write(buffer, 0, read);
	        }
	    }
	
	private static void loadRGB565() {
	 	   
		try {
   			int n = BitmapInputStream.read(BitmapBytes, 0, BitmapBytes.length); // reads
   																				// the
   																				// input
   																				// stream
   																				// into
   																				// a
   																				// byte
   																				// array
   			Arrays.fill(BitmapBytes, n, BitmapBytes.length, (byte) 0);
   		} catch (IOException e) {
   			e.printStackTrace();
   		}

   		int y = 0;
   		for (int i = 0; i < frame_.length; i++) {
   			frame_[i] = (short) (((short) BitmapBytes[y] & 0xFF) | (((short) BitmapBytes[y + 1] & 0xFF) << 8));
   			y = y + 2;
   		}
   }
	
    protected void onDestroy() {
    //	this.unregisterReceiver(receiver);
    	this.mCancelValidation = true;  //this was added from the apk downloader service
        super.onDestroy();
       // mThread.close();
       
        final GridView grid = gridview;
        final int count = grid.getChildCount();
        ImageView v = null;
        for (int i = 0; i < count; i++) {
            v = (ImageView) grid.getChildAt(i);
            ((BitmapDrawable) v.getDrawable()).setCallback(null);
        }
        
        if (matrix_ == null) {  
    	     if (connectTimer != null) connectTimer.cancel();  //if user closes the program, need to kill this timer or we'll get a crash
        }
        
       //kill the slideshow timers if they are open
       stopTimers();
    }
    
    public void LoadGridView (boolean deletePNG_) {
  	  
  	  File favPNGDirector;
  	  File favGIFDirector;
  	  File targetDirector;
  	  File PNGtargetDirector;
  	  File UserPNGtargetDirector;
  	  File UserGIFtargetDirector;
  	  File PNG64targetDirector;
  	  File GIF64targetDirector;
  	  File PNG16targetDirector;
 	  File GIF16targetDirector;
  	  
  	  int a = 0;
  	  int f = 0;
  	  int b = 0;
  		  
  		String ExternalStorageDirectoryPath = Environment
  	   .getExternalStorageDirectory().getAbsolutePath();
  		
  		if (deletePNG_) {
  			PNGPathFile.delete();  
  			System.out.println("Moved PNG to favpng and deleted the old one...");
  		}
  		
  	   String favPNGtargetPath = FavPNGPath;
  	   favPNGDirector = new File(favPNGtargetPath);
  	   
  	   String favGIFtargetPath = FavGIFPath;
  	   favGIFDirector = new File(favGIFtargetPath);
  	   
  	   String targetPath = GIFPath;
  	   targetDirector = new File(targetPath);
  	   
  	   String PNGtargetPath = PNGPath;
  	   PNGtargetDirector = new File(PNGtargetPath);
  	   
  	   String UserPNGtargetPath = userPNGPath;
  	   UserPNGtargetDirector = new File(UserPNGtargetPath);
  	   
  	   String UserGIFtargetPath = userGIFPath;
  	   UserGIFtargetDirector = new File(UserGIFtargetPath);
  	   
  	   String PNG64targetPath = PNG64Path;
  	   PNG64targetDirector = new File(PNG64targetPath);
  	   
  	   String GIF64targetPath = GIF64Path;
  	   GIF64targetDirector = new File(GIF64targetPath);
  	   
  	   String PNG16targetPath = PNG16Path;
	   PNG16targetDirector = new File(PNG16targetPath);
	   
	   String GIF16targetPath = GIF16Path;
	   GIF16targetDirector = new File(GIF16targetPath);
  	   
  	   if (favPNGDirector.exists()) {
	    	   File FavPNGDirectory = new File(FavPNGPath);
	    	   if (FavPNGDirectory.list().length>0) {  //does the favorites PNG folder have any favorites in it that the user has picked?
	   				System.out.println("FavPNG has files");
	   		    	FavPNGHasFiles = true; 
		   		} 
	    	   else {
		   			System.out.println("FavPNG is empty");
		   		}
  	   }
  	   else {
  		   FavPNGHasFiles = false; 
  	   }
  	   
	  if (favGIFDirector.exists()) {
	  	   File FavGIFDirectory = new File(FavGIFPath);
	  	   if (FavGIFDirectory.list().length>0) {  //does the favorites PNG folder have any favorites in it that the user has picked?
	 				System.out.println("FavGIF has files");
	 				FavGIFHasFiles = true; 
		   		} 
	  	   else {
		   			System.out.println("FavGIF is empty");
		   		}
	   }
	   else {
		   FavGIFHasFiles = false; 
	   }
  	   
  	   //myTaskAdapter.clear(); //TO DO add this to the sharing piece?
  	 
  	   items.clear(); //we need to clear the string array
  	   Arrays.fill(SlideShowArray, null); //empty the array
  	   Arrays.fill(SlideShowArrayFavs, null); //empty the array
  	   Arrays.fill(SlideShowArrayAll, null); //empty the array
  	   Arrays.fill(SlideShowGIFFavs,null);
  	   
  	   //we load in order here so favs and user supplied goes first
  	   
  	   //*********** FAVORITES **************
	      if (gifonly_ == false && favPNGDirector.exists()) {  //note we didn't check if favPNG is empty, probably should add that
	 	    	   File[] files = favPNGDirector.listFiles(new FilenameFilter() {
	 	   		    public boolean accept(File dir, String name) {
	 	   		        return name.toLowerCase().endsWith(".png") || name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".jpeg");
	 	   		    }
	 	   			});
	 	    	if (files != null) {  //don't go here if there are no files in there
	 		   	   for (File file : files) {
	 		   		items.add(file.getAbsolutePath());
	 		   	    SlideShowArrayFavs[f] = file.getAbsolutePath(); //array starts at 0
	 		   	    f++;
	 		   	    SlideShowArrayAll[a] = file.getAbsolutePath(); //array starts at 0
			   	    a++;
	 		   	   
	 		   	   }
	 	    	}
	 	   	}
      
      
	      if (favGIFDirector.exists()) { //fav gif content, could be any size
		    	   File[] files = favGIFDirector.listFiles(new FilenameFilter() {
		   		    public boolean accept(File dir, String name) {
		   		    	return name.toLowerCase().endsWith(".gif") || name.toLowerCase().endsWith(".png"); //can be either png thumbnails or gif (gifs could have came from user gifs)
		   		    }
			   		});
		    	if (files != null) {     
				   	   for (File file : files) {
				   		items.add(file.getAbsolutePath());
				   		SlideShowGIFFavs[b] = file.getAbsolutePath(); //array starts at 0, path is /pixel/favgif/
				   		b++;
				   	   }
		    	}
		   }
	      
	  	 //*********** USER SUPPLIED ******************	 
		  if (gifonly_ == false && UserPNGtargetDirector.exists()) {  //user png content, could be any size
	    	   File[] files = UserPNGtargetDirector.listFiles(new FilenameFilter() {
	   		    public boolean accept(File dir, String name) {
	   		        return name.toLowerCase().endsWith(".png") || name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".jpeg");
	   		    }
	   			});
	   	   
		   	   for (File file : files) {
		   		//items.add(file.getAbsolutePath());
		   		if (files != null) {      
		   				items.add(file.getAbsolutePath());
			   			SlideShowArrayAll[a] = file.getAbsolutePath(); //array starts at 0
				   	    a++;
			   	 }
		   	  }
	   	   }
			  
		  if (UserGIFtargetDirector.exists()) { //user gif content, could be any size
	    	   File[] files = UserGIFtargetDirector.listFiles(new FilenameFilter() {
	   		    public boolean accept(File dir, String name) {
	   		        return name.toLowerCase().endsWith(".gif") ;
	   		    }
		   		});
	    	if (files != null) {     
		   	   for (File file : files) {
		   		items.add(file.getAbsolutePath());
		   	   }
	    	}   
  	   }
		  
		  
		  //******** Only load if SUPER PIXEL *************
		  
		  if ((currentResolution == 128 || currentResolution == 64) && GIF64targetDirector.exists()) { //gif 64x64 content which we know by current resolution because we could have a super pixel or adafruit built panels, only show if 64x64 led matrix is picked
		 
	    	   File[] files = GIF64targetDirector.listFiles(new FilenameFilter() {
	   		    public boolean accept(File dir, String name) {
	   		        return name.toLowerCase().endsWith(".gif") || name.toLowerCase().endsWith(".png");
	   		    }
	   			});
	    	   
	    		if (files != null) {  
			   	   for (File file : files) {
			   		items.add(file.getAbsolutePath());
			   	   }
	    		}
		   }
		  
		  if ((currentResolution == 128 || currentResolution == 64) && gifonly_ == false && PNG64targetDirector.exists()) { //png 64x64 content but don't show for 32x32
		
	    	   File[] files = PNG64targetDirector.listFiles(new FilenameFilter() {
	   		    public boolean accept(File dir, String name) {
	   		        return name.toLowerCase().endsWith(".png") || name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".jpeg");
	   		    }
	   			});
	    	   
	    	   if (files != null) {  
	   	   
			   	   for (File file : files) {
			   		   items.add(file.getAbsolutePath());
			   		   SlideShowArrayAll[a] = file.getAbsolutePath(); //array starts at 0
				   	   a++;
			   	   }
		   	   
	    	   }
		   }
  		  
		  //*********** 32x32 GIFs and PNG ********** but don't load these if we have 32x16 because 32x32 will not look good on 32x16
		  
		  if (only64_ == false && currentResolution != 16 && targetDirector.exists()) {  //gif or png, this is the gif directory 32x32 content
	  		  File[] files = targetDirector.listFiles(new FilenameFilter() {
	  		    public boolean accept(File dir, String name) {
	  		        return name.toLowerCase().endsWith(".gif") || name.toLowerCase().endsWith(".png");
	  		    }
	  		});
	  		
		  		if (files != null) {  
		  	   
			    	   for (File file : files) {     //the Android emulator was crashing here, weird
			    		   items.add(file.getAbsolutePath());
			    	   }
		  		}
		    }
  		
  	   
	   if (only64_ == false && currentResolution != 16 && gifonly_ == false && PNGtargetDirector.exists()) { //png 32x32 content 
		   File[] files = PNGtargetDirector.listFiles(new FilenameFilter() {  //PNGFiles is a file array / list?, if we only want a slideshow with the PNGs
  		   
 		    public boolean accept(File dir, String name) {
 		        return name.toLowerCase().endsWith(".png") || name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".jpeg");
 		    }
 			});
		   
			if (files != null) {  
		   
		   	   for (File file : files) {
		   		   	items.add(file.getAbsolutePath());
			   		SlideShowArrayAll[a] = file.getAbsolutePath(); //array starts at 0
			   	    a++;
		   	   }
		   }
	   }
	   
	   //****** Lastly only load  32x16 art if we have a 32x16 ************
	   
	   if (currentResolution == 16 && GIF16targetDirector.exists()) { //gif 64x64 content which we know by current resolution because we could have a super pixel or adafruit built panels, only show if 64x64 led matrix is picked
			 
		    	   File[] files = GIF16targetDirector.listFiles(new FilenameFilter() {
		   		    public boolean accept(File dir, String name) {
		   		        return name.toLowerCase().endsWith(".gif") || name.toLowerCase().endsWith(".png");
		   		    }
		   			});
		    	   
		    		if (files != null) {  
				   	   for (File file : files) {
				   		items.add(file.getAbsolutePath());
				   	   }
		    		}
			   }
			  
		  if (currentResolution == 16 && gifonly_ == false && PNG16targetDirector.exists()) { //png 64x64 content but don't show for 32x32
		
	    	   File[] files = PNG16targetDirector.listFiles(new FilenameFilter() {
	   		    public boolean accept(File dir, String name) {
	   		        return name.toLowerCase().endsWith(".png") || name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".jpeg");
	   		    }
	   			});
	    	   
	    	   if (files != null) {  
	   	   
			   	   for (File file : files) {
			   		   items.add(file.getAbsolutePath());
			   		   SlideShowArrayAll[a] = file.getAbsolutePath(); //array starts at 0
				   	   a++;
			   	   }
	    	   }
		   }
	   
	   
	   SlideShowLengthAll = a;   //actually it's z-1 but we compensate for this later
	   SlideShowLengthFavs = f;   //actually it's z-1 but we compensate for this later
	   SlideShowLengthGIFFavs = b;
	  
	   list = new ListAdapter(this, items);
	   gridview.setAdapter(list);
	   gridview.setKeepScreenOn(false);
	   //??? added these two lines, did it break something?
	   gridview.setOnItemClickListener(MainActivity.this);
       gridview.setOnItemLongClickListener(MainActivity.this);
  	 }
    
public boolean onItemLongClick(final AdapterView<?> parent, View v, final int position, long id) {  
	 	stopTimers(); //adding this here seems to have fixed a lot of crashing
	 	
	 	//let's put into interactive mode if we have a matrix found and we have PIXEL V2 or higher
	 	if (matrix_ != null) {
    		  if (pixelHardwareID.substring(0,4).equals("PIXL")) {
    			  try {
						matrix_.interactive();
					} catch (ConnectionLostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			}
	 	  }  
	 	
    	gridViewPosition = position;
    	originalImagePath = (String) parent.getItemAtPosition(position);
    	Boolean showFavoriteButton = false;
        Boolean removeFavorite = false;
        Boolean showFavoriteGIFButton = false;
        Boolean removeFavoriteGIF = false;
    	String FavoriteButonText = getString(R.string.FavoriteText);
    	
    	String PixelDirName_ = Pixel.getPixelDir(originalImagePath);
    	
    	 if (PixelDirName_.equals("gif")) {
	        	decodedDirPath = GIFPath + "decoded";
	        	gifPath_ = GIFPath;
	        	showFavoriteGIFButton = true;
	      }
	      else if (PixelDirName_.equals("usergif")) {
	        	decodedDirPath = userGIFPath + "decoded";
	        	gifPath_ = userGIFPath;
	        	showFavoriteGIFButton = true;
	       }
	      else if (PixelDirName_.equals("gif64")) {
	        	decodedDirPath = GIF64Path + "decoded";
	        	gifPath_ = GIF64Path;
	        	showFavoriteGIFButton = true;
	      }
    	 
	      else if (PixelDirName_.equals("gif16")) {
	        	decodedDirPath = GIF16Path + "decoded";
	        	gifPath_ = GIF16Path;
	        	showFavoriteGIFButton = true;
	      }
	        
	      else if (PixelDirName_.equals("favgif")) {
	        	decodedDirPath = FavGIFPath + "decoded";
	        	gifPath_ = FavGIFPath;  //not used?
	        	removeFavoriteGIF = true;
	        	FavoriteButonText = getString(R.string.UnFavoriteText);
	      }
    	  
	      else if (PixelDirName_.equals("favpng")) {
	        	showFavoriteButton = false;
	        	removeFavorite = true;
	        	FavoriteButonText = getString(R.string.UnFavoriteText);
	      }
    	 
	      else if (PixelDirName_.equals("png")) {
	    	  	showFavoriteButton = true;
	        	FavoriteButonText = getString(R.string.FavoriteText);
	      }
    	 
	      else if (PixelDirName_.equals("png64")) {
	    	  	showFavoriteButton = true;
	        	FavoriteButonText = getString(R.string.FavoriteText);
	      }
    	 
	      else if (PixelDirName_.equals("userpng")) {
	    	  	showFavoriteButton = true;
	        	FavoriteButonText = getString(R.string.FavoriteText);
	      }
    	 
    	 //we can give the user the option to favorite if coming from userpng, png or png64, unfavorite if coming from favpng
    	

    		 AlertDialog.Builder LongTapPrompt = new AlertDialog.Builder(this);
    		 LongTapPrompt.setTitle(getString(R.string.LongTapActionTitle));
    		 LongTapPrompt.setMessage("");
    		 LongTapPrompt.setIcon(R.drawable.ic_action_new_event);
    		 LongTapPrompt.setPositiveButton(getString(R.string.LongTapActionWrite),
    		   new DialogInterface.OnClickListener() {

    		    public void onClick(DialogInterface dialog, int which) {  //WRITE
    		     
    		    	if (matrix_ != null) { 
				  		
    		    		if (!pixelHardwareID.substring(0,4).equals("PIXL")) { //add the kiosk mode firmware here
    		    			showToast(getString(R.string.cannotWriteMsg));
    		    		}
    		    		
    		    		//********we need to reset everything because the user could have been already running an animation
				  	     x = 0;
  	     
				  	    //stopTimers(); //need the kill all timers that were running, already had this at the top
			    		  
				    	imagePath = (String) parent.getItemAtPosition(position);
				    	
				    	originalImagePath = (String) parent.getItemAtPosition(position);
				    	
				        filename_no_extension = Pixel.getNameOnly(originalImagePath);
				        
				        selectedFileName = filename_no_extension; //not really good coding but selected file name is used elsewhere so we need this here
				      
				        extension_ = Pixel.getExtension(originalImagePath);
				        
				        // TO DO check this part of code, looks like I was duplicating this same block below so just delete the duplicate but make sure everything is still working
				        
				        if (extension_.equals("png")) {  //then we use the thumbnail, we just need to rename the image path to a gif
				       	
				        	//now we need to check that filename/decoded/filename.rgb565 exists
				        	
				        	File pngRGB565path = new File(gifPath_ + "decoded/" + filename_no_extension + ".rgb565"); //sdcard/pixel/gifs/decoded/tree.rgb565
				        	if (!pngRGB565path.exists()) { //if it doesn't exist
				        		
				        		//ok not there so let's see if the original gif is there as decoded may have been deleted because the led panel changed
				        		File originalGIF = new File(gifPath_ + "gifsource/" + filename_no_extension + ".gif"); //sdcard/pixel/gifs/gifsource/tree.rgb565
				        		if (originalGIF.exists()) { 
				        			//we've got the original gif so now let's decode it
				        			 imagePath = gifPath_ + "gifsource/" + filename_no_extension + ".gif";
				        			 gifView.setGif(imagePath);  //just sets the image , no decoding, decoding happens in the animateafterdecode method
							     	 animateAfterDecode(0);
				        		}
				        		else { //well we tried, no original gif so we'll treat it as a png
						            	//there's no rgb565 and we only have a single frame png so let's just send this single frame png to pixel
							        	
						        		//it's  not there so let's check the original gifs folder, if it's in there, then treat it like a gif and decode
						        		
						        		imagePath = originalImagePath;
						        		
						        		if (kioskMode_ == false) {
							        		try {
							        			matrix_.interactive();
												matrix_.writeFile(1); //since it's only one frame , doesn't matter what fps is
						    		        	WriteImagetoMatrix();
						    		        	matrix_.playFile();
											} catch (ConnectionLostException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
						        		}
						        		else {
						        			try {
							        			showToast(getString(R.string.NoWritinginKiosk));
						        				matrix_.interactive();
						    		        	WriteImagetoMatrix();
											} catch (ConnectionLostException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
						        		}
						            }
				        		}
				        	else {  //the rgb565 is there
				        		//gifView.setGif(imagePath);  //this is causing a crash, TO DO figure out why later 
				        		animateAfterDecode(1); //the rgb565 is there so let's run the already decoded animation
						    } 
				      
				    }
				        
				        else if (extension_.equals("jpg") || extension_.equals("jpeg")) {  
				        	imagePath = originalImagePath;
				        	try {
			        			matrix_.interactive();
								matrix_.writeFile(1000);
			        			WriteImagetoMatrix();
			        			matrix_.playFile();
							} catch (ConnectionLostException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				        }
				        
				       else if (extension_.equals("gif")) {  // if it's not a png, then it's a gif so let's animate
				     	   gifView.setGif(imagePath);  //just sets the image , no decoding, decoding happens in the animateafterdecode method
				     	   animateAfterDecode(1);
				       }  
				}
    		    	
	    	 else {
	    		 showToast(getString(R.string.PIXELNotFound));
	    	 }
	    }
	   });

    		 //only show the favorite option if coming from the right area 
    		 if (showFavoriteButton) { 
		    		 
		    		 LongTapPrompt.setNeutralButton(FavoriteButonText, new DialogInterface.OnClickListener() { //FAVORITE
		
		    		  @Override
		    		  public void onClick(DialogInterface dialog, int which) {
		    			  
		    			    
		    				//showToast(getString(R.string.MovingUp));
						        
						        //if the file type was not one of these like a png for example, then we don't care about the decodeddirpath and we don't change it
						     
							extension_ = Pixel.getExtension(originalImagePath);
							
							//***** let's check & create the needed directories on the sd card first
							
							File FavPNGPath_ = new File(FavPNGPath); //let's create the favoriate dir if it's not there already
				    		 if (!FavPNGPath_.exists()) {  //create the dir if it does not exist
				    			 FavPNGPath_.mkdirs();
							  }
				    		 
				    		File FavGIFPath_ = new File(FavGIFPath); //let's create the favoriate dir if it's not there already
				    		if (!FavGIFPath_.exists()) {  //create the dir if it does not exist
				    			FavGIFPath_.mkdirs();
							}
				    		 
				    		File FavGIFPathDecoded_ = new File(FavGIFPath + "/decoded"); //let's create the favoriate dir if it's not there already
				    		if (!FavGIFPathDecoded_.exists()) {  //create the dir if it does not exist
				    			FavGIFPathDecoded_.mkdirs();
							}
				    		
				    		File FavGIFPathGIFSource_ = new File(FavGIFPath + "/gifsource"); //let's create the favoriate dir if it's not there already
				    		if (!FavGIFPathGIFSource_.exists()) {  //create the dir if it does not exist
				    			FavGIFPathGIFSource_.mkdirs();
							}
				    		
				    		//***************************************************************************
				    		
				    		filename_no_extension = Pixel.getNameOnly(originalImagePath); //get the name of the select file but without the extension
				    		
			    			//may need to put this in the background
				    		//let's check now if the PNG that was favorited is a thumbnail for a gif or if it's realy just a PNG
				    		
				    				InputStream in = null;
				     	            OutputStream out = null;
				     	             
				     	            PNGPathFile = new File(originalImagePath); //this could be a png or gif
						        	if (PNGPathFile.exists()) { 
					     	             try {
					     	            	 
						     	             in = new FileInputStream(originalImagePath);
						     	             out = new FileOutputStream(FavPNGPath + filename_no_extension + "." + extension_); //used to be hard coded to .png
						     	             copyFile(in, out);
						     	             in.close();
						     	             in = null;
						     	             out.flush();
						     	             out.close();
						     	             out = null; 
					     	           
						     	            } catch(Exception e) {
						     	                Log.e("copy ERROR", e.toString());
						     	                e.printStackTrace();
						     	            } 
					     	            
					     	           //we have to reload the whole gridview because if you add, the favorite gets stuck at the bottom and rather we want the favorite towards the top 
					     	            LoadGridView(true);
					     	            //myAsyncTaskLoadFiles = new AsyncTaskLoadFiles(myImageAdapter, true);  //true is the flag to delete the old PNG
							    	    //myAsyncTaskLoadFiles.execute();
				        		}
		    		  }
		    		  
		    		 });
    		 }	
    		 
    		 //only show the favorite option if coming from the right area 
    		 if (showFavoriteGIFButton) { 
		    		 
		    		 LongTapPrompt.setNeutralButton(FavoriteButonText, new DialogInterface.OnClickListener() { //FAVORITE
		
		    		  @Override
		    		  public void onClick(DialogInterface dialog, int which) {
		    			  
		    			  
		    				//showToast(getString(R.string.MovingUp));
						        
						        //if the file type was not one of these like a png for example, then we don't care about the decodeddirpath and we don't change it
						     
							extension_ = Pixel.getExtension(originalImagePath);
							
							//***** let's check & create the needed directories on the sd card first
							
							File FavPNGPath_ = new File(FavPNGPath); //let's create the favoriate dir if it's not there already
				    		 if (!FavPNGPath_.exists()) {  //create the dir if it does not exist
				    			 FavPNGPath_.mkdirs();
							  }
				    		 
				    		File FavGIFPath_ = new File(FavGIFPath); //let's create the favoriate dir if it's not there already
				    		if (!FavGIFPath_.exists()) {  //create the dir if it does not exist
				    			FavGIFPath_.mkdirs();
							}
				    		 
				    		File FavGIFPathDecoded_ = new File(FavGIFPath + "/decoded"); //let's create the favoriate dir if it's not there already
				    		if (!FavGIFPathDecoded_.exists()) {  //create the dir if it does not exist
				    			FavGIFPathDecoded_.mkdirs();
							}
				    		
				    		File FavGIFPathGIFSource_ = new File(FavGIFPath + "/gifsource"); //let's create the favoriate dir if it's not there already
				    		if (!FavGIFPathGIFSource_.exists()) {  //create the dir if it does not exist
				    			FavGIFPathGIFSource_.mkdirs();
							}
				    		
				    		//***************************************************************************
				    		
				    		filename_no_extension = Pixel.getNameOnly(originalImagePath); //get the name of the select file but without the extension
				    		
			    			//may need to put this in the background
				    		//let's check now if the PNG that was favorited is a thumbnail for a gif or if it's realy just a PNG
				    		
				    				InputStream in = null;
				     	            OutputStream out = null;
				     	             
				     	            PNGPathFile = new File(originalImagePath); 
				     	      	
				     	           FavoriteGIFMoveAsync favoriteGIFMoveAsync_ = new FavoriteGIFMoveAsync();
				     	           favoriteGIFMoveAsync_.execute();
		    		  }
		    		  
		    		 });
    		 }	
    		 
    		 if (removeFavoriteGIF) {  //meaning the user clicked something that was already in the favpng directory
    			 
    			 LongTapPrompt.setNeutralButton(FavoriteButonText, new DialogInterface.OnClickListener() { //REMOVE FAVORITE
    					
		    		  @Override
		    		  public void onClick(DialogInterface dialog, int which) {
				    		
				    		filename_no_extension = Pixel.getNameOnly(originalImagePath); //get the name of the select file but without the extension
				    		
			    			//may need to put this in the background
				    		//showToast(getString(R.string.MovingDown));
				    		
				    		PNGPathFile = new File(originalImagePath); //sdcard/pixel/favgif
				    		
				    		UnFavoriteGIFMoveAsync unfavoriteGIFMoveAsync_ = new UnFavoriteGIFMoveAsync();
			     	        unfavoriteGIFMoveAsync_.execute();
			     	      
		    		  }
		    		  
		    		 });
    		 }
    		 
    		   if (removeFavorite) {
    		 // else if (removeFavorite) {  //meaning the user clicked something that was already in the favpng directory
    			 
    			 LongTapPrompt.setNeutralButton(FavoriteButonText, new DialogInterface.OnClickListener() { //REMOVE FAVORITE
    					
		    		  @Override
		    		  public void onClick(DialogInterface dialog, int which) {
				    		
				    		filename_no_extension = Pixel.getNameOnly(originalImagePath); //get the name of the select file but without the extension
				    		
			    			//may need to put this in the background
				    		//showToast(getString(R.string.MovingDown));
				    		
				    				InputStream in = null;
				     	            OutputStream out = null;
				     	             
				     	            PNGPathFile = new File(originalImagePath); //sdcard/pixel/favpng
						        	if (PNGPathFile.exists()) { 
					     	             try {
					     	            	 //TO DO check the res of the file being moved, either goes to PNGPath or PNG64Path
					     	             
						     	             in = new FileInputStream(originalImagePath);
						     	             out = new FileOutputStream(PNGPath + filename_no_extension + "." + extension_); //sdcard/pixel/png/fire.png
						     	             copyFile(in, out);
						     	             in.close();
						     	             in = null;
						     	             out.flush();
						     	             out.close();
						     	             out = null;  
					     	           
						     	            } catch(Exception e) {
						     	                Log.e("copy ERROR", e.toString());
						     	                e.printStackTrace();
						     	            } 
					     	            
					     	           //we have to reload the whole gridview because if you add, the favorite gets stuck at the bottom and rather we want the favorite towards the top 
					     	            LoadGridView(true);
					     	            //myAsyncTaskLoadFiles = new AsyncTaskLoadFiles(myImageAdapter, true);  //true is the flag to delete the old PNG
							    	    //myAsyncTaskLoadFiles.execute();
				        		}
		    		  }
		    		  
		    		 });
    		 }
    		 
    		 
    		 LongTapPrompt.setNegativeButton(getString(R.string.Delete), new DialogInterface.OnClickListener() {  //DELETE

    		  @Override
    		  public void onClick(DialogInterface dialog, int which) {
    			  
    			  AlertDialog.Builder confirmDelete = new AlertDialog.Builder(MainActivity.this);
    			  confirmDelete.setMessage(getString(R.string.AreYouSure));
    			  confirmDelete.setCancelable(true);
    			  confirmDelete.setPositiveButton(getString(R.string.Yes),
    	                new DialogInterface.OnClickListener() {
    	                public void onClick(DialogInterface dialog, int id) {
    	                	
    	                	File deleteGIF = new File(originalImagePath);
    						if (deleteGIF.exists()) {
    							 deleteGIF.delete();
    							 LoadGridView(false);
    					  	}
    		     	        
    	                    dialog.cancel();
    	                }
    	            });
    			  confirmDelete.setNegativeButton(getString(R.string.Cancel),
    	                    new DialogInterface.OnClickListener() {
    	                public void onClick(DialogInterface dialog, int id) {
    	                    dialog.cancel();
    	                }
    	            });

    	            AlertDialog alert11 = confirmDelete.create();
    	            alert11.show();
					
    		  }
    		 });

    		 // Remember, create doesn't show the dialog
    		 AlertDialog LongTapPromptDialog = LongTapPrompt.create();
    		 LongTapPromptDialog.show();
		
		
		return true;
}
    
    
public class FavoriteGIFMoveAsync extends AsyncTask<Void, Integer, Void>{
	
	/*need to move these files to the favorite usergif
	gif/tree.png
	gif/decoded/tree.rgb565
	gif/decoded/tree.txt
	gif/source/tree.gif*/
	
	int progress_status;
      
	  @Override
	  protected void onPreExecute() {
      super.onPreExecute();
    
     progress = new ProgressDialog(MainActivity.this);
	        progress.setMax(4);
	        progress.setTitle(getString(R.string.ProcessingFavorite));
	        progress.setMessage(getString(R.string.DoNotInterrupt));
	        //progress.setMessage("Sending Animation to PIXEL....");
	        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		    progress.setIcon(R.drawable.ic_action_warning);
	        progress.setCancelable(false); //must have this as we don't want users cancel while it's writing
	        progress.show();
  }
      
  @Override
  protected Void doInBackground(Void... params) {
		
			  //let's first copy the original png
	      	  InputStream in = null;
	          OutputStream out = null;
	          
	        PNGPathFile = new File(originalImagePath); 
	        String extension_ = Pixel.getExtension(originalImagePath);
	        
	      	if (PNGPathFile.exists()) { //if it doesn't exist
		            try {
		            	 
	   	             in = new FileInputStream(originalImagePath);
	   	            // out = new FileOutputStream(FavGIFPath + filename_no_extension + ".png"); 
	   	             out = new FileOutputStream(FavGIFPath + filename_no_extension + "." + extension_); 
	   	             copyFile(in, out);
	   	             in.close();
	   	             in = null;
	   	             out.flush();
	   	             out.close();
	   	             out = null; 
		           
	   	            } catch(Exception e) {
	   	                Log.e("copy ERROR", e.toString());
	   	                e.printStackTrace();
	   	            }  
		            
		            //we'll delete this file at the bottom
		            publishProgress(1);
	      	} 
	  
	      
	        File RGB565path = new File(gifPath_ + "decoded/" + filename_no_extension + ".rgb565"); //sdcard/pixel/gifs/decoded/tree.rgb565
	      	if (RGB565path.exists()) { //if it doesn't exist
	           //now let's get the rgb565
		             try {
	   	             in = new FileInputStream(gifPath_ + "decoded/" + filename_no_extension + ".rgb565");
	   	             out = new FileOutputStream(FavGIFPath + "decoded/" + filename_no_extension + ".rgb565");
	   	             copyFile(in, out);
	   	             in.close();
	   	             in = null;
	   	             out.flush();
	   	             out.close();
	   	             out = null;  
	   	              
	   	              //no need to register these with mediascanner as these are internal gifs , the workaround for the gifs with a black frame as the first frame
		           
	   	            } catch(Exception e) {
	   	                Log.e("copy ERROR", e.toString());
	   	                e.printStackTrace();
	   	            }  
		            
		            publishProgress(2);
				}
	           
	          //now let's get the txt
	        File TXTpath = new File(gifPath_ + "decoded/" + filename_no_extension + ".txt"); //sdcard/pixel/gifs/decoded/tree.rgb565
	      	if (TXTpath.exists()) { //if it doesn't exist
		             try {
	   	             in = new FileInputStream(gifPath_ + "decoded/" + filename_no_extension + ".txt");
	   	             out = new FileOutputStream(FavGIFPath + "decoded/" + filename_no_extension + ".txt");
	   	             copyFile(in, out);
	   	             in.close();
	   	             in = null;
	   	             out.flush();
	   	             out.close();
	   	             out = null;  
	   	              
	   	              //no need to register these with mediascanner as these are internal gifs , the workaround for the gifs with a black frame as the first frame
		           
	   	            } catch(Exception e) {
	   	                Log.e("copy ERROR", e.toString());
	   	                e.printStackTrace();
	   	            } 
		            
		            publishProgress(3);
	      	}
	      	
	      	//lastly we need to copy over the originanl GIF
	      	 File originalGIF = new File(gifPath_ + "gifsource/" + filename_no_extension + ".gif"); 
		        	if (originalGIF.exists()) { //if it doesn't exist
	   	             try {
		     	             in = new FileInputStream(gifPath_ + "gifsource/" + filename_no_extension + ".gif");
		     	             out = new FileOutputStream(FavGIFPath + "gifsource/" + filename_no_extension + ".gif");
		     	             copyFile(in, out);
		     	             in.close();
		     	             in = null;
		     	             out.flush();
		     	             out.close();
		     	             out = null;  
		     	              
		     	              //no need to register these with mediascanner as these are internal gifs , the workaround for the gifs with a black frame as the first frame
	   	           
		     	            } catch(Exception e) {
		     	                Log.e("copy ERROR", e.toString());
		     	                e.printStackTrace();
		     	            } 
	   	             
	   	          
	   	             
	   	             
	   	             publishProgress(4);
	   	             
		        	}
		        	
		        	 //now let's delete the files we copied for the move
		        	 if (originalGIF.exists()) originalGIF.delete();
		        	 if (RGB565path.exists()) RGB565path.delete();
		        	 if (TXTpath.exists())TXTpath.delete();
		        	 if (PNGPathFile.exists())PNGPathFile.delete();
		
	    
   return null;
  }
  
  @Override
  protected void onProgressUpdate(Integer... values) {
   super.onProgressUpdate(values);
   
   progress.incrementProgressBy(1);
    
  }
   
  @Override
  protected void onPostExecute(Void result) {
	  progress.dismiss();
	  LoadGridView(false); //TO DO make sure to test this

  super.onPostExecute(result);
}

}

public class UnFavoriteGIFMoveAsync extends AsyncTask<Void, Integer, Void>{
	
	/*need to move these files to the favorite from favgif to gif
	gif/tree.png
	gif/decoded/tree.rgb565
	gif/decoded/tree.txt
	gif/source/tree.gif*/
	
	int progress_status;
      
	  @Override
	  protected void onPreExecute() {
      super.onPreExecute();
    
     progress = new ProgressDialog(MainActivity.this);
	        progress.setMax(4);
	        progress.setTitle(getString(R.string.ProcessingFavorite));
	        progress.setMessage(getString(R.string.DoNotInterrupt));
	        //progress.setMessage("Sending Animation to PIXEL....");
	        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		    progress.setIcon(R.drawable.ic_action_warning);
	        progress.setCancelable(false); //must have this as we don't want users cancel while it's writing
	        progress.show();
  }
      
  @Override
  protected Void doInBackground(Void... params) {
	  
	  //let's first copy the original png
	  // TO DO we're not considering usergif's, need to do that for favorite gif slideshows
	      	  InputStream in = null;
	          OutputStream out = null;
	          
	          PNGPathFile = new File(originalImagePath); //it's favgif in this case
	          String extension_ = Pixel.getExtension(originalImagePath);
	      	
	          if (PNGPathFile.exists()) { //if it doesn't exist
		            try {
		            	 
	   	             in = new FileInputStream(originalImagePath);
	   	             out = new FileOutputStream(GIFPath + filename_no_extension + "." + extension_); 
	   	             copyFile(in, out);
	   	             in.close();
	   	             in = null;
	   	             out.flush();
	   	             out.close();
	   	             out = null; 
		           
	   	            } catch(Exception e) {
	   	                Log.e("copy ERROR", e.toString());
	   	                e.printStackTrace();
	   	            }  
		            
		            //we'll delete this file at the bottom
		            publishProgress(1);
	      	} 
        	
	        File RGB565path = new File(FavGIFPath + "decoded/" + filename_no_extension + ".rgb565"); //sdcard/pixel/gifs/decoded/tree.rgb565
	      	if (RGB565path.exists()) { //if it doesn't exist
	           //now let's get the rgb565
		             try {
	   	             in = new FileInputStream(FavGIFPath + "decoded/" + filename_no_extension + ".rgb565");
	   	             out = new FileOutputStream(GIFPath + "decoded/" + filename_no_extension + ".rgb565");
	   	             copyFile(in, out);
	   	             in.close();
	   	             in = null;
	   	             out.flush();
	   	             out.close();
	   	             out = null;  
	   	              
	   	              //no need to register these with mediascanner as these are internal gifs , the workaround for the gifs with a black frame as the first frame
		           
	   	            } catch(Exception e) {
	   	                Log.e("copy ERROR", e.toString());
	   	                e.printStackTrace();
	   	            }  
		            
		            publishProgress(2);
				}
	           
	          //now let's get the txt
	        File TXTpath = new File(FavGIFPath + "decoded/" + filename_no_extension + ".txt"); //sdcard/pixel/gifs/decoded/tree.rgb565
	      	if (TXTpath.exists()) { //if it doesn't exist
		             try {
	   	             in = new FileInputStream(FavGIFPath + "decoded/" + filename_no_extension + ".txt");
	   	             out = new FileOutputStream(GIFPath + "decoded/" + filename_no_extension + ".txt");
	   	             copyFile(in, out);
	   	             in.close();
	   	             in = null;
	   	             out.flush();
	   	             out.close();
	   	             out = null;  
	   	              
	   	              //no need to register these with mediascanner as these are internal gifs , the workaround for the gifs with a black frame as the first frame
		           
	   	            } catch(Exception e) {
	   	                Log.e("copy ERROR", e.toString());
	   	                e.printStackTrace();
	   	            } 
		            
		            publishProgress(3);
	      	}
	      	
	      	//lastly we need to copy over the originanl GIF
	      	 File originalGIF = new File(FavGIFPath + "gifsource/" + filename_no_extension + ".gif"); 
		        	if (originalGIF.exists()) { //if it doesn't exist
	   	             try {
		     	             in = new FileInputStream(FavGIFPath + "gifsource/" + filename_no_extension + ".gif");
		     	             out = new FileOutputStream(GIFPath + "gifsource/" + filename_no_extension + ".gif");
		     	             copyFile(in, out);
		     	             in.close();
		     	             in = null;
		     	             out.flush();
		     	             out.close();
		     	             out = null;  
		     	              
		     	              //no need to register these with mediascanner as these are internal gifs , the workaround for the gifs with a black frame as the first frame
	   	           
		     	            } catch(Exception e) {
		     	                Log.e("copy ERROR", e.toString());
		     	                e.printStackTrace();
		     	            } 
	   	             
	   	             publishProgress(4);
	   	             
		        	}
		        	
		        	 //now let's delete the files we copied for the move
		        	 if (originalGIF.exists()) originalGIF.delete();
		        	 if (RGB565path.exists()) RGB565path.delete();
		        	 if (TXTpath.exists())TXTpath.delete();
		        	 if (PNGPathFile.exists())PNGPathFile.delete();
		
	    
   return null;
  }
  
  @Override
  protected void onProgressUpdate(Integer... values) {
   super.onProgressUpdate(values);
   
   progress.incrementProgressBy(1);
    
  }
   
  @Override
  protected void onPostExecute(Void result) {
	  progress.dismiss();
	  
	  LoadGridView(false); 

  super.onPostExecute(result);
}

}
	
	public void onItemClick(AdapterView<?> parent, View v, int position, long id) {    //we go here when the user tapped an image from the initial grid    
        
	     
			if (matrix_ != null) { 
			  		//********we need to reset everything because the user could have been already running an animation
			  	     x = 0;
			  	     
			  	     
			  	    /* if (StreamModePlaying == 1) {
			  	    	 //decodedtimer.cancel();
			  	    	// if(!pixelHardwareID.equals("PIXL")) {
			  	    		if (decodedtimer != null) decodedtimer.cancel();
			  	    	// }
			  	    	// is.close();
			  	     }
			  	     ///****************************
*/			  	     
			  	    stopTimers();
		    		  
			    	imagePath = (String) parent.getItemAtPosition(position);
			    	
			    	originalImagePath = (String) parent.getItemAtPosition(position);
			    	
			        selectedFileName = imagePath;
			        
			        filename_no_extension = Pixel.getNameOnly(originalImagePath);
			        
			        easterEggs();
			        
			        selectedFileName = filename_no_extension; //not really good coding but selected file name is used elsewhere so we need this here

			        extension_ = Pixel.getExtension(originalImagePath);
			        
			        //we need to find out which directory was selected so we can set the decodeddir
			        
			        String PixelDirName_ = Pixel.getPixelDir(originalImagePath);
			        
			        if (PixelDirName_.equals("gif")) {
			        	decodedDirPath = GIFPath + "decoded";
			        	gifPath_ = GIFPath;
			        }
			        else if (PixelDirName_.equals("usergif")) {
			        	decodedDirPath = userGIFPath + "decoded";
			        	gifPath_ = userGIFPath;
			        }
			        else if (PixelDirName_.equals("gif64")) {
			        	decodedDirPath = GIF64Path + "decoded";
			        	gifPath_ = GIF64Path;
			        }
			        
			        else if (PixelDirName_.equals("gif16")) {
			        	decodedDirPath = GIF16Path + "decoded";
			        	gifPath_ = GIF16Path;
			      }
			        
			        else if (PixelDirName_.equals("favgif")) {
			        	decodedDirPath = FavGIFPath + "decoded";
			        	gifPath_ = FavGIFPath;
			        }
			        //if the file type was not one of these like a png for example, then we don't care about the decodeddirpath and we don't change it
			        
			        if (extension_.equals("png")) {  //then we use the thumbnail, we just need to rename the image path to a gif
			        	
			        	File pngRGB565path = new File(gifPath_ + "decoded/" + filename_no_extension + ".rgb565"); //sdcard/pixel/gifs/decoded/tree.rgb565
			        	if (!pngRGB565path.exists()) { //if it doesn't exist
			        		
			        		//ok not there so let's see if the original gif is there as decoded may have been deleted because the led panel changed
			        		File originalGIF = new File(gifPath_ + "gifsource/" + filename_no_extension + ".gif"); //sdcard/pixel/gifs/gifsource/tree.rgb565
			        		if (originalGIF.exists()) { 
			        			//we've got the original gif so now let's decode it
			        			 imagePath = gifPath_ + "gifsource/" + filename_no_extension + ".gif";
			        			 gifView.setGif(imagePath);  //just sets the image , no decoding, decoding happens in the animateafterdecode method
						     	 animateAfterDecode(0);
			        		}
			        		else { //well we tried, no original gif so we'll treat it as a png
					            	//there's no rgb565 and we only have a single frame png so let's just send this single frame png to pixel
						        	
					        		//it's  not there so let's check the original gifs folder, if it's in there, then treat it like a gif and decode
					        		
					        		imagePath = originalImagePath;
					        		try {
					        			//TO DO will this crash pixel v1?
					        			matrix_.interactive();  //this has to be here in case we were in interactive mode from a previous long tap
					        			WriteImagetoMatrix();
									} catch (ConnectionLostException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
					            }
			        		}
			        	else {  //the rgb565 is there
			        		//gifView.setGif(imagePath);  //this is causing a crash, TO DO figure out why later 
			        		animateAfterDecode(0); //the rgb565 is there so let's run the already decoded animation
					    } 
			        }
			        
			        else if (extension_.equals("jpg") || extension_.equals("jpeg")) {  
			        	imagePath = originalImagePath;
		        		try {
		        			matrix_.interactive(); //this has to be here in case we were in interactive mode from a previous long tap
		        			WriteImagetoMatrix();
						} catch (ConnectionLostException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        }
			        
			       else if (extension_.equals("gif")) {  // if it's not a png, then it's a gif so let's animate
			     	   gifView.setGif(imagePath);  //just sets the image , no decoding, decoding happens in the animateafterdecode method
			     	   animateAfterDecode(0);
			       } 
			   
			       // animateAfterDecode(0);  //DELETE this line ? 0 means streaming mode, 1 means download mode 
	        }
	        else {
	        	 showToast(getString(R.string.PIXELNotFound));
	        }
  		}
  
  
	private  void easterEggs() {
		 if (filename_no_extension.equals("sinistar")) {  //easter egg :-)

	        	sinistarWAV = getResources().openRawResourceFd(R.raw.beware_i);
	   		 
		        if (sinistarWAV != null) {

		            mediaPlayer = new MediaPlayer();
		            try {
						mediaPlayer.setDataSource(sinistarWAV.getFileDescriptor(), sinistarWAV.getStartOffset(), sinistarWAV.getLength());
						sinistarWAV.close();
				        mediaPlayer.prepare();
				        mediaPlayer.start();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		           
		        }
		    }
	        
	        if (filename_no_extension.equals("aqbert")) {  //easter egg :-)

	        	qbertWAV = getResources().openRawResourceFd(R.raw.qbertslick);
	   		 
		        if (qbertWAV != null) {

		            mediaPlayer = new MediaPlayer();
		            try {
						mediaPlayer.setDataSource(qbertWAV.getFileDescriptor(), qbertWAV.getStartOffset(), qbertWAV.getLength());
						qbertWAV.close();
				        mediaPlayer.prepare();
				        mediaPlayer.start();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		           
		        }
		    }
	}
	
	public static void WriteImagetoMatrix() throws ConnectionLostException {  //here we'll take a PNG, BMP, or whatever and convert it to RGB565 via a canvas, also we'll re-size the image if necessary
  	
	    // ***** old code, had to switch to newer code below as was getting out of memory errors for when opening larger JPEGs (from Android gallery for example)
	    // originalImage = BitmapFactory.decodeFile(imagePath);   
		// width_original = originalImage.getWidth();
		// height_original = originalImage.getHeight();
	    //***********************************************************************************
	  
		originalImage = decodeSampledBitmapFromFile(imagePath, KIND.width,KIND.height);
		 
		width_original = originalImage.getWidth();
	    height_original = originalImage.getHeight();
		 
		 if (width_original != KIND.width || height_original != KIND.height) {
			 resizedFlag = 1;
			 //the iamge is not the right dimensions, so we need to re-size
			 scaleWidth = ((float) KIND.width) / width_original;
 		 	 scaleHeight = ((float) KIND.height) / height_original;
 		 	 
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
		matrix_.frame(frame_);  //write to the matrix   
}
	
	public static void decodePNGNoWrite(String imagePath_) throws ConnectionLostException {  //here we'll take a PNG, BMP, or whatever and convert it to RGB565 via a canvas, also we'll re-size the image if necessary
	  	
	    // ***** old code, had to switch to newer code below as was getting out of memory errors for when opening larger JPEGs (from Android gallery for example)
	    // originalImage = BitmapFactory.decodeFile(imagePath);   
		// width_original = originalImage.getWidth();
		// height_original = originalImage.getHeight();
	    //***********************************************************************************
	  
		originalImage = decodeSampledBitmapFromFile(imagePath_, KIND.width,KIND.height);
		 
		width_original = originalImage.getWidth();
	    height_original = originalImage.getHeight();
		 
		 if (width_original != KIND.width || height_original != KIND.height) {
			 resizedFlag = 1;
			 //the iamge is not the right dimensions, so we need to re-size
			 scaleWidth = ((float) KIND.width) / width_original;
 		 	 scaleHeight = ((float) KIND.height) / height_original;
 		 	 
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
		//matrix_.frame(frame_);  //write to the matrix   
}
  
  public static void WritePNG2Matrix(Bitmap originalImage) throws ConnectionLostException {  //here we'll take a PNG, BMP, or whatever and convert it to RGB565 via a canvas, also we'll re-size the image if necessary
	  	
	    // ***** old code, had to switch to newer code below as was getting out of memory errors for when opening larger JPEGs (from Android gallery for example)
	    // originalImage = BitmapFactory.decodeFile(imagePath);   
		// width_original = originalImage.getWidth();
		// height_original = originalImage.getHeight();
	    //***********************************************************************************
	  
		//originalImage = decodeSampledBitmapFromFile(imagePath, KIND.width,KIND.height);
		 
		width_original = originalImage.getWidth();
	    height_original = originalImage.getHeight();
		 
		 if (width_original != KIND.width || height_original != KIND.height) {
			 resizedFlag = 1;
			 //the iamge is not the right dimensions, so we need to re-size
			 scaleWidth = ((float) KIND.width) / width_original;
		 	 scaleHeight = ((float) KIND.height) / height_original;
		 	 
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
		matrix_.frame(frame_);  //write to the matrix   
}
  
  private void WriteCameratoMatrix(Bitmap cameraBitmap) throws ConnectionLostException {  //here we'll take a PNG, BMP, or whatever and convert it to RGB565 via a canvas, also we'll re-size the image if necessary
	  	
		//originalImage = decodeSampledBitmapFromFile(imagePath, KIND.width,KIND.height);
		 
		width_original = cameraBitmap.getWidth();
	    height_original = cameraBitmap.getHeight();
		 
		 if (width_original != KIND.width || height_original != KIND.height) {
			 resizedFlag = 1;
			 //the iamge is not the right dimensions, so we need to re-size
			 scaleWidth = ((float) KIND.width) / width_original;
		 	 scaleHeight = ((float) KIND.height) / height_original;
		 	 
	   		 // create matrix for the manipulation
	   		 matrix2 = new Matrix();
	   		 // resize the bit map
	   		 matrix2.postScale(scaleWidth, scaleHeight);
	   		 resizedBitmap = Bitmap.createBitmap(cameraBitmap, 0, 0, width_original, height_original, matrix2, false); //false means don't anti-alias which is what we want when re-sizing for super pixel 64x64
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
	   	   	 canvas.drawBitmap(cameraBitmap, 0, 0, null);
	   		 ByteBuffer buffer = ByteBuffer.allocate(KIND.width * KIND.height *2); //Create a new buffer
	   		 canvasBitmap.copyPixelsToBuffer(buffer); //copy the bitmap 565 to the buffer		
	   		 BitmapBytes = buffer.array(); //copy the buffer into the type array
		 }	   		
		 
		loadImage();  
		matrix_.frame(frame_);  //write to the matrix   
}
  
  public static void loadImage() {
	  	

		int y = 0;
		for (int i = 0; i < frame_.length; i++) {
			frame_[i] = (short) (((short) BitmapBytes[y] & 0xFF) | (((short) BitmapBytes[y + 1] & 0xFF) << 8));
			y = y + 2;
		}
		
		//we're done with the images so let's recycle them to save memory
	    canvasBitmap.recycle();
	    //originalImage.recycle(); //was crashing on the camera2matrix 
	    
	    if ( resizedFlag == 1) {
	    	resizedBitmap.recycle(); //only there if we had to resize an image
	    }
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
  
  public void animateAfterDecode(int longpress) {
	  
	  //first check if rgb565 file is there, proceed if so
	  // if not then decode
	  // also check if the led matrix selected now doesn't match the led matrix from the decoded file, re-decode if so
	  
	  
	  //********we need to reset everything because the user could have been already running an animation
	     x = 0;
	    // downloadCounter = 0;
	     
	     stopTimers();
	     
	     /*if (StreamModePlaying == 1) {
	    	 decodedtimer.cancel();
	     }*/
	     ///****************************
     
     //now let's check if this file was already decoded by looking for the text meta data file
 	File decodedFile = new File(decodedDirPath + "/" + selectedFileName  + ".txt"); //decoded/rain.txt
		if(decodedFile.exists()) {
	   	      StringBuilder text = new StringBuilder();
	   	      String fileAttribs = null;
	   	      
	   	      try {
	   	          BufferedReader br = new BufferedReader(new FileReader(decodedFile));
	   	          String line;
	   
	   	          while ((line = br.readLine()) != null) {
	   	              text.append(line);
	   	              text.append('\n');	   	             
	   	          }
	   	      }
	   	      catch (IOException e) {
	   	          //You'll need to add proper error handling here
	   			
	   	      }
	   	      
	   	    fileAttribs = text.toString();  //now convert to a string	   	      
	   	    String fdelim = "[,]"; //now parse this string considering the comma split  ie, 32,60
	        String[] fileAttribs2 = fileAttribs.split(fdelim);
	        selectedFileTotalFrames = Integer.parseInt(fileAttribs2[0].trim());
	    	selectedFileDelay = Integer.parseInt(fileAttribs2[1].trim());
	    	selectedFileResolution = Integer.parseInt(fileAttribs2[2].trim());
	    	
	    	//we need this for the decoder timer
	    	//now we need to compare the current resoluiton with the encoded resolution
	    	//if different, then we need to re-encode
	    	
	    	if (selectedFileResolution == currentResolution) {  //selected resoluton comes from the text file of the select file and current comes from the selected led matrix type from preferences
	    	
			    	if (selectedFileDelay != 0) {  //then we're doing the FPS override which the user selected from settings
			    		fps = 1000.f / selectedFileDelay;
					} else { 
			    		fps = 0;
			    	}
			    	MainActivity myActivity = new MainActivity();  //had to add this due to some java requirement	  
			    	
		    		try {
		    			if (longpress == 1 && kioskMode_ == false && pixelHardwareID.substring(0,4).equals("PIXL")) {  //download mode
		    				StreamModePlaying = 0;
		    				gridview.setKeepScreenOn(true); //we don't want the screen going into sleep mode
		    				matrix_.interactive();
			    			matrix_.writeFile(fps);
			    			
			    			//writePixelAsync loadApplication = new writePixelAsync();
			    			//loadApplication.execute();
			    			
			    			//This piece of code to ensure we don't do a double write which was happening for SUPER PIXEL
			    			//*******************************************************
			    			if (writePixel == null) {
		    		            android.util.Log.v("TAG", "Pixel Write Async Task is Null so OK to Start Now");
		    		            writePixel = new writePixelAsync();
				    			writePixel.execute();
		    		        } 
				    			
				    		else {
		    		            //Depending on your situation take appropriate action
		    		          //  android.util.Log.i("TAG", "Not Null");
		    		            if(writePixel.getStatus() == (AsyncTask.Status.PENDING)) {
		    		                //Indicates that the task has not been executed yet.
		    		                android.util.Log.v("TAG", "Pixel Write Pending so not writing now");
		    		            } else if(writePixel.getStatus() == (AsyncTask.Status.RUNNING)) {
		    		                //Indicates that the task is running.
		    		                android.util.Log.v("TAG", "Pixel Write Running so not writing now");
		    		            } else if(writePixel.getStatus() == (AsyncTask.Status.FINISHED)) {
		    		                //Indicates that AsyncTask.onPostExecute has finished.
		    		                android.util.Log.v("TAG", "Pixel Write Finished Before so OK to Start Again");
		    		                writePixel = new writePixelAsync();
					    			writePixel.execute();
		    		            } 
				    		}
		    			}
			    			
		    			
		    			else {
		    				matrix_.interactive(); //put PIXEL back in interactive mode, can't forget to do that! or we'll just be playing local animations
		    				decodedtimer = myActivity.new DecodedTimer(300000,selectedFileDelay);  //stream mode
							decodedtimer.start();
							StreamModePlaying = 1; //our isStreamModePlaying flag	
		    			}
		    			
		    		} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	//StreamModePlaying = 1; //our isStreamModePlaying flag	        	
		   		}
	    	else {
	    		Toast toast6 = Toast.makeText(context, getString(R.string.LEDPanelChanged), Toast.LENGTH_LONG);
		        toast6.show();
		        
		        //because the LED panel was changed, we need to delete the decoding dir and create it all again
		        File decodeddir = new File(decodedDirPath); //could be gif, gif64, or usergif, this was set above
		        
		        //before we delete the decoded dir, we have to renmae it, this is due to some strange Android bug http://stackoverflow.com/questions/11539657/open-failed-ebusy-device-or-resource-busy
		        final File to = new File(decodeddir.getAbsolutePath() + System.currentTimeMillis());
		        decodeddir.renameTo(to);
		        recursiveDelete(to);
		        //ok decoded dir is deleted, let's add it back now
			  	decodeddir.mkdirs();
		       
		        ///************** let's show a message on PIXEL letting the user know we're decoding
		        showDecoding();
		        ///*********************************************************************************
	    		gifView.play(); //this does the actual decoding, it was a class already written
	    		
	    	}
		}	
		else { //then we need to decode the gif first	
			Toast toast7 = Toast.makeText(context, getString(R.string.oneTimeDecode), Toast.LENGTH_SHORT);
	        toast7.show();
	        showDecoding();
			gifView.play();
		}
  } 
  
  private void recursiveDelete(File fileOrDirectory) {
      if (fileOrDirectory.isDirectory())
          for (File child : fileOrDirectory.listFiles())
              recursiveDelete(child);

      fileOrDirectory.delete();
  }
  
  public class writePixelAsync extends AsyncTask<Void, Integer, Void>{
		
		 int progress_status;
	      
		  @Override
		  protected void onPreExecute() {
	      super.onPreExecute();
	    
	     progress = new ProgressDialog(MainActivity.this);
		        progress.setMax(selectedFileTotalFrames);
		        progress.setTitle(getString(R.string.writingPIXEL));
		        progress.setMessage(getString(R.string.DoNotInterrupt));
		        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			    progress.setIcon(R.drawable.ic_action_warning);
		        progress.setCancelable(false); //must have this as we don't want users cancel while it's writing
		        progress.show();
	  }
	      
	  @Override
	  protected Void doInBackground(Void... params) {
			
		
	  for (int count = 0 ; count < selectedFileTotalFrames  ; count++) {  //ex. 1402 total frames but starts at 0 so count would be 1401, 1403 < 1402
		
				  
				  File file = new File(decodedDirPath + "/" + selectedFileName + ".rgb565"); //this is one big file now, no longer separate files
				  
				  RandomAccessFile raf = null;
				  
					//let's setup the seeker object
					try {
						raf = new RandomAccessFile(file, "r");
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}  // "r" means open the file for reading
					
					try {
						raf.seek(0);
					} catch (IOException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					} //move pointer back to the beginning of the file
					
					 switch (selectedFileResolution) { //16x32 matrix = 1024k frame size, 32x32 matrix = 2048k frame size
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
					 
					// Log.d("PixelAnimations","frame length: " + frame_length);
					//now let's see forward to a part of the file
						try {
							//raf.seek(x*frame_length);
							raf.seek(count*frame_length);
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} 
						//Log.d("PixelAnimations","from sd card write, x is: " + x); 
						//Log.d("PixelAnimations","Writing frame : " + count);
						
						
						if (frame_length > Integer.MAX_VALUE) {
			   			    try {
								throw new IOException("The file is too big");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			   			}
						
						// Create the byte array to hold the data
			   			//byte[] bytes = new byte[(int)length];
			   			BitmapBytes = new byte[(int)frame_length];
			   			
			   			try {
							raf.read(BitmapBytes);
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
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
					
						//need to add something in here if the transfer got interruped, then go back to interactive mode and start over
						
					 
 					   		try {
						   	 Log.v("PixelAnimations ","Writing frame: " + count + " of " + String.valueOf(selectedFileTotalFrames-1));
						   		matrix_.frame(frame_);
						   		progress_status++;
							    publishProgress(progress_status);
						   	
							} catch (ConnectionLostException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			  }  
			
		    
	   return null;
	  }
	  
	  @Override
	  protected void onProgressUpdate(Integer... values) {
	   super.onProgressUpdate(values);
	   
	   progress.incrementProgressBy(1);
	    
	  }
	   
	  @Override
	  protected void onPostExecute(Void result) {
		  progress.dismiss();
	
	 
	   try {
		matrix_.playFile();
	} catch (ConnectionLostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  gridview.setKeepScreenOn(false); //we're done so we can allow the screen to turn off again
	  super.onPostExecute(result);
}
	
}
  
  public class streamPixelAsync extends AsyncTask<Void, Integer, Void>{
	      
		  @Override
		  protected void onPreExecute() {
	      super.onPreExecute();
	  }
	      
	  @Override
	  protected Void doInBackground(Void... params) {
			
		  File file = new File(decodedDirPath + "/" + selectedFileName + ".rgb565");
 			if (file.exists()) {
 				
				
				RandomAccessFile raf = null;
				
				//let's setup the seeker object
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
				
				if (x == selectedFileTotalFrames) { // Manju - Reached End of the file.
	   				x = 0;
	   				try {
						raf.seek(0); //go to the beginning of the rgb565 file
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
	   			}
				
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
				//Log.d("PixelAnimations","x is: " + x);
				//Log.d("seeker","seeker is: " + x*frame_length);
				
	   			 
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
	   			
	   			//BitmapBytes = bos.toByteArray();
	   			
	   			//now that we have the byte array loaded, load it into the frame short array
	   			
	   			int y = 0;
	     		for (int i = 0; i < frame_.length; i++) {
	     			frame_[i] = (short) (((short) BitmapBytes[y] & 0xFF) | (((short) BitmapBytes[y + 1] & 0xFF) << 8));
	     			y = y + 2;
	     		}
	     		
	     		//we're done with the images so let's recycle them to save memory
	    	   // canvasBitmap.recycle();
	    	 //  bitmap.recycle(); 
	   		
		   		//and then load to the LED matrix
	     		
			   	try {
					matrix_.frame(frame_);
					
				} catch (ConnectionLostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   	x++;
 			}
 			
 			else {
 				showToast("We have a problem, couldn't find the decoded file");
 			}
	   return null;
	  }
	  
	  @Override
	  protected void onProgressUpdate(Integer... values) {
	   super.onProgressUpdate(values);
	   
	   //progress.incrementProgressBy(1);
	    
	  }
	   
	  @Override
	  protected void onPostExecute(Void result) {
		 // progress.dismiss();
	
	 
	 /*  try {
		////matrix_.playFile();
	} catch (ConnectionLostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	 // gridview.setKeepScreenOn(false); //we're done so we can allow the screen to turn off again
	  super.onPostExecute(result);
}
	
}
   
	private static void showDecoding()  {
		
	     //TO DO change this later, it's not a good design, we should do a bitmap auto resize instead, for now we have to remember to change this if we add a matrix panel
		
		// switch (matrix_number) {  //get this from the preferences
		 switch (matrix_model) {  //get this from the preferences
	     case 0:
	    	 BitmapInputStream = context.getResources().openRawResource(R.raw.decoding16);
	    	 break;
	     case 1:
	    	 BitmapInputStream = context.getResources().openRawResource(R.raw.decoding16);
	    	 break;
	     case 2:
	    	 BitmapInputStream = context.getResources().openRawResource(R.raw.decoding32);
	    	 break;
	     case 3:
	    	 BitmapInputStream = context.getResources().openRawResource(R.raw.decoding32);
	    	 break;
	     case 4:
	    	 BitmapInputStream = context.getResources().openRawResource(R.raw.decoding64by32);
	    	 break;
	     case 5:
	    	 BitmapInputStream = context.getResources().openRawResource(R.raw.decoding32by64);
	    	 break;	 
	     case 6:
	    	 BitmapInputStream = context.getResources().openRawResource(R.raw.decoding32by64);
	    	 break;
	     case 7:
	    	 BitmapInputStream = context.getResources().openRawResource(R.raw.decoding32by128);
	    	 break;	 
	     case 8:
	    	 BitmapInputStream = context.getResources().openRawResource(R.raw.decoding128by32); 
	    	 break;	 	 	 
	     case 9:
	    	 BitmapInputStream = context.getResources().openRawResource(R.raw.decoding32by128); 
	    	 break;	 	
	     case 10:
	    	 BitmapInputStream = context.getResources().openRawResource(R.raw.decoding64by64); 
	    	 break;	
	     case 11:
	    	 BitmapInputStream = context.getResources().openRawResource(R.raw.decoding32); 
	    	 break;	 
	     case 12:
	    	 BitmapInputStream = context.getResources().openRawResource(R.raw.decoding32); 
	    	 break;	  
	     case 13:
	    	 BitmapInputStream = context.getResources().openRawResource(R.raw.decoding64by32); 
	    	 break;
	     case 14:
	    	 BitmapInputStream = context.getResources().openRawResource(R.raw.decoding64by64); 
	    	 break;	 
	     default:	    		 
	    	 BitmapInputStream = context.getResources().openRawResource(R.raw.decoding32);
	     }
		
	        loadRGB565(); //show the one time decoding message to the user
	        try {
				matrix_.frame(frame_);
			} catch (ConnectionLostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	}
	
    private void showPleaseWait(final String str) {
		runOnUiThread(new Runnable() {
			public void run() {
				//pDialog = ProgressDialog.show(breath.this,analyzingText, justAmomentText, true);
				pDialog = ProgressDialog.show(MainActivity.this,getString(R.string.loadingImagesPlsWaitTitle), str, true);
				//pDialog.setCancelable(true);  //we don't need this one
			}
		});
	}
	
	////*****************************
	
    public void letsAnimate() {
    	
        // hack to call the non-static method
	    animateAfterDecode(0);
    }
	
	
	  @Override
	    public boolean onCreateOptionsMenu(Menu menu) 
	    {
	       MenuInflater inflater = getMenuInflater();
	       inflater.inflate(R.menu.mainmenu, menu);
	       return true;
	    }

	    @Override
	    public boolean onOptionsItemSelected (MenuItem item)
	    {
	       
			
	      if (item.getItemId() == R.id.menu_instructions) {
	 	    	AlertDialog.Builder alert=new AlertDialog.Builder(this);
	 	      	alert.setTitle(getResources().getString(R.string.setupInstructionsStringTitle)).setIcon(R.drawable.icon).setMessage(getResources().getString(R.string.setupInstructionsString)).setNeutralButton(getResources().getString(R.string.OKText), null).show();
	 	   }
	      
	      if (item.getItemId() == R.id.start_SlideShow) {
	    	  
	    	  if (matrix_ != null) {
		    	  
		    	  Toast toast = Toast.makeText(context, "Streaming Slide Show...", Toast.LENGTH_LONG);
		 	      toast.show();
		    	  
		 	     SlideShowLength = SlideShowLengthAll;
		 	 
		         System.arraycopy(SlideShowArrayAll, 0, SlideShowArray, 0, SlideShowArrayAll.length);
		 	      
		    	  
		 	    	try {
						matrix_.interactive(); //need to put into interactive mode as it may have been in local playback before
		 	    		SlideShow(false);
					} catch (ConnectionLostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    	  }
	    	  else {
	    		   showToast(getString(R.string.PIXELNotFound));
	    	  }
	 	   }
	      
	      if (item.getItemId() == R.id.menu_createSlideShowGIFFavs) {
	    	  
	    	//  writeSlideShowGIF();
	    	  if (matrix_ != null) {
	    		  
	    		  if (pixelHardwareID.substring(0,4).equals("PIXL")) {
		    	 
		    	  		
	    			  if (FavGIFHasFiles == true) {
		    			  
		    			  try {
								matrix_.interactive();
							} catch (ConnectionLostException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		    			  
					  	     x = 0; //without this, the slideshow will not complete on the second run and will only work the first time
						  
					  	     gridview.setKeepScreenOn(true); //enable power savings again	
							 //new createSlideShowGIFAsync().execute();
							 createSlideShowGIFAsync createSlideShowGIFAsync_ = new createSlideShowGIFAsync();
							 createSlideShowGIFAsync_.execute();
					  	     //writeSlideShowGIF();
					  	     
	    			  }   
	    			  else {
	    				  showToast(getString(R.string.NoFavoritesMarked));
	    			  }
	    		  }
	    		  else {
	    			  showToast(getString(R.string.WritingOnlyOnV2));
	    		  }
	    	  }
	    	  else {
	    		  showToast(getString(R.string.PIXELNotFound));
	    	  }
	 	   }
	      
	      if (item.getItemId() == R.id.menu_createSlideShowFavs) {
	    	  
		    	 
	    	  if (matrix_ != null) {
	    		  
	    		  if (pixelHardwareID.substring(0,4).equals("PIXL")) {
		    	  		
	    			  if (FavPNGHasFiles == true) {
		    			  
		    			  try {
								matrix_.interactive();
							} catch (ConnectionLostException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		    			  
					  	     x = 0; //without this, the slideshow will not complete on the second run and will only work the first time
						  
					  	     SlideShowLength = SlideShowLengthFavs;
					  	     
						     System.arraycopy(SlideShowArrayFavs, 0, SlideShowArray, 0, SlideShowArrayFavs.length);
					  	     
					  	     writeSlideShow();
	    			  }   
	    			  else {
	    				  showToast(getString(R.string.NoFavoritesMarked));
	    			  }
	    		  }
	    		  else {
	    			  showToast(getString(R.string.WritingOnlyOnV2));
	    		  }
	    	  }
	    	  else {
	    		  showToast(getString(R.string.PIXELNotFound));
	    	  }
	 	   }
	      
	      if (item.getItemId() == R.id.menu_createSlideShow) { //all images including favorites (if there are favorites)
	    	  
	    	 
	    	  if (matrix_ != null) {
	    		  
	    		  if (pixelHardwareID.substring(0,4).equals("PIXL")) {
	    	  		  try {
						matrix_.interactive();
					} catch (ConnectionLostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  	     x = 0; //without this, the slideshow will not complete on the second run and will only work the first time
				  	  
				  	     SlideShowLength = SlideShowLengthAll;
				  	     
					     System.arraycopy(SlideShowArrayAll, 0, SlideShowArray, 0, SlideShowArrayAll.length);
				  	     
				  	     writeSlideShow();
	    		  }
	    		  else {
	    			  showToast(getString(R.string.WritingOnlyOnV2));
	    		  }
	    	  }
	    	  else {
	    		  showToast(getString(R.string.PIXELNotFound));
	    	  }
	 	   }
	      
	     if (item.getItemId() == R.id.stop_SlideShow) {
	 	    	//stopSlideShow();
	    	 
	    	 if (matrix_ != null) { //TO DO check to make sure this is the right code
	    		  
	    		  if (pixelHardwareID.substring(0,4).equals("PIXL")) {
		    	  		
	    			  	stopTimers();
		    			  
		    			  try {
								matrix_.interactive();
							} catch (ConnectionLostException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	    		  }
	    	 }	  
	 	   }
	     
	    	
		  if (item.getItemId() == R.id.menu_about) {
			  
			    AlertDialog.Builder alert=new AlertDialog.Builder(this);
		      	alert.setTitle(getString(R.string.menu_about_title)).setIcon(R.drawable.icon).setMessage(getString(R.string.menu_about_summary) + "\n\n" + getString(R.string.versionString) + " " + app_ver + "\n"
		      			+ getString(R.string.FirmwareVersionString) + " " + pixelFirmware + "\n"
		      			+ getString(R.string.HardwareVersionString) + " " + pixelHardwareID + "\n"
		      			+ getString(R.string.BootloaderVersionString) + " " + pixelBootloader + "\n"
		      			+ getString(R.string.LibraryVersionString) + " " + IOIOLibVersion).setNeutralButton(getResources().getString(R.string.OKText), null).show();	
		   }
		  
		  if (item.getItemId() == R.id.menu_refreshArt) {
			  
			  //made a change here and put this as a background task, it was crashing on some handsets
			  
			  AsyncRefreshArt asyncRefreshArt_ = new AsyncRefreshArt();
			  asyncRefreshArt_.execute();
		      	
		  }
	    	
	    	if (item.getItemId() == R.id.menu_prefs)
	       {
	    		
	    		if (imagedisplaydurationTimer != null) imagedisplaydurationTimer.cancel(); 
	     		if (pausebetweenimagesdurationTimer != null) pausebetweenimagesdurationTimer.cancel();
	    		
	    		appAlreadyStarted = 0;    		
	    		Intent intent = new Intent()
	       				.setClass(this,
	       						com.ledpixelart.piledriver.preferences.class);   
	    				this.startActivityForResult(intent, WENT_TO_PREFERENCES);
	       }
	    	
	    	if (item.getItemId() == R.id.menu_btPair)
		       {
	    			
	    		if (pixelHardwareID.substring(0,4).equals("MINT")) { //then it's a PIXEL V1 unit
	    			showToast(getString(R.string.BluetoothPairInstructionsV1));
	    		}
	    		else { //we have a PIXEL V2 unit
	    			showToast(getString(R.string.BluetoothPairInstructionsV2));
	    		}
	    		
	    		Intent intent = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
		        startActivityForResult(intent, REQUEST_PAIR_DEVICE);
		        
		       }
	    	

	    	if (item.getItemId() == R.id.menu_pixelJoint)
		       {
	    			String downloadURL = "www.pixeljoint.com/pixels/new_icons.asp?search=&dimo=%3D&dim=32&colorso=%3E%3D&colors=2&tran=&anim=&iso=&av=&owner=&d=&dosearch=1&ob=search&action=search";
	    			
	    			if (currentResolution == 128) { //if 64x64
	    				downloadURL = downloadURL_64;
	    			}
	    			else {
	    				downloadURL = downloadURL_32;
	    			}
	    			
			    	Intent i = new Intent(Intent.ACTION_VIEW);
			    	i.setData(Uri.parse("http://" + downloadURL));
			    	startActivity(i);
		       }
	    	
	    	if (item.getItemId() == R.id.menu_camera)
		       {
	    		Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	    	    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
	    	     startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
	    	    }
		       }
	    	
	    	
	    	
	    	//Intent intent = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
	        //startActivityForResult(intent, REQUEST_PAIR_DEVICE);
	    	
	    	/*if (item.getItemId() == R.id.menu_galleryPick)
		       {
	    		
	    		 	Intent intent = new Intent(); 
	    		    intent.setType("image/jpeg");
	    		    intent.setAction(Intent.ACTION_GET_CONTENT);
	    		    startActivityForResult(Intent.createChooser(intent, getResources().getString(R.string.select_picture)),GALLERY_INTENT_CALLED);
	    		
	    		
	    		
	    		
	    		Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
	    	    photoPickerIntent.setType("image/*");
	    	    startActivityForResult(photoPickerIntent, REQUEST_CODE_CHOOSE_PICTURE_FROM_GALLERY);
	    		
	    		//Intent photoPickerIntent = new Intent(Intent.ACTION_GET_CONTENT);
	    		//photoPickerIntent.setType("image/*");
	    		//startActivityForResult(photoPickerIntent, REQUEST_CODE_CHOOSE_PICTURE_FROM_GALLERY);
	    		
	    		//if (Build.VERSION.SDK_INT <19){
	    		    Intent intent = new Intent(); 
	    		    intent.setType("image/jpeg");
	    		    intent.setAction(Intent.ACTION_GET_CONTENT);
	    		    startActivityForResult(Intent.createChooser(intent, getResources().getString(R.string.select_picture)),REQUEST_CODE_CHOOSE_PICTURE_FROM_GALLERY);
	    		//} else {
	    		 //   Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
	    		  //  intent.addCategory(Intent.CATEGORY_OPENABLE);
	    		  //  intent.setType("image/jpeg");
	    		  //  startActivityForResult(intent, GALLERY_KITKAT_INTENT_CALLED);
	    		//}
	    		
		       }*/
	    	
	       return true;
	    }
	    
	 
public class AsyncRefreshArt extends AsyncTask<Void, String, Void> {
  	  
	  File pngPath = new File(PNGPath);
	  File pngPath64 = new File(PNG64Path);
	  File pngPath16 = new File(PNG16Path);
	  
	  File gifPath = new File(GIFPath);
	  File gifPathDecoded = new File(GIFPath + "decoded");
	  File gifPathSource = new File(GIFPath + "gifsource");
	  
	  File gifPath64 = new File(GIF64Path);
	  File gifPathDecoded64 = new File(GIF64Path + "decoded");
	  File gifPathSource64 = new File(GIF64Path + "gifsource");
	  
	  File gifPath16 = new File(GIF16Path);
	  File gifPathDecoded16 = new File(GIF16Path + "decoded");
	  File gifPathSource16 = new File(GIF16Path + "gifsource");
	  
	  File ObbDir = new File(Environment.getExternalStorageDirectory() + "/Android/obb/com.ledpixelart.piledriver"); //where the two expansion APK files are stored
	  
	  

  	  @Override
  	  protected void onPreExecute() {
		  stopTimers();
  	   super.onPreExecute();
  	  }

  	  @Override
  	  protected Void doInBackground(Void... params) {
  		  
      	//we're going to load the user favorited items first !
  		  
  		  DeleteRecursive(pngPath);  
		  DeleteRecursive(pngPath64); 
		  DeleteRecursive(pngPath16);  
		 
		  DeleteRecursive(gifPath);  
		  DeleteRecursive(gifPathDecoded);  
		  DeleteRecursive(gifPathSource);  
		  
		  DeleteRecursive(gifPath64);  
		  DeleteRecursive(gifPathDecoded64);  
		  DeleteRecursive(gifPathSource64); 
		  
		  DeleteRecursive(gifPath16);  
		  DeleteRecursive(gifPathDecoded16);  
		  DeleteRecursive(gifPathSource16);  
		  
		  DeleteRecursive(ObbDir);
		  
		  //reset the obb unzip flags
		  editor = prefs.edit(); //let's write the preference that we need to unzip the files again because a new one was downloaded
   	      editor.putBoolean("patchAPKUnzippedPref", false);
   	      editor.putBoolean("mainAPKUnzippedPref", false); //to do for now, we'll unzip both but perhaps this is a more elegant way to unzip only the new one?
   	      editor.putLong("APKExpMainFileSizePref", 0); 
   	      editor.putLong("APKExpPatchFileSizePref", 0); 
   	      editor.commit();
	   	  
	 return null;
	 
	}	  

  	  @Override
  	  protected void onProgressUpdate(String... values) {
  	  
  	   super.onProgressUpdate(values);
  	  }

  	  @Override
  	  protected void onPostExecute(Void result) {
  	   
  		 LoadGridView(false);
  		 AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
	     alert.setTitle(getString(R.string.menu_refresh_title)).setIcon(R.drawable.icon).setMessage(getString(R.string.menu_refresh_summary)).setNeutralButton(getResources().getString(R.string.OKText), null).show();	  
  	     super.onPostExecute(result);
  	  }

  	 }  
	    
	    
	  private void DeleteRecursive(File fileOrDirectory) {
	        if (fileOrDirectory.isDirectory())
	            for (File child : fileOrDirectory.listFiles())
	                DeleteRecursive(child);

	        fileOrDirectory.delete();
	    }

	@Override
	    public void onActivityResult(int reqCode, int resCode, Intent data) //we'll go into a reset after this
	    {
	    	super.onActivityResult(reqCode, resCode, data);    	
	    	
	    	
	    	//if (resCode == WENT_TO_PREFERENCES)  { //had resCode here, this dosn't seem to work, fires when we go to preferences, not when we return from preferences so instead let's add setPreferences to to ioio setup routine
	    		
	    		//TO DO do we need to cancel the slideshow timers here? test this
	    		
	    		//setPreferences(); //very important to have this here, after the menu comes back this is called, we'll want to apply the new prefs without having to re-start the app
	    		//showToast("returned from preferences");
	    	//}	
	    	
	    	//if (reqCode == 0 || reqCode == 1) //then we came back from the preferences menu so re-load all images from the sd card, 1 is a re-scan
	    	//if (reqCode == 1)
	    	//{
	    		//showToast("result ok");
	    		//setupViews();
	    	    //setProgressBarIndeterminateVisibility(true); 
	    	    //loadImages();      
	        //}
	    	
	    	/*if (reqCode == REQUEST_CODE_CHOOSE_PICTURE_FROM_GALLERY) { //not using this one right now
	    		
	    		 if (null == data) {
	    			 showToast("Sorry, an error occurred");
	    		 }
	    		 else {
	    		 Uri originalUri = null;
	    		 originalUri = data.getData();
	    		 String uriPath = originalUri.toString();
	    		 showToast(uriPath);
	    		 }
	    	}	*/
	    	
	    	if (reqCode == REQUEST_IMAGE_CAPTURE && resCode == RESULT_OK) {  //we'll get the picture and write is to the userpng sd card directory and then load into the gridview like any other png or gif
	            Bundle extras = data.getExtras();
	            cameraBMP = (Bitmap) extras.get("data");
	            
	            //let's make sure our directory is there fist and create it if not
	           File outPath = new File(userPNGPath);
    		   if (!outPath.exists()) {  //create the dir if it does not exist
				  outPath.mkdirs();
			   }
	            
	            //let's save this bitmap to the sd card and then load it also
	        
	           OutputStream stream = null;
	           File newCamerafile = new File(userPNGPath + "camerapic.png");
	           String newCamerafileString = null;
	   		   
				if (newCamerafile.exists() && saveMultipleCameraPics_ == true) {  //if the file is already there AND we should save multiple camera images, then we need to create a unique name
	   				  String uuid = UUID.randomUUID().toString();
	   				  try {
						stream = new FileOutputStream(userPNGPath  + uuid + ".png");
						newCamerafileString = userPNGPath  + uuid + ".png";
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	   			  }
	   			  else {
	   				try {
						stream = new FileOutputStream(userPNGPath + "camerapic.png");
						newCamerafileString = userPNGPath + "camerapic.png";
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	   			  }
				
	            /* Write bitmap to file using JPEG or PNG and 100% quality hint for JPEG. */
	            cameraBMP.compress(CompressFormat.PNG, 100, stream);
	            try {
					stream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 			 
 			  //we've copied in the new file so now we need to add it to the gridview
 			  //myImageAdapter.add(newCamerafileString);
 			  items.add(newCamerafileString); //TO DO be sure and test the camera still works
 			  //now let's re-load
 			  continueOnCreate();
 			  
 			  //now let's stream it
 			 //this part won't work actually because after this happens, we go back to IOIO setup which resets everything 
 			/*  imagePath = newCamerafileString;
     		try {
     			matrix_.interactive();  //this has to be here in case we were in interactive mode from a previous long tap
     			WriteImagetoMatrix();
				} catch (ConnectionLostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
 			 
	            //well this isn't working out so instead let's write to the sd card and treat it like any other image in this program but always overwrite so there is only one camera image
	            
	           /* if (saveMultipleCameraPics_ == true) { //we'll write to the SD card
	            	try {
						matrix_.interactive();
						matrix_.writeFile(100);
						WriteCameratoMatrix(cameraBMP);
	        			////matrix_.playFile();
	        			showToast("went here");
	        			
					} catch (ConnectionLostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
	            }
	            else { //just stream
	            	  try {
	            		  matrix_.interactive();
	            		  WriteCameratoMatrix(cameraBMP);
	  				} catch (ConnectionLostException e) {
	  					// TODO Auto-generated catch block
	  					e.printStackTrace();
	  				}
	            }*/
	            //add preference to write camera or stream
	        }
	    	
	    	
	    	
	    		//	Uri selectedImageURI = data.getData();
	    		
	    		//if (selectedImageURI != null) {
	    		        // Update UI to reflect image being shared
	    		  //  	String uriPath = selectedImageURI.toString();
	    		    	//showToast(uriPath);    	
	    		///}
	    		 
	    		

	    		 
	    	//	imageFile = new File(getRealPathFromURI(selectedImageURI));
	           //fdsafsadf
	    		//data.getAction();
	    		//String uripath = data.getDataString();
	    		//showToast(uripath);
	    		//showToast(uriPath);
	    		// Log.d("onActivityResult","uriImagePath Gallary :"+data.getData().toString());  
	         //  showToast("uriImagePath Gallary :"+ data.getData().toString());
	            ///Uri imageUri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
	     	   
	    	    
	    	  //  if (imageUri != null) {
	    	        // Update UI to reflect image being shared
	    	    //	String uriPath = imageUri.toString();
	    	    	//showToast(uriPath);
	    	    	
	    	    	/*
	    	         * Get the file's content URI from the incoming Intent, then
	    	         * get the file's MIME type
	    	         */
	    	        //Uri returnUri = returnIntent.getData();
	    	        //String mimeType = getContentResolver().getType(imageUri);
	            
	            
	            
	            
	            
	            
	          //  Intent intentGallary = new Intent(mContext, ShareInfoActivity.class);
	          //  intentGallary.putExtra(IMAGE_DATA, uriImagePath);
	          //  intentGallary.putExtra(TYPE, "photo");
	         //   File f = new File(imagepath);
	          //  if (!f.exists())
	          //  {
	               // try {
	                  //  f.createNewFile();
	                //    copyFile(new File(getRealPathFromURI(data.getData())), f);
	              //  } catch (IOException e) {
	                    // TODO Auto-generated catch block
	                //    e.printStackTrace();
	              //  }
	          //  }
	
	         //   startActivity(intentGallary);
	        //    finish();
     
	    	//}
            
	    	
	    	
	       //}
	    } 
	
	/**
	 * @return Number of Mega bytes available on External storage
	 */
	  public static long getAvailableSpaceInMB(){
	    final long SIZE_KB = 1024L;
	    final long SIZE_MB = SIZE_KB * SIZE_KB;
	    long availableSpace = -1L;
	    StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
	    availableSpace = (long) stat.getAvailableBlocks() * (long) stat.getBlockSize();
	    return availableSpace/SIZE_MB;
	  }

	    
	    private void setPreferences() //here is where we read the shared preferences into variables
	    {
	   //  SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);  
	    	//we are going to go here many times but let's not set the matrix KIND if the IOIO is not connected
	    	
	     //slideShowMode = prefs.getBoolean("pref_slideshowMode", false);
	     noSleep = prefs.getBoolean("pref_noSleep", false);
	     debug_ = prefs.getBoolean("pref_debugMode", false);
	     kioskMode_ = prefs.getBoolean("pref_kioskMode", false);
	     gifonly_ = prefs.getBoolean("pref_gifonly", false); //only load gifs, don't load static pngs if true
	     only64_ = prefs.getBoolean("pref_only64", false); //only show 64x64 content
	     showStartupMsg_ = prefs.getBoolean("pref_showStartupMsg", true); //show the "long tap to write to pixel message
	     saveMultipleCameraPics_ = prefs.getBoolean("pref_writeCamera", false);
	     slideShowAllPNGs_ = prefs.getBoolean("pref_slideShowAllPNGs", false);
	     DisableNewArtCheck_ = prefs.getBoolean("pref_DisableNewArtCheck", false);
	     AutoSelectPanel_ = prefs.getBoolean("pref_AutoSelectPanel", true);
	     
	   
	     matrix_model = Integer.valueOf(prefs.getString(   //the selected RGB LED Matrix Type
	    	        resources.getString(R.string.selected_matrix),
	    	        resources.getString(R.string.matrix_default_value))); 
	     
	     gridScale = Integer.valueOf(prefs.getString(   //size of the image grid, higher number is more columns
	    	        resources.getString(R.string.gridSize),
	    	        resources.getString(R.string.gridSizeDefault)));
	     
	     int slideshowGIFFrameDelay_ = Integer.valueOf(prefs.getString(   //the selected RGB LED Matrix Type
	    	        resources.getString(R.string.slideshowGIFFPS_key),
	    	        resources.getString(R.string.slideshowGIFFPS_default_value))); 
	     
	     downloadURL_32 = prefs.getString(   //the selected RGB LED Matrix Type
	    	        resources.getString(R.string.downloadURL_32),
	    	        resources.getString(R.string.downloadURL_32Default)); 
	     
	     downloadURL_64 = prefs.getString(   //the selected RGB LED Matrix Type
	    	        resources.getString(R.string.downloadURL_64),
	    	        resources.getString(R.string.downloadURL_64Default));
	   
	  //   dimDuringSlideShow = prefs.getBoolean("pref_dimDuringSlideShow", true);
	     
	     imageDisplayDuration = Integer.valueOf(prefs.getString(   
	  	        resources.getString(R.string.pref_imageDisplayDuration),
	  	        resources.getString(R.string.imageDisplayDurationDefault)));   
	     
	    if (imageDisplayDuration < 1 || imageDisplayDuration > 1000) imageDisplayDuration = 5; //in case someone entered 0
   
	     
	     pauseBetweenImagesDuration = Integer.valueOf(prefs.getString(   
	  	        resources.getString(R.string.pref_pauseBetweenImagesDuration),
	  	        resources.getString(R.string.pauseBetweenImagesDurationDefault)));  
	     //it's ok for pauseBetweenImages to be 0
	     
	   /*  FPSOverride_ = Integer.valueOf(prefs.getString(   //the selected RGB LED Matrix Type
	    	        resources.getString(R.string.fps_override),
	    	        resources.getString(R.string.FPSOverrideDefault))); */
	    //this wasn't adding any value so removed it
	     
	     FPSOverride_ = 0; //not using, maybe we add this back later
	     
	     switch (FPSOverride_) {  //get this from the preferences
	     case 0:
	    	 fps = 0;
	    	 break;
	     case 1:
	    	 fps = 5;
	    	 break;
	     case 2:
	    	 fps = 10;
	    	 break;
	     case 3:
	    	 fps = 15;
	    	 break;
	     case 4:
	    	 fps = 24;
	    	 break;
	     case 5:
	    	 fps = 30;
	    	 break;
	     default:	    		 
	    	 fps = 0;
	     }
	     
	     switch (slideshowGIFFrameDelay_) {  //get this from the preferences
	     case 0:
	    	 slideshowGIFFrameDelay = 1000;
	    	 break;
	     case 1:
	    	 slideshowGIFFrameDelay = 500;
	    	 break;
	     case 2:
	    	 slideshowGIFFrameDelay = 200;
	    	 break;
	     case 3:
	    	 slideshowGIFFrameDelay = 142;
	    	 break;
	     case 4:
	    	 slideshowGIFFrameDelay = 100;
	    	 break;
	     case 5:
	    	 slideshowGIFFrameDelay = 66;
	    	 break;
	     case 6:
	    	 slideshowGIFFrameDelay = 62;
	    	 break;
	     case 7:
	    	 slideshowGIFFrameDelay = 42;
	    	 break;
	     case 8:
	    	 slideshowGIFFrameDelay = 33;
	    	 break;
	     default:	    		 
	    	 slideshowGIFFrameDelay = 100;
	     }
	   
	    /* PIXEL V2 supported panels
	     I: 32x16 adafruit
	     P: 32x32 seeed, the panel for PIXEL V2
	     S: 64x64 seeed, super pixel original
	     K: 32x32 seeed kiosk no writing
	     V: 64x64 seeed kiosk no writing

	     PIXEL V2.5 additional supported panels
	     Q: 32x32 adafruit d pin
	     C: 32x32 adafruit color swap
	     R: 64x32 adafruit d pin
	     T: 64x64 adafruit
	     X: 64x64 adafruit kiosk no writing
	     Y: 32x32 adafruit d pin kiosk no writing

	     L: 32x16 low power and 32x16
	     M: 32x32 low power and Seeed 32x32
	     N: 32x32 low power and Adafruit 32x32 D-Pin*/
	     
	     //if (AutoSelectPanel_ && !pixelHardwareID.substring(0,4).equals("PIXL") && pixelHardwareID.substring(0,4).equals("XXXXX")) { //if auto select is on and it's NOT a PIXEL V2 board AND it's a PIXEL V2.5 or above board
	    
		  if (AutoSelectPanel_ && pixelHardwareID.substring(0,4).equals("PIXL") && !pixelFirmware.substring(4,5).equals("0")) { // PIXL0008 or PIXL0009 is the normal so if it's just a 0 for the 5th character, then we don't go here
		    	
		    	 	//let's first check if we have a matching firmware to auto-select and if not, we'll just go what the matrix from preferences
			  
			  		if (pixelFirmware.substring(4,5).equals("Q")) {
		    	 		matrix_model = 11;
		    	 		KIND = ioio.lib.api.RgbLedMatrix.Matrix.ADAFRUIT_32x32;
				    	BitmapInputStream = getResources().openRawResource(R.raw.selectimage32);
				    	frame_length = 2048;
				    	currentResolution = 32; 
		    	 	}
		    	 	else if (pixelFirmware.substring(4,5).equals("T")) {
		    	 		matrix_model = 14;
		    	 		KIND = ioio.lib.api.RgbLedMatrix.Matrix.ADAFRUIT_64x64;
				    	BitmapInputStream = getResources().openRawResource(R.raw.select64by64);
				    	frame_length = 8192;
				    	currentResolution = 128; 
		    	 	}
		    	 	else if (pixelFirmware.substring(4,5).equals("I")) {
		    	 		matrix_model = 1; 
		    	 		KIND = ioio.lib.api.RgbLedMatrix.Matrix.ADAFRUIT_32x16;
				    	BitmapInputStream = getResources().openRawResource(R.raw.selectimage16);
				    	frame_length = 1024;
				    	currentResolution = 16;
		    	 	}
		    	 	else if (pixelFirmware.substring(4,5).equals("L")) { //low power
		    	 		matrix_model = 1; 
		    	 		KIND = ioio.lib.api.RgbLedMatrix.Matrix.ADAFRUIT_32x16;
				    	BitmapInputStream = getResources().openRawResource(R.raw.selectimage16);
				    	frame_length = 1024;
				    	currentResolution = 16;
		    	 	}
		    	 	else if (pixelFirmware.substring(4,5).equals("C")) {
		    	 		matrix_model = 12; 
		    	 		KIND = ioio.lib.api.RgbLedMatrix.Matrix.ADAFRUIT_32x32_ColorSwap;
				    	BitmapInputStream = getResources().openRawResource(R.raw.selectimage32);
				    	frame_length = 2048;
				    	currentResolution = 32; 
		    	 	}
		    	 	else if (pixelFirmware.substring(4,5).equals("R")) {
		    	 		matrix_model = 13; 
		    	 		KIND = ioio.lib.api.RgbLedMatrix.Matrix.ADAFRUIT_64x32;
				    	BitmapInputStream = getResources().openRawResource(R.raw.select64by32);
				    	frame_length = 4096;
				    	currentResolution = 64; 
		    	 	}
		    	 	else if (pixelFirmware.substring(4,5).equals("M")) { //low power
		    	 		 matrix_model = 3;
		    	 		 KIND = ioio.lib.api.RgbLedMatrix.Matrix.SEEEDSTUDIO_32x32; //pixel v2
				    	 BitmapInputStream = getResources().openRawResource(R.raw.selectimage32);
				    	 frame_length = 2048;
				    	 currentResolution = 32;
		    	 	}
		    	 	else if (pixelFirmware.substring(4,5).equals("N")) { //low power
		    	 		 matrix_model = 11;
		    	 		 KIND = ioio.lib.api.RgbLedMatrix.Matrix.ADAFRUIT_32x32; //pixel v2.5
				    	 BitmapInputStream = getResources().openRawResource(R.raw.selectimage32);
				    	 frame_length = 2048;
				    	 currentResolution = 32; 
		    	 	}
		    	 	else {  //in theory, we should never go here
		    	 		KIND = ioio.lib.api.RgbLedMatrix.Matrix.ADAFRUIT_32x32;
				    	BitmapInputStream = getResources().openRawResource(R.raw.selectimage32);
				    	frame_length = 2048;
				    	currentResolution = 32; 
		    	 	}
		  		}	
		  
		       else {
			     switch (matrix_model) {  //get this from the preferences
				     case 0:
				    	 KIND = ioio.lib.api.RgbLedMatrix.Matrix.SEEEDSTUDIO_32x16;
				    	 BitmapInputStream = getResources().openRawResource(R.raw.selectimage16);
				    	 frame_length = 1024;
				    	 currentResolution = 16;
				    	 break;
				     case 1:
				    	 KIND = ioio.lib.api.RgbLedMatrix.Matrix.ADAFRUIT_32x16;
				    	 BitmapInputStream = getResources().openRawResource(R.raw.selectimage16);
				    	 frame_length = 1024;
				    	 currentResolution = 16;
				    	 break;
				     case 2:
				    	 KIND = ioio.lib.api.RgbLedMatrix.Matrix.SEEEDSTUDIO_32x32_NEW; //v1, this matrix was never used
				    	 BitmapInputStream = getResources().openRawResource(R.raw.selectimage32);
				    	 frame_length = 2048;
				    	 currentResolution = 32;
				    	 break;
				     case 3:
				    	 KIND = ioio.lib.api.RgbLedMatrix.Matrix.SEEEDSTUDIO_32x32; //v2
				    	 BitmapInputStream = getResources().openRawResource(R.raw.selectimage32);
				    	 frame_length = 2048;
				    	 currentResolution = 32;
				    	 break;
				     case 4:
				    	 KIND = ioio.lib.api.RgbLedMatrix.Matrix.SEEEDSTUDIO_64x32; 
				    	 BitmapInputStream = getResources().openRawResource(R.raw.select64by32);
				    	 frame_length = 8192;
				    	 currentResolution = 64; 
				    	 break;
				     case 5:
				    	 KIND = ioio.lib.api.RgbLedMatrix.Matrix.SEEEDSTUDIO_32x64; 
				    	 BitmapInputStream = getResources().openRawResource(R.raw.select32by64);
				    	 frame_length = 8192;
				    	 currentResolution = 64; 
				    	 break;	 
				     case 6:
				    	 KIND = ioio.lib.api.RgbLedMatrix.Matrix.SEEEDSTUDIO_2_MIRRORED; 
				    	 BitmapInputStream = getResources().openRawResource(R.raw.select32by64);
				    	 frame_length = 8192;
				    	 currentResolution = 64; 
				    	 break;	 	 
				     case 7: //this one doesn't work and we don't use it rigth now
				    	 KIND = ioio.lib.api.RgbLedMatrix.Matrix.SEEEDSTUDIO_4_MIRRORED;
				    	 BitmapInputStream = getResources().openRawResource(R.raw.select32by64);
				    	 frame_length = 8192; //original 8192
				    	 currentResolution = 128; //original 128
				    	 break;
				     case 8:
				    	 KIND = ioio.lib.api.RgbLedMatrix.Matrix.SEEEDSTUDIO_128x32; //horizontal
				    	 BitmapInputStream = getResources().openRawResource(R.raw.select128by32);
				    	 frame_length = 8192;
				    	 currentResolution = 128;  
				    	 break;	 
				     case 9:
				    	 KIND = ioio.lib.api.RgbLedMatrix.Matrix.SEEEDSTUDIO_32x128; //vertical mount
				    	 BitmapInputStream = getResources().openRawResource(R.raw.select32by128);
				    	 frame_length = 8192;
				    	 currentResolution = 128; 
				    	 break;	 
				     case 10:
				    	 KIND = ioio.lib.api.RgbLedMatrix.Matrix.SEEEDSTUDIO_64x64;
				    	 BitmapInputStream = getResources().openRawResource(R.raw.select64by64);
				    	 frame_length = 8192;
				    	 currentResolution = 128; 
				    	 break;
				     case 11:
				    	 KIND = ioio.lib.api.RgbLedMatrix.Matrix.ADAFRUIT_32x32;
				    	 BitmapInputStream = getResources().openRawResource(R.raw.selectimage32);
				    	 frame_length = 2048;
				    	 currentResolution = 32; 
				    	 break;	 
				     case 12:
				    	 KIND = ioio.lib.api.RgbLedMatrix.Matrix.ADAFRUIT_32x32_ColorSwap;
				    	 BitmapInputStream = getResources().openRawResource(R.raw.selectimage32);
				    	 frame_length = 2048;
				    	 currentResolution = 32; 
				    	 break;	 	 
				     case 13:
				    	 KIND = ioio.lib.api.RgbLedMatrix.Matrix.ADAFRUIT_64x32;
				    	 BitmapInputStream = getResources().openRawResource(R.raw.select64by32);
				    	 frame_length = 4096;
				    	 currentResolution = 64; 
				    	 break;	
				     case 14:
				    	 KIND = ioio.lib.api.RgbLedMatrix.Matrix.ADAFRUIT_64x64;
				    	 BitmapInputStream = getResources().openRawResource(R.raw.select64by64);
				    	 frame_length = 8192;
				    	 currentResolution = 128; 
				    	 break;	 	 	
				     default:	    		 
				    	 KIND = ioio.lib.api.RgbLedMatrix.Matrix.SEEEDSTUDIO_32x32; //v2 as the default
				    	 BitmapInputStream = getResources().openRawResource(R.raw.selectimage32);
				    	 frame_length = 2048;
				    	 currentResolution = 32;
				     }
		    	 }
		         
		     frame_ = new short [KIND.width * KIND.height];
			 BitmapBytes = new byte[KIND.width * KIND.height *2]; //512 * 2 = 1024 or 1024 * 2 = 2048
			 
			 loadRGB565(); //load the select pic raw565 file
			 
			// if (imagedisplaydurationTimer != null) imagedisplaydurationTimer.cancel();
		    // if (pausebetweenimagesdurationTimer != null) pausebetweenimagesdurationTimer.cancel();
			 
	
		     
		     stopTimers();
			 
			 imagedisplaydurationTimer = new ImageDisplayDurationTimer(imageDisplayDuration*1000,1000); //how long the image should display
		 	 pausebetweenimagesdurationTimer = new PauseBetweenImagesDurationTimer(pauseBetweenImagesDuration*1000,1000); //how long to show a blank screen before showing the next image
		 	
		 	 slideShowRunning = 0;
		 	 
		 	//int BoardID = Integer.valueOf(pixelBootloader.substring(6,8)); //
		 	 
		 	int BoardID = 0;
	
		 	try {
		 		BoardID = Integer.parseInt(pixelBootloader.substring(6,8)); //IOIO0401
		 		//showToast(String.valueOf(BoardID));
		 	} catch(NumberFormatException nfe) {
		 	  // Handle parse error.
		 	}
		 	 
		 	 //if (matrix_model > 10 && pixelHardwareID.substring(0,4).equals("PIXL")) { //we have a PIXEL V2 board
		 	 if (matrix_model > 10 && BoardID < 24 && BoardID !=0) { //we have a PIXEL V2 board pixl0025 or IOIO0401   25 or 01 pixl0025 TO DO Change this later to hardware ID
		 		AlertDialog.Builder alert=new AlertDialog.Builder(this);
				alert.setTitle(getResources().getString(R.string.unsupportedPanel)).setIcon(R.drawable.icon).setMessage(getResources().getString(R.string.unsupportedPanelMsg)).setNeutralButton(getResources().getString(R.string.OKText), null).show();	
		 	 }
	 	 
	 	 //need to do this to refresh the slide array
	    // myAsyncTaskLoadFiles = new AsyncTaskLoadFiles(myImageAdapter, false);
        // myAsyncTaskLoadFiles.execute();
	 }
	
	    
	    private void updatePrefs() //here is where we read the shared preferences into variables
	    {
	    	 SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);     
	    	 setPreferences();
	    	 
	    	 //need this part in case the user updates the grid size with preferences so we can adjust dynamically without having to re-start the app
	    	 int numColumns = 2; //default
	 	     if (targetScreenResolution < 481) {  //my droidX is 480 width as an example, samsung gs4 and gs4 is 1080 width, nexus 4 is 768, nexus 7 original is 800
	 	    	 numColumns = targetScreenResolution / (128 / MainActivity.gridScale); //128
	 	    	 //showToast(String.valueOf(numColumns));
	 	    	 gridview.setNumColumns(numColumns);
	 	     }
	 	     else {
	 	    	 numColumns = targetScreenResolution / (256 / MainActivity.gridScale); //256
	 	    	 //showToast(String.valueOf(numColumns));
	 	    	 gridview.setNumColumns(numColumns);
	 	     }
		 	 
		 	 LoadGridView(false);
	 }
	    
    
	
    
    class IOIOThread extends BaseIOIOLooper {
  	

  		@Override
  		protected void setup() throws ConnectionLostException { //we'll always come back here after an intent or loss of connection
  			
  			//matrix_ = ioio_.openRgbLedMatrix(KIND); //had to move this down because of the auto panel detect code below
  			deviceFound = true; //if we went here, then we are connected over bluetooth or USB
  			
  			if (connectTimer != null) connectTimer.cancel(); //we can stop this timer since we found PIXEL
  	
  			//**** let's get IOIO version info for the About Screen ****
  			pixelFirmware = ioio_.getImplVersion(v.APP_FIRMWARE_VER);
  			pixelBootloader = ioio_.getImplVersion(v.BOOTLOADER_VER);
  			pixelHardwareID = ioio_.getImplVersion(v.HARDWARE_VER); 
  			IOIOLibVersion = ioio_.getImplVersion(v.IOIOLIB_VER);
  			//**********************************************************
  		
  			if (debug_ == true) {  			
  			   showToast(pixelHardwareID);
  			}
  			
  		   if (AutoSelectPanel_ && pixelHardwareID.substring(0,4).equals("PIXL") && !pixelFirmware.substring(4,5).equals("0")) { //only go here if we have a firmware that is set to auto-detect, otherwise we can skip this
	  			runOnUiThread(new Runnable() 
	  			{
	  			   public void run() 
	  			   {
	  				  
	  				   updatePrefs();
	  				   
	  				   try {
	  					 matrix_ = ioio_.openRgbLedMatrix(KIND);
	 	  	  		     matrix_.frame(frame_); //stream "select image" text to PIXEL
					} catch (ConnectionLostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	  			      
	  			   }
	  			}); 
  			}
  		   
  		   else { //we didn't auto-detect so just go the normal way
  			  matrix_ = ioio_.openRgbLedMatrix(KIND);
  	  		  matrix_.frame(frame_); //stream "select image" text to PIXEL
  		   }
 			
  		   appAlreadyStarted = 1; 
  			
  			if (showStartupMsg_ == true && kioskMode_ == false && pixelHardwareID.substring(0,4).equals("PIXL")) { //if writing is supported
  	        	 showToast(getString(R.string.StartupMessage));
  	        }
  			
  			
  			
  		}

  	//	@Override
  		//public void loop() throws ConnectionLostException {
  		
  			//matrix_.frame(frame_); //doesn't work as well on older hardware if we keep in this loop, bad performance especially on animations
  			//try {
			//	pixelFirmware = ioio_.getImplVersion(v);
			//	showToast(pixelFirmware);
			//} catch (ConnectionLostException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
			//}
  					
  		//}	
  		
  		@Override
		public void disconnected() {   			
  			Log.i(LOG_TAG, "PIXEL disconnected");
			if (debug_ == true) {  			
	  			showToast("Bluetooth Disconnected");
  			}	
			
			deviceFound = false;
		}

		@Override
		public void incompatible() {  //if the wrong firmware is there
			//AlertDialog.Builder alert=new AlertDialog.Builder(context); //causing a crash
			//alert.setTitle(getResources().getString(R.string.notFoundString)).setIcon(R.drawable.icon).setMessage(getResources().getString(R.string.bluetoothPairingString)).setNeutralButton(getResources().getString(R.string.OKText), null).show();	
			showToast("Incompatbile firmware!");
			showToast("This app won't work until you flash PIXEL with the correct firmware!");
			showToast("You can use the PIXEL firmware application on your PC/Mac to upgrade to the correct firmware using the included USB A-A cable");
			Log.e(LOG_TAG, "Incompatbile firmware!");
		}
  		
  		}

  	@Override
  	protected IOIOLooper createIOIOLooper() {
  		return new IOIOThread();
  	}
    
    public void showToast(final String msg) {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Toast toast = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG);
                toast.show();
			}
		});
	}  
    
    private void showToastShort(final String msg) {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Toast toast = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT);
                toast.show();
			}
		});
	} 
    
    public class ConnectTimer extends CountDownTimer
   	{

   		public ConnectTimer(long startTime, long interval)
   			{
   				super(startTime, interval);
   			}

   		@Override
   		public void onFinish()
   			{
   				if (matrix_ == null) {
   					showNotFound(); 					
   				}
   				
   			}

   		@Override
   		public void onTick(long millisUntilFinished)				{
   			//not used
   		}
   	}
    
	 
    public class DecodedTimer extends CountDownTimer
   	{

   		public DecodedTimer(long startTime, long interval)
   			{
   				super(startTime, interval);
   			}

   		@Override
   		public void onFinish()
   			{
   			decodedtimer.start(); //re-start the timer to keep is going
   				
   			}
   		
   		@Override
   		public void onTick(long millisUntilFinished)	{
   			
   			//to do bug: the first frame is not display on pixel the first go around but does get displayed after looping
   			//now we need to read in the raw file, it's already in RGB565 format and scaled so we don't need to do any scaling
   			//Log.d("Animations","inside the decoder timer");
   			
   			//streamPixelAsync streamPixel = new streamPixelAsync();
   			//streamPixel.execute();
   			
   			
   			
   			File file = new File(decodedDirPath + "/" + selectedFileName + ".rgb565");
   			if (file.exists()) {
   				
				
				RandomAccessFile raf = null;
				
				//let's setup the seeker object
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
			
				
				if (x == selectedFileTotalFrames) { // Manju - Reached End of the file.
	   				x = 0;
	   				try {
						raf.seek(0); //go to the beginning of the rgb565 file
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
	   			}
				
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
				//Log.d("PixelAnimations","x is: " + x);
				//Log.d("seeker","seeker is: " + x*frame_length);
				
	   			 
	   			if (frame_length > Integer.MAX_VALUE) {
	   			    try {
						throw new IOException("The file is too big");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	   			}
	   			 
	   			// Create the byte array to hold the data
	   			//byte[] bytes = new byte[(int)length];
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
	   			
	   			//BitmapBytes = bos.toByteArray();
	   			
	   			//now that we have the byte array loaded, load it into the frame short array
	   			
	   			int y = 0;
	     		for (int i = 0; i < frame_.length; i++) {
	     			frame_[i] = (short) (((short) BitmapBytes[y] & 0xFF) | (((short) BitmapBytes[y + 1] & 0xFF) << 8));
	     			y = y + 2;
	     		}
	     		
	     		//we're done with the images so let's recycle them to save memory
	    	   // canvasBitmap.recycle();
	    	 //  bitmap.recycle(); 
	   		
		   		//and then load to the LED matrix
	     		
			   	try {
					matrix_.frame(frame_);
					
				} catch (ConnectionLostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   	x++;
   			}
   			
   			else {
   				showToast("We have a problem, couldn't find the decoded file");
   			}
   		}
   	}

   	
    
    private void showNotFound() {	
		AlertDialog.Builder alert=new AlertDialog.Builder(this);
		alert.setTitle(getResources().getString(R.string.notFoundString)).setIcon(R.drawable.icon).setMessage(getResources().getString(R.string.bluetoothPairingString)).setNeutralButton(getResources().getString(R.string.OKText), null).show();	
    }

	
	public static class GifView extends View {

		public static final int IMAGE_TYPE_UNKNOWN = 0;
		public static final int IMAGE_TYPE_STATIC = 1;
		public static final int IMAGE_TYPE_DYNAMIC = 2;

		public static final int DECODE_STATUS_UNDECODE = 0;
		public static final int DECODE_STATUS_DECODING = 1;
		public static final int DECODE_STATUS_DECODED = 2;

		private GifDecoder decoder;
		private Bitmap bitmap;

		public int imageType = IMAGE_TYPE_UNKNOWN;
		public int decodeStatus = DECODE_STATUS_UNDECODE;

		private int width;
		private int height;

		private long time;
		private int index = 0;

		private int resId;
		private String filePath;

		private boolean playFlag = false;
		//private FileOutputStream fos;  //true means append, false is over-write

		public  GifView(Context context, AttributeSet attrs) {
			super(context, attrs);
		}
		

		/**
		 * Constructor
		 */
		///***** action code in the view is here ************************
		
		public GifView(Context context) {
			super(context);
	       //  LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
	        // setGif(R.drawable.mushroom);
	         //setGif(basepath + "/pixelpiledriver/" + "frank.gif");
	        // Bitmap mBitmap = Bitmap.decodeFile(path.getPath()+"/"+ fileNames[i]);
			
	       //  play();
		}
		
		

		private InputStream getInputStream() {
			if (filePath != null)
				try {
					return new FileInputStream(filePath);
				} catch (FileNotFoundException e) {
				}
			if (resId > 0)
				return getContext().getResources().openRawResource(resId);
			return null;
		}

		/**
		 * set gif file path
		 * 
		 * @param filePath
		 */
		public void setGif(String filePath) {
			Bitmap bitmap = BitmapFactory.decodeFile(filePath);
			setGif(filePath, bitmap);
		}

		/**
		 * set gif file path and cache image
		 * 
		 * @param filePath
		 * @param cacheImage
		 */
		public void setGif(String filePath, Bitmap cacheImage) {
			gifView.setVisibility(View.VISIBLE);
			this.resId = 0;
			this.filePath = filePath;
			imageType = IMAGE_TYPE_UNKNOWN;
			decodeStatus = DECODE_STATUS_UNDECODE;
			playFlag = false;
			bitmap = cacheImage;
			width = bitmap.getWidth();
			height = bitmap.getHeight();
			setLayoutParams(new LayoutParams(width, height));
			//setLayoutParams(new LayoutParams(32, 32)); //changed this because otherwise the larger animations were taking up the whole screen
		}

		/**
		 * set gif resource id
		 * 
		 * @param resId
		 */
		public void setGif(int resId) {
			Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resId);
			setGif(resId, bitmap);
		}

		/**
		 * set gif resource id and cache image
		 * 
		 * @param resId
		 * @param cacheImage
		 */
		
		// to do, handle the case if it's a single frame gif
		public void setGif(int resId, Bitmap cacheImage) {
			gifView.setVisibility(View.VISIBLE);
			this.filePath = null;
			this.resId = resId;
			imageType = IMAGE_TYPE_UNKNOWN;
			decodeStatus = DECODE_STATUS_UNDECODE;
			playFlag = false;
			bitmap = cacheImage;
			width = bitmap.getWidth();
			height = bitmap.getHeight();
			setLayoutParams(new LayoutParams(width, height));
		}

		private void decode() {
			release();
			index = 0;

			decodeStatus = DECODE_STATUS_DECODING;

			new Thread() {
				@Override
				public void run() {
					decoder = new GifDecoder();
					decoder.read(getInputStream());
					if (decoder.width == 0 || decoder.height == 0) {
						imageType = IMAGE_TYPE_STATIC;
					} else {
						imageType = IMAGE_TYPE_DYNAMIC;
					}
					postInvalidate();
					time = System.currentTimeMillis();
					decodeStatus = DECODE_STATUS_DECODED;
				}
			}.start();
		}

		public void release() {
			decoder = null;
		}

		@Override
		protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);

			if (decodeStatus == DECODE_STATUS_UNDECODE) {
				canvas.drawBitmap(bitmap, 100, 100, null);
			
				if (playFlag) {
					decode();
					invalidate();
				}
			} else if (decodeStatus == DECODE_STATUS_DECODING) {
				canvas.drawBitmap(bitmap, 0, 0, null); //could add a decoding in progress message here
				invalidate();
			} else if (decodeStatus == DECODE_STATUS_DECODED) {
				if (imageType == IMAGE_TYPE_STATIC) { //static gif
					canvas.drawBitmap(bitmap, 0, 0, null);
				} else if (imageType == IMAGE_TYPE_DYNAMIC) {
					if (playFlag) {
						//long now = System.currentTimeMillis();
						index++;
						//showToast("delay: " + decoder.getDelay(index)); //took out the time delay to make decoding faster
						/*if (time + decoder.getDelay(index) < now) {
							//time += decoder.getDelay(index);
							incrementFrameIndex(); //this increments the index, we started at 0, so now we start at 1
						}*/
						Bitmap bitmap = decoder.getFrame(index);
						if (bitmap != null) {  //this is the main one, let's ioio here
							//canvas.drawBitmap(bitmap, 0, 0, null); //removed this because we'll re-write to canvas ioioBitmap instead
							
							    width_original = bitmap.getWidth();
					   		    height_original = bitmap.getHeight();
					   		    
						   		 if (width_original != KIND.width || height_original != KIND.height) { //we need to re-size
						    			 resizedFlag = 1;
						    			 //the iamge is not the right dimensions, so we need to re-size
						    			 scaleWidth = ((float) KIND.width) / width_original;
						 	   		 	 scaleHeight = ((float) KIND.height) / height_original;
						 	 	   		 // create matrix for the manipulation
						 	 	   		 matrix2 = new Matrix();
						 	 	   		 // resize the bit map
						 	 	   		 matrix2.postScale(scaleWidth, scaleHeight);
						 	 	   		 //resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, width_original, height_original, matrix2, true);
						 	 	   		 resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, width_original, height_original, matrix2, false);
						 	 	   		 IOIOBitmap = Bitmap.createBitmap(KIND.width, KIND.height, Config.RGB_565); 
						 	 	   		 canvasIOIO = new Canvas(IOIOBitmap);
						 	 	   		 canvasIOIO.drawRGB(0,0,0); //a black background
						 	 	   		 canvasIOIO.drawBitmap(resizedBitmap, 0, 0, null);
						 	 	   		 //ByteBuffer buffer = ByteBuffer.allocate(KIND.width * KIND.height *2); //Create a new buffer
						 	 	   		  buffer = ByteBuffer.allocate(KIND.width * KIND.height *2); //Create a new buffer
						 	 	   		 IOIOBitmap.copyPixelsToBuffer(buffer); //copy the bitmap 565 to the buffer		
						 	 	   		 BitmapBytes = buffer.array(); //copy the buffer into the type array
						 	 	   		 canvas.drawBitmap(IOIOBitmap, 0, 0, null); //where the image gets drawn to the screen
						    		 }
						   		 else {
									 	resizedFlag = 0; 			
										//but need to convert this image to 565 before we can send to the matrix
							   			IOIOBitmap = Bitmap.createBitmap(KIND.width, KIND.height, Config.RGB_565); //blank bitmap
										canvasIOIO = new Canvas(IOIOBitmap); //blank canvas with blank bitmap
										canvasIOIO.drawRGB(0,0,0); //a black background
										canvasIOIO.drawBitmap(bitmap, 0, 0, null); //now let's draw the real .gif bitmap onto it
								 	    ByteBuffer buffer = ByteBuffer.allocate(KIND.width * KIND.height *2); //Create a new buffer
								 	    IOIOBitmap.copyPixelsToBuffer(buffer); //now IOIOBitmap has real bits in it because of the canvas work		
								 	    BitmapBytes = buffer.array(); //copy the buffer into the type array	
								 	    canvas.drawBitmap(IOIOBitmap, 0, 0, null); //write the animated .gif to the screen
						   		 } 
				   		
					   	//**** had to add this as the decoded dir could have been deleted if the user changed the led panel type
					   
					    
					    File decodeddir = new File(decodedDirPath); //this could be gif, gif64, or usergif
					    if(decodeddir.exists() == false)
			             {
					    	decodeddir.mkdirs();
			             }
						//*********************   		 
					   
				   		if (index <= decoder.getFrameCount()) { 	
					   			try {
									//writeFile(BitmapBytes, decodedDirPath + "/" + selectedFileName + "/" + selectedFileName + index + ".rgb565");  //this one the original one
									appendWrite(BitmapBytes, decodedDirPath + "/" + selectedFileName + ".rgb565"); //this writes one big file instead of individual ones
									//Log.d("PixelAnimate","initial write: " + index);
									//Log.d("PixelAnimate", "frame count: " + decoder.getFrameCount());
									//index++;
								  
									
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									Log.e("PixelAnimate", "Had a problem writing the original unified animation rgb565 file");
									e1.printStackTrace();
								}
				   		}
						   		
				   		else {  //ok we're done, now let's write the text file meta data with delay time in between frames and number frames				         
				        ///***************************************************************
				   		Log.v("PixelAnimate", "Frame Count: " + decoder.getFrameCount());
				       // String filetag = String.valueOf(decoder.getFrameCount()) + "," + String.valueOf(decoder.getDelay(index-1)) + "," + String.valueOf(currentResolution);  //our format is number of frames,delay 32,60,32 equals 32 frames, 60 ms time delay, 32 resolution   resolution is 16 for 16x32 or 32 for 32x32 led matrix, we need this in case the user changes the resolution in the app, then we'd need to catch this mismatch and re-decode
				       //note here we're using the delay of the first frame, that becomes the delay for all the frames in the gif
				   		
				   		int frameDelay = decoder.getDelay(1); //we'll use the second frame as some animated gifs have a longer frame rate for the first frame
				   		
				   		if (decoder.getDelay(1) == 0 || decoder.getFrameCount() == 1) {  //the code crashes on a 0 frame delay so we'll need to check that and change to 100 ms if 0 and also if it's a single frame gif, we'll hardcode the frame delay
				   			frameDelay = 100;
				   		}
				   		
				   		//no longer need this because this has been taken care of in the firmware
				   		//the 64x64 configuration skips frame is the speed is greater than 70 so we need to reset the frame speed here if below 70
				   		/*if (currentResolution == 128 && decoder.getDelay(1) < 70) {  //70ms is the fastest for 64x64
				   			frameDelay = 70; //if it's too fast, then we need to slow down to 70ms frame delay
				   		}*/
				   		
				   		Log.v("PixelAnimate", "Frame Delay: " + frameDelay);
				   		
				   		//String filetag = String.valueOf(decoder.getFrameCount()) + "," + String.valueOf(decoder.getDelay(1)) + "," + String.valueOf(currentResolution);  //our format is number of frames,delay 121,60,32 equals 121 frames, 60 ms time delay, 32 resolution   resolution is 16 for 16x32 or 32 for 32x32 led matrix, we need this in case the user changes the resolution in the app, then we'd need to catch this mismatch and re-decode
				   		String filetag = String.valueOf(decoder.getFrameCount()) + "," + String.valueOf(frameDelay) + "," + String.valueOf(currentResolution); //current resolution may need to change to led panel type
				   	 
				        String exStorageState = Environment.getExternalStorageState();
				     	if (Environment.MEDIA_MOUNTED.equals(exStorageState)){
				     		try {
				     			
				     		   File myFile = new File(decodedDirPath + "/" + selectedFileName + ".txt");  //decoded/rain.txt						       
				     		   myFile.createNewFile();
					           FileOutputStream fOut = null;
							   fOut = new FileOutputStream(myFile);
					           OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
							   myOutWriter.append(filetag);  
							  // myOutWriter.append(String.valueOf(decoder.getDelay(index)));
							   myOutWriter.close();
							   fOut.close();
							   
							   //Toast toast1 = Toast.makeText(context, "One Time Decode Finished", Toast.LENGTH_LONG);
						      // toast1.show();	
						       gifView.stop();
						       gifView.setVisibility(View.GONE);
						       MainActivity nonstaticCall = new MainActivity();
						       //*****************************************************
							   //we're done decoding and we've written our file so let's animate!
						       nonstaticCall.letsAnimate();     // this is a hack to make a call to animateAfterDecode which needs to be non-static, didn't have time to make gifview non-static
						     // Log.d("PixelAnimate","made it to the nonstatic call");
						       // animateAfterDecode(0);
				     			
				     		} catch (IOException e) {
				     			e.printStackTrace();
				     			//Toast.makeText(this, "Couldn't save", Toast.LENGTH_SHORT);
				     		}
					     	}
					     	else {					     		
					     		Toast toast2 = Toast.makeText(context, "Storage Not Available, Cannot Continue", Toast.LENGTH_LONG);
						        toast2.show();	
					     	}
				   		}	
					}
						
						invalidate();
					} else {
						Bitmap bitmap = decoder.getFrame(index);
						canvas.drawBitmap(bitmap, 0, 0, null);
					}
				} 
				
				else {
					canvas.drawBitmap(bitmap, 0, 0, null);
				}
			}
			
		
     		//we're done with the images so let's recycle them to save memory
    	   // canvasBitmap.recycle();
    	 //  bitmap.recycle(); 
    	    
    	  //if ( resizedFlag == 1) {
    	    //	IOIOBitmap.recycle(); //only there if we had to resize an image
    	 // }
			
		   
		}
		
		/*public void writeFile(byte[] data, String fileName) throws IOException{
			  FileOutputStream out = new FileOutputStream(fileName);
			  out.write(data);
			  out.close();
		}*/
		
		public void appendWrite(byte[] data, String filename) throws IOException {
			 FileOutputStream fos = new FileOutputStream(filename, true);  //true means append, false is over-write
		     fos.write(data);
		     fos.close();
		}


		/*private void incrementFrameIndex() {
			index++;
			//if (index >= decoder.getFrameCount()) {
			//	index = 0;
			//}
		}

		private void decrementFrameIndex() {
			index--;
			if (index < 0) {
				index = decoder.getFrameCount() - 1;
			}
		}*/

		public void play() {
			time = System.currentTimeMillis();
			playFlag = true;
			invalidate();
		}

		/*public void pause() {
			playFlag = false;
			invalidate();
		}*/

		public void stop() {
			playFlag = false;
			index = 0;
			invalidate();
			
		}

		/*public void nextFrame() {
			if (decodeStatus == DECODE_STATUS_DECODED) {
				incrementFrameIndex();
				invalidate();
			}
		}

		public void prevFrame() {  //not used
			if (decodeStatus == DECODE_STATUS_DECODED) {
				decrementFrameIndex();
				invalidate();
			}
		}*/
	}
	
	
	 public static void clearMatrixImage() throws ConnectionLostException {
	    	//let's claear the image
		 //TO DO add back later
	    	/* BitmapInputStream = getResources().openRawResource(R.raw.blank); //load a blank image to clear it
	    	 loadRGB565();    	
	    	 matrix_.frame(frame_); */
	    	//then let's start another timer to load the next image
	    	pausebetweenimagesdurationTimer.start();  //how long the rgb matrix should be of before showing the next image
	    }
	 
	 
	 private void writeSlideShowGIF() { //we don't need this
		
		 gridview.setKeepScreenOn(true); //enable power savings again	
		 //new createSlideShowGIFAsync().execute();
		 createSlideShowGIFAsync createSlideShowGIFAsync_ = new createSlideShowGIFAsync();
		 createSlideShowGIFAsync_.execute();
		 
		/* if (matrix_ != null) { 
		    	
			 if (kioskMode_ == false) {
			 
	    		stopTimers();
	    		
	    		if (pixelHardwareID.substring(0,4).equals("PIXL")) {  //let's make sure we have a pixelv2 board
	    			   
	    			gridview.setKeepScreenOn(true); //enable power savings again	
	    			new createSlideShowGIFAsync().execute();  
		    			
		    	}
	    		else {
	    			 showToast(getString(R.string.WritingOnlyOnV2));
	    		}
			 }
		 } */
	 }
	 
	 @SuppressLint("ParserError")
	 private void writeSlideShow() {
		if (matrix_ != null) { 
		    	
			 if (kioskMode_ == false) {
			 
	    		stopTimers();
	    		
	    		if (pixelHardwareID.substring(0,4).equals("PIXL")) {  //let's make sure we have a pixelv2 board
	    			   
	    			gridview.setKeepScreenOn(true); //enable power savings again	
	    			new createSlideShowAsync().execute();  
		    			
		    	}
			 }
			 
			 else {
				 try {
					SlideShow(false);
				} catch (ConnectionLostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //let's stream instead
			 }
			 
		 }
	 }
	
	  
	   public static void SlideShow(boolean writeMode) throws ConnectionLostException {
		      	        
	    	if (matrix_ != null) { 
	    		
	    		//we need to kill the timers if they are already running
	    		stopTimers();
	    		
		    		if (slideshowPosition  >= SlideShowLength - 1) { //let's make sure we haven't reached the end, don't forget the -1 or we'll get a crash
			        	slideshowPosition = 0;
			        }
			        
		    		System.out.println (SlideShowArray[slideshowPosition]); 	
			      
			        imagePath = SlideShowArray[slideshowPosition];
		    		
			      
			        WriteImagetoMatrix();	    
			        //Pixel.writeImagetoMatrix(SlideShowArray[slideshowPosition],KIND.width,KIND.height); //crashing TO DO fix this later
			        slideshowPosition++; //increment it so we can play the next one
			        
			        imagedisplaydurationTimer.start(); //the image will stay on for as long as this timer;
		    	    
	    	}
	    	else {
	    		Toast toast = Toast.makeText(context, "PIXEL was not found, did you Bluetooth pair?", Toast.LENGTH_LONG);
		        toast.show();
	    	}
	    }
	    
	    private void stopSlideShow() { //stop the slideshow
	    	
	    	if (pixelHardwareID.substring(0,4).equals("PIXL")) {  
	    		try {
					matrix_.interactive(); //go out of local playback mode
				} catch (ConnectionLostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	
	    	
    	stopTimers(); //kill all the timers
 		
    	Toast toast = Toast.makeText(context, "Stopping Slide Show", Toast.LENGTH_LONG);
	    toast.show();
	    }
	    
	    private static void stopTimers() {
	    	if (imagedisplaydurationTimer != null) imagedisplaydurationTimer.cancel();
     		if (pausebetweenimagesdurationTimer != null) pausebetweenimagesdurationTimer.cancel();
        	if (decodedtimer != null) decodedtimer.cancel();
	    }
	    
	    private class createSlideShowAsync extends AsyncTask<Void, Integer, Void>{
			 
		     int progress_status = 0;
		      
		     @Override
		  protected void onPreExecute() {
			   super.onPreExecute();
			   
			   progress = new ProgressDialog(MainActivity.this);
			      progress.setMax(SlideShowLength);
			      progress.setTitle(getString(R.string.PreparingSlideshow));
			      progress.setMessage(getString(R.string.DoNotInterrupt));
			      progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			      progress.setCancelable(false);
			      progress.setIcon(R.drawable.ic_action_warning);
			      progress.show();
			   
		  }
		      
		  @Override
		  protected Void doInBackground(Void... params) {
			  
			  File decodedFileDir = new File(MainActivity.decodedDirPath); //pixel/decoded  ,create it if not there
				if(decodedFileDir.exists() == false) {
					decodedFileDir.mkdirs();
				}
		        	
	    		File decodedFile = new File(MainActivity.decodedDirPath + "/slideshow.rgb565"); //decoded/slideshow.rgb565 , if it's already there, then we need to delete
	    		if(decodedFile.exists()) {
	    			decodedFile.delete(); //delete the file as we're going to re-create it
	    		}
	    		
	    		File decodedFileTxt = new File(MainActivity.decodedDirPath + "/slideshow.txt"); //pixel/decoded/slideshow.txt  ,delete it if there
				if(decodedFileTxt.exists()) {
					decodedFileTxt.delete(); //delete the file as we're going to re-create it
				}
				
				String filetag = String.valueOf(SlideShowLength*imageDisplayDuration + SlideShowLength*pauseBetweenImagesDuration) + "," + String.valueOf(1000) + "," + String.valueOf(currentResolution);  //our format is number of frames,delay 72,60,32 equals 72 frames, 60 ms time delay, 32 resolution   resolution is 16 for 16x32 or 32 for 32x32 led matrix, we need this in case the user changes the resolution in the app, then we'd need to catch this mismatch and re-decode
		        
		        String exStorageState = Environment.getExternalStorageState();
		     	if (Environment.MEDIA_MOUNTED.equals(exStorageState)){
		     		try {
		     			
		     		   File myFile = new File(decodedDirPath + "/" + "slideshow.txt");  //decoded/gif/slideshow.txt					       
		     		   myFile.createNewFile();
			           FileOutputStream fOut = null;
					   fOut = new FileOutputStream(myFile);
			           OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
					   myOutWriter.append(filetag);
					   myOutWriter.close();
					   fOut.close();
		     			
		     		} catch (IOException e) {
		     			e.printStackTrace();
		     			//Toast.makeText(this, "Couldn't save", Toast.LENGTH_SHORT);
		     		}
		     	}
	    	
	    		int i = 0;
		        
		        for (i = 0; i < SlideShowLength; i++) { 
		        	
		        	imagePath = SlideShowArray[i];
		        	
		        	try {
						WriteImagetoMatrix();
					} catch (ConnectionLostException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	//we are streaming here, not writing
		        	publishProgress(i);
		        	
		        	
		        	//TO DO add a delay here?
		        	
				        //********* now let's add our tween frames including pause black frames in between, tween frames because 1 fps is the slowest we can go, we want slower than that so let's add some tween frames
			        	int y = 0;
			        	for (y = 0; y < imageDisplayDuration; y++) { //since the longest frame delay we can go is 1 second, we'll need to repeat frames here!
			        		
			        		 try {
			 					appendWrite(BitmapBytes, decodedDirPath + "/" + "slideshow" + ".rgb565");
			 				} catch (IOException e) {
			 					// TODO Auto-generated catch block
			 					e.printStackTrace();
			 				}
			        	}
			        	
			        	//and now let's write the black frame for the pause in between, it's possible pauseBetweenImagesDuration can be 0 and hence not execute here
			        	try {
							WritePNG2Matrix(blackFrame_);
						} catch (ConnectionLostException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			        	int p = 0;
			        	for (p = 0; p < pauseBetweenImagesDuration; p++) { //since the longest frame delay we can go is 1 second, we'll need to repeat frames here!
			        		
			        		 try {
			 					appendWrite(BitmapBytes, decodedDirPath + "/" + "slideshow" + ".rgb565");
			 				} catch (IOException e) {
			 					// TODO Auto-generated catch block
			 					e.printStackTrace();
			 				}
				        //***********
			        	}
		        }
		       
		        //add this delay here before we start writing to the sd card
		        try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
		   return null;
		  }
		
		  
		  @Override
		  protected void onProgressUpdate(Integer... values) {
		   super.onProgressUpdate(values);
		   progress.incrementProgressBy(1);
		  }
		   
		  @Override
		  protected void onPostExecute(Void result) {
		   super.onPostExecute(result);
		   //now let's put PIXEL in local playback mode and set fps
		   

		   if (progress != null) progress.dismiss();
		   
		   try {
			gridview.setKeepScreenOn(true);  //need to prevent screen from turning off / power savings during the write
			matrix_.interactive();
			matrix_.writeFile(1); //duhhh!!!! I had this at a 1000, no wonder it was going so fast, writeFile is frames per second as opposed to the ms frame delay which is used in the .txt file, 1 fps is the slowest we can go
			} catch (ConnectionLostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		 
		   writePixelAsyncSlideShow loadApplication = new writePixelAsyncSlideShow();
		   loadApplication.execute();
		   
			}
	} 
	    
	    private class writePixelAsyncSlideShow extends AsyncTask<Void, Integer, Void>{
			
	    	 int progress_status;
		      
			  @Override
			  protected void onPreExecute() {
		      super.onPreExecute();
		    
		      progress = new ProgressDialog(MainActivity.this);
		      progress.setMax(SlideShowLength * imageDisplayDuration + SlideShowLength*pauseBetweenImagesDuration);
		      progress.setTitle(getString(R.string.WritingSlideshow));
		      progress.setMessage(getString(R.string.DoNotInterrupt));
		      progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		      progress.setCancelable(false);
		      progress.setIcon(R.drawable.ic_action_warning);
		      progress.show();
		      
		      Log.i("PixelAnimations ", "Slide Show Length is: " + SlideShowLength);
		      Log.i("PixelAnimations ", "Image Display Duration is: " + imageDisplayDuration);
		      Log.i("PixelAnimations ", "Pause Between Images is: " + pauseBetweenImagesDuration);
		     
		      
		      if (selectedFileResolution == 0) { //then let's set it from the led panel that has been selected
		    	  selectedFileResolution = currentResolution;
		      }
		      
		      Log.i("PixelAnimations ", "Selected File Resoution is: " + selectedFileResolution);
		      
		     
			  }
		      
		  @Override
		  protected Void doInBackground(Void... params) {
				
		  int count = 0;
		  for (count = 0; count < (SlideShowLength*imageDisplayDuration + SlideShowLength*pauseBetweenImagesDuration); count++) { //do we need this minus 1?
					
					  File file = new File(decodedDirPath + "/" + "slideshow" + ".rgb565"); //this is one big file now, no longer separate files
					  
					  RandomAccessFile raf = null;
					  
						//let's setup the seeker object
						try {
							raf = new RandomAccessFile(file, "r");
							
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}  // "r" means open the file for reading
						
						 switch (selectedFileResolution) { //16x32 matrix = 1024k frame size, 32x32 matrix = 2048k frame size
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
							//Log.d("PixelAnimations","from sd card write, x is: " + x);
							x++;
							
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
								Log.i("PixelAnimations ","Could not close the raf");
								e1.printStackTrace();
							}	
								
								//now that we have the byte array loaded, load it into the frame short array
								
							int y = 0;
							for (int i = 0; i < frame_.length; i++) {
								frame_[i] = (short) (((short) BitmapBytes[y] & 0xFF) | (((short) BitmapBytes[y + 1] & 0xFF) << 8));
								y = y + 2;
							}
							
						   	try {
						   	 Log.i("PixelAnimations ","Starting-->"+ count + " " + String.valueOf(SlideShowLength-1));
						   		matrix_.frame(frame_);
						   		progress_status++;
							    publishProgress(progress_status);
						   	
							} catch (ConnectionLostException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				  }  
			    
		   return null;
		  }
		  
		  @Override
		  protected void onProgressUpdate(Integer... values) {
		   super.onProgressUpdate(values);
		   progress.incrementProgressBy(1);
		  }
		   
		  @Override
		  protected void onPostExecute(Void result) {
			  
		  if (progress != null) progress.dismiss();
		
		 
		   try {
			matrix_.playFile();
			gridview.setKeepScreenOn(false); //enable power savings again
		} catch (ConnectionLostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  super.onPostExecute(result);
	}
		
	}
	    
	    private class createSlideShowGIFAsync extends AsyncTask<Void, Integer, Void>{
			 
		     int progress_status = 0;
		      
		     @Override
		  protected void onPreExecute() {
			   super.onPreExecute();
			   
			   progress = new ProgressDialog(MainActivity.this);
			      progress.setMax(SlideShowLengthGIFFavs);
			      progress.setTitle(getString(R.string.PreparingSlideshow));
			      progress.setMessage(getString(R.string.DoNotInterrupt));
			      progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			      progress.setCancelable(false);
			      progress.setIcon(R.drawable.ic_action_warning);
			      progress.show();
			   
		  }
		      
		  @Override
		  protected Void doInBackground(Void... params) {
			  
			  /*here we need to essentially combine a bunch of rgb565 files into one big one
			  so we will concatenate into one big file
			  */
			 
			  
			  File decodedFileDir = new File(MainActivity.FavGIFPath + "decoded"); //pixel/decoded  ,create it if not there
				if(!decodedFileDir.exists()) {
					decodedFileDir.mkdirs();
				}
		        	
	    		File decodedFile = new File(MainActivity.FavGIFPath + "decoded" + "/slideshowgif.rgb565"); //decoded/slideshow.rgb565 , if it's already there, then we need to delete
	    		if(decodedFile.exists()) {
	    			decodedFile.delete(); //delete the file as we're going to re-create it
	    		}
	    		
	    		File decodedFileTxt = new File(MainActivity.FavGIFPath + "decoded" + "/slideshowgif.txt"); //pixel/decoded/slideshow.txt  ,delete it if there
				if(decodedFileTxt.exists()) {
					decodedFileTxt.delete(); //delete the file as we're going to re-create it
				}
	    	
	    		int i = 0;
	    		
	    		Pixel.GIFSlideShowFrameCounter = 0; //this is our counter telling us how many total frames
		        
		        for (i = 0; i < SlideShowLengthGIFFavs; i++) { 
		        	
		        		imagePath = SlideShowGIFFavs[i]; //this is the array of favgifs, remember some can be gif and some png
		        	
		        	    filename_no_extension = Pixel.getNameOnly(imagePath);
				        
				        selectedFileName = filename_no_extension; //not really good coding but selected file name is used elsewhere so we need this here
				        
				        extension_ = Pixel.getExtension(imagePath);
				        
				        if (extension_.equals("png")) {  //then we use the thumbnail, we just need to rename the image path to a gif
				       	
				        		File originalGIF = new File(FavGIFPath + "gifsource/" + filename_no_extension + ".gif"); 
				        		if (originalGIF.exists()) { 
				        			//we've got the original gif so now let's decode it
				        			 String sourceGIFPath = FavGIFPath + "gifsource/" + filename_no_extension + ".gif"; //need to change imagepath to gifsource
				        			 Pixel.decodeGIFSlideShow(sourceGIFPath, currentResolution);  //pass the matrix type
				        			 				        		}
				        		else { //well we tried, no original gif so we'll treat it as a png
						            	//there's no rgb565 and we only have a single frame png so let's just send this single frame png to pixel
							        	
						        		//it's  not there so let's check the original gifs folder, if it's in there, then treat it like a gif and decode
						        		
						        		//imagePath = originalImagePath;
						        		/*try {
											decodePNGNoWrite(imagePath);
										} catch (ConnectionLostException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
						        		
						        		try {
						 					appendWrite(BitmapBytes, FavGIFPath + "decoded" + "/" + "slideshowgif" + ".rgb565");
						 				} catch (IOException e) {
						 					// TODO Auto-generated catch block
						 					e.printStackTrace();
						 				}*/
						        		
						    		    //WriteImagetoMatrix(); //to do but don't write to pixel
						    		    //to do append this frame later
						            }
				        }
				        
				        /*else if (extension_.equals("jpg") || extension_.equals("jpeg")) {  
				        	try {
								decodePNGNoWrite(imagePath);
							} catch (ConnectionLostException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				        	
				        	try {
			 					appendWrite(BitmapBytes, FavGIFPath + "decoded" + "/" + "slideshowgif" + ".rgb565");
			 				} catch (IOException e) {
			 					// TODO Auto-generated catch block
			 					e.printStackTrace();
			 				}
				        	imagePath = originalImagePath;
				        	imagePath = originalImagePath;
			    		    WriteImagetoMatrix();
				        }*/
				        
				       else if (extension_.equals("gif")) {  // if it's not a png, then it's a gif so let's animate
				    	   Pixel.decodeGIFSlideShow(imagePath, currentResolution);  //pass the matrix type
				       } 
			        	
			        	/*//and now let's write the black frame for the pause in between, it's possible pauseBetweenImagesDuration can be 0 and hence not execute here
			        	try {
							WritePNG2Matrix(blackFrame_);
						} catch (ConnectionLostException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			        	int p = 0;
			        	for (p = 0; p < pauseBetweenImagesDuration; p++) { //since the longest frame delay we can go is 1 second, we'll need to repeat frames here!
			        		
			        		 try {
			 					appendWrite(BitmapBytes, decodedDirPath + "/" + "slideshowgif" + ".rgb565");
			 				} catch (IOException e) {
			 					// TODO Auto-generated catch block
			 					e.printStackTrace();
			 				}
				        //***********
			        	}*/
				        
				        publishProgress(i);
				        
		        }
		        
		        //now we're done and we need to write the txt meta data file
		        String filetag = String.valueOf(Pixel.GIFSlideShowFrameCounter) + "," + String.valueOf(slideshowGIFFrameDelay) + "," + String.valueOf(currentResolution);  //our format is number of frames,delay 72,60,32 equals 72 frames, 60 ms time delay, 32 resolution   resolution is 16 for 16x32 or 32 for 32x32 led matrix, we need this in case the user changes the resolution in the app, then we'd need to catch this mismatch and re-decode
		        //TO DO we need to get the total number of frames
		        
		        
		        String exStorageState = Environment.getExternalStorageState();
		     	if (Environment.MEDIA_MOUNTED.equals(exStorageState)){
		     		try {
		     			
		     		   File myFile = new File(MainActivity.FavGIFPath + "decoded/" + "slideshowgif.txt");  //decoded/gif/slideshow.txt					       
		     		   myFile.createNewFile();
			           FileOutputStream fOut = null;
					   fOut = new FileOutputStream(myFile);
			           OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
					   myOutWriter.append(filetag);
					   myOutWriter.close();
					   fOut.close();
		     			
		     		} catch (IOException e) {
		     			e.printStackTrace();
		     			//Toast.makeText(this, "Couldn't save", Toast.LENGTH_SHORT);
		     		}
		     	}
		       
				
			
		   return null;
		  }
		
		  
		  @Override
		  protected void onProgressUpdate(Integer... values) {
		   super.onProgressUpdate(values);
		   progress.incrementProgressBy(1);
		  }
		   
		  @Override
		  protected void onPostExecute(Void result) {
		   super.onPostExecute(result);
		   //now let's put PIXEL in local playback mode and set fps
		   

		   if (progress != null) progress.dismiss();
		   
		 
			gridview.setKeepScreenOn(true);  //need to prevent screen from turning off / power savings during the write
			
			try {
				matrix_.interactive();
				float fps_= 1000.f / slideshowGIFFrameDelay;
				matrix_.writeFile(fps_);  //writeFile is fps, not frame delay
			} catch (ConnectionLostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

	        //add this delay here before we start writing to the sd card
	        try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		 
		   writePixelGIFAsyncSlideShow writePixelGIFAsyncSlideShow_ = new writePixelGIFAsyncSlideShow();
		   writePixelGIFAsyncSlideShow_.execute();
		   
			}
	} 
	    
	    private class writePixelGIFAsyncSlideShow extends AsyncTask<Void, Integer, Void>{
			
	    	  int progress_status;
		      
			  @Override
			  protected void onPreExecute() {
		      super.onPreExecute();
		    
		      progress = new ProgressDialog(MainActivity.this);
		      progress.setMax(Pixel.GIFSlideShowFrameCounter);
		      progress.setTitle(getString(R.string.WritingSlideshowGIF));
		      progress.setMessage(getString(R.string.DoNotInterrupt));
		      progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		      progress.setCancelable(false);
		      progress.setIcon(R.drawable.ic_action_warning);
		      progress.show();
		      
		      Log.i("PixelAnimations ", "Slide Show Length is: " + Pixel.GIFSlideShowFrameCounter);
		     
		      
		      if (selectedFileResolution == 0) { //then let's set it from the led panel that has been selected
		    	  selectedFileResolution = currentResolution;
		      }
		      
		      Log.i("PixelAnimations ", "Selected File Resoution is: " + selectedFileResolution);
		      
		     
			  }
		      
		  @Override
		  protected Void doInBackground(Void... params) {
				
		  int count = 0;
		  for (count = 0; count < Pixel.GIFSlideShowFrameCounter; count++) { //do we need this minus 1?
					
					  File file = new File(FavGIFPath + "decoded" + "/" + "slideshowgif" + ".rgb565"); //this is one big file now, no longer separate files
					  
					  RandomAccessFile raf = null;
					  
						//let's setup the seeker object
						try {
							raf = new RandomAccessFile(file, "r");
							
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}  // "r" means open the file for reading
						
						 switch (selectedFileResolution) { //16x32 matrix = 1024k frame size, 32x32 matrix = 2048k frame size
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
							//Log.d("PixelAnimations","from sd card write, x is: " + x);
							x++;
							
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
								Log.i("PixelAnimations ","Could not close the raf");
								e1.printStackTrace();
							}	
								
								//now that we have the byte array loaded, load it into the frame short array
								
							int y = 0;
							for (int i = 0; i < frame_.length; i++) {
								frame_[i] = (short) (((short) BitmapBytes[y] & 0xFF) | (((short) BitmapBytes[y + 1] & 0xFF) << 8));
								y = y + 2;
							}
							
						   	try {
						   	 Log.i("PixelAnimations ","Starting-->"+ count + " " + String.valueOf(SlideShowLength-1));
						   		matrix_.frame(frame_);
						   		progress_status++;
							    publishProgress(progress_status);
						   	
							} catch (ConnectionLostException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				  }  
			    
		   return null;
		  }
		  
		  @Override
		  protected void onProgressUpdate(Integer... values) {
		   super.onProgressUpdate(values);
		   progress.incrementProgressBy(1);
		  }
		   
		  @Override
		  protected void onPostExecute(Void result) {
			  
		  if (progress != null) progress.dismiss();
		
		 
		   try {
			matrix_.playFile();
			gridview.setKeepScreenOn(false); //enable power savings again
		} catch (ConnectionLostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  super.onPostExecute(result);
	}
		
	}    
	    
	    public static void appendWrite(byte[] data, String filename) throws IOException {
			 FileOutputStream fos = new FileOutputStream(filename, true);  //true means append, false is over-write
		     fos.write(data);
		     fos.close();
		}
	   
	
  /*  class MyGestureDetector extends SimpleOnGestureListener {    //not using the gesture listener, could add later 
    	@Override        
    	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) { 
    		
    		try {                
    			if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
    				return false;                // right to left swipe
    			if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
    				//Toast.makeText(MainActivity.this, "Stopping Slide Show", Toast.LENGTH_SHORT).show();
    				showToastShort(getResources().getString(R.string.slideShowStopVerbage)); //stop slideshow verbage
    				stopSlideShow();
    				slideShowRunning = 0;
    				//if (dimDuringSlideShow == true) {
    				//	screenOn();
    				//}
    				//sdcardImages.setOnItemClickListener(MainActivity.this); //add the onclick listener back
    				//add onclick listener back?
    				
    				
    				}  else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) { 
    					
    					if (slideShowRunning == 0) {    						
    						slideShowRunning = 1;
	    					//Toast.makeText(MainActivity.this, "Starting Slide Show...", Toast.LENGTH_SHORT).show();
	    					showToastShort(getResources().getString(R.string.slideShowStartVerbage));
	    					showToast(getResources().getString(R.string.slideShowStopInstructions));
	    					//sdcardImages.setOnClickListener(null); //remove the on click listener
	    					//if (dimDuringSlideShow == true) {
	    					//	dimScreen();
	    					//}
	    					
	    					String[] projection = {MediaStore.Images.Media.DATA}; //maybe move this outside of slideshow since it runs everytime
	    				        
	    				        if (scanAllPics == true) {
	    				            
	    				            cursor = managedQuery( MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
	    				                projection, // Which columns to return
	    				                null,       // Return all rows
	    				                null,
	    				                null);
	    				        }
	    				        else {
	    				        	cursor = managedQuery(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
	    				                projection, 
	    				                MediaStore.Images.Media.DATA + " like ? ",
	    				                new String[] {"%pngs%"},  
	    				                null);
	    				        } 
	    					
	    					
	    					
	    					//SlideShow(true); //start or resume the slideshow
	    					writeSlideShow();
	    					
    					}
    					
    					
    					}            } catch (Exception e) {                // nothing
    						
    					}            return false;
    				}
    
    	} //end gesture recognizer
*/
		
	
	
}  //end package





