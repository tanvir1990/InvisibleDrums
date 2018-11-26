import socket



def filesend():
    print ("which file to send?")
    prompt = ': '
    while True:
        name = input(prompt)

        (HOST,PORT)=('localhost',19123)
        s=socket.socket(socket.AF_INET,socket.SOCK_STREAM);
        s.connect((HOST,PORT))
        WAVE_OUTPUT_FILENAME = name

        with open(WAVE_OUTPUT_FILENAME, 'rb') as wave_file:
            s.sendfile(wave_file)

        s.close()
        break;


filesend();

