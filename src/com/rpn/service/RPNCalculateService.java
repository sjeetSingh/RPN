package com.rpn.service;

import javax.ws.rs.core.Response;
import java.util.Stack;

public class RPNCalculateService {

    private static final String INVALID_EXPRESSION_EXTRA_OPERAND = "Extra Operand!";

    Stack<Integer> operandStack = new Stack<>();

    public Response performRPNCalculate(String[] exp){
        for( int i=0; i<exp.length; i++ ){

            if(exp[i].equals("+")){
                if(!operandStack.isEmpty()){
                    operandStack.add(operandStack.pop()+ operandStack.pop());
                }
            }
            else if(exp[i].equals("-")){
                if(!operandStack.isEmpty()){
                    int first = operandStack.pop();
                    int second = operandStack.pop();
                    operandStack.add(second-first);
                }
            }
            else if(exp[i].equals("/")){
                if(!operandStack.isEmpty()){
                    int first = operandStack.pop();
                    int second = operandStack.pop();
                    operandStack.add(second/first);
                }
            }
            else if(exp[i].equals("*")){
                if(!operandStack.isEmpty()){
                    int first = operandStack.pop();
                    int second = operandStack.pop();
                    operandStack.add(second*first);
                }
            }
            else{
                operandStack.add(Integer.parseInt(exp[i]));
            }
        }
        return operandStack.size()==1 ? Response.status(200).entity(operandStack.peek().toString()).build() :
                Response.status(400).entity(INVALID_EXPRESSION_EXTRA_OPERAND).build();
    }
}