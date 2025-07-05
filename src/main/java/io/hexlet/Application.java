package io.hexlet;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.Map;

import io.hexlet.Parser;

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
        try {
            Map<String, Object> data1 = Parser.parse(filePath1);
            Map<String, Object> data2 = Parser.parse(filePath2);

            System.out.println("Comparing:");
            System.out.println("  File 1: " + filePath1);
            System.out.println("  File 2: " + filePath2);
            System.out.println("  Format: " + format);
            System.out.println("------------");

            data1.keySet().forEach(key -> {
                if (!data2.containsKey(key)) {
                    System.out.println("Key '" + key + "' removed");
                } else if (!data1.get(key).equals(data2.get(key))) {
                    System.out.println("Key '" + key + "' changed from '" + data1.get(key) + "' to '" + data2.get(key) + "'");
                }
            });

            data2.keySet().stream()
                    .filter(key -> !data1.containsKey(key))
                    .forEach(key -> System.out.println("Key '" + key + "' added with value '" + data2.get(key) + "'"));

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Application()).execute(args);
        System.exit(exitCode);
    }
}
