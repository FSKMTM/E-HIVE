package si.fs.kmtm.ehive.api.v1.viri;

import si.fs.kmtm.ehive.api.JPAServlet;
import si.fs.kmtm.ehive.entitete.Meritev;
import si.fs.kmtm.ehive.entitete.Podnica;
import si.fs.kmtm.ehive.entitete.Tip;
import si.fs.kmtm.ehive.storitve.dto.UrejanjeMeritevDto;
import si.fs.kmtm.ehive.storitve.dto.UrejanjePodniceDto;
import si.fs.kmtm.ehive.storitve.zrna.MeritevZrno;
import si.fs.kmtm.ehive.storitve.zrna.PodnicaZrno;
import si.fs.kmtm.ehive.storitve.zrna.TipZrno;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Path("meritve")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class MeritevVir {

    private static final Logger logger = Logger.getLogger(MeritevVir.class.getName());

    @Inject
    private MeritevZrno meritevZrno;

    @Inject
    private PodnicaZrno podnicaZrno;

    @Inject
    private TipZrno tipZrno;

    @GET
    public Response vrniMeritve() {
//        QueryParameters query = QueryParameters.query(uriInfo.getRequestUri().getQuery()).build();
        List<Meritev> meritve = meritevZrno.pridobiMeritve();
        return Response.status(Response.Status.OK).entity(meritve).build();
    }

    @Path("{id}")
    @GET
    public Response vrniMeritev(@PathParam("id") Integer meritevId) {
        Meritev meritev = meritevZrno.pridobiMeritev(meritevId);
        if (meritev == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.OK).entity(meritev).build();
    }

    @Path("{id}")
    @DELETE
    public Response izbrisiMeritev(@PathParam("id") Integer meritevId) {
        if (meritevZrno.izbrisiMeritev(meritevId)) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response ustvariMeritev(UrejanjeMeritevDto mer) {

        Meritev meritev = new Meritev();
        meritev.setCas_meritve(mer.getCas_meritve());

        meritev.setVrednost(mer.getVrednost());

        Tip tip = tipZrno.pridobiTip(mer.getTip_id());
        if(tip == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        meritev.setTip(tip);

        Podnica podnica = podnicaZrno.pridobiPodnico(mer.getPodnica_id());
        if(podnica == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        meritev.setPodnica(podnica);

        meritevZrno.ustvariMeritev(meritev);
        return Response.status(Response.Status.CREATED).entity(meritev).build();


    }


}
