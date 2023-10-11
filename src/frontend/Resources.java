package frontend;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.AbstractBorder;
import java.awt.Color;

public class Resources {
    final Color darkBlack = new Color(24,24,24);
    final Color greyishBlack = new Color(41,41,41);
    final Color grey = new Color(95,95,95);
    final Color eggshellWhite = new Color(240,234,214);

    final EmptyBorder titleMargin = new EmptyBorder(100,10,10,10);
    final EmptyBorder buttonMargin = new EmptyBorder(60,10,10,10);
    final EmptyBorder pageMargin = new EmptyBorder(
            30,30,30,30);

    Border roundedBorder = new RoundBorder(20, greyishBlack, greyishBlack);
}