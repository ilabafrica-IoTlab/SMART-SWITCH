#include <ESP8266WiFi.h>
#include <FirebaseArduino.h>

int leds[4] = {D0, D1, D2 , D3};
int states[4] = {LOW, LOW, LOW, LOW};
int totalDevices = 4;

#define firebaseURl "iot-led-lighting-default-rtdb.firebaseio.com"
#define authCode "YJIUFItS3t9atA191JjM9xbtD1EU0KAfMNBlyFKB"

#define wifiName "Incubator"
#define wifiPass "Incubator#2013"



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

  int led1 = object.getInt("LEAD_STATUS1");
  int led2 = object.getInt("LEAD_STATUS2");
  int led3 = object.getInt("LEAD_STATUS3");
  int led4 = object.getInt("LEAD_STATUS4");

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
