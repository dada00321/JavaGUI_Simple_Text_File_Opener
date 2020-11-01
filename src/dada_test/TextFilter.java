package dada_test;

import java.io.File;
//import javax.swing.*;
import javax.swing.filechooser.*;

/* TextFilter.java is used by Simple_TextFile_Opener.java. */
public class TextFilter extends FileFilter {

    //Accept all directories and all txt, rtf, csv, md, ini, sql, py, java or c files.
    /**
     *  經實測，開 c 檔可能會有亂碼問題
     *  java 若編譯過亦會出現亂碼
     *  txt, rtf, csv, md, ini, sql, py 皆可正常顯示
     */
	public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = Utils.getExtension(f);
        if (extension != null) {
            if (extension.equals(Utils.txt) ||
                extension.equals(Utils.rtf) ||
                extension.equals(Utils.csv) ||
                extension.equals(Utils.md) ||
                extension.equals(Utils.ini) ||
                extension.equals(Utils.sql) ||
                extension.equals(Utils.py) ||
                extension.equals(Utils.java) ||
                extension.equals(Utils.c)) {
                    return true;
            } else {
                return false;
            }
        }
        return false;
    }

    //The description of this filter
    public String getDescription() {
        return "Texts Only";
    }
}
