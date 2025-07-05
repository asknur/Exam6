<h2>Новая запись на ${date}</h2>

<form action="/add" method="post">
    <input type="hidden" name="date" value="${date}">

    <div>
        <label>ФИО: <input type="text" name="name" required></label>
    </div>

    <div>
        <label>Дата рождения: <input type="date" name="birthdate" required></label>
    </div>

    <div>
        <label>Тип пациента:
            <select name="type" required>
                <option value="первичный">Первичный</option>
                <option value="вторичный">Вторичный</option>
            </select>
        </label>
    </div>

    <div>
        <label>Дата и время приема: <input type="datetime-local" name="time" required></label>
    </div>

    <div>
        <label>Симптомы: <textarea name="symptoms" required></textarea></label>
    </div>

    <button type="submit">Записать</button>
</form>

<style>
  body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    margin: 20px;
    color: #333;
    line-height: 1.6;
    background-color: #f5f7fa;
  }

  h2 {
    color: #2c3e50;
    border-bottom: 2px solid #3498db;
    padding-bottom: 10px;
    margin-bottom: 25px;
  }

  form {
    max-width: 600px;
    margin: 0 auto;
    background: white;
    padding: 25px;
    border-radius: 8px;
    box-shadow: 0 2px 10px rgba(0,0,0,0.1);
  }

  div {
    margin-bottom: 20px;
  }

  label {
    display: block;
    margin-bottom: 8px;
    font-weight: 500;
    color: #2c3e50;
  }

  input[type="text"],
  input[type="date"],
  input[type="datetime-local"],
  select,
  textarea {
    width: 100%;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 4px;
    font-size: 16px;
    transition: border-color 0.3s;
  }

  input[type="text"]:focus,
  input[type="date"]:focus,
  input[type="datetime-local"]:focus,
  select:focus,
  textarea:focus {
    border-color: #3498db;
    outline: none;
    box-shadow: 0 0 0 2px rgba(52, 152, 219, 0.2);
  }

  textarea {
    min-height: 100px;
    resize: vertical;
  }

  button[type="submit"] {
    background-color: #2ecc71;
    color: white;
    border: none;
    padding: 12px 20px;
    border-radius: 4px;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s;
    width: 100%;
    font-weight: 500;
  }

  button[type="submit"]:hover {
    background-color: #27ae60;
  }

</style>