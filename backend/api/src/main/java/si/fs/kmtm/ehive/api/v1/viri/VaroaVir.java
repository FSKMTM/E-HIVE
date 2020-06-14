package si.fs.kmtm.ehive.api.v1.viri;

import com.kumuluz.ee.cors.annotations.CrossOrigin;
import com.kumuluz.ee.rest.beans.QueryParameters;
import si.fs.kmtm.ehive.entitete.Podnica;
import si.fs.kmtm.ehive.entitete.Varoa;
import si.fs.kmtm.ehive.storitve.dto.PridobiVaroaDto;
import si.fs.kmtm.ehive.storitve.zrna.PodnicaZrno;
import si.fs.kmtm.ehive.storitve.zrna.VaroaZrno;

import javax.enterprise.context.ApplicationScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@CrossOrigin(supportedMethods = "GET, POST, HEAD, OPTIONS, DELETE")
@Path("varoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class VaroaVir {
    @Inject
    VaroaZrno varoaZrno;

    @Inject
    PodnicaZrno podnicaZrno;

    @Context
    private UriInfo uriInfo;

    @Consumes(MediaType.WILDCARD)
    @POST
    public Response novaVaroa(@QueryParam("podnica") Integer podnicaId, @QueryParam("ustvarjeno") Long ustvarjeno, InputStream uploadedInputStream) {
        String naslovSlike = "";
        if (uploadedInputStream == null)
            return Response.status(Response.Status.BAD_REQUEST).entity("{\"sporocilo\":\"Neustrezna datoteka\"}").build();
        try {
            BufferedImage imBuff = ImageIO.read(uploadedInputStream);
            Podnica podnica = podnicaZrno.pridobiPodnico(podnicaId);
            if (podnica == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("{\"sporocilo\":\"Napačni id podnice\"}").build();
            }
            naslovSlike = varoaZrno.ustvariSliko(imBuff, new Date(ustvarjeno), podnica);
        } catch (IOException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("{\"sporocilo\":\"Neustrezna datoteka\"}").build();
        }
        return Response.status(Response.Status.OK).entity("{\"sporocilo\":\"Uspešno naloženo\",\"naslovSlike\":\"" + naslovSlike + "\"}").build();
    }


//    @GET
//    @Path("/latest")
//    @Produces(MediaType.APPLICATION_OCTET_STREAM)
//    public Response najnovejsaVaroa() {
//        QueryParameters query = QueryParameters.query(uriInfo.getRequestUri().getQuery()).build();
//        PridobiVaroaDto dto = varoaZrno.pridobiZadnjoSliko(query);
//        if (dto == null) {
//            return Response.status(Response.Status.NOT_FOUND).entity("{\"sporocilo\":\"Ta slika ne obstaja\"}").build();
//        }
//        return Response.ok(dto.getSlika(), MediaType.APPLICATION_OCTET_STREAM)
//                .header("Access-Control-Expose-Headers", "*")
//                .header("Content-Disposition", "inline; filename=\"" + dto.getIme_datoteke() + "\"")
//                .header("Created", new SimpleDateFormat("d. MM. YYYY, HH:mm:ss").format(dto.getUstvarjeno()))
//                .build();
//
//    }

    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response pridobiVaroa() {
        QueryParameters query = QueryParameters.query(uriInfo.getRequestUri().getQuery()).build();
        PridobiVaroaDto dto = varoaZrno.pridobiSliko(query);
        if (dto == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"sporocilo\":\"Ta slika ne obstaja\"}")
                    .header("Access-Control-Expose-Headers", "*")
                    .header("X-Total-Count", 0)
                    .build();
        }
        return Response.ok(dto.getSlika(), MediaType.APPLICATION_OCTET_STREAM)
                .header("Access-Control-Expose-Headers", "*")
                .header("Content-Disposition", "inline; filename=\"" + dto.getIme_datoteke() + "\"")
                .header("Created", new SimpleDateFormat("d. MM. YYYY, HH:mm:ss").format(dto.getUstvarjeno()))
                .header("X-Total-Count", varoaZrno.stMeritev(query))
                .build();

    }



}
