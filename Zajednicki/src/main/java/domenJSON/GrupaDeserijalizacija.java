/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domenJSON;

import com.google.gson.Gson;
import domen.Grupa;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa koja implementira metodu za deserijalizaciju liste grupa.
 * @author Bogdan Blagojevic
 */
public class GrupaDeserijalizacija implements JSONDeserijalizacija {

    /**
     * {@inheritDoc}
     * @param putanja
     * @return 
     */
    @Override
    public List deserijalizuj(String putanja) {
                    Gson gson = new Gson();
    List<Grupa> lista = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(putanja))) {
        String red;
        while ((red = reader.readLine()) != null) {
            Grupa grupa = gson.fromJson(red, Grupa.class);
            System.out.println("Deserijalizovana grupa: " + grupa);
            lista.add(grupa);
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    return lista;
    }
    
}
