package ChatRMI;


import static javax.swing.JOptionPane.showInputDialog;

public class Cliente {

    private static String host;

    public static void main(String args[]) {
        String nome  = showInputDialog("Digite seu nome: ");

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                host = (args.length < 1) ? null : args[0];
                TelaCliente telaChat = new TelaCliente(nome);
                telaChat.setVisible(true);

            }
        });

    }
}
