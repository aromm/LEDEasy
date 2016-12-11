# LEDPlusPlus

Making LED strip coding easier for WS2811/2 (Neopixel) strips.

## Getting Started
To get started with LEDPlusPlus, clone this repository! Then check out 
the following sample programs to see how to run it!

## Sample Program
There is one very conclusive sample program in the repository:
- Sample1.lpp


To compile the `.lpp` sample file into arduino make sure the files are 
in the LEDPlusPlus directory and that you have an open terminal shell 
also in the LEDPlusPlus directory. Then simply run
```
$ ./lpp.sh Sample1.lpp
```
and they will compile into Arduino files located in Sample1/Sample1.ino.

If you have your Arduino IDE setup for your LED powering micro 
controller, clicking on the Sample1.ino file will open up in the Arduino 
application where you can click `Upload` to run it on the controller!

## Variables to Change

As you may have noted in `Sample1.lpp` the first line is `Led count <number> pin <number>`. This is required to be the first line of every `LedPlusPlus` program and is crucial for the LED strip to work on your specific micro-controller. The `count` is how many LEDs are on your specific strip. The `pin` is which pin on your micro-controller will be sending the signals (often called `DIN` on spec sheets). 

If you are new to micro-controllers, there are a lot of [guides](http://bfy.tw/906F) out there like [this one](https://learn.adafruit.com/adafruit-neopixel-uberguide/neopixel-strips).
