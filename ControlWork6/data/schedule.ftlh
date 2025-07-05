<#list days?keys as date>
    <h3>${date}</h3>
    <#list days[date] as patient>
        <p>${patient.time} — ${patient.fullName} (${patient.type})</p>
    </#list>
</#list>