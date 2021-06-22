// https://github.com/tabvn/arduino-lighting-control/blob/master/lightControl.ino
#include <ESP8266WiFi.h>
#include <FirebaseArduino.h>

int leds =  D1;
int LED_STATUS;
int totalDevices = 1;

#define firebaseURl "iot-led-lighting-default-rtdb.firebaseio.com"
#define authCode "YJIUFItS3t9atA191JjM9xbtD1EU0KAfMNBlyFKB"

#define wifiName "Incubator"
#define wifiPass "Incubator#2013"

//String chipId = "123";

void setupFirebase() {

  Firebase.begin(firebaseURl, authCode);
}

void setupWifi() {

  WiFi.begin(wifiName, wifiPass);

  Serial.println("Hey i 'm connecting...");

  while (WiFi.status() != WL_CONNECTED) {

    Serial.println(".");
    delay(500);
  }

  Serial.println();
  Serial.println("I 'm connected and my IP address: ");
  Serial.println(WiFi.localIP());
}

void setup() {

  Serial.begin(9600);

  setupWifi();
  setupFirebase();

  setupPinsMode();

}

void getData() {

  String path = "IoTlab/SmartSwitch/Device1";
  FirebaseObject object = Firebase.get(path);

  int led1 = object.getInt("LED_STATUS");


  Serial.println(led1);
  //               Serial.println(led1);



//  Serial.println("-------------------------------- -");

  // write output high or low to turn on or off led
  digitalWrite(leds, led1);



}
void loop() {

  getData();

}

void setupPinsMode() {

  // setup Pin mode as output.

  for (int i; i < totalDevices; i++) {

    Serial.printf("Setup Output for pin % d", leds);
    pinMode(leds, OUTPUT);
  }
}
