#Author: Zhi Qiao(qiaoqiaojiushiwo@gmail.com)
import socket

#send file
def filesend():
    #the user can select which file to send by enter the path
    print ("which file to send?")
    prompt = ': '
    while True:
        #enter the path of file
        name = input(prompt)
        #set the port
        (HOST,PORT)=('localhost',19123)
        #set the socket
        s=socket.socket(socket.AF_INET,socket.SOCK_STREAM);
        s.connect((HOST,PORT))
        #set the output file path and name
        WAVE_OUTPUT_FILENAME = name

        with open(WAVE_OUTPUT_FILENAME, 'rb') as wave_file:
            s.sendfile(wave_file)

        s.close()
        break;


filesend();

