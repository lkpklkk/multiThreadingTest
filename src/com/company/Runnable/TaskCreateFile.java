package com.company.Runnable;

import com.company.Utils.HelperFunc;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TaskCreateFile implements Runnable{
    private String curDir;
    private int loopTime;
    @Override
    public void run() {

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        File file = new File(s + "\\genedFiles");
        file.mkdir();

        HelperFunc.generateFiles(file.getAbsolutePath());
        System.out.println(file.getAbsolutePath());

    }
}

