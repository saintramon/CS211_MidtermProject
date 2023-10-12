
package frontend;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUIInfixPrecedence extends JFrame{

    // INFIX CARD
    private JPanel infixCard;

    // EVALUATE CARD
    private JPanel evaluateCard = new JPanel();

    private JPanel homeCard = new JPanel();

    private CardLayout cardLayout = new CardLayout();

    private JPanel contentPanel;


    private final Resources resources = new Resources();


    private  JButton homeButton;
    private JButton infixButton;
    private JButton evaluateButton;

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
        JLabel title = new JLabel();
        title.setText("Infix Precedence");
        title.setVerticalAlignment(SwingConstants.NORTH);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setForeground(resources.eggshellWhite);
        sidebarPanel.add(title,BorderLayout.NORTH);

        // Buttons
        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        buttons.setBorder(resources.buttonMargin);
        buttons.setPreferredSize(new Dimension(200, 80));
        buttons.setBackground(resources.greyishBlack);

        homeButton = resources.getRoundedButton();
        homeButton.setText("Home");
        homeButton.setForeground(resources.eggshellWhite);
        homeButton.setBackground(resources.grey);
        homeButton.setPreferredSize(new Dimension(100, 30));

        infixButton = new JButton("Infix");
        infixButton.setForeground(resources.eggshellWhite);
        infixButton.setOpaque(false);
        infixButton.setBorderPainted(false);
        infixButton.setPreferredSize(new Dimension(100, 30));

        evaluateButton = new JButton("Evaluate");
        evaluateButton.setForeground(resources.eggshellWhite);
        evaluateButton.setOpaque(false);
        evaluateButton.setBorderPainted(false);
        evaluateButton.setPreferredSize(new Dimension(100, 30));

        infixButton.addActionListener(e-> {
            cardLayout.show(contentPanel, "infixCard");
        });

        evaluateButton.addActionListener(e-> {
            cardLayout.show(contentPanel, "evaluateCard");
        });

        homeButton.addActionListener(e -> {
            cardLayout.show(contentPanel, "homeCard");
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

        JPanel contentPanel = contentPanel();
        pagePanel.add(contentPanel);
        return pagePanel;
    }

    private JPanel contentPanel() {
        contentPanel = new JPanel();
        contentPanel.setLayout(cardLayout);
        contentPanel.setBackground(resources.darkBlack);
        contentPanel.setBorder(resources.getRoundedBorder(resources.greyishBlack, resources.greyishBlack));
        contentPanel.setSize(500,500);

        // PAGE
        infixCard = populateInfixCard();
        evaluateCard = populateEvaluateCard();
        homeCard = populateHomeCard();
        contentPanel.add(infixCard,BorderLayout.CENTER);
        contentPanel.add(infixCard, "infixCard");
        contentPanel.add(homeCard, "homeCard");
        contentPanel.add(evaluateCard, "evaluateCard");

        cardLayout.show(contentPanel, "homeCard");

        return contentPanel;
    }

    private JPanel populateHomeCard() {
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(resources.greyishBlack);
        contentPanel.setBorder(resources.getRoundedBorder(resources.greyishBlack, resources.greyishBlack));
        contentPanel.setSize(500,500);
        JLabel title = new JLabel("THIS IS HOME CARD");
        title.setForeground(Color.WHITE);
        contentPanel.add(title);
        return contentPanel;
    }

    private JPanel populateInfixCard() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(resources.greyishBlack);
        contentPanel.setBorder(resources.getRoundedBorder(resources.greyishBlack, resources.greyishBlack));
        contentPanel.setPreferredSize(new Dimension(500,500));
        JLabel title = resources.getPanelTitle();
        title.setText("  Infix Precedence Conversion");

        // HOLDS INPUT
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout());
        inputPanel.setBackground(resources.greyishBlack);
        inputPanel.setSize(40,30);
        inputPanel.setBorder(resources.getRoundedBorder(resources.lightGrey, resources.lightGrey));

        // HOLDS EVALUATE REDIRECT BUTTONS
        JPanel evaluatePanel = new JPanel();
        evaluatePanel.setLayout(cardLayout);
        evaluatePanel.setBackground(Color.BLUE);
        evaluatePanel.setBorder(resources.getRoundedBorder(resources.lightGrey, resources.lightGrey));


        contentPanel.add(title, BorderLayout.NORTH);
        contentPanel.add(inputPanel, BorderLayout.CENTER);
        return contentPanel;
    }

    private JPanel populateEvaluateCard() {
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(resources.greyishBlack);
        contentPanel.setBorder(resources.getRoundedBorder(resources.greyishBlack, resources.greyishBlack));
        contentPanel.setSize(500,500);
        JLabel title = new JLabel("THIS IS EVALUATE CARD");
        title.setForeground(Color.WHITE);
        contentPanel.add(title);
        return contentPanel;
    }



}
