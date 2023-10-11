
package frontend;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUIInfixPrecedence extends JFrame{
    private final Resources resources = new Resources();
    public GUIInfixPrecedence() {
        // Main Frame
        super("Infix Statement Conversion");
       // resources.loadFonts();
       // Font titleFont = resources.montserratBold;
        setLayout(new BorderLayout());

        // SIDEBAR
        JPanel sideBar = createSideBar();
        add(sideBar, BorderLayout.WEST);

        // PAGE
        JPanel page = createPage();
        add(page, BorderLayout.CENTER);

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

        JButton homeButton = new JButton("Enter");
        homeButton.setForeground(resources.eggshellWhite);
        homeButton.setBackground(resources.grey);
        // Addresses an issue with displaying buttons on Macs
        homeButton.setOpaque(true);
        homeButton.setBorderPainted(false);
        homeButton.setBorder(resources.roundedBorder);
        homeButton.setPreferredSize(new Dimension(100, 30));

        JButton evaluateButton = new JButton("Evaluate");
        evaluateButton.setForeground(resources.eggshellWhite);
        evaluateButton.setBackground(resources.grey);
        // Addresses an issue with displaying buttons on Macs
        evaluateButton.setOpaque(true);
        evaluateButton.setBorderPainted(false);
        evaluateButton.setBorder(resources.roundedBorder);
        evaluateButton.setPreferredSize(new Dimension(100, 30));


        buttons.add(homeButton);
        buttons.add(evaluateButton);
        sidebarPanel.add(buttons, BorderLayout.CENTER);
        return sidebarPanel;
    } // end of createSideBar method

    private JPanel createPage() {

        // Page specifications
        JPanel pagePanel = new JPanel();
        pagePanel.setLayout(new BorderLayout());
        pagePanel.setBackground(resources.darkBlack);
        pagePanel.setBorder(resources.pageMargin);
        pagePanel.setPreferredSize(new Dimension(500,500));

        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(resources.darkBlack);
        contentPanel.setBorder(resources.roundedBorder);
        contentPanel.setSize(500,500);
        pagePanel.add(contentPanel, BorderLayout.CENTER);
        return pagePanel;
    }



}
