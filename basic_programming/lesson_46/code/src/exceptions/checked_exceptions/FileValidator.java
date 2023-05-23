package checked_exceptions;

import java.io.IOException;

public class FileValidator {
    public static void validate(String fileName) throws IOException {
        if (fileName == null) {
            throw new IOException();
        }
    }
}
