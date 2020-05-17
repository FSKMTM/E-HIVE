package si.fs.kmtm.ehive.api.v1;

import com.kumuluz.ee.cors.annotations.CrossOrigin;

import javax.persistence.Access;
import javax.ws.rs.core.Application;

import javax.ws.rs.ApplicationPath;

//@OpenAPIDefinition(info = @Info(title = "Ehive API",
//        version = "v1",
//        contact = @Contact(),
//        license = @License(),
//        description = "API za opazovalno podnico"),
//        security = @SecurityRequirement(name = "openid-connect"),
//        servers = @Server(url ="http://localhost:8080/v1"))
@CrossOrigin
@ApplicationPath("v1")
public class EhiveAplikacija extends Application{

}
