package si.fs.kmtm.ehive.api.v1.viri;

import com.kumuluz.ee.cors.annotations.CrossOrigin;
import si.fs.kmtm.ehive.entitete.Podnica;
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
import java.util.Date;

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
    private UriInfo context;

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


    private String getFileName(MultivaluedMap<String, String> header) {

        String[] contentDisposition = header.getFirst("Content-Disposition").split(";");

        for (String filename : contentDisposition) {
            if ((filename.trim().startsWith("filename"))) {
                String[] name = filename.split("=");
                String finalFileName = name[1].trim().replaceAll("\"", "");
                return finalFileName;
            }
        }
        return "unknown";
    }


//    @GET
//    @Path("/{imeSlike}")
//    @Produces(MediaType.APPLICATION_OCTET_STREAM)
//    public Response slikaKarte(@PathParam("imeSlike") String imeSlike) {
//        System.out.println(context.getAbsolutePath());
//        File slika = slikeZrno.datotekaSlikeKarte(imeSlike);
//        if (slika == null) {
//            return Response.status(Response.Status.NOT_FOUND).entity("{\"sporocilo\":\"Ta slika ne obstaja\"}").build();
//        }
//        return Response.ok(slika, MediaType.APPLICATION_OCTET_STREAM)
//                .header("Content-Disposition", "inline; filename=\"" + slika.getName() + "\"" )
//                .build();
//    }



}
