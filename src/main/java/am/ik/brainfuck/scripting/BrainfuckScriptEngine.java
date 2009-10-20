package am.ik.brainfuck.scripting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.Reader;

import javax.script.AbstractScriptEngine;
import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptContext;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptException;

import am.ik.brainfuck.BFInterpreter;

public class BrainfuckScriptEngine extends AbstractScriptEngine implements
		Compilable {
	private static InputStream in = System.in;
	private static PrintStream out = System.out;

	public static synchronized void setIn(InputStream in) {
		BrainfuckScriptEngine.in = in;
	}

	public static synchronized void setOut(PrintStream out) {
		BrainfuckScriptEngine.out = out;
	}

	@Override
	public Bindings createBindings() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object eval(String script, ScriptContext context)
			throws ScriptException {
		try {
			BFInterpreter interpreter = new BFInterpreter(script);
			synchronized (BrainfuckScriptEngine.class) {
				interpreter.setIn(in);
				interpreter.setOut(out);
			}
			interpreter.eval();
		} catch (Exception e) {
			throw new ScriptException(e);
		}

		return null;
	}

	@Override
	public Object eval(Reader reader, ScriptContext context)
			throws ScriptException {
		BufferedReader buffer = new BufferedReader(reader);
		StringBuilder builder = new StringBuilder();
		try {
			String line = null;
			while ((line = buffer.readLine()) != null) {
				builder.append(line);
			}
		} catch (IOException e) {
			throw new ScriptException(e);
		}
		return eval(buffer.toString(), context);
	}

	@Override
	public ScriptEngineFactory getFactory() {
		return new BrainfuckScriptEngineFactory();
	}

	@Override
	public CompiledScript compile(String script) throws ScriptException {
		throw new UnsupportedOperationException();
	}

	@Override
	public CompiledScript compile(Reader script) throws ScriptException {
		throw new UnsupportedOperationException();
	}

}
