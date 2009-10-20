package am.ik.brainfuck.scripting;

import java.util.Arrays;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;

public class BrainfuckScriptEngineFactory implements ScriptEngineFactory {
    private static final BrainfuckScriptEngine ENGINE = new BrainfuckScriptEngine();
    private static final List<String> NAMES = Arrays.asList("Brainfuck",
            "Brainf*ck", "BrainFuck", "BrainF*ck", "brainfuck", "brainf*ck",
            "bf");
    private static final List<String> EXTENSIONS = Arrays.asList("bf");

    @Override
    public String getEngineName() {
        return "Brainf*ck script";
    }

    @Override
    public String getEngineVersion() {
        return "0.1";
    }

    @Override
    public List<String> getExtensions() {
        return EXTENSIONS;
    }

    @Override
    public String getLanguageName() {
        return "Brainfuck";
    }

    @Override
    public String getLanguageVersion() {
        return "??";
    }

    @Override
    public String getMethodCallSyntax(String obj, String m, String... args) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> getMimeTypes() {
        return Arrays.asList();
    }

    @Override
    public List<String> getNames() {
        return NAMES;
    }

    @Override
    public String getOutputStatement(String toDisplay) {
        return toDisplay;
    }

    @Override
    public Object getParameter(String key) {
        return null;
    }

    @Override
    public String getProgram(String... statements) {
        StringBuilder sb = new StringBuilder();
        for (String statement : statements) {
            sb.append(statement);
        }
        return sb.toString();
    }

    @Override
    public ScriptEngine getScriptEngine() {
        return ENGINE;
    }

}
