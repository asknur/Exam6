<h2>Редактирование пациента</h2>

<form action="/edit" method="post">
  <input type="hidden" name="id" value="${patient.id}">
  <label>ФИО: ${patient.fullName}</label><br><br>

  <label>Дата рождения: ${patient.birthDate}</label><br><br>

  <label>Тип:
    <input name="type" value="${patient.type}">
  </label><br><br>

  <label>Симптомы:
    <textarea name="symptoms">${patient.symptoms}</textarea>
  </label><br><br>

  <label>Время:
    <input name="time" type="datetime-local"
           value="${patient.appointmentTime}"
  </label><br><br>

  <button type="submit">Сохранить</button>
</form>

<a href="/day?date=${date}">← Назад</a>
