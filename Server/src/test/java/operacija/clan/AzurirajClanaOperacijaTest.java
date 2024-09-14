/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package operacija.clan;

import domen.Administrator;
import domen.Clan;
import domen.Pol;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import repository.db.DBRepository;
import repository.db.impl.DBRepositoryGeneric;

/**
 *
 * @author Bogdan Blagojevic
 */
public class AzurirajClanaOperacijaTest {
    private AzurirajClanaOperacija operacija;
    private DBRepository brokerMock;
    private Clan validClan;
    private Clan invalidClan;
    
    public AzurirajClanaOperacijaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        operacija = new AzurirajClanaOperacija();
        brokerMock = Mockito.mock(DBRepositoryGeneric.class);
        operacija.broker = brokerMock; 
        
        validClan = new Clan();
        validClan.setJmbg("1111111111111");
        validClan.setImeClana("Bogdan");
        validClan.setPrezimeClana("Blagojevic");
        validClan.setDatumRodjenja(new Date());
        validClan.setPol(Pol.MUSKI);
        validClan.setTelefon("066225426");

        invalidClan = null;
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testPredusloviDrugaKlasa() {
        assertThrows(Exception.class, () -> operacija.preduslovi(new Administrator()));
    }

        @Test
    public void testPredusloviNull() {
        assertThrows(Exception.class, () -> operacija.preduslovi(null));
    }
    
        @Test
    public void testPredusloviValidClan() {
        assertDoesNotThrow(() -> operacija.preduslovi(validClan));
    }

    @Test
    public void testIzvrsiOperaciju() throws Exception {
        
        Mockito.when(brokerMock.edit(validClan)).thenReturn(true);

        operacija.izvrsiOperaciju(validClan, "");

      
        assertTrue(AzurirajClanaOperacija.update);
    }

    
        @Test
    public void testIzvrsiOperacijuBroker() throws Exception {
        
        Mockito.when(brokerMock.edit(validClan)).thenReturn(false);
        System.out.println("Valid clan: " + validClan);
        
        operacija.izvrsiOperaciju(validClan, "");

        
        assertFalse(AzurirajClanaOperacija.update);
    }
    
}
