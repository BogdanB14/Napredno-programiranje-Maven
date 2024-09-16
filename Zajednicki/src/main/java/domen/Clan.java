/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Objects;


/**
 * Klasa koja predstavlja člana u sistemu.
 * Ova klasa implementira {@link ApstraktniDomenskiObjekat} i pruža 
 * metode za rad sa članovima u bazi podataka.
 * 
 * @author Bogdan Blagojevic
 */
public class Clan implements ApstraktniDomenskiObjekat{
    /**
     * JMBG (Jedinstveni Maticni Broj Gradjana) clana.
     * Predstavlja jedinstveni identifikator clana u sistemu.
     * Tip String
     */
    private String jmbg;
    
    /**
     * Ime clana.
     * Predstavlja ime clana.
     * Tip String
     */
    private String imeClana;
    /**
     * Prezime clana.
     * Predstavlja prezime clana.
     * Tip String
     */
    private String prezimeClana;
    /**
     * Datum rođenja clana.
     * Predstavlja datum kada je clan rođen.
     * Tip Date
     */
    private Date datumRodjenja;
    /**
     * Pol clana.
     * Predstavlja pol clana (muski, zenski).
     * Tip Pol
     */
    private Pol pol;
    /**
     * Telefon clana.
     * Predstavlja kontakt telefon clana.
     * Tip String
     */
    private String telefon;
    
    /**
     * Mesto prebivalista clana.
     * Predstavlja mesto u kojem clan zivi.
     * Tip Mesto
     */
    private Mesto mesto;
    
  /**
   * Podrazumevani (default) konstruktor.
   */
    public Clan() {
    }

    /**
     * Konstruktor sa svim atributima.
     * 
     * @param jmbg JMBG člana.
     * @param imeClana Ime člana.
     * @param prezimeClana Prezime člana.
     * @param datumRodjenja Datum rođenja člana.
     * @param pol Pol člana.
     * @param telefon Telefon člana.
     * @param mesto Mesto prebivališta člana.
     */
    public Clan(String jmbg, String imeClana, String prezimeClana, Date datumRodjenja, Pol pol, String telefon, Mesto mesto) {
        this.jmbg = jmbg;
        this.imeClana = imeClana;
        this.prezimeClana = prezimeClana;
        this.datumRodjenja = datumRodjenja;
        this.pol = pol;
        this.telefon = telefon;
        this.mesto = mesto;
    }

    
    /**
     * Get metoda - Vraća JMBG člana.
     * 
     * @return JMBG člana.
     */
    public String getJmbg() {
        return jmbg;
    }

    
    /**
     * Set metoda - Postavlja JMBG člana.
     * 
     * @param jmbg JMBG člana.
     * @throws NullPointerException Ako je JMBG clana null ili nije duzine od 13 karaktera
     */
    public void setJmbg(String jmbg) {
        if(jmbg != null && jmbg.length() == 13)
        this.jmbg = jmbg;
        else throw new NullPointerException("JMBG nije u dobrom formatu");
    }

    
    /**
     * Get metoda - Vraća ime člana.
     * 
     * @return Ime člana.
     */
    public String getImeClana() {
        return imeClana;
    }

    /**
     * Set metoda - Postavlja ime člana.
     * 
     * @param imeClana Ime člana.
     * @throws NullPointerException Ako je ime clana null
     */
    public void setImeClana(String imeClana) {
        if(imeClana != null)
        this.imeClana = imeClana;
        else throw new NullPointerException("Clan nije u dobrom formatu");
    }

    /**
     * Get metoda - Vraća prezime člana.
     * 
     * @return Prezime člana.
     */
    public String getPrezimeClana() {
        return prezimeClana;
    }


    /**
     * Set metoda - Postavlja prezime člana.
     * 
     * @param prezimeClana Prezime člana.
     * @throws NullPointerException Ako je prezime clana null, prazno ili se sastoji samo od razmaka
     */
    public void setPrezimeClana(String prezimeClana) {
        if(prezimeClana != null && !prezimeClana.isEmpty() && !prezimeClana.isBlank())
        this.prezimeClana = prezimeClana;
        else throw new NullPointerException("Prezime nije u dobrom formatu");
    }

    /**
     * Get metoda - Vraća datum rođenja člana.
     * 
     * @return Datum rođenja člana.
     */
    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    /**
     * Set metoda - Postavlja datum rođenja člana.
     * 
     * @param datumRodjenja Datum rođenja člana.
     * @throws NullPointerException Ako je datum rodjenja clana null ili datum iz buducnosti.
     */
    public void setDatumRodjenja(Date datumRodjenja) {
        if(datumRodjenja != null && datumRodjenja.before(new Date()))
        this.datumRodjenja = datumRodjenja;
        else throw new NullPointerException("Datum nije u dobrom forrmatu");
    }

    
    /**
     * Get metoda - Vraća pol člana.Pol je enum
     * 
     * @return Pol člana.
     */
    public Pol getPol() {
        return pol;
    }

    /**
     * Set metoda - Postavlja pol člana.
     * 
     * @param pol Pol člana.
     */
    public void setPol(Pol pol) {
        this.pol = pol;
    }

    /**
     * Get metoda - Vraća telefon člana.
     * 
     * @return Telefon člana.
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * Set metoda - Postavlja telefon člana.
     * 
     * @param telefon Telefon člana.
     * @throws NullPointerException Ako je telefon clana null
     */
    public void setTelefon(String telefon) {
        if(telefon != null)
        this.telefon = telefon;
        else throw new NullPointerException("Telefon ne sme biti null");
    }

    /**
     * Get metoda - Vraća mesto rodjenja člana (Grad)
     * 
     * @return Mesto (grad) člana.
     */
    public Mesto getMesto() {
        return mesto;
    }
    
    
    /**
     * Set metoda - Postavlja mesto rodjenja člana (Grad)
     * 
     * @param mesto Mesto (grad) člana.
     * @throws NullPointerException Ako je mesto null
     */
    public void setMesto(Mesto mesto) {
        if(mesto != null)
        this.mesto = mesto;
        else throw new NullPointerException("Mesto ne sme biti null");
    }

    /**
     * Vraća string prezentaciju objekta {@code Clan}.
     * <p>
     * U ovom slučaju, vraća izgled celog objekta.
     * </p>
     *
     * @return sve atribute.
     */
    @Override
    public String toString() {
        return "Clan{" + "jmbg=" + jmbg + ", imeClana=" + imeClana + ", prezimeClana=" + prezimeClana + ", datumRodjenja=" + datumRodjenja + ", pol=" + pol + ", telefon=" + telefon + ", mesto=" + mesto + '}';
    }
    
    


    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    /**
     * Override-ovana equals metoda za klasu Clan. Proverava da li su 2 objekta klase clan jednaka
     * 
     * @param obj
     * @return true ako se porede dva objekta s iste memorijske lokacije ili ako su jednaki po jmbg-u
     * u suprotnom uvek vraca false
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
        final Clan other = (Clan) obj;
        return Objects.equals(this.jmbg, other.jmbg);
    }

    /**
     * {@inheritDoc}
     * Vraća naziv tabele u bazi podataka za klasu Clan.
     * 
     * @return naziv tabele
     */
    @Override
    public String vratiNazivTabele() {
        return "clan";
    }

    /**
     * {@inheritDoc}
     * Vraća listu objekata {@link Clan} iz rezultata upita.
     * 
     * @param rs {@code ResultSet} koji sadrži rezultate upita
     * @return lista objekata {@link ApstraktniDomenskiObjekat}
     * @throws Exception Ako dođe do greške tokom obrade {@code ResultSet}-a
     */
    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            String j =  rs.getString("clan.jmbg");
            String ime = rs.getString("clan.imeClana");
            String prezime = rs.getString("clan.prezimeClana");
            java.util.Date dr = new java.util.Date(rs.getDate("clan.datumRodjenja").getTime());
            Pol p = Pol.valueOf(rs.getString("clan.pol"));
            String t = rs.getString("clan.telefon");
            Long idMesto = (long) rs.getInt("mesto.mestoID");
            String naziv = rs.getString("mesto.naziv");
            Long postanskiBroj = (long) rs.getInt("mesto.postanskiBroj");
            Mesto m = new Mesto(idMesto, postanskiBroj, naziv);
            Clan clan = new Clan(j, ime, prezime, dr, p, t, m);
            lista.add(clan);
        }
        return lista;
    }

    /**
     * {@inheritDoc}
     * Vraća imena kolona koje se koriste za ubacivanje podataka u bazu u tabelu Clan.
     * 
     * @return imena kolona
     */
    @Override
    public String vratiKoloneZaUbacivanje() {
        return "jmbg,imeClana,prezimeClana,datumRodjenja,pol,telefon,mesto";
    }

    /**
     * {@inheritDoc}
     * Vraća vrednosti za ubacivanje u bazu u tabelu Clan
     * 
     * @return vrednosti za ubacivanje
     */
    @Override
    public String vratiVrednostiZaUbacivanje() {
        java.sql.Date datum = new java.sql.Date(datumRodjenja.getTime());
        return "'"+jmbg+"','"+imeClana+"','"+prezimeClana+"','"+datum+"','"+pol+"','"+telefon+"',"+mesto.getMestoID();
    }

    /**
     * {@inheritDoc}
     * Vraća primarni ključ za identifikaciju člana.
     * 
     * @return primarni ključ
     */
    @Override
    public String vratiPrimarniKljuc() {
        return "clan.jmbg='"+jmbg+"'";
    }

    /**
     * {@inheritDoc}
     * Ova metoda trenutno nije podržana.
     * 
     * @param rs {@code ResultSet} koji sadrži podatke za kreiranje objekta
     * @return instanca objekta klase {@link ApstraktniDomenskiObjekat}
     * @throws Exception Ako dođe do greške tokom obrade {@code ResultSet}-a
     */
    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    /**
     * {@inheritDoc}
     * Vraća SQL izraz za ažuriranje podataka u bazi za klasu Clan.
     * 
     * @return SQL izraz za ažuriranje
     */
    @Override
    public String vratiVrednostiZaIzmenu() {
        //"jmbg,imeClana,prezimeClana,datumRodjenja,pol,telefon,mesto";
        java.sql.Date datum = new java.sql.Date(datumRodjenja.getTime());
        return "clan.jmbg='"+jmbg+"', clan.imeClana='"+imeClana+"', clan.prezimeClana='"+prezimeClana+"', clan.datumRodjenja='"+datum+"', clan.pol='"+pol+"', clan.telefon='"+telefon+"', clan.mesto="+mesto.getMestoID() + " WHERE " + vratiPrimarniKljuc();
    }
    
    
}
