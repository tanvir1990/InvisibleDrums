
import serial

ser = serial.Serial('/dev/ttyACM1',9600)
isHit = 1

def playTone():
    if isHit == 0:
        print ('drum played')


while 1:
    v=ser.readline()
    if v== b'0\r\n':
        isHit = 0
    else:
        isHit = 1   
    playTone()
    
    
	
        



    
    


  