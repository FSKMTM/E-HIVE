package si.fs.kmtm.ehive.api.v1.viri;


import si.fs.kmtm.ehive.entitete.Podnica;
import si.fs.kmtm.ehive.storitve.dto.UrejanjePodniceDto;
import si.fs.kmtm.ehive.storitve.zrna.PodnicaZrno;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("podnice")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class PodnicaVir {
    @Inject
    private PodnicaZrno podnicaZrno;

    @GET
    public Response vrniPodnice() {
//        QueryParameters query = QueryParameters.query(uriInfo.getRequestUri().getQuery()).build();
        List<Podnica> podnice = podnicaZrno.pridobiPodnice();
        return Response.status(Response.Status.OK).entity(podnice).build();
    }

    @Path("{id}")
    @GET
    public Response vrniPodnico(@PathParam("id") Integer podnicaId) {
        Podnica podnica = podnicaZrno.pridobiPodnico(podnicaId);
        if (podnica == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.OK).entity(podnica).build();
    }

    @Path("{id}")
    @DELETE
    public Response izbrisiPodnico(@PathParam("id") Integer podnicaId) {
        if (podnicaZrno.izbrisiPodnico(podnicaId)) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response ustvariUporabnika(UrejanjePodniceDto pod) {
        Podnica podnica = new Podnica();
        podnica.setNaziv(pod.getNaziv());

        podnicaZrno.ustvariPodnico(podnica);
        return Response.status(Response.Status.CREATED).entity(podnica).build();
    }

    @Path("{id}")
    @PUT
    public Response posodobiPodnico(@PathParam("id") Integer podnicaId, UrejanjePodniceDto pod) {
        Podnica podnica = podnicaZrno.pridobiPodnico(podnicaId);
        if (podnica == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if (pod.getNaziv() != null)
            podnica.setNaziv(pod.getNaziv());
        podnicaZrno.posodobiPodnico(podnica);

        return Response.status(Response.Status.OK).build();
    }
}
