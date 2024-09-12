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
public class TreningTest {
    private Mesto mesto;
    private Sala sala;
    private Trener trener;
    private Administrator administrator;
    private Kategorija kategorija;
    private Grupa grupa;
    private Trening trening;
    private Date datumTreninga = new Date();
    
    public TreningTest() {
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
        trener = new Trener(3L, "Uros", "Blagojevic", mesto);
        sala = new Sala(1L, "Jovan Jovanovic Zmaj", 100, mesto);
        kategorija = new Kategorija(1L, "Seniori", "Opis", Pol.MUSKI);
        administrator = new Administrator(1L, "BogdanB14", "Bogdan123", "Bogdan", "Blagojevic");
        grupa = new Grupa(1L, "Prvi muski tim", 20, kategorija, administrator, trener);
        trening = new Trening(1, datumTreninga, TipTreninga.TERETANA, sala, trener, grupa);
    }
    @After
    public void tearDown() {
    }

    @Test
    public void testSetRbTreninga() {
        int rbTreninga = 2;
        trening.setRbTreninga(rbTreninga);
        assertEquals(rbTreninga, trening.getRbTreninga());
    }


    @Test
    public void testSetDatumTreninga() {
        Date noviDatum = new Date(datumTreninga.getTime() + 86400000); 
        trening.setDatumTreninga(noviDatum);
        assertEquals(noviDatum, trening.getDatumTreninga());
    }


    @Test
    public void testSetTipTreninga() {
        TipTreninga noviTipTreninga = TipTreninga.KONDICIONI;
        trening.setTipTreninga(noviTipTreninga);
        assertEquals(noviTipTreninga, trening.getTipTreninga());
    }

    @Test
    public void testSetSala() {
        Sala novaSala = new Sala(2L, "Nova Sala", 150, mesto);
        trening.setSala(novaSala);
        assertEquals(novaSala, trening.getSala());
    }


    @Test
    public void testSetTrener() {
        Trener noviTrener = new Trener(4L, "Marko", "Markovic", mesto);
        trening.setTrener(noviTrener);
        assertEquals(noviTrener, trening.getTrener());
    }

    @Test
    public void testSetGrupa() {
        Grupa novaGrupa = new Grupa(2L, "Drugi tim", 15, kategorija, administrator, trener);
        trening.setGrupa(novaGrupa);
        assertEquals(novaGrupa, trening.getGrupa());
    }

    @Test
    public void testToString() {
        String toString = "Trening{rbTreninga=1, datumTreninga=" + datumTreninga + ", tipTreninga=TERETANA, sala=" + sala + ", trener=" + trener + ", grupa=" + grupa + '}';
        assertEquals(toString, trening.toString());
    }


    @Test
    public void testEquals() {
        Trening drugi = new Trening(1, datumTreninga, TipTreninga.TERETANA, sala, trener, grupa);
        assertTrue(trening.equals(drugi));
        
        Trening treci = new Trening(2, datumTreninga, TipTreninga.KONDICIONI, sala, trener, grupa);
        assertFalse(trening.equals(treci));
    }

    @Test
    public void testVratiNazivTabele() {
        assertEquals("trening", trening.vratiNazivTabele());
    }

    @Test
    public void testVratiKoloneZaUbacivanje() {
        assertEquals("datumTreninga,tipTreninga,sala,trener,grupa", trening.vratiKoloneZaUbacivanje());
    }

    @Test
    public void testVratiVrednostiZaUbacivanje() {
        java.sql.Date datum = new java.sql.Date(datumTreninga.getTime());
        String vrednost = "'" + datum + "','" + TipTreninga.TERETANA + "'," + sala.getSalaID()+ "," + trener.getTrenerID()+ "," + grupa.getGrupaID();
        assertEquals(vrednost, trening.vratiVrednostiZaUbacivanje());
    }

    @Test
    public void testVratiPrimarniKljuc() {
        assertEquals("trening.rbTreninga=1", trening.vratiPrimarniKljuc());
    }

    @Test
    public void testVratiVrednostiZaIzmenu() {
        String vrednost = "datumTreninga='" + datumTreninga + "', tipTreninga='" + TipTreninga.TERETANA + "', sala=" + sala.getSalaID()+ ", trener=" + trener.getTrenerID()+ ", grupa=" + grupa.getGrupaID();
        assertEquals(vrednost, trening.vratiVrednostiZaIzmenu());
    }
    
}
