package im.jeanfrancois.listbuilder.todolist;

import com.google.inject.Inject;
import im.jeanfrancois.listbuilder.code.TodoListCodeImageGenerator;
import im.jeanfrancois.listbuilder.print.ResetAfterPrintPrintable;
import im.jeanfrancois.listbuilder.print.SettablePageCountPrintable;
import im.jeanfrancois.listbuilder.print.TitledPrintable;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;

/**
 * Document me!
 *
 * @author jfim
 */
public class TodoListPrintable implements TitledPrintable, SettablePageCountPrintable, ResetAfterPrintPrintable {
    private TodoListModel model;
    private TodoListCodeImageGenerator codeImageGenerator;
    private int pageCount = 1;
    private int QR_CODE_SIZE = 96;
    private int MARGIN_WIDTH = 32;

    @Inject
    public TodoListPrintable(TodoListModel model, TodoListCodeImageGenerator codeImageGenerator) {
        this.model = model;
        this.codeImageGenerator = codeImageGenerator;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageCount <= pageIndex) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;

        int pageWidth = (int) pageFormat.getImageableWidth();
        int pageHeight = (int) pageFormat.getImageableHeight();

        // Draw the separator line
        int centerX = (int) (pageFormat.getImageableX() + pageWidth / 2);
        g2d.drawLine(centerX, (int)pageFormat.getImageableY(), centerX, (int) (pageFormat.getImageableY() + pageHeight));

        // Draw both lists
        drawTodoList(g2d, (int) pageFormat.getImageableX(), (int) pageFormat.getImageableY(), pageWidth / 2 - MARGIN_WIDTH, pageHeight, pageIndex * 2);
        drawTodoList(g2d, ((int) pageFormat.getImageableX()) + pageWidth / 2 + MARGIN_WIDTH, (int) pageFormat.getImageableY(), pageWidth / 2 - MARGIN_WIDTH, pageHeight, pageIndex * 2 + 1);

        return PAGE_EXISTS;
    }

    private void drawTodoList(Graphics2D g, int x, int y, int width, int height, int index) {
        // Draw the title
        g.setColor(Color.BLACK);
        g.setFont(model.getFont());
        Rectangle2D bounds = model.getFont().getStringBounds(model.getTitleText(), g.getFontRenderContext());
        g.drawString(model.getTitleText(), x, y + (int)bounds.getHeight());

        // Draw the boxes and lines
        int boxCount = 30;
        int cellSize = (int) ((height - bounds.getHeight()) / boxCount);
        int boxSize = cellSize - 3;
        for(int i = 0; i < boxCount; ++i) {
            int yStart = height + y - i * cellSize - boxSize;
            g.setColor(Color.BLACK);
            g.drawRect(x, yStart, boxSize, boxSize);
            g.setColor(Color.GRAY);
            g.drawLine(boxSize + 3 + x, yStart + boxSize, x + width - 1, yStart + boxSize);
        }

        // Draw the QR code
        g.drawImage(codeImageGenerator.generateCodeImageForTodoListId(model.getUniqueIdentifierRegistry().getIdentifierForTodoListIndex(index).toString()), x + width - QR_CODE_SIZE, y, QR_CODE_SIZE, QR_CODE_SIZE, null);
    }

    @Override
    public String getTitle() {
        return model.getTitleText();
    }

    @Override
    public void reset() {
        model.resetUniqueIdentifierRegistry();
    }

    @Override
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
