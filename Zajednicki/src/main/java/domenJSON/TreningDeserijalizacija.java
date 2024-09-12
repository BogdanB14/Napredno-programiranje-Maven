/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domenJSON;

import com.google.gson.Gson;
import domen.Trening;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bogdan Blagojevic
 */
public class TreningDeserijalizacija implements JSONDeserijalizacija {

    @Override
    public List deserijalizuj(String putanja) {
        Gson gson = new Gson();
    List<Trening> lista = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(putanja))) {
        String red;
        while ((red = reader.readLine()) != null) {
            Trening trening = gson.fromJson(red, Trening.class);
            System.out.println("Deserijalizovan trening: " + trening);
            lista.add(trening);
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    return lista;
    }
    
}
