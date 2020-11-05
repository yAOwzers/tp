package zeronote;

import zeronote.userinterface.CliUserInterface;

public class ZeroNote {

    /**
     * Main entry-point for the teetwelvedashthree.zeronote.ZeroNote application.
     */
    public static void main(String[] args) throws Exception {
        CliUserInterface ui = new CliUserInterface();
        ui.run();
    }
}
