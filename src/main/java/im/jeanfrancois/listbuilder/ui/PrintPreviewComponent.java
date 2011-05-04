package im.jeanfrancois.listbuilder.ui;

import com.google.inject.Inject;

import javax.swing.*;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;


/**
 * Document me!
 *
 * @author jfim
 */
public class PrintPreviewComponent extends JComponent {
	private PageFormat pageFormat;
	private Printable printable;

    @Inject
	public PrintPreviewComponent(Printable printable, PageFormat pageFormat) {
		this.printable = printable;
		this.pageFormat = pageFormat;
	}

	@Override
	public void paint(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());

        // Fill page bounds with white
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, (int)pageFormat.getWidth(), (int)pageFormat.getHeight());

		// Draw page bounds
		g.setColor(Color.GRAY);
		g.drawRect(0, 0, (int) pageFormat.getWidth(),
				(int) pageFormat.getHeight());

		g.setColor(Color.BLACK);

		try {
			printable.print(g, pageFormat, 0);
		} catch (PrinterException e) {
			e.printStackTrace(); //To change body of catch statement use File | Settings | File Templates.
		}
	}
}
