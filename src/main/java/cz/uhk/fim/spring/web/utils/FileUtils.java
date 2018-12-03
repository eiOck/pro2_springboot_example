package cz.uhk.fim.spring.web.utils;

import cz.uhk.fim.spring.web.model.RSSSource;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static String loadStringFromFile(File file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(file.getPath())));
    }

    public static List<RSSSource> loadSources() throws IOException {
        List<RSSSource> sources = new ArrayList<>();
        new BufferedReader(new StringReader(loadStringFromFile(ResourceUtils.getFile("classpath:static/sources.cfg"))))
                .lines().forEach(line -> {
            String[] sourceData = line.split(";");
            sources.add(new RSSSource(sourceData[0], sourceData[1]));

        });
        return sources;
    }


}
