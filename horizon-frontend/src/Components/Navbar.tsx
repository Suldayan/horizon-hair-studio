import { motion } from 'framer-motion';
import './Navbar.css';

const Navbar = () => {
  return (
    <motion.nav 
      className="navbar-container"
      initial={{ x: -100, opacity: 0 }}
      animate={{ x: 0, opacity: 1 }}
      transition={{ duration: 0.8 }}
    >
      <div className="nav-content">
        <motion.div 
          className="navbar-logo"
          whileHover={{ scale: 1.05 }}
        >
          H
        </motion.div>
        
        <ul className="navbar-links">
          <motion.li 
            whileHover={{ x: 10 }}
            transition={{ type: "spring", stiffness: 300 }}
          >
            Home
          </motion.li>
          <motion.li 
            whileHover={{ x: 10 }}
            transition={{ type: "spring", stiffness: 300 }}
          >
            Services
          </motion.li>
          <motion.li 
            whileHover={{ x: 10 }}
            transition={{ type: "spring", stiffness: 300 }}
          >
            Gallery
          </motion.li>
          <motion.li 
            whileHover={{ x: 10 }}
            transition={{ type: "spring", stiffness: 300 }}
          >
            About
          </motion.li>
          <motion.li 
            className="booking-link"
            whileHover={{ x: 10 }}
            transition={{ type: "spring", stiffness: 300 }}
          >
            Book Now
          </motion.li>
        </ul>

        <div className="nav-footer">
          <span>© 2024</span>
        </div>
      </div>
    </motion.nav>
  );
};

export default Navbar;