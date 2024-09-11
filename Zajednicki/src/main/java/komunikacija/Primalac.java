/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa koja predstavlja prijemnik za primanje objekata od klijenta.
 * <p>
 * Ova klasa omogućava serveru da primi serijalizovane objekte 
 * koristeći {@link Socket} i {@link ObjectInputStream}. Koristi se za prijem zahteva
 * i drugih podataka od klijenta u komunikaciji između klijenta i servera.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class Primalac {
        /**
     * Socket koji se koristi za komunikaciju.
     */
    private Socket socket;

        /**
     * Konstruktor koji inicijalizuje objekat {@code Primalac} sa datim soketom.
     *
     * @param socket Socket koji koristi ovaj primalac za komunikaciju.
     */
    public Primalac(Socket socket) {
        this.socket = socket;
    }
    
        /**
     * Metoda koja prima objekat od klijenta.
     * <p>
     * Ova metoda koristi {@link ObjectInputStream} za čitanje objekta sa socket veze.
     * Ako dođe do greške tokom čitanja objekta, greška se ispisuje na standardni izlaz.
     * </p>
     * 
     * @return Objekte koji je primljen sa klijentove strane ili {@code null} ako dođe do greške.
     */
    public Object primi(){
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            return ois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
