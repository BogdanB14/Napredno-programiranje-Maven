/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domenJSON;

import com.google.gson.Gson;
import domen.Sala;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bogdan Blagojevic
 */
public class SalaDeserijalizacija implements JSONDeserijalizacija {

    @Override
    public List deserijalizuj(String putanja) {
        Gson gson = new Gson();
    List<Sala> lista = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(putanja))) {
        String red;
        while ((red = reader.readLine()) != null) {
            Sala sala = gson.fromJson(red, Sala.class);
            System.out.println("Deserijalizovana sala: " + sala);
            lista.add(sala);
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    return lista;
    }
    
}
