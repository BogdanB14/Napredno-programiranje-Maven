/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package domen;

import java.sql.ResultSet;
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
public class SalaTest {
    private Sala sala;
    private Mesto mesto;
    public SalaTest() {
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
        sala = new Sala(1L, "Jovan Jovanovic Zmaj", 100, mesto);
    }
    
    @After
    public void tearDown() {
    }



    @Test
    public void testSetSalaID() {
        Long noviId = 2L;
        sala.setSalaID(noviId);
        assertEquals(noviId, sala.getSalaID());
    }



    @Test
    public void testSetNazivSale() {
        String noviNaziv = "Vuk Karadzic";
        sala.setNazivSale(noviNaziv);
        assertEquals(noviNaziv, sala.getNazivSale());
    }



    @Test
    public void testSetKapacitet() {
        int novi = 200;
        sala.setKapacitet(novi);
        assertEquals(novi, sala.getKapacitet());
    }




    @Test
    public void testSetMesto() {
        Mesto novo = new Mesto(2L, 17000L, "Nis");
        sala.setMesto(novo);
        assertEquals(novo, sala.getMesto());
    }

    @Test
    public void testToString() {
        String toString = "Jovan Jovanovic Zmaj";
        assertEquals(toString, sala.toString());
    }



    @Test
    public void testEquals() {
        Sala nova = new Sala(1L, "Jovan Jovanovic Zmaj", 100, mesto);
        assertTrue(sala.equals(nova));
    }
    
    
    @Test
    public void testNotEquals() {
        Sala nova = new Sala(2L, "Vuk Karadzic", 100, mesto);
        assertFalse(sala.equals(nova));
    }


    @Test
    public void testVratiNazivTabele() {
        String nazivTabele = "sala";
        assertEquals(nazivTabele, sala.vratiNazivTabele());
    }



    @Test
    public void testVratiKoloneZaUbacivanje() {
        //return "nazivSale,kapacitet,mesto";
        String kolone = "nazivSale,kapacitet,mesto";
        assertEquals(kolone, sala.vratiKoloneZaUbacivanje());
    }


    @Test
    public void testVratiVrednostiZaUbacivanje() {
        //return "'"+nazivSale+"',"+kapacitet+","+mesto.getMestoID();
        System.out.print(sala.vratiVrednostiZaUbacivanje());
        String vrednost = "'Jovan Jovanovic Zmaj',100,1";
        assertEquals(vrednost, sala.vratiVrednostiZaUbacivanje());
    }


    @Test
    public void testVratiPrimarniKljuc() {
         //return "sala.salaID="+salaID;
         String primarniKljuc = "sala.salaID=1";
         assertEquals(primarniKljuc, sala.vratiPrimarniKljuc());
    }



    @Test
    public void testVratiVrednostiZaIzmenu() {
        //return "nazivSale='"+nazivSale+"', kapacitet="+kapacitet+", mesto="+mesto.getMestoID();
        String vrednost = "nazivSale='Jovan Jovanovic Zmaj', kapacitet=100, mesto=1";
        assertEquals(vrednost, sala.vratiVrednostiZaIzmenu());
    }
    
}
