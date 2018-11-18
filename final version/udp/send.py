import socket

(HOST,PORT)=('localhost',19123)
s=socket.socket(socket.AF_INET,socket.SOCK_STREAM); s.connect((HOST,PORT))
WAVE_OUTPUT_FILENAME = '90000 clap.wav'


with open(WAVE_OUTPUT_FILENAME, 'rb') as wave_file:
    s.sendfile(wave_file)


s.close()
