document.addEventListener('DOMContentLoaded', function () {
// Get the elements
const adminRadio = document.getElementById("admin");
const emailInput = document.getElementById("email"); 
const passwordInput = document.getElementById("password");
const loginForm = document.getElementById("loginForm");

// Initial values for the Admin user
const adminEmail = "admin@gmail.com";
const adminPassword = "Root@123";


// Set initial values when Admin radio button is selected
adminRadio.addEventListener("change", function () {
    if (adminRadio.checked) {
        emailInput.value = adminEmail;
        passwordInput.value = adminPassword;
    }
});

// Listen for the form submission
loginForm.addEventListener("submit", function (e) {
    e.preventDefault(); // Prevent the form from submitting normally

    // Check if the entered email and password match the Admin credentials
    if (emailInput.value === adminEmail && passwordInput.value === adminPassword) {
        // Redirect to Admin_homepage.html
        window.location.href = "/html/Admin_homepage.html";
    } else {
        // Display an error message or handle invalid login here
        alert("Invalid email or password");
    }
});

});