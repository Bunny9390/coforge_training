import { useState } from "react";

function Calculator() {
  const [num1, setNum1] = useState("");
  const [num2, setNum2] = useState("");
  const [result, setResult] = useState(0);

  const add = () => {
    setResult(Number(num1) + Number(num2));
  };
  const subtract = () => {
    setResult(Number(num1) - Number(num2));
  };
  const multiply = () => {
    setResult(Number(num1) * Number(num2));
  };
  const divide = () => {
    setResult(Number(num1)/Number(num2))
  };

  return (
    <div>
      <h1>Simple Calculator</h1>

      <input
        type="number"
        value={num1}
        onChange={(event) => setNum1(event.target.value)}
      />
      <br /><br />

      <input
        type="number"
        placeholder="Enter Second Number"
        value={num2}
        onChange={(e) => setNum2(e.target.value)}
      />
      <br /><br />
      <button onClick={add}>Addition</button>
      <button onClick={subtract}>Subraction</button>
      <button onClick={multiply}>Multiplication</button>
      <button onClick={divide}>Division</button>

      <br /><br />

      <h2>Result: {result}</h2>
    </div>
  );
}

export default Calculator;