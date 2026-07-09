import { useLocation, useNavigate } from "react-router-dom";

export default function Success() {

  const location = useLocation();
  const navigate = useNavigate();

  const data = location.state;

  return (
    <div style={{ padding: "40px", textAlign: "center" }}>

      <h1 style={{ color: "green" }}>
        Appointment Confirmed
      </h1>

      {data && (
        <div style={{ marginTop: "20px" }}>
          <p><b>Name:</b> {data.fullName}</p>
          <p><b>Doctor:</b> {data.doctorName}</p>
          <p><b>Date:</b> {data.preferredDate}</p>
          <p><b>Time:</b> {data.preferredTime}</p>
        </div>
      )}

      <br/>

      <button onClick={() => navigate("/home")}>
        Go Home
      </button>

    </div>
  );
}