package im.jeanfrancois.listbuilder.todolist;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.l2fprod.common.swing.JFontChooser;
import im.jeanfrancois.listbuilder.ui.PreviewAndPrintPanel;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

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
    private JLabel fontDisplayLabel = new JLabel();
    private JButton fontChooseButton = new JButton();

    private TodoListModel todoListModel;

    @Inject
    public TodoListBuilderPanel(final TodoListModel todoListModel, final PreviewAndPrintPanel previewAndPrintPanel) {
        this.todoListModel = todoListModel;

        setLayout(new MigLayout("", "[grow]", "[][grow, fill]"));
        add(titleTextLabel, "split");
        add(titleTextTextField);
        add(fontLabel, "gap unrelated");
        add(fontDisplayLabel);
        add(fontChooseButton);

        add(previewAndPrintPanel, "newline, grow, span");

        todoListModel.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                previewAndPrintPanel.updatePreview();
            }
        });

        BeanProperty<JTextField, String> textFieldTextProperty = BeanProperty.create("text");
        BeanProperty<JLabel, String> labelTextProperty = BeanProperty.create("text");
        BeanProperty<JSpinner, Integer> spinnerValueIntProperty = BeanProperty.create("value");

        BeanProperty<TodoListModel, String> todoListModelTitleTextProperty = BeanProperty.create("titleText");
        BeanProperty<TodoListModel, String> fontNameProperty = BeanProperty.create("font.name");

        Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, todoListModel, todoListModelTitleTextProperty, titleTextTextField, textFieldTextProperty).bind();
        final AutoBinding<TodoListModel, String, JLabel, String> fontDisplayBinding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, todoListModel, fontNameProperty, fontDisplayLabel, labelTextProperty);
        fontDisplayBinding.bind();

        fontChooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFontChooser fontChooser = new JFontChooser();
                fontChooser.setSelectedFont(todoListModel.getFont());
                fontChooser.showFontDialog(TodoListBuilderPanel.this,
                        "Pick a font");
                todoListModel.setFont(fontChooser.getSelectedFont());
                fontDisplayBinding.unbind();
                fontDisplayBinding.bind();
            }
        });
    }
}
