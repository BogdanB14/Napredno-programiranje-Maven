/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package operacija.grupa;

import domen.Administrator;
import domen.Grupa;
import domen.Kategorija;
import domen.Mesto;
import domen.Pol;
import domen.Trener;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import repository.db.DBRepository;

/**
 *
 * @author Bogdan Blagojevic
 */
public class UcitajGrupeOperacijaTest {
    private Mesto mesto1;
    private Mesto mesto2;
    private UcitajGrupeOperacija operacija;
    private DBRepository brokerMock;
    private Kategorija kategorija1;
    private Administrator administrator1;
    private Trener trener1;
    private Kategorija kategorija2;
    private Administrator administrator2;
    private Trener trener2;
    public UcitajGrupeOperacijaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        //Grupa 1:
 //'1', 'Prvi muski tim', '15', '1', '2', '1', '1', 'Dalibor', 'Rasic', '1', '1', 'SENIORI', 'U ovoj grupi se nalaze muske osobe koje se takmice i igraju sa prvim timom.\r\nTo su clanovi kluba koji imaju minimalno 18 godina.', 'MUSKI', '2', 'Vladica70', 'Vladica70', 'Vladica', 'Blagojevic'
//'2', 'Prvi zenski tim', '20', '2', '3', '2', '2', 'Caslav', 'Nikolic', '2', '2', 'SENIORI', 'U ovoj grupi se nalaze zenske osobe koje se takmice i igraju sa prvim timom.\r\nTo su clanovi kluba koji imaju minimalno 18 godina.', 'ZENSKI', '3', 'Nikolino', 'Nikolina21', 'Nikolina', 'Stanisavljevic'
        brokerMock = mock(DBRepository.class);
        operacija = new UcitajGrupeOperacija();
        operacija.broker = brokerMock;
        mesto1 = new Mesto(1l, 17530L, "Surdulica");
        administrator1 = new Administrator(4l, "Vladica70", "Vladica70", "Vladica", "Blagojevic");
        kategorija1 = new Kategorija(1L, "SENIORI", "U ovoj grupi se nalaze muske osobe koje se takmice i igraju sa prvim timom.\\r\\nTo su clanovi kluba koji imaju minimalno 18 godina.", Pol.MUSKI);
        trener1 = new Trener(1L, "Dalibor", "Rasic", mesto1);
        //Grupa 2:
        mesto2 = new Mesto(2l, 17500L, "Vranje");
        administrator2 = new Administrator(3l, "Nikolino", "Nikolina21", "Nikolina", "Stanisavljevic");
        kategorija2 = new Kategorija(2L, "SENIORI", "U ovoj grupi se nalaze zenske osobe koje se takmice i igraju sa prvim timom.\\r\\nTo su clanovi kluba koji imaju minimalno 18 godina.", Pol.ZENSKI);
        trener2 = new Trener(2L, "Caslav", "Nikolic", mesto2);
       
        
    }
    
    @AfterEach
    public void tearDown() {
    }

 
    @Test
    public void testPredusloviNull() throws Exception {
        operacija.preduslovi(null);
    }
    
        @Test
    public void testPredusloviGrupa() throws Exception {
        operacija.preduslovi(new Grupa());
    }
    
    @Test
    public void testPredusloviException() throws Exception {
        assertThrows(Exception.class, () -> {
            operacija.preduslovi(new Object()); 
        });
    }

    @Test
    public void testIzvrsiOperaciju() throws Exception {
       List<Grupa> grupe = Arrays.asList(
                new Grupa(1L, "Prvi muski tim", 15, kategorija1, administrator1, trener1),
        new Grupa(2L, "Prvi zenski tim", 15, kategorija1, administrator1, trener1),
        new Grupa(3L, "Drugi muski tim", 15, kategorija1, administrator1, trener1),
        new Grupa(4L, "Drugi zenski tim",  15, kategorija1, administrator1, trener1),
        new Grupa(5L, "Muski razvojni tim",  15, kategorija1, administrator1, trener1),
        new Grupa(6L, "Zenski razvojni tim", 15, kategorija1, administrator1, trener1),
        new Grupa(7L, "Muski deciji tim",  15, kategorija1, administrator1, trener1),
        new Grupa(8L, "Zenski deciji tim", 15, kategorija1, administrator1, trener1),
        new Grupa(9L, "Probna grupa", 15, kategorija1, administrator1, trener1),
        new Grupa(10L, "Nova grupa", 15, kategorija1, administrator1, trener1),
        new Grupa(11L, "Nova grupa za eliminacioni", 15, kategorija1, administrator1, trener1),
        new Grupa(12L, "Nova grupa 2 za eliminacioni", 15, kategorija1, administrator1, trener1),
        new Grupa(13L, "Grupa 3", 15, kategorija1, administrator1, trener1),
        new Grupa(14L, "Eliminacioni 4", 15, kategorija1, administrator1, trener1),
        new Grupa(15L, "Nikolinina grupic", 15, kategorija1, administrator1, trener1)
               
       );
           
    when(brokerMock.getAll(any(Grupa.class), anyString())).thenReturn(grupe);

    
    operacija.izvrsiOperaciju(null, "");

   
    List<Grupa> lista = operacija.getLista();
    
  
    System.out.println("Expected: " + grupe);
    System.out.println("Actual: " + lista);

    
    verify(brokerMock).getAll(any(Grupa.class), anyString());
    assertEquals(grupe, lista);
    }




    @Test
    public void testSetLista() {
       List<Grupa> grupe = Arrays.asList(
               new Grupa(1L, "Prvi muski tim", 15, kategorija1, administrator1, trener1),
               new Grupa(2L, "Prvi zenski tim", 20, kategorija2, administrator2, trener2)
               
       );
       operacija.setLista(grupe);
        assertEquals(grupe, operacija.getLista());
    }
    
}
