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
        </div>
    </header>


    <div class="center">
        <div class="nazar">

            <div class="ordersHeader">
                <p><fmt:message key="showOrders.orders.title"/></p>
            </div>
            <div class="viewData">
                <div class="idOrder">
                    <p><fmt:message key="showOrders.orders.id"/></p>
                </div>
                <div class="nameClient">
                    <p><fmt:message key="showOrders.client"/></p>
                </div>
                <div class="street">
                    <p><fmt:message key="showOrders.street.dep"/></p>
                </div>
                <div class="street">
                    <p><fmt:message key="showOrders.street.arr"/></p>
                </div>
                <div class="costVoage">
                    <p><fmt:message key="showOrders.price"/></p>
                </div>
            </div>
           <c:forEach items="${requestScope.orderList}" var="order" begin="0" end="${requestScope.recordPerPage -1}">
                <div class="viewData data">
                    <div class="idOrder">
                        <p><c:out value="${order.idOrder}"/></p>
                    </div>
                    <div class="nameClient">
                        <p><c:out value="${order.client.name}"/> <c:out value="${order.client.surname}"/></p>
                    </div>
                    <div class="street">
                        <p><c:out value="${order.addressArrive.street}"/> <c:out
                                value="${order.addressArrive.houseNumber}"/></p>
                    </div>
                    <div class="street">
                        <p><c:out value="${order.addressDeparture.street}"/> <c:out
                                value="${order.addressDeparture.houseNumber}"/></p>
                    </div>
                    <div class="costVoage">
                        <p><c:out value="${order.costWithDiscount}"/></p>
                    </div>
                </div>

            </c:forEach>
        </div>
            <nav aria-label="...">
                <ul class="pagination pagination-sm justify-content-center">
                    <c:forEach var="pagNumber" begin = "1" end = "${requestScope.pageNumbers}">
                     <li class="page-item">
                         <a class="page-link" href="${pageContext.request.contextPath}/taxi-Kyiv/showAllOrders?pagination=${pagNumber}"><c:out value = "${pagNumber}"/></a>
                     </li>
                    </c:forEach>
                </ul>
            </nav>
    </div>
</div>
<jsp:include page="../commonPartsOfPages/footer.jsp"/>
</body>
</html>