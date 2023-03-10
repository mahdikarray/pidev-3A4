
package com.esprit.veltun.model;
import com.esprit.veltun.model.base.BaseEntity;
import javafx.scene.image.Image;

public class Velo extends BaseEntity {
    private int idf;
    private String libellev;
    private String taillev;
    private String couleurv;
    private int rating;
    private Image image;



    public Velo() {
    }

    public Velo(Integer id, String libellev, String taillev, String couleurv, Integer idf , Integer rating , Image image) {
        this.setId(id);
        this.libellev = libellev;
        this.taillev = taillev;
        this.couleurv = couleurv;
        this.idf = idf;
        this.rating = rating;
        this.image = image;



    }

    public Velo(String libellev, String taillev, String couleurv, Integer idf, Integer rating , Image image) {
        this.libellev = libellev;
        this.taillev = taillev;
        this.couleurv = couleurv;
        this.idf = idf;
        this.rating = rating;
        this.image = image;


    }


    public Image getImage() {
        return this.image;
    }
    public void setImage(Image image) {
        this.image = image;
    }
    public Integer getRating() {
        return this.rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getLibelle() {
        return this.libellev;
    }

    public void setLibelle(String libellev) {
        this.libellev = libellev;
    }

    public String getTaille() {
        return this.taillev;
    }

    public void setTaille(String taillev) {
        this.taillev = taillev;
    }

    public String getCouleur() {
        return this.couleurv;
    }

    public void setCouleur(String couleurv) {
        this.couleurv = couleurv;
    }

    public Integer getIdf() {
        return this.idf;
    }

    public void setIdf(Integer idf) {
        this.idf = idf;
    }

    public String toString() {
        return "Velo{**id=" + this.getId() + ", **ibelle=" + this.libellev + ", **taille=" + this.taillev + ", **couleur=" + this.couleurv + ", **idf=" + this.idf + '}';
    }


}
