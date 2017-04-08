package com.example.ThinkingInJava.one_File类;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by heshixiyang on 2017/1/22.
 */
public class DirList {
    public static void main(String[] args) {
        File path=new File(".");
        String[] list;
        if (args.length==0)
            list=path.list();
        else
            list=path.list(new DirFilter("gradle"));
//        System.out.println(args[0]);
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for (String dirItem:list)
            System.out.println(dirItem);
    }

    public static class DirFilter implements FilenameFilter {
        private Pattern pattern;

        public DirFilter(String regex) {
            this.pattern = Pattern.compile(regex);
        }

        @Override
        public boolean accept(File dir, String name) {
            return pattern.matcher(name).matches();
        }
    }
}
