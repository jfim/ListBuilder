package im.jeanfrancois.listbuilder.matrixlist;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.guts.gui.application.support.SingleFrameLifecycle;

import javax.swing.*;
import java.awt.*;

/**
 * Document me!
 *
 * @author jfim
 */
@Singleton
public class AppLifecycle extends SingleFrameLifecycle {
	private MatrixListBuilderPanel matrixListBuilderPanel;

	@Inject
	public AppLifecycle(MatrixListBuilderPanel matrixListBuilderPanel) {
		this.matrixListBuilderPanel = matrixListBuilderPanel;
	}

	@Override
	protected void initFrame(JFrame mainFrame) {
		mainFrame.getContentPane().setLayout(new BorderLayout());
		mainFrame.getContentPane().add(matrixListBuilderPanel, BorderLayout.CENTER);
	}
}
