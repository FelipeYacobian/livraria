<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="pt_BR"/>

<table border="1">
    <c:forEach var="l" items="${listaLivros}">
        <tr>
            <td>${l.titulo}</td>
            <td>${l.autor}</td>
            <td>
                R$ <fmt:formatNumber value="${l.preco}" minFractionDigits="2"/>
            </td>
        </tr>
    </c:forEach>
</table>