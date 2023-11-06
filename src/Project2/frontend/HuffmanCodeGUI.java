package Project2.frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.HashMap;
import java.util.Map;
import Project2.backend.Huffman;
import Project2.backend.HuffmanTree;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultMutableTreeNode;


/**
 * HuffmanCodeGUI is a Swing-based graphical user interface for Huffman coding and decoding.
 */
public class HuffmanCodeGUI extends JFrame {
    /**
     * A mapping of characters to their corresponding Huffman codes.
     */
    private Map<Character, String> huffmanTable = new HashMap<>();
    /**
     * An instance of the Resources class, providing access to various graphical resources.
     */
    private final Resources resources = new Resources();
    /**
     * The main content area of the GUI where different panels are displayed.
     */
    private JPanel contentArea;
    /**
     * Button for the "Input" option in the sidebar.
     */
    private JButton inputButton;
    /**
     * Button for the "Convert" option in the sidebar.
     */
    private JButton convertButton;
    /**
     * Button for the "Huffman Table" option in the sidebar.
     */
    private JButton tableButton;
    /**
     * Button for the "Huffman Tree" option in the sidebar.
     */
    private JButton treeButton;
    /**
     * An instance of the Huffman class, used for Huffman coding and decoding operations.
     */
    private Huffman huffman;
    /**
     * The input text provided by the user for Huffman coding and decoding.
     */
    private String inputText;


    /**
     * Constructor for the HuffmanCodeGUI class, which initializes the Huffman Code application's graphical user interface.
     */
    public HuffmanCodeGUI() {
        super("Huffman Code Application");

        setIconImage(resources.huffmanLogo.getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(resources.sage);

        ImageIcon headerLogo = resources.scaleImage(resources.huffmanLogo, 25, 25);
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel titleLabel = new JLabel("Huffman Code Application");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 15));
        titleLabel.setIcon(headerLogo);
        titleLabel.setForeground(resources.white);
        headerPanel.setBackground(resources.hunterGreen);
        headerPanel.add(titleLabel);

        JPanel sidebar = populateSidebar();
        mainPanel.add(sidebar, BorderLayout.WEST);

        contentArea = new JPanel();
        contentArea.setBackground(Color.WHITE);
        mainPanel.add(contentArea, BorderLayout.CENTER);

        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(resources.hunterGreen);
        JLabel copyrightLabel = new JLabel("© RAMONSTERS 2023");
        copyrightLabel.setFont(new Font("Arial", Font.BOLD, 12));
        copyrightLabel.setForeground(resources.white);
        footerPanel.add(copyrightLabel);

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    /**
     * Creates and populates the sidebar panel for the Huffman Code Application.
     * @return A JPanel containing the populated sidebar with various option buttons.
     */
    private JPanel populateSidebar() {
        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BorderLayout());
        sidebarPanel.setPreferredSize(new Dimension(250, 600));
        sidebarPanel.setBackground(resources.fernGreen);

        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new GridBagLayout());
        optionPanel.setPreferredSize(new Dimension(200, 550));
        optionPanel.setBackground(resources.fernGreen);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5, 0, 0, 0);

        inputButton = createSidebarButton("Input", "icons/input-icon-black.png");
        convertButton = createSidebarButton("Convert", "icons/code-icon-black.png");
        tableButton = createSidebarButton("Huffman Table", "icons/table-icon-black.png");
        treeButton = createSidebarButton("Huffman Tree", "icons/tree-icon-black.png");

        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setButtonFormat(inputButton, new JButton[]{convertButton, tableButton, treeButton});
                populateInputPanel();

            }
        });

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setButtonFormat(convertButton, new JButton[]{inputButton, tableButton, treeButton});
                populateCodePanel();
            }
        });

        tableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setButtonFormat(tableButton, new JButton[]{inputButton, convertButton, treeButton});
                populateTablePanel();
            }
        });

        treeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setButtonFormat(treeButton, new JButton[]{inputButton, convertButton, tableButton});
                populateTreePanel();
            }
        });

        gbc.gridy = 1;
        optionPanel.add(inputButton, gbc);

        gbc.gridy = 2;
        optionPanel.add(convertButton, gbc);

        gbc.gridy = 3;
        optionPanel.add(tableButton, gbc);

        gbc.gridy = 4;
        optionPanel.add(treeButton, gbc);

        sidebarPanel.add(optionPanel, BorderLayout.CENTER);
        return sidebarPanel;
    }

    /**
     * Populates the input panel within the Huffman Code Application's content area.
     * It allows users to enter text, provides instructions, and handles text processing.
     */
    private void populateInputPanel() {

        JPanel firstInputPanel = new JPanel();
        firstInputPanel.setBackground(resources.timberwolf);
        firstInputPanel.setLayout(new BorderLayout());
        firstInputPanel.setPreferredSize(new Dimension(700, 490));
        contentArea.removeAll();
        contentArea.add(firstInputPanel, BorderLayout.EAST);
        contentArea.revalidate();
        contentArea.repaint();

        JPanel instructionsPanel = new JPanel();
        instructionsPanel.setPreferredSize(new Dimension(600, 150));
        instructionsPanel.setBackground(resources.fernGreen);

        JLabel welcomeLabel = new JLabel("WELCOME TO OUR PROGRAM!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setForeground(resources.white);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        instructionsPanel.add(welcomeLabel);

        String instructionsText = "Instructions:\n" +
                "Input: Enter your text in the input panel and click the option you want in the sidebar.\n" +
                "Convert: Choose 'Convert' option to convert text to Huffman code and vice versa. You can also view the binary code and saved space.\n" +
                "Huffman Table: To generate a Huffman table, select the 'Huffman Table' option from the sidebar and then click 'Generate Table.'\n" +
                "Huffman Tree: Choose the 'Huffman Tree' option in the sidebar and click 'Generate Tree.'";

        JTextArea instructionsArea = new JTextArea(instructionsText);
        instructionsArea.setPreferredSize(new Dimension(620, 150));
        instructionsArea.setWrapStyleWord(true);
        instructionsArea.setLineWrap(true);
        instructionsArea.setOpaque(false);
        instructionsArea.setEditable(false);
        instructionsArea.setFocusable(false);
        instructionsArea.setForeground(resources.white);
        instructionsArea.setFont(UIManager.getFont("Label.font"));

        instructionsPanel.add(instructionsArea, BorderLayout.SOUTH);

        JPanel secondInputPanel = new JPanel();
        secondInputPanel.setBackground(resources.fernGreen);
        secondInputPanel.setPreferredSize(new Dimension(600, 340));
        secondInputPanel.setLayout(new BorderLayout());
        firstInputPanel.add(secondInputPanel, BorderLayout.SOUTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(resources.fernGreen);
        inputPanel.setPreferredSize(new Dimension(600, 150));
        inputPanel.setLayout(new GridBagLayout());

        JLabel titleLabel = new JLabel("PUT YOUR INPUT HERE");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(resources.white);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.NONE;
        gbc.insets = new Insets(10, 0, 10, 0);

        inputPanel.add(titleLabel, gbc);

        JTextField phraseTextField = new JTextField();
        phraseTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        phraseTextField.setText("Enter a word, phrase, or a paragraph...");
        phraseTextField.setColumns(40);

        phraseTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                phraseTextField.setText("");
            }
        });

        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;

        inputPanel.add(phraseTextField, gbc);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(resources.fernGreen);
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        inputPanel.add(buttonsPanel, gbc);

        JButton submitButton = new JButton("SUBMIT");
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setForeground(resources.white);
        submitButton.setBackground(resources.sage);

        JButton clearButton = new JButton("CLEAR");
        clearButton.setFont(new Font("Arial", Font.BOLD, 16));
        clearButton.setForeground(resources.white);
        clearButton.setBackground(resources.sage);

        buttonsPanel.add(submitButton);
        buttonsPanel.add(clearButton);

        JPanel promptPanel = new JPanel();
        promptPanel.setBackground(resources.fernGreen);
        promptPanel.setVisible(false);

        String promptText = "* choose 'Huffman Table' or 'Huffman Tree' in the sidebar to show results *";
        JLabel promptLabel = new JLabel(promptText);
        promptLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        promptLabel.setForeground(resources.white);

        promptPanel.add(promptLabel);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputText = phraseTextField.getText();
                huffman = new Huffman(inputText);

                if (inputText.isEmpty()) {

                    promptLabel.setText("YOU MUST ENTER A TEXT BEFORE CLICKING SUBMIT");
                    promptLabel.setFont(new Font("Arial", Font.BOLD, 14));
                    promptPanel.setVisible(true);
                } else {
                    // Process the input if it's not empty


                    promptPanel.setVisible(true);
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phraseTextField.setText("Enter a word, phrase, or a paragraph...");



                promptLabel.setText("");
                promptPanel.setVisible(false);
            }
        });

        firstInputPanel.add(instructionsPanel, BorderLayout.NORTH);
        secondInputPanel.add(inputPanel, BorderLayout.NORTH);
        secondInputPanel.add(promptPanel, BorderLayout.CENTER);

        setButtonFormat(inputButton, new JButton[]{convertButton, tableButton, treeButton});
    }

    /**
     * Populates the code conversion panel within the Huffman Code Application's content area.
     * It allows users to convert text to Huffman code and vice versa, displaying results and additional information.
     */
    private void populateCodePanel() {

        JPanel codePanel = new JPanel();
        codePanel.setBackground(resources.timberwolf);
        codePanel.setLayout(new BorderLayout());
        codePanel.setPreferredSize(new Dimension(700, 490));
        contentArea.removeAll();
        contentArea.add(codePanel, BorderLayout.EAST);
        contentArea.revalidate();
        contentArea.repaint();

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(resources.fernGreen);
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setPreferredSize(new Dimension(600, 150));
        codePanel.add(inputPanel, BorderLayout.NORTH);

        JLabel titleLabel = new JLabel("HUFFMAN CODE CONVERSION");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(resources.white);
        titleLabel.setBackground(resources.fernGreen);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 0, 10, 0);

        inputPanel.add(titleLabel, gbc);

        JTextField phraseTextField = new JTextField();
        phraseTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        phraseTextField.setText("Enter a word, phrase, or code...");
        phraseTextField.setColumns(40);

        phraseTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                phraseTextField.setText("");
            }
        });

        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;

        inputPanel.add(phraseTextField, gbc);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(resources.fernGreen);
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        inputPanel.add(buttonsPanel, gbc);

        JButton convertToTextButton = new JButton("CONVERT TO TEXT");
        convertToTextButton.setFont(new Font("Arial", Font.BOLD, 16));
        convertToTextButton.setForeground(resources.white);
        convertToTextButton.setBackground(resources.sage);

        JButton convertToCodeButton = new JButton("CONVERT TO CODE");
        convertToCodeButton.setFont(new Font("Arial", Font.BOLD, 16));
        convertToCodeButton.setForeground(resources.white);
        convertToCodeButton.setBackground(resources.sage);

        JButton clearButton = new JButton("CLEAR");
        clearButton.setFont(new Font("Arial", Font.BOLD, 16));
        clearButton.setForeground(resources.white);
        clearButton.setBackground(resources.sage);

        buttonsPanel.add(convertToTextButton);
        buttonsPanel.add(convertToCodeButton);
        buttonsPanel.add(clearButton);

        JPanel outputPanel = new JPanel();
        outputPanel.setBackground(Color.WHITE);
        outputPanel.setPreferredSize(new Dimension(600, 340));
        codePanel.add(outputPanel, BorderLayout.SOUTH);

        JPanel resultPanel = new JPanel();
        resultPanel.setPreferredSize(new Dimension(600, 340));
        outputPanel.add(resultPanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(resultPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        outputPanel.add(scrollPane);

        convertToTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = phraseTextField.getText();

                if (!inputText.isEmpty() && !inputText.equals("Enter a word, phrase, or code...")) {
                    //huffman = new Huffman(inputText);
                    String convertedCode = huffman.convertToText(inputText);

                    resultPanel.removeAll();

                    resultPanel.setLayout(new BorderLayout());

                    JLabel resultsTitleLabel = new JLabel("RESULTS", SwingConstants.CENTER);
                    resultsTitleLabel.setFont(new Font("Arial", Font.BOLD, 16));
                    resultPanel.add(resultsTitleLabel, BorderLayout.NORTH);

                    JPanel detailsPanel = new JPanel(new GridBagLayout());
                    detailsPanel.setPreferredSize(new Dimension(600,340));
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.fill = GridBagConstraints.HORIZONTAL;
                    gbc.insets = new Insets(5, 5, 5, 5);
                    gbc.anchor = GridBagConstraints.WEST;
                    gbc.gridy = 0;

                    JLabel convertedCodeLabel = new JLabel("CONVERTED TEXT:");
                    convertedCodeLabel.setFont(new Font("Arial", Font.BOLD, 16));
                    gbc.gridx = 0;
                    detailsPanel.add(convertedCodeLabel, gbc);
                    JLabel convertedCodeValueLabel = new JLabel(convertedCode);
                    convertedCodeValueLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                    gbc.gridx = 1;
                    detailsPanel.add(convertedCodeValueLabel, gbc);

                    gbc.gridy++;

                    JButton showAllResultsButton = new JButton("SHOW ALL RESULTS");
                    showAllResultsButton.setFont(new Font("Arial", Font.BOLD, 16));
                    showAllResultsButton.setForeground(resources.white);
                    showAllResultsButton.setBackground(resources.sage);
                    gbc.gridx = 0;
                    gbc.gridwidth = 2;
                    detailsPanel.add(showAllResultsButton, gbc);

                    gbc.gridy++;

                    showAllResultsButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            resultPanel.removeAll();

                            resultPanel.setLayout(new BorderLayout());

                            JLabel resultsTitleLabel = new JLabel("RESULTS", SwingConstants.CENTER);
                            resultsTitleLabel.setFont(new Font("Arial", Font.BOLD, 16));
                            resultPanel.add(resultsTitleLabel, BorderLayout.NORTH);

                            JPanel detailsPanel = new JPanel(new GridBagLayout());
                            detailsPanel.setPreferredSize(new Dimension(600,340));
                            GridBagConstraints gbc = new GridBagConstraints();
                            gbc.fill = GridBagConstraints.HORIZONTAL;
                            gbc.insets = new Insets(5, 5, 5, 5);
                            gbc.anchor = GridBagConstraints.WEST;
                            gbc.gridy = 0;

                            JLabel convertedCodeLabel = new JLabel("CONVERTED TEXT:");
                            convertedCodeLabel.setFont(new Font("Arial", Font.BOLD, 16));
                            gbc.gridx = 0;
                            detailsPanel.add(convertedCodeLabel, gbc);
                            JLabel convertedCodeValueLabel = new JLabel(convertedCode);
                            convertedCodeValueLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                            gbc.gridx = 1;
                            detailsPanel.add(convertedCodeValueLabel, gbc);

                            gbc.gridy++;

                            String binaryCode = huffman.convertToBinary(huffman.convertToText(inputText));
                            JLabel binaryCodeLabel = new JLabel("BINARY CODE:");
                            binaryCodeLabel.setFont(new Font("Arial", Font.BOLD, 16));
                            gbc.gridx = 0;
                            detailsPanel.add(binaryCodeLabel, gbc);
                            JLabel binaryCodeValueLabel = new JLabel(binaryCode);
                            binaryCodeValueLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                            gbc.gridx = 1;
                            detailsPanel.add(binaryCodeValueLabel, gbc);

                            gbc.gridy++;

                            double savedSpace = huffman.computeSavedSpace(huffman.convertToText(inputText));
                            JLabel savedSpaceLabel = new JLabel("SAVED SPACE:");
                            savedSpaceLabel.setFont(new Font("Arial", Font.BOLD, 16));
                            gbc.gridx = 0;
                            detailsPanel.add(savedSpaceLabel, gbc);
                            JLabel savedSpaceValueLabel = new JLabel(String.format("%.2f%%", savedSpace));
                            savedSpaceValueLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                            gbc.gridx = 1;
                            detailsPanel.add(savedSpaceValueLabel, gbc);

                            resultPanel.add(detailsPanel, BorderLayout.CENTER);

                            contentArea.revalidate();
                            contentArea.repaint();
                        }
                    });

                    resultPanel.add(detailsPanel, BorderLayout.CENTER);

                    contentArea.revalidate();
                    contentArea.repaint();
                }
            }
        });

        convertToCodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = phraseTextField.getText();

                if (!inputText.isEmpty() && !inputText.equals("Enter a word, phrase, or code...")) {
                    //huffman = new Huffman(inputText);
                    String convertedCode = huffman.convertToHuffmanCode(inputText);

                    resultPanel.removeAll();

                    resultPanel.setLayout(new BorderLayout());

                    JLabel resultsTitleLabel = new JLabel("RESULTS", SwingConstants.CENTER);
                    resultsTitleLabel.setFont(new Font("Arial", Font.BOLD, 16));
                    resultPanel.add(resultsTitleLabel, BorderLayout.NORTH);

                    JPanel detailsPanel = new JPanel(new GridBagLayout());
                    detailsPanel.setPreferredSize(new Dimension(600,340));
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.fill = GridBagConstraints.HORIZONTAL;
                    gbc.insets = new Insets(5, 5, 5, 5);
                    gbc.anchor = GridBagConstraints.WEST;
                    gbc.gridy = 0;

                    JLabel convertedCodeLabel = new JLabel("CONVERTED HUFFMAN CODE:");
                    convertedCodeLabel.setFont(new Font("Arial", Font.BOLD, 16));
                    gbc.gridx = 0;
                    detailsPanel.add(convertedCodeLabel, gbc);
                    JLabel convertedCodeValueLabel = new JLabel(convertedCode);
                    convertedCodeValueLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                    gbc.gridx = 1;
                    detailsPanel.add(convertedCodeValueLabel, gbc);

                    gbc.gridy++;

                    JButton showAllResultsButton = new JButton("SHOW ALL RESULTS");
                    showAllResultsButton.setFont(new Font("Arial", Font.BOLD, 16));
                    showAllResultsButton.setForeground(resources.white);
                    showAllResultsButton.setBackground(resources.sage);
                    gbc.gridx = 0;
                    gbc.gridwidth = 2;
                    detailsPanel.add(showAllResultsButton, gbc);

                    gbc.gridy++;

                    showAllResultsButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            resultPanel.removeAll();

                            resultPanel.setLayout(new BorderLayout());

                            JLabel resultsTitleLabel = new JLabel("RESULTS", SwingConstants.CENTER);
                            resultsTitleLabel.setFont(new Font("Arial", Font.BOLD, 16));
                            resultPanel.add(resultsTitleLabel, BorderLayout.NORTH);

                            JPanel detailsPanel = new JPanel(new GridBagLayout());
                            detailsPanel.setPreferredSize(new Dimension(600,340));
                            GridBagConstraints gbc = new GridBagConstraints();
                            gbc.fill = GridBagConstraints.HORIZONTAL;
                            gbc.insets = new Insets(5, 5, 5, 5);
                            gbc.anchor = GridBagConstraints.WEST;
                            gbc.gridy = 0;

                            JLabel convertedCodeLabel = new JLabel("CONVERTED HUFFMAN CODE:");
                            convertedCodeLabel.setFont(new Font("Arial", Font.BOLD, 16));
                            gbc.gridx = 0;
                            detailsPanel.add(convertedCodeLabel, gbc);
                            JLabel convertedCodeValueLabel = new JLabel(convertedCode);
                            convertedCodeValueLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                            gbc.gridx = 1;
                            detailsPanel.add(convertedCodeValueLabel, gbc);

                            gbc.gridy++;

                            String binaryCode = huffman.convertToBinary(inputText);
                            JLabel binaryCodeLabel = new JLabel("BINARY CODE:");
                            binaryCodeLabel.setFont(new Font("Arial", Font.BOLD, 16));
                            gbc.gridx = 0;
                            detailsPanel.add(binaryCodeLabel, gbc);
                            JLabel binaryCodeValueLabel = new JLabel(binaryCode);
                            binaryCodeValueLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                            gbc.gridx = 1;
                            detailsPanel.add(binaryCodeValueLabel, gbc);

                            gbc.gridy++;

                            double savedSpace = huffman.computeSavedSpace(inputText);
                            JLabel savedSpaceLabel = new JLabel("SAVED SPACE:");
                            savedSpaceLabel.setFont(new Font("Arial", Font.BOLD, 16));
                            gbc.gridx = 0;
                            detailsPanel.add(savedSpaceLabel, gbc);
                            JLabel savedSpaceValueLabel = new JLabel(String.format("%.2f%%", savedSpace));
                            savedSpaceValueLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                            gbc.gridx = 1;
                            detailsPanel.add(savedSpaceValueLabel, gbc);

                            resultPanel.add(detailsPanel, BorderLayout.CENTER);

                            contentArea.revalidate();
                            contentArea.repaint();
                        }
                    });

                    resultPanel.add(detailsPanel, BorderLayout.CENTER);

                    contentArea.revalidate();
                    contentArea.repaint();
                }
            }
        });


        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phraseTextField.setText("Enter a word, phrase, or code...");

                // Clear the result panel
                resultPanel.removeAll();
                resultPanel.revalidate();
                resultPanel.repaint();
            }
        });


        setButtonFormat(convertButton, new JButton[]{tableButton, treeButton});
    }

    /**
     * Populates the Huffman Table panel within the Huffman Code Application's content area.
     * It allows users to generate and display the Huffman table or character frequency table based on input text.
     */
    private void populateTablePanel() {
        JPanel tablePanel = new JPanel();
        tablePanel.setBackground(resources.timberwolf);
        tablePanel.setLayout(new BorderLayout());
        tablePanel.setPreferredSize(new Dimension(700, 490));
        contentArea.removeAll();
        contentArea.add(tablePanel, BorderLayout.EAST);
        contentArea.revalidate();
        contentArea.repaint();

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(resources.fernGreen);
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setPreferredSize(new Dimension(600, 150));
        tablePanel.add(inputPanel, BorderLayout.CENTER);

        JLabel titleLabel = new JLabel("HUFFMAN TABLE");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(resources.white);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 0, 10, 0);

        inputPanel.add(titleLabel, gbc);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(resources.fernGreen);
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        inputPanel.add(buttonsPanel, gbc);

        JButton generateTableButton = new JButton("GENERATE");
        generateTableButton.setFont(new Font("Arial", Font.BOLD, 16));
        generateTableButton.setForeground(resources.white);
        generateTableButton.setBackground(resources.sage);

        JButton showFrequencyButton = new JButton("SHOW FREQUENCY");
        showFrequencyButton.setFont(new Font("Arial", Font.BOLD, 16));
        showFrequencyButton.setForeground(resources.white);
        showFrequencyButton.setBackground(resources.sage);

        JButton clearButton = new JButton("CLEAR");
        clearButton.setFont(new Font("Arial", Font.BOLD, 16));
        clearButton.setForeground(resources.white);
        clearButton.setBackground(resources.sage);

        buttonsPanel.add(generateTableButton);
        buttonsPanel.add(showFrequencyButton); // Add the new button
        buttonsPanel.add(clearButton);

        JPanel outputPanel = new JPanel();
        outputPanel.setBackground(Color.WHITE);
        outputPanel.setPreferredSize(new Dimension(600, 340));
        tablePanel.add(outputPanel, BorderLayout.SOUTH);

        generateTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the stored input text
                if (inputText != null) {

                    Map<Character, String> huffmanTable = huffman.getHuffmanTable();

                    DefaultTableModel model = new DefaultTableModel() {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    model.addColumn("CHARACTER");
                    model.addColumn("HUFFMAN CODE");
                    for (Map.Entry<Character, String> entry : huffmanTable.entrySet()) {
                        model.addRow(new Object[]{entry.getKey(), entry.getValue()});
                    }
                    JTable huffmanTableComponent = new JTable(model);
                    huffmanTableComponent.setFont(huffmanTableComponent.getFont().deriveFont(Font.BOLD, 16f));
                    huffmanTableComponent.getTableHeader().setFont(huffmanTableComponent.getTableHeader().getFont().deriveFont(Font.BOLD, 16f));
                    huffmanTableComponent.setBackground(Color.WHITE);
                    huffmanTableComponent.setRowHeight(15);
                    huffmanTableComponent.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                    outputPanel.removeAll();

                    outputPanel.setLayout(new BorderLayout());
                    outputPanel.add(new JScrollPane(huffmanTableComponent), BorderLayout.CENTER);

                    outputPanel.revalidate();
                    outputPanel.repaint();
                }
            }
        });

        showFrequencyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inputText != null) {
                    String phrase = inputText;
                   // huffman = new Huffman(phrase);

                    Map<Character, Integer> frequencyTable = huffman.getFrequencyTable();

                    DefaultTableModel model = new DefaultTableModel() {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    model.addColumn("CHARACTER");
                    model.addColumn("FREQUENCY");
                    for (Map.Entry<Character, Integer> entry : frequencyTable.entrySet()) {
                        model.addRow(new Object[]{entry.getKey(), entry.getValue()});
                    }
                    JTable frequencyTableComponent = new JTable(model);
                    frequencyTableComponent.setFont(frequencyTableComponent.getFont().deriveFont(Font.BOLD, 16f));
                    frequencyTableComponent.getTableHeader().setFont(frequencyTableComponent.getTableHeader().getFont().deriveFont(Font.BOLD, 16f));
                    frequencyTableComponent.setBackground(Color.WHITE);
                    frequencyTableComponent.setRowHeight(15);
                    frequencyTableComponent.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                    outputPanel.removeAll();

                    outputPanel.setLayout(new BorderLayout());
                    outputPanel.add(new JScrollPane(frequencyTableComponent), BorderLayout.CENTER);

                    outputPanel.revalidate();
                    outputPanel.repaint();
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputText = null;

                outputPanel.removeAll();
                outputPanel.revalidate();
                outputPanel.repaint();
            }
        });

        setButtonFormat(tableButton, new JButton[]{convertButton, treeButton});
    }


    /**
     * Populates the Huffman Tree panel within the Huffman Code Application's content area.
     * It allows users to enter a phrase and visualize the corresponding Huffman tree structure.
     */
    private void populateTreePanel() {
        JPanel treePanel = new JPanel();
        treePanel.setBackground(resources.timberwolf);
        treePanel.setLayout(new BorderLayout());
        treePanel.setPreferredSize(new Dimension(700, 500));
        contentArea.removeAll();
        contentArea.add(treePanel, BorderLayout.EAST);
        contentArea.revalidate();
        contentArea.repaint();

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(resources.fernGreen);
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setPreferredSize(new Dimension(600, 100));
        treePanel.add(inputPanel, BorderLayout.CENTER);

        JLabel titleLabel = new JLabel("HUFFMAN TREE");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(resources.white);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 0, 10, 0);

        inputPanel.add(titleLabel, gbc);

        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout());
        outputPanel.setBackground(Color.WHITE);
        outputPanel.setPreferredSize(new Dimension(600, 350));
        treePanel.add(outputPanel, BorderLayout.SOUTH);

        JPanel huffmanTreePanel = new JPanel();
        huffmanTreePanel.setLayout(new BorderLayout());
        huffmanTreePanel.setBackground(Color.GRAY);
        huffmanTreePanel.setPreferredSize(new Dimension(600, 200));
        huffmanTreePanel.setVisible(false);
        outputPanel.add(huffmanTreePanel, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(huffmanTreePanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        outputPanel.add(scrollPane, BorderLayout.CENTER);

        huffman = new Huffman(inputText);
        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.setRoot(huffman.getHuffmanRoot());
        huffmanTreePanel.add(huffmanTree);
        huffmanTreePanel.setVisible(true);
    }


    /**
     * Creates and returns a formatted sidebar button with the specified text and icon.
     * @param text The text displayed on the button.
     * @param iconPath The file path to the button's icon.
     * @return A JButton with the specified text, icon, and formatting.
     */
    private JButton createSidebarButton(String text, String iconPath) {
        JButton button = new JButton();
        button.setText(text);
        ImageIcon icon = new ImageIcon(iconPath);
        button.setIcon(icon);
        button.setForeground(Color.WHITE);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setBorderPainted(false);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setFocusable(false);
        button.setFocusPainted(false);
        return button;
    }

    /**
     * Sets the formatting of buttons in the sidebar by changing their text color.
     * @param selectedButton The button that is currently selected.
     * @param allButtons     An array of all sidebar buttons.
     */
    private void setButtonFormat(JButton selectedButton, JButton[] allButtons) {
        for (JButton button : allButtons) {
            button.setForeground(resources.sage);
        }
        selectedButton.setForeground(resources.eggshellWhite);
    }

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
