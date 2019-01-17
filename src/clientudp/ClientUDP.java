package clientudp;

import java.io.IOException;
import java.net.*;

public class ClientUDP {
    private String stringaRicevuta;

    public ClientUDP() {
        this.stringaRicevuta = "";
    }

    public void riceviMessaggio() {
        byte[] messaggioRicevuto = new byte[1024];
        try {
            DatagramSocket ricevitore = new DatagramSocket();
            DatagramPacket ricevitorePacchetto = new DatagramPacket(messaggioRicevuto,messaggioRicevuto.length,InetAddress.getByName("127.0.0.1"),4316);
            ricevitore.receive(ricevitorePacchetto);
            this.stringaRicevuta = new String(ricevitorePacchetto.getData(),0,ricevitorePacchetto.getLength());
            System.out.println("Beccati questo! " + this.getStringaRicevuta());
        } catch (UnknownHostException hostSconosciuto) {
            System.err.println("Host non in rete");
        } catch (IOException erroreFlusso) {
            System.err.println("Errore del flusso in ingresso");
        }

    }

    public String getStringaRicevuta() {
        return this.stringaRicevuta;
    }
}
