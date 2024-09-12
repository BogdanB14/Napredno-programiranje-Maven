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
public class GrupaTest {
    private Kategorija kategorija;
    private Administrator administrator;
    private Trener trener;
    private Mesto mesto;
    private Grupa grupa;
    public GrupaTest() {
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
         kategorija = new Kategorija(1L, "Seniori", "Opis", Pol.MUSKI);
         administrator = new Administrator(1L, "BogdanB14", "Bogdan123", "Bogdan", "Blagojevic");
         trener = new Trener(3L, "Uros", "Blagojevic", mesto);
         grupa = new Grupa(1L, "Prvi muski tim", 20, kategorija, administrator, trener);
    }
    
    @After
    public void tearDown() {
    }



    @Test
    public void testSetGrupaID() {
                Long noviID = 2L;
        grupa.setGrupaID(noviID);
        assertEquals(noviID, grupa.getGrupaID());

    }



    @Test
    public void testSetNazivGrupe() {
        String noviNaziv = "Drugi muski tim";
        grupa.setNazivGrupe(noviNaziv);
        assertEquals(noviNaziv, grupa.getNazivGrupe());
    }


    @Test
    public void testSetBrClanova() {
        int brClanova = 25;
        grupa.setBrClanova(brClanova);
        assertEquals(brClanova, grupa.getBrClanova());
    }

    @Test
    public void testSetKategorija() {
        Kategorija novaKategorija = new Kategorija(2L, "Juniori", "Opis", Pol.MUSKI);
        grupa.setKategorija(novaKategorija);
        assertEquals(novaKategorija, grupa.getKategorija());

    }



    @Test
    public void testSetAdministrator() {
        Administrator noviAdmin = new Administrator(2L, "Vladica70", "Vladica70", "Vladica", "Blagojevic");
        grupa.setAdministrator(noviAdmin);
        assertEquals(noviAdmin, grupa.getAdministrator());
    }

    @Test
    public void testSetTrener() {
        Mesto novoMesto = new Mesto(2L, 17000L, "Nis");
        Trener noviTrener = new Trener(4L, "Aleksa", "Pesic", novoMesto);
        grupa.setTrener(noviTrener);
        assertEquals(noviTrener, grupa.getTrener());
    }

    /**
     * Test of equals method, of class Grupa.
     */
    @Test
    public void testEquals() {
        Grupa novaGrupa = new Grupa(1L, "Prvi muski tim", 20, kategorija, administrator, trener);
        assertTrue(grupa.equals(novaGrupa));
    }

    @Test
    public void testNotEquals() {
         Grupa novaGrupa = new Grupa(2L, "Drugi muski tim", 15, kategorija, administrator, trener);
        assertFalse(grupa.equals(novaGrupa));
    }

    @Test
    public void testToString() {
        assertEquals("Prvi muski tim", grupa.toString());
    }

    @Test
    public void testVratiNazivTabele() {
        assertEquals("grupa", grupa.vratiNazivTabele());
    }

    @Test
    public void testVratiListu() throws Exception {

    }

    @Test
    public void testVratiKoloneZaUbacivanje() {
        assertEquals("nazivGrupe,brClanova,kategorija,administrator,trener", grupa.vratiKoloneZaUbacivanje());
    }

    @Test
    public void testVratiVrednostiZaUbacivanje() {
        String vrednosti = "'Prvi muski tim',20,1,1,3";
        assertEquals(vrednosti, grupa.vratiVrednostiZaUbacivanje());
    }

    @Test
    public void testVratiPrimarniKljuc() {
        assertEquals("grupa.grupaID=1", grupa.vratiPrimarniKljuc());
    }


    @Test
    public void testVratiVrednostiZaIzmenu() {
        String vrednosti = "nazivGrupe='Prvi muski tim', brClanova=20, kategorija=1 ,administrator=1, trener=3";
        assertEquals(vrednosti, grupa.vratiVrednostiZaIzmenu());
    }
    
}
