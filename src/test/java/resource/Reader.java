package resource;

import java.nio.file.Files;
import java.nio.file.Paths;
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
}
