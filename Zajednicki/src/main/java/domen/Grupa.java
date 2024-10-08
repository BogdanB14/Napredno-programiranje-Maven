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
 * Predstavlja grupu u sistemu.
 * Ova klasa implementira {@link ApstraktniDomenskiObjekat} interfejs
 * i pruža metode za interakciju sa tabelom "grupa" u bazi podataka.
 * 
 * @author Bogdan Blagojevic
 */
public class Grupa implements ApstraktniDomenskiObjekat{
    /**
     * Identifikator grupe.
     * Predstavlja jedinstveni identifikator za grupu.
     * Tip Long
     */
    private Long grupaID;
    /**
     * Naziv grupe.
     * Predstavlja naziv grupe.
     * Tip String
     */
    private String nazivGrupe;
    /**
     * Broj clanova u grupi.
     * Predstavlja ukupni broj članova koji su deo grupe.
     * Tip Integer
     */
    private int brClanova;
    /**
     * Kategorija kojoj grupa pripada.
     * Predstavlja kategoriju koja se dodeljuje grupi.
     * Tip Integer
     */
    private Kategorija kategorija;
    /**
     * Administrator koji upravlja grupom.
     * Predstavlja administratora koji je dodao grupu.
     * Tip Administrator
     */
    private Administrator administrator;
    /**
     * Trener koji vodi grupu.
     * Predstavlja trenera grupe.
     * Tip Trener
     */
    private Trener trener;

    
    /**
     * Podrazumevani konstruktor.
     */
    public Grupa() {
    }

    /**
     * Parametarski konstruktor
     *
     * @param grupaID ID grupe
     * @param nazivGrupe naziv grupe
     * @param brClanova maksimalan broj članova u grupi
     * @param kategorija kategorija grupe
     * @param administrator administrator grupe
     * @param trener trener grupe
     */
    public Grupa(Long grupaID, String nazivGrupe, int brClanova, Kategorija kategorija, Administrator administrator, Trener trener) {
//        this.grupaID = grupaID;
//        this.nazivGrupe = nazivGrupe;
//        this.brClanova = brClanova;
//        this.kategorija = kategorija;
//        this.administrator = administrator;
//        this.trener = trener;
          this.setGrupaID(grupaID);
          this.setNazivGrupe(nazivGrupe);
          this.setBrClanova(brClanova);
          this.setKategorija(kategorija);
          this.setAdministrator(administrator);
          this.setTrener(trener);
    }

    /**
     * Get metoda - Vraća ID grupe.
     *
     * @return ID grupe
     */
    public Long getGrupaID() {
        return grupaID;
    }

    /**
     * Set metoda - Postavlja ID grupe.
     *
     * @param grupaID ID grupe
     * @throws RuntimeException ako je id grupe 0 ili manji od 0
     */
    public void setGrupaID(Long grupaID) {
        if(grupaID > 0)
        this.grupaID = grupaID;
        else throw new RuntimeException("ID grupe mora biti vece od 0");
    }

    /**
     * Get metoda - Vraća naziv grupe.
     *
     * @return naziv grupe
     */
    public String getNazivGrupe() {
        return nazivGrupe;
    }

    /**
     * Set metoda - Postavlja naziv grupe.
     *
     * @param nazivGrupe naziv grupe
     * @throws NullPointerException ako je naziv grupe null, prazan string ili se sastoji samo od razmaka.
     */
    public void setNazivGrupe(String nazivGrupe) {
        if(nazivGrupe != null && !nazivGrupe.isBlank() && !nazivGrupe.isEmpty())
        this.nazivGrupe = nazivGrupe;
        else throw new NullPointerException("Naziv grupe nije u dobrom formatu");
    }

    /**
     * Get metoda - Vraća maksimalan broj članova u grupi.
     *
     * @return broj članova
     */
    public int getBrClanova() {
        return brClanova;
    }

    /**
     * Set metoda - Postavlja maksimalan broj članova u grupi.
     *
     * @param brClanova maksimalan broj članova u grupi
     * @throws RuntimeException ako je broj clanova 0 ili manji od 0
     */
    public void setBrClanova(int brClanova) {
        if(brClanova > 0)
        this.brClanova = brClanova;
        else throw new RuntimeException("Broj clanova mora biti veci od 0");
    }
    

    /**
     * Get metoda - Vraća kategoriju grupe.
     *
     * @return kategorija grupe
     */
    public Kategorija getKategorija() {
        return kategorija;
    }

    /**
     * Set metoda - Postavlja kategoriju grupe.
     *
     * @param kategorija kategorija grupe
     * @throws NullPointerException ako je kategorija null
     */
    public void setKategorija(Kategorija kategorija) {
        if(kategorija != null)
        this.kategorija = kategorija;
        else throw new NullPointerException("Kategorija ne sme biti null");
    }

    /**
     * Get metoda - Vraća administratora grupe.
     *
     * @return administrator grupe
     */
    public Administrator getAdministrator() {
        return administrator;
    }

    /**
     * Set metoda - Postavlja administratora grupe.
     *
     * @param administrator administrator grupe
     * @throws NullPointerException ako je administrator null
     */
    public void setAdministrator(Administrator administrator) {
        if(administrator != null)
        this.administrator = administrator;
        else throw new NullPointerException("Administrator ne sme biti null");
    }

    /**
     * Get metoda - Vraća trenera grupe.
     *
     * @return trener grupe
     */
    public Trener getTrener() {
        return trener;
    }

    /**
     * Set metoda - Postavlja trenera grupe.
     *
     * @param trener trener grupe
     * @throws NullPointerException ako je trener null
     */
    public void setTrener(Trener trener) {
        if(trener != null)
        this.trener = trener;
        else throw new NullPointerException("Trener ne sme biti null");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * Override-ovana equals metoda za klasu Grupa. Proverava da li su 2 objekta klase Grupa jednaka
     * 
     * @param obj
     * @return true ako se porede dva objekta s iste memorijske lokacije ili ako su jednaki po nazivu grupe
     * i id-u grupe
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
        final Grupa other = (Grupa) obj;
        if (!Objects.equals(this.nazivGrupe, other.nazivGrupe)) {
            return false;
        }
        return Objects.equals(this.grupaID, other.grupaID);
    }

    
    /**
     * Vraća string prezentaciju objekta {@code Grupa}.
     * <p>
     * U ovom slučaju, vraća naziv grupe.
     * </p>
     *
     * @return Naziv grupe.
     */
    @Override
    public String toString() {
        return nazivGrupe;
    }

    
    /**
     * {@inheritDoc}
     * Vraća naziv tabele u bazi podataka.
     * 
     * @return Naziv tabele
     */
    @Override
    public String vratiNazivTabele() {
        return "grupa";
    }

    /**
     * {@inheritDoc}
     * Vraća listu objekata {@link Grupa} iz rezultata upita.
     * 
     * @param rs {@code ResultSet} koji sadrži rezultate upita
     * @return Lista objekata {@link ApstraktniDomenskiObjekat}
     * @throws Exception Ako dođe do greške tokom obrade {@code ResultSet}-a
     */
    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){   
            /*    private Long grupaID;
    private String nazivGrupe;
    private int brClanova;
    private Kategorija kategorija;
    private Administrator administrator;
    private Trener trener;*/
            Long idGrupe = (long) rs.getInt("grupa.grupaID");
            String naziv = rs.getString("grupa.nazivGrupe");
            int br = rs.getInt("grupa.brClanova");
            
            Long kategorijaID = (long) rs.getInt("kategorija.kategorijaID");
            String nazivKategorije = rs.getString("kategorija.nazivKategorije");
            String opisKategorije = rs.getString("kategorija.opisKategorije");
            Pol pol = Pol.valueOf(rs.getString("kategorija.pol"));
            Kategorija k = new Kategorija(kategorijaID, nazivKategorije, opisKategorije, pol);
            
            Long administratorID = (long) rs.getInt("administrator.administratorID");
            String korisnickoIme = rs.getString("administrator.korisnickoIme");
            String sifra = rs.getString("administrator.sifra");
            String imeAdmin = rs.getString("administrator.imeAdmin");
            String prezimeAdmin = rs.getString("administrator.prezimeAdmin");
            Administrator a = new Administrator(administratorID, korisnickoIme, sifra, imeAdmin, prezimeAdmin);
            
            Long trenerId = (long) rs.getInt("trener.trenerID");
            String imeTrener = rs.getString("trener.imeTrener");
            String prezimeTrener = rs.getString("trener.prezimeTrener");
            Long mestoID = (long) rs.getInt("trener.mesto");
            Long postanskiBroj = (long) rs.getInt("mesto.postanskiBroj");
            String nazivMesta = rs.getString("mesto.naziv");
            Mesto m = new Mesto(mestoID, postanskiBroj, nazivMesta);
            Trener trener = new Trener(trenerId, imeTrener, prezimeTrener, m);
            
            Grupa grupa = new Grupa(idGrupe, naziv, br, k, a, trener);
            lista.add(grupa);
        }
        System.out.println("VRACENA GRUPA: " + lista);
        return lista;
    }

    /**
     * {@inheritDoc}
     * Vraća imena kolona koje se koriste za ubacivanje podataka u bazu u tabelu Grupa.
     * 
     * @return Imena kolona
     */
    @Override
    public String vratiKoloneZaUbacivanje() {
        return "nazivGrupe,brClanova,kategorija,administrator,trener";
    }
    
    /**
     * {@inheritDoc}
     * Vraća vrednosti za ubacivanje u bazu u tabelu Grupa.
     * 
     * @return Vrednosti za ubacivanje.
     */
    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+nazivGrupe+"',"+brClanova+","+kategorija.getKategorijaID()+","+administrator.getAdministratorID()+","+trener.getTrenerID();
    }

    /**
     * {@inheritDoc}
     * Vraća primarni ključ za identifikaciju grupe.
     * 
     * @return Primarni ključ
     */
    @Override
    public String vratiPrimarniKljuc() {
        return "grupa.grupaID="+grupaID;
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
     * Vraća SQL izraz za ažuriranje podataka u bazi u tabelu Grupa.
     * 
     * @return SQL izraz za ažuriranje
     */
    @Override
    public String vratiVrednostiZaIzmenu() {
        //"nazivGrupe,brClanova,kategorija,administrator,trener";
        return "nazivGrupe='"+nazivGrupe+"', brClanova="+brClanova+", kategorija="+ kategorija.getKategorijaID()+" ,administrator="+administrator.getAdministratorID()+", trener="+trener.getTrenerID();
    }
    
    
    
}
