PixelAnimate2
============

Use this one instead of PixelAnimate. This is a more efficient way to do the animations. Here we are doing a one time de-code of each animated .gif and then saving the decoded native .rgb565 file into Android local storage. Then we simply load the .rgb565 using a timer with a timer to make the animation. We read the animation delay from the initial animated .gif and also store that locally.

Ex.

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

