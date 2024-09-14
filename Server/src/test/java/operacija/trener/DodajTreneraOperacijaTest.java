/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package operacija.trener;

import domen.Trener;
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
public class DodajTreneraOperacijaTest {

    private DodajTreneraOperacija dodajTreneraOperacija;
    private DBRepository brokerMock;

    @BeforeEach
    public void setUp() {
        dodajTreneraOperacija = new DodajTreneraOperacija();
        brokerMock = mock(DBRepository.class); 
        dodajTreneraOperacija.broker = brokerMock; 
    }

    @AfterEach
    public void tearDown() {
        dodajTreneraOperacija = null;
    }

    @Test
    public void testPreduslovi() throws Exception {
        Trener trener = new Trener(); 
        assertDoesNotThrow(() -> dodajTreneraOperacija.preduslovi(trener));
    }


    @Test
    public void testPredusloviDrugaKlasa() {
       

        Exception exception = assertThrows(Exception.class, () -> {
            dodajTreneraOperacija.preduslovi(new String());
        });

        assertEquals("Podaci o novom treneru nisu upamceni", exception.getMessage());
    }

    @Test
    public void testPredusloviNull() {
        Exception exception = assertThrows(Exception.class, () -> {
            dodajTreneraOperacija.preduslovi(null); 
        });

        assertEquals("Podaci o novom treneru nisu upamceni", exception.getMessage());
    }

    @Test
    public void testIzvrsiOperaciju() throws Exception {
        Trener trener = new Trener();
        trener.setImeTrener("Zoran");
        trener.setPrezimeTrener("Terzic");
        
        doNothing().when(brokerMock).add(any(Trener.class));

        
        dodajTreneraOperacija.izvrsiOperaciju(trener, "");
        verify(brokerMock, times(1)).add(trener);
    }

}
