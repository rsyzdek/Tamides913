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
            break;
        }
    }
    
    for (i = 0; i < inputFields.length; i++) {
        var passwordInput = inputFields[i];
    
        if (passwordInput.name == "pass") {
            break;
        }
    }
    
    loginInput.value = "${Cfg.login}";
    passwordInput.value = "${Cfg.password}";
    
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