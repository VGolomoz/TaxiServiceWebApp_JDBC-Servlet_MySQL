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

                <div class="row">
                    <div class="col-lg-12">
                        <form class="dr" action="${pageContext.request.contextPath}/taxi-Kyiv/logOut">
                            <button type="submit" class="account-driver-btns"><fmt:message key="driver.account.logout"/></button>
                        </form>
                        <a href="${pageContext.request.contextPath}/taxi-Kyiv/showAllOrders?pagination=1">
                            <button class="account-driver-btns"><fmt:message key="driver.account.show.pag"/></button>
                        </a>
                    </div>
                    <div class="col-lg-12">
                        <c:if test="${param.wrongInput == true}">
                            <p class="errorsM bad-order-input"><fmt:message key="driver.account.mess.error"/></p>
                        </c:if>

                        <c:if test="${param.noSuchOrder == true}">
                            <p class="errorsM bad-order-input"><fmt:message key="driver.account.mess.error.2"/></p>
                        </c:if>

                        <c:if test="${sessionScope.loginedPerson.driverStatus.toString() == 'BOOKED'}">
                        <form class="make-order" action="${pageContext.request.contextPath}/taxi-Kyiv/enterNumOrder"
                              method="POST">
                            <button type="submit" class="account-driver-btns"><fmt:message key="driver.account.order"/></button>
                            <input type="text" name="executeOrder" class="text-order" placeholder="<fmt:message key="driver.account.enter"/>" />
                        </form>
                        </c:if>
                    </div>
                </div>
            </div>

            <div class="col-lg-6">
                <ul>
                    <li>
                       <strong>
                           <p><c:out value="${sessionScope.loginedPerson.name}"/>
                               <c:out value="${sessionScope.loginedPerson.surname}"/></p>
                       </strong>
                    </li>

                    <li class="liFont">
                        <p><fmt:message key="driver.phone"/>: <c:out value="${sessionScope.loginedPerson.phoneNumber}"/></p>
                    </li>

                    <li class="liFont">
                        <p><fmt:message key="driver.auto"/>: <c:out value="${sessionScope.loginedPerson.car.carType}"/></p>
                    </li>

                    <li class="liFont">
                        <p><fmt:message key="driver.status"/>: <c:out value="${sessionScope.loginedPerson.driverStatus}"/></p>
                    </li>
                </ul>
            </div>
            </div>
        </div>
    </div>
    </section>
</div>
<jsp:include page="../commonPartsOfPages/footer.jsp"/>
</body>
</html>