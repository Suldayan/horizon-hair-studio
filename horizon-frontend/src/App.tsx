import React from 'react';
import HomePage from './Components/HomePage';
import Navbar from './Components/Navbar';
import Services from './Components/Services';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

const App: React.FC = () => {
  return (
    <Router>
    
      <Routes>
        <Route path='/' element={<HomePage />} />
        <Route path='/services' element={<Services />}/>
      </Routes>
    </Router>
  )
}

export default App;
