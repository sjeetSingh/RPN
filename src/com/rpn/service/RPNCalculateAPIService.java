package com.rpn.service;

import com.rpn.input.RPNExpression;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

// The Java class will be hosted at the URI path "/helloworld"
@Path("/rpncalculator")
public class RPNCalculateAPIService {

    private static final String INVALID_EXPRESSION_EMPTY = "Expression is empty!";

    private RPNCalculateService rpnCalculateService = new RPNCalculateService();

    @GET
    @Produces("text/plain")
    public String getClichedMessage() {
        return "Welcome to RPN world!";
    }

    @POST
    @Path("/rpn")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response evaluateRPNExpression(RPNExpression inputRPNExpressionString){

        if( inputRPNExpressionString.getInputExpression()==null || inputRPNExpressionString.getInputExpression().length()==0){
            return Response.status(400).entity(INVALID_EXPRESSION_EMPTY).build();
        }
        String[] expressionArr = inputRPNExpressionString.getInputExpression().split(",");

        return rpnCalculateService.performRPNCalculate(expressionArr);
    }

}