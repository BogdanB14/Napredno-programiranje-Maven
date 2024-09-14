/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.trening;

import domen.Trening;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 * Klasa koja predstavlja operaciju za dodavanje novog treninga u bazu podataka.
 * <p>
 * Nasleđuje klasu {@link ApstraktnaGenerickaOperacija} i implementira konkretne metode
 * za dodavanje treninga u bazu podataka. Ova klasa koristi šablon obrazac
 * za obavljanje operacije i upravljanje transakcijama u bazi podataka.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class DodajTreningOperacija extends ApstraktnaGenerickaOperacija {

    /**
     * Proverava preduslove za izvršenje operacije dodavanja treninga.
     * <p>
     * Ova metoda osigurava da parametar koji se prosleđuje nije {@code null}
     * i da je instanca {@link Trening}. Ako parametar nije ispravan, baca se izuzetak
     * sa odgovarajućom porukom.
     * </p>
     * 
     * @param param Parametar koji se koristi za proveru preduslova.
     * @throws Exception Ako parametar nije instanca {@link Trening}.
     */
    @Override
    protected void preduslovi(Object param) throws Exception {
        if (param == null || !(param instanceof Trening)) {
            throw new Exception("Sistem ne može da doda trening.");
        }
    }

    /**
     * Izvršava operaciju dodavanja novog treninga u bazu podataka.
     * <p>
     * Ova metoda koristi {@code broker} za dodavanje novog treninga u bazu podataka.
     * Parametar {@code param} se koristi za dodavanje treninga. Ova operacija ne koristi
     * SQL upit za učitavanje podataka, već samo dodaje novi unos.
     * </p>
     * 
     * @param param Parametar koji se koristi za dodavanje novog treninga u bazu podataka.
     * @param kljuc Ključ koji se koristi u operaciji, ali u ovoj implementaciji se ne koristi.
     * @throws Exception Ako dođe do greške tokom izvršenja operacije.
     */
    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.add((Trening) param);
    }

}

