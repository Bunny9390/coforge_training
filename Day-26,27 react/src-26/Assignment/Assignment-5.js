import { useState } from "react";

function Assignment5() {
  const [employee, setEmployee] = useState({
    id: "",
    name: "",
    dept: "",
    salary: "",
  });

  const [details, setDetails] = useState(null);
  const [error, setError] = useState("");

  const register = () => {
    if (
      employee.id === "" ||
      employee.name === "" ||
      employee.dept === "" ||
      employee.salary === ""
    ) {
      setError("All fields are required");
    } else {
      setError("");
      setDetails(employee);
    }
  };

  return (
    <div>
      <h1>Employee Registration</h1>

      <input
        type="text"
        placeholder="Employee ID"
        onChange={(e) =>
          setEmployee({ ...employee, id: e.target.value })
        }
      />
      <br /><br />

      <input
        type="text"
        placeholder="Employee Name"
        onChange={(e) =>
          setEmployee({ ...employee, name: e.target.value })
        }
      />
      <br /><br />

      <input
        type="text"
        placeholder="Department No"
        onChange={(e) =>
          setEmployee({ ...employee, dept: e.target.value })
        }
      />
      <br /><br />

      <input
        type="number"
        placeholder="Salary"
        onChange={(e) =>
          setEmployee({ ...employee, salary: e.target.value })
        }
      />
      <br /><br />

      <button onClick={register}>Submit</button>

      <h3>{error}</h3>

      {details && (
        <>
          <h2>Employee Details</h2>

          <p>ID : {details.id}</p>
          <p>Name : {details.name}</p>
          <p>Department : {details.dept}</p>
          <p>Salary : {details.salary}</p>
        </>
      )}
    </div>
  );
}

export default Assignment5;