package ru.job4j.io;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SearchTest {

    @Test
    public void searchTest() {
        Search search = new Search();
        List<String> list = Arrays.asList(".html", ".css");
        List<String> expect = Arrays.asList(
                "file_3.html",
                "file_1.css",
                "file_2.css"
        );
        assertThat(search.files(System.getProperty("user.dir"), list).stream().map(File::getName)
                .collect(Collectors.toList()), is(expect)
        );
    }

    @Test
    public void whenFileFullNameThenFileExtension() {
        Search search = new Search();
        File file = new File("job4j.txt");
        assertThat(search.extension(file), is(".txt"));
    }
}