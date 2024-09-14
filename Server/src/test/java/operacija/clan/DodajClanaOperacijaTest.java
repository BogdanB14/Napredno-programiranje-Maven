/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package operacija.clan;

import domen.Clan;
import domen.Mesto;
import domen.Pol;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.db.DBRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Bogdan Blagojevic
 */
public class DodajClanaOperacijaTest {

    private DodajClanaOperacija dodajClanaOperacija;
    private DBRepository brokerMock;
    private Clan clan;
    private Mesto mesto;

    @BeforeEach
    public void setUp() {
        dodajClanaOperacija = new DodajClanaOperacija();
        brokerMock = mock(DBRepository.class); 
        dodajClanaOperacija.broker = brokerMock; 
        clan = new Clan();
        mesto = new Mesto(1L, 17530L, "Surdulica");
    }

    @Test
    public void testPredusloviValidClan() throws Exception {
        Clan clan = new Clan();
        assertDoesNotThrow(() -> dodajClanaOperacija.preduslovi(clan));
    }

    @Test
    public void testPredusloviDrugaKlasa() {
        
        Exception exception = assertThrows(Exception.class, () -> dodajClanaOperacija.preduslovi(new String()));
        assertEquals("Podaci o novom clanu nisu upamceni", exception.getMessage());
    }

    @Test
    public void testIzvrsiOperaciju() throws Exception {
        // Prepare a valid clan object
        clan.setJmbg("1111111111111");
        clan.setImeClana("Bogdan");
        clan.setPrezimeClana("Blagojevic");
        clan.setDatumRodjenja(new Date());
        clan.setPol(Pol.MUSKI);
        clan.setTelefon("066225426");
        clan.setMesto(mesto);

        
        doNothing().when(brokerMock).add(clan);
        dodajClanaOperacija.izvrsiOperaciju(clan, "");
        
        verify(brokerMock, times(1)).add(clan);
    }


}
