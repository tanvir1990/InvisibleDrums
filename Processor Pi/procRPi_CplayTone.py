import socket, sys, time
isHit = False

def playTone():
    print ('Stream finished playing')
    snd = Sound() 
    snd.read('ex1.wav') 
    snd.play()
    if isHit == False:
        print ('Stream not playing')
    
def resetisHit():
    isHit = False
    
def procRPi_UDPreceiverFP():    
    textport = sys.argv[1]
    
    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    port = int(textport)
    server_address = ('localhost', port)
    s.bind(server_address)
    
    while True:
        print ("Waiting to receive on port %d : press Ctrl-C or Ctrl-Break to stop " % port)
        buf, address = s.recvfrom(2048)
        if not len(buf):
            break
        print ("Received %s bytes from %s %s: " % (len(buf), address, buf ))
        s.shutdown(1)

while (1):
    procRPi_UDPreceiverFP()
    if isHit:
        playTone()
        resetisHit()


  