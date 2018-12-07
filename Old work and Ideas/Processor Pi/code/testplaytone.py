import socket
import pygame
import serial

ser = serial.Serial('/dev/ttyACM3',9600)
pygame.init();
tonename = "90000 clap.wav"
pygame.mixer.music.load(tonename)

isHit = 0

def playTone():
    if isHit == 1:
        print ('Stream not playing')
    else:
        print ('Stream finished playing')
        pygame.mixer.music.play()
        while pygame.mixer.music.play():
            time.sleep(2)
        resetisHit()
    
    
def resetisHit():
    isHit = 0

while 1:
    isHit=ser.readline()
    playTone()
    
        
	
        



    
    


  