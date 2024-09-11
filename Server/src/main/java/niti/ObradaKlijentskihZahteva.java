/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import controller.Controller;
import domen.Administrator;
import domen.Clan;
import domen.Grupa;
import domen.Kategorija;
import domen.Mesto;
import domen.Sala;
import domen.Trener;
import domen.Trening;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Odgovor;
import komunikacija.Operacija;
import komunikacija.Posiljalac;
import komunikacija.Primalac;
import komunikacija.Zahtev;

/**
 * Klasa koja obrađuje zahteve klijenata u komunikaciji sa serverom.
 * <p>
 * Ova klasa nasleđuje {@link Thread} i koristi se za obradu zahteva koje
 * server prima od klijenata. Svaki zahtev se procesuira na osnovu vrste operacije
 * i vraća odgovarajući odgovor klijentu. 
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class ObradaKlijentskihZahteva extends Thread{
        /**
     * Socket koji povezuje klijenta sa serverom.
     */
    Socket socket;
    /**
     * Atribut klase Primalac koji se koristi za slanje (upisivanje) objekta na soket
     */
    Primalac primalac;
        /**
     * Atribut klase Primalac koji se koristi za prijem (iscitavanje) objekta sa soketa
     */
    Posiljalac posiljalac;
        /**
     * Flag koji označava da li treba prekinuti obradu zahteva.
     */
    boolean kraj = false;
        /**
     * Trenutno ulogovani administrator.
     */
    Administrator administrator;
    
        /**
     * Konstruktor klase {@code ObradaKlijentskihZahteva}.
     * <p>
     * Inicijalizuje {@code Primalac} i {@code Posiljalac} koristeći zadati socket.
     * </p>
     * 
     * @param socket Socket povezan sa klijentom.
     */
    public ObradaKlijentskihZahteva(Socket socket){
        this.socket = socket;
        posiljalac = new Posiljalac(socket);
        primalac = new Primalac(socket);
    }
    
        /**
     * Metoda koja se izvršava u posebnoj niti i obrađuje zahteve klijenata.
     * <p>
     * Ova metoda neprekidno čita zahteve sa soketa, obrađuje ih i šalje odgovore
     * klijentima. Ako dođe do greške, ili ako je zahtev {@code null}, obrada se
     * prekida.
     * </p>
     */
    @Override
    public void run() {
        while(!kraj){
            try {
                Zahtev zahtev = (Zahtev) primalac.primi();
                if (zahtev == null) {
                System.out.println("Zahtev je null, prekidam obradu.");
                continue; // Skip the loop iteration if the request is null
            }
                System.out.println("Zahtev je primljen: " + zahtev);
                Odgovor odgovor = new Odgovor();
                
                switch (zahtev.getOperacija()) {
                    case Operacija.LOGIN:
                        Administrator a = (Administrator) zahtev.getParametar();
                        a = Controller.getInstance().login(a);
                        if(a != null)
                            administrator = a;
                        odgovor.setOdgovor(a);
                        break;
                    
                    case Operacija.UCITAJ_CLANOVE:
                        List<Clan> clanovi = Controller.getInstance().ucitajClanove();
                        odgovor.setOdgovor(clanovi);
                        break;

                    case Operacija.OBRISI_CLANA:
                        try{
                        Clan clan = (Clan) zahtev.getParametar();
                        boolean uspesno = Controller.getInstance().obrisiClana(clan);

                        odgovor.setOdgovor(uspesno);
                        System.out.println("ODGOVOR U OBRADU KLIJENTSKIH: " + odgovor.getOdgovor());
                        break;
                        }catch(Exception e){
                            odgovor.setOdgovor(e);
                            System.out.println("ODGOVOR U OBRADU KLIJENTSKIH: " + odgovor.getOdgovor());
                            break;
                        }
                        
                    case Operacija.DODAJ_CLANA:
                        try{
                        Clan clan = (Clan) zahtev.getParametar();
                        System.out.println("CLAN U OBRADI KOD DODAVANJA:" + clan);
                        Controller.getInstance().dodajClana(clan);
                        odgovor.setOdgovor(null);
                        break;
                        }catch(Exception e){
                            odgovor.setOdgovor(e);
                            break;
                        }
                        
                    case Operacija.DODAJ_TRENERA:
                        try{
                          Trener trener = (Trener) zahtev.getParametar();
                          System.out.println("TRENER U OBRADI KOD DODAVANJA:" + trener);
                          Controller.getInstance().dodajTrenera(trener);
                          odgovor.setOdgovor(null);
                          break;
                        } catch(Exception e){
                            odgovor.setOdgovor(e);
                            break;
                        }
                        
                    case Operacija.DODAJ_GRUPU:
                        try{
                            Grupa grupa = (Grupa) zahtev.getParametar();
                            System.out.println("GRUPA U OBRADI KOD DODAVANJA:" + grupa);
                            Controller.getInstance().dodajGrupu(grupa);
                            odgovor.setOdgovor(null);
                            break;
                        } catch(Exception e){
                            odgovor.setOdgovor(e);
                            break;
                        }
                        
                    case Operacija.DODAJ_TRENING:
                        try{
                            Trening trening = (Trening) zahtev.getParametar();
                            System.out.println("TRENING U OBRADI KOD DODAVANJA:" + trening);
                            Controller.getInstance().dodajTrening(trening);
                            odgovor.setOdgovor(null);
                            break;
                        }catch(Exception e){
                            odgovor.setOdgovor(e);
                            break;
                        }
                        
                    case Operacija.UCITAJ_SALE:
                        List<Sala> sale = Controller.getInstance().ucitajSale();
                        odgovor.setOdgovor(sale);
                        break;
                    case Operacija.UCITAJ_MESTA:
                        List<Mesto> mesta = Controller.getInstance().ucitajMesta();
                        odgovor.setOdgovor(mesta);
                        break;
                        
                    case Operacija.UCITAJ_ADMINISTRATORE:
                        List<Administrator> administratori = Controller.getInstance().ucitajAdministratore();
                        odgovor.setOdgovor(administratori);
                        break;
                        
                    case Operacija.UCITAJ_KATEGORIJE:
                        List<Kategorija> kategorije = Controller.getInstance().ucitajKategorije();
                        odgovor.setOdgovor(kategorije);
                        break;
                        
                    case Operacija.UCITAJ_TRENERE:
                        List<Trener> treneri = Controller.getInstance().ucitajTrenere();
                        odgovor.setOdgovor(treneri);
                        break;
                        
                    case Operacija.AZURIRAJ_CLANA:
                        try{
                        Clan clan = (Clan) zahtev.getParametar();
                        System.out.println("Clan koji je primljen u OKZ: " + clan);
                        boolean update = Controller.getInstance().azurirajClana(clan);
                        odgovor.setOdgovor(update);
                        break;
                        }catch(Exception e){
                            odgovor.setOdgovor(e);
                            break;
                        }
                        
                    case Operacija.UCITAJ_TRENINGE:
                        List<Trening> treninzi = Controller.getInstance().ucitajTreninge();
                        odgovor.setOdgovor(treninzi);
                        System.out.println("U OBRADI LISTA TRENINGA: " + treninzi);
                        break;
                    
                    case Operacija.UCITAJ_GRUPE:
                        List<Grupa> grupe = Controller.getInstance().ucitajGrupe();
                        odgovor.setOdgovor(grupe);
                        System.out.println("U OBRADI LISTA GRUPA: " + grupe);
                        break;
                    
                    case Operacija.LOGOUT:
                        Administrator izloguj = (Administrator) zahtev.getParametar();
                        Controller.getInstance().logout(izloguj);
                        prekiniNit();
                        break;
                    default:
                        System.out.println("Greska, ta operacija ne postoji");
                        break;
                
                }
                System.out.println("Odgovor" + odgovor);
                if(!socket.isClosed())
                     posiljalac.posalji(odgovor);
            }catch (SocketException se) {
            System.out.println("Connection aborted by client or network issue: " + se.getMessage());
            prekiniNit(); // Close the connection and stop the thread
            } 
            catch (Exception ex) {
                Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                prekiniNit(); 
            }
        }
    }
    
        /**
     * Prekida obradu zahteva i zatvara konekciju sa klijentom.
     * <p>
     * Ova metoda postavlja flag {@code kraj} na {@code true}, zatvara socket
     * i prekida nit.
     * </p>
     */
    public void prekiniNit(){
        try {
            kraj = true;
            socket.close(); //Zatvaranje socket-a
            interrupt(); //Prekidanje niti
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        /**
     * Get metoda - Vraća trenutno ulogovanog administratora.
     * 
     * @return Trenutno ulogovani administrator.
     */
    public Administrator getAdministrator() {
        return administrator;
    }

        /**
     * Set metoda - Postavlja trenutno ulogovanog administratora.
     * 
     * @param administrator Trenutno ulogovani administrator.
     */
    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }
    
    
    
}
