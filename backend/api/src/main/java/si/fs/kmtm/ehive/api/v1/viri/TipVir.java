package si.fs.kmtm.ehive.api.v1.viri;

import si.fs.kmtm.ehive.entitete.Podnica;
import si.fs.kmtm.ehive.entitete.Tip;
import si.fs.kmtm.ehive.storitve.zrna.PodnicaZrno;
import si.fs.kmtm.ehive.storitve.zrna.TipZrno;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("tipi")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class TipVir {
    @Inject
    private TipZrno tipZrno;

    @GET
    public Response vrniTipe() {
//        QueryParameters query = QueryParameters.query(uriInfo.getRequestUri().getQuery()).build();
        List<Tip> tipi = tipZrno.pridobiTipe();
        return Response.status(Response.Status.OK).entity(tipi)
                .header("Access-Control-Allow-Origin", "*")
                .build();
    }
}
