/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.trener;

import domen.Trener;
import operacija.ApstraktnaGenerickaOperacija;

/**
 * Klasa koja predstavlja operaciju za dodavanje novog trenera u bazu podataka.
 * <p>
 * Nasleđuje klasu {@link ApstraktnaGenerickaOperacija} i implementira konkretne metode
 * za dodavanje trenera u bazu podataka. Ova klasa koristi šablon 
 * za obavljanje operacije i upravljanje transakcijama u bazi podataka.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class DodajTreneraOperacija extends ApstraktnaGenerickaOperacija{

        /**
     * Proverava preduslove za izvršenje operacije dodavanja trenera.
     * <p>
     * Ova metoda osigurava da parametar koji se prosleđuje jeste instanca {@link Trener}.
     * Ako parametar nije ispravan, baca se izuzetak sa odgovarajućom porukom.
     * </p>
     * 
     * @param param Parametar koji se koristi za proveru preduslova.
     * @throws Exception Ako parametar nije instanca {@link Trener}.
     */
    @Override
    protected void preduslovi(Object param) throws Exception {
                if(!(param instanceof Trener))
            throw new Exception("Podaci o novom treneru nisu upamceni");

        
    }
    /**
     * Izvršava operaciju dodavanja novog trenera u bazu podataka.
     * <p>
     * Ova metoda koristi {@code broker} za dodavanje trenera u bazu podataka. 
     * Parametar {@code param} se konvertuje u instancu {@link Trener} i prosleđuje metodi {@code add()}.
     * </p>
     * 
     * @param param Parametar koji sadrži podatke o treneru koji se dodaje.
     * @param kljuc Ključ koji se koristi u operaciji, ali u ovoj implementaciji se ne koristi.
     * @throws Exception Ako dođe do greške tokom izvršenja operacije.
     */
    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.add((Trener) param);
    }
    
}
