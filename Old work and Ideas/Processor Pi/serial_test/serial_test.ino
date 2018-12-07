char dataString[50] = {0};
int a =0; 

void setup() {
Serial.begin(9600);              //Starting serial communication
}
  
void loop() {
  if(a ==0){
    Serial.println((byte)0x00);
    a=1;
   }else{
    Serial.println((byte)0x01);
    a=0;
   }  // a value increase every loop
   // send the data
  delay(1500);                  // give the loop some break
}
