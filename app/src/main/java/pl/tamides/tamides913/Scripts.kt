package pl.tamides.tamides913

class Scripts {
    companion object {
        val logInScript = """
(function () {
    var inputFields = document.getElementsByClassName('form_input_field');
    var i;
    
    for (i = 0; i < inputFields.length; i++) {
        var loginInput = inputFields[i];
        
        if (loginInput.name == "login") {
            loginInput.value = "${Cfg.login}";
            break;
        }
    }
    
    for (i = 0; i < inputFields.length; i++) {
        var passwordInput = inputFields[i];
    
        if (passwordInput.name == "pass") {
            passwordInput.value = "${Cfg.password}";
            break;
        }
    }
    
    var buttons = document.getElementsByClassName('btn_enter');
    
    for (i = 0; i < buttons.length; i++) {
        var logInButton = buttons[i]
    
        if (logInButton.nodeName == "INPUT") {
            logInButton.click();
        }
    }
}) ();
        """.trimIndent()
    }
}