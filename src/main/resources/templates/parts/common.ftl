<#macro page >
    <#import "/spring.ftl" as spring/>
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Food Tracking System</title>
    <link rel="stylesheet" type="text/css"
          href="<@spring.url '/css/styles.css'/>"/>
</head>
<body>

    <#nested >

<script src="../js/scripts.js"></script>
</body>
</html>
</#macro>
