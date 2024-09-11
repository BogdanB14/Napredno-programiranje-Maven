/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.mesto;

import domen.Mesto;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 * Klasa koja predstavlja operaciju za preuzimanje svih mesta iz baze podataka.
 * <p>
 * Nasleđuje klasu {@link ApstraktnaGenerickaOperacija} i implementira konkretne metode
 * za preuzimanje mesta iz baze podataka. Ova klasa koristi šablon 
 * za obavljanje operacije i upravljanje transakcijama u bazi podataka.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class UcitajMestaOperacija extends ApstraktnaGenerickaOperacija{
    /**
     * Lista mesta u kojoj ce se ucitati rezultat SELECT upita
     */
    private List<Mesto> lista;
    
        /**
     * Proverava preduslove za izvršenje operacije preuzimanja mesta.
     * <p>
     * Ova metoda osigurava da parametar koji se prosleđuje nije {@code null} i da je instanca {@link Mesto}.
     * Ako parametar nije ispravan, baca se izuzetak sa odgovarajućom porukom.
     * </p>
     * 
     * @param param Parametar koji se koristi za proveru preduslova.
     * @throws Exception Ako parametar nije ispravan (nije instanca {@link Mesto} ili je {@code null}).
     */
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param != null && !(param instanceof Mesto))
            throw new Exception("Sistem ne moze da ucita mesta");
    }

        /**
     * Izvršava operaciju preuzimanja svih mesta iz baze podataka.
     * <p>
     * Ova metoda koristi {@code broker} za preuzimanje svih mesta iz baze podataka. 
     * Rezultat preuzimanja se čuva u privatnom atributu {@code lista}.
     * </p>
     * 
     * @param param Parametar koji se koristi za izvršenje operacije, u ovom slučaju se ignoriše.
     * @param kljuc Ključ koji se koristi u operaciji, u ovom slučaju se ignoriše.
     * @throws Exception Ako dođe do greške tokom izvršenja operacije.
     */
    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        lista = broker.getAll(new Mesto(), "");
    }

        /**
     * Get metoda - Vraća listu mesta ucitanih iz baze podataka.
     * 
     * @return Lista mesta {@link Mesto} preuzetih iz baze podataka.
     */
    public List<Mesto> getLista() {
        return lista;
    }

        /**
     * Set metoda - Postavlja listu mesta ucitanih iz baze podataka.
     * 
     * @param lista Lista mesta {@link Mesto} koja će biti postavljena.
     */
    public void setLista(List<Mesto> lista) {
        this.lista = lista;
    }
    
    
}
