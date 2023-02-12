
package com.esprit.veltun.interfaces;

import java.util.List;
import com.esprit.veltun.model.Station;

/**
 *
 * @author user
 */
public interface interfaceCRUDstation {
	public void ajouterStation(Station s);

	public void ajouterStation2(Station s);

	public void modifierStation(Station s);

	public void supprimerStation(int id);

	public List<Station> afficherStation();

}
