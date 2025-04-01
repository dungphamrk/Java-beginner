package Ex5;

public class Writer extends Thread{
    private SharedData sharedData;

    public Writer(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run(){
        String[] messages = {
                "MOT",
                "HAI",
                "BA",
                "BON"
        };

        for(String message : messages){
            sharedData.writeMessage(message);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}