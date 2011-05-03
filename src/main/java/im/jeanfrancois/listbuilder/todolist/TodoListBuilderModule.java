package im.jeanfrancois.listbuilder.todolist;

import com.google.inject.AbstractModule;
import net.guts.gui.application.AppLifecycleStarter;

/**
 * Document me!
 *
 * @author jfim
 */
public class TodoListBuilderModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AppLifecycleStarter.class).to(AppLifecycle.class);
    }
}
