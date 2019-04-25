<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>

<div>
    <form  method="post" action="/traveladd">
        <div>
            <input type="text" name="name"  />
        </div>
        <div>
            <input type="text" name = "location" />
        </div>
        <div>
            <input type="text"  name="description"  />
        </div>
        <div>
            <input type="date"  name="startDate" />
        </div>
        <div>
            <input type="date" name="endDate" />
        </div>
        <div>
            <input type="text"  name="countLimit" />
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />


        <button type="submit">Submit</button>
    </form>
</div>


</@c.page>
