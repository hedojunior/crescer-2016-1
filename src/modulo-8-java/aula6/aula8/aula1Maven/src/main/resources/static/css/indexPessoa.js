'use strict';
$(document).ready(function () {

    $('button[name = "btnExcluir"]').click(function () {
        var self = $(this);
        var id = parseInt(self.val());

        var values = {id: id};
        $.ajax({
            url: '/rest/pessoa/delete',
            type: 'POST',
            data: values
        }).done(function () {
            $('#tablePessoas button[value = "' + id + '"]').closest('tr').remove();
        });
    });
    
    $('button[name = "btnEditar"').click(function(){
       var self = $(this);
       var nome = self.closest('tr').find('td[name = "tdNome"]').text();
       var dataNasc = self.closest('tr').find('td[name = "tdDataNasc"]').text();
       var id = parseInt(self.val());
       
       $('#inputNome').val(nome);
       $('#inputDataNasc').val(dataNasc);
       $('#inputId').val(id);
    });
});


