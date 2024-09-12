/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import domen.Administrator;
import domen.Clan;
import domen.Grupa;
import domen.Kategorija;
import domen.Mesto;
import domen.Sala;
import domen.Trener;
import domen.Trening;
import domenJSON.AdministratorDeserijalizacija;
import domenJSON.AdministratorSerijalizacija;
import domenJSON.ClanDeserijalizacija;
import domenJSON.ClanSerijalizacija;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kordinator.Kordinator;

/**
 * Klasa Komunikacija predstavlja komunikacioni sloj između klijentske aplikacije
 * i servera. Koristi se za slanje zahteva i primanje odgovora sa servera za
 * različite entitete kao što su članovi, treneri, grupe, administratori, itd.
 * Implementira singleton šablon, što znači da postoji samo jedna instanca ove klase.
 * 
 * @author Bogdan Blagojevic
 */
public class Komunikacija {
    private Socket socket;
    private Posiljalac posiljalac;
    private Primalac primalac;
    private static Komunikacija instanca;
    
    
        /**
     * Vraća jedinu instancu klase Komunikacija. Ukoliko instanca nije kreirana,
     * kreira novu instancu.
     * 
     * @return jedinstvena instanca klase Komunikacija
     */
    public static Komunikacija getInstanca(){
        if(instanca == null)
            instanca = new Komunikacija();
        return instanca;
    }
    
        /**
     * Privatni konstruktor klase kako bi se onemogućilo kreiranje više instanci.
     */
    private Komunikacija(){
        
    }
    
        /**
     * Uspostavlja konekciju sa serverom na lokalnoj mašini koristeći port 9000.
     * Kreira instance klasa Posiljalac i Primalac koje omogućavaju komunikaciju
     * sa serverom.
     */
    public void konekcija(){
        try {
            socket = new Socket("localhost",9000);
            posiljalac = new Posiljalac(socket);
            primalac = new Primalac(socket);
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        /**
     * Omogućava prijavu administratora. Šalje zahteve za autentifikaciju serveru
     * i prima odgovor o uspešnosti prijave.
     * 
     * @param korisnickoIme Korisničko ime administratora
     * @param lozinka Lozinka administratora
     * @return Administrator ukoliko je prijava uspešna, inače null
     */
    public Administrator prijava(String korisnickoIme, String lozinka) {
        Administrator a = new Administrator();
        a.setKorisnickoIme(korisnickoIme);
        a.setSifra(lozinka);
        Zahtev zahtev = new Zahtev(Operacija.LOGIN, a);
        
        posiljalac.posalji(zahtev);
        Odgovor odg = (Odgovor) primalac.primi();
        Administrator administrator = (Administrator) odg.getOdgovor();
        AdministratorSerijalizacija adminSerijalizacija = new AdministratorSerijalizacija();
        adminSerijalizacija.serijalizacija(administrator, "D:\\Napredno programiranje\\json\\Administrator\\ulogovanadministrator.txt");
        return administrator;
    }

    
    /**
     * Učitava listu članova iz baze podataka putem zahteva poslatog serveru.
     * 
     * @return Lista članova
     */
    public List<Clan> ucitajListuClanova() {
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_CLANOVE, null);
        List<Clan> lista;
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        lista = (List<Clan>) odgovor.getOdgovor();
        ClanSerijalizacija clanSerijalizacija = new ClanSerijalizacija();
        for(Clan a : lista){
        clanSerijalizacija.serijalizacija(a, "D:\\Napredno programiranje\\json\\Clan\\sviclanovi.txt");
        System.out.println("Serijalizuje se clan upravo" + a);
        }
        ClanDeserijalizacija clanDeserijalizacija = new ClanDeserijalizacija();
        List<Clan> deserijalizovana = clanDeserijalizacija.deserijalizuj("D:\\Napredno programiranje\\json\\Clan\\sviclanovi.txt");
        System.out.println("Deserijalizovana lista clanova: \n" + deserijalizovana);
        
        return lista;
    }
    
    
    /**
     * Učitava listu mesta iz baze podataka putem zahteva poslatog serveru.
     * 
     * @return Lista mesta
     */
    public List<Mesto> ucitajListuMesta() {
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_MESTA, null);
        List<Mesto> lista;
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        
        lista = (List<Mesto>) odgovor.getOdgovor();
        return lista;
        
    }

        /**
     * Briše člana iz baze podataka na osnovu prosleđenog objekta Clan.
     * 
     * @param clan Objekat člana koji treba da se obriše
     * @return Odgovor sa statusom operacije
     */
    public Odgovor obrisiClana(Clan clan) {
        Zahtev zahtev = new Zahtev(Operacija.OBRISI_CLANA, clan);
        posiljalac.posalji(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        System.out.println("ODGOVOR U OBRISI CLANA KOMUNIKACIJA:" + odgovor.getOdgovor());
        return odgovor;
        
    }

        /**
     * Kreira novog člana u bazi podataka na osnovu prosleđenog objekta Clan.
     * 
     * @param clan Objekat člana koji treba da se kreira
     * @return Odgovor sa statusom operacije
     */
    public Odgovor kreirajClana(Clan clan) {
        Zahtev zahtev = new Zahtev(Operacija.DODAJ_CLANA, clan);
        System.out.println("ZAHTEEV U DODAJ CLANA U KOMUNIKACIJI: " + zahtev.getParametar());
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        System.out.println("ODGOVOR U DODAJ CLANA U KOMUNIKACIJI: " + odgovor.getOdgovor());
        return odgovor;
    }
    
        /**
     * Kreira novog trenera u bazi podataka na osnovu prosleđenog objekta Trener.
     * 
     * @param trener Objekat trenera koji treba da se kreira
     * @return Odgovor sa statusom operacije
     */
    public Odgovor kreirajTrenera(Trener trener){
        Zahtev zahtev = new Zahtev(Operacija.DODAJ_TRENERA, trener);
        System.out.println("ZAHTEV U DODAJ TRENERA U KOMUNIKACIJI: " + zahtev.getParametar());
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        System.out.println("ODGOVOR U DODAJ TRENERA U KOMUNIKACIJI: " + odgovor.getOdgovor());
        return odgovor;
    }
    
        /**
     * Kreira novu grupu u bazi podataka na osnovu prosleđenog objekta Grupa.
     * 
     * @param grupa Objekat grupe koja treba da se kreira
     * @return Odgovor sa statusom operacije
     */
    public Odgovor kreirajGrupu(Grupa grupa) {
        Zahtev zahtev = new Zahtev(Operacija.DODAJ_GRUPU, grupa);
        System.out.println("ZAHTEV U DODAJ GRUPU U KOMUNIKACIJI: " + zahtev.getParametar());
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        System.out.println("ODGOVOR U DODAJ GRUPU U KOMUNIKACIJI: " + odgovor.getOdgovor());
        return odgovor;
    }
    
    /**
 * Kreira novi trening u bazi podataka na osnovu prosleđenog objekta Trening.
 * 
 * @param trening Objekat treninga koji treba da se kreira
 * @return Odgovor sa statusom operacije
 */
    public Odgovor kreirajTrening(Trening trening) {
        Zahtev zahtev = new Zahtev(Operacija.DODAJ_TRENING, trening);
        System.out.println("ZAHTEV U DODAJ TRENING U KOMUNIKACIJI: " + zahtev.getParametar());
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        System.out.println("ODGOVOR U DODAJ TRENING U KOMUNIKACIJI: " + odgovor.getOdgovor());
        return odgovor;
    }

    /**
 * Ažurira podatke o članu u bazi podataka na osnovu prosleđenog objekta Clan.
 * Nakon ažuriranja, osvežava glavnu formu.
 * 
 * @param clan Objekat člana koji treba da se ažurira
 * @return Odgovor sa statusom operacije
 */
    public Odgovor izmeniClana(Clan clan) {
        Zahtev zahtev = new Zahtev(Operacija.AZURIRAJ_CLANA, clan);
        System.out.println("ZAHTEEV U AZURIRAJ CLANA U KOMUNIKACIJI: " + zahtev.getParametar());
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        Kordinator.getInstanca().osveziGlavnuFormu();
        return odgovor;
    }

    
/**
 * Učitava listu treninga iz baze podataka.
 * 
 * @return Lista treninga
 */
    public List<Trening> ucitajListuTreninga() {
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_TRENINGE, null);
        List<Trening> treninzi = new ArrayList<>();
        
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        treninzi = (List<Trening>) odgovor.getOdgovor();
        
        return treninzi;
     }

    /**
 * Učitava listu grupa iz baze podataka.
 * 
 * @return Lista grupa
 */
    public List<Grupa> ucitajListuGrupa() {
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_GRUPE, null);
        List<Grupa> grupe = new ArrayList<>();
        
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        grupe = (List<Grupa>) odgovor.getOdgovor();
        
        return grupe;
    }
    /**
 * Učitava listu sala iz baze podataka.
 * 
 * @return Lista sala
 */
    public List<Sala> ucitajListuSala() {
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_SALE,  null);
        List<Sala> sale = new ArrayList<>();
        
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        sale = (List<Sala>) odgovor.getOdgovor();
        
        return sale;
    }
    

    /**
 * Učitava listu kategorija iz baze podataka.
 * 
 * @return Lista kategorija
 */
    public List<Kategorija> ucitajListuKategorija() {
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_KATEGORIJE, null);
        List<Kategorija> kategorije = new ArrayList<>();
        
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        kategorije = (List<Kategorija>) odgovor.getOdgovor();
        
        return kategorije;
    }

    /**
 * Učitava listu trenera iz baze podataka.
 * 
 * @return Lista trenera
 */
    public List<Trener> ucitajListuTrenera() {
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_TRENERE, null);
        List<Trener> treneri = new ArrayList<>();
        
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        treneri = (List<Trener>) odgovor.getOdgovor();
        
        return treneri;
    }

    /**
 * Učitava listu administratora iz baze podataka.
 * 
 * @return Lista administratora
 */
    public List<Administrator> ucitajAdministratore() {
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_ADMINISTRATORE, null);
        List<Administrator> administratori = new ArrayList<>();
        
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        administratori = (List<Administrator>) odgovor.getOdgovor();
        AdministratorSerijalizacija lista = new AdministratorSerijalizacija();
        for(Administrator a : administratori){
        lista.serijalizacija(a, "D:\\Napredno programiranje\\json\\Administrator\\sviadministratori.txt");
        System.out.println("Serijalizuje se administrator upravo" + a);
        }
        AdministratorDeserijalizacija deserijalizacija = new AdministratorDeserijalizacija();
        List<Administrator> deserijalizovana = deserijalizacija.deserijalizuj("D:\\Napredno programiranje\\json\\Administrator\\sviadministratori.txt");
        System.out.println("Deserijalizovana lista: \n" + deserijalizovana);
        return administratori;
    }

    /**
 * Odjavljuje trenutno prijavljenog administratora i zatvara socket konekciju.
 */
    public void logOut() {
        try {
            Administrator a = Kordinator.getInstanca().getUlogovani();
            AdministratorSerijalizacija adminSerijalizacija = new AdministratorSerijalizacija();
            adminSerijalizacija.serijalizacija(a, "D:\\Napredno programiranje\\json\\Administrator\\izlogovanadministrator.txt");
            Zahtev zahtev = new Zahtev(Operacija.LOGOUT, a);
            posiljalac.posalji(zahtev);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }







}
