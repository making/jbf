package am.ik.brainfuck;

import junit.framework.TestCase;

public class TestBFEnvironment extends TestCase {
    private BFEnvironment env;

    @Override
    protected void setUp() throws Exception {
        env = new BFEnvironment("abcd", 10);
    }

    public void testPointer() {
        env.incrementPointer();
        assertEquals(1, env.getPointer());
        env.decrementPointer();
        assertEquals(0, env.getPointer());
    }

    public void testValue() {
        env.incrementValue();
        assertEquals(1, env.getValue());
        env.incrementPointer();
        env.setValue(10);
        env.decrementValue();
        assertEquals(9, env.getValue());
        env.setValue(0);
        env.decrementPointer();
        env.decrementValue();
    }

    @Override
    protected void tearDown() throws Exception {
    }
}
