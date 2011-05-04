package im.jeanfrancois.listbuilder.matrixlist;

import com.google.inject.Inject;
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
public class MatrixListBuilderPanel extends JPanel {
    private JButton fontChooseButton = new JButton();
    private JButton printButton = new JButton();
    private JLabel fontDisplayLabel = new JLabel();
    private JLabel fontLabel = new JLabel();
    private JLabel sizeLabel = new JLabel();
    private JLabel spacingLabel = new JLabel();
    private JLabel strokeWidthLabel = new JLabel();
    private JLabel titleTextLabel = new JLabel();
    private JLabel xLabel = new JLabel();
    private JLabel yLabel = new JLabel();
    private JSpinner sizeSpinner = new JSpinner(new SpinnerNumberModel(1, 0,
            200, 1));
    private JSpinner spacingSpinner = new JSpinner(new SpinnerNumberModel(1, 0,
            200, 1));
    private JSpinner strokeWidthSpinner = new JSpinner(new SpinnerNumberModel(1.0,
            0.0,
            10.0,
            0.1));
    private JSpinner xSpinner = new JSpinner(new SpinnerNumberModel(1, 0, 200, 1));
    private JSpinner ySpinner = new JSpinner(new SpinnerNumberModel(1, 0, 200, 1));
    private JTextField titleTextTextField = new JTextField();
    private JLabel uuidDescriptionLabel = new JLabel();
    private JLabel uuidLabel = new JLabel();
    private MatrixListModel matrixListModel;

    @Inject
    public MatrixListBuilderPanel(final MatrixListModel matrixListModel,
                                  final MatrixListPrintable matrixListPrintable,
                                  final PreviewAndPrintPanel previewAndPrintPanel) {
        this.matrixListModel = matrixListModel;

        setLayout(new MigLayout("wrap 1", "[grow]", "[][][grow, fill]"));

        add(titleTextLabel, "split 7");
        add(titleTextTextField);
        add(fontLabel, "gap unrelated");
        add(fontDisplayLabel);
        add(fontChooseButton);

        add(uuidDescriptionLabel, "gap unrelated");
        add(uuidLabel);

        add(xLabel, "split 10");
        add(xSpinner);
        add(yLabel, "gap unrelated");
        add(ySpinner);
        add(sizeLabel, "gap unrelated");
        add(sizeSpinner);
        add(spacingLabel, "gap unrelated");
        add(spacingSpinner);
        add(strokeWidthLabel, "gap unrelated");
        add(strokeWidthSpinner);

        add(previewAndPrintPanel, "grow");

        BeanProperty<JTextField, String> textFieldTextProperty = BeanProperty.create("text");
        BeanProperty<JLabel, String> labelTextProperty = BeanProperty.create("text");
        BeanProperty<JSpinner, Integer> spinnerValueIntProperty = BeanProperty.create("value");

        BeanProperty<MatrixListModel, String> titleTextProperty = BeanProperty.create("titleText");
        BeanProperty<MatrixListModel, String> fontNameProperty = BeanProperty.create("font.name");
        BeanProperty<MatrixListModel, Integer> xProperty = BeanProperty.create("x");
        BeanProperty<MatrixListModel, Integer> yProperty = BeanProperty.create("y");
        BeanProperty<MatrixListModel, Integer> sizeProperty = BeanProperty.create("size");
        BeanProperty<MatrixListModel, Integer> spacingProperty = BeanProperty.create("spacing");
        BeanProperty<MatrixListModel, Integer> strokeWidthProperty = BeanProperty.create("strokeWidth");
        BeanProperty<MatrixListModel, String> uniqueIdentifierProperty = BeanProperty.create("defaultUniqueIdentifier");

        Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE,
                matrixListModel, titleTextProperty,
                titleTextTextField, textFieldTextProperty)
                .bind();

        final AutoBinding<MatrixListModel, String, JLabel, String> fontDisplayBinding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ,
                matrixListModel,
                fontNameProperty,
                fontDisplayLabel,
                labelTextProperty);
        fontDisplayBinding.bind();

        Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ,
                matrixListModel, uniqueIdentifierProperty, uuidLabel, labelTextProperty).bind();

        Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE,
                matrixListModel, xProperty, xSpinner,
                spinnerValueIntProperty).bind();
        Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE,
                matrixListModel, yProperty, ySpinner,
                spinnerValueIntProperty).bind();
        Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE,
                matrixListModel, sizeProperty, sizeSpinner,
                spinnerValueIntProperty).bind();
        Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE,
                matrixListModel, spacingProperty,
                spacingSpinner, spinnerValueIntProperty)
                .bind();
        Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE,
                matrixListModel, strokeWidthProperty,
                strokeWidthSpinner, spinnerValueIntProperty)
                .bind();

        fontChooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFontChooser fontChooser = new JFontChooser();
                fontChooser.showFontDialog(MatrixListBuilderPanel.this,
                        "Pick a font");
                matrixListModel.setFont(fontChooser.getSelectedFont());
                fontDisplayBinding.unbind();
                fontDisplayBinding.bind();
            }
        });

        matrixListModel.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                previewAndPrintPanel.updatePreview();
            }
        });
    }
}
