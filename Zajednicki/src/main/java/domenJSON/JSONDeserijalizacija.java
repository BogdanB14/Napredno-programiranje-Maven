/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domenJSON;

import java.util.List;

/**
 *
 * @author Bogdan Blagojevic
 */
public interface JSONDeserijalizacija<T> {
    List<T> deserijalizuj(String putanja);
}
