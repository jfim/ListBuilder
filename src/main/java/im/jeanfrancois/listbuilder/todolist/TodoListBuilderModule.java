package im.jeanfrancois.listbuilder.todolist;

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
public class TodoListBuilderModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AppLifecycleStarter.class).to(AppLifecycle.class);
        bind(Printable.class).to(TodoListPrintable.class).in(Scopes.SINGLETON);
        bind(TodoListModel.class).in(Scopes.SINGLETON);
        Resources.bindRootBundle(binder(), TodoListBuilderModule.class, "todolistbuilder");
    }
}
