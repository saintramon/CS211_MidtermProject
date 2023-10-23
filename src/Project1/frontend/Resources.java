package Project1.frontend;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * The Resources class provides access to various resources, including fonts, colors,
 * cursors, and UI elements for use in the application.
 */
public class Resources {
    /**
     *  The thin, regular, bold, and black Montserrat font
     */
    Font montserratThin, montserrat, montserratBold, montserratBlack;

    /**
     * The application logo as an ImageIcon.
     */
    ImageIcon logo = new ImageIcon("icons/logo.png");

    /**
     * Cursor used for buttons
     */
    Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);

    /**
     * Default cursor
     */
    Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);

    /**
     * Cursor used for texts
     */
    Cursor textCursor = new Cursor(Cursor.TEXT_CURSOR);

    /**
     * Loads a custom fonts for the application.
     */
    void loadFonts() {
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

            // Montserrat Thin
            montserratThin = Font.createFont(Font.TRUETYPE_FONT,
                    new File("fonts/Montserrat/static/Montserrat-Thin.ttf")).deriveFont(20f);
            ge.registerFont(montserratThin);

            // Montserrat Regular
            montserrat = Font.createFont(Font.TRUETYPE_FONT,
                    new File("fonts/Montserrat/static/Montserrat-Regular.ttf")).deriveFont(15f);
            ge.registerFont(montserrat);

            // Montserrat Bold
            montserratBold = Font.createFont(Font.TRUETYPE_FONT,
                    new File("fonts/Montserrat/static/Montserrat-Bold.ttf")).deriveFont(15f);
            ge.registerFont(montserratBold);

            // Montserrat Black
            montserratBlack = Font.createFont(Font.TRUETYPE_FONT,
                    new File("fonts/Montserrat/static/Montserrat-Black.ttf")).deriveFont(20f);
            ge.registerFont(montserratBlack);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (FontFormatException fontError) {
            System.out.println(fontError.getMessage());
            fontError.printStackTrace();
        } // end of try-catch
    } // end of loadFonts method

    final Color darkBlack = new Color(24,24,24);
    final Color greyishBlack = new Color(41,41,41);
    final Color lightGrey = new Color(51,51,51);
    final Color grey = new Color(95,95,95);
    final Color eggshellWhite = new Color(240,234,214);
    final Color blue = new Color(56,95,157);
    final Color lightestGrey = new Color(95,95,95);

    final EmptyBorder titleMargin = new EmptyBorder(100,10,10,10);
    final EmptyBorder buttonMargin = new EmptyBorder(60,10,10,10);
    final EmptyBorder pageMargin = new EmptyBorder(
            30,30,30,30);

    /**
     * Gets a rounded border with the specified colors.
     * @param color1 The first color of the border.
     * @param color2 The second color of the border.
     * @return A rounded border with the specified colors.
     */
    public Border getRoundedBorder(Color color1, Color color2) {
        return new RoundBorder(20, color1, color2);
    }

    /**
     * Get a rounded button with custom styling.
     */
    public JButton getRoundedButton() {
        JButton roundedButton = new JButton("Convert");

        Color backgroundColor = Color.GRAY; // Set the background color you desire

        // Set the background color directly on the button
        roundedButton.setBackground(backgroundColor);

        // Create a custom border with rounded corners and a different border color
        Border buttonBorder = new RoundBorder(10, Color.GRAY, Color.LIGHT_GRAY);

        roundedButton.setBorder(buttonBorder);
        roundedButton.setOpaque(true);
        roundedButton.setForeground(Color.WHITE); // Set the text color
        roundedButton.setFont(montserratBlack);
        roundedButton.setText("Convert");

        return roundedButton;
    }
    /**
     * Get a rounded text field with custom styling.
     */
    public JTextField getRoundedTextField() {
        JTextField textField = new JTextField(20);
        textField.setPreferredSize(new Dimension(150, 100));

        // Set the border to null to remove the border
        textField.setBorder(null);

        // Disable tooltip text
        textField.setToolTipText(null);

        return  textField;
    }
    /**
     * Get a panel title label with custom styling.
     * @return A JLabel for panel titles with custom styling.
     */
    public JLabel getPanelTitle() {
        JLabel title = new JLabel();
        title.setForeground(eggshellWhite);
        title.setPreferredSize(new Dimension(100,30));
        title.setFont(montserratBold);
        return title;
    }
    /**
     * Get an input title label with custom styling.
     * @return A JLabel for input titles with custom styling.
     */
    public JLabel getInputTitle() {
        JLabel title = new JLabel();
        title.setForeground(blue);
        title.setPreferredSize(new Dimension(70,20));
        title.setFont(montserratBold);
        return title;
    }
    /**
     * Get an application title label with custom styling.
     * @return A JLabel for the application title with custom styling.
     */
    public JLabel getAppTitle() {
        JLabel title = new JLabel();
        title.setForeground(blue);
        title.setPreferredSize(new Dimension(70,20));
        title.setFont(montserratBlack);
        return title;
    }
}