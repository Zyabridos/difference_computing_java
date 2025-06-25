package io.hexlet;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(
        name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference."
)
public class Application implements Runnable {

    @Option(
            names = {"-f", "--format"},
            description = "output format [default: stylish]"
    )
    private String format = "stylish";

    @Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private String filePath1;

    @Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    private String filePath2;

    @Override
    public void run() {
        // evnt Differ.generate
        System.out.println("Comparing:");
        System.out.println("  File 1: " + filePath1);
        System.out.println("  File 2: " + filePath2);
        System.out.println("  Format: " + format);

        // String result = Differ.generate(filePath1, filePath2, format);
        // System.out.println(result);
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Application()).execute(args);
        System.exit(exitCode);
    }
}
