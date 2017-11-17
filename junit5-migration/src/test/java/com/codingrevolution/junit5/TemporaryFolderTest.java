package com.codingrevolution.junit5;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

@EnableRuleMigrationSupport
class TemporaryFolderTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    void shouldCreateNewFile() throws IOException {
        File textFile = temporaryFolder.newFile("test.txt");
        Assertions.assertNotNull(textFile);
    }
}
