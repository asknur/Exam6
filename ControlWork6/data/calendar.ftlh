<h1>Расписание на ${today.month.toString()?lower_case?cap_first} ${today.year}</h1>

<table>
  <tr>
    <#list ["Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс"] as day>
      <th>${day}</th>
    </#list>
  </tr>

  <#assign firstDay = today.withDayOfMonth(1)>
  <#assign lastDay = today.withDayOfMonth(today.lengthOfMonth())>

  <#assign dayOfWeek = firstDay.getDayOfWeek().getValue()>
  <#assign daysInMonth = today.lengthOfMonth()>

  <#list 1..6 as week>
    <#if (week == 1)>
      <tr>
        <#list 1..(dayOfWeek - 1) as emptyDay>
          <td></td>
        </#list>
        <#list 1..(7 - dayOfWeek + 1) as day>
          <#assign currentDay = firstDay.plusDays(day - 1)>
          <@dayCell day=currentDay/>
        </#list>
      </tr>
    <#else>
      <#assign startDay = (week - 2) * 7 + (8 - dayOfWeek)>
      <#if (startDay <= daysInMonth)>
        <tr>
          <#list 1..7 as day>
            <#assign currentDayNum = startDay + day - 1>
            <#if (currentDayNum <= daysInMonth)>
              <#assign currentDay = firstDay.plusDays(currentDayNum - 1)>
              <@dayCell day=currentDay/>
            <#else>
              <td></td>
            </#if>
          </#list>
        </tr>
      </#if>
    </#if>
  </#list>
</table>

<#macro dayCell day>
  <td class="${(day == today)?then('today','')}">
    <a href="/day?date=${day}">${day.dayOfMonth}</a>
    <#assign patients = schedule.getPatientsByDate(day)>
    <#if patients?size gt 0>
      <span>(${patients?size})</span>
    </#if>
  </td>
</#macro>

<style>
  body {
    font-family: 'Arial', sans-serif;
    margin: 20px;
    color: #333;
  }

  h1 {
    color: #2c3e50;
    text-align: center;
    margin-bottom: 20px;
  }

  table {
    width: 100%;
    border-collapse: collapse;
    box-shadow: 0 2px 10px rgba(0,0,0,0.1);
  }

  th, td {
    padding: 12px;
    text-align: center;
    border: 1px solid #ddd;
  }

  th {
    background-color: #3498db;
    color: white;
    font-weight: bold;
  }

  td {
    height: 80px;
    vertical-align: top;
    background-color: white;
    transition: all 0.3s ease;
  }

  td:hover {
    background-color: #f5f5f5;
    transform: scale(1.02);
  }

  .today {
    background-color: #e3f2fd;
    font-weight: bold;
    position: relative;
  }

  .today:after {
    content: '';
    position: absolute;
    top: 2px;
    right: 2px;
    width: 8px;
    height: 8px;
    background-color: #e74c3c;
    border-radius: 50%;
  }

  a {
    color: #2980b9;
    text-decoration: none;
    font-weight: bold;
    display: block;
    margin-bottom: 5px;
  }

  span {
    display: inline-block;
    background-color: #2ecc71;
    color: white;
    border-radius: 50%;
    width: 22px;
    height: 22px;
    line-height: 22px;
    font-size: 12px;
  }

  tr:nth-child(even) td {
    background-color: #f9f9f9;
  }
</style>