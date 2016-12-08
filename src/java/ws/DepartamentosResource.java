/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import business.DepartamentoBL;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelos.Departamento;

/**
 * REST Web Service
 *
 * @author demetrius
 */
@Path("departamentos")
public class DepartamentosResource {

    @Context
    private UriInfo context;

    @EJB
    DepartamentoBL departamentoBL;

    /**
     * Creates a new instance of DepartamentosResource
     */
    public DepartamentosResource() {
        
    }

    /**
     * Retrieves representation of an instance of ws.DepartamentosResource
     *
     * @param response
     * @return an instance of modelos.Departamento
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Departamento> findAll(@Context final HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return departamentoBL.findAll();
    }

    /**
     *
     * @param id
     * @param response
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Departamento findOne(@PathParam("id") Long id, @Context final HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return departamentoBL.findOne(id);
    }

    /**
     *
     * @param departamento
     * @param response
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.TEXT_PLAIN)
    public String insert(Departamento departamento, @Context final HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        departamentoBL.insert(departamento);
        return "OK";
    }

    /**
     * PUT method for updating or creating an instance of DepartamentosResource
     *
     * @param content representation for the resource
     * @return
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.TEXT_PLAIN)
    public String update(Departamento content) {
        departamentoBL.update(content);
        return "OK";
    }

    /**
     *
     * @param id
     * @return
     */
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Departamento delete(@PathParam("id") Long id){
        Departamento d = departamentoBL.findOne(id);
        departamentoBL.delete(d);
        return d;
    }
}
