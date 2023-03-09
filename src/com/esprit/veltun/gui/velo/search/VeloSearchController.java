package com.esprit.veltun.gui.velo.search;


//import com.esprit.veltun.gui.;
//import com.esprit.veltun.gui.fournisseur.view.FournisseurDetailsControllerview;
//import com.esprit.veltun.gui.invitation.create.InvitationCreateController;

import com.esprit.veltun.gui.velo.update.VeloUpdateController;
import com.esprit.veltun.gui.velo.javafx_qrcodewriter.QRCodeGenerator;
import com.esprit.veltun.model.Velo;
import com.esprit.veltun.search.dto.VeloSearchCriteria;
import com.esprit.veltun.services.VeloService;
import com.esprit.veltun.services.impl.VeloServiceImpl;
import com.esprit.veltun.util.MyConnection;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

import javafx.util.Callback;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.Rating;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.ResourceBundle;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

// Importez la classe contenant la méthode generateQRCode

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static com.esprit.veltun.gui.velo.javafx_qrcodewriter.QRCodeGenerator.drawQRCode;


public class VeloSearchController implements Initializable {
    public TextField titletosearch;
    public TextField tfcolor;

    public Button searchbutton;
    public Button editeventbutton;
    private VeloService veloService = new VeloServiceImpl();
    public ListView<Velo> velolistview;
    private ImageView qrView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        velolistview.setCellFactory(param -> {
            return new ListCell<Velo>() {
                private final ImageView qrView = new ImageView();

                @Override
                protected void updateItem(Velo velo, boolean empty) {
                    super.updateItem(velo, empty);

                    if (empty || velo == null) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        setText(velo.getLibelle() + "\t\t" + velo.getTaille() + "\t\t" + velo.getCouleur());

                        int width = 100;
                        int height = 100;
                        String fileType = "png";
                        long veloR = velo.getIdf();

                        System.out.println("Generating QR code for rating: " + veloR);

                        try {
                            String mostFrequentColor = veloService.veloDominante();
                            tfcolor.setText("Most raited velo: " + mostFrequentColor);
                            BitMatrix bitMatrix = QRCodeGenerator.generateQRCode(String.valueOf(veloR), width, height);

                            System.out.println("Bit matrix: " + bitMatrix.toString());

                            Canvas canvas = drawQRCode(bitMatrix, width, height);
                            qrView.setImage(canvas.snapshot(null, null));
                            setGraphic(new HBox(qrView));
                        } catch (WriterException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            };
        });


    runSearch();

                }


                void runSearch() {
                    String libellev = titletosearch.getText();
                    VeloSearchCriteria veloSearchCriteria = new VeloSearchCriteria();
                    if (libellev != null && !libellev.isEmpty()) {
                        veloSearchCriteria.setLibelle(libellev);
                    }
                    Collection<Velo> velo = veloService.search(veloSearchCriteria);
                    velolistview.getItems().setAll(velo);
                }

                @FXML
                void removeEvent(ActionEvent mouseEvent) {
                    Velo velo = velolistview.getSelectionModel().getSelectedItem();
                    int selectionIndex = velolistview.getSelectionModel().getSelectedIndex();
                    veloService.remove(velo.getId());
                    velolistview.getItems().remove(selectionIndex);
                    addNotifications("Succes", "Velo supprimé");

                }

                @FXML
                void editEvent(ActionEvent mouseEvent) {

                }

                @FXML
                void addVelo(ActionEvent actionEvent) {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../create/create.fxml"));

                    Stage thisStage = (Stage) searchbutton.getScene().getWindow();
                    thisStage.setTitle("Création d'un velo");

                    try {
                        Parent root = fxmlLoader.load();
                        velolistview.getScene().setRoot(root);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }


                public void search(ActionEvent actionEvent) {
                    runSearch();
                }


                public void editVelo(ActionEvent actionEvent) {
                    Velo velo = velolistview.getSelectionModel().getSelectedItem();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../update/update.fxml"));

                    try {
                        Parent root = fxmlLoader.load();

                        Stage thisStage = (Stage) searchbutton.getScene().getWindow();
                        thisStage.setTitle("Mise à jour d'un velo");

                        VeloUpdateController cont = fxmlLoader.getController();
                        cont.setVelo(velo);

                        velolistview.getScene().setRoot(root);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                private void addNotifications(String title, String content) {

                    if (null != content) {
                        if (content.length() > 50) {
                            content = content.substring(0, 49) + "......";
                        }
                    }
                    Notifications notificationBuilder = Notifications.create()
                            .title(title)
                            .text(content)
                            .hideAfter(Duration.seconds(360))
                            .position(Pos.BOTTOM_RIGHT);

                    notificationBuilder.showInformation();
                }

                public void quit(ActionEvent actionEvent) {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../rating/rating.fxml"));

                    try {
                        Parent root = fxmlLoader.load();
                        titletosearch.getScene().setRoot(root);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }


            }

