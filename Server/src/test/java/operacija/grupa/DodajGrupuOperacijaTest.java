/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package operacija.grupa;

import domen.Grupa;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import repository.db.DBRepository;

/**
 *
 * @author Bogdan Blagojevic
 */
public class DodajGrupuOperacijaTest {

    private DodajGrupuOperacija operacija;
    private DBRepository brokerMock;
    
    @BeforeEach
    public void setUp() {
        
        operacija = new DodajGrupuOperacija();
        brokerMock = mock(DBRepository.class);
        operacija.broker = brokerMock; 
    }
    
    @AfterEach
    public void tearDown() {
        operacija = null; 
    }

    @Test
    public void testPreduslovi() throws Exception {
        Grupa grupa = new Grupa();
        operacija.preduslovi(grupa); 
    }

    @Test
    public void testPredusloviDrugaKlasa() {
        
        Exception exception = assertThrows(Exception.class, () -> {
            operacija.preduslovi(new String());
        });
        assertEquals("Podaci o novoj grupi nisu upamceni", exception.getMessage());
    }


    @Test
    public void testIzvrsiOperaciju() throws Exception {
        Grupa grupa = new Grupa();
        doNothing().when(brokerMock).add(grupa); 

        operacija.izvrsiOperaciju(grupa, "");
        
        verify(brokerMock, times(1)).add(grupa);
    }

}