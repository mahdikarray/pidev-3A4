package com.esprit.veltun.gui.velo.javafx_qrcodewriter;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.EnumMap;
import java.util.Map;

public class  QRCodeGenerator {
    public static BitMatrix generateQRCode(String data, int width, int height) throws WriterException {
        Map<EncodeHintType, Object> hints = new EnumMap<>(EncodeHintType.class);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, width, height, hints);
        return bitMatrix;
    }

    public static Canvas drawQRCode(BitMatrix bitMatrix, int width, int height) {
        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, width, height);

        gc.setFill(Color.BLACK);
        for (int i = 0; i < bitMatrix.getWidth(); i++) {
            for (int j = 0; j < bitMatrix.getHeight(); j++) {
                if (bitMatrix.get(i, j)) {
                    gc.fillRect(i, j, 1, 1);
                }
            }
        }

        return canvas;
    }
}
