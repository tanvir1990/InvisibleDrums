#Author: Zhi Qiao(qiaoqiaojiushiwo@gmail.com)
import socket

def
print ("which file to send?")
    prompt = ': '
     while True:
        #enter the path of file
        name = input(prompt)
        filepath = ("E:\drumbodybody\localdatabase\\" + name)
        (HOST,PORT) = ('localhost',19123)
        s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        s.bind((HOST, PORT)); s.listen(1); conn, addr = s.accept()

        WAVE_OUTPUT_FILENAME = filepath

        with open(WAVE_OUTPUT_FILENAME,'wb') as f:
          while True:
            l = conn.recv(1024)
            if not l: break
            f.write(l)
        s.close()
        break;
