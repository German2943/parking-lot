import View.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Always run GUI code on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("My App");
            frame.setContentPane(new Design().mainLayer);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack(); // Adjusts size to fit components
            frame.setLocationRelativeTo(null); // Centers window
            frame.setVisible(true); // Makes the frame visible
        });
    }
}
