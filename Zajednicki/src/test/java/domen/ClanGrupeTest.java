/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package domen;

import domen.Administrator;
import domen.Clan;
import domen.ClanGrupe;
import domen.Grupa;
import domen.Kategorija;
import domen.Mesto;
import domen.Pol;
import domen.Trener;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author Bogdan Blagojevic
 */
public class ClanGrupeTest {

    private ClanGrupe clanGrupe;
    private Clan clan;
    private Grupa grupa;
    private Mesto mesto;
    private Kategorija kategorija;
    private Administrator administrator;
    private Trener trener;
    private Date datumRodjenja = new Date();
    private long milisekunde = datumRodjenja.getTime();
    private Date datum = new Date(milisekunde - 8500000);
    
    public ClanGrupeTest() {   
        
    }
    
    
    @BeforeEach
    public void setUp() {
        mesto = new Mesto(1L, 17530L, "Surdulica");
        clan = new Clan("1234567890123", "Marko", "Markovic", datum, Pol.MUSKI, "0612345678", mesto);
        kategorija = new Kategorija(1L, "Seniori", "Opis", Pol.MUSKI);
        administrator = new Administrator(1L, "BogdanB14", "Bogdan123", "Bogdan", "Blagojevic");
        trener = new Trener(3L, "Uros", "Blagojevic", mesto);
        grupa = new Grupa(1L, "Prvi muski tim", 100, kategorija, administrator, trener);
//        clanGrupe = new ClanGrupe(1, "Libero", "Aktivan", clan, grupa);
        clanGrupe = new ClanGrupe();
        clanGrupe.setRbClana(1);
        clanGrupe.setPozicija("Libero");
        clanGrupe.setStatus("Aktivan");
        clanGrupe.setClan(clan);
        clanGrupe.setGrupa(grupa);
    }
    
    
    @AfterEach
    public void tearDown() {
    }
    
    @Test
    public void testParametarskiKonstruktor() {
        ClanGrupe noviClanGrupe = new ClanGrupe(2, "Pozicija", "Status", clan, grupa);
        assertEquals(2, noviClanGrupe.getRbClana());
        assertEquals("Pozicija", noviClanGrupe.getPozicija());
        assertEquals("Status", noviClanGrupe.getStatus());
        assertEquals(clan, noviClanGrupe.getClan());
        assertEquals(grupa, noviClanGrupe.getGrupa());
    }


    @Test
    public void testSetRbClana() {
        clanGrupe.setRbClana(2);
        assertEquals(2, clanGrupe.getRbClana());
    }
    
    @Test
    void testSetRbClanaNull() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            clanGrupe.setRbClana(0);
        });
        assertEquals("Redni broj clana mora biti veci od 0", exception.getMessage());
    }


    @Test
    public void testSetPozicija() {
        clanGrupe.setPozicija("Korektor");
        assertEquals("Korektor", clanGrupe.getPozicija());
    }
         
         @Test
    void testSetPozicijaNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            clanGrupe.setPozicija(null);
        });
        assertEquals("Pozicija nije u dobrom formatu", exception.getMessage());
    }
    
        @Test
    void testSetPozicijaEmpty() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            clanGrupe.setPozicija("");
        });
        assertEquals("Pozicija nije u dobrom formatu", exception.getMessage());
    }


    @Test
    public void testSetStatus() {
        clanGrupe.setStatus("Neaktivan");
        assertEquals("Neaktivan", clanGrupe.getStatus());
    }
    
    @Test
    void testSetStatusNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            clanGrupe.setStatus(null);
        });
        assertEquals("Status nije u dobrom formatu", exception.getMessage());
    }
    
        @Test
    void testSetStatusEmpty() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            clanGrupe.setStatus("");
        });
        assertEquals("Status nije u dobrom formatu", exception.getMessage());
    }
    
    @Test
     public void testSetClan() {
        Clan noviclan = new Clan("9876543210987", "Jovan", "Jovanovic", datumRodjenja, Pol.MUSKI, "0618765432", mesto);
        clanGrupe.setClan(noviclan);
        assertEquals(noviclan, clanGrupe.getClan());
    }
     
         @Test
    void testSetClanNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            clanGrupe.setClan(null);
        });
        assertEquals("Clan ne sme biti null", exception.getMessage());
    }
    
    @Test
    void testSetGrupa(){
        clanGrupe.setGrupa(grupa);
        assertEquals(clanGrupe.getGrupa(), grupa);
    }
    @Test
    void testSetGrupaNull(){
        Exception exception = assertThrows(NullPointerException.class, () -> {
            clanGrupe.setGrupa(null);
        });
        assertEquals("Grupa ne sme biti null", exception.getMessage());
    }


    @Test
    public void testToString() {
       String toString = "ClanGrupe{rbClana=1, pozicija=Libero, status=Aktivan}";
        assertEquals(toString, clanGrupe.toString());
    }



    @ParameterizedTest
    @CsvSource({
        "1, Vodja, Aktivan, 1, Vodja, Aktivan, true",
        "1, Vodja, Aktivan, 2, Vodja, Aktivan, false",
        "1, Vodja, Aktivan, 1, Nije vodja, Aktivan, false",
        "1, Vodja, Aktivan, 1, Vodja, Pasivan, false",
        "1, Vodja, Aktivan, 2, Nije vodja, Aktivan, false",
        "1, Vodja, Aktivan, 1, Nije vodja, Pasivan, false",
        "1, Vodja, Aktivan, 2, Vodja, Pasivan, false",
        "1, Vodja, Aktivan, 2, Nije vodja, Pasivan, false"
    })
    public void testEquals(int rbClana1, String pozicija1, String status1,
                           int rbClana2, String pozicija2, String status2, boolean tacno) {
        ClanGrupe cg1 = new ClanGrupe(rbClana1, pozicija1, status1, clan, grupa);
        ClanGrupe cg2 = new ClanGrupe(rbClana2, pozicija2, status2, clan, grupa);

        assertEquals(tacno, cg1.equals(cg2));
    }

    @Test
    public void testVratiNazivTabele() {
        assertEquals("clangrupe", clanGrupe.vratiNazivTabele());
    }


    @Test
    public void testVratiKoloneZaUbacivanje() {
        assertEquals("grupa,pozicija,status,clan", clanGrupe.vratiKoloneZaUbacivanje());
    }

    @Test
    public void testVratiVrednostiZaUbacivanje() {
         assertEquals("1,'Libero','Aktivan',1234567890123", clanGrupe.vratiVrednostiZaUbacivanje());
         //return ""+grupa.getGrupaID()+",'"+pozicija+"','"+status+"',"+clan.getJmbg();
    }

    @Test
    public void testVratiPrimarniKljuc() {
        assertEquals("clangrupe.rbClana=1 AND clangrupe.grupa=1", clanGrupe.vratiPrimarniKljuc());
    }


    @Test
    public void testVratiVrednostiZaIzmenu() {
        assertEquals("grupa=1, pozicija='Libero', status='Aktivan', clan=1234567890123", clanGrupe.vratiVrednostiZaIzmenu());
    }
    
}
