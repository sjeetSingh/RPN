package com.rpn.service;

import com.rpn.input.InputParser;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

// The Java class will be hosted at the URI path "/helloworld"
@Path("/helloworld")
public class RPNCalculateAPIService {

    private RPNCalculate rpnCalculate = new RPNCalculate();

    @GET
    @Produces("text/plain")
    public String getClichedMessage() {
        return "Welcome to RPN world!";
    }

    @POST
    @Consumes("text/plain")
    @Path("/exp/{expreesion}")
    public Response checkString(@PathParam("expreesion") String expression){

        return Response.ok("opk", MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("/expr")
    @Consumes(MediaType.APPLICATION_JSON)
    public String acceptInput( InputParser inputExpression){

        // Sanity goes here.

        String[] expressionArr = inputExpression.getInputExpression().split(",");
        StringBuilder temp = new StringBuilder();
        for(String item :expressionArr){
            temp.append(item+" ");
        }
        String ret = rpnCalculate.calculate(expressionArr);
        return ret;
    }

}