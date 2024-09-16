/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package operacija.trener;

import domen.Administrator;
import domen.Mesto;
import domen.Trener;
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
public class UcitajTrenereOperacijaTest {
    private UcitajTrenereOperacija operacija;
    private DBRepository brokerMock;
    private Mesto mesto1;
    private Mesto mesto2;
    private Mesto mesto3;
    private Mesto mesto4;
    public UcitajTrenereOperacijaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        operacija = new UcitajTrenereOperacija();
        brokerMock = mock(DBRepository.class);
        operacija.broker = brokerMock;
        mesto1 = new Mesto(1L, 17530L, "Surdulica");
        mesto2 = new Mesto(1L, 17500L, "Vranje");
        mesto3 = new Mesto(1L, 17510L, "Vladicin Han");
        mesto4 = new Mesto(1L, 18000L, "Nis");
        
    }
    
    @AfterEach
    public void tearDown() {
    }




    @Test
    public void testPredusloviException() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            operacija.preduslovi(new Administrator()); 
        });
        assertEquals(exception.getMessage(), "Sistem ne moze da ucita trener");
    }

    @Test
    public void testIzvrsiOperaciju() throws Exception {
        List<Trener> treneri = Arrays.asList(
        new Trener(1L, "Dalibor", "Rasic", mesto1),
        new Trener(2L, "Uros", "Blagojevic", mesto2),
        new Trener(3L, "Blagoja", "Trajkovic", mesto1),
        new Trener(4L, "Jovan", "Jovanovic", mesto1),
        new Trener(5L, "Caslav", "Nikolic", mesto3),
        new Trener(6L, "Radmilo", "Andjelkovic", mesto4),
        new Trener(7L, "Ivan", "Milojkovic", mesto4),
        new Trener(8L, "Ilija", "Radancic", mesto3),
        new Trener(9L, "Aleksa", "Pesic", mesto2),
        new Trener(10L, "Dragan", "Jovic", mesto1)
    );
        
        when(brokerMock.getAll(any(Trener.class), anyString())).thenReturn(treneri);
        
        operacija.izvrsiOperaciju(null, "");
        System.out.println(operacija.getLista());
        assertEquals(treneri, operacija.getLista());
        verify(brokerMock, times(1)).getAll(any(Trener.class), anyString());
        
    }

    @Test
    public void testSetLista() {
        List<Trener> treneri = Arrays.asList(
            new Trener(1L, "Dalibor", "Rasic", mesto1),
            new Trener(2L, "Caslav", "Nikolic", mesto2)
        );
        operacija.setLista(treneri);
        assertEquals(treneri, operacija.getLista());
    }
    
}
