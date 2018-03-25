# MapBox Example

Example Android project for a workshop that teaches Android app development.

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

### Beta Release

There are several services that you can use to distribute an app to a selected circle of testers.
For this example we chose [HockeyApp](https://hockeyapp.net).

See: https://rink.hockeyapp.net/manage/apps/734868

Alternatives include:

- Crashlytics Beta
- TestFlight (iOS)
- DryDock (iOS)
- Google Play Store: Beta Testing (Android)

### Typical Team

In bigger companies, you would usually have a team that consists of:

- PO: Product Owner
- Designer
- QA: Quality Assurance
- Backend developers
- Android developers
- iOS developers
- (DevOps and/or IT)

### Scrum Board

Usually, a software development team has a board that helps them doing their agile process (Scrum, Kanban).
This usually contains:
 
- a ***backlog*** where all open tickets are collected and sorted by priority
- a ***sprint board*** or ***scrum board*** whith columns like *OPEN*, *IN PROGRESS*, *IN REVIEW*, and *DONE*
- a ***burndown chart***, where the progress of a sprint is visualized

A ***sprint*** is a time span of usually 2 weeks, where developers focus on solving a certain amount of issues from the backlog.

### Code Review

After a developer implemented a new feature or fixed a bug, another developer will have a look at the code and double-check that everything is fine: the ***code review***.

Usually, developers use a software for *version control*, so they can keep track of the changes or revert changes.

One of the most common version control tools is ***git***.

If a developer made changes to the code, they can ***add*** these changes, and then ***commit*** them with a commit message.

***GitHub*** is an online platform where developers can push their commits to. An example is this project here.  
Have a look at the [commit history](https://github.com/hamburgcodingschool/android-mapbox-example/commits/master).

If a developer starts working on a project, they usually check out a new ***branch***. This way, multiple developers can work on the same project in parallel.

Many teams use this branching model:  
http://nvie.com/posts/a-successful-git-branching-model/

When a developer finished a feature or bugfix, they need to merge their branch back into the master branch.
On GitHub this is done with a ***pull request***.

When a pull request is open, the other developers can easily check the changes for errors or weaknesses.

### Continuous Integration

A continuous integration (CI) system can automatically:

- run unit tests
- run code quality tools, e.g. lint
- upload a new snapshot version
- upload a new release version

Examples for these systems are:

- TeamCity
- Travis
- Jenkins

## Mapbox Example

MapBox first steps:  
https://www.mapbox.com/help/first-steps-android-sdk/

### What do you need to get started?

- Your laptop
- An internet connection
- Android Studio
- An Android phone (optional)

### Setting up Android Studio

Download Android Studio here:  
https://developer.android.com/studio/index.html

Install Android Studio. If it asks you to install Java, install it, too.

Open Android Studio. Follow the instructions and install at least one SDK.

### Create your first App

Open Android Studio and select "Start a new Android Studio project".

Give it a name (e.g. "MapBox Example").

As company domain, use the following pattern:

```
firstnamelastname.com
```
So if your name would be Lisa Simpson, this would be:
```
lisasimpson.com
```

Press next, choose "Phone and Tablet", press next.

Select "Empty Activity", press next and finish.

### Start Your App

Click "AVD Manager" and "Create virtual device...".  
Select “Phone” and choose one (e.g. Pixel). Click next.

For the system image, choose the first one, click "Download", and once it's downloaded, press Finish. Your device will now be listed in the list of emulators.  
Click the "run" button and wait until it started.

In Android Studio, press the green "play" icon. It starts up your app in the emulator.

Alternatively, you can connect your Android phone with a USB cable and choose that.  
For this, you have to enable USB debugging in your phone's settings.

### Add MapBox to Your App

#### Add the MapBox Access Token

MapBox doesn't show a map if we don't use a key: the ***MapBox access token***. For using their SDK, they want you to register an account.

I did that already, and prepared an access token for you on the USB drive that you got.

Open the `key.txt` file on your USB drive and copy the key.

In your project, go to `res/values`. Right click the `values` folder and choose `New...` - `Values resource file`. 

At file name type `keys.xml` and press `OK`.

Open the file, and between the `<resources>` tags, in a new line, type:
```xml
<string name="mapbox_key"></string>
```
Then, in between the `>` and the `</string>`, paste your key.

#### Adding MapBox to the project

For downloading external dependencies (like the MapBox SDK), in Android we use Gradle,

In `build.gradle` (Project: ...) in line 22, below `jcenter()`, add: 
```
mavenCentral()
```
In `app/build.gradle` (Module: app) below line 24 add:
```
implementation 'com.mapbox.mapboxsdk:mapbox-android-sdk:5.5.0'
```
Build the project.  
This will download the MapBox SDK library that contains everything we need.

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

#### Add a Marker and an Info Window

In the method `protected void onCreate(Bundle savedInstanceState)` after the last statement but before the closing }, paste this code:
```java
mapView.getMapAsync(new OnMapReadyCallback() {
    @Override
    public void onMapReady(MapboxMap mapboxMap) {
        // One way to add a marker view
        mapboxMap.addMarker(new MarkerOptions()
            .position(new LatLng(41.885,-87.679))
            .title("Chicago")
            .snippet("Illinois")
        );
    }
});
```

Run your app and see what happens when you tap the marker.

#### Change the Camera Position

As you have noticed, when the app starts, MapBox will always show Chicago first.  
We can change that with the following steps:  

First, we need to find latitude and longitude of the location that we want to show first.  
For finding out longitude and latitude of places, go to http://www.latlong.net/.  

Find the latitude and longitude of, for example, Stuttgart.

Go to the file `activity_main.xml`. In line 14 and 15 you see that there are some latitude and longitude values given:
```xml
mapbox:mapbox_cameraTargetLat="41.885"
mapbox:mapbox_cameraTargetLng="-87.679"
```
Replace the numbers with the latitude and longitude of your city.

#### Change the Location of the Marker

Go to `MainActivity.java` and find the line `.position(new LatLng(41.885,-87.679))` in the code that you just pasted.

There, replace the numbers with the latitude and longitude of your city.

Run the app and see if your marker is at your new location now.

Can you also change the text of the snippet?

#### Change the Marker Icon

In your Android Studio project, navigate to the res folder.  
Create all the drawable-... folders there that you see at https://github.com/hamburgcodingschool/android-mapbox-example/tree/master/app/src/main/res.

From each of these folders, download the ic_directions_car.png file and put them at the same folder in your project.

At line 27, just before `mapView.getMapAsync(new OnMapReadyCallback() {`, paste the following line:
```java
final Icon icon = IconFactory.getInstance(MainActivity.this).fromResource(R.drawable.ic_directions_car);
```
Then, one line below `.snippet("Baden-Württemberg")`, add:
```java
.icon(icon)
```
Run your app and see how it looks.

If you want to create your own icons, you can use the Android Asset Studio:
https://romannurik.github.io/AndroidAssetStudio/index.html

#### Share your Location

For listening to clicks on the info window (the text shown when a marker is clicked), we need to create a listener like this:  
```java
mapboxMap.setOnInfoWindowClickListener(new MapboxMap.OnInfoWindowClickListener() {
    @Override
    public boolean onInfoWindowClick(@NonNull Marker marker) {
        
    }
});
```

This needs to be added in a new line just below
```java
    .icon(icon)
);
```
but before the closing } of `public void onMapReady(MapboxMap mapboxMap) {`.

Next, we need to fill in some logic, so that it looks like this:
```java
mapboxMap.setOnInfoWindowClickListener(new MapboxMap.OnInfoWindowClickListener() {
    @Override
    public boolean onInfoWindowClick(@NonNull Marker marker) {
        LatLng position = marker.getPosition();
        String location = "https://www.google.com/maps?ll=" + position.getLatitude() + ","
                + position.getLongitude() + "&q=" + position.getLatitude() + ","
                + position.getLongitude();
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, location);
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, "Send location"));
        return true;
    }
});
```
Run your app and share the location of your marker with someone! 

Note: this may not work if no email or similar account is set up in your emulator.

We explain all you need to know in this workshop.

Read more about sharing content in Android here:  
https://developer.android.com/training/sharing/send.html

#### Show the Phone's Location

At the end of the method `onMapReady()`, switch on the maps blue icon for the location:

```java
mapboxMap.setMyLocationEnabled(true);
```

This won't work yet, because of Android's location permissions. This permission needs to be granted by the user first.

Add the following code for checking the location permission:

```java
if (ContextCompat.checkSelfPermission(MainActivity.this,
        Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
    mapboxMap.setMyLocationEnabled(true);
} else {
    //Request Location Permission
    ActivityCompat.requestPermissions(MainActivity.this,
            new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
            MY_PERMISSIONS_REQUEST_LOCATION);
}
```

The variable `MY_PERMISSIONS_REQUEST_LOCATION` is marked red, because it's not there yet. We need to add it to the beginning of the class:

```java
public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
```

This is showing a dialog to the user that asks whether or not the app is allowed to use the phone's location.

We also need to react to the decision of the user: it's called a "Callback".

Directly at the beginning of the class, after `AppCompatActivity`, make a space and add this:  
`implements ActivityCompat.OnRequestPermissionsResultCallback`.

Add a new line directly after `private MapView mapView;` and add:
```java
private MapboxMap map;
```

Then, at the beginning of the `onMapReady()` method, on the first line after {, add:
```java
map = mapboxMap;
```

At the end of the class, just before the last `}`, put the following code:

```java
@SuppressWarnings("MissingPermission")
@Override
public void onRequestPermissionsResult(int requestCode, 
                                       @NonNull String[] permissions, 
                                       @NonNull int[] grantResults) {
    if (requestCode == MY_PERMISSIONS_REQUEST_LOCATION) {
        if (permissions.length == 1 &&
                Manifest.permission.ACCESS_FINE_LOCATION.equals(permissions[0]) &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        }
    }
}
```

Now, if you start your app, you get a dialog asking you to grant permission to use the location.  

You should now see a little blue dot at your location.

#### Create a Button

Open the file `activity_main.xml`. We need to change the layout so that it shows a button.

Inside the `<LinearLayout` e.g. in line 7 add:  
`android:orientation="vertical"`

In the `<com.mapbox.mapboxsdk.maps.MapView` replace line  
`android:layout_height="match_parent"`
with
```xml
android:layout_height="0dp"
android:layout_weight="1"
```

Almost at the bottom, create a new line above `</LinearLayout>` and add a button:
```xml
<Button
        android:id="@+id/button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Button"/>
```

Try changing the label text to `Share My Location`.

Run your app and see how the layout changed.  
The button is not doing anything yet when it's clicked.


