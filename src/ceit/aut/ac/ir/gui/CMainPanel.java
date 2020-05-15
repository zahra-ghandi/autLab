package ceit.aut.ac.ir.gui;

import ceit.aut.ac.ir.model.Note;
import ceit.aut.ac.ir.utils.FileUtils;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Date;

public class CMainPanel extends JPanel {

    private JTabbedPane tabbedPane;
    private JList<String> directoryList;

    public CMainPanel() {

        setLayout(new BorderLayout());

        initDirectoryList(); // add JList to main Panel

        initTabbedPane(); // add TabbedPane to main panel

//        addNewTab(); // open new empty tab when user open the application
    }

    private void initTabbedPane() {
        tabbedPane = new JTabbedPane();
        add(tabbedPane, BorderLayout.CENTER);
    }

    private void initDirectoryList() {
        File[] files = FileUtils.getFilesInDirectory();
        String[] listTitles = FileUtils.noteListTitles(files);
        directoryList = new JList<>(listTitles);

        directoryList.setBackground(new Color(211, 211, 211));
        directoryList.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        directoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        directoryList.setVisibleRowCount(-1);
        directoryList.setMinimumSize(new Dimension(130, 100));
        directoryList.setMaximumSize(new Dimension(130, 100));
        directoryList.setFixedCellWidth(150);
        directoryList.setCellRenderer(new MyCellRenderer());
        directoryList.addMouseListener(new MyMouseAdapter());

        add(new JScrollPane(directoryList), BorderLayout.WEST);
    }

    public void addNewTab() {
        String noteTitle = JOptionPane.showInputDialog(this, "Enter this note's title.", "Title");
        JTextArea textPanel = createTextPanel();
        textPanel.setText("Write Something here...");
        tabbedPane.addTab(noteTitle, textPanel);
        tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
    }

    // Previous method
//    public void openExistingNote(String content) {
//        JTextArea existPanel = createTextPanel();
//        existPanel.setText(content);
//
//        int tabIndex = tabbedPane.getTabCount() + 1;
//        tabbedPane.addTab("Tab " + tabIndex, existPanel);
//        tabbedPane.setSelectedIndex(tabIndex - 1);
//    }

    // New method for object notes.
    public void openExistingNote(Note note) {
        String title = note.getTitle();
        JTextArea existPanel = createTextPanel();
        existPanel.setText(note.getContent());

        int tabIndex = tabbedPane.getTabCount() + 1;
        tabbedPane.addTab(title, existPanel);
        tabbedPane.setSelectedIndex(tabIndex - 1);
    }

    // Previous method
//    public void saveNote() {
//        JTextArea textPanel = (JTextArea) tabbedPane.getSelectedComponent();
//        String note = textPanel.getText();
//        if (!note.isEmpty()) {
//            FileUtils.fileWriter(note);
//        }
//        updateListGUI();
//    }

    // New method for object notes.
    public void saveNote() {
        String title = tabbedPane.getTitleAt(tabbedPane.getSelectedIndex());
        JTextArea textPanel = (JTextArea) tabbedPane.getSelectedComponent();
        String content = textPanel.getText();

        Note note = new Note(title, content, (new Date()).toString());

        FileUtils.objectFileWriter(note);

        updateListGUI();
    }

    // Previous method
//    public void saveNotes() {
//        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
//            JTextArea textPanel = (JTextArea) tabbedPane.getComponentAt(i);
//            String note = textPanel.getText();
//            if (!note.isEmpty()) {
//                FileUtils.fileWriter(note);
//            }
//        }
//    }

    // New method for object notes.
    public void saveNotes() {
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            String title = tabbedPane.getTitleAt(i);
            JTextArea textPanel = (JTextArea) tabbedPane.getSelectedComponent();
            String content = textPanel.getText();

            Note note = new Note(title, content, (new Date()).toString());

            FileUtils.objectFileWriter(note);
        }
    }

    private JTextArea createTextPanel() {
        JTextArea textPanel = new JTextArea();
        textPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return textPanel;
    }

    private void updateListGUI() {
        File[] newFiles = FileUtils.getFilesInDirectory();
        String[] listTitles = FileUtils.noteListTitles(newFiles);
        directoryList.setListData(listTitles);
    }


    private class MyMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent eve) {
            // Double-click detected
            if (eve.getClickCount() == 2) {
                int index = directoryList.locationToIndex(eve.getPoint());
                System.out.println("Item " + index + " is clicked...");
                //TODO: Phase1: Click on file is handled... Just load content into JTextArea
                File curr[] = FileUtils.getFilesInDirectory();
                Note note = FileUtils.objectFileReader(curr[index]);
                openExistingNote(note);
            }
        }
    }


    private class MyCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object object, int index, boolean isSelected, boolean cellHasFocus) {
            if (object instanceof String) {
                setText((String) object);
                ImageIcon icon = new ImageIcon("./icon/icon.png");
                setIcon(icon);
                setToolTipText((String) object);
                if (isSelected) {
                    setBackground(list.getSelectionBackground());
                    setForeground(list.getSelectionForeground());
                } else {
                    setBackground(list.getBackground());
                    setForeground(list.getForeground());
                }
                setEnabled(list.isEnabled());
            }
            return this;
        }
    }
}
