<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<html lang="${param.lang}">

<jsp:include page="../commonPartsOfPages/headTag.jsp"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-grid.css">
<body class="home blog">

<div id="wrapper">
    <header id="header">
        <jsp:include page="../commonPartsOfPages/header_white.jsp"/>

        <div class="header_blue">
            <jsp:include page="../commonPartsOfPages/navi_block.jsp"/>
        </div>

    </header>

    <div class="center">
        <div class="nazar" >
            <div class="row">
                <div class="col-lg-6">
                    <img src="${pageContext.request.contextPath}/img/clientPhoto.png" style="width: 65% ">
                </div>

                <div class="col-lg-6">
                    <strong><p class="order-text-about"><fmt:message key="show.order.dear"/> <c:out value="${sessionScope.loginedPerson.name}"/>
                        <c:out value="${sessionScope.loginedPerson.surname}"/>, <fmt:message key="show.order.your.order"/>.</p></strong>
                    <p class="order-text-about"><fmt:message key="show.order.driver"/> <c:out value="${requestScope.driverName}"/>.
                        <fmt:message key="show.order.phone.number"/> +<c:out value="${requestScope.phoneNumber}"/>.</p>
                    <p class="order-text-about"><fmt:message key="show.order.thanks"/></p>
                    <p class="order-text-about"><fmt:message key="show.order.costs"/> <c:out value="${requestScope.priceVoyage}"/> <fmt:message key="show.order.money"/></p>
                    <p class="order-text-about"><fmt:message key="show.order.wait"/> <c:out value="${requestScope.timeWait}"/> <fmt:message key="show.order.min"/></p>
                </div>
            </div>
            <div>
                <form class="dr" action="${pageContext.request.contextPath}/taxi-Kyiv/homePage">
                    <button type="submit" class="logoutDriver"><fmt:message key="show.order.home"/></button>
                </form>
            </div>
        </div>
    </div>
    </section>
</div>
<jsp:include page="../commonPartsOfPages/footer.jsp"/>
</body>
</html>