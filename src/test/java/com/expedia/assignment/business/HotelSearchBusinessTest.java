package com.expedia.assignment.business;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.expedia.assignment.bean.HotelSearchCriteriaBean;
import com.expedia.assignment.business.exception.ServiceException;

/**
 * This class Represent all the test cases that used to test : 
 * [com.expedia.assignment.business.HotelSearchBusiness]
 *
 * @author Ahmad Fayyad
 * @version 1.0
 * @since 2018-02-09
 */
public class HotelSearchBusinessTest extends HotelSearchBusiness {

	/**
	 * this method is used to check the URL to test the case where the
	 * "destinationName" query param has white spaces.
	 * 
	 * @author Ahmad Fayyad
	 * @version 1.0
	 * @since 2018-02-09
	 */
	@Test
	public void mockComposeURL_testDestinationNameParameter() throws ServiceException {

		HotelSearchBusiness hotelSearchBusiness = new HotelSearchBusiness();
		HotelSearchCriteriaBean hotelSearchCriteriaBean = new HotelSearchCriteriaBean();
		hotelSearchCriteriaBean.setDestination("Amman Jordan");
		Assert.assertEquals(
				"https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&destinationName=Amman+Jordan",
				hotelSearchBusiness.composeURL(hotelSearchCriteriaBean));
	}

	/**
	 * this method is used to check the URL to test the case where the
	 * "lengthOfStay" query param added to Expedia hotel service URI
	 * 
	 * @author Ahmad Fayyad
	 * @version 1.0
	 * @since 2018-02-09
	 */
	@Test
	public void mockComposeURL_testLengthOfStayParameter() throws ServiceException {

		HotelSearchBusiness hotelSearchBusiness = new HotelSearchBusiness();
		HotelSearchCriteriaBean hotelSearchCriteriaBean = new HotelSearchCriteriaBean();
		hotelSearchCriteriaBean.setLengthOfStay(2);
		Assert.assertEquals(
				"https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&lengthOfStay=2",
				hotelSearchBusiness.composeURL(hotelSearchCriteriaBean));
	}

	/**
	 * this method is used to check the URL to test the case where the
	 * "minStarRating" query param added to the Expedia hotel service URI
	 * 
	 * @author Ahmad Fayyad
	 * @version 1.0
	 * @since 2018-02-09
	 */
	@Test
	public void mockComposeURL_testMinStarRatingParameter() throws ServiceException {

		HotelSearchBusiness hotelSearchBusiness = new HotelSearchBusiness();
		HotelSearchCriteriaBean hotelSearchCriteriaBean = new HotelSearchCriteriaBean();
		hotelSearchCriteriaBean.setMinStarRating(2.3);
		Assert.assertEquals(
				"https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&minStarRating=2.3",
				hotelSearchBusiness.composeURL(hotelSearchCriteriaBean));
	}

	/**
	 * this method is used to check the URL to test the case where the
	 * "maxStarRating" query param added to the Expedia hotel service URI
	 * 
	 * @author Ahmad Fayyad
	 * @version 1.0
	 * @since 2018-02-09
	 */
	@Test
	public void mockComposeURL_testMaxStarRatingParameter() throws ServiceException {

		HotelSearchBusiness hotelSearchBusiness = new HotelSearchBusiness();
		HotelSearchCriteriaBean hotelSearchCriteriaBean = new HotelSearchCriteriaBean();
		hotelSearchCriteriaBean.setMaxStarRating(4.5);
		Assert.assertEquals(
				"https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&maxStarRating=4.5",
				hotelSearchBusiness.composeURL(hotelSearchCriteriaBean));
	}

	/**
	 * this method is used to check the URL to test the case where the
	 * "minGuestRating" query param added to the Expedia hotel service URI
	 * 
	 * @author Ahmad Fayyad
	 * @version 1.0
	 * @since 2018-02-09
	 */
	@Test
	public void mockComposeURL_testMinGuestRatingParameter() throws ServiceException {

		HotelSearchBusiness hotelSearchBusiness = new HotelSearchBusiness();
		HotelSearchCriteriaBean hotelSearchCriteriaBean = new HotelSearchCriteriaBean();
		hotelSearchCriteriaBean.setMinGuestRating(3.2);
		Assert.assertEquals(
				"https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&minGuestRating=3.2",
				hotelSearchBusiness.composeURL(hotelSearchCriteriaBean));
	}

	/**
	 * this method is used to check the URL to test the case where the
	 * "maxGuestRating" query param added to the Expedia hotel service URI
	 * 
	 * @author Ahmad Fayyad
	 * @version 1.0
	 * @since 2018-02-09
	 */
	@Test
	public void mockComposeURL_testMaxGuestRatingParameter() throws ServiceException {

		HotelSearchBusiness hotelSearchBusiness = new HotelSearchBusiness();
		HotelSearchCriteriaBean hotelSearchCriteriaBean = new HotelSearchCriteriaBean();
		hotelSearchCriteriaBean.setMaxGuestRating(3.7);
		Assert.assertEquals(
				"https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&maxGuestRating=3.7",
				hotelSearchBusiness.composeURL(hotelSearchCriteriaBean));
	}

	/**
	 * this method is used to check the URL to test the case where the
	 * "minTotalRating" query param added to the Expedia hotel service URI
	 * 
	 * @author Ahmad Fayyad
	 * @version 1.0
	 * @since 2018-02-09
	 */
	@Test
	public void mockComposeURL_testMinTotalRatingParameter() throws ServiceException {

		HotelSearchBusiness hotelSearchBusiness = new HotelSearchBusiness();
		HotelSearchCriteriaBean hotelSearchCriteriaBean = new HotelSearchCriteriaBean();
		hotelSearchCriteriaBean.setMinTotalRating(4.0);
		Assert.assertEquals(
				"https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&minTotalRating=4.0",
				hotelSearchBusiness.composeURL(hotelSearchCriteriaBean));
	}

	/**
	 * this method is used to check the URL to test the case where the
	 * "maxTotalRating" query param added to the Expedia hotel service URI
	 * 
	 * @author Ahmad Fayyad
	 * @version 1.0
	 * @since 2018-02-09
	 */
	@Test
	public void mockComposeURL_testMaxTotalRatingParameter() throws ServiceException {

		HotelSearchBusiness hotelSearchBusiness = new HotelSearchBusiness();
		HotelSearchCriteriaBean hotelSearchCriteriaBean = new HotelSearchCriteriaBean();
		hotelSearchCriteriaBean.setMaxTotalRating(4.9);
		Assert.assertEquals(
				"https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&maxTotalRating=4.9",
				hotelSearchBusiness.composeURL(hotelSearchCriteriaBean));
	}

	/**
	 * this method is used to check the URL to test the case where the
	 * "minTripStartDate" query param added to the Expedia hotel service URI
	 * 
	 * @author Ahmad Fayyad
	 * @version 1.0
	 * @since 2018-02-09
	 */
	@Test
	public void mockComposeURL_testMinTripStartDateParameter() throws ServiceException {

		HotelSearchBusiness hotelSearchBusiness = new HotelSearchBusiness();
		Date minTripStartDate = new Date();
		HotelSearchCriteriaBean hotelSearchCriteriaBean = new HotelSearchCriteriaBean();
		hotelSearchCriteriaBean.setMinTripStartDate(minTripStartDate);
		Assert.assertEquals(
				"https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&minTripStartDate="
						+ DATE_FORMAT.format(minTripStartDate),
				hotelSearchBusiness.composeURL(hotelSearchCriteriaBean));
	}

	/**
	 * this method is used to check the URL to test the case where the
	 * "maxTripStartDate" query param added to the Expedia hotel service URI
	 * 
	 * @author Ahmad Fayyad
	 * @version 1.0
	 * @since 2018-02-09
	 */
	@Test
	public void mockComposeURL_testMaxTripStartDateParameter() throws ServiceException {

		HotelSearchBusiness hotelSearchBusiness = new HotelSearchBusiness();
		Date maxTripStartDate = new Date();
		HotelSearchCriteriaBean hotelSearchCriteriaBean = new HotelSearchCriteriaBean();
		hotelSearchCriteriaBean.setMaxTripStartDate(maxTripStartDate);
		Assert.assertEquals(
				"https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&maxTripStartDate="
						+ DATE_FORMAT.format(maxTripStartDate),
				hotelSearchBusiness.composeURL(hotelSearchCriteriaBean));
	}

	/**
	 * this method is used to check the returned object after sending the URI to
	 * Expedia service
	 * 
	 * @author Ahmad Fayyad
	 * @version 1.0
	 * @since 2018-02-09
	 */
	@Test()
	public void mockSearchHotels_testSearchHotels() throws ServiceException {

		Map<String, Object> result = searchHotels(new HotelSearchCriteriaBean());
		Assert.assertNotNull(result);
	}
}
