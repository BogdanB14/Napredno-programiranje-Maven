/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package operacija.sala;

import domen.Administrator;
import domen.Mesto;
import domen.Sala;
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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import repository.db.DBRepository;

/**
 *
 * @author Bogdan Blagojevic
 */
public class UcitajSaleOperacijaTest {
    private Mesto mesto;
    private UcitajSaleOperacija operacija;
    private DBRepository brokerMock;
    
    public UcitajSaleOperacijaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        brokerMock = mock(DBRepository.class);
        mesto = new Mesto(1L, 17530L, "Surdulica");
        operacija = new UcitajSaleOperacija();
        
        
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testPredusloviNull() throws Exception {
        operacija.preduslovi(null);
    }

    @Test
    public void testPredusloviSala() throws Exception {
        operacija.preduslovi(new Sala());
    }

    @Test
    public void testPredusloviException() throws Exception {
        assertThrows(Exception.class, () -> {
            operacija.preduslovi(new Administrator()); // Replace with a class that should throw an exception
        });
    }
    /**
     * Test of izvrsiOperaciju method, of class UcitajSaleOperacija.
     */
    @Test
    public void testIzvrsiOperaciju() throws Exception {
        List<Sala> sale = Arrays.asList(
            new Sala(1L, "Jovan Jovanovic Zmaj", 143, mesto),
            new Sala(2L, "Jovan Skerlic", 100, mesto),
            new Sala(3L, "Svetozar Markovic", 89, mesto),
            new Sala(4L, "Bora Stankovic", 200, mesto)
        );
        when(brokerMock.getAll(any(Sala.class), anyString())).thenReturn(sale); 
        operacija.izvrsiOperaciju(null, "");
        List<Sala> stvarne = operacija.getLista();
        System.out.println(stvarne);
        assertEquals(sale, stvarne);
        verify(brokerMock, times(1)).getAll(any(Sala.class), eq("JOIN mesto mesto ON sala.mesto=mesto.mestoID"));
    }




    @Test
    public void testSetLista() {
         List<Sala> sale = Arrays.asList(
            new Sala(1L, "Jovan Jovanovic Zmaj", 143, mesto),
            new Sala(3L, "Svetozar Markovic", 89, mesto)
        );
         operacija.setLista(sale);
        assertEquals(sale, operacija.getLista());
    }
    
}
