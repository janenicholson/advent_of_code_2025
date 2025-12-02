package resource;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;
import lombok.Data;
import lombok.SneakyThrows;

@Data
public class Reader {

    private final Class clazz;

    @SneakyThrows
    public Stream<String> getResource(String fileName) {
        return Files.lines(Paths.get(clazz.getResource(fileName).toURI()));
    }

    public Stream<String> getResourceAsCsv(String fileName) {
        return getResource(fileName)
                .flatMap(string -> Arrays.stream(string.split(",")));
    }
}
