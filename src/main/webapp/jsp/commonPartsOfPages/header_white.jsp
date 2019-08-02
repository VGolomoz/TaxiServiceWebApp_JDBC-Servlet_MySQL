<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<div class="header_white clearfix">
    <div class="center">
        <a href="${pageContext.request.contextPath}/taxi-Kyiv/homePage" id="logo" title="Taxi Kyiv">
            <img src="${pageContext.request.contextPath}/img/taxi_logo.png" width="85px" height="57">
        </a>
        <div style="float: right; width: 420px">
            <div class="signClient">
                <p style="float: left;padding-top: 7px; color: #009EDF"><c:out
                        value="${sessionScope.loginedPerson.name}"/>
                    <c:out value="${sessionScope.loginedPerson.surname}"/></p>

                <a href="${pageContext.request.contextPath}/taxi-Kyiv/login">
                    <div style="margin: auto; float: right; height: 36px;">
                        <img src="${pageContext.request.contextPath}/img/iconenter.png" style="height: 36px">
                    </div>
                </a>
            </div>

            <div class="header_city">
                <div class="city_current"><fmt:message key="label.current.city"/></div>
            </div>

            <div class="lang_block">
                <ul id="lang">
                    <li class="lang-item lang-item-2">
                        <a href="?locale=ua">ua</a>
                    </li>
                    <li class="lang-item lang-item-5">
                        <a href="?locale=en">en</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>