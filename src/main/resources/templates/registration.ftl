<#import "parts/common.ftl" as c>
<@c.page>
Add new user

<div>
    <form  method="post" action="/registration">
        <div>
           <label>User Name</label> <input type="text" name="username"  />
        </div>
        <div>
            <label>firs Name</label> <input type="text" name = "firstName" />
        </div>
        <div>
            <label>last Name</label> <input type="text"  name="lastName"  />
        </div>
        <div>
            <label>email</label> <input type="text"  name="email" />
        </div>
        <div>
            <label>birthday</label> <input type="date" name="birthday" />
        </div>
        <div>
            <label>password</label> <input type="password"  name="password" />
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />


        <button type="submit" >Submit</button>
    </form>
</div>

<a href="/login">login</a>
</@c.page>