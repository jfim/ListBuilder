package im.jeanfrancois.listbuilder.todolist;

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
    private TodoListBuilderPanel todoListBuilderPanel;

    @Inject
    public AppLifecycle(TodoListBuilderPanel todoListBuilderPanel) {
        this.todoListBuilderPanel = todoListBuilderPanel;
    }

    @Override
    protected void initFrame(JFrame jFrame) {
        jFrame.getContentPane().setLayout(new BorderLayout());
        jFrame.getContentPane().add(todoListBuilderPanel, BorderLayout.CENTER);
    }
}
