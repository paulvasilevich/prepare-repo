<%--
  Created by IntelliJ IDEA.
  User: white
  Date: 05.09.17
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ownTag" uri="WEB-INF/tags/implicit.tld" %>
<html>
<head>
    <title>own tags testing</title>
</head>
<body>
<ownTag:dtFmt format="MM-dd-yyyy"/>
<p>format yes</p>
<ownTag:dtFmt format="" />
<p>format no</p>
<c:url value="index.html" var="newUrl" />
<a href='<c:out value="${ newUrl }"/>'>go</a>

<ownTag:repeat countInt="5"> Text on repeat! </ownTag:repeat>
<ownTag:bodyRgstr register="up"> Text to upper case. </ownTag:bodyRgstr>
<ownTag:bodyRgstr register="low" > Text to LOWER CASE.  </ownTag:bodyRgstr>
<ownTag:bodyRgstr register=""> Text With default CASE.  </ownTag:bodyRgstr>
<br/>
<hr>
<ownTag:error code="401" color="red"/>
<ownTag:error code="400" color="green"/>
<ownTag:error code="403" color="blue"/>
<ownTag:error code="404" color="red"/>
<ownTag:error code="405" color="red"/>
<ownTag:error code="418" color="red"/>
<ownTag:error code="500" color="red"/>
<ownTag:error code="502" color="red"/>

<jsp:element name="colorText">
    <jsp:attribute name="style">
     "color: #453675;"
    </jsp:attribute>
    <jsp:body>
        Simple text For example. OoooUuuu!! His PURPLE!! omfg) He look's very pretty!))
    </jsp:body>

</jsp:element>
</body>
</html>
