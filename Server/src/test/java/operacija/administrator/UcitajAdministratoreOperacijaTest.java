/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package operacija.administrator;

import domen.Administrator;
import domen.Clan;
import java.util.Arrays;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;
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
public class UcitajAdministratoreOperacijaTest {
    
    private UcitajAdministratoreOperacija operacija;
    private DBRepository brokerMock;
    
    public UcitajAdministratoreOperacijaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        operacija = new UcitajAdministratoreOperacija();
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
    public void testPredusloviParam() throws Exception {
        Administrator a = new Administrator();
        operacija.preduslovi(a);
    }
    public void testPredusloviException() throws Exception {
        
        assertThrows(Exception.class, () -> {
        operacija.preduslovi(new Clan());
    });
    }

    @Test
    public void testIzvrsiOperaciju() throws Exception {
        List<Administrator> administratori = Arrays.asList(
                new Administrator(1L, "BogdanB14", "Bogdan123", "Bogdan", "Blagojevic"),
                new Administrator(2L, "Uros", "Uros123", "Uros", "Blagojevic") 
        );
        when(brokerMock.getAll(any(Administrator.class), anyString())).thenReturn(administratori);
        
        operacija.izvrsi(null, "");
        assertEquals(administratori, operacija.getLista());
        verify(brokerMock, times(1)).getAll(any(Administrator.class), anyString());
    }



    @Test
    public void testSetLista() {
        List<Administrator> administratori = Arrays.asList(
                new Administrator(1L, "BogdanB14", "Bogdan123", "Bogdan", "Blagojevic"),
                new Administrator(2L, "Uros", "Uros123", "Uros", "Blagojevic") 
        );
        operacija.setLista(administratori);

        assertEquals(administratori, operacija.getLista());
    }
    
}
