<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>



<div class="card-columns">
    <#list orders as orders>


    <#if orders??>
    <form class="card my-3" style="width: 18rem;">
        Username<h5>${orders.user.username}</h5>
        Travelname<h5>${orders.travel.name}</h5>
        StartDate<h5>${orders.timeKey}</h5>
    </form>

    <#else>
    No messages
</#if>
</#list>
</div>
</@c.page>