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
        <div class="register">
            <form method="POST" action="${pageContext.request.contextPath}/taxi-Kyiv/enterLogin">
                <div class="container">

                    <h1><fmt:message key="login.sign.up"/></h1>
                    <p><fmt:message key="login.fill.form"/></p>
                    <hr>
                    <c:if test="${param.wrongData == true}">
                        <p class="errorsM"><fmt:message key="login.incorrect.input"/></p>
                    </c:if>
                    <label><b><fmt:message key="login.title.phone"/></b></label>
                    <input type="text" placeholder="<fmt:message key="login.phoneNumber"/>" name="phoneNumber" required>
                    <label><b><fmt:message key="login.title.password"/></b></label>
                    <input type="password" placeholder="<fmt:message key="login.password"/>" name="password" required>
                    <hr>
                    <button type="submit" class="registerbtn"><fmt:message key="login.submit.btn"/></button>
                </div>

                <div class="container signup">
                    <p><fmt:message key="login.have.not.acc"/> <a href="${pageContext.request.contextPath}/taxi-Kyiv/registerClient">
                        <fmt:message key="login.sign.up"/></a>.</p>
                </div>
                <div style="height: 60px"></div>
            </form>
        </div>

    </div>
    </section>

</div>
<jsp:include page="../commonPartsOfPages/footer.jsp"/>
</body>
</html>