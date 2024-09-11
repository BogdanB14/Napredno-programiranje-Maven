/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.trening;

import domen.Trening;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 * Klasa koja predstavlja operaciju za učitavanje svih treninga iz baze podataka.
 * <p>
 * Nasleđuje klasu {@link ApstraktnaGenerickaOperacija} i implementira konkretne metode
 * za učitavanje podataka o treninzima iz baze podataka. Ova klasa koristi šablon 
 * za obavljanje operacije i upravljanje transakcijama u bazi podataka.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class UcitajTreningeOperacija extends ApstraktnaGenerickaOperacija{
    private List<Trening> lista;
    
        /**
     * Proverava preduslove za izvršenje operacije učitavanja treninga.
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
        if(param != null &&!(param instanceof Trening))
            throw new Exception("Sistem ne moze da ucita treninge");
    }

        /**
     * Izvršava operaciju učitavanja svih treninga iz baze podataka.
     * <p>
     * Ova metoda koristi {@code broker} za učitavanje podataka o svim treninzima
     * iz baze podataka. Parametar {@code param} se koristi za identifikaciju tipa
     * objekta koji se učitava. Metod koristi SQL join upit za učitavanje povezanih podataka.
     * </p>
     * 
     * @param param Parametar koji se koristi za identifikaciju tipa objekta za učitavanje.
     * @param kljuc Ključ koji se koristi u operaciji, ali u ovoj implementaciji se ne koristi.
     * @throws Exception Ako dođe do greške tokom izvršenja operacije.
     */
    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        lista = broker.getAll(new Trening(), " JOIN sala sala ON trening.`sala`= sala.`salaID` JOIN mesto mesto ON sala.`mesto`= mesto.`mestoID` JOIN trener trener ON trening.`trener`= trener.`trenerID` JOIN mesto mesto2 ON trener.`mesto`= mesto2.`mestoID` JOIN grupa grupa ON trening.`grupa`= grupa.`grupaID`");
    }

     /**
     * Vraća listu treninga koja je učitana tokom operacije.
     * <p>
     * Lista se koristi za prikaz svih učitanih treninga nakon izvršenja operacije.
     * </p>
     * 
     * @return Lista treninga.
     */
    public List<Trening> getLista() {
        return lista;
    }

        /**
     * Postavlja listu treninga koja treba da bude korišćena ili prikazana.
     * <p>
     * Lista se koristi za prikaz svih učitanih treninga nakon izvršenja operacije.
     * </p>
     * 
     * @param lista Lista treninga koju treba postaviti.
     */
    public void setLista(List<Trening> lista) {
        this.lista = lista;
    }
    
    
    
}
