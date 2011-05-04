package im.jeanfrancois.listbuilder.todolist;

import com.google.inject.Module;
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
    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new App().launch(args);
    }
}
