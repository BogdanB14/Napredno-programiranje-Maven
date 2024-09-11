/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.administrator;

import domen.Administrator;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 * Klasa koja predstavlja konkretne operacije za učitavanje administratora iz baze podataka.
 * <p>
 * Nasleđuje klasu {@link ApstraktnaGenerickaOperacija} i implementira konkretne metode
 * za učitavanje svih administratora. Ova klasa koristi šablon za obavljanje operacije
 * i upravljanje transakcijama u bazi podataka.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class UcitajAdministratoreOperacija extends ApstraktnaGenerickaOperacija{
        /**
     * Lista administratora koja se popunjava rezultatom operacije.
     */
    List<Administrator> lista;
    
        /**
     * Proverava preduslove za izvršenje operacije.
     * <p>
     * Ova metoda se koristi za osiguranje da parametar koji se prosleđuje
     * bude validan. Za ovu operaciju, parametar mora biti {@code null} ili instanca {@link Administrator}.
     * </p>
     * 
     * @param param Parametar koji se koristi za proveru preduslova.
     * @throws Exception Ako parametar nije {@code null} i nije instanca {@link Administrator}.
     */
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param != null && !(param instanceof Administrator))
            throw new Exception("");
    }

        /**
     * Izvršava operaciju učitavanja svih administratora iz baze podataka.
     * <p>
     * Ova metoda koristi {@code broker} za obavljanje upita i popunjava listu administratora
     * sa rezultatima iz baze podataka.
     * </p>
     * 
     * @param param Parametar koji se koristi u operaciji. Ova operacija ne koristi ovaj parametar.
     * @param kljuc Ključ koji se koristi u operaciji. Ova operacija ne koristi ovaj ključ.
     * @throws Exception Ako dođe do greške tokom izvršenja operacije.
     */
    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        lista = broker.getAll(new Administrator(), "");
    }

        /**
     * Vraća listu administratora koja je popunjena rezultatima operacije.
     * 
     * @return Lista administratora.
     */
    public List<Administrator> getLista() {
        return lista;
    }

        /**
     * Postavlja listu administratora.
     * 
     * @param lista Lista administratora za postavljanje.
     */
    public void setLista(List<Administrator> lista) {
        this.lista = lista;
    }
    
    
}
