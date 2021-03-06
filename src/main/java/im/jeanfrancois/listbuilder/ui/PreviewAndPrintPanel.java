package im.jeanfrancois.listbuilder.ui;

import com.google.inject.Inject;
import im.jeanfrancois.listbuilder.print.ResetAfterPrintPrintable;
import im.jeanfrancois.listbuilder.print.SettablePageCountPrintable;
import im.jeanfrancois.listbuilder.print.TitledPrintable;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/**
 * Document me!
 *
 * @author jfim
 */
public class PreviewAndPrintPanel extends JPanel {
    private PrintPreviewComponent printPreviewComponent;
    private JButton printButton = new JButton();
    private JSpinner copiesSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
    private JLabel copiesLabel = new JLabel();

    @Inject
    public PreviewAndPrintPanel(PrintPreviewComponent printPreviewComponent, final PrinterJob printerJob, final PageFormat pageFormat, final Printable printable) {
        this.printPreviewComponent = printPreviewComponent;

        setLayout(new MigLayout("wrap 1", "[grow]", "[grow, fill][]"));
        add(printPreviewComponent, "grow");

        add(copiesLabel, "span, align right, split 3");
        add(copiesSpinner);
        add(printButton);

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(printable instanceof TitledPrintable) {
                    printerJob.setJobName(((TitledPrintable) printable).getTitle());
                }

                printerJob.setPrintable(printable, pageFormat);

                if (printerJob.printDialog()) {
                    try {
                        if (printable instanceof SettablePageCountPrintable) {
                            ((SettablePageCountPrintable) printable).setPageCount((Integer) copiesSpinner.getValue());
                        }

                        printerJob.print();

                        if (printable instanceof ResetAfterPrintPrintable) {
                            ((ResetAfterPrintPrintable) printable).reset();
                        }
                    } catch (PrinterException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }

    public void updatePreview() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                printPreviewComponent.repaint();
            }
        });
    }
}
