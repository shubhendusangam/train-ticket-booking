document.getElementById('ticketForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const firstName = document.getElementById('firstName').value;
    const lastName = document.getElementById('lastName').value;
    const email = document.getElementById('email').value;
    const section = document.getElementById('section').value;

    const requestData = {
        firstName: firstName,
        lastName: lastName,
        email: email,
        section: section
    };

    fetch('/api/purchase-ticket', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(requestData)
    })
        .then(response => response.json())
        .then(data => {
            document.getElementById('userName').textContent = `${data.user.firstName} ${data.user.lastName}`;
            document.getElementById('userEmail').textContent = data.user.email;
            document.getElementById('userSection').textContent = data.section;

            document.getElementById('ticketForm').classList.add('hidden');
            document.getElementById('receipt').classList.remove('hidden');
        })
        .catch(error => console.error('Error:', error));
});

document.getElementById('newTicketButton').addEventListener('click', function() {
    document.getElementById('ticketForm').classList.remove('hidden');
    document.getElementById('receipt').classList.add('hidden');
    document.getElementById('ticketForm').reset();
});

document.getElementById('fetchReceiptButton').addEventListener('click', function() {
    const ticketId = document.getElementById('ticketId').value;
    getReceipt(ticketId);
});

function getReceipt(ticketId) {
    fetch(`/api/receipt/${ticketId}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById('userName').textContent = `${data.user.firstName} ${data.user.lastName}`;
            document.getElementById('userEmail').textContent = data.user.email;
            document.getElementById('userSection').textContent = data.section;

            document.getElementById('ticketForm').classList.add('hidden');
            document.getElementById('receipt').classList.remove('hidden');
        })
        .catch(error => console.error('Error:', error));
}
