<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>

<#list orders as orders>
<#if orders??>

<#else>
No messages
</#if>
</#list>

</@c.page>