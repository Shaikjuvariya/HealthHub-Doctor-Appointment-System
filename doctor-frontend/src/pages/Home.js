import { useNavigate } from "react-router-dom";
import "./Home.css";

export default function Home() {

  const navigate = useNavigate();

  return (
    <div className="home-container">

      <div className="header">
        <h1>Welcome to HealthHub</h1>
      </div>

      <div className="content">
        <h2>Your Health, Our Priority</h2>

        <p>
          HealthHub is your trusted platform for booking doctor appointments with ease.
          Choose from our list of specialized doctors, manage your appointments,
          and get the care you deserve — all in one place.
        </p>

        <div className="buttons">
          <button onClick={() => navigate("/doctors")}>
            View Doctors
          </button>

          <button onClick={() => navigate("/book")}>
            Book Appointment
          </button>

          <button>
            Contact Us
          </button>
        </div>
      </div>

      <div className="footer">
        © 2025 HealthHub | All Rights Reserved
      </div>

    </div>
  );
}