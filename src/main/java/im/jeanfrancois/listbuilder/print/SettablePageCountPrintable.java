package im.jeanfrancois.listbuilder.print;

import java.awt.print.Printable;

/**
 * Document me!
 *
 * @author jfim
 */
public interface SettablePageCountPrintable extends Printable {
    public void setPageCount(int pageCount);
}
