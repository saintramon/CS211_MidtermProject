package midlab2.frontend;

import javax.swing.*;

public class Main {
    /**
     * The main entry point of the HuffmanCodeGUI application. It creates and initializes the GUI interface.
     * @param args The command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HuffmanCodeGUI();
        });
    }
}
