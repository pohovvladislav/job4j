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
                "C:\\projects\\job4j\\chapter_003\\src\\main\\java\\ru\\job4j\\io\\tmpdir\\file.html",
                "C:\\projects\\job4j\\chapter_003\\src\\main\\java\\ru\\job4j\\io\\tmpdir\\dir\\file.css",
                "C:\\projects\\job4j\\chapter_003\\src\\main\\java\\ru\\job4j\\io\\tmpdir\\dir\\file_2.css"
        );
        assertThat(search.files(System.getProperty("user.dir"), list).stream().map(file -> file.getAbsolutePath())
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