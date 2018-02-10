package com.expedia.assignment.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * This Bean Represent the user selection to filter the search results.
 *
 * @author Ahmad Fayyad
 * @version 1.0
 * @since 2018-02-09
 */

public class HotelSearchCriteriaBean implements Serializable {

	private static final long serialVersionUID = 7305927662653012136L;

	private String destination;
	private Date minTripStartDate;
	private Date maxTripStartDate;
	private Integer lengthOfStay;
	private Double minStarRating;
	private Double maxStarRating;
	private Double minTotalRating;
	private Double maxTotalRating;
	private Double minGuestRating;
	private Double maxGuestRating;

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getMinTripStartDate() {
		return minTripStartDate;
	}

	public void setMinTripStartDate(Date minTripStartDate) {
		this.minTripStartDate = minTripStartDate;
	}

	public Date getMaxTripStartDate() {
		return maxTripStartDate;
	}

	public void setMaxTripStartDate(Date maxTripStartDate) {
		this.maxTripStartDate = maxTripStartDate;
	}

	public Integer getLengthOfStay() {
		return lengthOfStay;
	}

	public void setLengthOfStay(Integer lengthOfStay) {
		this.lengthOfStay = lengthOfStay;
	}

	public Double getMinStarRating() {
		return minStarRating;
	}

	public void setMinStarRating(Double minStarRating) {
		this.minStarRating = minStarRating;
	}

	public Double getMaxStarRating() {
		return maxStarRating;
	}

	public void setMaxStarRating(Double maxStarRating) {
		this.maxStarRating = maxStarRating;
	}

	public Double getMinTotalRating() {
		return minTotalRating;
	}

	public void setMinTotalRating(Double minTotalRating) {
		this.minTotalRating = minTotalRating;
	}

	public Double getMaxTotalRating() {
		return maxTotalRating;
	}

	public void setMaxTotalRating(Double maxTotalRating) {
		this.maxTotalRating = maxTotalRating;
	}

	public Double getMinGuestRating() {
		return minGuestRating;
	}

	public void setMinGuestRating(Double minGuestRating) {
		this.minGuestRating = minGuestRating;
	}

	public Double getMaxGuestRating() {
		return maxGuestRating;
	}

	public void setMaxGuestRating(Double maxGuestRating) {
		this.maxGuestRating = maxGuestRating;
	}

}