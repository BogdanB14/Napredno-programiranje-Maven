/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domenJSON;

import domen.ApstraktniDomenskiObjekat;

/**
 *
 * @author Bogdan Blagojevic
 */
public interface JSONSerijalizacija<T> {
    void serijalizacija(ApstraktniDomenskiObjekat klasa, String putanja);
}
