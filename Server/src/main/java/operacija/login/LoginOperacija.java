/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.login;

import domen.Administrator;

import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 * Klasa koja predstavlja operaciju prijave administratora u sistem.
 * <p>
 * Nasleđuje klasu {@link ApstraktnaGenerickaOperacija} i implementira konkretne metode
 * za prijavu administratora koristeći podatke koji se prosleđuju. Ova klasa koristi šablon obrazac
 * za obavljanje operacije i upravljanje transakcijama u bazi podataka.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class LoginOperacija extends ApstraktnaGenerickaOperacija {
    /**
     * PRivatni atribut klase Administrator koji ce pokupiti rezultat SELECT upita
     */
    private Administrator administrator;
    
    /**
     * Proverava preduslove za izvršenje operacije prijave administratora.
     * <p>
     * Ova metoda osigurava da parametar koji se prosleđuje nije {@code null} i da je instanca {@link Administrator}.
     * Ako parametar nije ispravan, baca se izuzetak sa odgovarajućom porukom.
     * </p>
     * 
     * @param param Parametar koji se koristi za proveru preduslova.
     * @throws Exception Ako parametar nije ispravan (nije instanca {@link Administrator} ili je {@code null}).
     */
    @Override
    protected void preduslovi(Object param) throws Exception {
            if(param == null || !(param instanceof Administrator))
                throw new Exception("Sistem ne moze da pronadje administratora na osnovu unetih podataka");
            
    }

    /**
     * Izvršava operaciju prijave administratora.
     * <p>
     * Ova metoda koristi {@code broker} za preuzimanje svih administratora iz baze podataka i upoređuje
     * ih sa prosleđenim parametrima. Ako pronađe odgovarajućeg administratora, postavlja ga kao trenutno
     * prijavljenog. Ako ne pronađe odgovarajućeg administratora, postavlja {@code administrator} na {@code null}.
     * </p>
     * 
     * @param param Parametar koji se koristi za upoređivanje (treba da bude instanca {@link Administrator}).
     * @param kljuc Ključ koji se koristi u operaciji, u ovom slučaju se ignoriše.
     * @throws Exception Ako dođe do greške tokom izvršenja operacije.
     */
    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        List<Administrator> listaAdministratora = broker.getAll((Administrator) param, null);
        System.out.println("LOGIN OPERACIJA ADMINISTRATORA, SVI ADMINISTRATORI: " + listaAdministratora);
        
        for(Administrator a : listaAdministratora){
            if(a.equals((Administrator) param)){
                administrator = a;
                return;
            }
        }
        administrator = null;
    }

    /**
     * Get metoda - Vraća trenutno prijavljenog administratora.
     * 
     * @return Trenutno prijavljeni {@link Administrator}, ili {@code null} ako nije pronađen.
     */
    public Administrator getAdministrator() {
        return administrator;
    }

    
}
