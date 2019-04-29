<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>

<div>
    <a class="btn btn-primary" href=/traveladd">Добавить тур</a>
</div>




<div>
<table  border="1px">
    <thead>
        <tr>
            <th>name</th>
            <th>location</th>
            <th>description</th>
            <th>startDate</th>
            <th>endDate</th>
            <th>countLimit</th>
            <th>freely</th>


        </tr>
    </thead>

    <tbody>
<#list travel as travel>

<tr>
    <td><center>${travel.name}</center></td>
    <td><center>${travel.location}</center></td>
    <td><center>${travel.description}</center></td>
    <td><center>${travel.startDate}</center></td>
    <td><center>${travel.endDate}</center></td>
    <td><center>${travel.countLimit}</center></td>

    <td><button type="submit" formaction="/orderadd">Добавить тур</button></td>
</tr>
    </tbody>

<#else>
No messages
</#list>
</table>
</div>
</@c.page>
