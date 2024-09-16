/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository.db;

import repository.Repository;

/**
 * Interfejs koji proširuje {@link Repository} za rad sa bazom podataka.
 * <p>
 * Ovaj interfejs dodaje metode za upravljanje transakcijama (commit, rollback)
 * i konekcijama sa bazom podataka. Pruža osnovne metode za rad sa bazom podataka
 * kao što su povezivanje, prekidanje veze i upravljanje transakcijama.
 * </p>
 * 
 * @param <T> Tip entiteta sa kojim se radi.
 */
public interface DBRepository<T> extends Repository<T>{
    
    /**
     * Povezuje se sa bazom podataka.
     * 
     * @throws Exception Ako dođe do greške prilikom povezivanja.
     */
    default public void connect() throws Exception{
        DBConnectionFactory.getInstance().getConnection();
    }
    
    /**
     * Prekida vezu sa bazom podataka.
     * 
     * @throws Exception Ako dođe do greške prilikom prekidanja veze.
     */
    default public void disconnect() throws Exception{
        DBConnectionFactory.getInstance().getConnection().close();
    }
    
    /**
     * Potvrdjuje sve promene u bazu podataka.
     * 
     * @throws Exception Ako dođe do greške prilikom komitovanja.
     */
    default public void commit() throws Exception{
        DBConnectionFactory.getInstance().getConnection().commit();
    }
    
    /**
     * Vraća sve promene koje nisu komitovane u bazu podataka.
     * 
     * @throws Exception Ako dođe do greške prilikom rollback-a.
     */
    default public void rollback() throws Exception{
        DBConnectionFactory.getInstance().getConnection().rollback();
    }
}
