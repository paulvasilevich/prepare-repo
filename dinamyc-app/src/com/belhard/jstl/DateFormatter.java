package com.belhard.jstl;

import javax.ejb.Local;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateFormatter extends TagSupport{

    private String format;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public int doStartTag() throws JspException {

        try {
//            if (format.equals("")){
//                pageContext.getOut().println("Today: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
//            } else  if (format.equals("MM-dd-yyyy")){
//                pageContext.getOut().println("Today: " + LocalDate.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
//            } else  if (format.equals("yyyy-MM-dd")){
//                pageContext.getOut().println("Today: " + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//            }else  if (format.equals("yyyy-dd-MM")){
//                pageContext.getOut().println("Today: " + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-dd-MM")));
//            }
            switch (format) {
                case "MM-dd-yyyy": {
                    pageContext.getOut().println("Today: " + LocalDate.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
                    break;
                }
                case "yyyy-MM-dd": {
                    pageContext.getOut().println("Today: " + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                    break;
                }
                case "yyyy-dd-MM": {
                    pageContext.getOut().println("Today: " + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-dd-MM")));
                    break;
                }
                default:{
                    pageContext.getOut().println("Today: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                    break;
                }
            }

            } catch (IOException e) {
            throw new JspException("Error: " + e.getMessage());
        }

        return SKIP_BODY;
    }




}
