package domen;

import domen.Clan;
import domen.Mesto;
import domen.Pol;
import java.sql.ResultSet;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;
import java.util.List;
import org.mockito.Mockito;


public class ClanTest {

    private Clan clan;
    private Mesto mesto;

    @Before
    public void setUp() {
       
        mesto = new Mesto(1L, 17530L, "Surdulica");
        clan = new Clan("1234567890123", "Marko", "Markovic", new Date(), Pol.MUSKI, "0612345678", mesto);
    }

    @Test
    public void testSetJmbg() {
        clan.setJmbg("9876543210987");
        assertEquals("9876543210987", clan.getJmbg());
    }

    @Test
    public void testSetImeClana() {
        clan.setImeClana("Petar");
        assertEquals("Petar", clan.getImeClana());
    }

    @Test
    public void testSetPrezimeClana() {
        clan.setPrezimeClana("Petrovic");
        assertEquals("Petrovic", clan.getPrezimeClana());
    }

    @Test
    public void testSetDatumRodjenja() {
        Date datum = new Date();
        clan.setDatumRodjenja(datum);
        assertEquals(datum, clan.getDatumRodjenja());
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
    public void testSetMesto() {
        Mesto novoMesto = new Mesto(2L, 11000L, "Beograd");
        clan.setMesto(novoMesto);
        assertEquals(novoMesto, clan.getMesto());
    }

    @Test
    public void testEquals() {
        Clan drugiClan = new Clan("1234567890123", "Nikola", "Nikolic", new Date(), Pol.MUSKI, "0612345678", mesto);
        assertTrue(clan.equals(drugiClan));

        Clan treciClan = new Clan("9876543210987", "Petar", "Petrovic", new Date(), Pol.MUSKI, "0691234567", mesto);
        assertFalse(clan.equals(treciClan));
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
