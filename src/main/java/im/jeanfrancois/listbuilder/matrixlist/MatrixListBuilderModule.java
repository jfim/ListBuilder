package im.jeanfrancois.listbuilder.matrixlist;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import im.jeanfrancois.listbuilder.code.QRCodeTodoListCodeImageGenerator;
import im.jeanfrancois.listbuilder.code.TodoListCodeImageGenerator;
import net.guts.gui.application.AppLifecycleStarter;
import net.guts.gui.resource.Resources;

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
        Resources.bindRootBundle(binder(), MatrixListBuilderModule.class, "matrixlistbuilder");
    }
}
