/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.Date;
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
public class TreningTest {
    private Mesto mesto;
    private Sala sala;
    private Trener trener;
    private Administrator administrator;
    private Kategorija kategorija;
    private Grupa grupa;
    private Trening trening;
    private Date trenutniDatum = new Date();
    private Long milisekunde = trenutniDatum.getTime();
    private Date datumTreninga = new Date(milisekunde + 100000000);
    public TreningTest() {
    }
    

    
    @BeforeEach
    public void setUp() {
        mesto = new Mesto(1L, 17530L, "Surdulica");
        trener = new Trener(3L, "Uros", "Blagojevic", mesto);
        sala = new Sala(1L, "Jovan Jovanovic Zmaj", 100, mesto);
        kategorija = new Kategorija(1L, "Seniori", "Opis", Pol.MUSKI);
        administrator = new Administrator(1L, "BogdanB14", "Bogdan123", "Bogdan", "Blagojevic");
        grupa = new Grupa(1L, "Prvi muski tim", 20, kategorija, administrator, trener);
        trening = new Trening();
        trening.setRbTreninga(1);
        trening.setDatumTreninga(datumTreninga);
        trening.setTipTreninga(TipTreninga.TERETANA);
        trening.setSala(sala);
        trening.setTrener(trener);
        trening.setGrupa(grupa);
    }
    @AfterEach
    public void tearDown() {
    }
    
        @Test
    public void testParametarskiKonstruktor() {
        Date datum = new Date(milisekunde + 10000000);
        TipTreninga tip = TipTreninga.KONDICIONI;
        Sala sala = new Sala(2L, "Vuk Karadzic", 100, new Mesto(1L, 17530L, "Surdulica"));
        Trener trener = new Trener(1L, "Dalibor", "Rasic", new Mesto(1L, 17530L, "Surdulica"));
        Grupa grupa = new Grupa(1L, "Drugi muski tim", 20, null, null, null);

        Trening trening = new Trening(1, datum, tip, sala, trener, grupa);

        assertEquals(1, trening.getRbTreninga());
        assertEquals(datum, trening.getDatumTreninga());
        assertEquals(tip, trening.getTipTreninga());
        assertEquals(sala, trening.getSala());
        assertEquals(trener, trening.getTrener());
        assertEquals(grupa, trening.getGrupa());
    }

    @Test
    public void testSetRbTreninga() {
        int rbTreninga = 2;
        trening.setRbTreninga(rbTreninga);
        assertEquals(rbTreninga, trening.getRbTreninga());
    }
    
        @Test
    public void testSetRbTreningaManjiOd1() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            trening.setRbTreninga(0);
        });
        assertEquals("Redni broj mora biti veci od 0", exception.getMessage());
    }


    @Test
    public void testSetDatumTreninga() {
        Date noviDatum = new Date(datumTreninga.getTime() + 86400000); 
        trening.setDatumTreninga(noviDatum);
        assertEquals(noviDatum, trening.getDatumTreninga());
    }
    
    @Test
    public void testSetDatumTreningaProslost() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            trening.setDatumTreninga(new Date());
        });
        assertEquals("Datum nije u skladu sa ogranicenjima", exception.getMessage());
    }
    
        @Test
    public void testSetDatumTreningaNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            trening.setDatumTreninga(null);
        });
        assertEquals("Datum nije u skladu sa ogranicenjima", exception.getMessage());
    }


    @Test
    public void testSetTipTreninga() {
        TipTreninga noviTipTreninga = TipTreninga.KONDICIONI;
        trening.setTipTreninga(noviTipTreninga);
        assertEquals(noviTipTreninga, trening.getTipTreninga());
    }

    @Test
    public void testSetSala() {
        Sala novaSala = new Sala(2L, "Nova Sala", 150, mesto);
        trening.setSala(novaSala);
        assertEquals(novaSala, trening.getSala());
    }
    
        @Test
    public void testSetSalaNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            trening.setSala(null);
        });
        assertEquals("Sala ne sme biti null", exception.getMessage());
    }


    @Test
    public void testSetTrener() {
        Trener noviTrener = new Trener(4L, "Marko", "Markovic", mesto);
        trening.setTrener(noviTrener);
        assertEquals(noviTrener, trening.getTrener());
    }
    
        @Test
    public void testSetTrenerNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            trening.setTrener(null);
        });
        assertEquals("Trener ne sme biti null", exception.getMessage());
    }

    @Test
    public void testSetGrupa() {
        Grupa novaGrupa = new Grupa(2L, "Drugi tim", 15, kategorija, administrator, trener);
        trening.setGrupa(novaGrupa);
        assertEquals(novaGrupa, trening.getGrupa());
    }
    
        @Test
    public void testSetGrupaNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            trening.setGrupa(null);
        });
        assertEquals("Grupa ne sme biti null", exception.getMessage());
    }

    @Test
    public void testToString() {
        String toString = "Trening{rbTreninga=1, datumTreninga=" + datumTreninga + ", tipTreninga=TERETANA, sala=" + sala + ", trener=" + trener + ", grupa=" + grupa + '}';
        assertEquals(toString, trening.toString());
    }


    @ParameterizedTest
    @CsvSource({
        "1,1, true",
        "1,2,false"
    })
    public void equals(int rb1, int rb2, boolean tacno){
        Trening t1 = new Trening(rb1, datumTreninga, TipTreninga.TERETANA, sala, trener, grupa);
        Trening t2 = new Trening(rb2, datumTreninga, TipTreninga.TERETANA, sala, trener, grupa);
        
        assertEquals(tacno, t1.equals(t2));
    }

    @Test
    public void testVratiNazivTabele() {
        assertEquals("trening", trening.vratiNazivTabele());
    }

    @Test
    public void testVratiKoloneZaUbacivanje() {
        assertEquals("datumTreninga,tipTreninga,sala,trener,grupa", trening.vratiKoloneZaUbacivanje());
    }

    @Test
    public void testVratiVrednostiZaUbacivanje() {
        java.sql.Date datum = new java.sql.Date(datumTreninga.getTime());
        String vrednost = "'" + datum + "','" + TipTreninga.TERETANA + "'," + sala.getSalaID()+ "," + trener.getTrenerID()+ "," + grupa.getGrupaID();
        assertEquals(vrednost, trening.vratiVrednostiZaUbacivanje());
    }

    @Test
    public void testVratiPrimarniKljuc() {
        assertEquals("trening.rbTreninga=1", trening.vratiPrimarniKljuc());
    }

    @Test
    public void testVratiVrednostiZaIzmenu() {
        String vrednost = "datumTreninga='" + datumTreninga + "', tipTreninga='" + TipTreninga.TERETANA + "', sala=" + sala.getSalaID()+ ", trener=" + trener.getTrenerID()+ ", grupa=" + grupa.getGrupaID();
        assertEquals(vrednost, trening.vratiVrednostiZaIzmenu());
    }
    
}
