package com.belhard.jstl;

import com.belhard.utils.ErrorMessage;

import javax.servlet.jsp.ErrorData;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Error extends TagSupport {

    private static  Map<Integer, ErrorMessage> errorBase;


    static {
        errorBase =  new LinkedHashMap<>();

        errorBase.put(400,new
        ErrorMessage("Bad Request:"," сервер обнаружил в запросе клиента " +
                "синтаксическую ошибку."));

        errorBase.put(401, new ErrorMessage("Unauthorized:", " для доступа к " +
                "запрашиваемому ресурсу требуется аутентификация. В заголовке ответ должен содержать поле WWW-Authenticate с перечнем условий аутентификации. Клиент может повторить запрос, включив в заголовок сообщения поле Authorization с требуемыми для аутентификации данными."));

        errorBase.put(403, new ErrorMessage("Forbidden:", " сервер понял запрос, но " +
                "он" +
                " отказывается его выполнять из-за ограничений в доступе для клиента к указанному ресурсу. Если для доступа к ресурсу требуется аутентификация средствами HTTP, то сервер вернёт ответ 401, или 407 при использовании прокси. В противном случае ограничения были заданы администратором сервера или разработчиком веб-приложения и могут быть любыми в зависимости от возможностей используемого программного обеспечения. В любом случае клиенту следует сообщить причины отказа в обработке запроса. Наиболее вероятными причинами ограничения может послужить попытка доступа к системным ресурсам веб-сервера (например, файлам .htaccess или .htpasswd) или к файлам, доступ к которым был закрыт с помощью конфигурационных файлов, требование аутентификации не средствами HTTP, например, для доступа к системе управления содержимым или разделу для зарегистрированных пользователей либо сервер не удовлетворён IP-адресом клиента, например, при блокировках."));

        errorBase.put(404, new ErrorMessage("Not Found:", " самая распространённая " +
                "ошибка при пользовании Интернетом, основная причина — ошибка в написании адреса Web-страницы. Сервер понял запрос, но не нашёл соответствующего ресурса по указанному URL. Если серверу известно, что по этому адресу был документ, то ему желательно использовать код 410. Ответ 404 может использоваться вместо 403, если требуется тщательно скрыть от посторонних глаз определённые ресурсы."));

        errorBase.put(418, new ErrorMessage("I’m a teapot:", " Этот код был введен в" +
                "1998 году как одна из традиционных первоапрельских шуток IETF в RFC 2324, Hyper Text Coffee Pot Control Protocol. Не ожидается, что данный код будет поддерживаться реальными серверами."));

        errorBase.put(405, new ErrorMessage("Method Not Allowed:", " указанный " +
                "клиентом метод нельзя применить к текущему ресурсу. В ответе сервер должен указать доступные методы в заголовке Allow, разделив их запятой. Эту ошибку сервер должен возвращать, если метод ему известен, но он не применим именно к указанному в запросе ресурсу, если же указанный метод не применим на всём сервере, то клиенту нужно вернуть код 501 (Not Implemented)."));

        errorBase.put(500, new ErrorMessage("Internal Server Error:", " любая " +
                "внутренняя ошибка сервера, которая не входит в рамки остальных ошибок класса."));

        errorBase.put(502, new ErrorMessage("Bad Gateway:", " сервер, выступая в роли" +
                " шлюза или прокси-сервера, получил недействительное ответное сообщение от вышестоящего сервера."));

        errorBase.put(521, new ErrorMessage("Web Server Is Down:", " возникает когда " +
                "подключения CDN отклоняются веб-сервером; нестандартный код CloudFlare."));
    }

    private Integer code;

    private String color;

    public void setColor(String color) {
        this.color = color;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public int doStartTag() throws JspException {
        ErrorMessage error = errorBase.get(code);
        String errorName =error.getErrorName();
        String errorDescription = error.getErrorDescription();

        try {
            JspWriter out = pageContext.getOut();

            out.write( "<div><span style=\"color: " + color + ";\""  + errorName +
                    "</span>" + errorDescription
                    +"<br><hr></div>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }
}
