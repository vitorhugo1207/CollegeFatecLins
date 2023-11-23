urlProdutos = "http://localhost:8080/produtos";

// load and display produtos
$(document).ready(function () {
	$.get(urlProdutos, function (json, status) {
		var html = '<div class="row">';
		html += '<div class="col s6 l3">Nome</div>';
		html += '<div class="col s6 l3">Descrição</div>';
		html += '<div class="col s6 l2">Valor</div>';
		html += '<div class="col s6 l2">Estoque</div>';
		html += '<div class="col s6 l1">Editar</div>';
		html += '<div class="col s6 l1">Deletar</div>';
		html += '</div>';
		for (var i = 0; i < json.length; i++) {
			html += '<div class="row">';
			html += '<div class="col s6 l3">' + json[i].nome + '</div>';
			html += '<div class="col s6 l3">' + json[i].descricao + '</div>';
			html += '<div class="col s6 l2">' + json[i].valor + '</div>';
			html += '<div class="col s6 l2">' + json[i].qtdeEstoque + '</div>';
			html += '<div class="col s6 l1">';
			html +=
				'<i class="Small material-icons clique blue-text text-darken-2 cursorPointer selectNone" onclick="editarProduto(\'' +
				json[i].id +
				'\')">edit</i>';
			html += '</div>';
			html += '<div class="col s6 l1">';
			html +=
				'<i class="Small material-icons clique red-text text-darken-3 cursorPointer selectNone" onclick="excluirProduto(\'' +
				json[i].id +
				'\')">delete_forever</i>';
			html += '</div>';
			html += '</div>';
		}
		$('#listaProdutos').html(html);
	});
});

function editarProduto(idProduto) {
    let urlProdutosPut = urlProdutos + "/" + idProduto;
    
    $.get(urlProdutosPut, function (json, status) {
		$('#id').val(json.id);
		$('#nome').val(json.nome);
        $('#descricao').val(json.descricao);
        $('#valor').val(json.valor);
        $('#qtdeEstoque').val(json.qtdeEstoque);
        $('#estoqueMinimo').val(json.estoqueMinimo);
        $('#imagem').val(json.imagem);
    });
}

function excluirProduto(idProduto) {
	urlProdutosDelete = urlProdutos + "/" + idProduto;

	makeRequest(urlProdutosDelete, null, "DELETE");

	location.reload();
}

function saveProduto() {
	let dados = {};
    let form = $('form').serializeArray();
	
	dados = formatForm(form) // Convert value revice from form to format accept by the server
    
	// Make Requests
	if (dados.id) {
		urlProdutosPut = urlProdutos + "/" + dados.id;
		
		dados = JSON.stringify(dados);
		
		makeRequest(urlProdutosPut, dados, "PUT");
		location.reload();
	}
    else {
		dados = JSON.stringify(dados);
		
		makeRequest(urlProdutos, dados, "POST");
		location.reload();
    }
}
