# MapBox Example

Example Android project for a workshop about MapBox.

## App Development

***Android***: operating system for smartphones or tablets.  
***iOS***: operating system for iPhones or iPads.  
***App***: application, computer program that runs on the platform, i.e. Android or iOS.

***Activity***: A screen in Android  
***UI***: User Interface  
***UI elements***: graphical elements for the user interface, e.g. text, input fields, pictures or buttons.  

***SDK***: Software Development Kit: set of libraries for developing apps  
***Framework***: software where we just need to write our logic or customization  

***IDE***: Integrated Development Environment: code editor with helpful tools  
***Android Studio***: IDE for making Android apps  
***Xcode***: IDE for making iOS apps  

***adb***: Android Debug Bridge: tool for putting an app from the IDE on the phone and debug it  
***Bug***: error/mistake in a computer program  
***debugging***: process of going through the program step by step to find the error  

***API***: Application Programming Interface  
***REST***: Representational State Transfer: an API for HTTP  
***HTTP***: Hypertext Transfer Protocol: a protocol for sending information over the internet  

### Communicating with a Server

Apps and websites often use REST APIs for communicating with a server over the internet.

You usually call something like:  
http://samples.openweathermap.org/data/2.5/weather?q=London&appid=b6907d289e10d714a6e88b30761fae22

And you will get data back that looks like this:
```json
{  
   "coord":{  
      "lon":-0.13,
      "lat":51.51
   },
   "weather":[  
      {  
         "id":300,
         "main":"Drizzle",
         "description":"light intensity drizzle",
         "icon":"09d"
      }
   ],
   "base":"stations",
   "main":{  
      "temp":280.32,
      "pressure":1012,
      "humidity":81,
      "temp_min":279.15,
      "temp_max":281.15
   },
   "visibility":10000,
   "wind":{  
      "speed":4.1,
      "deg":80
   },
   "clouds":{  
      "all":90
   },
   "dt":1485789600,
   "sys":{  
      "type":1,
      "id":5091,
      "message":0.0103,
      "country":"GB",
      "sunrise":1485762037,
      "sunset":1485794875
   },
   "id":2643743,
   "name":"London",
   "cod":200
}
```

This format is called ***JSON***, and its advantage is that it can be understood all different apps: Android, iOS and web applications.

For more examples have a look at:  
http://openweathermap.org/current

### Cross-Platform Frameworks

There are frameworks that support developing an app for multiple platforms, usually both Android and iOS.

Usually they create apps that use **HTML5**, **CSS** and **JavaScript**: ***web apps***.

Examples for these franeworks are:

- Apache Cordova (formerly PhoneGap)
- Sencha Touch
- Crosswalk Project
- Enyo
- iUI

There are also frameworks that let you build the app once, and then create ***native apps*** for all platforms.  

Examples are:

- React Native (using JavaScript)
- Xamarin (using .NET)
- Unity (using C#)

There are also ***Progressive Web Apps***. These are apps that run in the browser of your phone. 
They are advanced websites that display content for mobile devices.

Examples are:

- [Twitter](https://mobile.twitter.com/home)
- [Guitar Tuner](https://guitar-tuner.appspot.com/)
- [Air Horner](https://airhorner.com/)

Go ahead and try them out!

## The Development Cycle

The typical lifecycle for a bug-fix goes like this:

1. There is a new app version released.
2. A bug is reported.
3. The developer fixes that bug.
4. A fellow developer does a ***code review***.
5. The system builds a ***snapshot***.
6. QA tests it.
7. A new app version is released.

## Mapbox Example

MapBox first steps:  
https://www.mapbox.com/help/first-steps-android-sdk/

#### The MapBox Key

First we need an access token. I prepared one for you on the USB drive that you got.

Open the `key.txt` file on your USB drive and copy the key.

In your project, go to `res/values`. Right click the `values` folder, and choose `New...` - `Values resource file`. 

At file name type `keys.xml` and press `OK`.

Open the file, and between the `<resources>` tags, in a new line, type:
```xml
<string name="mapbox_key"></string>
```
Then, in between the `>` and the `</string>`, paste your key.

#### Adding MapBox to the project

In `build.gradle` (Project: ...) in line 22, below `jcenter()`, add: 
```
mavenCentral()
```
In `app/build.gradle` (Module: app) below line 24 add:
```
implementation 'com.mapbox.mapboxsdk:mapbox-android-sdk:5.5.0'
```
Build the project.

#### Displaying a map

In `activity_main.xml` replace existing code with the following content:
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:mapbox="http://schemas.android.com/apk/res-auto"
    tools:context="com.hamburgcodingschool.example.mapbox.MainActivity">

    <com.mapbox.mapboxsdk.maps.MapView
        android:id="@+id/mapView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        mapbox:mapbox_cameraTargetLat="41.885"
        mapbox:mapbox_cameraTargetLng="-87.679"
        mapbox:mapbox_styleUrl="@string/mapbox_style_light"
        mapbox:mapbox_cameraTilt="60"
        mapbox:mapbox_cameraZoom="12"
        />

</LinearLayout>
```

At `AndroidManifest.xml` add the following content at line 4:
```xml
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
```

In `MainActivity.java` in line 7 after the first { put this:
```java
private MapView mapView;
```
Replace the code that says `setContentView(R.layout.activity_main);` with this:
```java
Mapbox.getInstance(this, getString(R.string.mapbox_key));
setContentView(R.layout.activity_main);
mapView = (MapView) findViewById(R.id.mapView);
mapView.onCreate(savedInstanceState);
```

After line 20, before the last }, paste the following methods:
```java
@Override
public void onStart() {
    super.onStart();
    mapView.onStart();
}
 
@Override
public void onResume() {
    super.onResume();
    mapView.onResume();
}
 
@Override
public void onPause() {
    super.onPause();
    mapView.onPause();
}
 
@Override
public void onStop() {
    super.onStop();
    mapView.onStop();
}
 
@Override
public void onLowMemory() {
    super.onLowMemory();
    mapView.onLowMemory();
}
 
@Override
protected void onDestroy() {
    super.onDestroy();
    mapView.onDestroy();
}
 
@Override
protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    mapView.onSaveInstanceState(outState);
}
```

