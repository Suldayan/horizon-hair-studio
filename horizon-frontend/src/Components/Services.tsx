import { motion, AnimatePresence } from 'framer-motion';
import { useState } from 'react';
import './Services.css';

interface ServiceItem {
  id: number;
  title: string;
  description: string;
  image: string;
  price?: string;
}

const serviceData: ServiceItem[] = [
  { id: 1, title: "Classic Cut", description: "Traditional barbering at its finest.", image: "/path-to-image.jpg", price: "$30" },
  { id: 2, title: "Deluxe Trim", description: "A precise trim with modern techniques.", image: "/path-to-image2.jpg", price: "$45" },
  { id: 3, title: "Beard Styling", description: "Custom beard shaping and care.", image: "/path-to-image3.jpg", price: "$25" },
  { id: 4, title: "Hot Towel Shave", description: "Experience luxury with a smooth shave.", image: "/path-to-image4.jpg", price: "$40" },
  { id: 5, title: "Scalp Massage", description: "Relaxing and rejuvenating scalp care.", image: "/path-to-image5.jpg", price: "$35" },
];

const Services = () => {
  const [selectedId, setSelectedId] = useState<number>(1);
  const selectedService = serviceData.find(service => service.id === selectedId);

  return (
    <div className="services-container">
      {/* Left Section: Cards */}
      <div className="left-section">
        {serviceData.map((service, index) => (
          <motion.div
            key={service.id}
            className={`service-card ${selectedId === service.id ? 'selected' : ''}`}
            onClick={() => setSelectedId(service.id)}
            whileHover={{ scale: 1.05 }}
            initial={{ opacity: 0 }}
            animate={{ opacity: 1, transition: { delay: index * 0.1 } }}
          >
            <div className="service-number">{String(index + 1).padStart(2, '0')}</div>
            <h3>{service.title}</h3>
          </motion.div>
        ))}
      </div>

      {/* Right Section: Dynamic Content */}
      <div className="right-section">
        <AnimatePresence mode="wait">
          <motion.div
            key={selectedService?.id}
            initial={{ opacity: 0, x: 50 }}
            animate={{ opacity: 1, x: 0 }}
            exit={{ opacity: 0, x: -50 }}
            transition={{ duration: 0.5 }}
          >
            <h1>{selectedService?.title}</h1>
            <p>{selectedService?.description}</p>
            <div className="price">{selectedService?.price}</div>
          </motion.div>
        </AnimatePresence>
      </div>
    </div>
  );
};

export default Services;
