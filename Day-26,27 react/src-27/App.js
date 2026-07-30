import './App.css';

import Welcome from "./components/Welcome";
import Student from "./components/Student";
import Employee from "./components/Employee";
import Product from "./components/Product";

function App() {
  return (
    <div>

      <Welcome />

      <hr />

      <Student
        name="Rahul"
        course="React"
        age="22"
        city="Bangalore"
      />

      <hr />

      <Employee
        id="101"
        name="Rahul"
        department="IT"
        designation="Software Engineer"
        salary="65000"
      />

      <hr />

      <h2>Products</h2>

      <Product
        name="Laptop"
        price="850"
        brand="Dell"
        rating="4.5"
        stock="In Stock"
      />

      <Product
        name="Mobile"
        price="600"
        brand="Samsung"
        rating="4.3"
        stock="Out of Stock"
      />

      <Product
        name="Headphones"
        price="120"
        brand="Sony"
        rating="4.8"
        stock="In Stock"
      />

    </div>
  );
}

export default App;