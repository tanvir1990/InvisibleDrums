# InvisibleDrums
Please follow the instructions provided here to run the code. 

1. Clone the repository on your machine
2. Go to Invisible Drums-Final Version folder. This folder contains all the code for the project. The project has 4 different components. To succeffully run the project all the hardware are important to have. To find the list of hardware please follow the 'List of Hardware' on the Final Report.
3. When firstime loading the code into Raspberry pi, few things need to do for user is: 
  a) Edit ip address for sending and receiving class,
  b) Edit folderPath in sending, receiving and replaceTone class and create the folder at the same path.
  c) The Ip address is basing on wi-fi and it's dynamic. User can read from the internet status on the top-right of Raspberry Pi         interface.
4. For the method replaceTone, add an empty wav file and name it tone.wav to apply playTone. This playTone is a python script which looks for a tone named as tone.wav inside the folder. This is the tone which will be played by the python script.
5. For previous version, the user need to reload playTone.py after replace tone, system needs to load the newTone. 
