/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domenJSON;

import com.google.gson.Gson;
import domen.ApstraktniDomenskiObjekat;
import domen.Trener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Bogdan Blagojevic
 */
public class TrenerSerijalizacija implements JSONSerijalizacija {

    @Override
    public void serijalizacija(ApstraktniDomenskiObjekat klasa, String putanja) {
        Gson gson = new Gson();
        String json = gson.toJson((Trener) klasa);
        
        try{
            File file = new File(putanja);
            File parentDir = file.getParentFile();

            if (!parentDir.exists()) {
                if (parentDir.mkdirs()) {
                    System.out.println("Napravio direktoriju do fajla: " + parentDir.getAbsolutePath());
                } else {
                    System.out.println("Greska prilikom kreiranja deirektorijuma: " + parentDir.getAbsolutePath());
                    return;
                }
            }
            
            
            boolean postoji = file.exists();
            
            try(FileWriter writer = new FileWriter(file, postoji)){
                if(postoji)
                    writer.write("\n");
                writer.write(json);
                System.out.println("Serijalizovan trener: " + json + " na putanji: " + putanja);
            }
        } catch(IOException e){
            System.out.println("Usao u catch u serijalizaciji trenera");
            e.printStackTrace();
        }
    }
    
}
