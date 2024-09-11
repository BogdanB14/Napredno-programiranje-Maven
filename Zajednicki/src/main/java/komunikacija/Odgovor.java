/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.Serializable;
import java.util.Objects;

/**
 * Klasa koja predstavlja odgovor koji se koristi za komunikaciju između klijenta i servera.
 * <p>
 * Ova klasa implementira interfejs {@link Serializable} što omogućava serijalizaciju objekta
 * za prenos podataka između klijenta i servera.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class Odgovor implements Serializable{
        /** 
     * Objekat koji predstavlja odgovor servera.
     * Može biti bilo koje vrste podataka koji je potrebno preneti klijentu.
     */
    private Object odgovor;

    
        /**
     * Podrazumevani konstruktor koji inicijalizuje objekat {@code Odgovor}.
     * Ovaj konstruktor ne postavlja nikakve vrednosti za {@code odgovor}.
     */
    public Odgovor() {
    }

        /**
     * Parametarski konstruktor koji inicijalizuje objekat {@code Odgovor} sa datim odgovorom.
     *
     * @param odgovor Objekat koji predstavlja odgovor servera.
     */
    public Odgovor(Object odgovor) {
        this.odgovor = odgovor;
    }

        /**
     * Get metoda - Vraća odgovor servera.
     *
     * @return Objekat koji predstavlja odgovor servera.
     */
    public Object getOdgovor() {
        return odgovor;
    }

        /**
     * Set metoda - Postavlja odgovor servera.
     *
     * @param odgovor Objekat koji predstavlja odgovor servera.
     */
    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

        /**
     * Upoređuje objekat {@code Odgovor} sa drugim objekatom.
     *
     * @param obj Drugi objekat koji se upoređuje.
     * @return {@code true} ako su objekti identični, {@code false} inače.
     * Poređenje se vrši na osnovu vrednosti {@code odgovor}.
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
        final Odgovor other = (Odgovor) obj;
        return Objects.equals(this.odgovor, other.odgovor);
    }
    
    
    
}
