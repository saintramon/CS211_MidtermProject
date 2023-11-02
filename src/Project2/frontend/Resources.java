package Project2.frontend;

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

            // Load Montserrat Thin
            montserratThin = Font.createFont(Font.TRUETYPE_FONT,
                    getClass().getResourceAsStream("/fonts/Montserrat/static/Montserrat-Thin.ttf")).deriveFont(20f);
            ge.registerFont(montserratThin);

            // Load Montserrat Regular
            montserrat = Font.createFont(Font.TRUETYPE_FONT,
                    getClass().getResourceAsStream("/fonts/Montserrat/static/Montserrat-Regular.ttf")).deriveFont(20f);
            ge.registerFont(montserrat);

            // Load Montserrat Bold
            montserratBold = Font.createFont(Font.TRUETYPE_FONT,
                    getClass().getResourceAsStream("fonts/Montserrat/static/Montserrat-Bold.ttf")).deriveFont(20f);
            ge.registerFont(montserratBold);

            // Load Montserrat Black
            montserratBlack = Font.createFont(Font.TRUETYPE_FONT,
                    getClass().getResourceAsStream("/fonts/Montserrat/static/Montserrat-Black.ttf")).deriveFont(20f);
            ge.registerFont(montserratBlack);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (FontFormatException fontError) {
            fontError.printStackTrace();
        }
    }

    final Color darkBlack = new Color(24,24,24);
    final Color greyishBlack = new Color(41,41,41);
    final Color lightGrey = new Color(51,51,51);
    final Color grey = new Color(95,95,95);
    final Color eggshellWhite = new Color(240,234,214);
    final Color blue = new Color(56,95,157);
    final Color lightestGrey = new Color(95,95,95);
    final Color resedaGreen = new Color(75,84,67);
    final Color olivine = new Color(0x9CAF88);
    final Color alabaster = new Color(0xDFE6DA);

    // Forest Green Palette
    final Color brunswickGreen = new Color(0x344E41);
    final Color hunterGreen = new Color(0x3A5A40);
    final Color fernGreen = new Color(0x588157);
    final Color sage = new Color(0xA3B18A);
    final Color timberwolf = new Color(0xDAD7CD);
    final Color white = new Color (0xFFFFFF);

    final EmptyBorder titleMargin = new EmptyBorder(100,10,10,10);
    final EmptyBorder buttonMargin = new EmptyBorder(60,10,10,10);
    final EmptyBorder pageMargin = new EmptyBorder(
            30,30,30,30);
}
