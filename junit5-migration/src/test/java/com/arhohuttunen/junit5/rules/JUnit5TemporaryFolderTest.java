package com.arhohuttunen.junit5.rules;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@EnableRuleMigrationSupport
class JUnit5TemporaryFolderTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @TempDir
    Path temporaryDirectory;

    @Test
    void shouldCreateNewFileWithRule() throws IOException {
        File textFile = temporaryFolder.newFile("test.txt");
        Assertions.assertNotNull(textFile);
    }

    @Test
    public void shouldCreateNewFile() {
        Path textFile = temporaryDirectory.resolve("test.txt");
        Assertions.assertNotNull(textFile);
    }

    @Test
    public void shouldCreateNewFile(@TempDir Path anotherDirectory) {
        Path textFile = anotherDirectory.resolve("test.txt");
        Assertions.assertNotNull(textFile);
    }
}
