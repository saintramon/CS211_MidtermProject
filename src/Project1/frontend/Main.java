package Project1.frontend;

public class Main {

    /**
     * Main entry point of the program
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            Main program = new Main();
            program.run();
        } catch (Exception e){
            e.printStackTrace();
        }
    } // end of main method

    /**
     * Controls the execution of the program
     */
    public void run(){
        new GUIInfixPrecedence();
    } // end of run method
} // end of class Main