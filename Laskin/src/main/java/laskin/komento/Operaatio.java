/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin.komento;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author ColdFish
 */
public abstract class Operaatio implements Komento{

    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    int edellinenArvo;

    public Operaatio(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
    }

    void asetaTulos(int tulos) {
        syotekentta.setText("");
        tuloskentta.setText("" + tulos);

        if (tulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }

    int haeSyote() {
        int arvo = 0;

        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        return arvo;
    }

    @Override
    public void peru() {
        asetaTulos(edellinenArvo);
    }
}
