package com.esprit.veltun.search.dto;

import com.esprit.veltun.model.Adresse;
import com.esprit.veltun.search.base.dto.SearchCriteria;

public class AdresseSearchCriteria extends SearchCriteria<Adresse>{

		private String rue;
		private String region;
		private Double longitude;
		private Double latitude;

		

		public String getRue() {
			return rue;
		}

		public void setRue(String rue) {
			this.rue = rue;
		}

		public String getRegion() {
			return region;
		}

		public void setRegion(String region) {
			this.region = region;
		}

		public Double getLongitude() {
			return longitude;
		}

		public void setLongitude(Double longitude) {
			this.longitude = longitude;
		}

		public Double getLatitude() {
			return latitude;
		}

		public void setLatitude(Double latitude) {
			this.latitude = latitude;
		}

		@Override
		public String toString() {
			return "Adresse [id=" + getId() + ", rue=" + rue + ", region=" + region + ", longitude=" + longitude
					+ ", latitude=" + latitude + "]";
		}

	}


}
