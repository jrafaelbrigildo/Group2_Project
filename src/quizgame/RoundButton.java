package quizgame;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class RoundButton extends JButton{
    public RoundButton()
    {
        // Enlarge button to make a circle rather than an oval.
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);

        // This call causes the JButton *not* to paint the background
        // and allows us to paint a round background instead.
        setContentAreaFilled(false);
    }

    	// Paint the border of the button using a simple stroke.
        protected void paintComponent(Graphics g)
        {
            // Cast the Graphics object to a Graphics2D object.
            Graphics2D g2d = (Graphics2D) g;

            // Set the arc width and height to create a rounded corner effect.
            int arcWidth = 40;
            int arcHeight = 40;

            // Create a new RoundRectangle2D object with the specified arc width and height.
            RoundRectangle2D rect = new RoundRectangle2D.Double(0, 0, getSize().width-1, getSize().height-1, arcWidth, arcHeight);

            if (getModel().isArmed())
                g2d.setColor(Color.lightGray);
            else
                g2d.setColor(getBackground());

            // Fill the rounded corner rectangle with the specified color.
            g2d.fill(rect);

            // This call will paint the label and focus rectangle.
            super.paintComponent(g);
        }
    }

   