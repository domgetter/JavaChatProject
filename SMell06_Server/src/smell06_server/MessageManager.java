
import java.util.ArrayList;




public class MessageManager implements Runnable{
    ArrayList<String> messageBuff;
    ArrayList<ClientConnection> connections;
    public MessageManager(ArrayList<String> messageBuff, ArrayList<ClientConnection> connections){
        this.messageBuff = messageBuff;
        this.connections = connections;
    }
    public void run(){
        if(this.messageBuff.size() == 0){
            try{ Thread.sleep(500);} catch(InterruptedException e){}
        }else{
            while(this.messageBuff.size() > 0){
                String currentMessage = this.messageBuff.remove(0);
                for(ClientConnection connection: connections){
                    connection.passMessage(currentMessage);
                }
            }
        }
    }
    
    
}
