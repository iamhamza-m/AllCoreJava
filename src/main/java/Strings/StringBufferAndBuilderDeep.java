package Strings;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI demo for StringBuffer vs StringBuilder performance.
 */
public class StringBufferAndBuilderDeep extends JFrame {
	private JTextArea outputArea;
	private JTextField inputField;
	private JButton stringBufferBtn;
	private JButton stringBuilderBtn;
	private JButton clearBtn;
	
	private StringBuffer stringBuffer;
	private StringBuilder stringBuilder;
	
	public StringBufferAndBuilderDeep() {
		setTitle("StringBuffer vs StringBuilder Demo");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// Output area
		outputArea = new JTextArea();
		outputArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(outputArea);
		add(scrollPane, BorderLayout.CENTER);
		
		// Input panel
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout());
		inputPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		JLabel label = new JLabel("Enter number of operations:");
		inputField = new JTextField(10);
		
		stringBufferBtn = new JButton("Test StringBuffer");
		stringBuilderBtn = new JButton("Test StringBuilder");
		clearBtn = new JButton("Clear");
		
		inputPanel.add(label);
		inputPanel.add(inputField);
		inputPanel.add(stringBufferBtn);
		inputPanel.add(stringBuilderBtn);
		inputPanel.add(clearBtn);
		
		add(inputPanel, BorderLayout.SOUTH);
		
		// Action listeners
		stringBufferBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				testStringBuffer();
			}
		});
		
		stringBuilderBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				testStringBuilder();
			}
		});
		
		clearBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				outputArea.setText("");
			}
		});
		
		setVisible(true);
	}
	
	private void testStringBuffer() {
		int operations = getOperationsCount();
		if (operations <= 0) return;
		
		long startTime = System.nanoTime();
		
		stringBuffer = new StringBuffer("Initial");
		for (int i = 0; i < operations; i++) {
			stringBuffer.append(" append" + i);
		}
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1_000_000;  // ms
		
		outputArea.append("StringBuffer Test:\n");
		outputArea.append("Time taken: " + duration + " ms\n");
		outputArea.append("Length of result: " + stringBuffer.length() + " characters\n");
		outputArea.append("Thread-safe: Yes (synchronized)\n");
		outputArea.append("----------------------------------------\n\n");
	}
	
	private void testStringBuilder() {
		int operations = getOperationsCount();
		if (operations <= 0) return;
		
		long startTime = System.nanoTime();
		
		stringBuilder = new StringBuilder("Initial");
		for (int i = 0; i < operations; i++) {
			stringBuilder.append(" append" + i);
		}
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1_000_000;  // ms
		
		outputArea.append("StringBuilder Test:\n");
		outputArea.append("Time taken: " + duration + " ms\n");
		outputArea.append("Length of result: " + stringBuilder.length() + " characters\n");
		outputArea.append("Thread-safe: No (not synchronized)\n");
		outputArea.append("----------------------------------------\n\n");
	}
	
	private int getOperationsCount() {
		try {
			return Integer.parseInt(inputField.getText());
		} catch (NumberFormatException e) {
			outputArea.append("Invalid input. Please enter a number.\n");
			return 0;
		}
	}
	
	public static void main(String[] args) {
		// Use the event dispatch thread for GUI operations
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new StringBufferAndBuilderDeep();
			}
		});
	}
}
