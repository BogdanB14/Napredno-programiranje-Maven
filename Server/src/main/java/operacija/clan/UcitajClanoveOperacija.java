/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.clan;

import domen.Clan;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 * Klasa koja predstavlja operaciju učitavanja članova iz baze podataka.
 * <p>
 * Nasleđuje klasu {@link ApstraktnaGenerickaOperacija} i implementira konkretne metode
 * za učitavanje podataka o članovima iz baze podataka. Ova klasa koristi šablon
 * za obavljanje operacije i upravljanje transakcijama u bazi podataka.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class UcitajClanoveOperacija extends ApstraktnaGenerickaOperacija {

    /**
     * Lista članova učitana iz baze podataka.
     * <p>
     * Ova promenljiva čuva rezultate operacije učitavanja članova iz baze podataka.
     * </p>
     */
    List<Clan> lista;
    
    
    /**
     * Proverava preduslove za izvršenje operacije učitavanja članova.
     * <p>
     * Ova metoda osigurava da parametar koji se prosleđuje bude {@code null} ili instanca {@link Clan}.
     * Ako parametar nije {@code null} i nije instanca {@link Clan}, baca se izuzetak sa odgovarajućom porukom.
     * </p>
     * 
     * @param param Parametar koji se koristi za proveru preduslova.
     * @throws Exception Ako parametar nije {@code null} i nije instanca {@link Clan}.
     */
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param != null && !(param instanceof Clan))
            throw new Exception("Sistem ne moze da ucita clanove");
    }

    /**
     * Izvršava operaciju učitavanja članova iz baze podataka.
     * <p>
     * Ova metoda koristi {@code broker} za učitavanja članova iz baze podataka.
     * Parametar {@code param} se ne koristi u ovoj operaciji. SQL upit za učitavanje članova uključuje 
     * pridruživanje sa tabelom {@code mesto}.
     * </p>
     * 
     * @param param Parametar koji se koristi u operaciji, u ovom slučaju se ne koristi.
     * @param kljuc Ključ koji se koristi u operaciji, u ovom slučaju se ne koristi.
     * @throws Exception Ako dođe do greške tokom izvršenja operacije.
     */
    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        lista = broker.getAll(new Clan(), " JOIN mesto mesto ON clan.mesto=mesto.mestoID");
    }

    /**
     * Get metoda - Vraća listu članova učitanu iz baze podataka.
     * 
     * @return Lista članova.
     */
    public List<Clan> getLista() {
        return lista;
    }

    /**
     * Set metoda- Postavlja listu članova.
     * 
     * @param lista Lista članova koja će biti postavljena.
     */
    public void setLista(List<Clan> lista) {
        this.lista = lista;
    }

    
    
    
    
}
