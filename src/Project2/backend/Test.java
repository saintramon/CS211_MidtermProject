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
        String prompt = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbcccccccccccccddddddddddddddddddddeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeffgghhhhhhh";
        Huffman huffman = new Huffman(prompt);

        System.out.println("Original text:" + prompt);

        System.out.println(huffman.getFrequencyTable());

        System.out.println("CHAR " + " | " + " CODE");
        for (Map.Entry<Character,String> entry : huffman.getHuffmanTable().entrySet()){
            System.out.println(entry.getKey() + "     |  " + entry.getValue());
        }

        String converted = huffman.convertToText(prompt);
        System.out.println("Decoded text: " + converted);
    }
}
