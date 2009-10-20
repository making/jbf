package am.ik.brainfuck;

import java.io.IOException;

public enum BFProcessor {
    /**
     * &gt;
     */
    INCREMENT_POINTER {
        @Override
        public void process(BFEnvironment env) {
            env.incrementPointer();
        }
    },
    /**
     * &lt;
     */
    DECREMENT_POINTER {
        @Override
        public void process(BFEnvironment env) {
            env.decrementPointer();
        }
    },
    /**
     * +
     */
    INCREMENT_VALUE {
        @Override
        public void process(BFEnvironment env) {
            env.incrementValue();
        }
    },
    /**
     * -
     */
    DECREMENT_VALUE {
        @Override
        public void process(BFEnvironment env) {
            env.decrementValue();
        }
    },
    /**
     * .
     */
    WRITE_VALUE {
        @Override
        public void process(BFEnvironment env) {
            env.getOut().print((char) env.getValue());
        }
    },
    /**
     * ,
     */
    READ_VALUE {
        @Override
        public void process(BFEnvironment env) {
            try {
                env.setValue(env.getIn().read());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    },
    /**
     * [
     */
    FORWARD {
        @Override
        public void process(BFEnvironment env) {
            if (env.getValue() == 0) {
                env.incrementCurrent();
                for (int brackets = 1; brackets > 0; env.incrementCurrent()) {
                    switch (env.getChar()) {
                    case '[':
                        brackets++;
                        break;
                    case ']':
                        brackets--;
                        break;
                    default:
                        break;
                    }
                }
                env.decrementCurrent();
            }
        }
    },
    /**
     * ]
     */
    BACKWARD {
        @Override
        public void process(BFEnvironment env) {
            if (env.getValue() != 0) {
                env.decrementCurrent();
                for (int brackets = 1; brackets > 0; env.decrementCurrent()) {
                    switch (env.getChar()) {
                    case '[':
                        brackets--;
                        break;
                    case ']':
                        brackets++;
                        break;
                    default:
                        break;
                    }
                }
                env.incrementCurrent();
            }
        }
    };

    abstract public void process(BFEnvironment env);
}
