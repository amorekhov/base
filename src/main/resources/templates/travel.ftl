<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>

<form method="post" action="/travelall/${travel.travelId}/orderadd">
        Name <h3> ${name}</h3>
        Location <h3>${location}</h3>
        Description <h3> ${description}</h3>
        Start Date <h3> ${startdate}</h3>
        End date <h3> ${enddate}</h3>
        Limit <h3>${countlimit}</h3>


    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <#if isDate&isLimit>
         <button class="btn btn-primary" type="submit">Выбрать тур</button>
</#if>
</form>




</@c.page>