package Project2.backend;

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Huffman {
    Map<Character,Integer> frequencyTable = new HashMap<>();
    Map<Character,String> huffmanTable = new HashMap<>();

    public Huffman(String text){
        countFrequency(text);
        generateHuffmanTable();
    }

    public Map<Character, Integer> getFrequencyTable() {
        return frequencyTable;
    }

    public Map<Character, String> getHuffmanTable() {
        return huffmanTable;
    }

    /**
     * The countFrequency method will count the occurrences of each distinct characters that will be stored in the frequencyTable.
     * The frequencyTable will then be used by the generateHuffmanTable to establish a HashMap that contains the Characters and their corresponding Huffman Codes.
     *
     * VISUALIZATION
     * CHAR    |   CODE
     * A           2
     * B           5
     * ...         ...
     *
     * @param text
     */
    public void countFrequency(String text){
        for (int i = 0; i < text.length(); i++){
            char curr = text.charAt(i);

            if (Character.isLetter(curr) || Character.isWhitespace(curr) || isPunctuation(curr)){
                if (frequencyTable.containsKey(curr)){
                    frequencyTable.put(curr, frequencyTable.get(curr) + 1);
                }else {
                    frequencyTable.put(curr, 1);
                }
            }
        }
    }

    /**
     * The generateHuffmanTable will be the one responsible creating the Huffman Tree.
     * After the root of the tree is known, this method will then call the populateHuffmanTable which will recursively put the Unique Characters
     * and their corresponding codes in the huffmanTable
     */
    public void generateHuffmanTable(){
        PriorityQueue<Node> huffmanTree = new PriorityQueue<>();
        Node huffmanRoot = new Node();

        for (Map.Entry<Character,Integer> entry : frequencyTable.entrySet()){
            Node newNode = new Node();

            newNode.setSymbol(entry.getKey());
            newNode.setCount(entry.getValue());
            newNode.setLeft(null);
            newNode.setRight(null);

            huffmanTree.add(newNode);
        }

        while (huffmanTree.size() > 1){
            Node x = huffmanTree.poll();
            Node y = huffmanTree.poll();

            Node z = new Node('-',x.getCount() + y.getCount());
            z.setLeft(x);
            z.setRight(y);

            huffmanTree.add(z);
        }
        huffmanRoot = huffmanTree.poll();

        populateHuffmanTable(huffmanRoot,"");
    }

    /**
     * This method will accept a plain text and will then return a String that is a converted huffman code
     *
     * INPUT: The quick brown fox jumps over the lazy dog
     * OUTPUT: 00010101010101110101010011...
     *
     * @param text
     * @return
     */
    public String convertToHuffmanCode(String text){
        String converted = "";

        //CODE HERE

        return converted;
    }

    /**
     * This method will accept a String of huffman code and will return its translated plain text.
     *
     * INPUT: 010100100001111001110111011101101...
     * OUTPUT: The quick brown fox jumps over the lazy dog
     *
     * @param text
     * @return
     */
    public String convertToText(String text){
        String converted = "";

        //CODE HERE

        return converted;
    }


    // UTILITY FUNCTIONS
    /**
     * A utility function that checks whether the passed character is a punctuation
     * @param symbol
     * @return
     */
    private boolean isPunctuation(char symbol){
        String punctuation = ".,;:?!'";
        return punctuation.contains(String.valueOf(symbol));
    }

    /**
     * A utility function that populates the huffman table with the characters with its corresponding code using recursion
     * @param root
     * @param code
     */
    private void populateHuffmanTable(Node root, String code){
        if (root.getLeft() == null && root.getRight() == null && (Character.isLetter(root.getSymbol()) || Character.isWhitespace(root.getSymbol()) || isPunctuation(root.getSymbol()))){
            huffmanTable.put(root.getSymbol(), code);
            return;
        }

        populateHuffmanTable(root.getLeft(), code+"0");
        populateHuffmanTable(root.getRight(), code+"1");
    }
}
