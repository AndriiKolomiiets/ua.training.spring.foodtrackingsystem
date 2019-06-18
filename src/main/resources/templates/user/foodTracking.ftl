<#import '../parts/common.ftl' as c>
<#import "../parts/login.ftl" as l>
<#import '../parts/footer.ftl' as f>
<#import '../parts/header.ftl' as h>
<@c.page>

<div>Meal Tracking</div>
<br>
    <@h.menu/>
<fieldset id="mealForm">
    <legend>Choose the meal and number of dishes!</legend>
<#--    <form id="registrationForm" &lt;#&ndash;action="${path}" method="post"&ndash;&gt;>
        <div id="postResultDiv" style="padding:20px 10px 20px 50px"></div>
        <div><label> Food name :
            <input type="text" name="username" id="username" placeholder="Input your Login"
                   pattern="[A-Za-z ]{1,14}" required/>
        </label></div>

        <label for="food-select">Choose food:</label>

        <select id="food-select">
            <option value="">--Please choose an option--</option>
            <option value="soup">Soup</option>
            <option value="porridge">Porridge</option>
            <option value="hamburger">Hamburger</option>
        </select>


        <div><label> Number:
            <input type="text" id="number" name="number" placeholder="Input the number of food"
            &lt;#&ndash;pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$"&ndash;&gt; required/>
        </label></div>-->
</fieldset>


        <input type="hidden" name="${_csrf.parameterName}" id="csrf" value="${_csrf.token}"/>
        <div><input type="button" value="Add Food" class="add" id="add"/></div>
        <div><input type="submit" class="button" id="registerButton" value="Submit"/></div>
    </form>

<script>
    $(document).ready(function () {
        $("#add").click(function () {
            var lastField = $("#mealForm div:last");
            var intId = (lastField && lastField.length && lastField.data("idx") + 1) || 1;
            var fieldWrapper = $("<div class=\"fieldwrapper\" id=\"field" + intId + "\"/>");
            fieldWrapper.data("idx", intId);
            var fName = $("<input type=\"text\" class=\"fieldname\" />");
            var fType = $("<select class=\"fieldtype\"><option value=\"checkbox\">Soup</option><option value=\"textbox\">Porridge</option><option value=\"textarea\">Hamburger</option></select>");
            var removeButton = $("<input type=\"button\" class=\"remove\" value=\"-\" />");
            removeButton.click(function () {
                $(this).parent().remove();
            });
            fieldWrapper.append(fName);
            fieldWrapper.append(fType);
            fieldWrapper.append(removeButton);
            $("#mealForm").append(fieldWrapper);
        });
        $("#preview").click(function () {
            $("#yourform").remove();
            var fieldSet = $("<fieldset id=\"yourform\"><legend>Your Form</legend></fieldset>");
            $("#mealForm div").each(function () {
                var id = "input" + $(this).attr("id").replace("field", "");
                var label = $("<label for=\"" + id + "\">" + $(this).find("input.fieldname").first().val() + "</label>");
                var input;
                switch ($(this).find("select.fieldtype").first().val()) {
                    case "checkbox":
                        input = $("<input type=\"checkbox\" id=\"" + id + "\" name=\"" + id + "\" />");
                        break;
                    case "textbox":
                        input = $("<input type=\"text\" id=\"" + id + "\" name=\"" + id + "\" />");
                        break;
                    case "textarea":
                        input = $("<textarea id=\"" + id + "\" name=\"" + id + "\" ></textarea>");
                        break;
                }
                fieldSet.append(label);
                fieldSet.append(input);
            });
            $("body").append(fieldSet);
        });
    });


</script>

<script>
    //add options to drop-down
    //https://css-tricks.com/dynamic-dropdowns/

    $("#first-choice").change(function () {

        var $dropdown = $(this);

        $.getJSON("jsondata/data.json", function (data) {

            var key = $dropdown.val();
            var vals = [];

            switch (key) {
                case 'beverages':
                    vals = data.beverages.split(",");
                    break;
                case 'snacks':
                    vals = data.snacks.split(",");
                    break;
                case 'base':
                    vals = ['Please choose from above'];
            }

            var $secondChoice = $("#second-choice");
            $secondChoice.empty();
            $.each(vals, function (index, value) {
                $secondChoice.append("<option>" + value + "</option>");
            });

        });
    });

</script>



<script>
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    $(document).ready(function () {

        // SUBMIT FORM
        $("#registrationForm").submit(function (event) {
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
                    } else {
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



    <@f.footer date="2019" project="Food Tracking System"/>
</@c.page>