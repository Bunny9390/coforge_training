import { useState } from "react";

function Assignment3() {
  const [student, setStudent] = useState({
    name: "",
    age: "",
    gender: "",
    course: "",
    city: "",
  });

  const [details, setDetails] = useState(null);

  return (
    <div>
      <h1>Student Registration</h1>

      <input
        type="text"
        placeholder="Name"
        onChange={(event) =>
          setStudent({ ...student, name: event.target.value })
        }
      />
      <br /><br />

      <input
        type="number"
        placeholder="Age"
        onChange={(e) =>
          setStudent({ ...student, age: e.target.value })
        }
      />
      <br /><br />

      <input
        type="text"
        placeholder="Gender"
        onChange={(e) =>
          setStudent({ ...student, gender: e.target.value })
        }
      />
      <br /><br />

      <input
        type="text"
        placeholder="Course"
        onChange={(e) =>
          setStudent({ ...student, course: e.target.value })
        }
      />
      <br /><br />

      <input
        type="text"
        placeholder="City"
        onChange={(e) =>
          setStudent({ ...student, city: e.target.value })
        }
      />
      <br /><br />

      <button onClick={() => setDetails(student)}>Submit</button>

      {details && (
        <>
          <h2>Student Details</h2>

          <p>Name : {details.name}</p>
          <p>Age : {details.age}</p>
          <p>Gender : {details.gender}</p>
          <p>Course : {details.course}</p>
          <p>City : {details.city}</p>
        </>
      )}
    </div>
  );
}

export default Assignment3;