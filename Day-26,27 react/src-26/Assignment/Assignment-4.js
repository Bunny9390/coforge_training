import { useState } from "react";

function Assignment4() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");

  const login = () => {
    if (email === "") {
      setMessage("Email should not be empty");
    } else if (password.length < 6) {
      setMessage("Password should contain minimum 6 characters");
    } else {
      setMessage("Login Successful");
    }
  };

  return (
    <div>
      <h1>Login Form</h1>

      <input
        type="email"
        placeholder="Email"
        onChange={(e) => setEmail(e.target.value)}
      />
      <br /><br />

      <input
        type="password"
        placeholder="Password"
        onChange={(e) => setPassword(e.target.value)}
      />
      <br /><br />

      <button onClick={login}>Login</button>

      <h3>{message}</h3>
    </div>
  );
}

export default Assignment4;