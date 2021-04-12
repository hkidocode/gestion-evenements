<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <title>Sign up Form - YouCode</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <style>
        body {
            color: #999;
            background: #e2e2e2;
            font-family: 'Varela Round', sans-serif;
            font-size: 13px;
        }
        .form-control {
            min-height: 41px;
            box-shadow: none;
            border-color: #e1e1e1;
        }
        .form-control:focus {
            border-color: #00cb82;
        }
        .form-control, .btn {
            border-radius: 3px;
        }
        .form-header {
            margin: -30px -30px 20px;
            padding: 30px 30px 10px;
            text-align: center;
            background: #00cb82;
            border-bottom: 1px solid #eee;
            color: #fff;
        }
        .form-header h2 {
            font-size: 34px;
            font-weight: bold;
            margin: 0 0 10px;
            font-family: 'Pacifico', sans-serif;
        }
        .form-header p {
            margin: 20px 0 15px;
            font-size: 17px;
            line-height: normal;
            font-family: 'Courgette', sans-serif;
        }
        .signup-form {
            width: 390px;
            margin: 0 auto;
            padding: 30px 0;
        }
        .signup-form form {
            color: #999;
            border-radius: 3px;
            margin-bottom: 15px;
            background: #f0f0f0;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            padding: 30px;
        }
        .signup-form .form-group {
            margin-bottom: 20px;
        }
        .signup-form label {
            font-weight: normal;
            font-size: 14px;
        }
        .signup-form input[type="checkbox"] {
            position: relative;
            top: 1px;
        }
        .signup-form .btn {
            font-size: 16px;
            font-weight: bold;
            background: #00cb82;
            border: none;
            min-width: 200px;
        }
        .signup-form .btn:hover, .signup-form .btn:focus {
            background: #00b073 !important;
            outline: none;
        }
        .signup-form a {
            color: #00cb82;
        }
        .signup-form a:hover {
            text-decoration: underline;
        }

        select {
            font-size: 12px;
        }

        .text-center {
            font-size: 15px;
        }
    </style>
</head>
<body>
<div class="signup-form">
    <form action="login" method="post">
        <div class="form-header">
            <h2>Sign Up</h2>
            <p>Fill out this form to see upcoming events!</p>
        </div>
        <div class="form-group">
            <label>First Name</label>
            <input type="text" name="first-name" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Last Name</label>
            <input type="text" name="last-name" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Email Address</label>
            <input type="email" name="email" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Password</label>
            <input type="password" name="password" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Phone Number</label>
            <input type="number" name="phone" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Role</label>
            <select name="role" class="form-control" id="role" required>
                <option value="2">Teacher</option
                <option value="3">Student</option>
            </select>
        </div>
        <div class="form-group" id="promo">
            <label>Promo</label>
            <select name="promo" class="form-control">
                <option value="1">2019-2021</option>
                <option value="2">2020-2022</option>
            </select>
        </div>
        <div class="form-group" id="specialitie">
            <label>Speciality</label>
            <select name="speciality" class="form-control">
                <option value="1">Web Dev</option>
                <option value="2">C#</option>
                <option value="3">JEE</option>
                <option value="4">FEBE</option>
            </select>
        </div>
        <div class="form-group" id="classe">
            <label>Class</label>
            <select name="class" class="form-control">
                <option value="1">Class 1</option>
                <option value="2">Class 2</option>
                <option value="3">Class 3</option>
                <option value="4">Class 4</option>
                <option value="5">Class 5</option>
                <option value="6">Class 6</option>
                <option value="7">Class 7</option>
                <option value="8">Class 8</option>
            </select>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block btn-lg">Sign Up</button>
        </div>
    </form>
    <div class="text-center small">Already have an account? <a href="#">Login here!</a></div>
</div>
<script>
    const role = document.getElementById('role');
    const promo = document.getElementById('promo');
    const specialitie = document.getElementById('specialitie');
    const classe = document.getElementById('classe');
    console.log(role.value);

        if (role.value === "2") {
            promo.hidden = true;
            specialitie.hidden = false;
            classe.hidden = false;
        }
        role.addEventListener('change', () => {
            // if user is an teacher
            if (role.value === "2") {
                promo.hidden = true;
                specialitie.hidden = false;
                classe.hidden = false;
            }
            // if user is an student
            else {
                promo.hidden = false;
                specialitie.hidden = false;
                classe.hidden = false;
            }
        });
</script>
</body>
</html>
