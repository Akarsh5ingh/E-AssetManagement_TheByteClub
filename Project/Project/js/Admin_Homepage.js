document.addEventListener('DOMContentLoaded', function () {
    // Get references to the button and form
    const importUser = document.getElementById('importUser');
    const myForm = document.getElementById('myForm');

    // Function to display submitted emails
function displayEmails() {
    const emailList = document.getElementById('emails');
    emailList.innerHTML = '';

    const storedEmails = JSON.parse(localStorage.getItem('submittedEmails')) || [];
    const storedFirstNames = JSON.parse(localStorage.getItem('submittedFirstNames')) || [];
    const storedLastNames = JSON.parse(localStorage.getItem('submittedLastNames')) || [];

    for (let i = 0; i < storedEmails.length; i++) {
                const listItem = document.createElement('li');
                const emailSpan = document.createElement('span');
                emailSpan.textContent = storedEmails[i];
                const firstNameSpan = document.createElement('span');
                firstNameSpan.classList.add('first-name');
                firstNameSpan.textContent = storedFirstNames[i];
                const lastNameSpan = document.createElement('span');
                lastNameSpan.classList.add('last-name');
                lastNameSpan.textContent = storedLastNames[i];

                // Button elements for each email
                const buttonGroup = document.createElement('div');
                buttonGroup.classList.add('btn-group');

                // View button
                const viewButton = document.createElement('button');
                viewButton.classList.add('btnView', 'view');
                viewButton.textContent = 'View';
                viewButton.onclick = function () {
                    viewUser(viewButton, i);
                };


        // Delete button
        const deleteButton = document.createElement('button');
        deleteButton.classList.add('btnDelete', 'delete');
        deleteButton.textContent = 'Delete';
        deleteButton.onclick = function () {
            confirmDelete(deleteButton);
        };

        // Add buttons to the button group
        buttonGroup.appendChild(viewButton);
        buttonGroup.appendChild(deleteButton);

        // Add spans and buttons to the list item
        listItem.appendChild(emailSpan);
        listItem.appendChild(firstNameSpan);
        listItem.appendChild(lastNameSpan);
        listItem.appendChild(buttonGroup);

        // Add the list item to the email list
        emailList.appendChild(listItem);
    }
}

// Function to check if an email already exists in the list
function emailExists(email, emailList) {
    return emailList.indexOf(email) !== -1;
}

// Function to reset the email input field
function resetForm() {
    const myForm = document.getElementById('myForm');
    myForm.reset();
}

    // Function to view user information
    function viewUser(button, index) {
        const listItem = button.closest('li');
        const firstNameSpan = listItem.querySelector('.first-name');
        const lastNameSpan = listItem.querySelector('.last-name');
        
        const firstName = firstNameSpan.textContent;
        const lastName = lastNameSpan.textContent;
        
        alert(`User Information:\nEmail: ${emailInput}\nFirst Name: ${firstName}\nLast Name: ${lastName}`);
    }

   // Function to confirm and delete a user
   function confirmDelete(button) {
    const listItem = button.closest('li');
    const emailText = listItem.querySelector('span');
    const email = emailText.textContent;

    if (confirm(`Are you sure you want to delete the user with email: ${email}`)) {
        // Delete the user
        deleteUser(email);
    }
}

document.getElementById('upload').addEventListener('click', function() {
    const fileInput = document.getElementById('fileInput');
    fileInput.click();
});

document.getElementById('fileInput').addEventListener('change', function(event) {
    const selectedFile = event.target.files[0];
    if (selectedFile) {
        const fileType = selectedFile.name.split('.').pop().toLowerCase();

        if (fileType === 'xml') {
            alert('XML file selected');
            // You can add code here to handle the XML file.
        } else if (fileType === 'json') {
            alert('JSON file selected');
            // You can add code here to handle the JSON file.
        } else {
            alert('Unsupported file format. Please select an XML or JSON file.');
        }
    }
});

// Function to delete a user
function deleteUser(email) {
    const storedEmails = JSON.parse(localStorage.getItem('submittedEmails')) || [];
    const storedFirstNames = JSON.parse(localStorage.getItem('submittedFirstNames')) || [];
    const storedLastNames = JSON.parse(localStorage.getItem('submittedLastNames')) || [];
    
    const emailIndex = storedEmails.indexOf(email);
    if (emailIndex !== -1) {
        storedEmails.splice
        storedEmails.splice(emailIndex, 1);
                storedFirstNames.splice(emailIndex, 1);
                storedLastNames.splice(emailIndex, 1);

                // Update Local Storage
                localStorage.setItem('submittedEmails', JSON.stringify(storedEmails));
                localStorage.setItem('submittedFirstNames', JSON.stringify(storedFirstNames));
                localStorage.setItem('submittedLastNames', JSON.stringify(storedLastNames));

                // Refresh the displayed emails
                displayEmails();
            }
}

    // Add a click event listener to the button
    importUser.addEventListener('click', function () {
        // Toggle the display of the form
        if (myForm.style.display === 'none' || myForm.style.display === '') {
            myForm.style.display = 'block';
        } else {
            myForm.style.display = 'none';
        }
    });

    document.getElementById('myForm').addEventListener('submit', function (e) {
        e.preventDefault();
        const emailInput = document.getElementById('email');
        const firstNameInput = document.getElementById('firstNameInput');
        const lastNameInput = document.getElementById('lastNameInput');
        const email = emailInput.value.trim();
        const firstName = firstNameInput.value.trim();
        const lastName = lastNameInput.value.trim();
        const editIndex = parseInt(document.getElementById('editIndex').value);
    
        if (email && firstName && lastName) {
            // Retrieve existing emails from Local Storage
            const storedEmails = JSON.parse(localStorage.getItem('submittedEmails')) || [];
            const storedFirstNames = JSON.parse(localStorage.getItem('submittedFirstNames')) || [];
            const storedLastNames = JSON.parse(localStorage.getItem('submittedLastNames')) || [];

            if (editIndex !== -1) {
                // Update the email and user information if in edit mode
                storedEmails[editIndex] = email;
                storedFirstNames[editIndex] = firstName;
                storedLastNames[editIndex] = lastName;
            } else {
                // Check if the email already exists
                if (!emailExists(email, storedEmails)) {
                    // Add the new email and user information
                    storedEmails.push(email);
                    storedFirstNames.push(firstName);
                    storedLastNames.push(lastName);
                } else {
                    alert('This email address is already submitted.');
                }
            }

            // Update Local Storage and reset the form
            localStorage.setItem('submittedEmails', JSON.stringify(storedEmails));
            localStorage.setItem('submittedFirstNames', JSON.stringify(storedFirstNames));
            localStorage.setItem('submittedLastNames', JSON.stringify(storedLastNames));
            resetForm();

            // Display the updated list of emails
            displayEmails();
        }
    });
    // Initial display of submitted emails
    displayEmails();
    
});