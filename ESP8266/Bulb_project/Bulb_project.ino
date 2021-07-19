#include <Firebase_ESP_Client.h>
#include <FirebaseFS.h>
#include <Utils.h>
#include <common.h>

#include <ESPAsync_WiFiManager.h>

#include <ESP8266WiFi.h> //wifi library
#include <FirebaseArduino.h>//firebase arduino library

int leds[4] = {D0, D1, D2 , D3};//Inializiing the four Relays pins on nodemcu Esp8266
int states[4] = {LOW, LOW, LOW, LOW};//setting the default status low at first
int totalDevices = 4;//number of relays connected to nodemcu

#define firebaseURl "iot-led-lighting-default-rtdb.firebaseio.com"
#define authCode "YJIUFItS3t9atA191JjM9xbtD1EU0KAfMNBlyFKB"

#define wifiName "Incubator"
#define wifiPass "Incubator#2013"



void setupFirebase() {

  Firebase.begin(firebaseURl, authCode);//connecting to firebase using firebase keys
}

void setupWifi() {

  WiFi.begin(wifiName, wifiPass);

  Serial.println("Hey i 'm connecting...");

  while (WiFi.status() != WL_CONNECTED) {

    Serial.println(".");
    delay(500);
  }

  Serial.println();
  Serial.println("I 'm connected and my IP address Is: ");
  Serial.println(WiFi.localIP());
}


void setup() {

  Serial.begin(9600);

  setupWifi();
  setupFirebase();

  setupPinsMode();

}



void getData() {

  String path1="IoTlab/SmartSwitch/BULBS/BULB_1"
  String path2="IoTlab/SmartSwitch/BULBS/BULB_2"
  String path3="IoTlab/SmartSwitch/BULBS/BULBS_3"
  String path4="IoTlab/SmartSwitch/BULBS/BULBS_4"
  FirebaseObject object1=Firebase.get(path1)
  FirebaseObject object2=Firebase.get(path2)
  FirebaseObject object3=Firebase.get(path3)
  FirebaseObject object4=Firebase.get(path4)
  string led1=object1.getString("status")
  string led2=object2.getString("status")
  string led3=object3.getString("status")
  string led4=object4.getString("status")


  Serial.println("Bulb 1: ");
  Serial.println(led1);

  //
  Serial.println();
  Serial.println("Bulb 2: ");
  Serial.println(led2);

  //
  Serial.println();
  Serial.println("Bulb 3: ");
  Serial.println(led3);
  //
  Serial.println();
  Serial.println("Bulb 4: ");
  Serial.println(led4);
  // write output high or low to turn on or off the bulb
  digitalWrite(leds[0], led1);

  digitalWrite(leds[1], led2);

  digitalWrite(leds[2], led3);

  digitalWrite(leds[3], led4);


}
void loop() {


  getData();


}

void setupPinsMode() {

  // setup Pin mode as output.


  for (int i; i < totalDevices; i++) {

    Serial.printf("Setup Output for pin %d", leds[i]);
    pinMode(leds[i], OUTPUT);
  }
  }
