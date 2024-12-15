import { motion } from 'framer-motion';
import './HomePage.css';

const HomePage = () => {
  return (
    <div className="home-container">
      <div className="gradient-overlay"></div>
      
      <main className="hero-section">
        <motion.div 
          className="brand-title-container"
          initial={{ opacity: 0 }}
          animate={{ opacity: 1 }}
          transition={{ duration: 1.5 }}
        >
          <h1 className="title-line first">
            <motion.span 
              initial={{ y: 100 }}
              animate={{ y: 0 }}
              transition={{ duration: 1, delay: 0.2 }}
              className="resin-effect"
            >
              Horizon
            </motion.span>
          </h1>
          
          <h1 className="title-line second">
            <motion.span
              initial={{ y: 100 }}
              animate={{ y: 0 }}
              transition={{ duration: 1, delay: 0.4 }}
            >
              Hair
            </motion.span>
          </h1>
          
          <h1 className="title-line third">
            <motion.span
              initial={{ y: 100 }}
              animate={{ y: 0 }}
              transition={{ duration: 1, delay: 0.6 }}
            >
              Studio
            </motion.span>
          </h1>
        </motion.div>

        <motion.div 
          className="image-grid"
          initial={{ opacity: 0, y: 50 }}
          animate={{ opacity: 1, y: 0 }}
          transition={{ duration: 1, delay: 0.8 }}
        >
          <div className="image-placeholder left">
            <span className="placeholder-text">01</span>
          </div>
          <div className="image-placeholder right">
            <span className="placeholder-text">02</span>
          </div>
        </motion.div>
      </main>
    </div>
  );
};

export default HomePage;