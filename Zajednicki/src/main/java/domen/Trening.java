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
 * Klasa koja predstavlja entitet treninga u sistemu.
 * <p>
 * Ova klasa implementira interfejs {@link ApstraktniDomenskiObjekat} i pruža osnovne informacije o treningu,
 * uključujući identifikator, datum, tip treninga, salu, trenera i grupu.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class Trening implements ApstraktniDomenskiObjekat{
    /**
     * Redni broj treninga.
     * Predstavlja jedinstveni identifikator za svaki trening.
     * Tip Integer
     */
    private int rbTreninga;
    /**
     * Datum treninga.
     * Predstavlja datum kada se trening odrzava.
     * Tip Date
     */
    private Date datumTreninga;
    /**
     * Tip treninga.
     * Predstavlja tip treninga, koji je instanca klase {@link TipTreninga}.
     * Tip Date
     */
    private TipTreninga tipTreninga;
    /**
     * Sala u kojoj se održava trening.
     * Predstavlja objekat klase {@link Sala} koji opisuje lokaciju treninga.
     * Tip TipTreninga
     */
    private Sala sala;
    /**
     * Trener koji vodi trening.
     * Predstavlja objekat klase {@link Trener} koji vodi trening.
     * Tip Trener
     */
    private Trener trener;
    /**
     * Grupa koja učestvuje u treningu.
     * Predstavlja objekat klase {@link Grupa} koja je prisutna na treningu.
     * Tip Grupa
     */
    private Grupa grupa;

    /**
     * Podrazumevani konstruktor koji inicijalizuje novi objekat {@code Trening}.
     */
    public Trening() {
    }

    /**
     * Parametarski konstruktor koji inicijalizuje objekat {@code Trening}.
     *
     * @param rbTreninga Redni broj treninga.
     * @param datumTreninga Datum održavanja treninga.
     * @param tipTreninga Tip treninga.
     * @param sala Sala u kojoj se održava trening.
     * @param trener Trener koji vodi trening.
     * @param grupa Grupa koja prisustvuje treningu.
     */
    public Trening(int rbTreninga, Date datumTreninga, TipTreninga tipTreninga, Sala sala, Trener trener, Grupa grupa) {
        this.rbTreninga = rbTreninga;
        this.datumTreninga = datumTreninga;
        this.tipTreninga = tipTreninga;
        this.sala = sala;
        this.trener = trener;
        this.grupa = grupa;
    }

    /**
     * Get metoda - Vraća redni broj treninga.
     *
     * @return Redni broj treninga.
     */
    public int getRbTreninga() {
        return rbTreninga;
    }

    /**
     * Set metoda - Postavlja redni broj treninga.
     *
     * @param rbTreninga Redni broj treninga.
     * @throws  RuntimeException ako je redni broj manji od 0 ili 0
     */
    public void setRbTreninga(int rbTreninga) {
        if(rbTreninga > 0)
        this.rbTreninga = rbTreninga;
        else throw new RuntimeException("Redni broj mora biti veci od 0");
    }

    /**
     * Get metoda - Vraća datum održavanja treninga.
     *
     * @return Datum održavanja treninga.
     */
    public Date getDatumTreninga() {
        return datumTreninga;
    }

    /**
     * Set metoda - Postavlja datum održavanja treninga.
     *
     * @param datumTreninga Datum održavanja treninga.
     * @throws  NullPointerException ako je datum null ili ako je datum treninga postavljen na proslo vreme
     */
    public void setDatumTreninga(Date datumTreninga) {
        if(datumTreninga != null && datumTreninga.after(new Date()))
        this.datumTreninga = datumTreninga;
        else throw new NullPointerException("Datum nije u skladu sa ogranicenjima");
    }

    /**
     * Get metoda - Vraća tip treninga.
     *
     * @return Tip treninga.
     */
    public TipTreninga getTipTreninga() {
        return tipTreninga;
    }

    /**
     * Set metoda - Postavlja tip treninga.
     *
     * @param tipTreninga Tip treninga.
     */
    public void setTipTreninga(TipTreninga tipTreninga) {
        this.tipTreninga = tipTreninga;
    }

    
    /**
     * Get metoda - Vraća salu u kojoj se održava trening.
     *
     * @return Sala u kojoj se održava trening.
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * Set metoda - Postavlja salu u kojoj se održava trening.
     *
     * @param sala Sala u kojoj se održava trening.
     * @throws NullPointerException ako je sala null
     */
    public void setSala(Sala sala) {
        if(sala != null)
        this.sala = sala;
        else throw new NullPointerException("Sala ne sme biti null");
    }

    /**
     * Get metoda - Vraća trenera koji vodi trening.
     *
     * @return Trener koji vodi trening.
     */
    public Trener getTrener() {
        return trener;
    }

    /**
     * Set metoda - Postavlja trenera koji vodi trening.
     *
     * @param trener Trener koji vodi trening.
     * @throws NullPointerException ako je trener null
     */
    public void setTrener(Trener trener) {
        if(trener != null)
        this.trener = trener;
        else throw new NullPointerException("Trener ne sme biti null");
    }

    /**
     * Get metoda - Vraća grupu koja prisustvuje treningu.
     *
     * @return Grupa koja prisustvuje treningu.
     */
    public Grupa getGrupa() {
        return grupa;
    }

    /**
     * Set metoda - Postavlja grupu koja prisustvuje treningu.
     *
     * @param grupa Grupa koja prisustvuje treningu.
     * @throws NullPointerException ako je grupa null
     */
    public void setGrupa(Grupa grupa) {
        if(grupa != null)
        this.grupa = grupa;
        else throw new NullPointerException("Grupa ne sme biti null");
    }

    /**
     * Vraća string prezentaciju objekta {@code Trening}.
     * <p>
     * U ovom slučaju, vraća sve informacije o treningu.
     * </p>
     *
     * @return String reprezentacija objekta {@code Trening}.
     */
    @Override
    public String toString() {
        return "Trening{" + "rbTreninga=" + rbTreninga + ", datumTreninga=" + datumTreninga + ", tipTreninga=" + tipTreninga + ", sala=" + sala + ", trener=" + trener + ", grupa=" + grupa + '}';
    }


    
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    /**
     * Upoređuje objekat {@code Trening} sa drugim objektom.
     *
     * @param obj Drugi objekat koji se upoređuje.
     * @return {@code true} ako su objekti identični, {@code false} inače.
     * Poređenje se vrši po rednom broju treninga, datumu i tipu treninga.
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
        final Trening other = (Trening) obj;
        return this.rbTreninga == other.rbTreninga;
    }

    /**
     * {@inheritDoc}
     * Vraća naziv tabele u bazi podataka u kojoj se nalazi entitet {@code Trening}.
     * 
     * @return Naziv tabele.
     */
    @Override
    public String vratiNazivTabele() {
        return "trening";
    }

    /**
     * {@inheritDoc}
     * Vraća listu objekata {@link Trening} iz rezultata upita.
     * 
     * @param rs {@code ResultSet} koji sadrži rezultate upita.
     * @return Lista objekata {@link ApstraktniDomenskiObjekat}.
     * @throws Exception Ako dođe do greške tokom obrade {@code ResultSet}-a.
     */
    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        /*    private int rbTreninga;
    private Date datumTreninga;
    private TipTreninga tipTreninga;
    private Sala sala;
    private Trener trener;
    private Grupa grupa;
*/      List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int rb = rs.getInt("trening.rbTreninga");
            java.util.Date datum = new java.util.Date(rs.getDate("trening.datumTreninga").getTime());
            TipTreninga tip = TipTreninga.valueOf(rs.getString("trening.tipTreninga"));
            
            Long salaID = (long) rs.getInt("sala.salaID");
            String nazivSale = rs.getString("sala.nazivSale");
            int kapacitet = rs.getInt("sala.kapacitet");
            Long mestoID = (long) rs.getInt("sala.mesto");
            Long postanskiBroj = (long) rs.getInt("mesto.postanskiBroj");
            String nazivMesta = rs.getString("mesto.naziv");
            Mesto m = new Mesto(mestoID, postanskiBroj, nazivMesta);
            Sala s = new Sala(salaID, nazivSale, kapacitet, m);
            
            Long trenerID = (long) rs.getInt("trener.trenerID");
            String imeTrener = rs.getString("trener.imeTrener");
            String prezimeTrener = rs.getString("trener.prezimeTrener");
            Long mestoIDTrener = (long) rs.getInt("trener.mesto");
            String nazivMestaTrener = rs.getString("mesto2.naziv");
            Long ptt = (long) rs.getInt("mesto2.postanskiBroj");
            Mesto m1 = new Mesto(mestoIDTrener, ptt, nazivMestaTrener);
            Trener t = new Trener(trenerID, imeTrener, prezimeTrener, m1);
            
            Long grupaID = (long) rs.getInt("trening.grupa");
            String naziv = rs.getString("grupa.nazivGrupe");
            int brClanova = rs.getInt("grupa.brClanova");
            Grupa g = new Grupa(grupaID, naziv, brClanova, null, null, null);
            
            Trening trening = new Trening(rb, datum, tip, s, t, g);
            lista.add(trening);
        }
        System.out.println("LISTA TRENINGA JE: " + lista);
        return lista;
    }

    /**
     * {@inheritDoc}
     * Vraća imena kolona koje se koriste za ubacivanje podataka u bazu u tabelu {@code Trening}.
     * 
     * @return Imena kolona.
     */
    @Override
    public String vratiKoloneZaUbacivanje() {
        return "datumTreninga,tipTreninga,sala,trener,grupa";
    }

    /**
     * {@inheritDoc}
     * Vraća vrednosti za ubacivanje u bazu u tabelu {@code Trening}.
     * 
     * @return Vrednosti za ubacivanje.
     */
    @Override
    public String vratiVrednostiZaUbacivanje() {
        java.sql.Date datum = new java.sql.Date(datumTreninga.getTime());
        return "'"+datum+"','"+tipTreninga+"',"+sala.getSalaID()+","+trener.getTrenerID()+","+grupa.getGrupaID();
    }

    /**
     * {@inheritDoc}
     * Vraća primarni ključ za identifikaciju treninga.
     * 
     * @return Primarni ključ - redni broj treninga.
     */
    @Override
    public String vratiPrimarniKljuc() {
        return "trening.rbTreninga="+rbTreninga;
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
     * Vraća SQL izraz za ažuriranje podataka u bazi u tabelu {@code Trening}.
     * 
     * @return SQL izraz za ažuriranje.
     */
    @Override
    public String vratiVrednostiZaIzmenu() {
        //"datumTreninga,tipTreninga,sala,trener,grupa";
        return "datumTreninga='"+datumTreninga+"', tipTreninga='"+tipTreninga+"', sala="+sala.getSalaID()+", trener="+trener.getTrenerID()+", grupa="+grupa.getGrupaID();
    }
    
    
}
