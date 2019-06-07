
$( document ).ready(function() {

var username = $("#username").val();
var password = $("#new-password").val();
var password2 = $("#new-password2").val();
var email = $("#email").val();

    // SUBMIT FORM
    $("#registrationForm").submit(function(event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        ajaxPost();
    });


    function ajaxPost(){

        // PREPARE FORM DATA
        var formData = {
            username : username,
            password :  password,
            password2 : password2,
            email: email
        }

        // DO POST
        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : /*window.location +*/ "/api/user",
            data : JSON.stringify(formData),
            dataType : 'json',
            success : function(result) {
                if(result.status == "200"){
                    $("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" +
                        "Post Successfully! <br>" +
                        "---> Customer's Info: FirstName = " +
                        result.data.firstname + " ,LastName = " + result.data.lastname + "</p>");
                }else{
                    $("#postResultDiv").html("<strong>Error</strong>");
                }
                console.log(result);
            },
            error : function(e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });

        // Reset FormData after Posting
        resetData();
    }

    function resetData(){
        $("#username").val("");
        $("#password").val("");
        $("#email").val("");
    }

    function validate() {
        if (document.f.username.value == "" && document.f.password.value == "") {
            alert("Username and password are required");
            document.f.username.focus();
            return false;
        }
        if (document.f.username.value == "") {
            alert("Username is required");
            document.f.username.focus();
            return false;
        }
        if (document.f.password.value == "") {
            alert("Password is required");
            document.f.password.focus();
            return false;
        }
    }

})


window.onload = function() {
    if (window.jQuery) {
        showMessage("Success");
        $('#postResultDiv').css("display", "block");
    } else {
        // jQuery is not loaded
        alert("Doesn't Work");
    }
}




/*
$( document ).ready(function() {
    // GET REQUEST
    $("#loginButton").click(function(event){
        event.preventDefault();
        ajaxGet();
    });

    // DO GET
    function ajaxGet(){
        $.ajax({
            type : "GET",
            url : /!*window.location +*!/ "api/user",
            success: function(result){
                if(result.status == "Done"){
                    $('#getResultDiv ul').empty();
                    var custList = "";
                    $.each(result.data, function(i, customer){
                        var customer = "- Customer with Id = " + i + ", firstname = " + customer.firstname + ", lastName = " + customer.lastname + "<br>";
                        $('#getResultDiv .list-group').append(customer)
                    });
                    console.log("Success: ", result);
                }else{
                    $("#getResultDiv").html("<strong>Error</strong>");
                    console.log("Fail: ", result);
                }
            },
            error : function(e) {
                $("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        });
    }
})
*/

