/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.Administrator;
import domen.Clan;
import domen.Grupa;
import domen.Kategorija;
import domen.Mesto;
import domen.Sala;
import domen.Trener;
import domen.Trening;
import java.util.ArrayList;
import java.util.List;
import niti.ObradaKlijentskihZahteva;
import operacija.administrator.UcitajAdministratoreOperacija;
import operacija.clan.AzurirajClanaOperacija;
import operacija.clan.DodajClanaOperacija;
import operacija.clan.ObrisiClanaOperacija;
import operacija.clan.UcitajClanoveOperacija;
import operacija.grupa.DodajGrupuOperacija;
import operacija.grupa.UcitajGrupeOperacija;
import operacija.kategorija.UcitajKategorijeOperacija;
import operacija.login.LoginOperacija;
import operacija.mesto.UcitajMestaOperacija;
import operacija.sala.UcitajSaleOperacija;
import operacija.trener.DodajTreneraOperacija;
import operacija.trener.UcitajTrenereOperacija;
import operacija.trening.DodajTreningOperacija;
import operacija.trening.UcitajTreningeOperacija;

/**
 * Klasa koja predstavlja kontroler za upravljanje operacijama aplikacije.
 * <p>
 * Ova klasa služi kao centralno mesto za upravljanje različitim operacijama vezanim za
 * korisnike, treninge, grupe, sale, itd. Pruža metode za prijavu i odjavu administratora,
 * kao i za obavljanje CRUD operacija nad različitim entitetima (npr. članovi, treneri, treninzi).
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class Controller {
        /**
     * Singleton instanca klase {@code Controller}.
     */
    private static Controller instance;
        /**
     * Lista trenutnih korisnika koji su prijavljeni i čiji zahtevi se obrađuju.
     */
    private List<ObradaKlijentskihZahteva> listaTrenutnihKorisnika = new ArrayList<>();
        /**
     * Lista trenutno ulogovanih administratora.
     */
    private List<Administrator> ulogovaniAdministratori = new ArrayList<>();
        /**
     * Vraća jedinu instancu klase {@code Controller} (Singleton).
     * 
     * @return Instanca klase {@code Controller}.
     */
    public static Controller getInstance(){
        if(instance == null)
            instance = new Controller();
        return instance;
    }
    
        /**
     * Privatni konstruktor koji inicijalizuje objekat klase {@code Controller}.
     */
    private Controller(){
        
    }

        /**
     * Metoda za prijavu administratora.
     * <p>
     * Ova metoda koristi {@link LoginOperacija} za autentifikaciju administratora. Ako je
     * prijava uspešna, administrator se dodaje u listu ulogovanih administratora.
     * </p>
     * 
     * @param a Administrator koji se prijavljuje.
     * @return Ulogovani {@link Administrator} ako je prijava uspešna, {@code null} inače.
     * @throws Exception Ako dođe do greške tokom prijave.
     */
    public Administrator login(Administrator a) throws Exception{
        LoginOperacija lo = new LoginOperacija();
        lo.izvrsi(a, null);
        System.out.println("Administrator u login metodi u kontroleru: " + lo.getAdministrator());
        a = lo.getAdministrator();
        if(a != null)
            ulogovaniAdministratori.add(a);
        return a;
    }

        /**
     * Metoda za učitavanje članova.
     * <p>
     * Ova metoda koristi {@link UcitajClanoveOperacija} za ucitavanje svih članova iz baze podataka.
     * </p>
     * 
     * @return Lista svih {@link Clan} objekata.
     * @throws Exception Ako dođe do greške tokom učitavanja.
     */
    public List<Clan> ucitajClanove() throws Exception {
        UcitajClanoveOperacija operacija = new UcitajClanoveOperacija();
        operacija.izvrsi(null, null);
        System.out.println("KLASA CONTROLLER CLANOVI:" + operacija.getLista());
        return operacija.getLista(); 
    }

        /**
     * Metoda za brisanje člana.
     * <p>
     * Ova metoda koristi {@link ObrisiClanaOperacija} za brisanje člana iz baze podataka.
     * </p>
     * 
     * @param clan {@link Clan} koji treba da se obriše.
     * @return {@code true} ako je član uspešno obrisan, {@code false} inače.
     * @throws Exception Ako dođe do greške tokom brisanja.
     */
    public boolean obrisiClana(Clan clan) throws Exception {
        ObrisiClanaOperacija opo = new ObrisiClanaOperacija();
        opo.izvrsi(clan, null);
        return opo.delete;
    }

        /**
     * Metoda za dodavanje člana.
     * <p>
     * Ova metoda koristi {@link DodajClanaOperacija} za dodavanje novog člana u bazu podataka.
     * </p>
     * 
     * @param clan {@link Clan} koji treba da se doda.
     * @throws Exception Ako dođe do greške tokom dodavanja.
     */
    public void dodajClana(Clan clan) throws Exception {
        DodajClanaOperacija dco = new DodajClanaOperacija();
        dco.izvrsi(clan, null);
    }

        /**
     * Metoda za dodavanje trenera.
     * <p>
     * Ova metoda koristi {@link DodajTreneraOperacija} za dodavanje novog trenera u bazu podataka.
     * </p>
     * 
     * @param trener {@link Trener} koji treba da se doda.
     * @throws Exception Ako dođe do greške tokom dodavanja.
     */
    public void dodajTrenera(Trener trener) throws Exception {
        DodajTreneraOperacija dto = new DodajTreneraOperacija();
        dto.izvrsi(trener, null);
    }
    
        
    /**
     * Metoda za dodavanje treninga.
     * <p>
     * Ova metoda koristi {@link DodajTreningOperacija} za dodavanje novog treninga u bazu podataka.
     * </p>
     * 
     * @param trening {@link Trening} koji treba da se doda.
     * @throws Exception Ako dođe do greške tokom dodavanja.
     */
    public void dodajTrening(Trening trening) throws Exception {
        DodajTreningOperacija dto = new DodajTreningOperacija();
        dto.izvrsi(trening, null);
    }


        /**
     * Metoda za dodavanje grupe.
     * <p>
     * Ova metoda koristi {@link DodajGrupuOperacija} za dodavanje nove grupe u bazu podataka.
     * </p>
     * 
     * @param grupa {@link Grupa} koja treba da se doda.
     * @throws Exception Ako dođe do greške tokom dodavanja.
     */
    public void dodajGrupu(Grupa grupa) throws Exception {
        DodajGrupuOperacija dgo = new DodajGrupuOperacija();
        dgo.izvrsi(grupa, null);
    
    }
    
       /**
     * Metoda za učitavanje mesta.
     * <p>
     * Ova metoda koristi {@link UcitajMestaOperacija} za ucitavanje svih mesta iz baze podataka.
     * </p>
     * 
     * @return Lista svih {@link Mesto} objekata.
     * @throws Exception Ako dođe do greške tokom učitavanja.
     */
    public List<Mesto> ucitajMesta() throws Exception {
        UcitajMestaOperacija umo = new UcitajMestaOperacija();
        umo.izvrsi(null, null);
        System.out.println("KLASA CONTROLLER CLANOVI:" + umo.getLista());
        return umo.getLista();
    }

        /**
     * Metoda za ažuriranje člana.
     * <p>
     * Ova metoda koristi {@link AzurirajClanaOperacija} za ažuriranje podataka o članu u bazi podataka.
     * </p>
     * 
     * @param clan {@link Clan} koji treba da se ažurira.
     * @return {@code true} ako je član uspešno ažuriran, {@code false} inače.
     * @throws Exception Ako dođe do greške tokom ažuriranja.
     */
    public boolean azurirajClana(Clan clan) throws Exception {
        System.out.println("Usao u azuriraj clana u kontroleru");
        AzurirajClanaOperacija aco = new AzurirajClanaOperacija();
        aco.izvrsi(clan, null);
        return aco.update;
    }

    /**
     * Metoda za učitavanje treninga.
     * <p>
     * Ova metoda koristi {@link UcitajTreningeOperacija} za ucitavanje  svih treninga iz baze podataka.
     * </p>
     * 
     * @return Lista svih {@link Trening} objekata.
     * @throws Exception Ako dođe do greške tokom učitavanja.
     */
    public List<Trening> ucitajTreninge() throws Exception {
        UcitajTreningeOperacija uto = new UcitajTreningeOperacija();
        uto.izvrsi(null, null);
        System.out.println("KLASA CONTROLLER TRENINZI: " + uto.getLista());
        return uto.getLista();
    }

        /**
     * Metoda za učitavanje grupa.
     * <p>
     * Ova metoda koristi {@link UcitajGrupeOperacija} za ucitavanje svih grupa iz baze podataka.
     * </p>
     * 
     * @return Lista svih {@link Grupa} objekata.
     * @throws Exception Ako dođe do greške tokom učitavanja.
     */
    public List<Grupa> ucitajGrupe() throws Exception {
        UcitajGrupeOperacija ugo = new UcitajGrupeOperacija();
        ugo.izvrsi(null, null);
        System.out.println("KLASA CONTROLLER GRUPE: " + ugo.getLista());
        return ugo.getLista();
    }

    /**
     * Metoda za učitavanje administratora.
     * <p>
     * Ova metoda koristi {@link UcitajAdministratoreOperacija} za ucitavanje svih administratora iz baze podataka.
     * </p>
     * 
     * @return Lista svih {@link Administrator} objekata.
     * @throws Exception Ako dođe do greške tokom učitavanja.
     */
    public List<Administrator> ucitajAdministratore() throws Exception {
        UcitajAdministratoreOperacija uao = new UcitajAdministratoreOperacija();
        uao.izvrsi(null, null);
        System.out.println("KLASA CONTROLLER ADMINISTRATORI: " + uao.getLista());
        return uao.getLista();
    }

        /**
     * Metoda za učitavanje kategorija.
     * <p>
     * Ova metoda koristi {@link UcitajKategorijeOperacija} za ucitavanje svih kategorija iz baze podataka.
     * </p>
     * 
     * @return Lista svih {@link Kategorija} objekata.
     * @throws Exception Ako dođe do greške tokom učitavanja.
     */
    public List<Kategorija> ucitajKategorije() throws Exception {
        UcitajKategorijeOperacija uko = new UcitajKategorijeOperacija();
        uko.izvrsi(null, null);
        System.out.println("KLASA CONTROLLER KATEGORIJE: " + uko.getLista());
        return uko.getLista();
    }

        /**
     * Metoda za učitavanje trenera.
     * <p>
     * Ova metoda koristi {@link UcitajTrenereOperacija} za ucitavanje svih trenera iz baze podataka.
     * </p>
     * 
     * @return Lista svih {@link Trener} objekata.
     * @throws Exception Ako dođe do greške tokom učitavanja.
     */
    public List<Trener> ucitajTrenere() throws Exception {
        UcitajTrenereOperacija uto = new UcitajTrenereOperacija();
        uto.izvrsi(null, null);
        System.out.println("KLASA CONTROLLER TRENERI: " + uto.getLista());
        return uto.getLista();
    }

        /**
     * Metoda za učitavanje sala.
     * <p>
     * Ova metoda koristi {@link UcitajSaleOperacija} za učitavanje svih sala iz baze podataka.
     * </p>
     * 
     * @return Lista svih {@link Sala} objekata.
     * @throws Exception Ako dođe do greške tokom učitavanja.
     */
    public List<Sala> ucitajSale() throws Exception {
        UcitajSaleOperacija uso = new UcitajSaleOperacija();
        uso.izvrsi(null, null);
        System.out.println("KLASA CONTROLLER SALE: " + uso.getLista());
        return uso.getLista();
    }

        /**
     * Metoda za odjavu administratora.
     * <p>
     * Ova metoda uklanja administratora iz liste ulogovanih administratora i uklanja sve
     * njegove trenutne klijentske zahteve.
     * </p>
     * 
     * @param izloguj {@link Administrator} koji se odjavljuje.
     */
    public void logout(Administrator izloguj) {
        ulogovaniAdministratori.remove(izloguj);
        for(ObradaKlijentskihZahteva o : listaTrenutnihKorisnika){
            if(o.getAdministrator().getAdministratorID() == izloguj.getAdministratorID())
                listaTrenutnihKorisnika.remove(o);    
            
        }
    }

        /**
     * Get metoda - Vraća listu trenutnih korisnika koji su prijavljeni i čiji zahtevi se obrađuju.
     * 
     * @return Lista trenutnih korisnika.
     */
    public List<ObradaKlijentskihZahteva> getListaTrenutnihKorisnika() {
        return listaTrenutnihKorisnika;
    }

        /**
     * Set metoda - Postavlja listu trenutnih korisnika koji su prijavljeni i čiji zahtevi se obrađuju.
     * 
     * @param listaTrenutnihKorisnika Lista trenutnih korisnika.
     */
    public void setListaTrenutnihKorisnika(List<ObradaKlijentskihZahteva> listaTrenutnihKorisnika) {
        this.listaTrenutnihKorisnika = listaTrenutnihKorisnika;
    }

        /**
     * Get metoda - Vraća listu trenutno ulogovanih administratora.
     * 
     * @return Lista ulogovanih administratora.
     */
    public List<Administrator> getUlogovaniAdministratori() {
        return ulogovaniAdministratori;
    }

        /**
     * Set metoda - Postavlja listu trenutno ulogovanih administratora.
     * 
     * @param ulogovaniAdministratori Lista ulogovanih administratora.
     */
    public void setUlogovaniAdministratori(List<Administrator> ulogovaniAdministratori) {
        this.ulogovaniAdministratori = ulogovaniAdministratori;
    }




}
