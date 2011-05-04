package im.jeanfrancois.listbuilder.todolist;

import com.google.inject.Module;
import im.jeanfrancois.listbuilder.code.DefaultQRCodeImageGeneratorModule;
import im.jeanfrancois.listbuilder.common.DefaultUniqueIdentifierModule;
import im.jeanfrancois.listbuilder.print.DefaultPrintModule;
import net.guts.gui.application.AbstractApplication;
import net.guts.gui.naming.ComponentNamingModule;

import javax.swing.*;
import java.util.List;

/**
 * Document me!
 *
 * @author jfim
 */
public class App extends AbstractApplication {
    @Override
    protected void initModules(String[] strings, List<Module> modules) {
        modules.add(new ComponentNamingModule());
        modules.add(new TodoListBuilderModule());
        modules.add(new DefaultPrintModule());
        modules.add(new DefaultQRCodeImageGeneratorModule());
        modules.add(new DefaultUniqueIdentifierModule());
    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new App().launch(args);
    }
}
