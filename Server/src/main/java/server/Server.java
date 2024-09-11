/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import controller.Controller;
import domen.Administrator;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import niti.ObradaKlijentskihZahteva;

/**
 *
 * @author Bogdan Blagojevic
 */
public class Server extends Thread{
    private boolean kraj = false;
    private ServerSocket serverSocket;
  
    


    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(9000);
            while(!kraj){
                Socket s = serverSocket.accept();
                System.out.println("Klijent se povezao");
                
                ObradaKlijentskihZahteva okz = new ObradaKlijentskihZahteva(s);
                Controller.getInstance().getListaTrenutnihKorisnika().add(okz);
                okz.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void zaustaviServer(){
        try {
            kraj = true;
            List<ObradaKlijentskihZahteva> lista = Controller.getInstance().getListaTrenutnihKorisnika();
            for(ObradaKlijentskihZahteva o : lista){
                o.prekiniNit();
            }
            serverSocket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }
    
    
}
