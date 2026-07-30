import { useState } from "react";

function Assignment2() {
  const [name, setName] = useState("");

  return (
    <div>
      <h1>Live Name Preview</h1>

      <input
        type="text"
        value={name}
        onChange={(event) => setName(event.target.value)}
      />

      <h2>Welcome, {name === "" ? "Guest" : name}</h2>
    </div>
  );
}

export default Assignment2;