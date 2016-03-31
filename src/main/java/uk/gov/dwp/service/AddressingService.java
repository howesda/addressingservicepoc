package uk.gov.dwp.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
    	return Response.status(Status.OK).entity(postcode).build();
    }
}
