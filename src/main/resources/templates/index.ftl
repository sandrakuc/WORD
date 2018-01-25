<#import "template.ftl" as t>

<@t.page>

    <#if Session.user?exists>
        ${Session.user.firstName}
    </#if>

    test spring
</@t.page>

