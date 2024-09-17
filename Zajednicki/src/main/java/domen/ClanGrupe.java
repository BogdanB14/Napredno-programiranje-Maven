/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.List;
import java.util.Objects;

/**
 * Predstavlja model člana u grupi u sistemu.
 * Ova klasa implementira interfejs {@link ApstraktniDomenskiObjekat} i obezbeđuje implementaciju svih
 * potrebnih metoda za rad sa članom grupe u sistemu.
 * 
 * @author Bogdan Blagojevic
 */
public class ClanGrupe implements ApstraktniDomenskiObjekat{
    /**
     * Redni broj clana.
     * Predstavlja jedinstveni redni broj clana unutar grupe.
     * Tip Integer
     */
    private int rbClana;
    /**
     * Grupa kojoj clan pripada.
     * TIp Grupa
     */
    private Grupa grupa;
    /**
     * Pozicija clana u grupi.
     * Predstavlja poziciji u rotaciji clana.
     * Tip String
     */
    private String pozicija;
    /**
     * Status clana.
     * Predstavlja trenutni status clana (AKTIVAN, NEAKTIVAN)
     * Tip String
     */
    private String status;
    /**
     * Objekat clan.
     * Predstavlja referencu na objekat {@link Clan} koji sadrži dodatne informacije o clanu.
     * Tip Clan
     */
    private Clan clan;

    
    /**
     * Default konstruktor - Kreira novu instancu {@link ClanGrupe} sa podrazumevanim vrednostima.
     */
    public ClanGrupe() {
    }

    
    /**
     * Parametarski konstruktor - Kreira novu instancu {@link ClanGrupe} sa zadatim vrednostima.
     * 
     * @param rbClana Redni broj člana u grupi
     * @param pozicija Pozicija člana u grupi
     * @param status Status člana u grupi
     * @param clan Član grupe
     * @param grupa Grupa kojoj član pripada
     */
    public ClanGrupe(int rbClana, String pozicija, String status, Clan clan, Grupa grupa) {
//        this.rbClana = rbClana;
//        this.pozicija = pozicija;
//        this.status = status;
//        this.clan = clan;
//        this.grupa = grupa;
          this.setRbClana(rbClana);
          this.setPozicija(pozicija);
          this.setStatus(status);
          this.setClan(clan);
          this.setGrupa(grupa);
    }

    /**
     * Get metoda - Vraća redni broj člana u grupi.
     * 
     * Redni broj predstavlja primarni kljuc u tabeli Clan u bazi.
     * 
     * @return Redni broj člana
     */
    public int getRbClana() {
        return rbClana;
    }
    
    

    /**
     * Set metoda - Postavlja redni broj člana u grupi.
     * 
     * @param rbClana Redni broj člana
     * @throws RuntimeException Ako je redni broj clana 0 ili manji od 0
     */
    public void setRbClana(int rbClana) {
        if(rbClana > 0)
        this.rbClana = rbClana;
        else throw new RuntimeException("Redni broj clana mora biti veci od 0");
    }

    /**
     * Get metoda - Vraća poziciju člana u grupi.
     * 
     * @return Pozicija člana
     */
    public String getPozicija() {
        return pozicija;
    }

    
    /**
     * Set metoda - Postavlja poziciju člana u grupi.
     * 
     * @param pozicija Pozicija člana
     */
    public void setPozicija(String pozicija) {
        if(pozicija != null && !pozicija.isEmpty() && !pozicija.isBlank())
        this.pozicija = pozicija;
        else throw new NullPointerException("Pozicija nije u dobrom formatu");
    }

    
    /**
     * Get metoda - Vraća status člana u grupi.
     * 
     * @return Status člana
     */
    public String getStatus() {
        return status;
    }

    
    /**
     * Set metoda - Postavlja status člana u grupi.
     * 
     * @param status Status člana
     */
    public void setStatus(String status) {
        if(status != null && !status.isEmpty() && !status.isBlank())
        this.status = status;
        else throw new NullPointerException("Status nije u dobrom formatu");
    }

    /**
     * Vraća člana koji pripada grupi.
     * 
     * @return Član grupe
     */
    public Clan getClan() {
        return clan;
    }

    /**
     * Postavlja člana koji pripada grupi.
     * 
     * @param clan Član grupe
     * @throws NullPointerException ako je clan null
     */
    public void setClan(Clan clan) {
        if(clan != null)
        this.clan = clan;
        else throw new NullPointerException("Clan ne sme biti null");
    }

    /**
     * Postavlja grupu u kojoj pripada clan.
     * 
     * @param grupa  
     * @throws NullPointerException ako je grupa null
     */
    public void setGrupa(Grupa grupa) {
        if(grupa != null)
        this.grupa = grupa;
        else throw new NullPointerException("Grupa ne sme biti null");
        
    }

    public Grupa getGrupa() {
        return grupa;
    }
    
    
    
    
    /**
     * Vraća string prezentaciju objekta {@code ClanGrupe}.
     * <p>
     * U ovom slučaju, vraća Redni broj clana, pozicija clana i status clana.
     * </p>
     *
     * @return Redni broj clana, pozicija clana i status clana.
     */
    @Override
    public String toString() {
        return "ClanGrupe{" + "rbClana=" + rbClana + ", pozicija=" + pozicija + ", status=" + status + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * Override-ovana equals metoda za klasu ClanGrupe. Proverava da li su 2 objekta klase ClanGrupa jednaka
     * 
     * @param obj
     * @return true ako se porede dva objekta s iste memorijske lokacije ili ako su jednaki po poziciji i statusu
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
        final ClanGrupe other = (ClanGrupe) obj;
        if (this.rbClana != other.rbClana) {
            return false;
        }
        if (!Objects.equals(this.pozicija, other.pozicija)) {
            return false;
        }
        return Objects.equals(this.status, other.status);
    }

    /**
     * {@inheritDoc}
     * Vraća naziv tabele u bazi podataka.
     * 
     * @return Naziv tabele
     */
    @Override
    public String vratiNazivTabele() {
        return "clangrupe";
    }

    /**
     * {@inheritDoc}
     * Vraća listu objekata {@link ClanGrupe} iz rezultata upita.
     * 
     * @param rs {@code ResultSet} koji sadrži rezultate upita
     * @return Lista objekata {@link ApstraktniDomenskiObjekat}
     * @throws Exception Ako dođe do greške tokom obrade {@code ResultSet}-a
     */
    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * {@inheritDoc}
     * Vraća imena kolona koje se koriste za ubacivanje podataka u bazu u tabelu ClanGrupe.
     * 
     * @return Imena kolona
     */
    @Override
    public String vratiKoloneZaUbacivanje() {
        return "grupa,pozicija,status,clan";
    }

    /**
     * {@inheritDoc}
     * Vraća vrednosti za ubacivanje u bazu u tabelu ClanGrupe.
     * 
     * @return Vrednosti za ubacivanje u tabelu
     */
    @Override
    public String vratiVrednostiZaUbacivanje() {
        return ""+grupa.getGrupaID()+",'"+pozicija+"','"+status+"',"+clan.getJmbg();
    }

    /**
     * {@inheritDoc}
     * Vraća primarni ključ za identifikaciju člana u grupi.
     * Redni broj clana i ID grupe u kojoj se nalazi
     * @return Primarni ključ
     */
    @Override
    public String vratiPrimarniKljuc() {
        return "clangrupe.rbClana="+rbClana + " AND clangrupe.grupa="+grupa.getGrupaID();
    }

    /**
     * {@inheritDoc}
     * Ova metoda trenutno nije podržana.
     * 
     * @param rs {@code ResultSet} koji sadrži podatke za kreiranje objekta
     * @return Instanca objekta klase {@link ApstraktniDomenskiObjekat}
     * @throws Exception Ako dođe do greške tokom obrade {@code ResultSet}-a
     */
    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * {@inheritDoc}
     * Vraća SQL izraz za ažuriranje podataka u bazi.
     * 
     * @return SQL izraz za ažuriranje
     */
    @Override
    public String vratiVrednostiZaIzmenu() {
        //"grupa,pozicija,status,clan";
        return "grupa="+grupa.getGrupaID()+", pozicija='"+pozicija+"', status='"+status+"', clan="+clan.getJmbg();
    }
    
    
}
