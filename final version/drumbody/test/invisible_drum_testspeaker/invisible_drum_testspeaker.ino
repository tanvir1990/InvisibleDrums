// Saser Sensor code for Robojax.com
#define DETECT 2 // pin 2 for  sensor
#define ACTION 8 // pin 8 for action to do someting


void setup() {
  Serial.begin(9600);
  Serial.println("Invisible Drums");

  // Laser sensor code for Robojax.com

}

void loop() {
  // Laser Sensor code for Robojax.com

  int hit = 0;// read Laser sensor

  while(1)
  {
    if (hit = 1){
    Serial.println((byte)1);
  delay(100);
  hit = 0;
    
  } else {
   Serial.println((byte)0);
   delay(150);
   hit = 1;
  }
 }
 
}
