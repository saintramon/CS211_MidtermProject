package Project2.frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HuffmanCodeGUI extends JFrame {

    public HuffmanCodeGUI() {
        super("Huffman Code Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setResizable(true);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel titleLabel = new JLabel("Huffman Code Application");
        titleLabel.setFont(new Font("Montserrat", Font.BOLD, 15)); // Adjusted the font size
        headerPanel.add(titleLabel);

        JPanel sidebar = populateSidebar();
        mainPanel.add(sidebar, BorderLayout.WEST);

        JPanel contentArea = new JPanel();
        contentArea.setBackground(Color.WHITE);

        mainPanel.add(contentArea, BorderLayout.CENTER);

        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel copyrightLabel = new JLabel("© RAMONSTERS 2023");
        copyrightLabel.setFont(new Font("Arial", Font.BOLD, 12)); // Bold font
        copyrightLabel.setForeground(Color.GRAY); // Adjusted the color
        footerPanel.add(copyrightLabel);

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private JPanel populateSidebar() {

        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BorderLayout());
        sidebarPanel.setPreferredSize(new Dimension(200, 600)); // Adjusted the width
        sidebarPanel.setBackground(new Color(17, 38, 59)); // Adjusted color

        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new GridBagLayout());
        optionPanel.setPreferredSize(new Dimension(100, 550));
        optionPanel.setBackground(new Color(17, 38, 59));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5, 0, 0, 0);

        JButton codeButton = createSidebarButton("Code", "icons/code-icon-black.png");
        JButton tableButton = createSidebarButton("Table", "icons/table-icon-black.png");
        JButton treeButton = createSidebarButton("Tree", "icons/tree-icon-black.png");

        gbc.gridy = 1;
        optionPanel.add(codeButton, gbc);

        gbc.gridy = 2;
        optionPanel.add(tableButton, gbc);

        gbc.gridy = 3;
        optionPanel.add(treeButton, gbc);

        sidebarPanel.add(optionPanel, BorderLayout.CENTER);
        return sidebarPanel;
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HuffmanCodeGUI();
        });
    }
}
