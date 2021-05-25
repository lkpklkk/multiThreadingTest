package com.company.runnable;

import com.company.utils.Generator;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author lekeping
 */
public class CreateFiles implements Runnable {

    @Override
    public void run() {

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        File file = new File(s + "\\genedFiles");
        file.mkdir();

        Generator.generateFiles(file.getAbsolutePath());
        System.out.println(file.getAbsolutePath());

    }
}

