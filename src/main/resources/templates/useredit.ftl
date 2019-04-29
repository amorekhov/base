<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>

${message?ifExists}
<h5>${username}</h5>

<form  method="post">

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
        <label class="col-sm-2 col-form-label"> Password : </label>
        <div class="col-sm-6">
            <input type="password" name="password" class="form-control" placeholder="Password">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 col-form-label"> Email : </label>
        <div class="col-sm-6">
            <input type="email" name="email" class="form-control" placeholder="some@some.com" value="${email!''}">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 col-form-label">birthday</label>
        <div class="col-sm-6">
            <input type="date" name="birthday" class="form-control"/>
        </div>
    </div>

    <input type="hidden" name="_csrf" value="${_csrf.token}" />

    <button class="btn btn-primary" type="submit">Save</button>

</form>


</@c.page>