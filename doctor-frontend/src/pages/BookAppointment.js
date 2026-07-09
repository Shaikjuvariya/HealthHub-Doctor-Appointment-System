import { useState, useEffect } from "react";
import API from "../services/api";
import { useNavigate } from "react-router-dom";
import "./BookAppointment.css";

export default function BookAppointment() {

  const navigate = useNavigate();

  const [doctors, setDoctors] = useState([]);

  const [form, setForm] = useState({
    fullName: "",
    email: "",
    phone: "",
    doctorId: "",
    doctorName: "",
    preferredDate: "",
    preferredTime: "",
    notes: ""
  });

  useEffect(() => {
    API.get("/api/doctors")
      .then(res => setDoctors(res.data));
  }, []);

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleDoctorSelect = (e) => {
    const selected = doctors.find(d => d.id == e.target.value);

    setForm({
      ...form,
      doctorId: selected.id,
      doctorName: selected.name
    });
  };

  const bookAppointment = async () => {
    await API.post("/api/appointments/book", form);
    navigate("/success", { state: form });
  };

  return (
    <div className="booking-container">

      {/* LEFT PANEL */}
      <div className="left-panel">

        <h1>Welcome to HealthHub</h1>

        <p>
          Your health is our top priority. Book your appointment in just a few clicks
          and get the care you deserve — from the best doctors around the world.
        </p>

        <img
          src="https://cdn-icons-png.flaticon.com/512/4320/4320371.png"
          alt="doctor"
          className="doctor-icon"
        />

      </div>

      {/* RIGHT PANEL */}
      <div className="right-panel">

        <div className="form-card">

          <h2>Book Appointment</h2>

          <label>Full Name</label>
          <input name="fullName" onChange={handleChange} />

          <label>Email</label>
          <input name="email" onChange={handleChange} />

          <label>Phone Number</label>
          <input name="phone" onChange={handleChange} />

          <label>Select Doctor</label>
          <select onChange={handleDoctorSelect}>
            <option>-- Choose Doctor --</option>
            {doctors.map(doc => (
              <option key={doc.id} value={doc.id}>
                {doc.name} ({doc.specialization})
              </option>
            ))}
          </select>

          <label>Preferred Date</label>
          <input type="date" name="preferredDate" onChange={handleChange} />

          <label>Preferred Time</label>
          <input type="time" name="preferredTime" onChange={handleChange} />

          <label>Additional Notes</label>
          <textarea name="notes" onChange={handleChange} />

          <button onClick={bookAppointment}>
            Confirm Appointment
          </button>

        </div>
      </div>
    </div>
  );
}