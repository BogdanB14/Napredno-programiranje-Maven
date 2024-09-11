/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package konfiguracija;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa koja upravlja konfiguracionim datotekama u aplikaciji.
 * <p>
 * Ova klasa koristi Singleton obrazac kako bi obezbedila jedinstvenu instancu za 
 * upravljanje konfiguracijama. Omogućava učitavanje, pristupanje i čuvanje
 * konfiguracionih svojstava iz datoteke.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class Konfiguracija {
        /**
     * Singleton instanca klase {@code Konfiguracija}.
     */
    private static Konfiguracija instanca;
        /**
     * Objekt koji sadrži konfiguracijska svojstva.
     */
    private Properties konfiguracija;
    
        /**
     * Vraća jedinu instancu klase {@code Konfiguracija} (Singleton).
     * <p>
     * Ako instanca ne postoji, kreira se nova instanca i vraća.
     * </p>
     * 
     * @return Instanca klase {@code Konfiguracija}.
     */
    public static Konfiguracija getInstance(){
        if(instanca == null)
            instanca = new Konfiguracija();
        return instanca;
    }
    
    /**
     * Privatni konstruktor koji inicijalizuje konfiguraciju.
     * <p>
     * Ovaj konstruktor učitava konfiguraciona svojstva iz datoteke
     * {@code config.properties}. Ako dođe do greške tokom učitavanja,
     * prijavljuje grešku putem {@link Logger}.
     * </p>
     */ 
    private Konfiguracija(){
        try {
            konfiguracija = new Properties();
            konfiguracija.load(new FileInputStream("D:\\Projektovanje softvera workspace\\Seminarski\\Server\\config\\config.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(Konfiguracija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        /**
     * Vraća vrednost propertija na osnovu ključa.
     * <p>
     * Ako ključ ne postoji, vraća podrazumevanu vrednost {@code "n/a"}.
     * </p>
     * 
     * @param key Ključ propertija.
     * @return Vrednost propertija ili {@code "n/a"} ako ključ ne postoji.
     */
    public String getProperty(String key){
        return konfiguracija.getProperty(key, "n/a");
    }
    
        
    /**
     * Postavlja novu vrednost za konfiguracionu osobinu na osnovu ključa.
     * <p>
     * Ova metoda menja ili dodaje properti u memoriji, ali ne
     * čuva promene u datoteci dok se metoda {@link #sacuvajIzmene()} ne pozove.
     * </p>
     * 
     * @param key Ključ propertija.
     * @param value Nova vrednost propertija.
     */
    public void setProperty(String key, String value){
        konfiguracija.setProperty(key, value);
    }
    
        /**
     * Čuva trenutne izmene propertija u datoteku.
     * <p>
     * Ova metoda upisuje sve promene iz memorije u datoteku {@code config.properties}.
     * Ako dođe do greške tokom upisa, prijavljuje grešku putem {@link Logger}.
     * </p>
     */
    public void sacuvajIzmene(){
        try {
            konfiguracija.store(new FileOutputStream("D:\\Projektovanje softvera workspace\\Seminarski\\Server\\config\\config.properties"), null);
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(Konfiguracija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
