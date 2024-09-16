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
public class SalaTest {
    private Sala sala;
    private Mesto mesto;
    public SalaTest() {
    }
    
    
    @BeforeEach
    public void setUp() {
        mesto = new Mesto(1L, 17530L, "Surdulica");
        sala = new Sala();
        sala.setSalaID(1L);
        sala.setNazivSale("Jovan Jovanovic Zmaj");
        sala.setKapacitet(100);
        sala.setMesto(mesto);
    }
    
    @AfterEach
    public void tearDown() {
    }



    @Test
    public void testSetSalaID() {
        Long noviId = 2L;
        sala.setSalaID(noviId);
        assertEquals(noviId, sala.getSalaID());
    }

        @Test
    public void testSetSalaIDManjiOd1() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            sala.setSalaID(0L);
        });
        assertEquals("ID sale mora biti veci od 0", exception.getMessage());
    }


    @Test
    public void testSetNazivSale() {
        String noviNaziv = "Vuk Karadzic";
        sala.setNazivSale(noviNaziv);
        assertEquals(noviNaziv, sala.getNazivSale());
    }
    
        @Test
    public void testSetNazivSaleEmpty() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            sala.setNazivSale("");
        });
        assertEquals("Naziv sale nije u dobrom formatu", exception.getMessage());
    }
    
           @Test
    public void testSetNazivSaleNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            sala.setNazivSale(null);
        });
        assertEquals("Naziv sale nije u dobrom formatu", exception.getMessage());
    }
    
           @Test
    public void testSetNazivSaleSpace() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            sala.setNazivSale("          ");
        });
        assertEquals("Naziv sale nije u dobrom formatu", exception.getMessage());
    }



    @Test
    public void testSetKapacitet() {
        int novi = 200;
        sala.setKapacitet(novi);
        assertEquals(novi, sala.getKapacitet());
    }

    
        @Test
    public void testSetKapacitetManjiOd1() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            sala.setKapacitet(0);
        });
        assertEquals("Kapacitet mora biti veci od 0", exception.getMessage());
    }



    @Test
    public void testSetMesto() {
        Mesto novo = new Mesto(2L, 17000L, "Nis");
        sala.setMesto(novo);
        assertEquals(novo, sala.getMesto());
    }
    
        @Test
    public void testSetMestoNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            sala.setMesto(null);
        });
        assertEquals("Mesto ne sme biti null", exception.getMessage());
    }

    @Test
    public void testToString() {
        String toString = "Jovan Jovanovic Zmaj";
        assertEquals(toString, sala.toString());
    }



    @ParameterizedTest
    @CsvSource({
        "1, Sala 1, 100, 1, Sala 1, 100, true",  
        "1, Sala 1, 100, 2, Sala 1, 100, false",  
        "1, Sala 1, 100, 1, Sala 2, 100, false",  
        "1, Sala 1, 100, 1, Sala 1, 200, true"
    })
    public void testEquals(Long salaID1, String nazivSale1, int kapacitet1,
                           Long salaID2, String nazivSale2, int kapacitet2, boolean tacno) {
        Mesto mesto = new Mesto(1L, 11000L, "Beograd");
        Sala s1 = new Sala(salaID1, nazivSale1, kapacitet1, mesto);
        Sala s2 = new Sala(salaID2, nazivSale2, kapacitet2, mesto);

        assertEquals(tacno, s1.equals(s2));
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
