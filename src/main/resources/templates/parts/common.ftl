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

    <#nested >


<#--<script type="application/json" src="/static/js/scripts.js"></script>
<script src="/static/js/registerScript.js"></script>
<script type="application/json" src="/static/js/scripts.js"></script>-->

<link type="application/json" rel="script"
      href="<@spring.url '/static/js/scripts.js'/>"/>

<#--<script type="type/javascript" src="/static/js/scripts.js">
<script src="/static/js/scripts.js"></script>-->
</body>
</html>
</#macro>
