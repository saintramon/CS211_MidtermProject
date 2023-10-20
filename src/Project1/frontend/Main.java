package Project1.frontend;

public class Main {
    public static void main(String[] args) {
        try{
            Main program = new Main();
            program.run();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        new GUIInfixPrecedence();
    }
}