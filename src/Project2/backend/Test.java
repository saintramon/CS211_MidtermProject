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
        String prompt = "test";
        Huffman huffman = new Huffman(prompt);

        System.out.println("================");
        System.out.println(huffman.getHuffmanTable());
        System.out.println("================");
        System.out.println("Convert to Huffman Code");
        System.out.println(huffman.convertToHuffmanCode(prompt));

        System.out.println(huffman.getFrequencyTable());

        System.out.println("CHAR " + " | " + " CODE");
        for (Map.Entry<Character,String> entry : huffman.getHuffmanTable().entrySet()){
            System.out.println(entry.getKey() + "     |  " + entry.getValue());
        }
    }
}
