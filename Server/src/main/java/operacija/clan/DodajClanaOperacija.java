/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.clan;

import domen.Clan;
import operacija.ApstraktnaGenerickaOperacija;

/**
 * Klasa koja predstavlja operaciju dodavanja novog člana u bazu podataka.
 * <p>
 * Nasleđuje klasu {@link ApstraktnaGenerickaOperacija} i implementira konkretne metode
 * za dodavanje podataka o članu u bazu podataka. Ova klasa koristi šablon za obavljanje
 * operacije i upravljanje transakcijama u bazi podataka.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class DodajClanaOperacija extends ApstraktnaGenerickaOperacija{

    /**
     * Proverava preduslove za izvršenje operacije dodavanja člana.
     * <p>
     * Ova metoda osigurava da parametar koji se prosleđuje bude instanca {@link Clan}.
     * Ako parametar nije instanca {@link Clan}, baca se izuzetak sa odgovarajućom porukom.
     * </p>
     * 
     * @param param Parametar koji se koristi za proveru preduslova.
     * @throws Exception Ako parametar nije instanca {@link Clan}.
     */
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(!(param instanceof Clan))
            throw new Exception("Podaci o novom clanu nisu upamceni");

        
    }

    /**
     * Izvršava operaciju dodavanja novog člana u bazu podataka.
     * <p>
     * Ova metoda koristi {@code broker} za obavljanje dodavanja podataka o članu u bazu podataka.
     * Parametar {@code param} mora biti instanca {@link Clan}.
     * </p>
     * 
     * @param param Parametar koji se koristi u operaciji, mora biti instanca {@link Clan}.
     * @param kljuc Ključ koji se koristi u operaciji. Ova operacija ne koristi ovaj ključ.
     * @throws Exception Ako dođe do greške tokom izvršenja operacije.
     */
    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.add((Clan) param);
    }
    
}
