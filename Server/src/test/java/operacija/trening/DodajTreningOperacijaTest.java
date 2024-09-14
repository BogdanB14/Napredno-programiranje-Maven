/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package operacija.trening;

import domen.TipTreninga;
import domen.Trening;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import repository.db.DBRepository;

/**
 *
 * @author Bogdan Blagojevic
 */
public class DodajTreningOperacijaTest {

    private DodajTreningOperacija dodajTreningOperacija;
    private DBRepository brokerMock;

    @BeforeEach
    public void setUp() {
        dodajTreningOperacija = new DodajTreningOperacija();
        brokerMock = mock(DBRepository.class); 
        dodajTreningOperacija.broker = brokerMock; 
    }

    @AfterEach
    public void tearDown() {
        dodajTreningOperacija = null;
    }

    @Test
    public void testPreduslovi() throws Exception {
        Trening trening = new Trening(); 
        assertDoesNotThrow(() -> dodajTreningOperacija.preduslovi(trening)); 
    }


    @Test
    public void testPredusloviDrugaKlasa() {
        Exception exception = assertThrows(Exception.class, () -> {
            dodajTreningOperacija.preduslovi(new String());
        });
        assertEquals("Sistem ne može da doda trening.", exception.getMessage());
    }
    
    @Test
    public void testPredusloviNull() {
        Exception exception = assertThrows(Exception.class, () -> {
            dodajTreningOperacija.preduslovi(null); 
        });
        assertEquals("Sistem ne može da doda trening.", exception.getMessage());
    }


    @Test
    public void testIzvrsiOperacijuValidTrening() throws Exception {
        Trening trening = new Trening();
        trening.setRbTreninga(1);
        trening.setTipTreninga(TipTreninga.TERETANA);
        trening.setDatumTreninga(new Date());
        
        doNothing().when(brokerMock).add(any(Trening.class));

        
        dodajTreningOperacija.izvrsiOperaciju(trening, "");

        verify(brokerMock, times(1)).add(trening);
    }



}