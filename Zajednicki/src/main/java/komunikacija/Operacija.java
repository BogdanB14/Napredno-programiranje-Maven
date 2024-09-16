/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package komunikacija;


/**
 * Enumeracija {@code Operacija} definiše različite operacije koje se mogu izvršiti u sistemu.
 * Ove operacije predstavljaju razlicite akcije koje se mogu obaviti, kao što su:
 * <ul>
 *     <li>{@code LOGIN} - Operacija za prijavu korisnika u sistem.</li>
 *     <li>{@code UCITAJ_CLANOVE} - Operacija za ucitavanje svih clanova iz sistema.</li>
 *     <li>{@code OBRISI_CLANA} - Operacija za brisanje određenog clana iz sistema.</li>
 *     <li>{@code DODAJ_CLANA} - Operacija za dodavanje novog clana u sistem.</li>
 *     <li>{@code UCITAJ_MESTA} - Operacija za ucitavanje svih mesta iz sistema.</li>
 *     <li>{@code AZURIRAJ_CLANA} - Operacija za azuriranje informacija o clanu u sistemu.</li>
 *     <li>{@code UCITAJ_TRENINGE} - Operacija za ucitavanje svih treninga iz sistema.</li>
 *     <li>{@code UCITAJ_GRUPE} - Operacija za ucitavanje svih grupa iz sistema.</li>
 *     <li>{@code DODAJ_TRENERA} - Operacija za dodavanje novog trenera u sistem.</li>
 *     <li>{@code DODAJ_GRUPU} - Operacija za dodavanje nove grupe u sistem.</li>
 *     <li>{@code UCITAJ_KATEGORIJE} - Operacija za ucitavanje svih kategorija iz sistema.</li>
 *     <li>{@code UCITAJ_TRENERE} - Operacija za ucitavanje svih trenera iz sistema.</li>
 *     <li>{@code UCITAJ_ADMINISTRATORE} - Operacija za ucitavanje svih administratora iz sistema.</li>
 *     <li>{@code DODAJ_TRENING} - Operacija za dodavanje novog treninga u sistem.</li>
 *     <li>{@code UCITAJ_SALE} - Operacija za ucitavanje svih sala iz sistema.</li>
 *     <li>{@code LOGOUT} - Operacija za odjavu korisnika iz sistema.</li>
 * </ul>
 * 
 * @author Bogdan Blagojevic
 */
public enum Operacija {
    LOGIN, UCITAJ_CLANOVE, OBRISI_CLANA, DODAJ_CLANA, UCITAJ_MESTA, AZURIRAJ_CLANA, UCITAJ_TRENINGE, UCITAJ_GRUPE, DODAJ_TRENERA, DODAJ_GRUPU, UCITAJ_KATEGORIJE, UCITAJ_TRENERE, UCITAJ_ADMINISTRATORE, DODAJ_TRENING, UCITAJ_SALE, LOGOUT;
    
}
