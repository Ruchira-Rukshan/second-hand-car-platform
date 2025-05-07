<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Successful</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="d-flex justify-content-center align-items-center vh-100 bg-light">

    <div class="text-center p-4 border rounded shadow bg-white">
        <h2 class="text-success">Registration Successful!</h2>
        <p>Your account has been created successfully.</p>
        <a href="${pageContext.request.contextPath}/Login/login.jsp" class="btn btn-primary mt-2">Go to Login Page</a>
    </div>

</body>
</html>
