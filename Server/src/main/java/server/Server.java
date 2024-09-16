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
 * Klasa koja implementira server za prihvatanje i obrada klijentskih zahteva.
 * <p>
 * Ova klasa koristi {@code ServerSocket} za uspostavljanje veze sa klijentima na određenom portu. 
 * Kada klijent uspostavi vezu, server kreira novu instancu {@link ObradaKlijentskihZahteva} 
 * za obrada zahteva i upravljanje komunikacijom sa klijentom. Server može biti zaustavljen 
 * pozivanjem metode {@link #zaustaviServer()}, koja takođe prekida sve trenutne klijentske niti.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class Server extends Thread{
    /**
     * Flag koji se koristi za zaustavljanje i pokretanje while petlje u serverskoj niti
     */
    private boolean kraj = false;
    /**
     * Socket koji prihvata dolazne konekcije klijenta na istom portu.
     */
    private ServerSocket serverSocket;
  
    

    /**
     * Glavna metoda koja pokreće server.
     * <p>
     * Ova metoda kreira {@code ServerSocket} na portu 9000 i neprekidno prihvata 
     * dolazne veze od klijenata. Za svakog povezanog klijenta, kreira se nova nit 
     * {@link ObradaKlijentskihZahteva} koja će obraditi klijentske zahteve.
     * </p>
     */
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
    
    
    /**
     * Zaustavlja server i prekida sve trenutne klijentske niti.
     * <p>
     * Ova metoda postavlja {@code kraj} na {@code true} što uzrokuje da se 
     * server zaustavi. Takođe, prekida sve aktivne niti koje trenutno 
     * obrađuju klijentske zahteve i zatvara {@code ServerSocket}.
     * </p>
     */
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

    /**
     * Get metoda - Vraća {@code ServerSocket} koji server koristi za prihvatanje veza.
     * 
     * @return {@code ServerSocket} objekat koji koristi server.
     */
    public ServerSocket getServerSocket() {
        return serverSocket;
    }
    
    
}
