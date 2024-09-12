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
public class MestoTest {
    private Mesto mesto;
    public MestoTest() {
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
    }
    
    @After
    public void tearDown() {
    }




    @Test
    public void testSetMestoID() {
        Long noviID = 2L;
        mesto.setMestoID(noviID);
        assertEquals(noviID, mesto.getMestoID());
    }



    @Test
    public void testSetPostanskiBroj() {
        Long noviPostanskiBroj = 17000L;
        mesto.setMestoID(noviPostanskiBroj);
        assertEquals(noviPostanskiBroj, mesto.getMestoID());
    }



    @Test
    public void testSetNaziv() {
        String noviNaziv = "Nis";
        mesto.setNaziv(noviNaziv);
        assertEquals(noviNaziv, mesto.getNaziv());
    }



 
    @Test
    public void testEquals() {
        Mesto drugoMesto = new Mesto(1L,17530L, "Surdulica");
        assertTrue(mesto.equals(drugoMesto));
    }
    
    @Test
    public void testNotEquals() {
        Mesto drugoMesto = new Mesto(2L,17000L, "Nis");
        assertFalse(mesto.equals(drugoMesto));
    }

 
    @Test
    public void testToString() {
        String toString = "Surdulica";
        assertEquals(toString, mesto.getNaziv());
    }

    @Test
    public void testVratiNazivTabele() {
        String naziv = "mesto";
        assertEquals(naziv, mesto.vratiNazivTabele());
    }

    


    @Test
    public void testVratiKoloneZaUbacivanje() {
        //return "postanskiBroj,naziv";
        String kolone = "postanskiBroj,naziv";
        assertEquals(kolone, mesto.vratiKoloneZaUbacivanje());
    }

 
    @Test
    public void testVratiVrednostiZaUbacivanje() {
        //return""+postanskiBroj+",'"+naziv+"'";
        String vrednost = "17530,'Surdulica'";
        assertEquals(vrednost, mesto.vratiVrednostiZaUbacivanje());
    }

 
    @Test
    public void testVratiPrimarniKljuc() {
        //return "mesto.mestoID="+mestoID;
        String primarniKljuc = "mesto.mestoID=1";
        assertEquals(primarniKljuc, mesto.vratiPrimarniKljuc());
    }
    @Test
    public void testVratiVrednostiZaIzmenu() {
        //return "postanskiBroj="+postanskiBroj+", naziv='"+naziv+"'";
        String vrednost = "postanskiBroj=17530, naziv='Surdulica'";
        assertEquals(vrednost, mesto.vratiVrednostiZaIzmenu());
    }
    
}
