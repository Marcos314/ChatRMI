package ChatRMI;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Servidor implements ChatInterface {
    
    
    private static ArrayList<String> lista;
    private static String mensagem;
    private static String nome;

    public Servidor() {
        lista=new ArrayList<String>();
    }

//    @Override
//    public void enviarMensagem(String mensagem) throws RemoteException {
//        mensagens.add(mensagem);
//    }
//    @Override
//    public ArrayList<String> lerMensagem() throws RemoteException {
//
//    }

    //Método funcionando!
    @Override
    public String lerMensagem(int n)  throws RemoteException  {
        
        if (n < lista.size()) {
            return (n+1) + lista.get(n);        
        }
        
        return null;
    }

    @Override
    public void enviarMensagem(String nome, String mensagem) throws RemoteException {
        String new_msg = nome + ": "+mensagem;        
  
        lista.add(new_msg);
        this.mensagem = new_msg;
        
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Servidor obj = new Servidor();
                    //Exporta o objeto remoto.
                    ChatInterface stub = (ChatInterface) UnicastRemoteObject.exportObject(obj, 0);
                    //Registra o objeto remoto.
                    Registry registry = LocateRegistry.getRegistry();
                    registry.rebind("ChatInterface", stub);
                    System.out.println("Contectado!!");

                } catch (Exception e) {
                    System.out.println("Trouble: " + e);
                }
            }
        });
    }
}
