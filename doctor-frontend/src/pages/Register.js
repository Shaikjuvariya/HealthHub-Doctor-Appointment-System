import { useState } from "react";
import API from "../services/api";
import { useNavigate } from "react-router-dom";
import "./Register.css";

export default function Register() {

  const navigate = useNavigate();

  const [user, setUser] = useState({
    name: "",
    email: "",
    password: "",
    role: "USER"
  });

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const register = async () => {
    try {
      await API.post("/api/auth/register", user);
      alert("Registered Successfully");
      navigate("/");
    } catch {
      alert("Registration Failed");
    }
  };

  return (
    <div className="register-container">

      <div className="register-card">

        <h1 className="logo">HealthHub</h1>
        <h3 className="subtitle">Create Your Account</h3>

        <input
          name="name"
          placeholder="Full Name"
          onChange={handleChange}
        />

        <input
          name="email"
          placeholder="Email Address"
          onChange={handleChange}
        />

        <input
          name="password"
          type="password"
          placeholder="Password"
          onChange={handleChange}
        />

        <button onClick={register}>Register</button>

        <p className="login-link">
          Already have an account?
          <span onClick={() => navigate("/")}> Login</span>
        </p>

      </div>
    </div>
  );
}
