package org.exameple.api;

import java.lang.Integer;
import java.lang.String;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/pets")
public interface Pets {
  @GET
  @Produces("application/json")
  org.exameple.api.beans.Pets listPets(@QueryParam("limit") Integer limit);

  @POST
  void createPets();

  @Path("/{petId}")
  @GET
  @Produces("application/json")
  org.exameple.api.beans.Pets showPetById(@PathParam("petId") String petId);
}
