package dada_test;

import java.io.File;
import javax.swing.ImageIcon;

/* Utils.java is used by Simple_TextFile_Opener.java. */
public class Utils {
	/**
     *  �g����A�} c �ɥi��|���ýX���D
     *  java �Y�sĶ�L��|�X�{�ýX
     *  txt, rtf, csv, md, ini, sql, py �ҥi���`���
     */
    public final static String txt = "txt";
    public final static String rtf = "rtf";
    public final static String csv = "csv";
    public final static String md = "md";
    public final static String ini = "ini";
    public final static String sql = "sql";
    public final static String py = "py";
    public final static String java = "java";
    public final static String c = "c";

    // ���X���ɦW(extension)
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');
        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
}
