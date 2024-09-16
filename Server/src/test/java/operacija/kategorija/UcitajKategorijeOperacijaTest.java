/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package operacija.kategorija;

import domen.Administrator;
import domen.Kategorija;
import domen.Pol;
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
public class UcitajKategorijeOperacijaTest {
    
    private UcitajKategorijeOperacija operacija;
    private DBRepository brokerMock;
    
    public UcitajKategorijeOperacijaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        operacija = new UcitajKategorijeOperacija();
        brokerMock = mock(DBRepository.class);
        operacija.broker = brokerMock;
    }
    
    @AfterEach
    public void tearDown() {
    }


    @Test
    public void testPredusloviException() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            operacija.preduslovi(new Administrator()); 
        });
        assertEquals(exception.getMessage(), "Sistem ne moze da ucita kategorije");
    }


    @Test
    public void testIzvrsiOperaciju() throws Exception {
        List<Kategorija> kategorije = Arrays.asList(
            new Kategorija(1L, "Kategorija 1", "opis1", Pol.MUSKI),
            new Kategorija(2L, "Kategorija 2", "opis2", Pol.ZENSKI)
        );
       
        when(brokerMock.getAll(any(Kategorija.class), anyString())).thenReturn(kategorije);
        operacija.izvrsiOperaciju(null, "");
        assertEquals(kategorije, operacija.getLista());
        verify(brokerMock, times(1)).getAll(any(Kategorija.class), anyString());
    }

    @Test
    public void testSetLista() {
        List<Kategorija> kategorije = Arrays.asList(
            new Kategorija(1L, "Kategorija 1", "opis1", Pol.MUSKI),
            new Kategorija(2L, "Kategorija 2", "opis2", Pol.ZENSKI)
        );
        
        operacija.setLista(kategorije);
        assertEquals(kategorije, operacija.getLista());
    }
}
