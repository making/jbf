package am.ik.brainfuck.servlet;

import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import am.ik.brainfuck.BFInterpreter;
import am.ik.brainfuck.util.FileUtil;

@SuppressWarnings("serial")
public class BrainfuckServlet extends HttpServlet {
    private static final String BF_DIR_KEY = "brainfuck.dir";
    private static final String ENCODING_KEY = "encoding";
    private String bfDir;
    private String encoding;

    @Override
    public void init(ServletConfig config) throws ServletException {
        bfDir = config.getInitParameter(BF_DIR_KEY);
        if (bfDir == null) {
            bfDir = "";
        }
        encoding = config.getInitParameter(ENCODING_KEY);
        if (encoding == null) {
            encoding = "UTF-8";
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String path = req.getServletPath();
        String source = FileUtil.slurp(getClass().getResourceAsStream(
                bfDir + path));
        BFInterpreter interpreter = new BFInterpreter(source);
        PrintStream stream = new PrintStream(res.getOutputStream());
        interpreter.setOut(stream);
        interpreter.eval();
        stream.flush();
    }
}
