package im.jeanfrancois.listbuilder.print;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;

/**
 * Document me!
 *
 * @author jfim
 */
@Singleton
public class LandscapePageFormatProvider implements Provider<PageFormat> {
    private PrinterJob printerJob;

    @Inject
    public LandscapePageFormatProvider(PrinterJob printerJob) {
        this.printerJob = printerJob;
    }

    @Override
    public PageFormat get() {
        final PageFormat pageFormat = printerJob.defaultPage();
        pageFormat.setOrientation(PageFormat.LANDSCAPE);

        return pageFormat;
    }
}
