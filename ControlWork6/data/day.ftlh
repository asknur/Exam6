<h2>Пациенты на ${date}</h2>

<table>
  <tr>
    <th>ФИО</th>
    <th>Дата рождения</th>
    <th>Тип</th>
    <th>Симптом</th>
    <th>Действие</th>
  </tr>

  <#list patients as p>
    <tr class="${p.type}">
        ${p.appointmentTime}
      <td>${p.fullName}</td>
      <td>${p.birthDate}</td>
      <td>${p.type}</td>
      <td>${p.symptoms}</td>
      <td>
        <form action="/delete" method="post">
          <input type="hidden" name="id" value="${p.id}">
          <input type="hidden" name="date" value="${date}">
          <button>Удалить</button>
        </form>
        <form action="/edit-patient" method="get" style="display:inline;">
          <input type="hidden" name="id" value="${p.id}">
          <button>Редактировать</button>
        </form>
      </td>
    </tr>
  </#list>
</table>

<a href="/add-patient?date=${date}">Добавить пациента</a>

<style>
  body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    margin: 20px;
    color: #333;
    line-height: 1.6;
  }

  h2 {
    color: #2c3e50;
    border-bottom: 2px solid #3498db;
    padding-bottom: 10px;
    margin-bottom: 20px;
  }

  table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
    box-shadow: 0 2px 10px rgba(0,0,0,0.1);
  }

  th {
    background-color: #3498db;
    color: white;
    padding: 12px;
    text-align: left;
  }

  td {
    padding: 10px 12px;
    border-bottom: 1px solid #ddd;
    vertical-align: top;
  }

  tr:hover {
    background-color: #f5f5f5;
  }

  /* Цвета для разных типов пациентов */
  tr.URGENT {
    background-color: #ffebee;
  }

  tr.URGENT:hover {
    background-color: #ffcdd2;
  }

  tr.REGULAR {
    background-color: #e8f5e9;
  }

  tr.REGULAR:hover {
    background-color: #c8e6c9;
  }

  tr.CHILD {
    background-color: #e3f2fd;
  }

  tr.CHILD:hover {
    background-color: #bbdefb;
  }

  button {
    background-color: #e74c3c;
    color: white;
    border: none;
    padding: 6px 12px;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s;
  }

  button:hover {
    background-color: #c0392b;
  }

  a {
    display: inline-block;
    background-color: #2ecc71;
    color: white;
    padding: 10px 15px;
    text-decoration: none;
    border-radius: 4px;
    margin-top: 10px;
    transition: background-color 0.3s;
  }

  a:hover {
    background-color: #27ae60;
  }
</style>
