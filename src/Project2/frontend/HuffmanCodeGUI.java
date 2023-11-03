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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;


public class HuffmanCodeGUI extends JFrame {
    private Map<Character, String> huffmanTable = new HashMap<>();
    private final Resources resources = new Resources();
    private JPanel contentArea;
    private JButton inputButton;
    private JButton codeButton;
    private JButton tableButton;
    private JButton treeButton;
    private Huffman huffman;

    public HuffmanCodeGUI() {
        super("Huffman Code Application");

        setIconImage(resources.huffmanLogo.getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setResizable(true);

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
        codeButton = createSidebarButton("Code", "icons/code-icon-black.png");
        tableButton = createSidebarButton("Table", "icons/table-icon-black.png");
        treeButton = createSidebarButton("Tree", "icons/tree-icon-black.png");

        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setButtonFormat(inputButton, new JButton[]{codeButton, tableButton, treeButton});

            }
        });

        codeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setButtonFormat(codeButton, new JButton[]{inputButton, tableButton, treeButton});
                populateCodePanel();
            }
        });

        tableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setButtonFormat(tableButton, new JButton[]{inputButton, codeButton, treeButton});
                populateTablePanel();
            }
        });

        treeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setButtonFormat(treeButton, new JButton[]{inputButton, codeButton, tableButton});
                populateTreePanel();
            }
        });

        gbc.gridy = 1;
        optionPanel.add(inputButton, gbc);

        gbc.gridy = 2;
        optionPanel.add(codeButton, gbc);

        gbc.gridy = 3;
        optionPanel.add(tableButton, gbc);

        gbc.gridy = 4;
        optionPanel.add(treeButton, gbc);

        sidebarPanel.add(optionPanel, BorderLayout.CENTER);
        return sidebarPanel;
    }


    private void populateCodePanel() {

        JPanel codePanel = new JPanel();
        codePanel.setBackground(resources.timberwolf);
        codePanel.setLayout(new BorderLayout());
        codePanel.setPreferredSize(new Dimension(700, 600));
        contentArea.removeAll();
        contentArea.add(codePanel, BorderLayout.EAST);
        contentArea.revalidate();
        contentArea.repaint();

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(resources.fernGreen);
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setPreferredSize(new Dimension(600, 150));
        codePanel.add(inputPanel, BorderLayout.CENTER);

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
        outputPanel.setPreferredSize(new Dimension(600, 450));
        codePanel.add(outputPanel, BorderLayout.SOUTH);

        convertToTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = phraseTextField.getText();

                if (!inputText.isEmpty() && !inputText.equals("Enter a word, phrase, or code...")) {
                    huffman = new Huffman(inputText);
                    String convertedText = huffman.convertToText(inputText);

                    outputPanel.removeAll();
                    outputPanel.setLayout(new GridBagLayout());
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.insets = new Insets(5, 5, 5, 5);

                    JLabel resultLabel = new JLabel("RESULT");
                    resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    gbc.gridwidth = 2;
                    gbc.anchor = GridBagConstraints.NORTH;
                    outputPanel.add(resultLabel, gbc);

                    JLabel huffmanCodeLabel = new JLabel("CONVERTED TEXT:");
                    huffmanCodeLabel.setFont(new Font("Arial", Font.BOLD, 16));
                    gbc.gridy++;
                    gbc.gridx = 0;
                    gbc.gridwidth = 1;
                    gbc.anchor = GridBagConstraints.WEST;
                    outputPanel.add(huffmanCodeLabel, gbc);

                    JTextField convertedTextField = new JTextField(convertedText);
                    convertedTextField.setFont(new Font("Arial", Font.BOLD, 16));
                    convertedTextField.setEditable(false);
                    convertedTextField.setBorder(null);
                    gbc.gridx = 1;
                    gbc.fill = GridBagConstraints.HORIZONTAL;
                    outputPanel.add(convertedTextField, gbc);

                    JButton showAllResultsButton = new JButton("SHOW ALL RESULTS");
                    showAllResultsButton.setFont(new Font("Arial", Font.BOLD, 16));
                    showAllResultsButton.setForeground(resources.white);
                    showAllResultsButton.setBackground(resources.sage);
                    gbc.gridy++;
                    gbc.gridwidth = 1;
                    gbc.anchor = GridBagConstraints.WEST;
                    outputPanel.add(showAllResultsButton, gbc);

                    contentArea.revalidate();
                    contentArea.repaint();

                    showAllResultsButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String convertedText = huffman.convertToText(inputText);
                            String binaryCode = huffman.convertToBinary(inputText);
                            double savedSpace = huffman.computeSavedSpace(inputText);

                            outputPanel.removeAll();
                            outputPanel.setLayout(new GridBagLayout());
                            GridBagConstraints gbc = new GridBagConstraints();
                            gbc.insets = new Insets(5, 5, 5, 5);

                            JLabel resultLabel = new JLabel("RESULT:");
                            resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
                            gbc.gridx = 0;
                            gbc.gridy = 0;
                            gbc.gridwidth = 2;
                            gbc.anchor = GridBagConstraints.CENTER;
                            outputPanel.add(resultLabel, gbc);

                            JLabel convertedTextLabel = new JLabel("CONVERTED TEXT: ");
                            convertedTextLabel.setFont(new Font("Arial", Font.BOLD, 16));
                            gbc.gridy++;
                            gbc.gridx = 0;
                            gbc.gridwidth = 1;
                            gbc.anchor = GridBagConstraints.WEST;
                            outputPanel.add(convertedTextLabel, gbc);

                            JTextField convertedTextField = new JTextField(convertedText);
                            convertedTextField.setFont(new Font("Arial", Font.BOLD, 16));
                            convertedTextField.setEditable(false);
                            convertedTextField.setBorder(null);
                            gbc.gridx = 1;
                            gbc.fill = GridBagConstraints.HORIZONTAL;
                            outputPanel.add(convertedTextField, gbc);

                            JLabel binaryCodeLabel = new JLabel("BINARY CODE:");
                            binaryCodeLabel.setFont(new Font("Arial", Font.BOLD, 16));
                            gbc.gridy++;
                            gbc.gridx = 0;
                            gbc.gridwidth = 1;
                            gbc.anchor = GridBagConstraints.WEST;
                            outputPanel.add(binaryCodeLabel, gbc);

                            JTextField binaryCodeField = new JTextField(binaryCode);
                            binaryCodeField.setFont(new Font("Arial", Font.BOLD, 16));
                            binaryCodeField.setEditable(false);
                            binaryCodeField.setBorder(null);
                            gbc.gridx = 1;
                            gbc.fill = GridBagConstraints.HORIZONTAL;
                            outputPanel.add(binaryCodeField, gbc);

                            JLabel savedSpaceLabel = new JLabel("SAVED SPACE:");
                            savedSpaceLabel.setFont(new Font("Arial", Font.BOLD, 16));
                            gbc.gridy++;
                            gbc.gridx = 0;
                            gbc.gridwidth = 1;
                            gbc.anchor = GridBagConstraints.WEST;
                            outputPanel.add(savedSpaceLabel, gbc);

                            JTextField savedSpaceField = new JTextField(savedSpace + "%");
                            savedSpaceField.setFont(new Font("Arial", Font.BOLD, 16));
                            savedSpaceField.setEditable(false);
                            savedSpaceField.setBorder(null);
                            gbc.gridx = 1;
                            gbc.fill = GridBagConstraints.HORIZONTAL;
                            outputPanel.add(savedSpaceField, gbc);
                        }
                    });

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
                    huffman = new Huffman(inputText);
                    String convertedCode = huffman.convertToHuffmanCode(inputText);

                    outputPanel.removeAll();
                    outputPanel.setLayout(new GridBagLayout());
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.insets = new Insets(5, 5, 5, 5);

                    JLabel resultLabel = new JLabel("RESULT");
                    resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    gbc.gridwidth = 2;
                    gbc.anchor = GridBagConstraints.NORTH;
                    outputPanel.add(resultLabel, gbc);

                    JLabel huffmanCodeLabel = new JLabel("CONVERTED TEXT:");
                    huffmanCodeLabel.setFont(new Font("Arial", Font.BOLD, 16));
                    gbc.gridy++;
                    gbc.gridx = 0;
                    gbc.gridwidth = 1;
                    gbc.anchor = GridBagConstraints.WEST;
                    outputPanel.add(huffmanCodeLabel, gbc);

                    JTextField convertedCodeField = new JTextField(convertedCode);
                    convertedCodeField.setFont(new Font("Arial", Font.BOLD, 16));
                    convertedCodeField.setEditable(false);
                    convertedCodeField.setBorder(null);
                    gbc.gridx = 1;
                    gbc.fill = GridBagConstraints.HORIZONTAL;
                    outputPanel.add(convertedCodeField, gbc);

                    JButton showAllResultsButton = new JButton("SHOW ALL RESULTS");
                    showAllResultsButton.setFont(new Font("Arial", Font.BOLD, 16));
                    showAllResultsButton.setForeground(resources.white);
                    showAllResultsButton.setBackground(resources.sage);
                    gbc.gridy++;
                    gbc.gridwidth = 1;
                    gbc.anchor = GridBagConstraints.WEST;
                    outputPanel.add(showAllResultsButton, gbc);

                    contentArea.revalidate();
                    contentArea.repaint();

                    showAllResultsButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String convertedText = huffman.convertToText(inputText);
                            String binaryCode = huffman.convertToBinary(inputText);
                            double savedSpace = huffman.computeSavedSpace(inputText);

                            outputPanel.removeAll();
                            outputPanel.setLayout(new GridBagLayout());
                            GridBagConstraints gbc = new GridBagConstraints();
                            gbc.insets = new Insets(5, 5, 5, 5);

                            JLabel resultLabel = new JLabel("RESULT:");
                            resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
                            gbc.gridx = 0;
                            gbc.gridy = 0;
                            gbc.gridwidth = 2;
                            gbc.anchor = GridBagConstraints.CENTER;
                            outputPanel.add(resultLabel, gbc);

                            JLabel convertedCodeLabel = new JLabel("CONVERTED HUFFMAN CODE: ");
                            convertedCodeLabel.setFont(new Font("Arial", Font.BOLD, 16));
                            gbc.gridy++;
                            gbc.gridx = 0;
                            gbc.gridwidth = 1;
                            gbc.anchor = GridBagConstraints.WEST;
                            outputPanel.add(convertedCodeLabel, gbc);

                            JTextField convertedTextField = new JTextField(convertedText);
                            convertedTextField.setFont(new Font("Arial", Font.BOLD, 16));
                            convertedTextField.setEditable(false);
                            convertedTextField.setBorder(null);
                            gbc.gridx = 1;
                            gbc.fill = GridBagConstraints.HORIZONTAL;
                            outputPanel.add(convertedTextField, gbc);

                            JLabel binaryCodeLabel = new JLabel("BINARY CODE:");
                            binaryCodeLabel.setFont(new Font("Arial", Font.BOLD, 16));
                            gbc.gridy++;
                            gbc.gridx = 0;
                            gbc.gridwidth = 1;
                            gbc.anchor = GridBagConstraints.WEST;
                            outputPanel.add(binaryCodeLabel, gbc);

                            JTextField binaryCodeField = new JTextField(binaryCode);
                            binaryCodeField.setFont(new Font("Arial", Font.BOLD, 16));
                            binaryCodeField.setEditable(false);
                            binaryCodeField.setBorder(null);
                            gbc.gridx = 1;
                            gbc.fill = GridBagConstraints.HORIZONTAL;
                            outputPanel.add(binaryCodeField, gbc);

                            JLabel savedSpaceLabel = new JLabel("SAVED SPACE:");
                            savedSpaceLabel.setFont(new Font("Arial", Font.BOLD, 16));
                            gbc.gridy++;
                            gbc.gridx = 0;
                            gbc.gridwidth = 1;
                            gbc.anchor = GridBagConstraints.WEST;
                            outputPanel.add(savedSpaceLabel, gbc);

                            JTextField savedSpaceField = new JTextField(savedSpace + "%");
                            savedSpaceField.setFont(new Font("Arial", Font.BOLD, 16));
                            savedSpaceField.setEditable(false);
                            savedSpaceField.setBorder(null);
                            gbc.gridx = 1;
                            gbc.fill = GridBagConstraints.HORIZONTAL;
                            outputPanel.add(savedSpaceField, gbc);
                        }
                    });

                    contentArea.revalidate();
                    contentArea.repaint();
                }
            }
        });


        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phraseTextField.setText("Enter a word, phrase, or code...");

                outputPanel.removeAll();
                outputPanel.revalidate();
                outputPanel.repaint();
            }
        });

        setButtonFormat(codeButton, new JButton[]{tableButton, treeButton});
    }


    private void populateTablePanel() {
        JPanel tablePanel = new JPanel();
        tablePanel.setBackground(resources.timberwolf);
        tablePanel.setLayout(new BorderLayout());
        tablePanel.setPreferredSize(new Dimension(700, 600));
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

        JTextField phraseTextField = new JTextField();
        phraseTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        phraseTextField.setText("Enter a phrase...");
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

        JButton showTableButton = new JButton("SHOW TABLE");
        showTableButton.setFont(new Font("Arial", Font.BOLD, 16));
        showTableButton.setForeground(resources.white);
        showTableButton.setBackground(resources.sage);

        JButton clearButton = new JButton("CLEAR");
        clearButton.setFont(new Font("Arial", Font.BOLD, 16));
        clearButton.setForeground(resources.white);
        clearButton.setBackground(resources.sage);

        buttonsPanel.add(showTableButton);
        buttonsPanel.add(clearButton);

        JPanel outputPanel = new JPanel();
        outputPanel.setBackground(Color.WHITE);
        outputPanel.setPreferredSize(new Dimension(600, 450));
        tablePanel.add(outputPanel, BorderLayout.SOUTH);

        showTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String phrase = phraseTextField.getText();

                if (!phrase.isEmpty() && !phrase.equals("Enter a phrase...")) {

                    Huffman huffman = new Huffman(phrase);

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

                    String encodedText = phrase;
                    String decodedText = huffman.convertToHuffmanCode(phrase);

                    JLabel encodedLabel = new JLabel("ENCODED: ");
                    encodedLabel.setFont(encodedLabel.getFont().deriveFont(Font.BOLD, 16f));

                    JLabel decodedLabel = new JLabel("DECODED: ");
                    decodedLabel.setFont(decodedLabel.getFont().deriveFont(Font.BOLD, 16f));

                    JTextField encodedTextfield = new JTextField(encodedText);
                    JTextField decodedTextfield = new JTextField(decodedText);

                    encodedTextfield.setEditable(false);
                    encodedTextfield.setBorder(null);
                    encodedTextfield.setFont(encodedTextfield.getFont().deriveFont(Font.PLAIN, 16f));
                    decodedTextfield.setEditable(false);
                    decodedTextfield.setBorder(null);
                    decodedTextfield.setFont(decodedTextfield.getFont().deriveFont(Font.PLAIN, 16f));

                    JPanel resultPanel = new JPanel(new GridBagLayout());
                    GridBagConstraints gbc = new GridBagConstraints();

                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    gbc.anchor = GridBagConstraints.CENTER;
                    resultPanel.add(encodedLabel, gbc);

                    gbc.gridx = 2;
                    resultPanel.add(decodedLabel, gbc);

                    gbc.gridx = 1;
                    gbc.gridy = 0;
                    gbc.weightx = 1.0;
                    gbc.fill = GridBagConstraints.HORIZONTAL;
                    resultPanel.add(encodedTextfield, gbc);

                    gbc.gridx = 3;
                    resultPanel.add(decodedTextfield, gbc);

                    resultPanel.setPreferredSize(new Dimension(400, 100));

                    JScrollPane tableScrollPane = new JScrollPane(huffmanTableComponent);

                    tableScrollPane.setPreferredSize(new Dimension(400, 150));

                    outputPanel.removeAll();

                    outputPanel.setLayout(new BorderLayout());
                    outputPanel.add(tableScrollPane, BorderLayout.CENTER);
                    outputPanel.add(resultPanel, BorderLayout.SOUTH);

                    // Repaint the content
                    outputPanel.revalidate();
                    outputPanel.repaint();
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phraseTextField.setText("Enter a phrase...");
            }
        });

        setButtonFormat(tableButton, new JButton[]{codeButton, treeButton});
    }

    private void populateTreePanel() {
        JPanel treePanel = new JPanel();
        treePanel.setBackground(resources.timberwolf);
        treePanel.setLayout(new BorderLayout());
        treePanel.setPreferredSize(new Dimension(700, 600));
        contentArea.removeAll();
        contentArea.add(treePanel, BorderLayout.EAST);
        contentArea.revalidate();
        contentArea.repaint();

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(resources.fernGreen);
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setPreferredSize(new Dimension(600, 150));
        treePanel.add(inputPanel, BorderLayout.CENTER);

        JLabel titleLabel = new JLabel("HUFFMAN TREE");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(resources.white);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 0, 10, 0);

        inputPanel.add(titleLabel, gbc);

        JTextField phraseTextField = new JTextField();
        phraseTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        phraseTextField.setText("Enter a phrase...");
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

        JButton showTreeButton = new JButton("SHOW TREE");
        showTreeButton.setFont(new Font("Arial", Font.BOLD, 16));
        showTreeButton.setForeground(resources.white);
        showTreeButton.setBackground(resources.sage);

        JButton clearButton = new JButton("CLEAR");
        clearButton.setFont(new Font("Arial", Font.BOLD, 16));
        clearButton.setForeground(resources.white);
        clearButton.setBackground(resources.sage);

        buttonsPanel.add(showTreeButton);
        buttonsPanel.add(clearButton);

        JPanel outputPanel = new JPanel();
        outputPanel.setBackground(Color.WHITE);
        outputPanel.setPreferredSize(new Dimension(600, 450));
        treePanel.add(outputPanel, BorderLayout.SOUTH);

        showTreeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle show tree button here
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phraseTextField.setText("Enter a phrase...");
            }
        });

        setButtonFormat(treeButton, new JButton[]{codeButton, tableButton});
    }


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

    private void setButtonFormat(JButton selectedButton, JButton[] allButtons) {
        for (JButton button : allButtons) {
            button.setForeground(resources.sage);
        }
        selectedButton.setForeground(resources.eggshellWhite);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HuffmanCodeGUI();
        });
    }
}
