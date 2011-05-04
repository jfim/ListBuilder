package im.jeanfrancois.listbuilder.todolist;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import im.jeanfrancois.listbuilder.ui.PreviewAndPrintPanel;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;

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
    public TodoListBuilderPanel(TodoListModel todoListModel, PreviewAndPrintPanel previewAndPrintPanel) {
        this.todoListModel = todoListModel;

        setLayout(new MigLayout("", "[grow]", "[][grow, fill]"));
        add(titleTextLabel, "split 4");
        add(titleTextTextField);
        add(fontLabel, "gap unrelated");
        add(fontChooseButton);

        add(previewAndPrintPanel, "newline, grow, span");

        BeanProperty<JTextField, String> textFieldTextProperty = BeanProperty.create("text");
        BeanProperty<JLabel, String> labelTextProperty = BeanProperty.create("text");
        BeanProperty<JSpinner, Integer> spinnerValueIntProperty = BeanProperty.create("value");

        BeanProperty<TodoListModel, String> todoListModelTitleTextProperty = BeanProperty.create("titleText");

        Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, todoListModel, todoListModelTitleTextProperty, titleTextTextField, textFieldTextProperty).bind();
    }
}
