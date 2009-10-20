package am.ik.brainfuck;

import static am.ik.brainfuck.BFProcessor.BACKWARD;
import static am.ik.brainfuck.BFProcessor.DECREMENT_POINTER;
import static am.ik.brainfuck.BFProcessor.DECREMENT_VALUE;
import static am.ik.brainfuck.BFProcessor.FORWARD;
import static am.ik.brainfuck.BFProcessor.INCREMENT_POINTER;
import static am.ik.brainfuck.BFProcessor.INCREMENT_VALUE;
import static am.ik.brainfuck.BFProcessor.READ_VALUE;
import static am.ik.brainfuck.BFProcessor.WRITE_VALUE;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class BFInterpreter {
    public static final int MEMORY_SIZE = 1024;
    private final BFEnvironment env;
    private final static Map<Character, BFProcessor> PROCESSOR_MAP;

    static {
        PROCESSOR_MAP = new HashMap<Character, BFProcessor>();
        PROCESSOR_MAP.put('>', INCREMENT_POINTER);
        PROCESSOR_MAP.put('<', DECREMENT_POINTER);
        PROCESSOR_MAP.put('+', INCREMENT_VALUE);
        PROCESSOR_MAP.put('-', DECREMENT_VALUE);
        PROCESSOR_MAP.put('.', WRITE_VALUE);
        PROCESSOR_MAP.put(',', READ_VALUE);
        PROCESSOR_MAP.put('[', FORWARD);
        PROCESSOR_MAP.put(']', BACKWARD);
    }

    public BFInterpreter(String source) {
        env = new BFEnvironment(source, MEMORY_SIZE);
    }

    public void eval() {
        while (env.hasChar()) {
            char c = env.getChar();
            if (PROCESSOR_MAP.containsKey(c)) {
                PROCESSOR_MAP.get(c).process(env);
            }
            env.incrementCurrent();
        }
    }

    public void setIn(InputStream in) {
        env.setIn(in);
    }

    public void setOut(PrintStream out) {
        env.setOut(out);
    }
}
