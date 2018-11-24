// Saser Sensor code for Robojax.com
#define DETECT 2 // pin 2 for  sensor

void setup() {
  Serial.begin(9600);
  Serial.println("Invisible Drums");
  pinMode(DETECT, INPUT);//define detect input pin
}

void loop() {
  int flag = 0;
  while(1){
    int detected = digitalRead(DETECT);// read Laser sensor
  if ( detected == HIGH&&flag == 0){
    Serial.println((byte)1);
    delay(100);
  } else if  ( detected == HIGH&&flag == 1){
    Serial.println((byte)1);
    flag = 0;
    delay(100);  
  } else if  ( detected == LOW&&flag == 0){
    Serial.println((byte)0);
    flag = 1;
    delay(135);  
  } else if  ( detected == LOW&&flag == 1){
    Serial.println((byte)1);
    delay(100);
  }  
 }
}
