/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija;

import repository.Repository;
import repository.db.DBRepository;
import repository.db.impl.DBRepositoryGeneric;

/**
 * Apstraktna klasa koja pruža osnovne operacije za izvršavanje generičkih
 * operacija u bazi podataka sa podrškom za transakcije.
 * <p>
 * Ova klasa koristi obrazac šablona (Template Method Pattern) za obezbeđivanje
 * jedinstvenog načina izvršavanja operacija u bazi podataka. Pruža implementaciju
 * za upravljanje transakcijama (pokretanje, potvrđivanje, poništavanje), a konkretne
 * operacije se definišu u podklasama.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public abstract class ApstraktnaGenerickaOperacija {
    /**
     * Atribut klase Repository koji se koristi za komunikaciju sa bazom podataka.
     */
    public  Repository broker; //AKO TE ZEZA PROGRAM SAMO VRATI FINAL 

    /**
     * Konstruktor koji inicijalizuje {@code broker} kao instancu {@link DBRepositoryGeneric}.
     */
    public ApstraktnaGenerickaOperacija() {
        this.broker = new DBRepositoryGeneric();
    }
    
    /**
     * Izvršava generičku operaciju sa podrškom za transakcije.
     *  
     * Ova metoda obavlja sledeće korake:
     *        <ul>
     *   <li>Proverava preduslove za operaciju.</li>
     *   <li>Pokreće transakciju.</li>
     *   <li>Izvršava konkretne operacije koje definiše konkretna klasa.</li>
     *   <li>Potvrđuje transakciju ako sve operacije prođu bez grešaka.</li>
     *   <li>U slučaju greške, poništava transakciju.</li>
     *        </ul>
     *  
     * 
     * @param objekat Objekt koji se koristi u operaciji.
     * @param kljuc Ključ koji se koristi u operaciji.
     * @throws Exception Ako dođe do greške tokom izvršavanja operacije ili upravljanja transakcijama.
     */
    public final void izvrsi(Object objekat, String kljuc) throws Exception{
        try{
            preduslovi(objekat);
            zapocniTransakciju();
            izvrsiOperaciju(objekat, kljuc);
            potvrdiTransakciju();
        } catch(Exception e){
            ponistiTransakciju();
            throw e;
        }
        
    }
    
    /**
     * Proverava preduslove koji moraju biti ispunjeni pre izvršavanja konkretne operacije.
     * <p>
     * Ova metoda treba biti implementirana u podklasama da definiše specifične preduslove
     * za operaciju.
     * </p>
     * 
     * @param param Parametar koji se koristi za proveru preduslova.
     * @throws Exception Ako preduslovi nisu ispunjeni.
     */
    protected abstract void preduslovi(Object param) throws Exception;
    
    
    /**
     * Izvršava konkretnu operaciju u bazi podataka.
     * <p>
     * Ova metoda treba biti implementirana u podklasama da definiše specifične operacije
     * koje treba izvršiti.
     * </p>
     * 
     * @param param Parametar koji se koristi u operaciji.
     * @param kljuc Ključ koji se koristi u operaciji.
     * @throws Exception Ako dođe do greške tokom izvršavanja operacije.
     */
    protected abstract void izvrsiOperaciju(Object param, String kljuc) throws Exception;
    
    /**
     * Pokreće transakciju u bazi podataka.
     * <p>
     * Ova metoda se poziva pre nego što se konkretna operacija izvrši.
     * </p>
     * 
     * @throws Exception Ako dođe do greške prilikom povezivanja sa bazom podataka.
     */
    private void zapocniTransakciju() throws Exception{
        ((DBRepository) broker).connect();
    }
    
    /**
     * Potvrđuje transakciju u bazi podataka.
     * <p>
     * Ova metoda se poziva nakon uspešnog izvršavanja operacije. Radi se commit operacija.
     * </p>
     * 
     * @throws Exception Ako dođe do greške prilikom potvrđivanja transakcije.
     */
    private void potvrdiTransakciju() throws Exception{
        ((DBRepository) broker).commit();
    }
    
    
    /**
     * Poništava transakciju u bazi podataka.
     * <p>
     * Ova metoda se poziva u slučaju greške tokom izvršavanja operacije. Radi se rollback operacija.
     * </p>
     * 
     * @throws Exception Ako dođe do greške prilikom poništavanja transakcije.
     */
    private void ponistiTransakciju() throws Exception{
        ((DBRepository) broker).rollback();
    }
    
    /**
     * Zatvara konekciju sa bazom podataka.
     * <p>
     * Ova metoda je trenutno komentarisana iz razloga što može uzrokovati da neka operacija
     * bude izvršena samo jednom. Ako je potrebno, treba je otkomentarisati i koristiti u
     * blokovima {@code finally}.
     * </p>
     * 
     * @throws Exception Ako dođe do greške prilikom zatvaranja konekcije.
     */
    private void ugasiKonekciju() throws Exception{
        ((DBRepository) broker).disconnect();
    }
}
