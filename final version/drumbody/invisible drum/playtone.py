#Author: Zhi Qiao(qiaoqiaojiushiwo@gmail.com)
import socket
import pygame
import serial

#initiate Serial method port, read the record file
ser = serial.Serial('/dev/ttyACM1',9600)
#initiate the pygame module for music file play output
pygame.init();
#set the tone path and read the file
pygame.mixer.music.load("E:\drumbodybody\tone\tone.wav")
#flag for signal received or not
isHit = 1

def playTone():
    if isHit == 0:
        print ('drum played')
        #play the tone file
        pygame.mixer.music.play()


while 1:
    #read the newest record 
    v=ser.readline()
    
    if v== b'0\r\n':
        isHit = 0
    else:
        isHit = 1   
    playTone()
    
    
	
        



    
    


  
