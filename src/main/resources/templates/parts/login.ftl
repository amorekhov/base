<#macro login path isRegisterForm>

<form action="${path}" method="post">
    <div class="form-group">
        <label class="col-sm-2 col-form-label"> User name :</label>
        <div class="col-sm-6">
            <input type="text" name="username" value="<#if user??>${user.username}</#if>"
                   class="form-control ${(usernameError??)?string('is-invalid', '')}"
                   placeholder="User name">
            <#if usernameError??>
            <div>
                ${usernameError}
            </div>
        </#if>
        </div>
</div>
    <div class="form-group">
        <label class="col-sm-2 col-form-label"> Password : </label>
        <div class="col-sm-6">
            <input type="password" name="password" class="form-control ${(passwordError??)?string('is-invalid', '')}"
                   placeholder="Password">
            <#if passwordError??>
            <div>
                ${passwordError}
            </div>
        </#if>
        </div>
    </div>

    <#if isRegisterForm>

    <div class="form-group">
        <label class="col-sm-2 col-form-label">firstName</label>
        <div class="col-sm-6">
            <input type="text" name = "firstName" class="form-control" placeholder="Firstname"/>
        </div>

    </div>
    <div class="form-group">
        <label class="col-sm-2 col-form-label">lastName</label>
        <div class="col-sm-6">
            <input type="text"  name="lastName"  class="form-control" placeholder="lastname"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 col-form-label">email</label>
        <div class="col-sm-6">
        <input type="email"  name="email" class="form-control" placeholder="some@some.com"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 col-form-label">birthday</label>
        <div class="col-sm-6">
            <input type="date" name="birthday" class="form-control"/>
        </div>
    </div>


</#if>


    <input type="hidden" name="_csrf" value="${_csrf.token}" />

    <#if !isRegisterForm> <a href="/registration">Add new user</a> </#if>

    <button class="btn btn-primary" type="submit"><#if isRegisterForm> Create <#else> Sing In </#if></button>

</form>


</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit"><#if user??>Sign Out<#else>Log in</#if></button>
    </form>
</#macro>


