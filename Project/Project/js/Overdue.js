// script.js
document.addEventListener("DOMContentLoaded", function () {
    const searchInput = document.getElementById("searchInput");
    const searchButton = document.getElementById("searchButton");
    const resultsTable = document.getElementById("resultsTable");

    searchButton.addEventListener("click", function () {
        const searchTerm = searchInput.value.toLowerCase();

        // Loop through table rows and check if the search term exists in the "Name of Person" column
        const rows = resultsTable.getElementsByTagName("tbody")[0].rows;
        let userFound = false;

        for (let i = 0; i < rows.length; i++) {
            const nameColumn = rows[i].cells[0].textContent.toLowerCase();

            if (nameColumn.includes(searchTerm)) {
                userFound = true;
                break; // Exit the loop if the user is found
            }
        }

        if (userFound) {
            alert("User Found");
        } else {
            alert("User Not Found");
        }
    });
})






