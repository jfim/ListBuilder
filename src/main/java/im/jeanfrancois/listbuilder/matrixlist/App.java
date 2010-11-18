package im.jeanfrancois.listbuilder.matrixlist;

import com.google.inject.Module;
import net.guts.gui.application.AbstractApplication;
import net.guts.gui.naming.ComponentNamingModule;

import javax.swing.*;

/**
 * Document me!
 *
 * @author jfim
 */
public class App extends AbstractApplication {
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new App().launch(args);
	}

	@Override
	protected void initModules(String[] args, java.util.List<Module> modules) {
		modules.add(new ComponentNamingModule());
		modules.add(new MatrixListBuilderModule());
	}
}
