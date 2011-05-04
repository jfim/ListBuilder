package im.jeanfrancois.listbuilder.code;

import com.google.inject.AbstractModule;

/**
 * Document me!
 *
 * @author jfim
 */
public class DefaultQRCodeImageGeneratorModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TodoListCodeImageGenerator.class).to(QRCodeTodoListCodeImageGenerator.class);
    }
}
