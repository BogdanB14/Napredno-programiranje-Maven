/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.kategorija;

import domen.Kategorija;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;
/**
 * Klasa koja predstavlja operaciju učitavanja svih kategorija iz baze podataka.
 * <p>
 * Nasleđuje klasu {@link ApstraktnaGenerickaOperacija} i implementira konkretne metode
 * za učitavanje podataka o kategorijama iz baze podataka. Ova klasa koristi šablon
 * za obavljanje operacije i upravljanje transakcijama u bazi podataka.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class UcitajKategorijeOperacija extends ApstraktnaGenerickaOperacija{
    /**
     * Lista kategorija u kojoj ce biti ucitan rezultat SELECT upita
     */
    List<Kategorija> lista;
    
    /**
     * Proverava preduslove za izvršenje operacije učitavanja kategorija.
     * <p>
     * Ova metoda osigurava da parametar koji se prosleđuje bude {@code null} ili instanca {@link Kategorija}.
     * Ako parametar nije {@code null} i nije instanca {@link Kategorija}, baca se izuzetak sa odgovarajućom porukom.
     * </p>
     * 
     * @param param Parametar koji se koristi za proveru preduslova.
     * @throws Exception Ako parametar nije {@code null} i nije instanca {@link Kategorija}.
     */
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param != null && !(param instanceof Kategorija))
            throw new Exception("Sistem ne moze da ucita kategorije");
    }

    /**
     * Izvršava operaciju učitavanja svih kategorija iz baze podataka.
     * <p>
     * Ova metoda koristi {@code broker} za obavljanje učitavanja podataka o kategorijama.
     * Parametar {@code param} se ignoriše, a rezultati se dobijaju pomoću {@code broker.getAll} metode
     * bez dodatnih SQL uslova.
     * </p>
     * 
     * @param param Parametar koji se koristi u operaciji, u ovom slučaju se ignoriše.
     * @param kljuc Ključ koji se koristi u operaciji, u ovom slučaju se ignoriše.
     * @throws Exception Ako dođe do greške tokom izvršenja operacije.
     */
    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        lista = broker.getAll(new Kategorija(), "");
    }



               
    public void setLista(List<Kategorija> lista) {
        this.lista = lista;
    }


    /**
     * Get metoda - Postavlja listu kategorija.
     * 
     * @return lista Lista kategorija koja ce biti postavljena.
     */
    public List<Kategorija> getLista() {
        return lista;
    }
    
    
    
}
