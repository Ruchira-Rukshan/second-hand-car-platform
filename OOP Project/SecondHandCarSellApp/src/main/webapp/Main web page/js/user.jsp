let users = [];

const registerForm = document.getElementById("registerForm");
const userList = document.getElementById("userList");

registerForm.addEventListener("submit", (e) => {
  e.preventDefault();

  const user = {
    id: Date.now(),
    name: document.getElementById("regName").value,
    email: document.getElementById("regEmail").value,
    contact: document.getElementById("regContact").value,
    role: document.getElementById("regRole").value,
    password: document.getElementById("regPassword").value,
  };

  users.push(user);
  registerForm.reset();
  displayUsers();
});

function displayUsers() {
  userList.innerHTML = "";

  users.forEach((user) => {
    const li = document.createElement("li");

    li.innerHTML = `
      <div contenteditable="false" class="user-info">
        <strong>Name:</strong> <span class="name">${user.name}</span> |
        <strong>Email:</strong> <span class="email">${user.email}</span> |
        <strong>Contact:</strong> <span class="contact">${user.contact}</span> |
        <strong>Role:</strong> <span class="role">${user.role}</span>
      </div>
      <div class="user-actions">
        <button onclick="enableEdit(${user.id})">Edit</button>
        <button onclick="updateUser(${user.id})">Update</button>
        <button onclick="deleteUser(${user.id})">Delete</button>
      </div>
    `;
    userList.appendChild(li);
  });
}

function enableEdit(userId) {
  const userItem = users.find((u) => u.id === userId);
  const li = Array.from(userList.children).find((li) =>
    li.innerHTML.includes(userItem.email)
  );

  const spans = li.querySelectorAll(".user-info span");
  spans.forEach((span) => {
    span.setAttribute("contenteditable", true);
    span.classList.add("editable");
  });
}

function updateUser(userId) {
  const userIndex = users.findIndex((u) => u.id === userId);
  const li = Array.from(userList.children).find((li) =>
    li.innerHTML.includes(users[userIndex].email)
  );

  const spans = li.querySelectorAll(".user-info span");
  const updatedUser = {
    ...users[userIndex],
    name: spans[0].innerText,
    email: spans[1].innerText,
    contact: spans[2].innerText,
    role: spans[3].innerText,
  };

  users[userIndex] = updatedUser;

  spans.forEach((span) => {
    span.setAttribute("contenteditable", false);
    span.classList.remove("editable");
  });

  displayUsers();
}

function deleteUser(userId) {
  users = users.filter((u) => u.id !== userId);
  displayUsers();
}

document.getElementById("registerForm").addEventListener("submit", function (e) {
  e.preventDefault();

  const formData = new FormData(this);

  fetch("/SecondHandCarSellApp/components/user", {
    method: "POST",
    body: formData
  })
    .then(response => {
      if (response.redirected) {
        window.location.href = response.url; // redirect to success/error JSP
      } else {
        alert("Registration failed.");
      }
    })
    .catch(error => {
      console.error("Error:", error);
      alert("An error occurred.");
    });
});
