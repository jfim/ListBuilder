package im.jeanfrancois.listbuilder.todolist;

import com.google.inject.Inject;
import im.jeanfrancois.listbuilder.print.TitledPrintable;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;

/**
 * Document me!
 *
 * @author jfim
 */
public class TodoListPrintable implements TitledPrintable {
    private TodoListModel model;

    @Inject
    public TodoListPrintable(TodoListModel model) {
        this.model = model;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        // TODO Implement!
        return NO_SUCH_PAGE;
    }

    @Override
    public String getTitle() {
        return model.getTitleText();
    }
}
