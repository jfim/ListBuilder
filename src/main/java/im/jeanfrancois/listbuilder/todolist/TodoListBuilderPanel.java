package im.jeanfrancois.listbuilder.todolist;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

/**
 * Document me!
 *
 * @author jfim
 */
@Singleton
public class TodoListBuilderPanel extends JPanel {
    private JLabel titleTextLabel = new JLabel();
    private JTextField titleTextTextField = new JTextField();
    private JLabel fontLabel = new JLabel();
    private JButton fontChooseButton = new JButton();

    private TodoListModel todoListModel;

    @Inject
    public TodoListBuilderPanel(TodoListModel todoListModel) {
        this.todoListModel = todoListModel;

        setLayout(new MigLayout());
        add(titleTextLabel);
        add(titleTextTextField);
        add(fontLabel);
        add(fontChooseButton);
    }
}
