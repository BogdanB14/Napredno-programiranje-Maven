/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package operacija.trening;

import domen.Administrator;
import domen.TipTreninga;
import domen.Trening;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import repository.db.DBRepository;

/**
 *
 * @author Bogdan Blagojevic
 */
public class UcitajTreningeOperacijaTest {
    private UcitajTreningeOperacija operacija;
    private DBRepository brokerMock;
    
    public UcitajTreningeOperacijaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        operacija = new UcitajTreningeOperacija();
        brokerMock = Mockito.mock(DBRepository.class);
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
    public void testPredusloviTrening() throws Exception {
        operacija.preduslovi(new Trening());
    }

    @Test
    public void testPredusloviException() {
        assertThrows(Exception.class, () -> {
            operacija.preduslovi(new Administrator()); // Replace with a class that should throw an exception
        });
    }

    /**
     * Test of izvrsiOperaciju method, of class UcitajTreningeOperacija.
     */
    @Test
    public void testIzvrsiOperaciju() throws Exception {
        List<Trening> treninzi = Arrays.asList(
            new Trening(1, null, TipTreninga.TERETANA, null, null, null),
            new Trening(2, null, TipTreninga.TERETANA, null, null, null)
        );
        
        Mockito.when(brokerMock.getAll(Mockito.any(Trening.class), Mockito.anyString())).thenReturn(treninzi);


        operacija.izvrsiOperaciju(null, "");


        assertEquals(treninzi, operacija.getLista());
        Mockito.verify(brokerMock, Mockito.times(1)).getAll(Mockito.any(Trening.class), Mockito.anyString());
  
    }



    @Test
    public void testSetLista() {
        List<Trening> treninzi = Arrays.asList(
            new Trening(1, null, TipTreninga.TERETANA, null, null, null),
            new Trening(2, null, TipTreninga.TERETANA, null, null, null)
        );
        operacija.setLista(treninzi);
        List<Trening> result = operacija.getLista();
        assertEquals(treninzi, result);
    }
    
}
