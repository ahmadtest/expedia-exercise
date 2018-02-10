package com.expedia.assignment.business;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.client.utils.URIBuilder;
import org.codehaus.jackson.map.ObjectMapper;

import com.expedia.assignment.bean.HotelSearchCriteriaBean;
import com.expedia.assignment.business.exception.ServiceException;

/**
 * This class Represent the search business based on user filtration
 *
 * @author Ahmad Fayyad
 * @version 1.0
 * @since 2018-02-09
 */
public class HotelSearchBusiness {

	private static final String SERVICE_URL = "https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel";
	protected static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private ObjectMapper mapper = new ObjectMapper();

	/**
	 * This method fetch the search result from Expedia Web service
	 * 
	 * @param searchCriteria
	 * @returnMap<String, Object>
	 * @throws ServiceException
	 * @author Ahmad Fayyad
	 * @version 1.0
	 * @since 2018-02-09
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchHotels(HotelSearchCriteriaBean searchCriteria) throws ServiceException {

		Map<String, Object> result = null;
		try (InputStream inputStream = sendRequest(composeURL(searchCriteria))) {
			result = mapper.readValue(inputStream, Map.class);
		} catch (IOException e) {
			e.printStackTrace();
			throw new ServiceException("Failed to get offers due to: " + e.getMessage(), e);
		}
		return result;
	}

	/**
	 * This method append the user search filtration to expedia hotels URI
	 * 
	 * @param searchCriteria
	 * @author Ahmad Fayyad
	 * @version 1.0
	 * @throws ServiceException
	 * @since 2018-02-09
	 */
	protected String composeURL(HotelSearchCriteriaBean searchCriteria) throws ServiceException {

		try {
			URIBuilder uriBuilder = new URIBuilder(SERVICE_URL);

			if (searchCriteria.getDestination() != null && !searchCriteria.getDestination().isEmpty()) {
				uriBuilder.addParameter("destinationName", searchCriteria.getDestination());
			}
			if (searchCriteria.getMinTripStartDate() != null) {
				uriBuilder.addParameter("minTripStartDate", DATE_FORMAT.format(searchCriteria.getMinTripStartDate()));
			}
			if (searchCriteria.getMaxTripStartDate() != null) {
				uriBuilder.addParameter("maxTripStartDate", DATE_FORMAT.format(searchCriteria.getMaxTripStartDate()));
			}
			if (searchCriteria.getLengthOfStay() != null) {
				uriBuilder.addParameter("lengthOfStay", String.valueOf(searchCriteria.getLengthOfStay()));
			}
			if (searchCriteria.getMinStarRating() != null) {
				uriBuilder.addParameter("minStarRating", String.valueOf(searchCriteria.getMinStarRating()));
			}
			if (searchCriteria.getMaxStarRating() != null) {
				uriBuilder.addParameter("maxStarRating", String.valueOf(searchCriteria.getMaxStarRating()));
			}
			if (searchCriteria.getMinGuestRating() != null) {
				uriBuilder.addParameter("minGuestRating", String.valueOf(searchCriteria.getMinGuestRating()));
			}
			if (searchCriteria.getMaxGuestRating() != null) {
				uriBuilder.addParameter("maxGuestRating", String.valueOf(searchCriteria.getMaxGuestRating()));
			}
			if (searchCriteria.getMinTotalRating() != null) {
				uriBuilder.addParameter("minTotalRating", String.valueOf(searchCriteria.getMinTotalRating()));
			}
			if (searchCriteria.getMaxTotalRating() != null) {
				uriBuilder.addParameter("maxTotalRating", String.valueOf(searchCriteria.getMaxTotalRating()));
			}
			return uriBuilder.build().toString();
		} catch (URISyntaxException e) {
			throw new ServiceException("Failed to compose service URL due to: " + e.getMessage(), e);
		}
	}

	/**
	 * This method send https request to the received URL.
	 * 
	 * @param url
	 * @return InputStream
	 * @throws IOException
	 * @author Ahmad Fayyad
	 * @version 1.0
	 * @throws ServiceException
	 * @since 2018-02-09
	 */
	protected InputStream sendRequest(String url) throws ServiceException {

		try {
			URL httpsUrl = new URL(url);
			HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpsUrl.openConnection();
			httpsURLConnection.setRequestMethod("GET");
			return httpsURLConnection.getInputStream();
		} catch (IOException e) {
			throw new ServiceException("Failed to send http request due to: " + e.getMessage(), e);
		}
	}
}