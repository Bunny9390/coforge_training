// import './App.css';
// import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';
// import HomeComp from './30/HomeComp';
// import AboutComp from './30/AboutComp';
// import ContactComp from './30/ContactComp';

// function App() {
//   return (
//     <BrowserRouter>
//       <div>
//         <nav>
//           <Link to="/">Home</Link> | <Link to="/about">About</Link> |{' '}
//           <Link to="/contact">Contact</Link>
//         </nav>

//         <hr />

//         <Routes>
//           <Route path="/" element={<HomeComp />} />
//           <Route path="/about" element={<AboutComp />} />
//           <Route path="/contact" element={<ContactComp />} />
//         </Routes>
//       </div>
//     </BrowserRouter>
//   );
// }
import { useState } from "react";
import HomeComp from "./30/HomeComp";
import AboutComp from "./30/AboutComp";
import ContactComp from "./30/ContactComp";

function App() {
  const [page, setPage] = useState("home");

  return (
    <div>
      <nav>
        <button onClick={() => setPage("home")}>Home</button>
        <button onClick={() => setPage("about")}>About</button>
        <button onClick={() => setPage("contact")}>Contact</button>
      </nav>

      <hr />

      {page === "home" && <HomeComp />}
      {page === "about" && <AboutComp />}
      {page === "contact" && <ContactComp />}
    </div>
  );
}

export default App;


// export default App;