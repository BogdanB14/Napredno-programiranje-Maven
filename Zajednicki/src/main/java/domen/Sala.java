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
 * Klasa koja predstavlja entitet sale u sistemu.
 * <p>
 * Ova klasa implementira interfejs {@link ApstraktniDomenskiObjekat} i pruža osnovne informacije o sali,
 * kao što su identifikator, naziv sale, kapacitet i mesto u kojem se sala nalazi.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class Sala implements ApstraktniDomenskiObjekat{
    private Long salaID;
    private String nazivSale;
    private int kapacitet;
    private Mesto mesto;
    
       /**
     * Podrazumevani konstruktor koji inicijalizuje novi objekat {@code Sala}.
     */
    public Sala() {
    }

        /**
     * Parametarski konstruktor koji inicijalizuje objekat {@code Sala}.
     *
     * @param salaID Identifikator sale.
     * @param nazivSale Naziv sale.
     * @param kapacitet Kapacitet sale.
     * @param mesto Mesto u kojem se sala nalazi.
     */
    public Sala(Long salaID, String nazivSale, int kapacitet, Mesto mesto) {
        this.salaID = salaID;
        this.nazivSale = nazivSale;
        this.kapacitet = kapacitet;
        this.mesto = mesto;
    }

        /**
     * Get metoda - Vraća identifikator sale.
     *
     * @return Identifikator sale.
     */
    public Long getSalaID() {
        return salaID;
    }

        /**
     * Set metoda - Postavlja identifikator sale.
     *
     * @param salaID Identifikator sale.
     */
    public void setSalaID(Long salaID) {
        this.salaID = salaID;
    }

        /**
     * Get metoda - Vraća naziv sale.
     *
     * @return Naziv sale.
     */
    public String getNazivSale() {
        return nazivSale;
    }

        /**
     * Set metoda - Postavlja naziv sale.
     *
     * @param nazivSale Naziv sale.
     */
    public void setNazivSale(String nazivSale) {
        this.nazivSale = nazivSale;
    }

        /**
     * Get metoda - Vraća kapacitet sale.
     *
     * @return Kapacitet sale.
     */
    public int getKapacitet() {
        return kapacitet;
    }

        /**
     * Set metoda - Postavlja kapacitet sale.
     *
     * @param kapacitet Kapacitet sale.
     */
    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

        /**
     * Get metoda - Vraća mesto u kojem se sala nalazi.
     *
     * @return Mesto u kojem se sala nalazi.
     */
    public Mesto getMesto() {
        return mesto;
    }

        /**
     * Set metoda - Postavlja mesto u kojem se sala nalazi.
     *
     * @param mesto Mesto u kojem se sala nalazi.
     */
    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }
    
        /**
     * Vraća string prezentaciju objekta {@code Sala}.
     * <p>
     * U ovom slučaju, vraća naziv sale.
     * </p>
     *
     * @return Naziv sale.
     */
    @Override
    public String toString() {
        return nazivSale;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

        /**
     * Upoređuje objekat {@code Sala} sa drugim objektom.
     *
     * @param obj Drugi objekat koji se upoređuje.
     * @return {@code true} ako su objekti identični, {@code false} inače.
     * Poređenje se vrši po nazivu sale i identifikatoru sale.
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
        final Sala other = (Sala) obj;
        if (!Objects.equals(this.nazivSale, other.nazivSale)) {
            return false;
        }
        return Objects.equals(this.salaID, other.salaID);
    }

        /**
     * {@inheritDoc}
     * Vraća naziv tabele u bazi podataka u kojoj se nalazi entitet {@code Sala}.
     * 
     * @return Naziv tabele.
     */
    @Override
    public String vratiNazivTabele() {
        return "sala";
    }

        /**
     * {@inheritDoc}
     * Vraća listu objekata {@link Sala} iz rezultata upita.
     * 
     * @param rs {@code ResultSet} koji sadrži rezultate upita.
     * @return Lista objekata {@link ApstraktniDomenskiObjekat}.
     * @throws Exception Ako dođe do greške tokom obrade {@code ResultSet}-a.
     */
    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {

        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        
        while(rs.next()){
            Long id = (long) rs.getInt("sala.salaID");
            String nazivS = rs.getString("sala.nazivSale");
            int kap = rs.getInt("sala.kapacitet");
            Long mestoID = (long) rs.getInt("mesto.mestoID");
            Long ptt = (long) rs.getInt("mesto.postanskiBroj");
            String nazivmesta = rs.getString("mesto.naziv");
            Mesto m = new Mesto(mestoID, ptt, nazivmesta);
            Sala s = new Sala(id, nazivS, kap, m);
            
            lista.add(s);
            
        }
        
        return lista;
    }

        /**
     * {@inheritDoc}
     * Vraća imena kolona koje se koriste za ubacivanje podataka u bazu u tabelu {@code Sala}.
     * 
     * @return Imena kolona.
     */
    @Override
    public String vratiKoloneZaUbacivanje() {
        return "nazivSale,kapacitet,mesto";
    }
    

        /**
     * {@inheritDoc}
     * Vraća vrednosti za ubacivanje u bazu u tabelu {@code Sala}.
     * 
     * @return Vrednosti za umetanje.
     */
    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+nazivSale+"',"+kapacitet+","+mesto.getMestoID();
    }

        /**
     * {@inheritDoc}
     * Vraća primarni ključ za identifikaciju sale.
     * 
     * @return Primarni ključ.
     */
    @Override
    public String vratiPrimarniKljuc() {
        return "sala.salaID="+salaID;
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
     * Vraća SQL izraz za ažuriranje podataka u bazi u tabelu {@code Sala}.
     * 
     * @return SQL izraz za ažuriranje.
     */
    @Override
    public String vratiVrednostiZaIzmenu() {
       //"nazivSale,kapacitet,mesto";
       return "nazivSale='"+nazivSale+"', kapacitet="+kapacitet+", mesto="+mesto.getMestoID();
    }
    
    
}
