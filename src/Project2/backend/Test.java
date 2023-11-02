package Project2.backend;

import java.util.Map;

public class Test {
    public static void main(String[] args) {
        try {
            Test test = new Test();
            test.run();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        String prompt = "DRAGON";
        String prompt2 = "DONG";
        Huffman huffman = new Huffman(prompt);


        System.out.println("==============================");
        System.out.println("    Convert to Huffman Code   ");
        System.out.println(huffman.convertToHuffmanCode(prompt2));
        System.out.println("==============================");

        System.out.println("==============================");
        System.out.println("       Frequency Table        ");
        System.out.println(huffman.getFrequencyTable());
        System.out.println("==============================");

        System.out.println("==============================");
        System.out.println("         Huffman Table        ");
        System.out.println("CHAR " + " | " + " CODE");
        for (Map.Entry<Character,String> entry : huffman.getHuffmanTable().entrySet()){
            System.out.println(entry.getKey() + "     |  " + entry.getValue());
        }
        System.out.println("==============================");
    }
}
