package com.esprit.veltun.GUI.abonnementt.frontchoice;

import com.esprit.veltun.GUI.abonnementt.view.EventDetailsController;
import com.esprit.veltun.model.Abonnement;
import com.esprit.veltun.search.dto.AbonnementSearchCriteria;
import com.esprit.veltun.services.AbonnementService;
import com.esprit.veltun.services.impl.AbonnementServiceImpl;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class SecondFXMLController implements Initializable {
    public Button cancelbutton;
    private AbonnementService abonnementService = new AbonnementServiceImpl();

   /* public TextField fxType_ab;
    public TextField fxDureeab;
    public DatePicker Adatedebut;
    public DatePicker Adatefin;
    public TextField fxPrixAb;
    public TextField fxCIN;
    public TextField fxidO;*/
    @FXML
    private Label codeLabel;
    @FXML
    private TextField priceField;

    @FXML
    private Label discountedPriceLabel;
    private  Label errorA;
    @FXML
    private TextField discountCodeTextField;
    @FXML
    private ImageView qrCodeImageView;
    public TextField titletosearch;
    public Button searchbutton;
    public Button tooffer;
    public ListView<Abonnement> eventlistview;
    private Abonnement abonnement;
    @FXML
    private ListView<String> listView2;

    public ListView<String> getEventListView2() {
        return listView2;
    }
    @FXML
    private Label fxtype;
    @FXML
    private Label datef;
    @FXML
    private Label fxprix;
    @FXML
    private Label dated;
    public void setAbdateDebut(LocalDate date){this.dated.setText(String.valueOf(date));}
    public void setAbdateFin(LocalDate date){this.datef.setText(String.valueOf(date));}

    public void setFxTypeab(String Type_ab) {
        this.fxtype.setText(Type_ab);
    }

   /* public void setFxDureeab(String Dure) {
        this.fxDureeab.setText(Dure);
    }*/

    public void setFxPrixAb(String prixAb) {
        this.fxprix.setText(prixAb);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
       /* eventlistview.setCellFactory(param -> {
            return new ListCell<Abonnement>(){
                public void updateItem(Abonnement abonnement, boolean empty) {
                    super.updateItem(abonnement, empty);
                    if (empty || abonnement == null) {
                        setText(null);
                    } else {
                        setText(abonnement.getType_ab() + "\t\t" + "\t\t"+ abonnement.getDateDebut() + "\t\t" + "\t\t"+abonnement.getDateFin() + "\t\t" +"\t\t"+ abonnement.getPrix_ab() + "\t\t" +"\t\t" + abonnement.getId_offre());
                    }
                }
            };
        });
        runSearch();*/
        final Pattern pattern = Pattern.compile("\\d{2}\\:\\d{2}\\:\\d{2}");
        TextFormatter<?> formatter = new TextFormatter<>(change -> {
            if (pattern.matcher(change.getControlNewText()).matches()) {
                // todo: remove error message/markup
                return change; // allow this change to happen
            } else {
                // todo: add error message/markup
                return null; // prevent change
            }
        });


    }

    void runSearch() {
        String Type_ab = titletosearch.getText();
        AbonnementSearchCriteria abonnementSearchCriteria = new AbonnementSearchCriteria();
        if (Type_ab != null && !Type_ab.isEmpty()) {
            abonnementSearchCriteria.setType_ab(Type_ab);
        }
        Collection<Abonnement> abonnements = abonnementService.search(abonnementSearchCriteria);
        eventlistview.getItems().setAll(abonnements);
    }

    public void search(ActionEvent actionEvent) {
        runSearch();
    }

    public void addAbonnement(Abonnement selectedAbonnement) {
    }

    public void setAbonnement(Abonnement abonnement) {
        this.abonnement= abonnement;
        setFxTypeab(abonnement.getType_ab());
        setAbdateDebut(abonnement.getDateDebut().toLocalDate());
        setAbdateFin(abonnement.getDateFin().toLocalDate());
        // setFxDureeab(abonnement.getDuree());
        setFxPrixAb(String.valueOf(abonnement.getPrix_ab()));
    }

    public void setData(Abonnement abonnement) {
    }


    public static class QRCodeGenerator {

        public static BufferedImage generateQRCodeImage(String text, int width, int height) throws WriterException, IOException {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        }

        public static String generateQRCodeBase64(String text, int width, int height) throws WriterException, IOException {
            BufferedImage qrCodeImage = generateQRCodeImage(text, width, height);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(qrCodeImage, "png", baos);
            baos.flush();

            byte[] imageBytes = baos.toByteArray();
            baos.close();

            return Base64.getEncoder().encodeToString(imageBytes);
        }

        public static String decodeQRCodeImage(BufferedImage qrCodeImage) throws WriterException {
            // TODO: Implement QR code decoding logic
            return "";
        }

    }
    @FXML
    private void generateCode(ActionEvent event) {
        // Generate the discount code from the QR code
        String discountCode = AbonnementServiceImpl.DiscountCodeGenerator.generateCode();

        // Set the discount code in the text field
        discountCodeTextField.setText(discountCode);
        discountCodeTextField.setEditable(false);

        // Get the discount percentage from the discount code
        float discountPercentage = AbonnementServiceImpl.DiscountCodeGenerator.getDiscount(discountCode);

        // Calculate the final discount amount
        float originalPrice = Float.parseFloat(fxprix.getText());
        float discountAmount = originalPrice * discountPercentage;
        float finalPrice = originalPrice - discountAmount;

        String message = String.format("Voici votre code. Vous beneficiez d'une reduction de %.0f%% avec le code %s", discountPercentage*100, discountCode);

        try {
            // Generate the QR code image
            String qrCodeBase64 = com.esprit.veltun.GUI.abonnementt.frontchoice.SecondFXMLController.QRCodeGenerator.generateQRCodeBase64(message, 200, 200);

            // Set the QR code image in the ImageView
            qrCodeImageView.setImage(new Image(new ByteArrayInputStream(Base64.getDecoder().decode(qrCodeBase64))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   @FXML
   private void applyDiscount(ActionEvent event) {
       // Get the discount from the entered code
       float discount = AbonnementServiceImpl.DiscountCodeGenerator.getDiscount(discountCodeTextField.getText());
       String enteredCode = discountCodeTextField.getText();

       // Get the price from the fxprix label
       String priceText = fxprix.getText();
       float price = Float.parseFloat(priceText);
       int subscriptionId = abonnement.getId_ab();
       String type = fxtype.getText();
       if (!type.equals("Premium")) {
           // The discount cannot be applied if the type is not "premium"
           Alert alert = new Alert(Alert.AlertType.ERROR, "The discount can only be applied to premium subscriptions.");
           alert.showAndWait();
           return;
       }
       // Compare the entered code with the last generated code
       if (price > 0) {
           // Apply the discount to the price
           float discountedPrice = price - (price * discount);

           // Update the price in the fxprix label with the discounted price
           fxprix.setText(String.valueOf(discountedPrice));
          // AbonnementServiceImpl.updateEventPrice(subscriptionId, discountedPrice);
       } else {
           // The price in the fxprix label is not valid, show an error message
           Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a valid price to apply the discount to.");
           alert.showAndWait();
       }
   }
    public void cancel(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("searchfront.fxml"));

        try {
            Parent root = fxmlLoader.load();
            fxtype.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
