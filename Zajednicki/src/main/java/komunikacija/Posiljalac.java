/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa koja predstavlja pošiljaoca za slanje objekata.
 * <p>
 * Ova klasa omogućava serveru da šalje serijalizovane objekte
 * koristeći {@link Socket} i {@link ObjectOutputStream}. Koristi se za slanje zahteva
 * i odgovora između servera i klijenta u komunikaciji klijent-server.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class Posiljalac {
    //Kod posiljalaca se koristi za outpustStream, a kod primaoca inputStream
    /**
     * Socket koji koristi ova klasa za komunikaciju.
     */
    private Socket socket; 


    /**
     * Konstruktor koji inicijalizuje objekat {@code Posiljalac} sa datim soketom.
     *
     * @param socket Socket koji koristi ovaj pošiljalac za komunikaciju.
     */
    public Posiljalac(Socket socket) {
        this.socket = socket;
    }
    
    /**
     * Metoda koja šalje objekat.
     * <p>
     * Ova metoda koristi {@link ObjectOutputStream} za slanje objekta preko socket veze.
     * Nakon slanja objekta, koristi se {@code flush()} metoda da bi se osiguralo da su
     * svi podaci poslati. Ako dođe do greške tokom slanja, greška se ispisuje na standardni izlaz.
     * </p>
     * 
     * @param obj Objekat koji treba da se pošalje.
     */
    public void posalji(Object obj){ try {
        //Salje ili zahtev ili odgovor
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(obj);
        oos.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    
}
