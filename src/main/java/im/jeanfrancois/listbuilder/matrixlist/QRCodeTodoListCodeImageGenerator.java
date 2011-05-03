package im.jeanfrancois.listbuilder.matrixlist;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;

import java.awt.image.BufferedImage;

/**
 * Document me!
 *
 * @author jfim
 */
@Singleton
public class QRCodeTodoListCodeImageGenerator implements TodoListCodeImageGenerator {
    private QRCodeWriter qrCodeWriter;
    private static final int QR_CODE_IMAGE_SIZE = 512;
    private static final String QR_CODE_URL_PREFIX = "TODOLISTID://";

    @Inject
    public QRCodeTodoListCodeImageGenerator(QRCodeWriter qrCodeWriter) {
        this.qrCodeWriter = qrCodeWriter;
    }

    @Override
    public BufferedImage generateCodeImageForTodoListId(String todoListIdentifier) {
        try {
            return MatrixToImageWriter.toBufferedImage(qrCodeWriter.encode(QR_CODE_URL_PREFIX + todoListIdentifier, BarcodeFormat.QR_CODE, QR_CODE_IMAGE_SIZE, QR_CODE_IMAGE_SIZE));
        } catch (WriterException e) {
            throw new RuntimeException(e);
        }
    }
}
