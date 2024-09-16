/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package domen;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Test klasa domenske klase Administrator.
 * @author Bogdan Blagojevic
 */
public class AdministratorTest {
    private Administrator administrator;
    public AdministratorTest() {
    }
    
    
    
    @BeforeEach
    public void setUp() {
        administrator = new Administrator();
        administrator.setAdministratorID(1L);
        administrator.setKorisnickoIme("BogdanB14");
        administrator.setSifra("Bogdan123");
        administrator.setImeAdmin("Bogdan");
        administrator.setPrezimeAdmin("Blagojevic");
    }
    
    @AfterEach
    public void tearDown() {
    }


      @Test
    public void testKonstruktora() {
        assertTrue(administrator.getAdministratorID() == 1L);
        assertEquals("BogdanB14", administrator.getKorisnickoIme());
        assertEquals("Bogdan123", administrator.getSifra());
        assertEquals("Bogdan", administrator.getImeAdmin());
        assertEquals("Blagojevic", administrator.getPrezimeAdmin());
    }
    

    @Test
    public void testSetAdministrator() {
        administrator.setAdministratorID(2L);
        assertEquals(Long.valueOf(2L), administrator.getAdministratorID());
    }
    

    @Test
    public void testSetAdministratorIDException() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            administrator.setAdministratorID(-1L);
        });
        assertEquals("ID mora biti veci od 0", exception.getMessage());
    }
    

    @Test
    public void testSetKorisnickoIme() {
        administrator.setKorisnickoIme("Uros");
        assertEquals("Uros", administrator.getKorisnickoIme());
    }
    

    @Test
    public void testSetSifra() {
        administrator.setSifra("Uros123");
        assertEquals("Uros123", administrator.getSifra());
    }
    

    @Test
    public void testSetSifraException() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            administrator.setSifra(null);
        });
        assertEquals("Sifra nije u dobrom formatu", exception.getMessage());
    }
    

    @Test
    public void testSetKorisnickoImeException() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            administrator.setKorisnickoIme(null);
        });
        assertEquals("Korisnicko ime nije u dobrom formatu", exception.getMessage());
    }
    

    @Test
    public void testSetImeAdminExcecption() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            administrator.setImeAdmin(null);
        });
        assertEquals("Ime nije u dobrom formatu", exception.getMessage());
    }

    @Test
    public void testSetPrezimeAdminValid() {
        administrator.setPrezimeAdmin("Blagojevic");
        assertEquals("Blagojevic", administrator.getPrezimeAdmin());
    }
    
 
    @Test
    public void testSetPrezimeAdminException() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            administrator.setPrezimeAdmin(null);
        });
        assertEquals("Prezime nije u dobrom formatu", exception.getMessage());
    }

    @Test
    public void testSetImeAdminValid() {
        administrator.setImeAdmin("Uros");
        assertEquals("Uros", administrator.getImeAdmin());
    }

    
    @ParameterizedTest
    @CsvSource({
        "1, korisnicko1, sifra1, 2, korisnicko1, sifra1, true",  // Očekujemo true jer su korisničko ime i lozinka isti
        "1, korisnicko1, sifra1, 2, korisnicko2, sifra1, false", // Očekujemo false jer su različita korisnička imena
        "1, korisnicko1, sifra1, 2, korisnicko1, sifra2, false", // Očekujemo false jer su lozinke različite
        "1, korisnicko1, sifra1, 1, korisnicko1, sifra1, true",  // Očekujemo true jer su sve vrednosti iste
        "1, korisnicko1, sifra1, 1, korisnicko2, sifra2, false"  // Očekujemo false jer su sve različite vrednosti
    })
    public void testEquals(long id1, String korisnickoIme1, String sifra1,
                           long id2, String korisnickoIme2, String sifra2, boolean tacno) {
        Administrator a1 = new Administrator(id1, korisnickoIme1, sifra1, "Ime1", "Prezime1");
        Administrator a2 = new Administrator(id2, korisnickoIme2, sifra2, "Ime2", "Prezime2");

        assertEquals(tacno, a1.equals(a2));
    }


    @Test
    public void testToString() {
        assertEquals(administrator.toString(), "BogdanB14");
    }


    @Test
    public void testVratiNazivTabele() {
        assertEquals("administrator", administrator.vratiNazivTabele());
    }




    @Test
    public void testVratiKoloneZaUbacivanje() {
        assertEquals("korisnickoIme,sifra,imeAdmin,prezimeAdmin", administrator.vratiKoloneZaUbacivanje());
    }

    @Test
    public void testVratiVrednostiZaUbacivanje() {
        
        assertEquals("'BogdanB14','Bogdan123','Bogdan','Blagojevic'", administrator.vratiVrednostiZaUbacivanje());
        
    }


    @Test
    public void testVratiPrimarniKljuc() {
        assertEquals("administrator.administratorID=1", administrator.vratiPrimarniKljuc());
    }


    @Test
    public void testVratiVrednostiZaIzmenu() {
        assertEquals("korisnickoIme='BogdanB14', sifra='Bogdan123', imeAdmin='Bogdan', prezimeAdmin='Blagojevic", 
            administrator.vratiVrednostiZaIzmenu());
    }
    
}
