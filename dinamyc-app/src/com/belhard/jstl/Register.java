package com.belhard.jstl;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

public class Register extends BodyTagSupport{
    private String register;


    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

//    @Override
//    public int doStartTag() throws JspException {
//        return EVAL_BODY_INCLUDE;
//    }

//    @Override
//    public void doInitBody() throws JspException {
////        BodyContent content = this.bodyContent;
////        String body = content.getString();
////        JspWriter out = pageContext.getOut();
////        try{
////
////
////        switch (register) {
////            case "up":{
////                body = body.toUpperCase();
////                out.write(body);
////                break;
////            }
////            case "low":{
////                body = body.toLowerCase();
////                out.write(body);
////                break;
////            } default:{
////                out.write(body);
////            }
////        }
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//    }

    @Override
    public int doAfterBody() throws JspException {
        BodyContent content = getBodyContent();
        String body = content.getString();
        JspWriter out = content.getEnclosingWriter();
        try{
            switch (register) {
                case "up":{
                    body = body.toUpperCase();
                    out.write(body);
                    break;
                }
                case "low":{
                    body = body.toLowerCase();
                    out.write(body);
                    break;
                } default:{
                    out.write(body);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }

}
