/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domenJSON;

import com.google.gson.Gson;
import domen.Mesto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bogdan Blagojevic
 */
public class MestoDeserijalizacija implements JSONDeserijalizacija {

    @Override
    public List deserijalizuj(String putanja) {
                Gson gson = new Gson();
    List<Mesto> lista = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(putanja))) {
        String red;
        while ((red = reader.readLine()) != null) {
            Mesto mesto = gson.fromJson(red, Mesto.class);
            System.out.println("Deserijalizovana mesta: " + mesto);
            lista.add(mesto);
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    return lista;
    }
    
    }
    
