/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kordinator;

import domen.Administrator;
import forme.DodajClanaForma;
import forme.DodajGrupuForma;
import forme.DodajTreneraForma;
import forme.DodajTreningForma;
import forme.GlavnaForma;
import forme.LoginForma;
import forme.ModFormeClan;
import forme.PrikazClanaForma;
import forme.PrikazGrupaForma;
import forme.PrikazTreningForma;
import java.util.HashMap;
import java.util.Map;
import kontroleri.DodajClanaController;
import kontroleri.DodajGrupuController;
import kontroleri.DodajTreneraController;
import kontroleri.DodajTreningController;
import kontroleri.GlavnaFormaController;
import kontroleri.LoginController;
import kontroleri.PrikazClanaController;
import kontroleri.PrikazGrupaController;
import kontroleri.PrikazTreningaController;

/**
 * Kordinator je singleton klasa koja koordinira otvaranjem formi i upravljanjem podacima
 * unutar aplikacije. Ova klasa služi kao osnovni kontroler koji kontroliše formu za prijavu,
 * glavnu formu i druge funkcionalnosti kao što su prikaz članova, grupa i treninga, 
 * kao i dodavanje novih članova, trenera, grupa i treninga.
 * 
 * <p>Kordinator klasa upravlja interakcijom između korisničkog interfejsa (forme)
 * i specijalizovanih kontrolera. Ova klasa takođe čuva informacije o trenutno ulogovanom administratoru
 * i sadrži mehanizam za prosleđivanje parametara između različitih delova aplikacije.</p>
 * 
 * @author Bogdan Blagojevic
 */
public class Kordinator {
    private static Kordinator instanca;
    private Administrator ulogovani;
    private LoginController loginController;
    private GlavnaFormaController glavnaFormaController;
    private PrikazClanaController prikazClanaController;
    private DodajClanaController dodajClanaController;
    private PrikazGrupaController prikazGrupaController;
    private PrikazTreningaController prikazTreningaController;
    private DodajTreneraController dodajTreneraController;
    private DodajGrupuController dodajGrupuController;
    private DodajTreningController dodajTreningController;
    private Map<String, Object> parametri;
    
    
        /**
     * Vraća instancu klase Kordinator.
     * Ukoliko instanca ne postoji, kreira se nova.
     * 
     * @return instanca klase Kordinator
     */
    public static Kordinator getInstanca(){
        if(instanca == null)
            instanca = new Kordinator();
        return instanca;
    }
    
        /**
     * Privatni konstruktor koji kreira mapu parametara.
     * Konstruktori su privatni kako bi se obezbedila primena Singleton šablona.
     */
    private Kordinator(){
        parametri = new HashMap<>();
    }

        /**
     * Otvara formu za prijavu i kreira novi LoginController.
     */
    public void otvoriLoginFormu() {
        loginController = new LoginController(new LoginForma());
        loginController.otvoriFormu();
        
    }

        /**
     * Otvara glavnu formu i kreira novi GlavnaFormaController.
     */
    public void otvoriGlavnuFormu() {
        glavnaFormaController = new GlavnaFormaController(new GlavnaForma());
        glavnaFormaController.otvoriFormu();
        
    }

    /**
     * Otvara formu za prikaz članova i kreira novi PrikazClanaController.
     */
    public void otvoriPrikazClanaFormu() {
        prikazClanaController = new PrikazClanaController(new PrikazClanaForma());
        prikazClanaController.otvoriFormu();
    }
    
        /**
     * Vraća trenutno ulogovanog administratora.
     * 
     * @return ulogovani administrator
     */
    public Administrator getUlogovani() {
        return ulogovani;
    }

        /**
     * Postavlja trenutno ulogovanog administratora.
     * 
     * @param ulogovani administrator koji se postavlja
     */
    public void setUlogovani(Administrator ulogovani) {
        this.ulogovani = ulogovani;
    }

        /**
     * Otvara formu za dodavanje novog člana i kreira novi DodajClanaController.
     * Postavlja formu u mod za dodavanje.
     */
    public void otvoriDodajClanaFormu() {
        dodajClanaController = new DodajClanaController(new DodajClanaForma());
        dodajClanaController.otvoriFormu(ModFormeClan.DODAJ);
        dodajClanaController.pripremiFormu(ModFormeClan.DODAJ);
        
    }


        /**
     * Otvara formu za dodavanje novog trenera i kreira novi DodajTreneraController.
     */
    public void otvoriDodajTreneraFormu() {
        System.out.println("USAO U OTVORI DODAJ TRENERA FORMU");
        dodajTreneraController = new DodajTreneraController(new DodajTreneraForma());
        dodajTreneraController.otvoriFormu();

    }
    
    
        /**
     * Osvežava tabelu članova pozivanjem metode za pripremu forme.
     */
    public void osveziTabeluClanova() {
        prikazClanaController.pripremiFormu();
    }
    
    
    /**
     * Dodaje parametar u mapu parametara.
     * 
     * @param s ključno ime parametra
     * @param o vrednost parametra
     */
    public void dodajParam(String s, Object o){
        parametri.put(s, o);
    }
    
        /**
     * Vraća parametar iz mape parametara na osnovu prosleđenog ključa.
     * 
     * @param s ključno ime parametra
     * @return vrednost parametra
     */
    public Object vratiParam(String s){
        return parametri.get(s);
    }

       /**
     * Otvara formu za izmenu člana i postavlja formu u mod za izmenu.
     */
    public void otvoriIzmeniClanaFormu() {
        dodajClanaController = new DodajClanaController(new DodajClanaForma());
        dodajClanaController.otvoriFormu(ModFormeClan.IZMENI);
    }

        /**
     * Osvežava glavnu formu pozivanjem metode za pripremu forme za članove.
     */
    public void osveziGlavnuFormu() {
        prikazClanaController.pripremiFormu();
    }
    
        /**
     * Otvara formu za prikaz grupa i kreira novi PrikazGrupaController.
     */
    public void otvoriPrikazGrupaFormu(){
        prikazGrupaController = new PrikazGrupaController(new PrikazGrupaForma());
        prikazGrupaController.otvoriFormu();
    }
    
        /**
     * Otvara formu za prikaz treninga i kreira novi PrikazTreningaController.
     */
    public void otvoriPrikazTreningaFormu(){
        prikazTreningaController = new PrikazTreningaController(new PrikazTreningForma());
        prikazTreningaController.otvoriFormu();
    }
    /**
     * Otvara formu za dodavanje nove grupe i kreira novi DodajGrupuController.
     */
    public void otvoriDodajGrupuForma() {
        dodajGrupuController = new DodajGrupuController(new DodajGrupuForma());
        dodajGrupuController.otvoriFormu();
    }

        /**
     * Otvara formu za dodavanje novog treninga i kreira novi DodajTreningController.
     */
    public void otvoriDodajTreningFormu() {
        System.out.println("USAO U OTVORI DODAJ TRENING FORMU U KORDINATORU");
        dodajTreningController = new DodajTreningController(new DodajTreningForma());
        dodajTreningController.otvoriFormu();
    }

}
