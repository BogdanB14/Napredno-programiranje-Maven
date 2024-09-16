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
public class KategorijaTest {
    private Kategorija kategorija;
    public KategorijaTest() {
    }
    
    @BeforeEach
    public void setUp() {
        kategorija = new Kategorija();
        kategorija.setKategorijaID(1L);
        kategorija.setNazivKategorije("SENIORI");
        kategorija.setOpisKategorije("Prvotimci");
        kategorija.setPol(Pol.MUSKI);
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @Test
    public void testParametarskiKonstruktor() {
        
        Kategorija k = new Kategorija(1L, "PIONIRI", "Drugi tim", Pol.ZENSKI);
        assertEquals(1L, k.getKategorijaID());
        assertEquals("PIONIRI", k.getNazivKategorije());
        assertEquals("Drugi tim", k.getOpisKategorije());
        assertEquals(Pol.ZENSKI, k.getPol());
    }


    @Test
    public void testSetKategorijaID() {
        Long noviID = 2L;
        kategorija.setKategorijaID(noviID);
        assertEquals(noviID, kategorija.getKategorijaID());
    }
    
    @Test
    public void testSetKategorijaManjiOd1() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            kategorija.setKategorijaID(0L);
        });
        assertEquals("ID kategorije mora biti veci od 0", exception.getMessage());
    }


    @Test
    public void testSetNazivKategorije() {
                String noviNaziv = "JUNIORI";
        kategorija.setNazivKategorije(noviNaziv);
        assertEquals(noviNaziv, kategorija.getNazivKategorije());
    }
    
    
    @Test
    public void testSetNazivKategorijeEmpty() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            kategorija.setNazivKategorije("");
        });
        assertEquals("Naziv nije u odgovarajucem formatu", exception.getMessage());
    }
    
        @Test
    public void testSetNazivKategorijeSapce() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            kategorija.setNazivKategorije(" ");
        });
        assertEquals("Naziv nije u odgovarajucem formatu", exception.getMessage());
    }
    
        @Test
    public void testSetNazivKategorijeNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            kategorija.setNazivKategorije(null);
        });
        assertEquals("Naziv nije u odgovarajucem formatu", exception.getMessage());
    }



    @Test
    public void testSetOpisKategorije() {
        String noviOpis = "Novi opis";
        kategorija.setOpisKategorije(noviOpis);
        assertEquals(noviOpis, kategorija.getOpisKategorije());
    }
    
    @Test
    public void testSetOpisKategorijeSpacew() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            kategorija.setOpisKategorije(" ");
        });
        assertEquals("Opis kategorije nije u odgovarajucem formatu", exception.getMessage());
    }
    
    @Test
    public void testSetOpisKategorijeNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            kategorija.setOpisKategorije(null);
        });
        assertEquals("Opis kategorije nije u odgovarajucem formatu", exception.getMessage());
    }
    
    @Test
    public void testSetOpisKategorijeEmpty() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            kategorija.setOpisKategorije("");
        });
        assertEquals("Opis kategorije nije u odgovarajucem formatu", exception.getMessage());
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


//Kategorija k = new Kategorija(1L, "PIONIRI", "Drugi tim", Pol.ZENSKI);
    @ParameterizedTest
    @CsvSource({
        "1, SENIORI, Prvi tim, MUSKI, 1, SENIORI, Prvi tim, MUSKI, true",
        "2, SENIORI, Prvi tim, MUSKI, 1, SENIORI, Prvi tim, MUSKI, false"
    })
    public void Equals(Long kategorijaID1, String nazivKategorije1, String opisKategorije1, String polKategorije1, Long kategorijaID2, String nazivKategorije2, String opisKategorije2, String polKategorije2, boolean tacno){
        Kategorija k1 = new Kategorija(kategorijaID1, nazivKategorije1, opisKategorije1, Pol.valueOf(polKategorije1));
        Kategorija k2 = new Kategorija(kategorijaID2, nazivKategorije2, opisKategorije2, Pol.valueOf(polKategorije1));
        
        assertEquals(tacno, k1.equals(k2));
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
