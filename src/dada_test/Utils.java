package dada_test;

import java.io.File;
import javax.swing.ImageIcon;

/* Utils.java is used by Simple_TextFile_Opener.java. */
public class Utils {
	/**
     *  經實測，開 c 檔可能會有亂碼問題
     *  java 若編譯過亦會出現亂碼
     *  txt, rtf, csv, md, ini, sql, py 皆可正常顯示
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

    // 取出副檔名(extension)
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
