import os
import socket


def removeold():
  os.remove("M:/settone/receive/tone.wav")


def receivefile():
  removeold();
  (HOST,PORT) = ('localhost',19123)
  s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
  s.bind((HOST, PORT)); s.listen(1); conn, addr = s.accept()
  WAVE_OUTPUT_FILENAME = "M:/settone/receive/tone.wav"

  with open(WAVE_OUTPUT_FILENAME,'wb') as f:
    while True:
      l = conn.recv(1024)
      if not l: break
      f.write(l)
      s.close() 


receivefile();
