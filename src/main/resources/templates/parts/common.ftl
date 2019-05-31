<#macro page >
    <#import "/spring.ftl" as spring/>
<#--<import '/spring..templates' as spring/>-->
    <!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Food Tracking System</title>

    <#--<link rel="stylesheet"  href="../css/styles.css">-->

    <link rel="stylesheet" type="text/css"
          href="<@spring.url '/css/styles.css'/>"/>
    <link href="/js/scripts.js" type='text/javascript'/>

<#--<link rel="stylesheet"
      type="text/css" href="<@spring.url '/css/style.css'/>"/>-->

</head>
<body>
    <#nested >

<script src="../js/scripts.js"></script>



</body>
</html>
</#macro>
