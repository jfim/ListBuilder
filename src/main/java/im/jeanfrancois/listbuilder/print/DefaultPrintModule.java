package im.jeanfrancois.listbuilder.print;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;

/**
 * Document me!
 *
 * @author jfim
 */
public class DefaultPrintModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(PrinterJob.class).toProvider(PrinterJobProvider.class).in(Scopes.SINGLETON);
        bind(PageFormat.class).toProvider(LandscapePageFormatProvider.class).in(Scopes.SINGLETON);
    }
}
