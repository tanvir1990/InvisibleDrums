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

if isHit:
    playTone()
    resetisHit()
    print('Stream not playing')
  

    
