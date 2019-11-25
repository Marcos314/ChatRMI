package ChatRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/*
*Interface implementada pelo servidor.
 */
//Extende a classe remota
public interface ChatInterface extends Remote {

    /*
    *Métodos que podem ser chamados remotamente, e lançam RemoteException.
     */
    public void enviarMensagem(String nome, String mensagem) throws RemoteException;

    //public ArrayList<String> lerMensagem() throws RemoteException;

    public String lerMensagem(int n) throws RemoteException;
}
