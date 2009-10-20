package am.ik.brainfuck;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;

public class TestBFInterpreter extends TestCase {
    /**
     * A
     */
    public static final String A = "++++++++[>++++++++<-]>+.";
    /**
     * HelloWorld
     */
    public static final String HELLO_WORLD = "++++++++[>+++++++++<-]>.<+++++[>++++++<-]>-.<++[>+++<-]>+..+"
            + "++.<++++++[>----<-]>.<++++++[>++++<-]>.+++.------.--------.";
    /**
     * hoge
     */
    public static final String HOGE = "++++++++++[>++++++++++<-]>++++.+++++++.--------.--.";
    public static final String FIZZ_BUZZ = "++++++[->++++> >+>+>-<<<<<]>[<++++> >+++>++++> >+++>+++++>++"
            + "+++> > > > > >++> >++<<<<<<<<<<<<<<-]<++++>+++>-->+++>-> >--"
            + "->++> > >+++++[->++>++<<]<<<<<<<<<<[->-[> > > > > > >]>[<+++"
            + ">.>.> > > >..> > >+<]<<<<<-[> > > >]>[<+++++>.>.>..> > >+<]>"
            + " > > >+<-[<<<]<[[-<<+> >]> > >+>+<<<<<<[-> >+>+>-<<<<]<]>>[["
            + "-]<]>[> > >[>.<<.<<<]<[.<<<<]>]>.<<<<<<<<<<<]";

    private ByteArrayOutputStream baos;
    private PrintStream out;

    @Override
    protected void setUp() throws Exception {
        out = System.out;
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(baos)));

    }

    protected void assertEquals(String expectedString,
            ByteArrayOutputStream stream) {
        System.out.flush();
        assertEquals(expectedString, stream.toString());
    }

    public void testA() throws Exception {
        BFInterpreter interpreter = new BFInterpreter(A);
        interpreter.eval();
        assertEquals("A", baos);
    }

    public void testHelloWorld() throws Exception {
        BFInterpreter interpreter = new BFInterpreter(HELLO_WORLD);
        interpreter.eval();
        assertEquals("HelloWorld", baos);
    }

    public void testHoge() throws Exception {
        BFInterpreter interpreter = new BFInterpreter(HOGE);
        interpreter.eval();
        assertEquals("hoge", baos);
    }

    public void testFizzBuzz() throws Exception {
        // BFInterpreter interpreter = new BFInterpreter(FIZZ_BUZZ);
        // interpreter.eval();
    }

    @Override
    protected void tearDown() throws Exception {
        System.setOut(out);
    }

}
