import { useState } from "react";
import API from "../services/api";
import { useNavigate } from "react-router-dom";
import "./Login.css";

export default function Login() {

  const navigate = useNavigate();

  const [user, setUser] = useState({
    email: "",
    password: ""
  });

  const [showPassword, setShowPassword] = useState(false);

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const login = async () => {
    try {
      const res = await API.post("/api/auth/login", user);
      localStorage.setItem("token", res.data);
      navigate("/home");
    } catch {
      alert("Invalid Login");
    }
  };

  return (
    <div className="login-container">

      <div className="login-card">

        <h1 className="logo">HealthHub</h1>
        <h3 className="subtitle">Welcome Back 👋</h3>

        <input
          name="email"
          placeholder="Email Address"
          onChange={handleChange}
        />

        <div className="password-box">
          <input
            name="password"
            type={showPassword ? "text" : "password"}
            placeholder="Password"
            onChange={handleChange}
          />
          <span onClick={() => setShowPassword(!showPassword)}>
            {showPassword ? "🙈" : "👁"}
          </span>
        </div>

        <button onClick={login}>Login</button>

        <p className="register">
          Don't have an account? 
          <span onClick={() => navigate("/register")}> Register</span>
        </p>

      </div>
    </div>
  );
}
