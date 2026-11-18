import api from "./Api";
import SubmitButton from "./SubmitButton";
import { useState, useActionState } from "react";

const AuthForm = ({ onLogin }) => {
  const [mode, setMode] = useState("login");
  const submitAction = async (prevState, formData) => {
    const username = formData.get("username")?.trim();
    const password = formData.get("password")?.trim();

    if (!username || !password) {
      return {
        error: "username and password is required",
        msg: "",
        username: username || "",
      };
    }
    try {
      if (mode == "register") {
        await api.post("/auth/register", { username, password });
        setMode("login");
        return {
          error: null,
          msg: "user registered successfully",
          username,
        };
      }
      // login mode
      const { data } = await api.post("/auth/login", { username, password });
      localStorage.setItem("token", data.token);
      localStorage.setItem("username", username);
      onLogin(username);
      return {
        error: null,
        msg: "",
        username: data.username,
      };
    } catch (error) {
      return {
        error:
          error.response?.data?.error ||
          error.response?.dta?.message ||
          "Something went wrong. Please try again.",
        msg: "",
        username,
      };
    }
  };
  const [state, formAction, isPending] = useActionState(submitAction, {
    error: null,
    msg: "",
    username: "",
  });
  return (
    <form action={formAction} className="space-y-5">
  <h3 className="text-xl font-bold tracking-tight text-slate-900">
    {mode === "login" ? "Welcome Back" : "Create an Account"}
  </h3>

  <div className="space-y-4">
    <div>
      <label htmlFor="username" className="block text-xs font-medium uppercase tracking-wider text-slate-600 mb-1">
        Username
      </label>
      <input
        type="text"
        name="username"
        id="username"
        placeholder="Enter your username"
        defaultValue={state.username}
        required
        disabled={isPending}
        className="w-full rounded-lg border border-slate-300 bg-white px-3.5 py-2.5 text-sm text-slate-900 shadow-sm placeholder:text-slate-400 focus:border-indigo-500 focus:outline-none focus:ring-2 focus:ring-indigo-500/20 disabled:cursor-not-allowed disabled:bg-slate-50 disabled:text-slate-500"
      />
    </div>

    <div>
      <label htmlFor="password" className="block text-xs font-medium uppercase tracking-wider text-slate-600 mb-1">
        Password
      </label>
      <input
        type="password"
        name="password"
        id="password"
        placeholder="••••••••"
        required
        disabled={isPending}
        className="w-full rounded-lg border border-slate-300 bg-white px-3.5 py-2.5 text-sm text-slate-900 shadow-sm placeholder:text-slate-400 focus:border-indigo-500 focus:outline-none focus:ring-2 focus:ring-indigo-500/20 disabled:cursor-not-allowed disabled:bg-slate-50 disabled:text-slate-500"
      />
    </div>
  </div>

  <div className="space-y-3 pt-2">
    <SubmitButton />

    <button
      type="button"
      disabled={isPending}
      onClick={() => {
        setMode(mode === "login" ? "register" : "login");
      }}
      className="w-full text-center text-sm font-medium text-indigo-600 transition hover:text-indigo-500 disabled:opacity-50"
    >
      {mode === "login"
        ? "Don't have an account? Register"
        : "Already have an account? Login"}
    </button>
  </div>

  {state.msg && (
    <p role="status" className="rounded-lg bg-emerald-50 p-3 text-sm text-emerald-700 border border-emerald-200">
      {state.msg}
    </p>
  )}

  {state.error && (
    <p role="status" className="rounded-lg bg-red-50 p-3 text-sm text-red-600 border border-red-200">
      {state.error}
    </p>
  )}
</form>
  );
};

export default AuthForm;