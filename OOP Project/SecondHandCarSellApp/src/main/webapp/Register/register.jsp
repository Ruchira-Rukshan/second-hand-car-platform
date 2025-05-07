<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="d-flex justify-content-center align-items-center vh-100 bg-light">

    <div class="text-center p-4 border rounded shadow bg-white">
        <h2>Register</h2>
        <form action="/SecondHandCarSellApp/Register/register" method="post">
            <input type="text" name="username" placeholder="Enter Username" required class="form-control mb-2">
            <input type="password" name="password" placeholder="Enter Password" required class="form-control mb-2">
            <input type="email" name="email" placeholder="Enter Email" required class="form-control mb-2">
            <button type="submit" class="btn btn-success">Register</button>
        </form>
    </div>

</body>
</html>
