/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domenJSON;

import com.google.gson.Gson;
import domen.Administrator;
import domen.ApstraktniDomenskiObjekat;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bogdan Blagojevic
 */
public class AdministratorDeserijalizacija implements JSONDeserijalizacija<Administrator>{

@Override
public List<Administrator> deserijalizuj(String putanja) {
    Gson gson = new Gson();
    List<Administrator> lista = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(putanja))) {
        String red;
        while ((red = reader.readLine()) != null) {
            Administrator admin = gson.fromJson(red, Administrator.class);
            System.out.println("Deserijalizovan administrator: " + admin);
            lista.add(admin);
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    return lista;
}

   
}
