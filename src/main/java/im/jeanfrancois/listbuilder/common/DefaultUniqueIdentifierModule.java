package im.jeanfrancois.listbuilder.common;

import com.google.inject.AbstractModule;

/**
 * Document me!
 *
 * @author jfim
 */
public class DefaultUniqueIdentifierModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TodoListUniqueIdentifierRegistry.class).to(UuidBasedTodoListUniqueIdentifierRegistry.class);
    }
}
