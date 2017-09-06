package com.belhard.jstl;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

public class CountPrinter extends BodyTagSupport {

    private int iter;

    private int countInt;

    public void setCountInt(int countInt) {
        this.countInt = countInt;
    }

    @Override
    public int doStartTag() throws JspException {
        iter = 0;
        if (countInt <= 0) {
            return SKIP_BODY;
        }
        iter++;
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doAfterBody() throws JspException {
        try {
        while (iter < countInt) {
            iter++;
            pageContext.getOut().write("<hr><br>");

            return EVAL_BODY_AGAIN;
        }
            pageContext.getOut().write("<hr><br>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
