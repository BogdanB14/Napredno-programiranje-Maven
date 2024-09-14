/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package operacija.clan;

import domen.Administrator;
import domen.Clan;
import domen.Mesto;
import domen.Pol;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.ArgumentMatchers;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import repository.db.DBRepository;

/**
 *
 * @author Bogdan Blagojevic
 */
public class UcitajClanoveOperacijaTest {
    
    private UcitajClanoveOperacija operacija;
    private DBRepository brokerMock;
    private Mesto mesto;
    public UcitajClanoveOperacijaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        mesto = new Mesto(1L, 17530L, "Surdulica");
        operacija = new UcitajClanoveOperacija();
         brokerMock = mock(DBRepository.class);
        operacija.broker = brokerMock;
    }
    
    @AfterEach
    public void tearDown() {
    }

    
    @Test
    public void testPredusloviNull() throws Exception {
        operacija.preduslovi(null);
    }
    
    @Test
    public void testPredusloviClan() throws Exception {
        operacija.preduslovi(new Clan());
    }
    
        
    @Test
    public void testPredusloviException() throws Exception {
        assertThrows(Exception.class, () -> {
            operacija.preduslovi(new Administrator()); 
        });
    }

    
    @Test
    public void testIzvrsiOperaciju() throws Exception {
        List<Clan> clanovi = Arrays.asList(
                new Clan("1904000744123", "Bogdan", "Blagojevic", new Date(), Pol.MUSKI, "066225426", mesto),
                new Clan("2702970744123", "Vladica", "Blagojevic", new Date(), Pol.MUSKI, "0646692153", mesto)
        );
        when(brokerMock.getAll(any(Clan.class), anyString())).thenReturn(clanovi);
        operacija.izvrsi(null, "");
        assertEquals(operacija.getLista(), clanovi);
        verify(brokerMock, times(1)).getAll(any(Clan.class), anyString());
    }

    @Test
    public void testSetLista() {
        List<Clan> clanovi = Arrays.asList(
                new Clan("1904000744123", "Bogdan", "Blagojevic", new Date(), Pol.MUSKI, "066225426", mesto),
                new Clan("2702970744123", "Vladica", "Blagojevic", new Date(), Pol.MUSKI, "0646692153", mesto)
        );
        operacija.setLista(clanovi);
        assertEquals(clanovi, operacija.getLista());
    }
    
}
