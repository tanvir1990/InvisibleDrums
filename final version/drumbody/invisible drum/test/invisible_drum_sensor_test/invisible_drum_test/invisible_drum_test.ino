//Author: Zhi Qiao(qiaoqiaojiushiwo@gmail.com)
#define DETECT 2 // pin 2 for  sensor
#define ACTION 8 // pin 8 for action to do someting


void setup() {
  Serial.begin(9600);
  Serial.println("Invisible Drums");
  pinMode(DETECT, INPUT);//define detect input pin

}

void loop() {
  int detected = digitalRead(DETECT);// read Laser sensor
  if ( detected == LOW)
  {
   Serial.println("drummer is playing");
   delay(150);
  }
 
}
