$.validator.methods.number = function (value, element) {
    var regex = /^(\d*)(\,\d{1,2})?$/; //99999,99
    return this.optional(element) || regex.test(value);
}

$.validator.methods.date = function (value, element) {
    var date = new Date(value.replace(/(\d{2})[/](\d{2})[/](\d{4})/, "$2/$1/$3")); //31/12/2015
    return this.optional(element) || !/Invalid|NaN/.test(date.toString());
}

$("#formCheckPassword").validate({
    rules: {
        senha: {
            required: true,
            minlength: 8,
            maxlength: 30

        },

        cfmSenha: {
            equalTo: "#senha",
            minlength: 8,
            maxlength: 30
        }


    },
    messages: {
        senha: {
            required: "A senha é obrigatória",
            minlength: "O tamanho mínimo da senha é de 8 caracteres",
            maxlength: "O tamanho máximo da senha é de 30 caracteres"
        },
        cfmSenha: {
            equalTo: "Não são iguais"
        }
    }

});
