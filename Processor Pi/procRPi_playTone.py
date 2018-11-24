import serial

ser = serial.Serial('/dev/ttyACM1',9600)
tonename = "90000 clap.wav"
snd = Sound() 
snd.read(tonename)

def playTone():
    if isHit == 0:
        print ('drum played') 
        snd.play()

while 1:
    v=ser.readline() //read the newest record

    if v== b'0\r\n':
        isHit = 0
    else:
        isHit = 1   

    playTone()

  

    
