<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
login page
<@l.login "/login" />
<a href="/registration">регистрация</a>
</@c.page>