package im.jeanfrancois.listbuilder.matrixlist;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import im.jeanfrancois.listbuilder.code.QRCodeTodoListCodeImageGenerator;
import im.jeanfrancois.listbuilder.code.TodoListCodeImageGenerator;
import im.jeanfrancois.listbuilder.common.TodoListUniqueIdentifierRegistry;
import im.jeanfrancois.listbuilder.common.UuidBasedTodoListUniqueIdentifierRegistry;
import im.jeanfrancois.listbuilder.print.TitledPrintable;
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
        bind(TodoListCodeImageGenerator.class).to(QRCodeTodoListCodeImageGenerator.class);
        bind(TodoListUniqueIdentifierRegistry.class).to(UuidBasedTodoListUniqueIdentifierRegistry.class);
        bind(Printable.class).to(TitledPrintable.class);
        bind(TitledPrintable.class).to(MatrixListPrintable.class).in(Scopes.SINGLETON);
        Resources.bindRootBundle(binder(), MatrixListBuilderModule.class, "matrixlistbuilder");
    }
}
