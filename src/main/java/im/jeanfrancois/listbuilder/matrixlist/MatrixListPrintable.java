package im.jeanfrancois.listbuilder.matrixlist;

import com.google.inject.Inject;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;


/**
 * Document me!
 *
 * @author jfim
 */
public class MatrixListPrintable implements Printable {
	private MatrixListModel matrixListModel;

	@Inject
	public MatrixListPrintable(MatrixListModel matrixListModel) {
		this.matrixListModel = matrixListModel;
	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
			throws PrinterException {
		if (pageIndex != 0) {
			return NO_SUCH_PAGE;
		}

		Graphics2D g2d = (Graphics2D) graphics;
		g2d.setFont(matrixListModel.getFont());

		FontMetrics fontMetrics = g2d.getFontMetrics();
		Rectangle2D titleBounds = fontMetrics.getStringBounds(matrixListModel.getTitleText(),
				g2d);

		g2d.drawString(matrixListModel.getTitleText(),
				(int) pageFormat.getImageableX(),
				(int) (pageFormat.getImageableY() +
						titleBounds.getHeight()));

		// Draw the boxes
		g2d.setStroke(new BasicStroke(matrixListModel.getStrokeWidth()));

		final int boxSize = matrixListModel.getSize();
		final int boxCellSize = boxSize + matrixListModel.getSpacing();

		for (int x = 0; x < matrixListModel.getX(); ++x) {
			for (int y = 0; y < matrixListModel.getY(); ++y) {
				g2d.drawRect((int) pageFormat.getImageableX() +
						(x * boxCellSize),
						(int) ((pageFormat.getImageableHeight() +
								pageFormat.getImageableY()) -
								(y * boxCellSize) - boxSize), boxSize, boxSize);
			}
		}

		// Draw the vertical lines
		for (int x = 0; x < matrixListModel.getX(); ++x) {
			final int xPos = (int) (pageFormat.getImageableX() +
					(x * boxCellSize) + boxSize);
			final int yStart = (int) (pageFormat.getImageableY() +
					titleBounds.getHeight() +
					matrixListModel.getSpacing());
			final int yEnd = (int) ((pageFormat.getImageableY() +
					pageFormat.getImageableHeight()) -
					(matrixListModel.getY() * boxCellSize));
			g2d.drawLine(xPos, yStart, xPos, yEnd);
		}

		// Draw the horizontal lines
		for (int y = 0; y < matrixListModel.getY(); ++y) {
			final int yPos = (int) ((pageFormat.getImageableY() +
					pageFormat.getImageableHeight()) -
					(y * boxCellSize));
			final int xStart = (int) (pageFormat.getImageableX() + matrixListModel.getX() * boxCellSize + matrixListModel.getSpacing());
			final int xEnd = (int) (pageFormat.getImageableX() + pageFormat.getImageableWidth());
			g2d.drawLine(xStart, yPos, xEnd, yPos);
		}

		return PAGE_EXISTS;
	}
}
