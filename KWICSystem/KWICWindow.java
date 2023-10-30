package KWICSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class KWICWindow {
    JFrame frame;
    JTextArea inputTextArea;
    JTextArea outputTextArea;
    JComboBox<String> architectureComboBox;
    JButton importButton;
    JButton processButton;

    public KWICWindow() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblInput = new JLabel("Input:");
        lblInput.setBounds(10, 10, 46, 14);
        frame.getContentPane().add(lblInput);

        JLabel lblOutput = new JLabel("Output:");
        lblOutput.setBounds(10, 130, 46, 14);
        frame.getContentPane().add(lblOutput);

        inputTextArea = new JTextArea();
        inputTextArea.setBounds(10, 30, 414, 90);
        frame.getContentPane().add(inputTextArea);

        outputTextArea = new JTextArea();
        outputTextArea.setBounds(10, 150, 414, 300);
        frame.getContentPane().add(outputTextArea);

        architectureComboBox = new JComboBox<String>();
        architectureComboBox.setBounds(10, 450, 150, 20);
        architectureComboBox.addItem("Main-Sub");
        architectureComboBox.addItem("Object-Oriented");
        architectureComboBox.addItem("Event");
        architectureComboBox.addItem("Pipeline");
        frame.getContentPane().add(architectureComboBox);

        importButton = new JButton("Import");
        importButton.setBounds(170, 450, 89, 23);
        importButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                importFile();
            }
        });
        frame.getContentPane().add(importButton);

        /*processButton = new JButton("Process");
        processButton.setBounds(279, 450, 89, 23);
        processButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String filename = "";
                processFile(filename);
            }
        });
        frame.getContentPane().add(processButton);*/
    }

    private void importFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            // 获取选定的文件，并进行处理
            // String filename = fileChooser.getSelectedFile().getPath();
            // ...
            try {
                // 获取选定的文件，并进行处理
                String filename = fileChooser.getSelectedFile().getPath();
                // 调用处理文件方法并传递文件名作为参数
                processFile(filename);
                BufferedReader reader = new BufferedReader(new FileReader(filename));
                String line;
                StringBuilder content = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                reader.close();

                inputTextArea.setText(content.toString());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "文件导入失败: " + e.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void processFile(String filename) {
        String fileName = filename;
        //String input = inputTextArea.getText();
        String architecture = (String) architectureComboBox.getSelectedItem();
        String processedText = "";

        if (architecture.equals("Main-Sub")) {
            processedText = MainSubSystem.process(fileName);
        } else if (architecture.equals("Object-Oriented")) {
            processedText = KWICSystem.ObjectOrientedSystem.process.process(fileName);
        } else if (architecture.equals("Event")) {
            processedText = KWICSystem.EventSystem.Process.process(fileName);
        } else if (architecture.equals("Pipeline")) {
            processedText = KWICSystem.PipelineSystem.Process.process(fileName);
        }
        outputTextArea.setText(processedText);
    }
}
