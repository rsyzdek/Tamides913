package pl.tamides.tamides913

class Scripts {
    companion object {
        val logInScript = """
(function () {
    var inputFields = document.getElementsByClassName('form_input_field')
    var i
    
    for (i = 0; i < inputFields.length; i++) {
        var loginInput = inputFields[i]
        
        if (loginInput.name == "login") {
            loginInput.value = "${Cfg.login}"
            break
        }
    }
    
    for (i = 0; i < inputFields.length; i++) {
        var passwordInput = inputFields[i]
    
        if (passwordInput.name == "pass") {
            passwordInput.value = "${Cfg.password}"
            break
        }
    }
    
    var buttons = document.getElementsByClassName('btn_enter')
    
    for (i = 0; i < buttons.length; i++) {
        var logInButton = buttons[i]
    
        if (logInButton.nodeName == "INPUT") {
            logInButton.click()
        }
    }
}) ();
        """.trimIndent()
    }

    val minningScript = """
(function () {
    var wbwhites = document.getElementsByClassName('wbwhite')
    var i
    
    for (i = 0; i < wbwhites.length; i++) {
        var wbwhiteWithUnemployed = wbwhites[i].textContent

        if (wbwhiteWithUnemployed.includes("unemployed")) {
            var date = new Date()
            var year = date.getFullYear()
            var month = new Date().getMonth() + 1
            month = "0" + month
            month = month.substring(month.length - 2, month.length)
            var day = date.getDate()
            day = "0" + day
            day = day.substring(day.length - 2, day.length)
            var hour = date.getHours()
            hour = "0" + hour
            hour = hour.substring(hour.length - 2, hour.length)
            var minutes = date.getMinutes()
            minutes = "0" + minutes
            minutes = minutes.substring(minutes.length - 2, minutes.length)
        
            return year + "-" + month + "-" + day + " " + hour + ":" + minutes + ":00"
        }
    }

    var pises = document.getElementsByClassName('pi')

    for (i = 0; i < pises.length; i++) {
        var nextSibling = pises[i].nextSibling

        if (nextSibling == null) {
            continue
        }

        var piWithSince = nextSibling.data

        if (piWithSince.includes("since")) {
            var sinceText = "since "
            var time = piWithSince.substring(piWithSince.indexOf(sinceText) + sinceText.length)
            var minutesFromTime = parseInt(time.substring(time.indexOf(":") + 1))
            var minutes = parseInt(new Date().getMinutes(), 10)
            var difference = parseInt(minutes - minutesFromTime)      

            if (minutes == minutesFromTime) {
                var minutesToEnroll = 61
                var date = new Date(new Date().getTime() + minutesToEnroll * 60000)
                var year = date.getFullYear()
                var month = new Date().getMonth() + 1
                month = "0" + month
                month = month.substring(month.length - 2, month.length)
                var day = date.getDate()
                day = "0" + day
                day = day.substring(day.length - 2, day.length)
                var hour = date.getHours()
                hour = "0" + hour
                hour = hour.substring(hour.length - 2, hour.length)
                var minutes = date.getMinutes()
                minutes = "0" + minutes
                minutes = minutes.substring(minutes.length - 2, minutes.length)
        
                return year + "-" + month + "-" + day + " " + hour + ":" + minutes + ":00"
            }
            
            if (difference > 0) {
                var minutesToEnroll = 60 - minutes + minutesFromTime + 1
                var date = new Date(new Date().getTime() + minutesToEnroll * 60000)
                var year = date.getFullYear()
                var month = new Date().getMonth() + 1
                month = "0" + month
                month = month.substring(month.length - 2, month.length)
                var day = date.getDate()
                day = "0" + day
                day = day.substring(day.length - 2, day.length)
                var hour = date.getHours()
                hour = "0" + hour
                hour = hour.substring(hour.length - 2, hour.length)
                var minutes = date.getMinutes()
                minutes = "0" + minutes
                minutes = minutes.substring(minutes.length - 2, minutes.length)
        
                return year + "-" + month + "-" + day + " " + hour + ":" + minutes + ":00"
            }

            if (difference < 0) {
                var minutesToEnroll = minutesFromTime - minutes + 1
                var date = new Date(new Date().getTime() + minutesToEnroll * 60000)
                var year = date.getFullYear()
                var month = new Date().getMonth() + 1
                month = "0" + month
                month = month.substring(month.length - 2, month.length)
                var day = date.getDate()
                day = "0" + day
                day = day.substring(day.length - 2, day.length)
                var hour = date.getHours()
                hour = "0" + hour
                hour = hour.substring(hour.length - 2, hour.length)
                var minutes = date.getMinutes()
                minutes = "0" + minutes
                minutes = minutes.substring(minutes.length - 2, minutes.length)
        
                return year + "-" + month + "-" + day + " " + hour + ":" + minutes + ":00"
            }
        }
    }

    for (i = 0; i < pises.length; i++) {
        var nextSibling = pises[i].nextSibling

        if (nextSibling == null) {
            continue
        }

        var piWithAgain = nextSibling.data

        if (piWithAgain.includes("again")) {
            var inText = " in "
            var minutesToEnroll = parseInt(piWithAgain.substring(piWithAgain.indexOf(inText) + inText.length, piWithAgain.indexOf(" min.")), 10) + 1
            var date = new Date(new Date().getTime() + minutesToEnroll * 60000)
            var year = date.getFullYear()
            var month = new Date().getMonth() + 1
            month = "0" + month
            month = month.substring(month.length - 2, month.length)
            var day = date.getDate()
            day = "0" + day
            day = day.substring(day.length - 2, day.length)
            var hour = date.getHours()
            hour = "0" + hour
            hour = hour.substring(hour.length - 2, hour.length)
            var minutes = date.getMinutes()
            minutes = "0" + minutes
            minutes = minutes.substring(minutes.length - 2, minutes.length)
        
            return year + "-" + month + "-" + day + " " + hour + ":" + minutes + ":00"
        }
    }

    var date = new Date()
    var year = date.getFullYear()
    var month = new Date().getMonth() + 1
    month = "0" + month
    month = month.substring(month.length - 2, month.length)
    var day = date.getDate()
    day = "0" + day
    day = day.substring(day.length - 2, day.length)
    var hour = date.getHours()
    hour = "0" + hour
    hour = hour.substring(hour.length - 2, hour.length)
    var minutes = date.getMinutes()
    minutes = "0" + minutes
    minutes = minutes.substring(minutes.length - 2, minutes.length)
        
    return year + "-" + month + "-" + day + " " + hour + ":" + minutes + ":00"
}) ();
    """.trimIndent()
}