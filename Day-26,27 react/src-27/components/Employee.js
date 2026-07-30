function Employee(props) {
  return (
    <div>
      <h2>Employee Details</h2>

      <p>Employee ID : {props.id}</p>
      <p>Name : {props.name}</p>
      <p>Department : {props.department}</p>
      <p>Designation : {props.designation}</p>
      <p>Salary : {props.salary}</p>
    </div>
  );
}

export default Employee;