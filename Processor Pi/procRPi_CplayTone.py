import socket
import winsound

UDP_IP_ADDRESS = "127.0.0.1"
UDP_PORT_NO = 6789
tonename = "90000 clap"
isHit = True

def playTone():
    if isHit == False:
        print ('Stream not playing')
    else:
        print ('Stream finished playing')
        winsound.PlaySound(tonename,winsound.SND_FILENAME) 

    
    
def resetisHit():
    isHit = False
    
def procRPi_UDPreceiverFP():    
    serverSock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    serverSock.bind((UDP_IP_ADDRESS, UDP_PORT_NO))
    while True:
        data, addr = serverSock.recvfrom(1024)
        print ("isHit: ", data)
        isHit = data
        
while(1):
    procRPi_UDPreceiverFP()
    playTone()
    resetisHit()

        



    
    


  