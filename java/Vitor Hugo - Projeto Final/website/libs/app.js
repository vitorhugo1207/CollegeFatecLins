$(document).ready(function(){});
                  
function makeRequest(url, dados, type) {
    escreverLoadAction();
    $.ajax({
        type: type,
        url: url,
        data: dados,
        contentType: 'application/json',
        success: function () {
            mensage();
        },
        complete: function () {
            removerLoadAction();
        }
    });
}

function formatForm(form) {
    $.each(form, function (i, field) {
        if (i == 0) {
            dados = "{";
        }

        dados = dados + `"${field.name}":"${field.value}"`;

        if (i == 6) {
            dados = dados + "}";
        } else {
            dados = dados + ",";
        }
	});
    dados = JSON.parse(dados);
    
    return dados;
}

function exibirMensagem(msg) {
    $("#msgResp").html(msg);
    $("#dialog").dialog();
    setTimeout(function () {
        $("#dialog").dialog('close')
    }, '5000');
}

function mensage() {
    exibirMensagem("Operação realizada com sucesso!")
}

function escreverLoadAction() {
    $("#dialogAguarde").dialog({
        modal: true,
    });
}

function removerLoadAction() {
    $("#dialogAguarde").dialog('close');
}