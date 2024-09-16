/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domenJSON;

import com.google.gson.Gson;
import domen.Kategorija;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa koja implementira metodu za deserijalizaciju liste kategorija.
 * @author Bogdan Blagojevic
 */
public class KategorijaDeserijalizacija implements JSONDeserijalizacija {

    /**
     * {@inheritDoc }
     * @param putanja
     * @return 
     */
    @Override
    public List deserijalizuj(String putanja) {
        Gson gson = new Gson();
    List<Kategorija> lista = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(putanja))) {
        String red;
        while ((red = reader.readLine()) != null) {
            Kategorija grupa = gson.fromJson(red, Kategorija.class);
            System.out.println("Deserijalizovana kategorija: " + grupa);
            lista.add(grupa);
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    return lista;
    }
    
    }
    
