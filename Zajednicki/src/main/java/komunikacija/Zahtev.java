/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.Serializable;

/**
 * Klasa koja predstavlja zahtev koji korisnik šalje serveru.
 * <p>
 * Ova klasa implementira interfejs {@link Serializable} što omogućava serijalizaciju objekta
 * za prenos podataka između klijenta i servera.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class Zahtev implements Serializable{
        /** 
     * Operacija koju korisnik zahteva od servera.
     * Ovaj objekat predstavlja vrstu operacije koja treba da se izvrši.
     */
    private Operacija operacija;
        /** 
     * Parametar koji se šalje uz zahtev.
     * Ovaj objekat može biti bilo koji tip podataka koji je potreban za izvršenje operacije.
     */
    private Object parametar;

        /**
     * Podrazumevani konstruktor koji inicijalizuje objekat {@code Zahtev}.
     * Ovaj konstruktor ne postavlja nikakve vrednosti za {@code operacija} i {@code parametar}.
     */
    public Zahtev() {
    }

        /**
     * Parametarski konstruktor koji inicijalizuje objekat {@code Zahtev} sa datom operacijom i parametrom.
     *
     * @param operacija Operacija koju korisnik zahteva od servera.
     * @param parametar Parametar koji se šalje uz zahtev.
     */
    public Zahtev(Operacija operacija, Object parametar) {
        this.operacija = operacija;
        this.parametar = parametar;
    }

    
    /**
     * Get metoda - Vraća operaciju koju korisnik zahteva.
     *
     * @return Operacija koju korisnik zahteva od servera.
     */
    public Operacija getOperacija() {
        return operacija;
    }

        /**
     * Set metoda - Postavlja operaciju koju korisnik zahteva.
     *
     * @param operacija Operacija koju korisnik zahteva od servera.
     */
    public void setOperacija(Operacija operacija) {
        this.operacija = operacija;
    }

        /**
     * Get metoda - Vraća parametar koji se šalje uz zahtev.
     *
     * @return Parametar koji se šalje uz zahtev.
     */
    public Object getParametar() {
        return parametar;
    }

        /**
     * Set metoda - Postavlja parametar koji se šalje uz zahtev.
     *
     * @param parametar Parametar koji se šalje uz zahtev.
     */
    public void setParametar(Object parametar) {
        this.parametar = parametar;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

        /**
     * Upoređuje objekat {@code Zahtev} sa drugim objekatom.
     *
     * @param obj Drugi objekat koji se upoređuje.
     * @return {@code true} ako su objekti identični, {@code false} inače.
     * Poređenje se vrši na osnovu vrednosti {@code operacija}.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Zahtev other = (Zahtev) obj;
        return this.operacija == other.operacija;
    }
    
    
    
}
