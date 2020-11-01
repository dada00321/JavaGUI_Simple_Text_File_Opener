package dada_test;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

class TxtInfo {
	int txtID;
	String filename;
	JEditorPane content;
	public TxtInfo(int txtID, String filename, JEditorPane content) {
		this.txtID = txtID;
		this.filename = filename;
		this.content = content;
	}
	public int getTxtID() { return txtID; }
	public String getFilename() { return filename; }
	public JEditorPane getEditorPane() { return content; }
}

public class Simple_TextFile_Opener extends JFrame {
    JMenu menu;
    JMenuItem open;
    JMenuItem exit;
    JMenuBar menuBar;
    JFileChooser fc = new JFileChooser();
    JTabbedPane tabPane = new JTabbedPane();
    //JEditorPane text = new JEditorPane();
    int tab_count = 0;
    ArrayList<TxtInfo> txt_list = new ArrayList<TxtInfo>();
    
    public Simple_TextFile_Opener() {
        super();
        menu = new JMenu("File");
        open = new JMenuItem("Open");
        exit = new JMenuItem("Exit");
        menuBar = new JMenuBar();
        set_texts_for_components();
        
        tabPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent changeEvent) {
				JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
		        int tab_idx = sourceTabbedPane.getSelectedIndex();
		        //System.out.println("Tab index: "+ tab_idx);
		        System.out.printf("切換到第 %d 分頁: %s\n", tab_idx+1, sourceTabbedPane.getTitleAt(tab_idx));
		        load_tagContent_onIndex(tab_idx);
			}
		});

        open.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add a custom file filter and disable the default
                // (Accept All) file filter.
            	fc.addChoosableFileFilter(new TextFilter());
                fc.setAcceptAllFileFilterUsed(false);

            	int result = fc.showDialog(
                        Simple_TextFile_Opener.this,"open");
                switch(result) {
                  case JFileChooser.CANCEL_OPTION:
                    System.out.println("偵測到視窗被關閉");
                    break;
                  case JFileChooser.APPROVE_OPTION:
                    File file = fc.getSelectedFile();
                    JEditorPane curr_text = new JEditorPane();
                    try {
                    	//text.setPage(f.toURI().toURL());
                        BufferedReader br = new BufferedReader(new InputStreamReader(
                     		     new FileInputStream(file), StandardCharsets.UTF_8));
                        StringBuffer content = new StringBuffer("");
                        String line = "";
                        while((line=br.readLine()) != null){
                           content.append(line + "\n");
                         }
                        br.close();
                        curr_text.setText(content.toString());
                        curr_text.setEditable(false);
                        curr_text.setFont(new Font("serif", Font.PLAIN, 30));
                    
                        txt_list.add(new TxtInfo((tab_count+1), file.getName(), curr_text));
                        JScrollPane spanel = new JScrollPane(curr_text);
                        tabPane.add(file.getName(), spanel);
                        System.out.println("開啟檔案: " + file.getName());
                        tabPane.setSelectedIndex(tab_count);
                        tab_count += 1;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    break;
                  case JFileChooser.ERROR_OPTION:
                    System.out.println("發生一些錯誤");
                    break;
                  default:
                    System.out.println("發生未知的錯誤");
                    break;
                }
            }
        });
        exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<txt_list.size();i++) {
					System.out.println(txt_list.get(i).filename);
				}
				System.out.println("\nGUI程式結束，感謝您的使用！");
				Simple_TextFile_Opener.this.dispose();
			}
		});

        menu.add(open);
        menu.add(exit);
        menuBar.add(menu);

        setJMenuBar(menuBar);
        add(tabPane);
    }
    
    private void load_tagContent_onIndex(int i) {
    	TxtInfo info = txt_list.get(i);
    	JEditorPane text = info.getEditorPane();
    	text.setFont(new Font("serif", Font.PLAIN, 30));
    	JScrollPane spanel = new JScrollPane(text);
    	tabPane.setComponentAt(i, spanel);
    }
    
    private void set_texts_for_components() {
    	menu.setFont(new Font("Arial", Font.PLAIN, 20));
        open.setFont(new Font("Arial", Font.PLAIN, 18));
        exit.setFont(new Font("Arial", Font.PLAIN, 18));
    }
}
