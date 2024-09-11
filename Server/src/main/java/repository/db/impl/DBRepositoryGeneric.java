/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import domen.ApstraktniDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;
import repository.db.DBConnectionFactory;
import repository.db.DBRepository;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * Generička implementacija {@link DBRepository} za rad sa entitetima tipa {@link ApstraktniDomenskiObjekat}.
 * Predstavlja implementaciju metoda za manipulaciju bazom podataka za objekte iz zajednickog projekta iz klase domen
 * <p>
 * Ova klasa pruža osnovne operacije za rad sa bazom podataka, uključujući pretragu, dodavanje,
 * ažuriranje i brisanje entiteta. Koristi {@code Statement} za izvršavanje SQL upita i {@code ResultSet}
 * za obrada rezultata pretrage.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class DBRepositoryGeneric implements DBRepository<ApstraktniDomenskiObjekat> {

        /**
     * Vraća sve entitete koji odgovaraju uslovima iz baze podataka.
     * 
     * @param param Entitet koji se koristi za formiranje SQL upita.
     * @param uslov SQL uslov za filtriranje rezultata.
     * @return Lista entiteta koji odgovaraju uslovima pretrage.
     * @throws Exception Ako dođe do greške prilikom pretrage.
     */
    @Override
    public List<ApstraktniDomenskiObjekat> getAll(ApstraktniDomenskiObjekat param, String uslov) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        
        String upit = "SELECT * FROM " + param.vratiNazivTabele();
        if(uslov != null){
            upit += uslov;
        }
        System.out.println(upit);
        
        Statement st = DBConnectionFactory.getInstance().getConnection().createStatement();
        ResultSet rs = st.executeQuery(upit);
        lista = param.vratiListu(rs);
        
        rs.close();
        st.close();
        
        return lista;
    }

        /**
     * Dodaje novi entitet u bazu podataka.
     * 
     * @param param Entitet koji se dodaje.
     * @throws Exception Ako dođe do greške prilikom dodavanja.
     */
    @Override
    public void add(ApstraktniDomenskiObjekat param) throws Exception {
        String upit = "INSERT INTO " + param.vratiNazivTabele() + " (" + param.vratiKoloneZaUbacivanje() + ") VALUES (" + param.vratiVrednostiZaUbacivanje() + ")";
        System.out.println(upit);
        Statement st = DBConnectionFactory.getInstance().getConnection().createStatement();
        st.executeUpdate(upit);
        System.out.println(upit);
        st.close();
    }

        /**
     * Ažurira postojeći entitet u bazi podataka.
     * 
     * @param param Entitet koji se ažurira.
     * @return {@code true} ako je ažuriranje uspešno, {@code false} inače.
     * @throws Exception Ako dođe do greške prilikom ažuriranja.
     */
    @Override
    public boolean edit(ApstraktniDomenskiObjekat param) throws Exception {
        System.out.println("Usao u edit!");
        String upit = "UPDATE " + param.vratiNazivTabele() + " SET " + param.vratiVrednostiZaIzmenu();
        System.out.println(upit);
        Statement st = DBConnectionFactory.getInstance().getConnection().createStatement();
        int affectedRows = st.executeUpdate(upit);
        commit();
        st.close();
        return affectedRows > 0;
    }

        /**
     * Briše entitet iz baze podataka.
     * 
     * @param param Entitet koji se briše.
     * @return {@code true} ako je brisanje uspešno, {@code false} inače.
     * @throws Exception Ako dođe do greške prilikom brisanja.
     */
    @Override
    public boolean delete(ApstraktniDomenskiObjekat param) throws Exception {
        String upit = "DELETE FROM " + param.vratiNazivTabele() + " WHERE " + param.vratiPrimarniKljuc();
        System.out.println(upit);
        Statement st = DBConnectionFactory.getInstance().getConnection().createStatement();
        int a = st.executeUpdate(upit);
        
        st.close();        
        return a > 0;
    }

    @Override
    public List<ApstraktniDomenskiObjekat> getAll() {
        return null; //TODO
    }
    
    
}
