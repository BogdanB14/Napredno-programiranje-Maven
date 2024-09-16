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
public class MestoTest {
    private Mesto mesto;
    public MestoTest() {
    }
    
    @BeforeEach
    public void setUp() {
        mesto = new Mesto();
        mesto.setMestoID(1L);
        mesto.setPostanskiBroj(17530L);
        mesto.setNaziv("Surdulica");
    }
    
    @AfterEach
    public void tearDown() {
    }
    
        @Test
    public void testParametarskiKonstruktor() {
        Mesto m = new Mesto(2L, 17000L, "Nis");
        assertEquals(2L, m.getMestoID());
        assertEquals(17000L, m.getPostanskiBroj());
        assertEquals("Nis", m.getNaziv());
    }




    @Test
    public void testSetMestoID() {
        Long noviID = 2L;
        mesto.setMestoID(noviID);
        assertEquals(noviID, mesto.getMestoID());
    }
    
    @Test
    public void testSetMestoIDException() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            mesto.setMestoID(0L);
        });
        assertEquals("ID mesta mora biti vece od 0", exception.getMessage());
    }



    @Test
    public void testSetPostanskiBroj() {
        Long noviPostanskiBroj = 17000L;
        mesto.setMestoID(noviPostanskiBroj);
        assertEquals(noviPostanskiBroj, mesto.getMestoID());
    }

        @Test
    public void testSetPostanskiBrojManji() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            mesto.setPostanskiBroj(1234L);
        });
        assertEquals("Postanski broj mora biti petocifren", exception.getMessage());
    }
    
        @Test
    public void testSetPostanskiBrojVeci() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            mesto.setPostanskiBroj(123411L);
        });
        assertEquals("Postanski broj mora biti petocifren", exception.getMessage());
    }

    @Test
    public void testSetNaziv() {
        String noviNaziv = "Nis";
        mesto.setNaziv(noviNaziv);
        assertEquals(noviNaziv, mesto.getNaziv());
    }



 
    @ParameterizedTest
    @CsvSource({
        "1, 11000, Beograd, 1, 11000, Beograd, true",
        "1, 11000, Beograd, 2, 11000, Beograd, false",
        "1, 11000, Beograd, 1, 12000, Beograd, false",
        "1, 11000, Beograd, 1, 11000, Novi Sad, false",
        "1, 11000, Beograd, 1, 12000, Novi Sad, false",
        "1, 11000, Beograd, 2, 12000, Beograd, false",
        "1, 11000, Beograd, 2, 11000, Novi Sad, false",
        "1, 11000, Beograd, 2, 12000, Novi Sad, false"
    })
    public void testEquals(Long mestoID1, Long postanskiBroj1, String naziv1,
                           Long mestoID2, Long postanskiBroj2, String naziv2, boolean tacno) {
        Mesto m1 = new Mesto(mestoID1, postanskiBroj1, naziv1);
        Mesto m2 = new Mesto(mestoID2, postanskiBroj2, naziv2);

        assertEquals(tacno, m1.equals(m2));
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
