/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin.komento;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

/**
 *
 * @author ColdFish
 */
public class Summa extends Operaatio {

    private Sovelluslogiikka sovellus;

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo);
        this.sovellus = sovellus;
    }


    @Override
    public void suorita() {
        edellinenArvo = sovellus.tulos();
        sovellus.plus(haeSyote());
        asetaTulos(sovellus.tulos());
    }
}
