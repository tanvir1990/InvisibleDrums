//Author:Zhi Qiao(qiaoqiaojiushiwo@gmail.com)

// Saser Sensor code for Robojax.com
#define DETECT 2 // pin 2 for  sensor
#define ACTION 8 // pin 8 for action to do someting


void setup() {
  Serial.begin(9600);//set the port for Serial method
  Serial.println("Invisible Drums");
  pinMode(DETECT, INPUT);//define detect input pin

}

void loop() {
  
  int flag = 0;//flag for reduce double detect
  while(1){
    int detected = digitalRead(DETECT);// read Laser sensor
    
  if ( detected == HIGH&&flag == 0){//sensor is not detected
    Serial.println((byte)1);//serial method send 1
    delay(100);
    
  } else if  ( detected == HIGH&&flag == 1){//sensor turn back from multi-detected
    Serial.println((byte)1);//serial method send 1
    flag = 0;//reset flag
    delay(100);
    
  } else if  ( detected == LOW&&flag == 0){//first detect
    Serial.println((byte)0);//serial method send 0
    flag = 1;
    delay(135);
    
  } else if  ( detected == LOW&&flag == 1){//sensor already detected
    Serial.println((byte)1);//serial method send 1
    delay(100);
  }  
 }
}
