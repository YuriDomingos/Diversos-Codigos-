mport java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.colorchooser.*;

public class ColorChooserPanel extends JPanel
{
    ColorChooserPanel()
    {
        JColorChooser chooser = new JColorChooser();
        AbstractColorChooserPanel[] panels = chooser.getChooserPanels();

        for (AbstractColorChooserPanel panel: panels)
        {
            if ("HSL".equals(panel.getDisplayName()))
            {
                add( panel );

                List<JSlider> sliders = SwingUtils.getDescendantsOfType(JSlider.class, panel, true);

                for (JSlider slider: sliders)
                {
                    slider.setVisible( false );
                }

            }
        }
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("ColorChooserPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ColorChooserPanel());
        frame.pack();
        frame.setLocationByPlatform( true );
        frame.setVisible( true );

    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater( () -> createAndShowGUI() );
/*
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
*/
    }
