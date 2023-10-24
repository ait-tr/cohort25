async function confirm() {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);

    await fetch("http://localhost:8080/api/users/confirm/" + urlParams.get("id"))
        .then(response => {
            if (!response.ok) {
                throw Error(response.json().message)
            }

            return response
        })
        .then(response => {
            return response.json();
        }).then(user => {
            let firstName = document.getElementById('firstName')
            let lastName = document.getElementById('lastName')

            firstName.innerHTML = user.firstName
            lastName.innerHTML = user.lastName
        }).catch(error => {
            alert(error)
        })
}