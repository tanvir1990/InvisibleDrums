package udptest;

public class test {

    static class Runnable1 implements Runnable{
        public Runnable1(){}
        public void run(){
            try{
                System.out.println(" run server");
                Thread.sleep(1000);
                FileServer receiver = new FileServer();
                receiver.run();
         

            }catch ( Exception ie){
                System.out.println(ie);
            }
        }     
    }


    static class Runnable2 implements Runnable{
        public Runnable2(){}
        public void run(){
            try{
                System.out.println(" run client");
                Thread.sleep(2000);
                FileClient sender = new FileClient();
                sender.run();
                Thread.sleep(1000);

            }catch ( Exception ie){
                System.out.println(ie);
            }
        }     
    }
    
    public static void main(String[] args) throws InterruptedException{        
        Thread t1 = new Thread(new test.Runnable1());
        Thread t2 = new Thread(new test.Runnable2());      
        
        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }     
}
