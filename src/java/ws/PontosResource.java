/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import business.FuncionarioBL;
import business.PontoBL;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelos.Funcionario;
import modelos.Ponto;

/**
 * REST Web Service
 *
 * @author demetrius
 */
@Path("pontos")
public class PontosResource {

    @Context
    private UriInfo context;
    
    @EJB
    PontoBL pontoBL;
    
    @EJB
    FuncionarioBL funcionarioBL;

    /**
     * Creates a new instance of PontosResource
     */
    public PontosResource() {
    }

    /**
     * Retrieves representation of an instance of ws.PontosResource
     * @param matricula
     * @param response
     * @return an instance of modelos.Ponto
     */
    @GET
    @Path("/{matricula}")
    @Produces(MediaType.APPLICATION_XML)
    public List<Ponto> findByFuncionario(@PathParam("matricula") int matricula,
                                         @Context final HttpServletResponse response) {
        
        response.setHeader("Access-Control-Allow-Origin", "*");
        Funcionario f = funcionarioBL.findOne(matricula);
        return pontoBL.findByFuncionario(f);
        
    }
}
