package uk.gov.dwp.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Implements the supported addressing services.
 */
@Path("/addresses")
@Produces(MediaType.APPLICATION_JSON)
public class AddressingService {

	/**
	 * @param postcode
	 *            the postcode search term which can be a full or partial
	 *            postcode.
	 * @return a structure containing the full set of addresses which match the
	 *         supplied full or partial postcode.
	 */
    @Path("/postcode/{postcode}")
    @GET
    public Response getByPostcode(@PathParam("postcode")String postcode) {
    	
    	return null;
    }

	/**
	 * @param uprn
	 *            the unique property reference number.
	 * @return a structure containing the address corresponding to the
	 *         supplied unique property reference number.
	 */
    @Path("/uprn/{uprn}")
    @GET
    public Response getByUprn(@PathParam("uprn")String uprn) {
    	
    	return null;
    }
}
