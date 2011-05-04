package im.jeanfrancois.listbuilder.print;

import com.google.inject.Provider;
import com.google.inject.Singleton;

import java.awt.print.PrinterJob;

/**
 * Document me!
 *
 * @author jfim
 */
@Singleton
public class PrinterJobProvider implements Provider<PrinterJob> {
    @Override
    public PrinterJob get() {
        return PrinterJob.getPrinterJob();
    }
}
