#Author: Zhi Qiao(qiaoqiaojiushiwo@gmail.com)
import os
import socket

#remove the old tone
def removeold():
  os.remove("E:\drumbodybody\tone\tone.wav")

#receive the data from somewhere else and replace the tone file through tcp
def receivefile():
  #set the port
  (HOST,PORT) = ('localhost',19123)
  #set the socket
  s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
  s.bind((HOST, PORT)); s.listen(1); conn, addr = s.accept()
  #set the path and name of new file
  WAVE_OUTPUT_FILENAME = "E:\drumbodybody\tone\tone.wav"
  
  with open(WAVE_OUTPUT_FILENAME,'wb') as f:
    while True:
      l = conn.recv(1024)
      if not l: break
      f.write(l)
      s.close() 

removeold();
receivefile();
