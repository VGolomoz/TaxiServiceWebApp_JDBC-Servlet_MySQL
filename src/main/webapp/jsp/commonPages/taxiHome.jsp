<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<html lang="${param.lang}">
<jsp:include page="../commonPartsOfPages/headTag.jsp"/>

<body class="home blog">

<div id="wrapper">
    <header id="header">
        <jsp:include page="../commonPartsOfPages/header_white.jsp"/>
        <div class="header_blue">
            <jsp:include page="../commonPartsOfPages/navi_block.jsp"/>

            <section class="slider_home">
                <ul id="main_slider">
                    <li>
                        <img src="${pageContext.request.contextPath}/img/9.png" class="desktop-slide" width="960"
                             height="368">

                        <div class="slide_block">
                            <img src="${pageContext.request.contextPath}/img/9.png" class="mobile-slide" width="320"
                                 height="475">
                        </div>
                    </li>
                </ul>
            </section>
        </div>

    </header>
</div>

<section class="text_section">
    <div class="center text">
        <h1><fmt:message key="home.taxi.title"/></h1>
        <span><fmt:message key="home.text1"/></span>
        <h2><span><fmt:message key="home.benefit.text"/></span></h2>
        <ul>
            <li><span><fmt:message key="home.text2"/></span>
            </li>
            <li><span><fmt:message key="home.text.3"/></span>
            </li>
            <li><span><fmt:message key="home.text.4"/></span>
            </li>
        </ul>
        </div>
</section>

<jsp:include page="../commonPartsOfPages/footer.jsp"/>
</body>
</html>