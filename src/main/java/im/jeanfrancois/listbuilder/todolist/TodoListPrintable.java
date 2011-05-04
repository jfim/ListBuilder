package im.jeanfrancois.listbuilder.todolist;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

/**
 * Document me!
 *
 * @author jfim
 */
public class TodoListPrintable implements Printable {
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        return NO_SUCH_PAGE;
    }
}
