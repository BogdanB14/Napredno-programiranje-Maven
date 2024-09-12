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
public class KategorijaTest {
    private Kategorija kategorija;
    public KategorijaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kategorija = new Kategorija(1L, "SENIORI", "Prvotimci", Pol.MUSKI);
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void testSetKategorijaID() {
        Long noviID = 2L;
        kategorija.setKategorijaID(noviID);
        assertEquals(noviID, kategorija.getKategorijaID());
    }


    @Test
    public void testSetNazivKategorije() {
                String noviNaziv = "JUNIORI";
        kategorija.setNazivKategorije(noviNaziv);
        assertEquals(noviNaziv, kategorija.getNazivKategorije());
    }



    @Test
    public void testSetOpisKategorije() {
        String noviOpis = "Novi opis";
        kategorija.setOpisKategorije(noviOpis);
        assertEquals(noviOpis, kategorija.getOpisKategorije());
    }


    @Test
    public void testSetPol() {
        Pol noviPol = Pol.ZENSKI;
        kategorija.setPol(noviPol);
        assertEquals(noviPol, kategorija.getPol());
    }


    @Test
    public void testToString() {
        assertEquals("SENIORI", kategorija.toString());
    }



    @Test
    public void testEquals() {
        Kategorija drugaKategorija = new Kategorija(1L, "SENIORI", "Prvotimci", Pol.MUSKI);
        assertTrue(kategorija.equals(drugaKategorija));
    }
    
    @Test
    public void testNotEquals() {
        Kategorija drugaKategorija = new Kategorija(3L, "PETLICI", "Drugotimci", Pol.MUSKI);
        assertFalse(kategorija.equals(drugaKategorija));
    }


    @Test
    public void testVratiNazivTabele() {
        assertEquals("kategorija", kategorija.vratiNazivTabele());
    }



    @Test
    public void testVratiKoloneZaUbacivanje() {
        assertEquals("nazivKategorije,opisKategorije,pol", kategorija.vratiKoloneZaUbacivanje());
    }


    @Test
    public void testVratiVrednostiZaUbacivanje() {
        String vrednost = "'SENIORI','Prvotimci','MUSKI'";
        assertEquals(vrednost, kategorija.vratiVrednostiZaUbacivanje());
    }

    @Test
    public void testVratiPrimarniKljuc() {
        assertEquals("kategorija.kategorijaID=1", kategorija.vratiPrimarniKljuc());
    }



    @Test
    public void testVratiVrednostiZaIzmenu() {
        String vrednost = "nazivKategorije='SENIORI', opisKategorije='Prvotimci', pol='MUSKI'";
        assertEquals(vrednost, kategorija.vratiVrednostiZaIzmenu());
    }
    
}
