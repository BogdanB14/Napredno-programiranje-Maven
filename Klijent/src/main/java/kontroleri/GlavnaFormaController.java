/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Administrator;
import forme.GlavnaForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import komunikacija.Komunikacija;
import komunikacija.Operacija;
import komunikacija.Zahtev;
import kordinator.Kordinator;

/**
 *
 * @author Bogdan Blagojevic
 */
public class GlavnaFormaController {
    private final GlavnaForma glavnaForma;

    public GlavnaFormaController(GlavnaForma glavnaForma) {
        this.glavnaForma = glavnaForma;
        addActionListeners();
    }

    private void addActionListeners() {
        glavnaForma.odjavaAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                glavnaForma.dispose();
                
                Komunikacija.getInstanca().logOut();
            }
        });
    }

    public void otvoriFormu() {
        Administrator a = Kordinator.getInstanca().getUlogovani();
        glavnaForma.setVisible(true);

        glavnaForma.getjLabelKorisnickoIme().setText(a.getImeAdmin() + " " + a.getPrezimeAdmin());
    }

    
}
