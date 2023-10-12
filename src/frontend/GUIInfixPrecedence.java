
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

    private JPanel infoCard = new JPanel();

    private CardLayout cardLayout = new CardLayout();

    private JPanel contentPanel;


    private final Resources resources = new Resources();

    private JButton infixButton;
    public GUIInfixPrecedence() {
        // Main Frame
        super("Infix Statement Conversion");

        setLayout(new BorderLayout());

        JPanel page = populateInfoCard();
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

    private JPanel populateInfixCard() {
        // Page specifications
        JPanel pagePanel = new JPanel();
        pagePanel.setLayout(new BorderLayout());
        pagePanel.setBackground(resources.darkBlack);
        pagePanel.setBorder(resources.pageMargin);
        pagePanel.setPreferredSize(new Dimension(500,500));

        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.ORANGE);
        contentPanel.setBorder(resources.roundedBorder);
        contentPanel.setSize(500,500);
        pagePanel.add(contentPanel, BorderLayout.CENTER);
        JLabel title = new JLabel("THIS IS INFIX CARD");
        title.setForeground(Color.WHITE);
        contentPanel.add(title);
        return pagePanel;
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

        infixButton = new JButton("Infix");
        infixButton.setForeground(resources.eggshellWhite);
        infixButton.setBackground(resources.grey);
        infixButton.setBorderPainted(false);
        // Addresses an issue with displaying buttons on Macs
        infixButton.setOpaque(true);
        infixButton.setBorderPainted(false);
        infixButton.setBorder(resources.roundedBorder);
        infixButton.setPreferredSize(new Dimension(100, 30));

        JButton evaluateButton = new JButton("Evaluate");
        evaluateButton.setForeground(resources.eggshellWhite);
        evaluateButton.setBackground(resources.grey);
        // Addresses an issue with displaying buttons on Macs
        evaluateButton.setOpaque(true);
        evaluateButton.setBorderPainted(false);
        evaluateButton.setBorder(resources.roundedBorder);
        evaluateButton.setPreferredSize(new Dimension(100, 30));

        infixButton.addActionListener(e-> {
            cardLayout.show(contentPanel, "infixCard");

        });


        buttons.add(infixButton);
        buttons.add(evaluateButton);
        sidebarPanel.add(buttons, BorderLayout.CENTER);
        return sidebarPanel;
    } // end of createSideBar method

    private JPanel populateInfoCard() {

        // Page specifications
        JPanel pagePanel = new JPanel();
        pagePanel.setLayout(new BorderLayout());
        pagePanel.setBackground(resources.darkBlack);
        pagePanel.setBorder(resources.pageMargin);
        pagePanel.setPreferredSize(new Dimension(500,500));

        contentPanel = new JPanel();
        contentPanel.setLayout(cardLayout);
        contentPanel.setBackground(resources.darkBlack);
        contentPanel.setBorder(resources.roundedBorder);
        contentPanel.setSize(500,500);
        pagePanel.add(contentPanel, BorderLayout.CENTER);
        JLabel title = new JLabel("THIS IS INFO CARD");
        title.setForeground(Color.WHITE);
        contentPanel.add(title);

        // PAGE


        infixCard = populateInfixCard();
        contentPanel.add(infixCard,BorderLayout.CENTER);
        contentPanel.add(infixCard, "infixCard");
        contentPanel.add(infoCard, "infoCard");
        contentPanel.add(evaluateCard, "evaluateCard");

        return pagePanel;
    }



}
