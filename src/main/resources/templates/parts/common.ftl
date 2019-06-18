<#macro page >
    <#import "/spring.ftl" as spring/>
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <meta charset="UTF-8">
    <title>Food Tracking System</title>
    <link rel="stylesheet" type="text/css"
          href="<@spring.url '/css/styles.css'/>"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


</head>
<body>
    <#--<#include "security.ftl">-->
    <#nested >

<script type="text/javascript">
    $(document).ready(function() {
        $("#locales").change(function () {
            var selectedOption = $('#locales').val();
            if (selectedOption != ''){
                window.location.replace(window.location.origin + window.location.pathname + '?lang=' + selectedOption);
            }
        });
    });
</script>


<link type="application/json" rel="script"
      href="<@spring.url '/static/js/scripts.js'/>"/>


</body>
</html>
</#macro>
