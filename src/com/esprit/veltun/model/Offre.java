package com.esprit.veltun.model;

import com.esprit.veltun.model.base.BaseEntity;

public class Offre extends BaseEntity {
<<<<<<< Updated upstream
	private int Id_offre;
	private float Prix;
=======
    private int Id_offre;
   // private float Prix;
>>>>>>> Stashed changes

	public Offre(int i) {
		this.Id_offre = Id_offre;
	}

	public Offre() {

	}

	public Offre(int Id_offre, float Prix) {
		this.Id_offre = Id_offre;
		this.Prix = Prix;
	}

<<<<<<< Updated upstream
	public int getId_offre() {
		return Id_offre;
	}

	public void setId_offre(int Id_offre) {
		this.Id_offre = Id_offre;
	}
=======

    public Offre(int Id_offre, String description_of) {
        this.Id_offre = Id_offre;
      //  this.Prix = Prix;
        this.description_of = description_of;
    }

   /* public Offre(float prix)
    {
        this.Prix=prix;
    }*/
>>>>>>> Stashed changes

	public float getPrix() {
		return Prix;
	}

	public void setPrix(float Prix) {
		this.Prix = Prix;
	}

<<<<<<< Updated upstream
	@Override
	public String toString() {
		return "offre{" + "Id_offre=" + Id_offre + ", Prix=" + Prix + '}';
	}

}
=======
   /* public float getPrix() {
        return this.Prix;
    }*/

   /* public void setPrix(float Prix) {
        this.Prix = Prix;
    }*/

    public String toString() {
        return "offre{Id_offre=" + this.Id_offre + ", description_of=" + this.description_of + '}';
    }
}
>>>>>>> Stashed changes
