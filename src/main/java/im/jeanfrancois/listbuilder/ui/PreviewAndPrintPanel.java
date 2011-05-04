package im.jeanfrancois.listbuilder.ui;

import com.google.inject.Inject;
import im.jeanfrancois.listbuilder.print.ResetAfterPrintPrintable;
import im.jeanfrancois.listbuilder.print.TitledPrintable;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
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

    @Inject
    public PreviewAndPrintPanel(PrintPreviewComponent printPreviewComponent, final PrinterJob printerJob, final PageFormat pageFormat, final TitledPrintable titledPrintable) {
        this.printPreviewComponent = printPreviewComponent;

        setLayout(new MigLayout("wrap 1", "[grow]", "[grow, fill][]"));
        add(printPreviewComponent, "grow");

        add(printButton);

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printerJob.setJobName(titledPrintable.getTitle());
                printerJob.setPrintable(titledPrintable, pageFormat);

                if (printerJob.printDialog()) {
                    try {
                        printerJob.print();

                        if(titledPrintable instanceof ResetAfterPrintPrintable) {
                            ((ResetAfterPrintPrintable) titledPrintable).reset();
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
                System.out.println(printButton.getName());
            }
        });
    }
}
