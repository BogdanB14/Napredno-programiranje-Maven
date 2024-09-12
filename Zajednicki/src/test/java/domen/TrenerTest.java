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
public class TrenerTest {
    private Mesto mesto;
    private Trener trener;
    public TrenerTest() {
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
        trener = new Trener(1l, "Bogdan", "Blagojevic", mesto);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSetTrenerID() {
        Long noviID = 2L;
        trener.setTrenerID(noviID);
        assertEquals(noviID, trener.getTrenerID());
    }


    @Test
    public void testSetImeTrener() {
        String novoIme = "Marko";
        trener.setImeTrener(novoIme);
        assertEquals(novoIme, trener.getImeTrener());
    }



    @Test
    public void testSetPrezimeTrener() {
        String novoPrezime = "Markovic";
        trener.setPrezimeTrener(novoPrezime);
        assertEquals(novoPrezime, trener.getPrezimeTrener());
    }


    @Test
    public void testSetMesto() {
        Mesto novoMesto = new Mesto(2L, 17000L, "Nis");
        trener.setMesto(novoMesto);
        assertEquals(novoMesto, trener.getMesto());
    }


    @Test
    public void testToString() {
        String toString = "Bogdan Blagojevic";
        assertEquals(toString, trener.toString());
    }


 
    @Test
    public void testEquals() {
        Trener drugi = new Trener(1L, "Bogdan", "Blagojevic", mesto);
        assertTrue(trener.equals(drugi));

        Trener treci = new Trener(2L, "Marko", "Markovic", mesto);
        assertFalse(trener.equals(treci));

    }

  
    @Test
    public void testVratiNazivTabele() {
       String naziv = "trener";
        assertEquals(naziv, trener.vratiNazivTabele());
    }




    @Test
    public void testVratiKoloneZaUbacivanje() {
         String kolone = "imeTrener,prezimeTrener,mesto";
        assertEquals(kolone, trener.vratiKoloneZaUbacivanje());
    }

    @Test
    public void testVratiVrednostiZaUbacivanje() {
        String vrednost = "'Bogdan','Blagojevic',1";
        assertEquals(vrednost, trener.vratiVrednostiZaUbacivanje());
    }


    @Test
    public void testVratiPrimarniKljuc() {
        String primarniKljuc = "trener.trenerID=1";
        assertEquals(primarniKljuc, trener.vratiPrimarniKljuc());
    }



    @Test
    public void testVratiVrednostiZaIzmenu() {
        String izmena = "imeTrener='Bogdan', prezimeTrener='Blagojevic', mesto=1";
        assertEquals(izmena, trener.vratiVrednostiZaIzmenu());
    }
    
}
