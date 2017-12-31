package com.codingrevolution.junit5.rules;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

public class JUnit4TemporaryFolderTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void shouldCreateNewFile() throws IOException {
        File textFile = temporaryFolder.newFile("test.txt");
        Assert.assertNotNull(textFile);
    }
}
