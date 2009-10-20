package am.ik.brainfuck.scripting;

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

	@Override
	public Bindings createBindings() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object eval(String script, ScriptContext context)
			throws ScriptException {
		try {
			BFInterpreter interpreter = new BFInterpreter(script);
			interpreter.eval();
		} catch (Exception e) {
			throw new ScriptException(e);
		}

		return null;
	}

	@Override
	public Object eval(Reader reader, ScriptContext context)
			throws ScriptException {
		throw new UnsupportedOperationException();
	}

	@Override
	public ScriptEngineFactory getFactory() {
		throw new UnsupportedOperationException();
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
