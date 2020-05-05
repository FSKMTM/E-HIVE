package si.fs.kmtm.ehive.api;

import si.fs.kmtm.ehive.entitete.Podnica;
import si.fs.kmtm.ehive.storitve.zrna.PodnicaZrno;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/servlet")
public class JPAServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(JPAServlet.class.getName());

    @Inject
    private PodnicaZrno podnicaZrno;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("doGet");

        List<Podnica> podnice = podnicaZrno.pridobiVse();

        resp.setContentType("text/html");
        // izpis uporabnikov na spletno stran
        PrintWriter printWriter = new PrintWriter(resp.getWriter());
        printWriter.print("Vse podnice: \n<br>");
        for (Podnica podnica : podnice) {
            printWriter.print(podnica.getId()+"<br>");

        }


    }
}
