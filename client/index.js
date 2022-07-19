const form = document.getElementById('form');
const username = document.getElementById('username');
const password = document.getElementById('password');
const todoDiv = document.getElementById('todo');
const userId = document.getElementById('userId');
const BASEURL = 'http://localhost:8080';
form.addEventListener('submit', event => {
   event.preventDefault();

   fetch(`${BASEURL}/register`, {
      method: 'POST',
      headers: {
         'Content-Type': 'application/json',
         // 'Content-Type': 'application/x-www-form-urlencoded',
      },
      body: JSON.stringify({
         username: username.value,
         password: password.value,
      }),
   });
});

fetch(`${BASEURL}/ping`)
   .then(res => res.json())
   .then(data => console.log(data))
   .catch(error => console.log(error));

console.log('adasd');

async function getTodo() {
   const res = await fetch(`${BASEURL}/todos`);
   const data = await res.json();
   todoDiv.innerHTML = '';
   for (let i = 0; i < data.length; i++) {
      const p = document.createElement('p');
      p.textContent = data[i].title;
      todoDiv.appendChild(p);
   }
}

async function deleteUser() {
   fetch(`${BASEURL}/user/${userId.value}`, {
      method: 'DELETE',
   });
}
