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
 * Klasa koja predstavlja entitet mesta u sistemu.
 * <p>
 * Ova klasa implementira interfejs {@link ApstraktniDomenskiObjekat} i pruža osnovne informacije o mestu,
 * kao što su identifikator, poštanski broj i naziv.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class Mesto implements ApstraktniDomenskiObjekat{
    private Long mestoID;
    private Long postanskiBroj;
    private String naziv;

        /**
     * Podrazumevani konstruktor koji inicijalizuje novi objekat {@code Mesto}.
     */
    public Mesto() {
    }

        /**
     * Parametarski konstruktor koji inicijalizuje objekat {@code Mesto}.
     *
     * @param mestoID Identifikator mesta.
     * @param postanskiBroj Poštanski broj mesta.
     * @param naziv Naziv mesta.
     */
    public Mesto(Long mestoID, Long postanskiBroj, String naziv) {
        this.mestoID = mestoID;
        this.postanskiBroj = postanskiBroj;
        this.naziv = naziv;
    }

        /**
     * Get metoda - Vraća identifikator mesta.
     *
     * @return Identifikator mesta.
     */
    public Long getMestoID() {
        return mestoID;
    }

        /**
     * Set metoda - Postavlja identifikator mesta.
     *
     * @param mestoID Identifikator mesta.
     */
    public void setMestoID(Long mestoID) {
        this.mestoID = mestoID;
    }

        /**
     * Get metoda - Vraća poštanski broj mesta.
     *
     * @return Poštanski broj mesta.
     */
    public Long getPostanskiBroj() {
        return postanskiBroj;
    }

        /**
     * Set metoda - Postavlja poštanski broj mesta.
     *
     * @param postanskiBroj Poštanski broj mesta.
     */
    public void setPostanskiBroj(Long postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }

        /**
     * Get metoda - Vraća naziv mesta.
     *
     * @return Naziv mesta.
     */
    public String getNaziv() {
        return naziv;
    }

        /**
     * Set metoda - Postavlja naziv mesta.
     *
     * @param naziv Naziv mesta.
     */
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

        /**
     * Upoređuje objekat {@code Mesto} sa drugim objektom.
     *
     * @param obj Drugi objekat koji se upoređuje.
     * @return {@code true} ako su objekti identični, {@code false} inače.
     * Poređenje se vrši po nazivu mesta, identifikatoru mesta i poštanskom broju.
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
        final Mesto other = (Mesto) obj;
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.mestoID, other.mestoID)) {
            return false;
        }
        return Objects.equals(this.postanskiBroj, other.postanskiBroj);
    }

    
        /**
     * Vraća string prezentaciju objekta {@code Mesto}.
     * <p>
     * U ovom slučaju, vraća naziv mesta.
     * </p>
     *
     * @return Naziv mesta.
     */
    @Override
    public String toString() {
        return naziv;
    }

        /**
     * {@inheritDoc}
     * Vraća naziv tabele u bazi podataka u kojoj se nalazi entitet {@code Mesto}.
     * 
     * @return Naziv tabele.
     */
    @Override
    public String vratiNazivTabele() {
        return "mesto";
    }

        /**
     * {@inheritDoc}
     * Vraća listu objekata {@link Mesto} iz rezultata upita.
     * 
     * @param rs {@code ResultSet} koji sadrži rezultate upita.
     * @return Lista objekata {@link ApstraktniDomenskiObjekat}.
     * @throws Exception Ako dođe do greške tokom obrade {@code ResultSet}-a.
     */
    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            Long id = (long) rs.getInt("mesto.mestoID");
            Long ptt = (long) rs.getInt("mesto.postanskiBroj");
            String n = rs.getString("mesto.naziv");
            Mesto m = new Mesto(id, ptt, n);
            lista.add(m);
        }
        return lista;
     }

        /**
     * {@inheritDoc}
     * Vraća imena kolona koje se koriste za ubacivanje podataka u bazu u tabelu {@code Mesto}.
     * 
     * @return Imena kolona.
     */
    @Override
    public String vratiKoloneZaUbacivanje() {
        return "postanskiBroj,naziv";
    }

        /**
     * {@inheritDoc}
     * Vraća vrednosti za ubacivanje u bazu u tabelu {@code Mesto}.
     * 
     * @return Vrednosti za umetanje.
     */
    @Override
    public String vratiVrednostiZaUbacivanje() {
        return""+postanskiBroj+",'"+naziv+"'";
    }

        /**
     * {@inheritDoc}
     * Vraća primarni ključ za identifikaciju mesta.
     * 
     * @return Primarni ključ.
     */
    @Override
    public String vratiPrimarniKljuc() {
        return "mesto.mestoID="+mestoID;
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
     * Vraća SQL izraz za ažuriranje podataka u bazi u tabelu {@code Mesto}.
     * 
     * @return SQL izraz za ažuriranje.
     */
    @Override
    public String vratiVrednostiZaIzmenu() {
        //"postanskiBroj,naziv";
        return "postanskiBroj="+postanskiBroj+", naziv='"+naziv+"'";
    }
    
    
}
