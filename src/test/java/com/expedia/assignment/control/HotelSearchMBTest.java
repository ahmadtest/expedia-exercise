package com.expedia.assignment.control;

import java.util.Calendar;

import org.junit.Test;

import com.expedia.assignment.bean.HotelSearchCriteriaBean;

/**
 * This class Represent all the test cases that used to test:
 * [com.expedia.assignment.control.HotelSearchMB]
 *
 * @author Ahmad Fayyad
 * @version 1.0
 * @since 2018-02-09
 */
public class HotelSearchMBTest extends HotelSearchMB {

	private static final long serialVersionUID = 2173685643187342145L;

	/**
	 * this method is used to test the validation case where the "minTripStartDate"
	 * query param is after the "maxTripStartDate"
	 * 
	 * @author Ahmad Fayyad
	 * @version 1.0
	 * @since 2018-02-09
	 */
	@Test(expected = IllegalArgumentException.class)
	public void mockValidateSearchCriteria_testValidateTripDate() {

		Calendar minTripStartDate = Calendar.getInstance();
		minTripStartDate.set(Calendar.YEAR, 2017);

		Calendar maxTripStartDate = Calendar.getInstance();
		maxTripStartDate.set(Calendar.YEAR, 2012);

		HotelSearchCriteriaBean hotelSearchCriteriaBean = new HotelSearchCriteriaBean();
		hotelSearchCriteriaBean.setMinTripStartDate(minTripStartDate.getTime());
		hotelSearchCriteriaBean.setMaxTripStartDate(maxTripStartDate.getTime());
		setSearchCriteria(hotelSearchCriteriaBean);
		validateSearchCriteria();
	}

	/**
	 * this method is used to test the validation case where the "minStarRating"
	 * query param is greater than the "maxStarRating"
	 * 
	 * @author Ahmad Fayyad
	 * @version 1.0
	 * @since 2018-02-09
	 */
	@Test(expected = IllegalArgumentException.class)
	public void mockValidateSearchCriteria_testValidateStarRating() {

		HotelSearchCriteriaBean hotelSearchCriteriaBean = new HotelSearchCriteriaBean();
		hotelSearchCriteriaBean.setMinStarRating(3.0);
		hotelSearchCriteriaBean.setMaxStarRating(2.1);
		setSearchCriteria(hotelSearchCriteriaBean);
		validateSearchCriteria();
	}

	/**
	 * this method is used to test the validation case where the "minGuestRating"
	 * query param is greater than the "maxGuestRating"
	 * 
	 * @author Ahmad Fayyad
	 * @version 1.0
	 * @since 2018-02-09
	 */
	@Test(expected = IllegalArgumentException.class)
	public void mockValidateSearchCriteria_testValidateGuestRating() {

		HotelSearchCriteriaBean hotelSearchCriteriaBean = new HotelSearchCriteriaBean();
		hotelSearchCriteriaBean.setMinGuestRating(4.0);
		hotelSearchCriteriaBean.setMaxGuestRating(3.4);
		setSearchCriteria(hotelSearchCriteriaBean);
		validateSearchCriteria();
	}

	/**
	 * this method is used to test the validation case where the "minTotalRate"
	 * query param is after the "maxTotalRate"
	 * 
	 * @author Ahmad Fayyad
	 * @version 1.0
	 * @since 2018-02-09
	 */
	@Test(expected = IllegalArgumentException.class)
	public void mockValidateSearchCriteria_testValidateTotalRating() {

		HotelSearchCriteriaBean hotelSearchCriteriaBean = new HotelSearchCriteriaBean();
		hotelSearchCriteriaBean.setMinTotalRating(3.2);
		hotelSearchCriteriaBean.setMaxTotalRating(1.4);
		setSearchCriteria(hotelSearchCriteriaBean);
		validateSearchCriteria();
	}

}
