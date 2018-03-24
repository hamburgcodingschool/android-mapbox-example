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

There are also frameworks that let you build the app once, and then create different "native" apps.  

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