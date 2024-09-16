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
public class TrenerTest {
    private Mesto mesto;
    private Trener trener;
    public TrenerTest() {
    }
    
    
    @BeforeEach
    public void setUp() {
        mesto = new Mesto(1L, 17530L, "Surdulica");
        trener = new Trener();
        trener.setTrenerID(1L);
        trener.setImeTrener("Bogdan");
        trener.setPrezimeTrener("Blagojevic");
        trener.setMesto(mesto);
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testSetTrenerID() {
        Long noviID = 2L;
        trener.setTrenerID(noviID);
        assertEquals(noviID, trener.getTrenerID());
    }
    
    @Test
    public void testSetTrenerIDManjiOd1() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            trener.setTrenerID(0L);
        });
        assertEquals("ID trenera mora biti veci od 0", exception.getMessage());
    }


    @Test
    public void testSetImeTrener() {
        String novoIme = "Marko";
        trener.setImeTrener(novoIme);
        assertEquals(novoIme, trener.getImeTrener());
    }
    
    @Test
    public void testSetImeTrenerNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            trener.setImeTrener(null);
        });
        assertEquals("Ime trenera nije u dobrom formatu", exception.getMessage());
    }
    
    @Test
    public void testSetImeTrenerEmpty() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            trener.setImeTrener("");
        });
        assertEquals("Ime trenera nije u dobrom formatu", exception.getMessage());
    }
    
    @Test
    public void testSetImeTrenerSpace() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            trener.setImeTrener("      ");
        });
        assertEquals("Ime trenera nije u dobrom formatu", exception.getMessage());
    }



    @Test
    public void testSetPrezimeTrener() {
        String novoPrezime = "Markovic";
        trener.setPrezimeTrener(novoPrezime);
        assertEquals(novoPrezime, trener.getPrezimeTrener());
    }

    
        @Test
    public void testSetPrezimeTrenerNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            trener.setPrezimeTrener(null);
        });
        assertEquals("Prezime trenera nije u dobrom formatu", exception.getMessage());
    }
    
    @Test
    public void testSetPrezimeTrenerEmpty() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            trener.setPrezimeTrener("");
        });
        assertEquals("Prezime trenera nije u dobrom formatu", exception.getMessage());
    }
    
    @Test
    public void testSetPrezimeTrenerSpace() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            trener.setPrezimeTrener("      ");
        });
        assertEquals("Prezime trenera nije u dobrom formatu", exception.getMessage());
    }

    @Test
    public void testSetMesto() {
        Mesto novoMesto = new Mesto(2L, 17000L, "Nis");
        trener.setMesto(novoMesto);
        assertEquals(novoMesto, trener.getMesto());
    }
    
        @Test
    public void testSetMestoNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            trener.setMesto(null);
        });
        assertEquals("Mesto ne sme biti null", exception.getMessage());
    }


    @Test
    public void testToString() {
        String toString = "Bogdan Blagojevic";
        assertEquals(toString, trener.toString());
    }


 
    @ParameterizedTest
    @CsvSource({
        "1, Dalibor, Rasic, 1, Dalibor, Rasic, true",   
        "1, Dalibor, Rasic, 2, Dalibor, Rasic, false",  
        "1, Dalibor, Rasic, 1, Caslav, Rasic, false",
        "1, Dalibor, Rasic, 1, Dalibor, Nikolic, false"
    })
    public void testEquals(Long trenerID1, String imeTrener1, String prezimeTrener1,
                           Long trenerID2, String imeTrener2, String prezimeTrener2, boolean expected) {
        Mesto mesto = new Mesto(1L, 11000L, "Beograd");
        Trener t1 = new Trener(trenerID1, imeTrener1, prezimeTrener1, mesto);
        Trener t2 = new Trener(trenerID2, imeTrener2, prezimeTrener2, mesto);

        assertEquals(expected, t1.equals(t2));
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
