/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Klasa koja predstavlja entitet trenera u sistemu.
 * <p>
 * Ova klasa implementira interfejs {@link ApstraktniDomenskiObjekat} i pruža osnovne informacije o treneru,
 * uključujući njegov identifikator, ime, prezime i mesto prebivališta.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class Trener implements ApstraktniDomenskiObjekat{
    private Long trenerID;
    private String imeTrener;
    private String prezimeTrener;
    private Mesto mesto;

        /**
     * Podrazumevani konstruktor koji inicijalizuje novi objekat {@code Trener}.
     */
    public Trener() {
    }

        /**
     * Parametarski konstruktor koji inicijalizuje objekat {@code Trener}.
     *
     * @param trenerID Identifikator trenera.
     * @param imeTrener Ime trenera.
     * @param prezimeTrener Prezime trenera.
     * @param mesto Mesto prebivališta trenera.
     */
    public Trener(Long trenerID, String imeTrener, String prezimeTrener, Mesto mesto) {
        this.trenerID = trenerID;
        this.imeTrener = imeTrener;
        this.prezimeTrener = prezimeTrener;
        this.mesto = mesto;
    }

        /**
     * Get metoda - Vraća identifikator trenera.
     *
     * @return Identifikator trenera.
     */
    public Long getTrenerID() {
        return trenerID;
    }

        /**
     * Set metoda - Postavlja identifikator trenera.
     *
     * @param trenerID Identifikator trenera.
     */
    public void setTrenerID(Long trenerID) {
        this.trenerID = trenerID;
    }

        /**
     * Get metoda - Vraća ime trenera.
     *
     * @return Ime trenera.
     */
    public String getImeTrener() {
        return imeTrener;
    }

        /**
     * Set metoda - Postavlja ime trenera.
     *
     * @param imeTrener Ime trenera.
     */
    public void setImeTrener(String imeTrener) {
        this.imeTrener = imeTrener;
    }

        /**
     * Get metoda - Vraća prezime trenera.
     *
     * @return Prezime trenera.
     */
    public String getPrezimeTrener() {
        return prezimeTrener;
    }

        /**
     * Set metoda - Postavlja prezime trenera.
     *
     * @param prezimeTrener Prezime trenera.
     */
    public void setPrezimeTrener(String prezimeTrener) {
        this.prezimeTrener = prezimeTrener;
    }

        /**
     * Get metoda - Vraća mesto prebivališta trenera.
     *
     * @return Mesto prebivališta trenera.
     */
    public Mesto getMesto() {
        return mesto;
    }

        /**
     * Set metoda - Postavlja mesto prebivališta trenera.
     *
     * @param mesto Mesto prebivališta trenera.
     */
    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    
        /**
     * Vraća string prezentaciju objekta {@code Trener}.
     * <p>
     * U ovom slučaju, vraća ime i prezime trenera.
     * </p>
     *
     * @return Ime i prezime trenera.
     */
    @Override
    public String toString() {
        return imeTrener + " " + prezimeTrener;
    }

    @Override
    public int hashCode() {
        return Objects.hash(trenerID, imeTrener, prezimeTrener, mesto);
    }
        /**
     * Upoređuje objekat {@code Trener} sa drugim objektom.
     *
     * @param obj Drugi objekat koji se upoređuje.
     * @return {@code true} ako su objekti identični, {@code false} inače.
     * Poređenje se vrši po imenu, prezimenu i identifikatoru trenera.
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
        final Trener other = (Trener) obj;
        if (!Objects.equals(this.imeTrener, other.imeTrener)) {
            return false;
        }
        if (!Objects.equals(this.prezimeTrener, other.prezimeTrener)) {
            return false;
        }
        return Objects.equals(this.trenerID, other.trenerID);
    }


    /**
     * {@inheritDoc}
     * Vraća naziv tabele u bazi podataka u kojoj se nalazi entitet {@code Trener}.
     * 
     * @return Naziv tabele.
     */
    @Override
    public String vratiNazivTabele() {
        return "trener";
    }

        /**
     * {@inheritDoc}
     * Vraća listu objekata {@link Trener} iz rezultata upita.
     * 
     * @param rs {@code ResultSet} koji sadrži rezultate upita.
     * @return Lista objekata {@link ApstraktniDomenskiObjekat}.
     * @throws Exception Ako dođe do greške tokom obrade {@code ResultSet}-a.
     */
    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {

        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            Long id = (long) rs.getInt("trener.trenerID");
            String ime = rs.getString("trener.imeTrener");
            String prezime =rs.getString("trener.prezimeTrener");
            Long mestoID = (long) rs.getInt("mesto.mestoID");
            Long ptt = (long) rs.getInt("mesto.postanskiBroj");
            String naziv = rs.getString("mesto.naziv");
            Mesto m = new Mesto(mestoID, ptt, naziv);
            
            Trener t = new Trener(id, ime, prezime, m);
            lista.add(t);
        }
        return lista;
    }

        /**
     * {@inheritDoc}
     * Vraća imena kolona koje se koriste za ubacivanje podataka u bazu u tabelu {@code Trener}.
     * 
     * @return Imena kolona.
     */
    @Override
    public String vratiKoloneZaUbacivanje() {
        return "imeTrener,prezimeTrener,mesto";
    }

        /**
     * {@inheritDoc}
     * Vraća vrednosti za ubacivanje u bazu u tabelu {@code Trener}.
     * 
     * @return Vrednosti za ubacivanje.
     */
    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+imeTrener+"','"+prezimeTrener+"',"+mesto.getMestoID();
    }

        /**
     * {@inheritDoc}
     * Vraća primarni ključ za identifikaciju trenera.
     * 
     * @return Primarni ključ.
     */
    @Override
    public String vratiPrimarniKljuc() {
        return "trener.trenerID="+trenerID;
    }

        /**
     * {@inheritDoc}
     * Ova metoda trenutno nije podržana.
     * 
     * @param rs {@code ResultSet} koji sadrži podatke za kreiranje objekta.
     * @return Instanca objekta klase {@link ApstraktniDomenskiObjekat}.
     * @throws Exception Ako dođe do greške tokom obrade {@code ResultSet}-a.
     */
    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

        /**
     * {@inheritDoc}
     * Vraća SQL izraz za ažuriranje podataka u bazi u tabelu {@code Trener}.
     * 
     * @return SQL izraz za ažuriranje.
     */
    @Override
    public String vratiVrednostiZaIzmenu() {
        //"imeTrener,prezimeTrener,mesto";
        return "imeTrener='"+imeTrener+"', prezimeTrener='"+prezimeTrener+"', mesto="+mesto.getMestoID();
    }
    
    
}
