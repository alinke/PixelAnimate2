PixelAnimate2
============

The main Android app for PIXEL:LED ART http://ledpixelart.com . Use Android Studio

__Explanation of GIF decoding__

Original file is rain.gif
which is stored like this: pixel/pixelpiledriver/rain.gif

after the one time decode, we'll have this:

pixel/pixelpiledriver/decoded/rain.txt
pixel/pixelpiledriver/decoded/rain.rgb565

rain.rgb565 will have all the decoded frames in the one big file. Thus the file size will vary depending on how many frames. For a 32x32 matrix, one frame is 2048 bytes. 

rain.txt will have this format

resolution of LED matrix, total frames, time delay

so

32,105,60

32: which means 32x32 matrix (as opposed to 16x32), we know if it's 32x32 or 16x32 from the apps prefs
105: means 105 total frames
60: means 60 ms delay to use in between frames for the timer

Each time we run the animation, we first read rain.txt to know what matrix to use, how many frame we're going to be loading, and at what timer frequency we should be loading those frames

