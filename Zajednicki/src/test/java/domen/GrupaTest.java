/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.List;
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
public class GrupaTest {
    private Kategorija kategorija;
    private Administrator administrator;
    private Trener trener;
    private Mesto mesto;
    private Grupa grupa;
    public GrupaTest() {
    }
    

    
    @BeforeEach
    public void setUp() {
         mesto = new Mesto(1L, 17530L, "Surdulica");
         kategorija = new Kategorija(1L, "Seniori", "Opis", Pol.MUSKI);
         administrator = new Administrator(1L, "BogdanB14", "Bogdan123", "Bogdan", "Blagojevic");
         trener = new Trener(3L, "Uros", "Blagojevic", mesto);
         grupa = new Grupa();
         grupa.setGrupaID(1L);
         grupa.setNazivGrupe("Prvi muski tim");
         grupa.setBrClanova(20);
         grupa.setKategorija(kategorija);
         grupa.setAdministrator(administrator);
         grupa.setTrener(trener);
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @Test
    public void testParametarskiKonstruktor() {
        Grupa novaGrupa = new Grupa(1L, "Grupa A", 10, kategorija, administrator, trener);
        
        assertEquals(1L, novaGrupa.getGrupaID());
        assertEquals("Grupa A", novaGrupa.getNazivGrupe());
        assertEquals(10, novaGrupa.getBrClanova());
        assertEquals(kategorija, novaGrupa.getKategorija());
        assertEquals(administrator, novaGrupa.getAdministrator());
        assertEquals(trener, novaGrupa.getTrener());
    }


    @Test
    public void testSetGrupaID() {
                Long noviID = 2L;
        grupa.setGrupaID(noviID);
        assertEquals(noviID, grupa.getGrupaID());

    }

        @Test
    public void testSetGrupaManjeOd1() {
        Exception exception = assertThrows(RuntimeException.class, () -> grupa.setGrupaID(0L));
        assertEquals("ID grupe mora biti vece od 0", exception.getMessage());
    }


    @Test
    public void testSetNazivGrupe() {
        String noviNaziv = "Drugi muski tim";
        grupa.setNazivGrupe(noviNaziv);
        assertEquals(noviNaziv, grupa.getNazivGrupe());
    }
    
    @Test
    public void testSetNazivGrupeNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> grupa.setNazivGrupe(null));
        assertEquals("Naziv grupe nije u dobrom formatu", exception.getMessage());

        exception = assertThrows(NullPointerException.class, () -> grupa.setNazivGrupe("   "));
        assertEquals("Naziv grupe nije u dobrom formatu", exception.getMessage());
        
        exception = assertThrows(NullPointerException.class, () -> grupa.setNazivGrupe(""));
        assertEquals("Naziv grupe nije u dobrom formatu", exception.getMessage());
    }


    @Test
    public void testSetBrClanova() {
        int brClanova = 25;
        grupa.setBrClanova(brClanova);
        assertEquals(brClanova, grupa.getBrClanova());
    }
    
        @Test
    public void testSetBrClanovaManjiOd1() {
        Exception exception = assertThrows(RuntimeException.class, () -> grupa.setBrClanova(0));
        assertEquals("Broj clanova mora biti veci od 0", exception.getMessage());
    }

    @Test
    public void testSetKategorija() {
        Kategorija novaKategorija = new Kategorija(2L, "Juniori", "Opis", Pol.MUSKI);
        grupa.setKategorija(novaKategorija);
        assertEquals(novaKategorija, grupa.getKategorija());
    }
    
        @Test
    public void testSetKategorijaNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> grupa.setKategorija(null));
        assertEquals("Kategorija ne sme biti null", exception.getMessage());
    }



    @Test
    public void testSetAdministrator() {
        Administrator noviAdmin = new Administrator(2L, "Vladica70", "Vladica70", "Vladica", "Blagojevic");
        grupa.setAdministrator(noviAdmin);
        assertEquals(noviAdmin, grupa.getAdministrator());
    }
    
    @Test
    public void testSetAdministratorNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> grupa.setAdministrator(null));
        assertEquals("Administrator ne sme biti null", exception.getMessage());
    }

    @Test
    public void testSetTrener() {
        Mesto novoMesto = new Mesto(2L, 17000L, "Nis");
        Trener noviTrener = new Trener(4L, "Aleksa", "Pesic", novoMesto);
        grupa.setTrener(noviTrener);
        assertEquals(noviTrener, grupa.getTrener());
    }
    
        @Test
    public void testSetTrenerNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> grupa.setTrener(null));
        assertEquals("Trener ne sme biti null", exception.getMessage());
    }

  @ParameterizedTest
    @CsvSource({
        "1, Grupa A, 1, Grupa A, true",   
        "1, Grupa A, 2, Grupa A, false",  
        "1, Grupa A, 1, Grupa B, false",  
        "1, Grupa A, 2, Grupa B, false"   
    })
    public void testEquals(Long grupaID1, String naziv1, Long grupaID2, String naziv2, boolean tacno) {
        Grupa g1 = new Grupa(grupaID1, naziv1, 10, kategorija, administrator, trener);
        Grupa g2 = new Grupa(grupaID2, naziv2, 10, kategorija, administrator, trener);

        assertEquals(tacno, g1.equals(g2));
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
