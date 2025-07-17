import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;

public class Main {
    public static void main(String[] args) throws Exception {
        Terminal terminal = TerminalBuilder.terminal();
        LineReader reader = LineReaderBuilder.builder()
                .terminal(terminal)
                .build();
        String line;
        while ((line = reader.readLine("Nhập (hiển thị *): ", '*')) != null) {
            System.out.println("Bạn đã nhập: " + line);
            if (line.equalsIgnoreCase("exit")) {
                break;
            }
        }
    }
}