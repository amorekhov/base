<#import "parts/common.ftl" as c>

<@c.page>
${message?ifExists}


Username
<h5>${username}</h5>
Firstname
<#if firstname??>
    <h5>${firstname}</h5>
<#else>
   <h5></h5>
</#if>

Lastname
<#if lastname??>
    <h5>${lastname}</h5>
<#else>
<h5></h5>
</#if>
birthday
<#if birthday??>
    <h5>${birthday}</h5>
<#else>
    <h5></h5>
</#if>
email
<#if email??>
    <h5>${email}</h5>
<#else>
    <h5></h5>
</#if>

<a class="btn btn-primary" href="/user/useredit">
    Edit
</a>

</@c.page>