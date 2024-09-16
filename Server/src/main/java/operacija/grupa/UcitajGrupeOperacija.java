/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.grupa;

import domen.Grupa;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 * Klasa koja predstavlja operaciju učitavanja svih grupa iz baze podataka.
 * <p>
 * Nasleđuje klasu {@link ApstraktnaGenerickaOperacija} i implementira konkretne metode
 * za učitavanje podataka o grupama iz baze podataka. Ova klasa koristi šablon obrazac
 * za obavljanje operacije i upravljanje transakcijama u bazi podataka.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class UcitajGrupeOperacija extends ApstraktnaGenerickaOperacija{
    /**
     * Lista grupa u kojoj ce se ucitati rezultat metode.
     */
    private List<Grupa> lista;
    
    /**
     * Proverava preduslove za izvršenje operacije učitavanja grupa.
     * <p>
     * Ova metoda osigurava da parametar koji se prosleđuje bude {@code null} ili instanca {@link Grupa}.
     * Ako parametar nije {@code null} i nije instanca {@link Grupa}, baca se izuzetak sa odgovarajućom porukom.
     * </p>
     * 
     * @param param Parametar koji se koristi za proveru preduslova.
     * @throws Exception Ako parametar nije {@code null} i nije instanca {@link Grupa}.
     */
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param != null && !(param instanceof Grupa))
            throw new Exception("Sistem ne moze da ucita grupe");
    }

    /**
     * Izvršava operaciju učitavanja svih grupa iz baze podataka.
     * <p>
     * Ova metoda koristi {@code broker} za obavljanje učitavanja podataka o grupama.
     * Parametar {@code param} se ignoriše, a rezultati se dobijaju pomoću {@code broker.getAll} metode sa SQL join-om
     * i sortiraju se po ID-ju grupe.
     * </p>
     * 
     * @param param Parametar koji se koristi u operaciji, u ovom slučaju se ignoriše.
     * @param kljuc Ključ koji se koristi u operaciji, u ovom slučaju se ignoriše.
     * @throws Exception Ako dođe do greške tokom izvršenja operacije.
     */
    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        lista = broker.getAll(new Grupa(), " JOIN kategorija kategorija ON grupa.`kategorija`=kategorija.`kategorijaID` JOIN administrator administrator ON grupa.`administrator`=administrator.`administratorID` JOIN trener trener ON grupa.`trener`=trener.`trenerID` JOIN mesto mesto ON trener.`mesto`=mesto.`mestoID` ORDER BY grupa.grupaID");
    }

    /**
     * Get metoda - Vraća listu grupa koje su učitane iz baze podataka.
     * 
     * @return Lista grupa.
     */
    public List<Grupa> getLista() {
        return lista;
    }

    /**
     * Set metoda- Postavlja listu grupa.
     * 
     * @param lista Lista grupa koja će biti postavljena.
     */
    public void setLista(List<Grupa> lista) {
        this.lista = lista;
    }
    
    
    
}
