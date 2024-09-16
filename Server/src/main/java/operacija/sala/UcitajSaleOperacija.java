/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.sala;

import domen.Sala;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 * Klasa koja predstavlja operaciju za preuzimanje svih sala iz baze podataka.
 * <p>
 * Nasleđuje klasu {@link ApstraktnaGenerickaOperacija} i implementira konkretne metode
 * za preuzimanje sala iz baze podataka. Ova klasa koristi šablon 
 * za obavljanje operacije i upravljanje transakcijama u bazi podataka.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class UcitajSaleOperacija extends ApstraktnaGenerickaOperacija{
    List<Sala> lista;
    
    /**
     * Proverava preduslove za izvršenje operacije preuzimanja sala.
     * <p>
     * Ova metoda osigurava da parametar koji se prosleđuje nije {@code null} i da je instanca {@link Sala}.
     * Ako parametar nije ispravan, baca se izuzetak sa odgovarajućom porukom.
     * </p>
     * 
     * @param param Parametar koji se koristi za proveru preduslova.
     * @throws Exception Ako parametar nije ispravan (nije instanca {@link Sala} ili je {@code null}).
     */
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param != null && !(param instanceof Sala))
            throw new Exception("Sistem ne moze da ucita sale");
    }

    /**
     * Izvršava operaciju preuzimanja svih sala iz baze podataka.
     * <p>
     * Ova metoda koristi {@code broker} za preuzimanje svih sala iz baze podataka. 
     * Rezultat preuzimanja se čuva u privatnom atributu {@code lista}.
     * </p>
     * 
     * @param param Parametar koji se koristi za izvršenje operacije, u ovom slučaju se ignoriše.
     * @param kljuc Ključ koji se koristi u operaciji, u ovom slučaju se koristi za pridruživanje sa tabelom {@code mesto}.
     * @throws Exception Ako dođe do greške tokom izvršenja operacije.
     */
    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        lista = broker.getAll(new Sala(), " JOIN mesto mesto ON sala.mesto=mesto.mestoID");
    }

    /**
     * Get metoda - Vraća listu sala preuzetih iz baze podataka.
     * 
     * @return Lista sala {@link Sala} preuzetih iz baze podataka.
     */
    public List<Sala> getLista() {
        return lista;
    }

    /**
     * Set metoda - Postavlja listu sala preuzetih iz baze podataka.
     * 
     * @param lista Lista sala {@link Sala} koja će biti postavljena.
     */
    public void setLista(List<Sala> lista) {
        this.lista = lista;
    }
    
    
}
