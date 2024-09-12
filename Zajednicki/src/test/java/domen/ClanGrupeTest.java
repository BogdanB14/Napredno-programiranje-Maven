/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public ClanGrupeTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        mesto = new Mesto(1L, 17530L, "Surdulica");
        clan = new Clan("1234567890123", "Marko", "Markovic", datumRodjenja, Pol.MUSKI, "0612345678", mesto);
        kategorija = new Kategorija(1L, "Seniori", "Opis", Pol.MUSKI);
        administrator = new Administrator(1L, "BogdanB14", "Bogdan123", "Bogdan", "Blagojevic");
        trener = new Trener(3L, "Uros", "Blagojevic", mesto);
        grupa = new Grupa(1L, "Prvi muski tim", 100, kategorija, administrator, trener);
        clanGrupe = new ClanGrupe(1, "Libero", "Aktivan", clan, grupa);
    }
    
    @After
    public void tearDown() {
    }



    @Test
    public void testSetRbClana() {
        clanGrupe.setRbClana(2);
        assertEquals(2, clanGrupe.getRbClana());
    }



    @Test
    public void testSetPozicija() {
        clanGrupe.setPozicija("Korektor");
        assertEquals("Korektor", clanGrupe.getPozicija());
    }


    @Test
    public void testSetStatus() {
        clanGrupe.setStatus("Neaktivan");
        assertEquals("Neaktivan", clanGrupe.getStatus());
    }
        
    @Test
     public void testSetClan() {
        Clan noviclan = new Clan("9876543210987", "Jovan", "Jovanovic", datumRodjenja, Pol.MUSKI, "0618765432", mesto);
        clanGrupe.setClan(noviclan);
        assertEquals(noviclan, clanGrupe.getClan());
    }

    @Test
    public void testToString() {
       String toString = "ClanGrupe{rbClana=1, pozicija=Libero, status=Aktivan}";
        assertEquals(toString, clanGrupe.toString());
    }



    /**
     * Test of equals method, of class ClanGrupe.
     */
    @Test
    public void testEquals() {
        ClanGrupe novi = new ClanGrupe(1, "Libero", "Aktivan", clan, grupa);
        assertTrue(clanGrupe.equals(novi));
    }
    
    
    @Test
    public void testNotEquals() {
        ClanGrupe novi = new ClanGrupe(2, "Korektor", "Neaktivan", clan, grupa);
        assertFalse(clanGrupe.equals(novi));
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
