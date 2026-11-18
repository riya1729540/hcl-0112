import { useEffect, useState } from "react";
import api from "./Api";
import AuthForm from "./Authform";
import PostForm from "./Postform";

const App = () => {
  const [user, setUser] = useState(localStorage.getItem("username"));
  const [posts, setPosts] = useState([]);

  const loadPosts = async () => {
    const { data } = await api.get("/posts");
    setPosts(data);
  };
  useEffect(() => {
    loadPosts();
  }, []);

  const logout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("username");
    setUser(null);
  };

  return (
    <div className="min-h-screen bg-slate-50 text-slate-900">
  {/* Header */}
  <header className="sticky top-0 z-10 border-b border-slate-200 bg-white/80 backdrop-blur">
    <div className="mx-auto flex max-w-4xl items-center justify-between px-4 py-4 sm:px-6">
      <h1 className="text-xl font-bold tracking-tight text-indigo-600 sm:text-2xl">
        JWT Blog Demo
      </h1>

      {user && (
        <button
          onClick={logout}
          className="rounded-lg border border-slate-300 bg-white px-3.5 py-1.5 text-sm font-medium text-slate-700 shadow-sm transition hover:bg-slate-50 hover:text-red-600 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2"
        >
          Logout
        </button>
      )}
    </div>
  </header>

  <main className="mx-auto max-w-4xl space-y-10 px-4 py-8 sm:px-6">
    {/* Authentication and Post Form */}
    <section className="rounded-xl border border-slate-200 bg-white p-6 shadow-sm">
      {user ? (
        <div className="space-y-4">
          <div className="flex items-center gap-2 border-b border-slate-100 pb-3 text-sm text-slate-600">
            <span className="inline-block h-2 w-2 rounded-full bg-emerald-500" />
            <p>
              Logged in as <span className="font-semibold text-slate-900">{user}</span>
            </p>
          </div>

          <PostForm onCreated={loadPosts} />
        </div>
      ) : (
        <AuthForm onLogin={setUser} />
      )}
    </section>

    {/* All Posts */}
    <section className="space-y-6">
      <div className="flex items-center justify-between border-b border-slate-200 pb-3">
        <h2 className="text-lg font-semibold text-slate-900 sm:text-xl">
          All Posts
        </h2>

        <span className="rounded-full bg-indigo-50 px-3 py-1 text-xs font-medium text-indigo-700">
          {posts.length} {posts.length === 1 ? "Post" : "Posts"}
        </span>
      </div>

      {posts.length === 0 && (
        <div className="rounded-xl border border-dashed border-slate-300 bg-white p-12 text-center">
          <p className="text-sm text-slate-500">
            No posts yet. Be the first to publish one!
          </p>
        </div>
      )}

      <div className="space-y-4">
        {posts.map((p) => (
          <article
            key={p.id}
            className="rounded-xl border border-slate-200 bg-white p-6 shadow-sm transition hover:border-slate-300 hover:shadow-md"
          >
            <h2 className="text-lg font-semibold text-slate-900 sm:text-xl">
              {p.title}
            </h2>

            <p className="mt-2 whitespace-pre-line leading-relaxed text-slate-600">
              {p.content}
            </p>

            <div className="mt-4 flex flex-wrap items-center justify-between gap-2 border-t border-slate-100 pt-3 text-xs text-slate-500">
              <span>
                By <span className="font-medium text-slate-700">{p.author}</span>
              </span>

              <time dateTime={p.createdAt}>
                {new Date(p.createdAt).toLocaleString()}
              </time>
            </div>
          </article>
        ))}
      </div>
    </section>
  </main>
</div>
  );
};
export default App;