/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domenJSON;

import java.util.List;

/**
 * Interface JSONDeserijalizacija u sebi ima samo jednu metodu, zaduzenu za deserijalizaciju objekta
 * @author Bogdan Blagojevic
 */
public interface JSONDeserijalizacija<T> {
    /**
     * Metoda koja deserijalizuje iz fajla na putanji listu objekata koji se nalaze u txt fajlu
     * @param putanja Putanja do fajla koji se nalazi u direktorijumu iz kog se vrsi deserijalizacija
     * @return List<T> Lista je generickog tipa, umesto generickog T prosledjivace se bilo koja lista objekata klasa iz domena
     */
    List<T> deserijalizuj(String putanja);
}
