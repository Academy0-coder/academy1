package Settimana3.EsercizioEsame.elezioni;

import Settimana3.EsercizioEsame.elezioni.gui.GuiCreaListe;

public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            GuiCreaListe finestra = new GuiCreaListe();
            finestra.setVisible(true);
        });
    }
}
