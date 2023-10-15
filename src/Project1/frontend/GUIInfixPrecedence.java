
package Project1.frontend;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIInfixPrecedence extends JFrame{

    // CARDS
    private JPanel infixCard;
    private JPanel evaluateCard = new JPanel();
    private JPanel homeCard = new JPanel();
    private JPanel tableCard = new JPanel();
    private CardLayout cardLayout = new CardLayout();



    private final Resources resources = new Resources();


    private  JButton homeButton;
    private JButton infixButton;
    private JButton evaluateButton;

    private JPanel infoPanel = contentPanel();

    public GUIInfixPrecedence() {
        // Main Frame
        super("Infix Statement Conversion");

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
        homeButton.setOpaque(false);
        homeButton.setBorderPainted(false);
        homeButton.setFocusPainted(false);
        homeButton.setHorizontalAlignment(SwingConstants.LEFT);
        homeButton.setPreferredSize(new Dimension(150, 30));

        infixButton = new JButton("Conversion");
        infixButton.setFont(resources.montserratBold);
        infixButton.setForeground(resources.eggshellWhite);
        infixButton.setFocusPainted(false);
        infixButton.setOpaque(false);
        infixButton.setBorderPainted(false);
        infixButton.setHorizontalAlignment(SwingConstants.LEFT);
        infixButton.setPreferredSize(new Dimension(150, 30));

        evaluateButton = new JButton("Evaluate");
        evaluateButton.setFont(resources.montserratBold);
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


        tableCard = populateTableCard();
        infoPanel.add(tableCard, "tableCard");

        cardLayout.show(infoPanel, "homeCard");

        return infoPanel;
    }

    private JPanel populateHomeCard() {
        JPanel homePanel = new JPanel();
        homePanel.setBackground(resources.greyishBlack);
        homePanel.setBorder(resources.getRoundedBorder(resources.greyishBlack, resources.greyishBlack));
        homePanel.setSize(500,500);
        JLabel title = new JLabel("THIS IS HOME CARD");
        title.setForeground(Color.WHITE);
        homePanel.add(title);
        return homePanel;
    }

    private JPanel populateInfixCard() {
        JPanel infixPanel = new JPanel();
        infixPanel.setLayout(new BorderLayout());
        infixPanel.setBackground(resources.greyishBlack);
        infixPanel.setBorder(resources.getRoundedBorder(resources.greyishBlack, resources.greyishBlack));
        infixPanel.setPreferredSize(new Dimension(500,300));
        JLabel title = resources.getPanelTitle();
        title.setText("  Infix Precedence Conversion");

        // HOLDS INPUT
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.setBackground(resources.greyishBlack);
        inputPanel.setBorder(resources.getRoundedBorder(resources.lightGrey, resources.lightGrey));

        JTextField expressionField = new RoundJTextField(50);

        expressionField.setBackground(resources.lightestGrey);

        expressionField.setText("  Enter expression");
        expressionField.setPreferredSize(new Dimension(90, 50));
        expressionField.setForeground(resources.eggshellWhite);
        expressionField.setEditable(true);
        inputPanel.add(expressionField, BorderLayout.NORTH);
        inputPanel.setOpaque(true);


        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BorderLayout());

        RoundJButton convertButton = new RoundJButton();
        convertButton.setText("Convert");
        convertButton.setBackground(resources.eggshellWhite);
        convertButton.setForeground(resources.blue);
        convertButton.setFont(resources.montserratBlack);

        RoundJButton clearButton = new RoundJButton();
        clearButton.setText("Clear");
        clearButton.setForeground(resources.blue);
        clearButton.setFont(resources.montserratBlack);


        buttonsPanel.setBackground(resources.lightGrey);
        buttonsPanel.add(convertButton, BorderLayout.WEST);
        buttonsPanel.add(clearButton, BorderLayout.EAST);


        convertButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                convertButton.setBackground(resources.blue);
                convertButton.setForeground(Color.BLACK);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                convertButton.setBackground(resources.eggshellWhite);
                convertButton.setForeground(resources.blue);
            }
        });

        clearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearButton.setBackground(resources.blue);
                clearButton.setForeground(Color.BLACK);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearButton.setBackground(resources.eggshellWhite);
                clearButton.setForeground(resources.blue);
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
        resultExpression.setText("  xy+ab-");
        resultExpression.setHorizontalAlignment(SwingConstants.LEFT);
        resultExpression.setVerticalAlignment(SwingConstants.CENTER);
        resultsPanel.add(resultExpression, BorderLayout.CENTER);

        evaluatePanel.add(resultsPanel, BorderLayout.CENTER);


        JPanel iconPanel = new JPanel();
        iconPanel.setLayout(new BorderLayout());
        iconPanel.setBackground(resources.greyishBlack);

        ImageIcon rightArrow = new ImageIcon("icons/right_arrow.png");
        Image rightArrowImage = rightArrow.getImage();
        Image rightArrowImageResized = rightArrowImage.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
        rightArrow = new ImageIcon(rightArrowImageResized);
        JButton evaluateIcon = new JButton(rightArrow);
        evaluateIcon.setPreferredSize(new Dimension(20, 30));
        evaluateIcon.setHorizontalAlignment(SwingConstants.RIGHT);
        evaluateIcon.setVerticalAlignment(SwingConstants.BOTTOM);
        evaluateIcon.setOpaque(false);

        evaluateIcon.setContentAreaFilled(false);
        evaluateIcon.setBorderPainted(false);
        evaluateIcon.setFocusPainted(false);

        iconPanel.add(evaluateIcon, BorderLayout.EAST);
        evaluatePanel.add(iconPanel,BorderLayout.SOUTH);

        evaluateIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(infoPanel, "tableCard");
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
        inputField.setText("Enter Postfix Expression");
        inputField.setPreferredSize(new Dimension(90,50));
        inputField.setForeground(resources.eggshellWhite);
        inputField.setEditable(true);
        inputField.setBackground(resources.lightestGrey);

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
        evaluateButton.setBackground(resources.eggshellWhite);
        evaluateButton.setForeground(resources.blue);
        evaluateButton.setFont(resources.montserratBlack);
        evaluateButton.setPreferredSize(new Dimension(150,50));


        RoundJButton clearButton = new RoundJButton();
        clearButton.setText("Clear");
        clearButton.setForeground(resources.blue);
        clearButton.setFont(resources.montserratBlack);
        clearButton.setPreferredSize(new Dimension(150,50));

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
        answerLabel.setText("42069");
        answerLabel.setHorizontalAlignment(SwingConstants.LEFT);
        answerLabel.setVerticalAlignment(SwingConstants.CENTER);

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
        evaluateIcon.setPreferredSize(new Dimension(20,30));
        evaluateIcon.setHorizontalAlignment(SwingConstants.RIGHT);
        evaluateIcon.setVerticalAlignment(SwingConstants.BOTTOM);
        evaluateIcon.setOpaque(false);
        evaluateIcon.setContentAreaFilled(false);
        evaluateIcon.setBorderPainted(false);
        evaluateIcon.setFocusPainted(false);





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

    private JPanel populateTableCard() {
        JPanel tablePanel = new JPanel();
        tablePanel.setBackground(resources.greyishBlack);
        tablePanel.setBorder(resources.getRoundedBorder(resources.greyishBlack, resources.greyishBlack));
        tablePanel.setSize(500,500);
        JLabel title = new JLabel("THIS IS TABLE CARD");
        title.setForeground(Color.WHITE);
        tablePanel.add(title);
        return tablePanel;
    }



}
