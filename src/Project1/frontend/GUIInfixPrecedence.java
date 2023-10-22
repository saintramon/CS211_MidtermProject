
package Project1.frontend;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

import Project1.backend.Expressions;

public class GUIInfixPrecedence extends JFrame {
    // BACKEND
    private Expressions expressions = new Expressions();


    // CARDS
    private JPanel infixCard;
    private JPanel evaluateCard = new JPanel();
    private JPanel homeCard = new JPanel();
    private JPanel convertTableCard = new JPanel();
    private JPanel evaluateTableCard = new JPanel();
    private CardLayout cardLayout = new CardLayout();


    private final Resources resources = new Resources();


    private  JButton homeButton;
    private JButton infixButton;
    private JButton evaluateButton;


    private JTable evaluateTable;
    private JTable convertTable;

    private JPanel infoPanel = contentPanel();

    /**
     * TODO: Documentation
     */
    public GUIInfixPrecedence() {
        // Main Frame
        super("Infix Statement Conversion");

        setIconImage(resources.logo.getImage());

        setLayout(new BorderLayout());
        resources.loadFonts();

        JPanel page = pagePanel();
        add(page, BorderLayout.CENTER);

        // SIDEBAR
        JPanel sideBar = createSideBar();
        add(sideBar, BorderLayout.WEST);

        revalidate();
        repaint();
        setSize(700, 500);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel createSideBar() {

        // Sidebar specifications
        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BorderLayout());
        sidebarPanel.setBorder(resources.titleMargin); // sidebarPanel.setBorder(new EmptyBorder(30,10,10,10);
        sidebarPanel.setBackground(resources.greyishBlack);
        sidebarPanel.setPreferredSize(new Dimension(200,500));

        // Title
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.setPreferredSize(new Dimension(200,80));
        JLabel title = resources.getAppTitle();
        title.setText("INFIX");
        title.setVerticalAlignment(SwingConstants.NORTH);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        sidebarPanel.add(title,BorderLayout.NORTH);

        // Buttons
        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        buttons.setBorder(resources.buttonMargin);
        buttons.setAlignmentY(Component.LEFT_ALIGNMENT);
        buttons.setPreferredSize(new Dimension(200, 80));
        buttons.setBackground(resources.greyishBlack);

        homeButton = new JButton("Home");
        homeButton.setFont(resources.montserratBold);
        homeButton.setForeground(resources.blue);
        homeButton.setBackground(resources.greyishBlack);
        homeButton.setOpaque(false);
        homeButton.setBorderPainted(false);
        homeButton.setFocusPainted(false);
        homeButton.setHorizontalAlignment(SwingConstants.LEFT);
        homeButton.setPreferredSize(new Dimension(150, 30));


        infixButton = new JButton("Conversion");
        infixButton.setFont(resources.montserratBold);
        infixButton.setForeground(resources.eggshellWhite);
        infixButton.setBackground(resources.greyishBlack);
        infixButton.setFocusPainted(false);
        infixButton.setOpaque(false);
        infixButton.setBorderPainted(false);
        infixButton.setHorizontalAlignment(SwingConstants.LEFT);
        infixButton.setPreferredSize(new Dimension(150, 30));

        evaluateButton = new JButton("Evaluate");
        evaluateButton.setFont(resources.montserratBold);
        evaluateButton.setBackground(resources.greyishBlack);
        evaluateButton.setForeground(resources.eggshellWhite);
        evaluateButton.setFocusPainted(false);
        evaluateButton.setOpaque(false);
        evaluateButton.setBorderPainted(false);
        evaluateButton.setHorizontalAlignment(SwingConstants.LEFT);
        evaluateButton.setPreferredSize(new Dimension(150, 30));

        infixButton.addActionListener(e-> {
            cardLayout.show(infoPanel, "infixCard");
            homeButton.setForeground(resources.eggshellWhite);
            evaluateButton.setForeground(resources.eggshellWhite);
            infixButton.setForeground(resources.blue);
        });

        evaluateButton.addActionListener(e-> {
            cardLayout.show(infoPanel, "evaluateCard");
            homeButton.setForeground(resources.eggshellWhite);
            evaluateButton.setForeground(resources.blue);
            infixButton.setForeground(resources.eggshellWhite);
        });

        homeButton.addActionListener(e -> {
            cardLayout.show(infoPanel, "homeCard");
            homeButton.setForeground(resources.blue);
            evaluateButton.setForeground(resources.eggshellWhite);
            infixButton.setForeground(resources.eggshellWhite);
        });

        infixButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(resources.handCursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(resources.defaultCursor);
            }
        });

        evaluateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(resources.handCursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(resources.defaultCursor);
            }
        });

        homeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(resources.handCursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(resources.defaultCursor);
            }
        });

        buttons.add(homeButton);
        buttons.add(infixButton);
        buttons.add(evaluateButton);
        sidebarPanel.add(buttons, BorderLayout.CENTER);
        return sidebarPanel;
    } // end of createSideBar method

    private JPanel pagePanel() {
        // Page specifications
        JPanel pagePanel = new JPanel();
        pagePanel.setLayout(new BorderLayout());
        pagePanel.setBackground(resources.darkBlack);
        pagePanel.setBorder(resources.pageMargin);
        pagePanel.setPreferredSize(new Dimension(500,500));

        pagePanel.add(infoPanel);
        return pagePanel;
    }

    private JPanel contentPanel() {
        infoPanel = new JPanel();
        infoPanel.setLayout(cardLayout);
        infoPanel.setBackground(resources.darkBlack);
        infoPanel.setBorder(resources.getRoundedBorder(resources.greyishBlack, resources.greyishBlack));
        infoPanel.setSize(500,500);

        // PAGE
        evaluateCard = populateEvaluateCard();
        homeCard = populateHomeCard();
        infoPanel.add(homeCard, "homeCard");
        infoPanel.add(evaluateCard, "evaluateCard");


        infixCard = populateInfixCard();
        infoPanel.add(infixCard, "infixCard");


        convertTableCard= populateConvertTableCard();
        infoPanel.add(convertTableCard, "convertTableCard");

        evaluateTableCard = populateEvaluateTableCard();
        infoPanel.add(evaluateTableCard, "evaluateTableCard");

        cardLayout.show(infoPanel, "homeCard");

        return infoPanel;
    }

    private JPanel populateHomeCard() {
        JPanel homePanel = new JPanel();
        homePanel.setBackground(resources.greyishBlack);
        homePanel.setBorder(resources.getRoundedBorder(resources.greyishBlack, resources.greyishBlack));
        homePanel.setLayout(new BorderLayout());

        JLabel title = new JLabel("Welcome to the Infix Expression Converter and Evaluator!");
        title.setForeground(Color.WHITE);
        homePanel.add(title, BorderLayout.NORTH);

        JTextArea instructionTextArea = new JTextArea(
                "This program helps you convert infix expressions into postfix notation for evaluation " +
                        "to simplify expressions.\n\n"
                        + "Accepted Operators and Parentheses:\n"
                        + "You can only use the following operators: + (addition), - (subtraction), * " +
                        "(multiplication), / (division), and ^ (exponentiation). You can use parentheses " +
                        "( and ) to control the order of operations.\n\n"
                        + "General Instructions:\n"
                        + "1. Click the 'Convert' button to see the expression in postfix notation.\n"
                        + "2. Click the 'Evaluate' button to calculate the result of the postfix expression.\n"
                        + "3. Do not use spaces when writing the expression, e.g., \"3+4\" not \"3 + 4\".\n"
                        + "4. The program will return an error message for improperly formatted expressions.\n\n"
                        + "Thank you for using our program. Let's get started!"
        );
        instructionTextArea.setFont(resources.montserratBold);
        instructionTextArea.setWrapStyleWord(true);
        instructionTextArea.setLineWrap(true);
        instructionTextArea.setOpaque(false);
        instructionTextArea.setEditable(false);
        instructionTextArea.setForeground(Color.WHITE);

        homePanel.add(instructionTextArea, BorderLayout.CENTER);

        return homePanel;
    }

    private JPanel populateInfixCard() {
        JPanel infixPanel = new JPanel();
        infixPanel.setLayout(new BorderLayout());
        infixPanel.setBackground(resources.greyishBlack);
        infixPanel.setBorder(resources.getRoundedBorder(resources.greyishBlack, resources.greyishBlack));
        infixPanel.setPreferredSize(new Dimension(500,300));
        JLabel title = resources.getPanelTitle();
        title.setText("Infix Precedence Conversion");

        // HOLDS INPUT
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.setBackground(resources.greyishBlack);
        inputPanel.setBorder(resources.getRoundedBorder(resources.lightGrey, resources.lightGrey));

        JTextField expressionField = new RoundJTextField(50);

        expressionField.setBackground(resources.lightestGrey);

        expressionField.setText("  Enter expression");
        expressionField.setPreferredSize(new Dimension(90, 40));
        expressionField.setForeground(resources.eggshellWhite);
        expressionField.setEditable(true);
        inputPanel.add(expressionField, BorderLayout.NORTH);
        inputPanel.setOpaque(true);

        // Implementations
        expressionField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (expressionField.getText().isEmpty() || expressionField.getText().equals("  Enter expression")) {
                    expressionField.setText("");
                } // end of if
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (expressionField.getText().isEmpty())
                    expressionField.setText("  Enter expression");
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BorderLayout());

        RoundJButton convertButton = new RoundJButton();
        convertButton.setText("Convert");
        convertButton.setForeground(resources.eggshellWhite);
        convertButton.setBackground(resources.lightestGrey);

        RoundJButton clearButton = new RoundJButton();
        clearButton.setText("Clear");
        clearButton.setForeground(resources.eggshellWhite);
        clearButton.setBackground(resources.lightestGrey);


        buttonsPanel.setBackground(resources.lightGrey);
        buttonsPanel.add(convertButton, BorderLayout.WEST);
        buttonsPanel.add(clearButton, BorderLayout.EAST);


        convertButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                convertButton.setForeground(resources.darkBlack);
                convertButton.setBackground(resources.blue);
                setCursor(resources.handCursor);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                convertButton.setForeground(resources.eggshellWhite);
                convertButton.setBackground(resources.lightestGrey);
                setCursor(resources.defaultCursor);

            }
        });

        clearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearButton.setForeground(resources.darkBlack);
                clearButton.setBackground(resources.blue);
                clearButton.setCursor(resources.handCursor);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearButton.setForeground(resources.eggshellWhite);
                clearButton.setBackground(resources.lightestGrey);
                clearButton.setCursor(resources.defaultCursor);
            }
        });

        inputPanel.setPreferredSize(new Dimension(50, 200));
        //buttonsPanel.setPreferredSize(new Dimension(100, 100));
        convertButton.setPreferredSize(new Dimension(150, 50));
        clearButton.setPreferredSize(new Dimension(150, 50));

        inputPanel.add(buttonsPanel, BorderLayout.SOUTH);

        // HOLDS EVALUATE REDIRECT BUTTONS
        JPanel evaluatePanel = new JPanel();
        evaluatePanel.setLayout(new BorderLayout());
        evaluatePanel.setBackground(resources.greyishBlack);
        evaluatePanel.setBorder(resources.getRoundedBorder(resources.greyishBlack, resources.greyishBlack));
        evaluatePanel.setBorder(resources.getRoundedBorder(resources.greyishBlack, resources.greyishBlack));
        evaluatePanel.setPreferredSize(new Dimension(500, 160));

        JLabel resultsTitle = resources.getPanelTitle();
        resultsTitle.setText("Results");
        evaluatePanel.add(resultsTitle, BorderLayout.NORTH);

        JPanel resultsPanel = new JPanel();
        resultsPanel.setLayout(new BorderLayout());
        resultsPanel.setBackground(resources.greyishBlack);
        resultsPanel.setBorder(resources.getRoundedBorder(resources.lightGrey, resources.lightGrey));

        JLabel resultExpression = resources.getPanelTitle();
        resultExpression.setText("");
        resultExpression.setHorizontalAlignment(SwingConstants.LEFT);
        resultExpression.setVerticalAlignment(SwingConstants.CENTER);
        resultsPanel.add(resultExpression, BorderLayout.CENTER);

        evaluatePanel.add(resultsPanel, BorderLayout.CENTER);

        convertButton.addActionListener(e -> {
            if (!expressionField.getText().isEmpty() || !expressionField.getText().equals("  Enter expression")) {
                if (expressions.validateParentheses(expressionField.getText())) {
                    resultExpression.setText(expressions.convertToPostfix(expressionField.getText(), convertTable));
                    System.out.println(resultExpression.getText());
                } else {
                    resultExpression.setText("Syntax error. Try again.");
                    resultExpression.setForeground(Color.RED);
                } // end of if-else (user input for infix expression)
            } else {
                resultExpression.setText("Input empty.");
            } // end of if-else (empty expression field)
        });

        clearButton.addActionListener(e -> {
            resultExpression.setText("");
            expressionField.setText("  Enter expression");
            resultExpression.setForeground(Color.white);
        });

        JPanel iconPanel = new JPanel();
        iconPanel.setLayout(new BorderLayout());
        iconPanel.setBackground(resources.greyishBlack);

        JPanel evaluateButtonPanel = new JPanel();
        evaluateButtonPanel.setLayout(new BorderLayout());
        evaluateButtonPanel.setBackground(resources.greyishBlack);

        RoundJButton evaluateButton = new RoundJButton();
        evaluateButton.setText("Evaluate");
        evaluateButton.setForeground(resources.eggshellWhite);
        evaluateButton.setBackground(resources.lightestGrey);
        evaluateButton.setPreferredSize(new Dimension(120,30));

        evaluateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                evaluateButton.setForeground(resources.darkBlack);
                evaluateButton.setBackground(resources.blue);
                evaluateButton.setCursor(resources.handCursor);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                evaluateButton.setForeground(resources.eggshellWhite);
                evaluateButton.setBackground(resources.lightestGrey);
                evaluateButton.setCursor(resources.defaultCursor);
            }
        });

        ImageIcon rightArrow = new ImageIcon("icons/right_arrow.png");
        Image rightArrowImage = rightArrow.getImage();
        Image rightArrowImageResized = rightArrowImage.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
        rightArrow = new ImageIcon(rightArrowImageResized);
        JButton evaluateIcon = new JButton(rightArrow);
        evaluateIcon.setPreferredSize(new Dimension(50, 40));
        evaluateIcon.setHorizontalAlignment(SwingConstants.RIGHT);
        evaluateIcon.setVerticalAlignment(SwingConstants.BOTTOM);
        evaluateIcon.setOpaque(false);

        evaluateIcon.setContentAreaFilled(false);
        evaluateIcon.setBorderPainted(false);
        evaluateIcon.setFocusPainted(false);

        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new BorderLayout());
        footerPanel.setBackground(resources.greyishBlack);
        footerPanel.add(evaluateButtonPanel, BorderLayout.WEST);
        footerPanel.add(iconPanel, BorderLayout.EAST);

        JPanel emptyPanel = new JPanel();
        emptyPanel.setBackground(resources.greyishBlack);
        footerPanel.add(emptyPanel, BorderLayout.NORTH);

        evaluateButtonPanel.setPreferredSize(new Dimension(150,30));
        iconPanel.setPreferredSize(new Dimension(50,30));


        iconPanel.add(evaluateIcon, BorderLayout.EAST);
        evaluateButtonPanel.add(evaluateButton,BorderLayout.WEST);
        evaluatePanel.add(footerPanel,BorderLayout.SOUTH);

        evaluateIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(infoPanel, "convertTableCard");
            }
        });

        evaluateIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(resources.handCursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(resources.defaultCursor);
            }
        });

        infixPanel.add(title, BorderLayout.NORTH);
        infixPanel.add(inputPanel, BorderLayout.CENTER);
        infixPanel.add(evaluatePanel, BorderLayout.SOUTH);
        return infixPanel;
    }

    private JPanel populateEvaluateCard() {
        //!
        JPanel evaluatePanel = new JPanel();
        evaluatePanel.setLayout(new BorderLayout());
        evaluatePanel.setBackground(resources.greyishBlack);
        evaluatePanel.setBorder(resources.getRoundedBorder(resources.greyishBlack,resources.greyishBlack));
        evaluatePanel.setPreferredSize(new Dimension(500,300));
        JLabel title = resources.getPanelTitle();
        title.setText("Postfix Evaluation");


        /**
         * !! INPUT PANEL
         *
         * Holds the Textfield and the Buttons
         */
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.setBackground(resources.greyishBlack);
        inputPanel.setBorder(resources.getRoundedBorder(resources.lightGrey,resources.lightGrey));
        inputPanel.setOpaque(true);
        inputPanel.setPreferredSize(new Dimension(50,200));

        JTextField inputField = new RoundJTextField(50);
        inputField.setText("  Enter Postfix Expression");
        inputField.setPreferredSize(new Dimension(90,40));
        inputField.setForeground(resources.eggshellWhite);
        inputField.setEditable(true);
        inputField.setBackground(resources.lightestGrey);

        inputField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (inputField.getText().isEmpty() || inputField.getText().equals("  Enter Postfix Expression")) {
                    inputField.setText("");
                } // end of if
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (inputField.getText().isEmpty())
                    inputField.setText("  Enter Postfix Expression");
            }
        });
        /**
         * !!! BUTTONS PANEL
         *
         * Holds the buttons
         */
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BorderLayout());
        buttonsPanel.setBackground(resources.lightGrey);

        RoundJButton evaluateButton = new RoundJButton();
        evaluateButton.setText("Evaluate");
        evaluateButton.setBackground(resources.lightestGrey);
        evaluateButton.setForeground(resources.eggshellWhite);
        evaluateButton.setPreferredSize(new Dimension(150,50));

        RoundJButton clearButton = new RoundJButton();
        clearButton.setText("Clear");
        clearButton.setForeground(resources.eggshellWhite);
        clearButton.setBackground(resources.lightestGrey);
        clearButton.setPreferredSize(new Dimension(150,50));

        evaluateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                evaluateButton.setForeground(resources.darkBlack);
                evaluateButton.setBackground(resources.blue);
                setCursor(resources.handCursor);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                evaluateButton.setForeground(resources.eggshellWhite);
                evaluateButton.setBackground(resources.lightestGrey);
                setCursor(resources.defaultCursor);
            }
        });

        clearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearButton.setForeground(resources.darkBlack);
                clearButton.setBackground(resources.blue);
                setCursor(resources.handCursor);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearButton.setForeground(resources.eggshellWhite);
                clearButton.setBackground(resources.lightestGrey);
                setCursor(resources.defaultCursor);
            }
        });

        /**
         * !! RESULTS PANEL
         *
         * Holds the result components
         */
        JPanel resultsPanel = new JPanel();
        resultsPanel.setLayout(new BorderLayout());
        resultsPanel.setBackground(resources.greyishBlack);
        resultsPanel.setBorder(resources.getRoundedBorder(resources.greyishBlack,resources.greyishBlack));
        resultsPanel.setPreferredSize(new Dimension(500,160));

        JLabel resultsTitle = resources.getPanelTitle();
        resultsTitle.setText("Results");

        /**
         * !!! ANSWER PANEL
         *
         * Holds the text field in which the answer will be displayed
         */
        JPanel answerPanel = new JPanel();
        answerPanel.setLayout(new BorderLayout());
        answerPanel.setBackground(resources.greyishBlack);
        answerPanel.setBorder(resources.getRoundedBorder(resources.lightGrey,resources.lightGrey));

        JLabel answerLabel = resources.getPanelTitle();
        answerLabel.setText("");
        answerLabel.setHorizontalAlignment(SwingConstants.LEFT);
        answerLabel.setVerticalAlignment(SwingConstants.CENTER);

        clearButton.addActionListener(e -> {
            inputField.setText("  Enter Postfix Expression");
            answerLabel.setText("");
            answerLabel.setForeground(Color.WHITE);
        });

        /**
         * !!! ICON PANEL
         *
         * Holds the icon for the results panel
         */
        JPanel iconPanel = new JPanel();
        iconPanel.setLayout(new BorderLayout());
        iconPanel.setBackground(resources.greyishBlack);

        ImageIcon rightArrow = new ImageIcon("icons/right_arrow.png");
        Image rightArrowImage = rightArrow.getImage();
        Image rightArrowImageResized = rightArrowImage.getScaledInstance(20,20, Image.SCALE_SMOOTH);
        rightArrow = new ImageIcon(rightArrowImageResized);

        JButton evaluateIcon = new JButton(rightArrow);
        evaluateIcon.setPreferredSize(new Dimension(50,40));
        evaluateIcon.setHorizontalAlignment(SwingConstants.RIGHT);
        evaluateIcon.setVerticalAlignment(SwingConstants.BOTTOM);
        evaluateIcon.setOpaque(false);
        evaluateIcon.setContentAreaFilled(false);
        evaluateIcon.setBorderPainted(false);
        evaluateIcon.setFocusPainted(false);

        evaluateIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(infoPanel, "evaluateTableCard");
            }
        });

        evaluateIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(resources.handCursor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(resources.defaultCursor);
            }
        });

        evaluateButton.addActionListener(e -> {
            if (expressions.validateParentheses(inputField.getText())) {
                String postfixExpression = inputField.getText();
                double result = expressions.evaluatePostfix(postfixExpression, evaluateTable);
                answerLabel.setText(String.valueOf(result));
                // answerLabel.setText(String.valueOf(expressions.evaluatePostfix(inputField.getText(), evaluateTable)));
            } else {
                answerLabel.setText("Syntax error. Try again.");
                answerLabel.setForeground(Color.RED);
            }

        });

        //POPULATE BUTTON PANEL !!!
        buttonsPanel.add(evaluateButton,BorderLayout.WEST);
        buttonsPanel.add(clearButton,BorderLayout.EAST);

        //POPULATE INPUT PANEL !!
        inputPanel.add(inputField,BorderLayout.NORTH);
        inputPanel.add(buttonsPanel,BorderLayout.SOUTH);

        //POPULATE ANSWER PANEL !!!
        answerPanel.add(answerLabel,BorderLayout.CENTER);

        //POPULATE ICON PANEL !!!
        iconPanel.add(evaluateIcon,BorderLayout.EAST);

        //POPULATE RESULTS PANEL !!
        resultsPanel.add(resultsTitle, BorderLayout.NORTH);
        resultsPanel.add(answerPanel,BorderLayout.CENTER);
        resultsPanel.add(iconPanel,BorderLayout.SOUTH);

        //POPULATE EVALUATE PANEL !
        evaluatePanel.add(title, BorderLayout.NORTH);
        evaluatePanel.add(inputPanel,BorderLayout.CENTER);
        evaluatePanel.add(resultsPanel,BorderLayout.SOUTH);

        return evaluatePanel;
    }

    private JPanel populateConvertTableCard() {
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        tablePanel.setBackground(resources.greyishBlack);
        tablePanel.setBorder(resources.getRoundedBorder(resources.greyishBlack, resources.greyishBlack));
        tablePanel.setSize(500,500);
        JLabel title = new JLabel("CONVERSION TABLE");
        title.setForeground(Color.WHITE);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Symbol");
        tableModel.addColumn("Postfix");
        tableModel.addColumn("Stack");
        convertTable = new JTable(tableModel);


        tablePanel.add(title, BorderLayout.NORTH);
        tablePanel.add(new JScrollPane(convertTable), BorderLayout.CENTER);
        return tablePanel;
    }

    private JPanel populateEvaluateTableCard(){
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        tablePanel.setBackground(resources.greyishBlack);
        tablePanel.setBorder(resources.getRoundedBorder(resources.greyishBlack, resources.greyishBlack));
        tablePanel.setSize(500,500);
        JLabel title = new JLabel("EVALUATION TABLE");
        title.setForeground(Color.white);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Symbol");
        tableModel.addColumn("Stack");
        evaluateTable = new JTable(tableModel);

        tablePanel.add(title, BorderLayout.NORTH);
        tablePanel.add(new JScrollPane(evaluateTable),BorderLayout.CENTER);
        return tablePanel;
    }

}
