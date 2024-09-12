/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package domen;

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
public class AdministratorTest {
    private Administrator administrator;
    public AdministratorTest() {
    }
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        administrator = new Administrator(1L, "BogdanB14", "Bogdan123", "Bogdan", "Blagojevic");

    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test konstruktora uz pomoc getera
     */
      @Test
    public void testKonstruktora() {
        assertTrue(administrator.getAdministratorID() == 1L);
        assertEquals("BogdanB14", administrator.getKorisnickoIme());
        assertEquals("Bogdan123", administrator.getSifra());
        assertEquals("Bogdan", administrator.getImeAdmin());
        assertEquals("Blagojevic", administrator.getPrezimeAdmin());
    }
    
        @Test
    public void testSeteri() {
        administrator.setAdministratorID(2L);
        administrator.setKorisnickoIme("Uros");
        administrator.setSifra("Uros");
        administrator.setImeAdmin("Uros");
        administrator.setPrezimeAdmin("Blagojevic");

        assertTrue(administrator.getAdministratorID() == 2L);
        assertEquals("Uros", administrator.getKorisnickoIme());
        assertEquals("Uros", administrator.getSifra());
        assertEquals("Uros", administrator.getImeAdmin());
        assertEquals("Blagojevic", administrator.getPrezimeAdmin());
    }

    /**
     * Test za equals metodu, administratori se porede po korisnickom imenu i sifri
     * 
     */
    @Test
    public void testEquals() {
        Administrator a1 = new Administrator(3L,"korisnicko1", "sifra1", "Ime1", "Prezime1");
        Administrator a2 = new Administrator(4L, "korisnicko1", "sifra1", "Ime2", "Prezime2");
        
        assertTrue(a1.equals(a2));
        
        Administrator a3 = new Administrator(3L, "korisnicko2", "sifra2", "Ime1", "Prezime1");
        
        assertFalse(a1.equals(a3));
    }

    /**
     * Testiranje metode toString
     */
    @Test
    public void testToString() {
        assertEquals(administrator.toString(), "BogdanB14");
    }

    /**
     * Test za metodu vratiNazivTabele
     */
    @Test
    public void testVratiNazivTabele() {
        assertEquals("administrator", administrator.vratiNazivTabele());
    }



    /**
     * Test za metodu vratiKoloneZaUbacivanje
     */
    @Test
    public void testVratiKoloneZaUbacivanje() {
        assertEquals("korisnickoIme,sifra,imeAdmin,prezimeAdmin", administrator.vratiKoloneZaUbacivanje());
    }

    /**
     * Test za metodu VratiVrednostiZaUbacivanje
     */
    @Test
    public void testVratiVrednostiZaUbacivanje() {
        
        assertEquals("'BogdanB14','Bogdan123','Bogdan','Blagojevic'", administrator.vratiVrednostiZaUbacivanje());
        
    }

    /**
     * Test za metodu vratiPrimarniKljuc
     */
    @Test
    public void testVratiPrimarniKljuc() {
        assertEquals("administrator.administratorID=1", administrator.vratiPrimarniKljuc());
    }

    /**
     * Test za metodu vratiVrednostiZaIzmenu.
     */
    @Test
    public void testVratiVrednostiZaIzmenu() {
        assertEquals("korisnickoIme='BogdanB14', sifra='Bogdan123', imeAdmin='Bogdan', prezimeAdmin='Blagojevic", 
            administrator.vratiVrednostiZaIzmenu());
    }
    
}
