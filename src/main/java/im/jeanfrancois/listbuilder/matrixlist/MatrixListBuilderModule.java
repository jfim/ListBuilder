package im.jeanfrancois.listbuilder.matrixlist;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import net.guts.gui.application.AppLifecycleStarter;
import net.guts.gui.resource.Resources;

import java.awt.print.Printable;

/**
 * Document me!
 *
 * @author jfim
 */
public class MatrixListBuilderModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AppLifecycleStarter.class).to(AppLifecycle.class);
        bind(MatrixListModel.class).in(Scopes.SINGLETON);
        bind(Printable.class).to(MatrixListPrintable.class).in(Scopes.SINGLETON);
        Resources.bindRootBundle(binder(), MatrixListBuilderModule.class, "matrixlistbuilder");
    }
}
