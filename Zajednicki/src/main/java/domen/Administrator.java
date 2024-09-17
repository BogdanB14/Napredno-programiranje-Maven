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
 * Predstavlja model administratora u sistemu.
 * Ova klasa implementira interfejs {@link ApstraktniDomenskiObjekat} i obezbeđuje implementaciju svih
 * potrebnih metoda za rad sa administratorom u sistemu.
 * 
 * @author Bogdan Blagojevic
 */
public class Administrator implements ApstraktniDomenskiObjekat{
    /**
     * ID administratora.
     * Predstavlja jedinstveni identifikator za administratora u sistemu.
     * Tip Long
     */
    private Long administratorID;
    /**
     * Korisnicko ime administratora.
     * Predstavlja jedinstveno korisnicko ime koje administrator koristi za prijavu u sistem.
     * Tip String
     */
    private String korisnickoIme;
    /**
     * Sifra administratora.
     * Predstavlja lozinku koja se koristi za autentifikaciju administratora.
     * Tip String
     */
    private String sifra;
    
    /**
     * Ime administratora.
     * Predstavlja ime administratora.
     * Tip String
     */
    private String imeAdmin;
    /**
     * Prezime administratora.
     * Predstavlja prezime administratora.
     * Tip String
     */
    private String prezimeAdmin;

    /**
     * Default konstruktor - Kreira novog administratora sa podrazumevanim vrednostima.
     */
    public Administrator() {
    }

    /**
     * Parametarski konstruktor - Kreira novog administratora sa zadatim vrednostima.
     * 
     * @param administratorID ID administratora
     * @param korisnickoIme korisničko ime administratora
     * @param sifra lozinka administratora
     * @param imeAdmin ime administratora
     * @param prezimeAdmin prezime administratora
     */
    public Administrator(Long administratorID, String korisnickoIme, String sifra, String imeAdmin, String prezimeAdmin) {
//        this.administratorID = administratorID;
//        this.korisnickoIme = korisnickoIme;
//        this.sifra = sifra;
//        this.imeAdmin = imeAdmin;
//        this.prezimeAdmin = prezimeAdmin;
          this.setAdministratorID(administratorID);
          this.setKorisnickoIme(korisnickoIme);
          this.setSifra(sifra);
          this.setImeAdmin(imeAdmin);
          this.setPrezimeAdmin(prezimeAdmin);

    }
    
    
    /**
     * Get metoda - Vraća ID administratora.
     * 
     * @return ID administratora
     */
    public Long getAdministratorID() {
        return administratorID;
    }

    
    /**
     *Set metoda - Postavlja ID administratora.
     * 
     * @param administratorID ID administratora
     * @throws RuntimeException Ako je ID administratora postavljen na broj manji od 0
     */
    public void setAdministratorID(Long administratorID) {
        if(administratorID > 0)
        this.administratorID = administratorID;
        else throw new RuntimeException("ID mora biti veci od 0");
    }

    /**
     *Get metoda - Vraća korisničko ime administratora.
     * 
     * @return korisničko ime administratora
     */
    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    /**
     * Set metoda - Postavlja korisničko ime administratora.
     * 
     * @param korisnickoIme korisničko ime administratora
     * @throws NullPointerException Ako je korisnicko ime administratora null, prazno ili se sastoji samo od razmaka
     */
    public void setKorisnickoIme(String korisnickoIme) {
        if(korisnickoIme != null && !korisnickoIme.isEmpty() && !korisnickoIme.isBlank())
        this.korisnickoIme = korisnickoIme;
        else throw new NullPointerException("Korisnicko ime nije u dobrom formatu");
    }

    /**
     * Get metoda - Vraća lozinku administratora.
     * 
     * @return lozinka administratora
     */
    public String getSifra() {
        return sifra;
    }

    
    /**
     * Set metoda - Postavlja lozinku administratora.
     * 
     * @param sifra lozinka administratora
     * @throws NullPointerException Ako je sifra administratora null, prazna ili se sastoji samo od razmaka
     */
    public void setSifra(String sifra) {
        if(sifra != null && !sifra.isEmpty() && !korisnickoIme.isBlank())
        this.sifra = sifra;
        else throw new NullPointerException("Sifra nije u dobrom formatu");
    }

    /**
     * Get metoda - Vraća ime administratora.
     * 
     * @return ime administratora
     */
    public String getImeAdmin() {
        return imeAdmin;
    }

    /**
     * Set metoda - Postavlja ime administratora.
     * 
     * @param imeAdmin ime administratora
     * @throws NullPointerException Ako je ime administratora null, prazno ili se sastoji samo od razmaka
     */
    public void setImeAdmin(String imeAdmin) {
        if(imeAdmin != null && !imeAdmin.isEmpty() && !imeAdmin.isBlank())
        this.imeAdmin = imeAdmin;
        else throw new NullPointerException("Ime nije u dobrom formatu");
    }

    /**
     * Vraća prezime administratora.
     * 
     * @return prezime administratora
     */
    public String getPrezimeAdmin() {
        return prezimeAdmin;
    }

    /**
     * Postavlja prezime administratora.
     * 
     * @param prezimeAdmin prezime administratora
     * @throws NullPointerException Ako je prezime administratora null, prazno ili se sastoji samo od razmaka
     */
    public void setPrezimeAdmin(String prezimeAdmin) {
        if(prezimeAdmin != null && !prezimeAdmin.isEmpty() && !prezimeAdmin.isBlank())
        this.prezimeAdmin = prezimeAdmin;
        else throw new NullPointerException("Prezime nije u dobrom formatu");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * 
     * Predefinisana metoda overriede-ovana za potrebe klase Administrator. Poredi jednakost dva objekta
     * @param obj predstavlja objekat klase Object koji ce se kastovati u klasu Administrator
     * @return true ako  je prosledjen objekat na istoj memorijskoj adresi kao i objekat sa kojim se poredi
     * ili u slucaju da su sifra i korisnicko ime isti. U svakom drugom slucaju vraca false
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
        final Administrator other = (Administrator) obj;
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        return Objects.equals(this.sifra, other.sifra);
    }

    /**
     * Vraća string prezentaciju objekta {@code Administrator}.
     * <p>
     * U ovom slučaju, vraća  korisnicko ime Administratora.
     * </p>
     *
     * @return Korisnicko ime
     */
    @Override
    public String toString() {
        return korisnickoIme;
    }

    /**
     * {@inheritDoc}
     * Metoda predefinisana za potrebe klase Administrator
     */
    @Override
    public String vratiNazivTabele() {
        return "administrator";
    }

    
    /**
     * {@inheritDoc}
     * Metoda predifinisana za potrebe klase Administrator
     * @param rs {@code ResultSet} koji sadrži rezultate upita
     * @return lista objekata klase Administrator
     * @throws Exception Ako dođe do greške tokom obrade {@code ResultSet}-a
     */
    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            Long id = (long) rs.getInt("administrator.administratorID");
            String korisnicko = rs.getString("administrator.korisnickoIme");
            String lozinka = rs.getString("administrator.sifra");
            String ime = rs.getString("administrator.imeAdmin");
            String prezime = rs.getString("administrator.prezimeAdmin");
            Administrator a = new Administrator(id, korisnicko, lozinka, ime, prezime);
            lista.add(a);
        }
        return lista;
    }

    /**
     * {@inheritDoc}
     * Metoda predifinisana za potrebe klase Administrator
     * @return imena kolona
     */
    @Override
    public String vratiKoloneZaUbacivanje() {
        return "korisnickoIme,sifra,imeAdmin,prezimeAdmin";
    }

    /**
     * {@inheritDoc}
     * Metoda predifinisana za potrebe klase Administrator
     * @return vrednosti za ubacivanje.
     */
    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+korisnickoIme+"','"+sifra+"','"+imeAdmin+"','"+prezimeAdmin+"'";
    }

    /**
     * {@inheritDoc}
     * Metoda predifinisana za potrebe klase Administrator
     * @return uslov za pretragu
     */
    @Override
    public String vratiPrimarniKljuc() {
        return "administrator.administratorID="+administratorID;
    }

    /**
     * {@inheritDoc}
     * 
     * @param rs {@code ResultSet} koji sadrži podatke za kreiranje objekta
     * @return instanca objekta klase Administrator
     * @throws Exception Ako dođe do greške tokom obrade {@code ResultSet}-a
     */
    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * {@inheritDoc}
     * 
     * @return SQL izraz za ažuriranje
     */
    @Override
    public String vratiVrednostiZaIzmenu() {
        return "korisnickoIme='"+korisnickoIme+"', sifra='"+sifra+"', imeAdmin='"+imeAdmin+"', prezimeAdmin='"+prezimeAdmin;
    }
    
    
}
