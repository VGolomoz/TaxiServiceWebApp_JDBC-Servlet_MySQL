<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<nav id="navi_block">
    <div class="center">
        <div id="navmobile-btn"><fmt:message key="label.header.menu"/></div>
        <ul id="menu-main-menu" class="main_menu ">
            <li id="menu-item-45" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-45"><a
                    href="#"><fmt:message key="label.header.menu.tariff"/></a></li>
            <li id="menu-item-44" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-44"><a
                    href="#"><fmt:message key="label.header.menu.about.us"/></a></li>
            <li id="menu-item-47" class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-47"><a
                    href="#"><fmt:message key="label.header.menu.news"/></a></li>
            <li id="menu-item-431" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-431"><a
                    href="${pageContext.request.contextPath}/taxi-Kyiv/makeOrder">
                <fmt:message key="label.header.menu.for.make.order"/></a></li>
            <li id="menu-item-42" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-42"><a
                    href="#"><fmt:message key="label.header.menu.contacts"/></a></li>
        </ul>
    </div>
</nav>
