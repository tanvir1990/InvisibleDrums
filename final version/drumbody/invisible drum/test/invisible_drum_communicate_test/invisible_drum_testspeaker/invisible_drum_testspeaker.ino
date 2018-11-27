//Author: Zhi Qiao(qiaoqiaojiushiwo@gmail.com)
// Saser Sensor code for Robojax.com
#define DETECT 2 // pin 2 for  sensor
#define ACTION 8 // pin 8 for action to do someting


void setup() {
  Serial.begin(9600);
  Serial.println("Invisible Drums");
}

void loop() {
  Serial.println((byte)1);
  delay(1000);

 Serial.println((byte)0);
   delay(1000);



 
}
