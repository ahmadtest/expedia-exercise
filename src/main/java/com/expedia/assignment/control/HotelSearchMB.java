package com.expedia.assignment.control;

import java.io.Serializable;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.expedia.assignment.bean.HotelSearchCriteriaBean;
import com.expedia.assignment.business.HotelSearchBusiness;

/**
 * This class represent the controller for the hotels search
 * 
 * @author Ahmad Fayyad
 * @version 1.0
 * @since 2018-02-09
 */
@ManagedBean(name = "hotelSearchMB")
@ViewScoped
public class HotelSearchMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private HotelSearchCriteriaBean searchCriteria = new HotelSearchCriteriaBean();
	private Map<String, Object> searchResult;

	/**
	 * Searches the hotels based on the criteria provided by the user.
	 * 
	 * @author Ahmad Fayyad
	 * @version 1.0
	 * @since 2018-02-09
	 */
	public void search() {

		try {
			validateSearchCriteria();
			searchResult = new HotelSearchBusiness().searchHotels(searchCriteria);
		} catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
	}

	/**
	 * Validate user search criteria.
	 * 
	 * @author Ahmad Fayyad
	 * @version 1.0
	 * @since 2018-02-09
	 */
	protected void validateSearchCriteria() {

		if (searchCriteria.getMaxTripStartDate() != null && searchCriteria.getMinTripStartDate() != null && searchCriteria.getMinTripStartDate().compareTo(searchCriteria.getMaxTripStartDate()) > 0) {
			throw new IllegalArgumentException("Min Trip Start Date must be before Max Trip Start Date");
		}
		if (searchCriteria.getMaxStarRating() != null && searchCriteria.getMinStarRating() != null && searchCriteria.getMinStarRating().compareTo(searchCriteria.getMaxStarRating()) > 0) {
			throw new IllegalArgumentException("Min Star Rating must be less than Max Star Rating");
		}
		if (searchCriteria.getMaxGuestRating() != null && searchCriteria.getMinGuestRating() != null && searchCriteria.getMinGuestRating().compareTo(searchCriteria.getMaxGuestRating()) > 0) {
			throw new IllegalArgumentException("Min Guest Rating must be less than Max Guest Rating");
		}
		if (searchCriteria.getMaxTotalRating() != null && searchCriteria.getMinTotalRating() != null && searchCriteria.getMinTotalRating().compareTo(searchCriteria.getMaxTotalRating()) > 0) {
			throw new IllegalArgumentException("Min Total Rating must be less than Max Total Rating");
		}
	}

	public HotelSearchCriteriaBean getSearchCriteria() {
		return searchCriteria;
	}

	public void setSearchCriteria(HotelSearchCriteriaBean searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	public Map<String, Object> getSearchResult() {
		return searchResult;
	}

}
