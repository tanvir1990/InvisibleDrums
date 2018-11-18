// Saser Sensor code for Robojax.com
#define DETECT 2 // pin 2 for  sensor
#define ACTION 8 // pin 8 for action to do someting


void setup() {
  Serial.begin(9600);
  Serial.println("Invisible Drums");
  pinMode(DETECT, INPUT);//define detect input pin
  pinMode(ACTION, OUTPUT);//define ACTION output pin

  // Laser sensor code for Robojax.com

}

void loop() {
  // Laser Sensor code for Robojax.com

  int detected = digitalRead(DETECT);// read Laser sensor

  if ( detected == HIGH)
  {
    Serial.println((byte)1);
  delay(100);
    
  } else {
   Serial.println((byte)0);
   delay(150);
  }
 
}
