<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Editoras</h1>

<a href="editoras/cadastro">Nova Editora</a>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>CNPJ</th>
        <th>Ações</th>
    </tr>

    <c:forEach var="e" items="${listaEditoras}">
        <tr>
            <td>${e.id}</td>
            <td>${e.nome}</td>
            <td>${e.CNPJ}</td>

            <td>
                <a href="editoras/edicao?id=${e.id}">Editar</a>
                <a href="editoras/remocao?id=${e.id}">Excluir</a>
            </td>
        </tr>
    </c:forEach>

</table>