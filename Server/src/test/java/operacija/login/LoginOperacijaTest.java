/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package operacija.login;

import domen.Administrator;
import domen.Clan;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import repository.db.DBRepository;

/**
 *
 * @author Bogdan Blagojevic
 */
public class LoginOperacijaTest {

    private LoginOperacija loginOperacija;
    private DBRepository brokerMock;

    @BeforeEach
    public void setUp() {
        loginOperacija = new LoginOperacija();
        brokerMock = mock(DBRepository.class); 
        loginOperacija.broker = brokerMock;    
    }

    @AfterEach
    public void tearDown() {
        loginOperacija = null;
    }

    @Test
    public void testPreduslovi() throws Exception {
        Administrator admin = new Administrator();
        assertDoesNotThrow(() -> loginOperacija.preduslovi(admin)); 
    }

    @Test
    public void testPredusloviDrugaKlasa() {

        Exception exception = assertThrows(Exception.class, () -> {
            loginOperacija.preduslovi(new Clan());
        });

        assertEquals("Sistem ne moze da pronadje administratora na osnovu unetih podataka", exception.getMessage());
    }

    @Test
    public void testPredusloviNull() {
        Exception exception = assertThrows(Exception.class, () -> {
            loginOperacija.preduslovi(null); 
        });

        assertEquals("Sistem ne moze da pronadje administratora na osnovu unetih podataka", exception.getMessage());
    }


    @Test
    public void testIzvrsiOperacijuValidAdmin() throws Exception {
        Administrator administrator = new Administrator();
        administrator.setKorisnickoIme("BogdanB14");
        administrator.setSifra("Bogdan123");

       
        List<Administrator> lista = new ArrayList<>();
        lista.add(administrator);

        when(brokerMock.getAll(any(Administrator.class), isNull())).thenReturn(lista);

       
        loginOperacija.izvrsiOperaciju(administrator, "");

        
        assertNotNull(loginOperacija.getAdministrator());
        assertEquals(administrator, loginOperacija.getAdministrator());
    }

    @Test
    public void testIzvrsiOperacijuNePostoji() throws Exception {
        Administrator adminParam = new Administrator();
        adminParam.setKorisnickoIme("Dragan");
        adminParam.setSifra("Torbica");

        
        List<Administrator> adminList = new ArrayList<>();

        when(brokerMock.getAll(any(Administrator.class), isNull())).thenReturn(adminList);

        
        loginOperacija.izvrsiOperaciju(adminParam, "");

       
        assertNull(loginOperacija.getAdministrator());
    }


    @Test
    public void testGetAdministratorNakonPrijave() throws Exception {
        Administrator administrator = new Administrator();
        administrator.setKorisnickoIme("BogdanB14");
        administrator.setSifra("Bogdan123");

        List<Administrator> adminList = new ArrayList<>();
        adminList.add(administrator);

        when(brokerMock.getAll(any(Administrator.class), isNull())).thenReturn(adminList);

       
        loginOperacija.izvrsiOperaciju(administrator, "");
        assertEquals(administrator, loginOperacija.getAdministrator());
    }

}