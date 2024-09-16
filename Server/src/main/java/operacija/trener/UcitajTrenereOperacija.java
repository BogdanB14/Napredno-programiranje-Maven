/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.trener;

import domen.Trener;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 * Klasa koja predstavlja operaciju za učitavanje trenera iz baze podataka.
 * <p>
 * Nasleđuje klasu {@link ApstraktnaGenerickaOperacija} i implementira konkretne metode
 * za preuzimanje liste trenera iz baze podataka. Ova klasa koristi šablon obrazac
 * za obavljanje operacije i upravljanje transakcijama u bazi podataka.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class UcitajTrenereOperacija extends ApstraktnaGenerickaOperacija{
    /**
     * Lista trenera u kojoj ce biti ucitan rezultat SELECT upita
     */
    List<Trener> lista;
    
    /**
     * Proverava preduslove za izvršenje operacije učitavanja trenera.
     * <p>
     * Ova metoda osigurava da parametar koji se prosleđuje nije {@code null}
     * i da je instanca {@link Trener}. Ako parametar nije ispravan, baca se izuzetak
     * sa odgovarajućom porukom.
     * </p>
     * 
     * @param param Parametar koji se koristi za proveru preduslova.
     * @throws Exception Ako parametar nije instanca {@link Trener}.
     */
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param != null && !(param instanceof Trener))
            throw new Exception("Sistem ne moze da ucita trener");
    }

    /**
     * Izvršava operaciju učitavanja trenera iz baze podataka.
     * <p>
     * Ova metoda koristi {@code broker} za preuzimanje liste trenera iz baze podataka. 
     * Parametar {@code param} se koristi kao kriterijum za pretragu, dok se koristi SQL 
     * JOIN za povezivanje sa tabelom mesta. Rezultati se čuvaju u listi {@code lista}.
     * </p>
     * 
     * @param param Parametar koji se koristi za pretragu trenera. U ovoj implementaciji 
     *              se ne koristi za specifične filtere.
     * @param kljuc Ključ koji se koristi u operaciji, ali u ovoj implementaciji se ne koristi.
     * @throws Exception Ako dođe do greške tokom izvršenja operacije.
     */
    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
       lista = broker.getAll(new Trener(), " JOIN mesto mesto ON trener.mesto=mesto.mestoID");
    }

    /**
     * Get metoda - Vraća listu trenera učitanih iz baze podataka.
     * 
     * @return Lista trenera.
     */
    public List<Trener> getLista() {
        return lista;
    }

    /**
     * Set metoda - Postavlja listu trenera učitanih iz baze podataka.
     * 
     * @param lista Lista trenera koju treba postaviti.
     */
    public void setLista(List<Trener> lista) {
        this.lista = lista;
    }
    
    
}
