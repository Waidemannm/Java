package br.com.fiap.resource;

import br.com.fiap.bo.RemedioBO;
import br.com.fiap.to.RemedioTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/megafarma")
public class RemedioResource {
    private RemedioBO remedioBO = new RemedioBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<RemedioTO> resultado = remedioBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(); // 200 - OK
        }
        else {
            response = Response.status(404);  // 404 - NOT FOUND
        }
        response.entity(resultado);
        return response.build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{codigo}")
    public Response findByCodigo(@PathParam("codigo") Long codigo){
        RemedioTO resultado = remedioBO.findByCodigo(codigo);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(); // 200 - OK
        }
        else {
            response = Response.status(404);  // 404 - NOT FOUND
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid RemedioTO remedio) {
        RemedioTO resultado = remedioBO.save(remedio);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.created(null);  // 201 - CREATED
        } else {
            response = Response.status(400);  // 400 - BAD REQUEST
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{codigo}")
    public Response delete(@PathParam("codigo") Long codigo){
        Response.ResponseBuilder response = null;
        if(remedioBO.delete(codigo)){ //se a execução de delete for true
            response = Response.status(204); //codigo - NO CONTENT (Não tem mais o conteúdo) deletado com sucesso
        }else{ //se for false
            response = Response.status(404); // NOT FOUND (Não encontrado)
        }
        return response.build();
    }

    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid RemedioTO remedio, @PathParam("codigo") Long codigo){
        remedio.setCodigo(codigo);
        Response.ResponseBuilder response = null;
        RemedioTO resultado = remedioBO.update(remedio);
        if(resultado != null){
            response = Response.created(null); // 201 - CREATED
        } else {
            response = Response.status(400); // BAD REQUEST
        }
        return response.build();
    }
}
