<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>

<div>
    <a class="btn btn-primary" href=/traveladd>Добавить тур</a>
</div>




<div class="card-columns">

    <#list travel as travel>

    <form class="card my-3" style="width: 18rem;">
       Name <h3> ${travel.name}</h3>
       Location <h3>${travel.location}</h3>
       Description <h3> ${travel.description}</h3>
       Start Date <h3> ${travel.startDate}</h3>
       End date <h3> ${travel.endDate}</h3>
       Limit <h3>${travel.countLimit}</h3>

        <div>
            <a class="btn btn-primary" href="/travelall/${travel.travelId}">Посмотреть тур</a>
        </div>
        </form>

<#else>
No messages
</#list>

</div>
</@c.page>
