import socket
import pygame
import serial

ser = serial.Serial('/dev/ttyACM3',9600)
pygame.init();
tonename = "90000 clap.wav"
pygame.mixer.music.load(tonename)

isHit = 0

def playTone():
    if isHit == 0:
        print ('Stream not playing')
    elif isHit == 1:
        print ('Stream finished playing')
        pygame.mixer.music.play()
        resetisHit()

    
    
def resetisHit():
    isHit = 0


while True:
	isHit=ser.readline()
	playTone()
	
        



    
    


  