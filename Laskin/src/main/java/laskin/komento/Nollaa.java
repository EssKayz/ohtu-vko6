package laskin.komento;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

public class Nollaa extends Operaatio {
    
    private Sovelluslogiikka sovellus;

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo);
        this.sovellus = sovellus;
    }

    @Override
    public void suorita() {
        edellinenArvo = sovellus.tulos();
        sovellus.nollaa();
        asetaTulos(sovellus.tulos());
    }

}