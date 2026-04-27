<form action="${editora != null ? 'atualizacao' : 'insercao'}" method="post">

    <input type="hidden" name="id" value="${editora.id}"/>

    Nome: <input name="nome" value="${editora.nome}" /><br>
    CNPJ: <input name="cnpj" value="${editora.CNPJ}" /><br>

    <button type="submit">Salvar</button>

</form>