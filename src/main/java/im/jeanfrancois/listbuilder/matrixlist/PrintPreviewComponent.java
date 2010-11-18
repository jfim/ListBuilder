package im.jeanfrancois.listbuilder.matrixlist;

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

	public PrintPreviewComponent(Printable printable, PageFormat pageFormat) {
		this.printable = printable;
		this.pageFormat = pageFormat;
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.clearRect(0, 0, getWidth(), getHeight());

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
