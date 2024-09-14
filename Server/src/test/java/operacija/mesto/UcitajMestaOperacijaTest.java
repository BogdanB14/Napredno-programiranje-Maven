/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package operacija.mesto;

import domen.Administrator;
import domen.Mesto;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import repository.db.DBRepository;

/**
 *
 * @author Bogdan Blagojevic
 */
public class UcitajMestaOperacijaTest {
    
    private UcitajMestaOperacija operacija;
    private DBRepository brokerMock;
    
    public UcitajMestaOperacijaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        operacija = new UcitajMestaOperacija();
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
    public void testPredusloviMesto() throws Exception {
        operacija.preduslovi(new Mesto());
    }

    @Test
    public void testPredusloviException() throws Exception {
        assertThrows(Exception.class, () -> {
            operacija.preduslovi(new Administrator()); 
        });
    }

    @Test
    public void testIzvrsiOperaciju() throws Exception {
        List<Mesto> mesta = Arrays.asList(
            new Mesto(1L, 17530L, "Surdulica"),
            new Mesto(2L, 17000L, "Vranje")
        );

        when(brokerMock.getAll(any(Mesto.class), anyString())).thenReturn(mesta);

        operacija.izvrsiOperaciju(null, "");

        assertEquals(mesta, operacija.getLista());
        verify(brokerMock, times(1)).getAll(any(Mesto.class), anyString());
    }

    @Test
    public void testSetLista() {
               List<Mesto> mesta = Arrays.asList(
            new Mesto(1L, 17530L, "Surdulica"),
            new Mesto(2L, 17000L, "Vranje")
        );
               
               operacija.setLista(mesta);
        List<Mesto> result = operacija.getLista();
        assertEquals(mesta, result);
    }
    
}
