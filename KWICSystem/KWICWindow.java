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
        outputTextArea.setBounds(10, 150, 414, 400);
        outputTextArea.setLineWrap(true); // 启用自动换行
        frame.getContentPane().add(outputTextArea);

        architectureComboBox = new JComboBox<String>();
        architectureComboBox.setBounds(10, 550, 150, 20);
        architectureComboBox.addItem("Main-Sub");
        architectureComboBox.addItem("Object-Oriented");
        architectureComboBox.addItem("Event");
        architectureComboBox.addItem("Pipeline");
        frame.getContentPane().add(architectureComboBox);

        importButton = new JButton("Import");
        importButton.setBounds(170, 550, 89, 23);
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
            processedText = "主程序-子程序风格是结构化程序设计的一种典型风格从功能的观点设计系统，通过逐步分解和细化，形成整个系统的体系结构。"+"\n";
            processedText = processedText+MainSubSystem.process(fileName);
        } else if (architecture.equals("Object-Oriented")) {
            processedText = "面向对象风格建立在数据抽象和面向对象的基础上，数据的表示方法和它们的相应操作封装在一个抽象数据类型或对象中"+"\n";
            processedText = processedText+KWICSystem.ObjectOrientedSystem.process.process(fileName);
        } else if (architecture.equals("Event")) {
            processedText = "基于事件的隐式调用风格的思想是构件不直接调用一个过程，而是触发或广播一个或多个事件"+"\n";
            processedText = processedText+KWICSystem.EventSystem.Process.process(fileName);
        } else if (architecture.equals("Pipeline")) {
            processedText = "在管道/过滤器风格的软件体系结构中，每个构件都有一组输入和输出，构件读输入的数据流，经过内部处理，然后产生输出数据流。"+"\n";
            processedText = processedText+KWICSystem.PipelineSystem.Process.process(fileName);
        }
        outputTextArea.setText(processedText);
    }
}
