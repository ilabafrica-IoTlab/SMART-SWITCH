# SMART-SWITCH
Smart Light Switching

### Hardware Requirements
- Nodemcu ESP8266 
- Bread board
- Leds
- Jumper wires
- USB cable
- Resistor
- Relays
- Bulbs

### Software Requirements
[Arduino IDE](https://www.arduino.cc/en/Main/Software)

[Android studio](https://developer.android.com/studio?gclid=Cj0KCQjw_dWGBhDAARIsAMcYuJxSorSzlaZerJVsB2MzHUj0hZ2O9gxSlPIMrYXx69GwbUY9qHFVLxkaApQ8EALw_wcB&gclsrc=aw.ds) 

Firebase (Realtime database):The Firebase Realtime Database is a cloud-hosted NoSQL database that lets you store and sync data between your users in real time.

## Firebase creation process
1. [Open the firebase console](https://console.firebase.google.com/?pli=1)

2. Click `CREATE NEW PROJECT`.
3. The *Create a project* window opens.

     ### Enter the following information and click "CREATE PROJECT".
   - Project name
   - Country/region
4. The start screen of the Firebase console opens.
   - Click "Add Firebase to your Android app
5. The "Enter app details" screen opens.   
    - Click "ADD APP" after specifying the app details.
6. Continue the configuration by following the on-screen instruction.

7. Check the server key after the project is created.
   - First, select "Settings" from the project menu to open the "Settings" screen.
   - Open the "CLOUD MESSAGING" tab in the "Settings" screen.
   
### Project description.
Developing a smart lighting system which is controlled by an android application  over WiFi using HTTP protocol.

### Libraries installed

- [FirebaseArduino](https://github.com/FirebaseExtended/firebase-arduino)

- [ESP8266 WiFi library](https://github.com/ekstrand/SerialESP8266wifi/archive/master.zip)

- [ArduinoJson version 5.13.5](https://arduinojson.org/v5/doc/installation/) 

- [ESP8266 Library](https://github.com/esp8266/Arduino)

## Demo diagram on an LED

### Diagram on breadboard
<p align="centre">
<image src="https://github.com/ilabafrica-IoTlab/SMART-SWITCH/blob/Develop/Images/Node%20MCU%20Working.jpg" 
width="240" height="180">



### Diagram on Fritzing  
<image src="https://github.com/ilabafrica-IoTlab/SMART-SWITCH/blob/Develop/Images/NodeMCU%20Connection_bb.jpg"
width="400" height="300">
</p>


### Connection
+ Connect pin D0 of the NodeMCU to positive of the LED1

+ Connect pin D1 of the NodeMCU to positive of the LED2

+ Connect pin D2 of the NodeMCU to positive of the LED3

+ Connect pin D3 of the NodeMCU to positive of the LED4

+ Connect GND of the NodeMCU to negative of the LED1, LED2, LED3 & LED4

### CONTRIBUTORS TO THE PROJECT
+ [Caren Kiprono](https://github.com/KARENKIP)

+ [Cynthia Njoki](https://github.com/NjokiCynthia)

+ [Dancun Sikuku](https://github.com/dancansikuku94)



