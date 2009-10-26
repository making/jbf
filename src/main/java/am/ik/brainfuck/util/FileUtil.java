package am.ik.brainfuck.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtil {
    public static String slurp(InputStream in) throws IOException {
        StringBuilder out = new StringBuilder();
        byte[] b = new byte[4096];
        for (int n; (n = in.read(b)) != -1;) {
            out.append(new String(b, 0, n));
        }
        return out.toString();
    }

    public static String slurp(String fileName) throws IOException {
        return slurp(new FileInputStream(fileName));
    }

    public static String slurp(File file) throws IOException {
        return slurp(new FileInputStream(file));
    }
}
