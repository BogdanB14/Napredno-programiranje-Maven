/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domenJSON;

import com.google.gson.Gson;
import domen.Trener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa koja implementira metodu za deserijalizaciju liste trenera.
 * @author Bogdan Blagojevic
 */
public class TrenerDeserijalizacija implements JSONDeserijalizacija {

    /**
     * {@inheritDoc }
     * @param putanja
     * @return 
     */
    @Override
    public List deserijalizuj(String putanja) {
        Gson gson = new Gson();
    List<Trener> lista = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(putanja))) {
        String red;
        while ((red = reader.readLine()) != null) {
            Trener trener = gson.fromJson(red, Trener.class);
            System.out.println("Deserijalizovan trener: " + trener);
            lista.add(trener);
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    return lista;
    }
    }
    
