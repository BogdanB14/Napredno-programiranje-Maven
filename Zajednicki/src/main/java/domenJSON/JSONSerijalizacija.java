/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domenJSON;

import domen.ApstraktniDomenskiObjekat;

/**
 *Interface JSONSerijalizacija u sebi ima samo jednu metodu, zaduzenu za serijalizaciju objekta
 * @author Bogdan Blagojevic
 */
public interface JSONSerijalizacija<T> {
    /**
     * Metoda koja serijalizuje prosledjeni objekat u fajl na prosledjenoj putanji.
     * @param klasa Bilo koja klasa koja implementira interfejs ApstraktniDomenskiObjekat iz domena
     * @param putanja Putanja do fajla u direktorijumu gde ce se vrsiti serijalizacija
     */
    void serijalizacija(ApstraktniDomenskiObjekat klasa, String putanja);
}
