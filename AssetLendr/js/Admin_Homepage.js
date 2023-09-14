document.addEventListener('DOMContentLoaded', function () {
    // Get references to the button and form
    const importUser = document.getElementById('importUser');
    const myForm = document.getElementById('myForm');

    // Function to display submitted emails
function displayEmails() {
    const emailList = document.getElementById('emails');
    emailList.innerHTML = '';

    const storedEmails = JSON.parse(localStorage.getItem('submittedEmails')) || [];
    for (const email of storedEmails) {
        const listItem = document.createElement('li');
        const emailText = document.createElement('span');
        emailText.textContent = email;

        // Button elements for each email
        const buttonGroup = document.createElement('div');
        buttonGroup.classList.add('btn-group');

        
        const viewButton = document.createElement('button');
        viewButton.classList.add('btnView', 'view');
        viewButton.textContent = 'View';

        // Delete button
        const deleteButton = document.createElement('button');
        deleteButton.classList.add('btnDelete', 'delete');
        deleteButton.textContent = 'Delete';
        deleteButton.onclick = function () {
            confirmDelete(deleteButton);
        };

        buttonGroup.appendChild(viewButton);

        // Add buttons to the button group
        buttonGroup.appendChild(deleteButton);

        // Add email text and buttons to the list item
        listItem.appendChild(emailText);

        listItem.appendChild(buttonGroup);
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

// Function to delete a user
function deleteUser(email) {
    const storedEmails = JSON.parse(localStorage.getItem('submittedEmails')) || [];
    const updatedEmails = storedEmails.filter(item => item !== email);
    localStorage.setItem('submittedEmails', JSON.stringify(updatedEmails));
    displayEmails();
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
        const email = emailInput.value.trim();
    
        if (email) {
            // Retrieve existing emails from Local Storage
            const storedEmails = JSON.parse(localStorage.getItem('submittedEmails')) || [];
    
            if (!emailExists(email, storedEmails)) {
                // Add the new email and update Local Storage
                storedEmails.push(email);
                localStorage.setItem('submittedEmails', JSON.stringify(storedEmails));
    
                // Display the updated list of emails
                displayEmails();
    
                // Reset the form
                resetForm();
            } else {
                alert('This email address is already submitted.');
                // Reset the form even if the email is repeated
                resetForm();
            }
        }
    });
    // Initial display of submitted emails
    displayEmails();
    
});