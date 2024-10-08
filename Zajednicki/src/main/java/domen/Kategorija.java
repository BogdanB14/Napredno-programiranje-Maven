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
 * Klasa koja predstavlja entitet kategorije u sistemu.
 * <p>
 * Ova klasa implementira interfejs {@link ApstraktniDomenskiObjekat} i pruža osnovne informacije o kategoriji,
 * kao što su identifikator, naziv, opis i pol.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class Kategorija implements ApstraktniDomenskiObjekat{
    /**
     * Identifikator kategorije.
     * Predstavlja jedinstveni identifikator za kategoriju.
     * Tip Long
     */
    private Long kategorijaID;
    /**
     * Naziv kategorije.
     * Predstavlja naziv kategorije.
     * Tip String
     */
    private String nazivKategorije;
    /**
     * Opis kategorije.
     * Predstavlja dodatne informacije ili objašnjenje o kategoriji.
     * Tip String
     */
    private String opisKategorije;
    /**
     * Pol koji se odnosi na ovu kategoriju.
     * Predstavlja pol kategorije (MUSKI, ZENSKI)
     * Tip Pol
     */
    private Pol pol;

    /**
     * Podrazumevani konstruktor koji inicijalizuje novi objekat {@code Kategorija}.
     */
    public Kategorija() {
    }

    /**
     * Parametarski konstruktor koji inicijalizuje objekat {@code Kategorija} 
     *
     * @param kategorijaID Identifikator kategorije.
     * @param nazivKategorije Naziv kategorije.
     * @param opisKategorije Opis kategorije.
     * @param pol Pol koji se odnosi na ovu kategoriju.
     */
    public Kategorija(Long kategorijaID, String nazivKategorije, String opisKategorije, Pol pol) {
//        this.kategorijaID = kategorijaID;
//        this.nazivKategorije = nazivKategorije;
//        this.opisKategorije = opisKategorije;
//        this.pol = pol;
          this.setKategorijaID(kategorijaID);
          this.setNazivKategorije(nazivKategorije);
          this.setOpisKategorije(opisKategorije);
          this.setPol(pol);
    }

    /**
     * Get metoda - Vraća identifikator kategorije.
     *
     * @return Identifikator kategorije.
     */
    public Long getKategorijaID() {
        return kategorijaID;
    }

    /**
     * Set metoda - Postavlja identifikator kategorije.
     *
     * @param kategorijaID Identifikator kategorije.
     * @throws RuntimeException ako je id kategorije 0 ili manji od 0
     */
    public void setKategorijaID(Long kategorijaID) {
        if(kategorijaID > 0)
        this.kategorijaID = kategorijaID;
        else throw new RuntimeException("ID kategorije mora biti veci od 0");
    }

    /**
     * Get metoda - Vraća naziv kategorije.
     *
     * @return Naziv kategorije.
     */
    public String getNazivKategorije() {
        return nazivKategorije;
    }

    /**
     * Set metoda - Postavlja naziv kategorije.
     *
     * @param nazivKategorije Naziv kategorije.
     * @throws NullPointerException ako je naziv null, prazan, ili string koji se sastoji samo od razmaka
     */
    public void setNazivKategorije(String nazivKategorije) {
        if(nazivKategorije != null && !nazivKategorije.isEmpty() && !nazivKategorije.isBlank())
        this.nazivKategorije = nazivKategorije;
        else throw new NullPointerException("Naziv nije u odgovarajucem formatu");
    }

    /**
     * Get metoda - Vraća opis kategorije.
     *
     * @return Opis kategorije.
     */
    public String getOpisKategorije() {
        return opisKategorije;
    }

    /**
     * Set metoda - Postavlja opis kategorije.
     *
     * @param opisKategorije Opis kategorije.
     * @throws NullPointerException ako je opis null, prazan, ili string koji se sastoji samo od razmaka
     */
    public void setOpisKategorije(String opisKategorije) {
        if(opisKategorije != null && !opisKategorije.isEmpty() && !opisKategorije.isBlank())
        this.opisKategorije = opisKategorije;
        else throw new NullPointerException("Opis kategorije nije u odgovarajucem formatu");
    }

    /**
     * Get metoda - Vraća pol koji se odnosi na ovu kategoriju. Pol predstavlja enumeraciju.
     *
     * @return Pol koji se odnosi na ovu kategoriju.
     */
    public Pol getPol() {
        return pol;
    }

    /**
     * Set metoda - Postavlja pol koji se odnosi na ovu kategoriju.
     *
     * @param pol Pol koji se odnosi na ovu kategoriju.
     */
    public void setPol(Pol pol) {
        this.pol = pol;
    }

    /**
     * Vraća string prezentaciju objekta {@code Kategorija}.
     * <p>
     * U ovom slučaju, vraća naziv kategorije.
     * </p>
     *
     * @return Naziv kategorije.
     */
    @Override
    public String toString() {
        return nazivKategorije;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

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
        final Kategorija other = (Kategorija) obj;
        return Objects.equals(this.kategorijaID, other.kategorijaID);
    }


    

    /**
     * {@inheritDoc}
     * Vraća naziv tabele u bazi podataka u kojoj se nalazi entitet {@code Kategorija}.
     * 
     * @return Naziv tabele.
     */
    @Override
    public String vratiNazivTabele() {
        return "kategorija";
    }

    /**
     * {@inheritDoc}
     * Vraća listu objekata {@link Kategorija} iz rezultata upita.
     * 
     * @param rs {@code ResultSet} koji sadrži rezultate upita.
     * @return Lista objekata {@link ApstraktniDomenskiObjekat}.
     * @throws Exception Ako dođe do greške tokom obrade {@code ResultSet}-a.
     */

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            Long id = (long) rs.getInt("kategorija.kategorijaID");
            String naziv = rs.getString("kategorija.nazivKategorije");
            String opis = rs.getString("kategorija.opisKategorije");
            Pol p = Pol.valueOf(rs.getString("kategorija.pol"));
            Kategorija k = new Kategorija(id, naziv, opis, p);
            lista.add(k);
        }
        return lista;
    }

    /**
     * {@inheritDoc}
     * Vraća imena kolona koje se koriste za ubacivanje podataka u bazu u tabelu {@code Kategorija}.
     * 
     * @return Imena kolona.
     */
    @Override
    public String vratiKoloneZaUbacivanje() {
        return "nazivKategorije,opisKategorije,pol";
    }

    /**
     * {@inheritDoc}
     * Vraća vrednosti za ubacivanje u bazu u tabelu {@code Kategorija}.
     * 
     * @return Vrednosti za ubacivanje.
     */
    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+nazivKategorije+"','"+opisKategorije+"','"+pol+"'";
    }

    /**
     * {@inheritDoc}
     * Vraća primarni ključ za identifikaciju kategorije.
     * 
     * @return Primarni ključ.
     */
    @Override
    public String vratiPrimarniKljuc() {
        return "kategorija.kategorijaID="+kategorijaID;
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
     * Vraća SQL izraz za ažuriranje podataka u bazi u tabelu {@code Kategorija}.
     * 
     * @return SQL izraz za ažuriranje.
     */
    @Override
    public String vratiVrednostiZaIzmenu() {
        //"nazivKategorije,opisKategorije,pol";
        return "nazivKategorije='"+nazivKategorije+"', opisKategorije='"+opisKategorije+"', pol='"+pol+"'";
    }
    
    
}
