package com.rpn.service;

import java.util.Stack;

public class RPNCalculate {

    Stack<Integer> stack = new Stack<>();

    public String calculate(String[] exp){
        for( int i=0; i<exp.length; i++ ){

            if(exp[i].equals("+")){
                if(!stack.isEmpty()){
                    stack.add(stack.pop()+stack.pop());
                }
            }
            else if(exp[i].equals("-")){
                if(!stack.isEmpty()){
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.add(second-first);
                }
            }
            else if(exp[i].equals("/")){
                if(!stack.isEmpty()){
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.add(second/first);
                }
            }
            else if(exp[i].equals("*")){
                if(!stack.isEmpty()){
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.add(second*first);
                }
            }
            else{
                stack.add(Integer.parseInt(exp[i]));
            }
        }
        return stack.size()==1 ? stack.peek().toString() : "Invalid expression! Please check!";
    }
}