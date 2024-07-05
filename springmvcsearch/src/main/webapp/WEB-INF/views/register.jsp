<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Complex Form Example</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Complex Form Example</h1>
        <div class="alert alert-danger" role="alert">
            <form:errors path="data.*"/>
        </div>
        <form action="handler" method="post">
            <div class="row">
                <div class="col-md-6">
                    <div class="mb-3">
                        <label for="name" class="form-label">Name</label>
                        <input type="text" class="form-control" name="name" placeholder="Enter your name">
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" name="email" placeholder="Enter your email">
                    </div>
                </div>
            </div>
            <div class="mb-3">
                <label for="message" class="form-label">Message</label>
                <textarea class="form-control" name="message" rows="5" placeholder="Enter your message"></textarea>
            </div>
            <div class="mb-3">
                <label class="form-label">Gender</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" id="male" value="male">
                    <label class="form-check-label" for="male">Male</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" id="female" value="female">
                    <label class="form-check-label" for="female">Female</label>
                </div>
            </div>
            <div class="mb-3">
                <label class="form-label">Interests</label>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="interest" id="interest1" value="interest1">
                    <label class="form-check-label" for="interest1">Interest 1</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="interest" id="interest2" value="interest2">
                    <label class="form-check-label" for="interest2">Interest 2</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="interest" id="interest3" value="interest3">
                    <label class="form-check-label" for="interest3">Interest 3</label>
                </div>
            </div>
            <div class="mb-3">
                <label class="form-label">Country</label>
                <select class="form-select" name="country">
                    <option selected>Select country</option>
                    <option value="usa">USA</option>
                    <option value="canada">Canada</option>
                    <option value="uk">UK</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
    <!-- Bootstrap JS (optional) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
