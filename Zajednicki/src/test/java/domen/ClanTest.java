package domen;

import domen.Clan;
import domen.Mesto;
import domen.Pol;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;


public class ClanTest {

    private Clan clan;
    private Mesto mesto;
    private Date danasnji = new Date();
    private Long milisec = danasnji.getTime();
    @BeforeEach
    public void setUp() {
       //Mesto:
        mesto = new Mesto();
        mesto.setMestoID(1L);
        mesto.setPostanskiBroj(17530L);
        mesto.setNaziv("Surdulica");
        //Clan:
        clan = new Clan();
        clan.setJmbg("1234567890123");
        clan.setImeClana("Marko");
        clan.setPrezimeClana("Markovic");
        clan.setDatumRodjenja(new Date(milisec - 8640000));
        clan.setPol(Pol.MUSKI);
        clan.setTelefon("0612345678");
        clan.setMesto(mesto);
    }
    
        /**
     * Test konstruktora uz pomoc getera
     */
      @Test
    public void testKonstruktora() {
        assertTrue(clan.getJmbg().equals("1234567890123"));
        assertEquals(clan.getImeClana(), "Marko");
        assertEquals(clan.getPrezimeClana(), "Markovic");
        assertEquals(clan.getPol(), Pol.MUSKI);
        assertEquals(clan.getTelefon(), "0612345678");
          assertEquals(clan.getMesto(), mesto);
    }

    @Test
    public void testSetJmbg() {
        clan.setJmbg("9876543210987");
        assertEquals("9876543210987", clan.getJmbg());
    }
    
    @Test
    public void testSetJmbgNull() {
        Clan clan = new Clan();
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            clan.setJmbg(null);
        });
         exception = assertThrows(NullPointerException.class, () -> {
            clan.setJmbg("12345");
        });
        assertEquals(exception.getMessage(), "JMBG nije u dobrom formatu");
       
    }

    @Test
    public void testSetImeClana() {
        clan.setImeClana("Petar");
        assertEquals("Petar", clan.getImeClana());
    }
    
        @Test
    public void testSetImeClanaNull() {
        Clan clan = new Clan();
        NullPointerException ex = assertThrows(NullPointerException.class, () -> {
            clan.setImeClana(null);
        });
        assertEquals(ex.getMessage(), "Clan nije u dobrom formatu");
    }

    @Test
    public void testSetPrezimeClana() {
        clan.setPrezimeClana("Petrovic");
        assertEquals("Petrovic", clan.getPrezimeClana());
    }
    
        @Test
    public void testSetPrezimeClanaNull() {
        Clan clan = new Clan();

        
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            clan.setPrezimeClana(null);
        });
        assertEquals("Prezime nije u dobrom formatu", exception.getMessage());

        
        exception = assertThrows(NullPointerException.class, () -> {
            clan.setPrezimeClana("");
        });
        assertEquals("Prezime nije u dobrom formatu", exception.getMessage());

       
        exception = assertThrows(NullPointerException.class, () -> {
            clan.setPrezimeClana("   ");
        });
        assertEquals("Prezime nije u dobrom formatu", exception.getMessage());
    }

    @Test
    public void testSetDatumRodjenja() {
        Date datum = new Date(milisec - 8640000);
        clan.setDatumRodjenja(datum);
        assertEquals(datum, clan.getDatumRodjenja());
    }

        @Test
    public void testSetDatumRodjenjaNull() {
        Clan clan = new Clan();

        
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            clan.setDatumRodjenja(null);
        });
        assertEquals("Datum nije u dobrom forrmatu", exception.getMessage());
        
        exception = assertThrows(NullPointerException.class, () -> {
            clan.setDatumRodjenja(new Date(System.currentTimeMillis() + 1000000000L));
        });
        assertEquals("Datum nije u dobrom forrmatu", exception.getMessage());
    }
    
    @Test
    public void testSetPol() {
        clan.setPol(Pol.MUSKI);
        assertEquals(Pol.MUSKI, clan.getPol());
    }

    @Test
    public void testSetTelefon() {
        clan.setTelefon("0691234567");
        assertEquals("0691234567", clan.getTelefon());
    }
    
        @Test
    public void testSetTelefon_InvalidMessage() {
        Clan clan = new Clan();
        
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            clan.setTelefon(null);
        });
        assertEquals("Telefon ne sme biti null", exception.getMessage());
    }

    @Test
    public void testSetMesto() {
        Mesto novoMesto = new Mesto(2L, 11000L, "Beograd");
        clan.setMesto(novoMesto);
        assertEquals(novoMesto, clan.getMesto());
    }
    
        @Test
    public void testSetMestoNull() {
        Clan clan = new Clan();

        // Test with null value
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            clan.setMesto(null);
        });
        assertEquals("Mesto ne sme biti null", exception.getMessage());
    }

 @ParameterizedTest
    @CsvSource({
        "1234567890123, Marko, Markovic, 2000-01-01, MUSKI, 123456789, 1, 1234567890123, John, Doe, 1999-12-31, ZENSKI, 987654321, 2, true",  // Isti JMBG, ostalo je različito
        "1234567890333, Marko, Markovic, 2000-01-01, MUSKI, 123456789, 1, 1234567890124, Marko, Markovic, 2000-01-01, MUSKI, 123456789, 1, false", // Različit JMBG
        "1234567890123, Marko, Markovic, 2000-01-01, MUSKI, 123456789, 1, 1234567890123, John, Doe, 1990-05-05, ZENSKI, 999999999, 3, true"  // Isti JMBG, sve ostalo različito
    })
    public void testEquals(String jmbg1, String ime1, String prezime1, String datumRodjenja1, String pol1, String telefon1, long mestoId1,
                           String jmbg2, String ime2, String prezime2, String datumRodjenja2, String pol2, String telefon2, long mestoId2, boolean tacno) {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date datum = sdf.parse(datumRodjenja1);
            Mesto mesto1 = new Mesto(mestoId1, 12345L, "Grad");
            Mesto mesto2 = new Mesto(mestoId2, 12345L, "Grad");
            
            Clan clan1 = new Clan(jmbg1, ime1, prezime1, datum, Pol.valueOf(pol1), telefon1, mesto1);
            Clan clan2 = new Clan(jmbg2, ime2, prezime2, datum, Pol.valueOf(pol2), telefon2, mesto2);
            
            assertEquals(tacno, clan1.equals(clan2));
        } catch (ParseException ex) {
            Logger.getLogger(ClanTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testToString() {
        String toString = "Clan{jmbg=1234567890123, imeClana=Marko, prezimeClana=Markovic, datumRodjenja="+clan.getDatumRodjenja()+", pol=MUSKI, telefon=0612345678, mesto=Surdulica}";
        assertEquals(toString, clan.toString());
    }
    
    
    @Test
    public void testVratiKoloneZaUbacivanje() {
        String kolone = "jmbg,imeClana,prezimeClana,datumRodjenja,pol,telefon,mesto";
        assertEquals(kolone, clan.vratiKoloneZaUbacivanje());
    }

    @Test
    public void testVratiVrednostiZaUbacivanje() {
        java.sql.Date datum = new java.sql.Date(clan.getDatumRodjenja().getTime());
        String vrednosti = "'1234567890123','Marko','Markovic','" + datum + "','MUSKI','0612345678'," + mesto.getMestoID();
        assertEquals(vrednosti, clan.vratiVrednostiZaUbacivanje());
    }

    @Test
    public void testVratiPrimarniKljuc() {
        String primarniKljuc = "clan.jmbg='1234567890123'";
        assertEquals(primarniKljuc, clan.vratiPrimarniKljuc());
    }

    @Test
    public void testVratiVrednostiZaIzmenu() {
        java.sql.Date datum = new java.sql.Date(clan.getDatumRodjenja().getTime());
        String updateUpit = "clan.jmbg='1234567890123', clan.imeClana='Marko', clan.prezimeClana='Markovic', clan.datumRodjenja='" 
                + datum + "', clan.pol='MUSKI', clan.telefon='0612345678', clan.mesto=" + mesto.getMestoID() + " WHERE " + clan.vratiPrimarniKljuc();
        assertEquals(updateUpit, clan.vratiVrednostiZaIzmenu());
    }
    
}
