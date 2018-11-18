import socket
import pygame
import serial

ser = serial.Serial('/dev/ttyACM1',9600)
pygame.init();
tonename = "90000 clap.wav"
pygame.mixer.music.load(tonename)
isHit = 1

def playTone():
    if isHit == 0:
        print ('drum played')
        pygame.mixer.music.play()

    else:
        print ('drum not playing')


while 1:
    v=ser.readline()
    print(v)
    if v== b'0\r\n':
        isHit = 0
    else:
        isHit = 1   
    playTone()
    
    
	
        



    
    


  