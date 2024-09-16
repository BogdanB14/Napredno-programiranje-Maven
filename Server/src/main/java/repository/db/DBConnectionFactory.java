/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;
import java.sql.Connection;
import konfiguracija.Konfiguracija;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa za kreiranje i upravljanje konekcijama sa bazom podataka.
 * <p>
 * Ova klasa koristi singleton obrazac kako bi obezbedilo da postoji samo jedno
 * pojavljivanje konekcije sa bazom podataka tokom trajanja aplikacije. Pruža metode
 * za dobijanje i upravljanje konekcijom sa bazom podataka.
 * </p>
 * 
 * @author Bogdan Blagojevic
 */
public class DBConnectionFactory {
    private static DBConnectionFactory instance;
    private Connection connection;
    
    /**
     * Vraća jedini primerak klase .
     * 
     * @return Jedini primerak {@code DBConnectionFactory}.
     */
    public static DBConnectionFactory getInstance(){
        if(instance == null)
            instance = new DBConnectionFactory();
        return instance;
    }
    
    /**
     * Privatni konstruktor klase koji uzima vrednosti propertija iz koniguracionog fajla 
     * url, username i password koji postavlja u metodi getConnection klase DriverManager
     * kako bi se osigurala konekcija sa bazom podataka. Konekcija se cuva u objektu klase Connection
     * Potrebno je rucno izvrsiti operaciju commit.
     */
    private DBConnectionFactory(){
        try {
            if(connection == null || connection.isClosed()){
                try {
                    String url = Konfiguracija.getInstance().getProperty("url");
                    String username = Konfiguracija.getInstance().getProperty("username");
                    String password = Konfiguracija.getInstance().getProperty("password");
                    connection = DriverManager.getConnection(url, username, password);
                    connection.setAutoCommit(false);
                } catch (SQLException ex) {
                    Logger.getLogger(DBConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Vraća trenutno otvorenu konekciju sa bazom podataka.
     * 
     * @return Konekcija sa bazom podataka.
     */
    public Connection getConnection() {
        return connection;
    }
}
