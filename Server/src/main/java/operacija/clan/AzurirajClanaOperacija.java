/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.clan;

import domen.Clan;
import operacija.ApstraktnaGenerickaOperacija;

/**
 * Klasa koja predstavlja operaciju ažuriranja podataka o članu u bazi podataka.
 * <p>
 * Nasleđuje klasu {@link ApstraktnaGenerickaOperacija} i implementira konkretne metode
 * za ažuriranje podataka o članu. Ova klasa koristi šablon za obavljanje operacije
 * i upravljanje transakcijama u bazi podataka.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class AzurirajClanaOperacija extends ApstraktnaGenerickaOperacija{
        /**
     * Staticka promenljiva koja označava rezultat ažuriranja.
     * <p>
     * Ova promenljiva je postavljena na {@code false} kada se operacija započne i ažurira se
     * tokom izvršenja operacije. Pokušava se da se ažurira podatak o članu i rezultat se čuva
     * u ovoj promenljivoj.
     * </p>
     */
    public static boolean update = false;
    
        /**
     * Proverava preduslove za izvršenje operacije.
     * <p>
     * Ova metoda osigurava da parametar koji se prosleđuje bude instanca {@link Clan}.
     * Ako parametar nije instanca {@link Clan} ili je {@code null}, baca se izuzetak.
     * </p>
     * 
     * @param param Parametar koji se koristi za proveru preduslova.
     * @throws Exception Ako parametar nije instanca {@link Clan} ili je {@code null}.
     */
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param == null || !(param instanceof Clan))
            throw new Exception("Sistem ne moze da ucita clana");
    }

        /**
     * Izvršava operaciju ažuriranja podataka o članu u bazi podataka.
     * <p>
     * Ova metoda koristi {@code broker} za obavljanje ažuriranja podataka o članu.
     * Rezultat operacije (da li je ažuriranje uspešno ili ne) se čuva u statičkoj promenljivoj {@code update}.
     * </p>
     * 
     * @param param Parametar koji se koristi u operaciji, mora biti instanca {@link Clan}.
     * @param kljuc Ključ koji se koristi u operaciji. Ova operacija ne koristi ovaj ključ.
     * @throws Exception Ako dođe do greške tokom izvršenja operacije.
     */
    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        System.out.println("Usao u izvrsi oeraciju u AzurirajClanaOperacija");
        System.out.println("BOOLEAN UPDATE PRE broker.edit = " + update);
        update = broker.edit((Clan) param);
        System.out.println("BOOLEAN UPDATE POSLE broker.edit = " + update);
    }
    
}
