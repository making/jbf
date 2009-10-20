package am.ik.brainfuck;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import junit.framework.TestCase;
import am.ik.brainfuck.scripting.BrainfuckScriptEngine;

public class TestBraifuckScriptEngine extends TestCase {

    @Override
    protected void setUp() throws Exception {
    }

    public void testGetEngineByName() throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        for (String name : new String[] { "Brainfuck", "Brainf*ck",
                "BrainFuck", "BrainF*ck", "brainfuck", "brainf*ck", "bf" }) {
            ScriptEngine engine = manager.getEngineByName(name);
            assertEquals(engine.getClass(), BrainfuckScriptEngine.class);
        }
    }

    public void testGetEngineByExtension() throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        for (String extension : new String[] { "bf" }) {
            ScriptEngine engine = manager.getEngineByExtension(extension);
            assertEquals(engine.getClass(), BrainfuckScriptEngine.class);
        }
    }

    @Override
    protected void tearDown() throws Exception {
    }

}
