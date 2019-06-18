<#macro register path>

    <form id="registrationForm" action="${path}" method="post">
        <div id="postResultDiv" style="padding:20px 10px 20px 50px"></div>
        <div><label> Login :
            <input type="text" name="username" id="username" placeholder="Input your Login"
                   pattern="[A-Za-z ]{1,14}" required/>
        </label></div>
        <div><label> Password:
            <input type="password" id="new-password" name="new-password" placeholder="Input your Password"
                   <#--pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$"--> required/>
        </label></div>
        <div><label> Password Confirmation:
            <input type="password" id="new-password2" name="new-password2" placeholder="Confirm your Password"
                  <#-- pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$"--> required/>
        </label></div>
        <div><label> Email:
            <input type="text" id="emailId" name="email" placeholder="Input your Email"
                   pattern="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?"
                   required/>
        </label></div>

        <input type="hidden" name="${_csrf.parameterName}" id="csrf" value="${_csrf.token}"/>

        <div><input type="submit" class="button" id="registerButton" value="Register"/></div>
    </form>
<script>
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    /*    $(document).ajaxSend(function(e, xhr, options) {
            xhr.setRequestHeader(header, token);
        });*/

    $(document).ready(function () {


        /*        $(document).ajaxSend(function(e, xhr, options) {
                    xhr.setRequestHeader(header, token);
                });*/
        /*
                var username = $("#username").val();
                var password = $("#new-password").val();
                var password2 = $("#new-password2").val();
                var email = $("#email").val();*/

        // SUBMIT FORM
        $("#registrationForm").submit(function (event) {
            // Prevent the form from submitting via the browser.
            event.preventDefault();
            ajaxPost();

        });


        function ajaxPost() {

            var username = $("#username").val();
            var password = $("#new-password").val();
            var password2 = $("#new-password2").val();
            var email = $("#emailId").val();
            if (username == "") {
                $('#messageDiv').css("display", "none");
                alert("Please, input your username!");
                username.focus()
                return;
            }
            if (password == "") {
                $('#messageDiv').css("display", "none");
                alert("Please, input password!");
                return;
            }
            if (password != password2) {
                $('#messageDiv').css("display", "none");
                alert("Please, check password confirmation!");
                return;
            }
            if (email == "") {
                $('#messageDiv').css("display", "none");
                alert("Please, input your email!");
                return;
            }
            // PREPARE FORM DATA
            var formData = {
                username: $("#username").val(),
                password: $("#new-password").val(),
                password2: $("#new-password2").val(),
                // _csrf: $("#csrf").val(),
                email: $("#emailId").val()
            }

            // DO POST
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: /*window.location +*/ "/api/user",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader(header, token);
                },
                data: JSON.stringify(formData),
                dataType: 'json',
                success: function (result) {
                    if (result.status === "200") {
                        alert("registered!")
                        window.location = '/user/main';
                        /*$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" +
                                "Post Successfully! <br>" +
                                "---> Customer's Info: FirstName = " +
                                result.data.firstname + " ,LastName = " + result.data.lastname + "</p>");*/
                    } else {
                        /*$("#postResultDiv").html("<strong>Error</strong>");*/
                        alert("Fuuuuuuck!!!")
                    }
                    console.log(result);
                },
                error: function (e) {
                    alert("Error!")
                    console.log("ERROR: ", e);
                }
            });

            // Reset FormData after Posting
            resetData();
        }

        function resetData() {
            $("#username").val("");
            $("#new-password").val("");
            $("#new-password2").val("");
            $("#emailId").val("");
        }
    })
</script>
</#macro>


