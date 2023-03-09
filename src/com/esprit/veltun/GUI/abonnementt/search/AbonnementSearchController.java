package com.esprit.veltun.GUI.abonnementt.search;


//import com.esprit.veltun.gui.invitation.create.InvitationCreateController;
import com.esprit.veltun.model.Abonnement;
import com.esprit.veltun.search.dto.AbonnementSearchCriteria;
import com.esprit.veltun.services.AbonnementService;
import com.esprit.veltun.services.impl.AbonnementServiceImpl;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Optional;
import java.util.ResourceBundle;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
public class AbonnementSearchController implements Initializable {
    public TextField titletosearch;
    public Button searchbutton;
    public Button tooffer;
    private AbonnementService abonnementService = new AbonnementServiceImpl();
    public ListView<Abonnement> eventlistview;
    private Timeline timeline;
    @FXML
    private Button downloadButton;
    @FXML
    WebView map;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        eventlistview.setCellFactory(param -> {
            return new ListCell<Abonnement>(){
                public void updateItem(Abonnement abonnement, boolean empty) {
                    super.updateItem(abonnement, empty);
                    if (empty || abonnement == null) {
                        setText(null);
                    } else {
                        setText(abonnement.getType_ab() + "\t\t" + "\t\t"+ abonnement.getDateDebut() + "\t\t" + "\t\t"+abonnement.getDateFin() + "\t\t" +"\t\t"+ abonnement.getPrix_ab());
                    }
                }
            };
        });

        runSearch();

    }
    @FXML
    void downloadPDF(ActionEvent event) {
        Document document = new Document();
        try {
            // Show file chooser dialog
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save PDF File");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf"));
            File file = fileChooser.showSaveDialog(((Node) event.getSource()).getScene().getWindow());

            if (file != null) {
                // Create PDF document
                PdfWriter.getInstance(document, new FileOutputStream(file));
                document.open();

                PdfPTable table = new PdfPTable(4); // 4 columns

                // Table header
                table.addCell("Subscription Type");
                table.addCell("Start Date");
                table.addCell("End Date");
                table.addCell("Price");

                // Table data
                for (Abonnement abonnement : eventlistview.getItems()) {
                    table.addCell(abonnement.getType_ab());
                    table.addCell(abonnement.getDateDebut().toString());
                    table.addCell(abonnement.getDateFin().toString());
                    table.addCell(Double.toString(abonnement.getPrix_ab()));
                }

                document.add(table);

                document.close();

                // Open PDF file
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(file);
                }
            }
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
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

    @FXML
    void removeEvent(ActionEvent mouseEvent) {
        Abonnement abonnement = eventlistview.getSelectionModel().getSelectedItem();
        int selectionIndex = eventlistview.getSelectionModel().getSelectedIndex();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure you want to remove this subscription?");
        alert.setContentText("Subscription Type: " + abonnement.getType_ab() + "\nSubscription Start Date: " + abonnement.getDateDebut().toString() + "\nSubscription End Date: " + abonnement.getDateFin().toString()+ "\nSubscription Price: " + abonnement.getPrix_ab());

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            abonnementService.remove(abonnement.getId_ab());
            eventlistview.getItems().remove(selectionIndex);
        } else {
            // User clicked Cancel or closed the dialog
        }
    }

    @FXML
    void editEvent(ActionEvent mouseEvent) {
        Abonnement abonnement = eventlistview.getSelectionModel().getSelectedItem();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure you want to update this subscription?");
        alert.setContentText("Subscription Type: " + abonnement.getType_ab() + "\nSubscription Start Date: " + abonnement.getDateDebut().toString() + "\nSubscription End Date: " + abonnement.getDateFin().toString()+ "\nSubscription Price: " + abonnement.getPrix_ab());

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../update/update.fxml"));

            try {
                Parent root = fxmlLoader.load();

                Stage thisStage = (Stage) searchbutton.getScene().getWindow();
                thisStage.setTitle("Update subscription");

                com.esprit.veltun.GUI.abonnementt.update.AbonnementUpdateController cont = fxmlLoader.getController();
                cont.setAbonnement(abonnement);

                eventlistview.getScene().setRoot(root);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else {
            // User clicked Cancel or closed the dialog
        }
    }

    @FXML
    void addEvent(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure you want to create a new subscription?");
        alert.setContentText("Ok to create.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../create/create.fxml"));

            Stage thisStage = (Stage) searchbutton.getScene().getWindow();
            thisStage.setTitle("creation of subscription");

            try {
                Parent root = fxmlLoader.load();
                eventlistview.getScene().setRoot(root);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }}
    }

    public void search(ActionEvent actionEvent) {
        runSearch();
    }


    public void tooffer(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../offree/search/searchof.fxml"));
        try {
            Parent root = fxmlLoader.load();
            tooffer.getScene().setRoot(root);
        } catch (IOException ex)
        {
            System.out.println(ex);
        }

    }
}
