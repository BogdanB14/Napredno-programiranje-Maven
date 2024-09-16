/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package operacija.clan;

import domen.Clan;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import repository.db.DBRepository;

/**
 *
 * @author Bogdan Blagojevic
 */
public class ObrisiClanaOperacijaTest {

    private ObrisiClanaOperacija operacija;
    private DBRepository brokerMock;
    
    @BeforeEach
    public void setUp() {
       
        operacija = new ObrisiClanaOperacija();
        brokerMock = mock(DBRepository.class);
        operacija.broker = brokerMock;
    }
    
    @AfterEach
    public void tearDown() {
        ObrisiClanaOperacija.delete = false;
    }

    @Test
    public void testPredusloviValidClan() throws Exception {
        Clan clan = new Clan();
       assertDoesNotThrow(() -> operacija.preduslovi(clan));
    }


    @Test
    public void testPredusloviDrugaKlasat() {
        Exception exception = assertThrows(Exception.class, () -> {
            operacija.preduslovi(new String());
        });
        assertEquals("Sistem ne moze da obrise clana", exception.getMessage());
    }


    @Test
    public void testIzvrsiOperacijuTrue() throws Exception {
        Clan clan = new Clan();
        when(brokerMock.delete(clan)).thenReturn(true); 
        
        operacija.izvrsiOperaciju(clan, "");
        
        assertTrue(ObrisiClanaOperacija.delete);
        verify(brokerMock, times(1)).delete(clan); 
    }


    @Test
    public void testIzvrsiOperacijuFalse() throws Exception {
        Clan clan = new Clan();
        when(brokerMock.delete(clan)).thenReturn(false); 
        
        operacija.izvrsiOperaciju(clan, "");
        
        assertFalse(ObrisiClanaOperacija.delete);
        verify(brokerMock, times(1)).delete(clan); 
    }
}