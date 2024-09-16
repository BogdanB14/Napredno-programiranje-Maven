/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domenJSON;

import com.google.gson.Gson;
import domen.Clan;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa koja implementira metodu za deserijalizaciju liste clanova.
 * @author Bogdan Blagojevic
 */
public class ClanDeserijalizacija implements JSONDeserijalizacija {

    /**
     * {@inheritDoc }
     * @param putanja
     * @return 
     */
    @Override
    public List<Clan> deserijalizuj(String putanja) {
            Gson gson = new Gson();
    List<Clan> lista = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(putanja))) {
        String red;
        while ((red = reader.readLine()) != null) {
            Clan clan = gson.fromJson(red, Clan.class);
            System.out.println("Deserijalizovan administrator: " + clan);
            lista.add(clan);
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    return lista;
        
    }
    
}
