import { useEffect, useState } from "react";
import API from "../services/api";
import { useNavigate } from "react-router-dom";
import "./Doctors.css";

export default function Doctors() {

  const [doctors, setDoctors] = useState([]);
  const [showForm, setShowForm] = useState(false);

  const [newDoctor, setNewDoctor] = useState({
    name: "",
    specialization: "",
    email: "",
    phone: ""
  });

  const navigate = useNavigate();

  useEffect(() => {
    loadDoctors();
  }, []);

  const loadDoctors = () => {
    API.get("/api/doctors")
      .then(res => setDoctors(res.data));
  };

  const handleChange = (e) => {
    setNewDoctor({
      ...newDoctor,
      [e.target.name]: e.target.value
    });
  };

  const addDoctor = async () => {
    await API.post("/api/doctors", newDoctor);
    setShowForm(false);
    loadDoctors();
  };

  return (
    <div className="doctors-container">

      <div className="doctors-header">
        <h1>Our Specialized Doctors</h1>

        <button
          className="add-btn"
          onClick={() => setShowForm(!showForm)}
        >
          + Add Doctor
        </button>
      </div>

      {showForm && (
        <div className="add-form">
          <input
            name="name"
            placeholder="Doctor Name"
            onChange={handleChange}
          />
          <input
            name="specialization"
            placeholder="Specialization"
            onChange={handleChange}
          />
          <input
            name="email"
            placeholder="Email"
            onChange={handleChange}
          />
          <input
            name="phone"
            placeholder="Phone"
            onChange={handleChange}
          />

          <button onClick={addDoctor}>Save Doctor</button>
        </div>
      )}

      <h2 className="subtitle">Meet Our Expert Team</h2>

      <div className="doctor-grid">
        {doctors.map((doc) => (
          <div className="doctor-card" key={doc.id}>

            <h3>{doc.name}</h3>
            <p className="spec">{doc.specialization}</p>
            <p>{doc.email}</p>
            <p>{doc.phone}</p>

            <button
              onClick={() =>
                navigate("/book", { state: doc })
              }
            >
              Book Appointment
            </button>

          </div>
        ))}
      </div>
    </div>
  );
}