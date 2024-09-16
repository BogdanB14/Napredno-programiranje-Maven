/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;

/**
 * Interfejs koji definiše osnovne operacije za rad sa entitetima u bazi podataka.
 * <p>
 * Ovaj interfejs definiše generičke metode za CRUD (Create, Read, Update, Delete) operacije
 * nad entitetima tipa {@code T}. Implementacije ovog interfejsa omogućavaju rad sa različitim
 * modelima podataka.
 * </p>
 * 
 * @param <T> Tip entiteta sa kojim se radi.
 */
public interface Repository<T> {
    /**
     * Pretražuje sve entitete u bazi podataka na osnovu uslova.
     * 
     * @param param Parametar koji definiše tip entiteta za pretragu.
     * @param uslov SQL uslov za filtriranje rezultata pretrage.
     * @return Lista entiteta koji odgovaraju uslovima pretrage.
     * @throws Exception Ako dođe do greške prilikom pretrage.
     */
    List<T> getAll(T param, String uslov) throws Exception; //Претрага
    /**
     * Dodaje novi entitet u bazu podataka.
     * 
     * @param param Entitet koji se dodaje.
     * @throws Exception Ako dođe do greške prilikom dodavanja.
     */
    void add(T param) throws Exception; //Radi insert operaciju
    
    /**
     * Ažurira postojeći entitet u bazu podataka.
     * 
     * @param param Entitet koji se ažurira.
     * @return {@code true} ako je ažuriranje uspešno, {@code false} inače.
     * @throws Exception Ako dođe do greške prilikom ažuriranja.
     */
    boolean edit(T param) throws Exception; //Radi update operaciju nad parametrom T
    
    /**
     * Briše entitet iz baze podataka.
     * 
     * @param param Entitet koji se briše.
     * @return {@code true} ako je brisanje uspešno, {@code false} inače.
     * @throws Exception Ako dođe do greške prilikom brisanja.
     */
    boolean delete(T param) throws Exception; //Radi se delete operacija nad parametrom T koji moze biti bilo koji objekat iz modela
    
    /**
     * Vraća sve entitete iz skladišta podataka.
     * 
     * @return Lista svih entiteta.
     */
    List<T> getAll(); //Vraca sve objekte iz liste
    
    
}
