import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class InputHandler implements KeyListener, WindowFocusListener {

    private final MonkeyType monkeyType;
    private JFrame frame;

    public InputHandler(MonkeyType monkeyType) {
        this.monkeyType = monkeyType;
    }

    public void build_input_field(){

        frame = new JFrame();
        frame.setSize(0,0);
        frame.setVisible(true);
        frame.addKeyListener(this);
        frame.addWindowFocusListener(this);
        frame.setFocusTraversalKeysEnabled(false);
        frame.setLocation(10000,10000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        char key_char = e.getKeyChar();

        if (key >= KeyEvent.VK_A && key <= KeyEvent.VK_Z) {
            monkeyType.handle_char_input(key_char);
        } else if (key == KeyEvent.VK_TAB || key == KeyEvent.VK_SPACE) {
            monkeyType.handle_char_input(' ');
        } else if (key == KeyEvent.VK_ENTER) {
            monkeyType.create_new_sentence();
        } else if (key == KeyEvent.VK_BACK_SPACE) {
            monkeyType.remove_last_char();
        } else if (key == KeyEvent.VK_ESCAPE) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }

        monkeyType.print_line();

    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void windowGainedFocus(WindowEvent e) {}

}
