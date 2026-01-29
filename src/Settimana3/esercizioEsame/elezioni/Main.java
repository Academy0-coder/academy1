package Settimana3.esercizioEsame.elezioni;

import Settimana3.esercizioEsame.elezioni.gui.GuiCreaListe;

public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            GuiCreaListe finestra = new GuiCreaListe();
            finestra.setVisible(true);
        });
    }
}
