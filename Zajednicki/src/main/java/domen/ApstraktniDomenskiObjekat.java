/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.util.List;
import java.sql.ResultSet;


/**
 * Interfejs koji predstavlja generički domen objekat u aplikaciji.
 * Pruža metode za interakciju sa bazom podataka i rukovanje
 * operacijama specifičnim za domen.
 * <p>
 * Sve klase domena treba da implementiraju ovaj interfejs kako bi se osigurala
 * doslednost u pristupu i manipulaciji podacima.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public interface ApstraktniDomenskiObjekat extends Serializable {
    
        /**
     * Vraća naziv baze podataka koji je povezan sa ovim objektom iz domena.
     * 
     * @return Naziv tabele
     */
    public String vratiNazivTabele();
    
      /**
     * Vraća listu objekata domena kreiranih iz prosledjenog {@code ResultSet}-a.
     * 
     * @param rs {@code ResultSet} koji sadrži podatke iz baze podataka.
     * @return Lista objekata domena popunjena iz {@code ResultSet}-a.
     * @throws Exception Ako dođe do greške tokom obrade {@code ResultSet}-a.
     */
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception;
    
    
        /**
     * Vraća listu kolona koje će se koristiti za dodavanje novog reda u bazi podataka.
     * 
     * @return Kolone za ubacivanje kao {@code String}.
     */
    public String vratiKoloneZaUbacivanje();
    
    public String vratiVrednostiZaUbacivanje();
    
    public String vratiPrimarniKljuc();
    
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception;
    
    public String vratiVrednostiZaIzmenu();
}
