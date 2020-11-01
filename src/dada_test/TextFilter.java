package dada_test;

import java.io.File;
//import javax.swing.*;
import javax.swing.filechooser.*;

/* TextFilter.java is used by Simple_TextFile_Opener.java. */
public class TextFilter extends FileFilter {

    //Accept all directories and all txt, rtf, csv, md, ini, sql, py, java or c files.
    /**
     *  �g����A�} c �ɥi��|���ýX���D
     *  java �Y�sĶ�L��|�X�{�ýX
     *  txt, rtf, csv, md, ini, sql, py �ҥi���`���
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
