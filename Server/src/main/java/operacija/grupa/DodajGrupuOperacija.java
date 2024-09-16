/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.grupa;

import domen.Grupa;
import operacija.ApstraktnaGenerickaOperacija;

/**
 * Klasa koja predstavlja operaciju dodavanja nove grupe u bazu podataka.
 * <p>
 * Nasleđuje klasu {@link ApstraktnaGenerickaOperacija} i implementira konkretne metode
 * za dodavanje novih grupa u bazu podataka. Ova klasa koristi šablon
 * za obavljanje operacije i upravljanje transakcijama u bazi podataka.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class DodajGrupuOperacija extends ApstraktnaGenerickaOperacija{

    
    /**
     * Proverava preduslove za izvršenje operacije dodavanja grupe.
     * <p>
     * Ova metoda osigurava da parametar koji se prosleđuje bude instanca {@link Grupa}.
     * Ako parametar nije instanca {@link Grupa}, baca se izuzetak sa odgovarajućom porukom.
     * </p>
     * 
     * @param param Parametar koji se koristi za proveru preduslova.
     * @throws Exception Ako parametar nije instanca {@link Grupa}.
     */
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(!(param instanceof Grupa))
            throw new Exception("Podaci o novoj grupi nisu upamceni");
    }

    /**
     * Izvršava operaciju dodavanja nove grupe u bazu podataka.
     * <p>
     * Ova metoda koristi {@code broker} za obavljanje dodavanja nove grupe u bazu podataka.
     * Parametar {@code param} se pretvara u instancu {@link Grupa} i prosleđuje {@code broker} metodom {@code add}.
     * </p>
     * 
     * @param param Parametar koji se koristi u operaciji, u ovom slučaju instanca {@link Grupa} koja treba da bude dodata.
     * @param kljuc Ključ koji se koristi u operaciji, u ovom slučaju se ne koristi.
     * @throws Exception Ako dođe do greške tokom izvršenja operacije.
     */
    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.add((Grupa) param);
    }
    
}
