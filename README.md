# COMP3000

##Key Stock OS Applications As Quick Setting Tiles
  - For stock Android 6.0 ROM
  - For easier access for the older generation of users that are being forced into smartphones but are unaware of how to use the complicated smartphones on the market today and just want the basic functionality back that they had with their previous simple and basic phones.

###Steps to implementing into your custom Android 6.0 ROM
  - Add all the files in the CustomTiles folder into the following directory in your custom ROM:   /frameworks/base/packages/SystemUI/src/com/android/systemui/qs/tiles
  - Add the QSTileHost.java file into the following directory in your custom ROM: /frameworks/base/packages/SystemUI/src/com/android/systemui/statusbar/phone
  - Add the config.xml and the strings.xml file into into the following directory in your custom ROM: /frameworks/base/packages/SystemUI/res/values
  - Add the QsTuner.java file into the following directory in your custom ROM: /frameworks/base/packages/SystemUI/src/com/android/systemui/tuner
