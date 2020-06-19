package pl.tamides.tamides913

class Scripts {
    companion object {
        val logInScript = """
(function () {
    var login = "${Cfg.login}";
    var password = "${Cfg.password}";
    var inputFields = document.getElementsByClassName('form_input_field');
    var i;
    
    for (i = 0; i < inputFields.length; i++) {
        if (inputFields[i].name == "login") {
            break;
        }
    }
    
    var loginInput = inputFields[i];
    
    for (i = 0; i < inputFields.length; i++) {
        if (inputFields[i].name == "pass") {
            break;
        }
    }
    
    var passwordInput = inputFields[i];
    
    loginInput.value = login;
    passwordInput.value = password;
    
    var buttons = document.getElementsByClassName('btn_enter');
    
    for (i = 0; i < buttons.length; i++) {
        if (buttons[i].nodeName == "INPUT") {
            break;
        }
    }
    
    var logInButton = buttons[i]
    logInButton.click();
}) ();
        """.trimIndent()
    }
}