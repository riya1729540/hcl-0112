import { greet } from "../app.js";
import { test } from "node:test";
import assert from "node:assert";

test("greet returns the correct greeting", () => {
  const expected = `Hello, World!`;
  const actual = greet("World");

  assert.strictEqual(actual, expected);
});