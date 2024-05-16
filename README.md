# MonkeyType
A relatively complex typing test with a simple TUI, which is inspired by [monkeytype.com](monkeytype.com). It is written in Java and is based on OOP. 

After calling the InputHandler class, which takes care of KeyEvents, the RandomSentence class is called. 
This class creates a 7 to 15 word sentence which is displayed in the terminal. 
![example](https://raw.githubusercontent.com/gxstxxv/MonkeyType/main/pictures/Bildschirmfoto%202024-05-10%20um%2013.13.00.png)

Now an algorithm of the MonkeyType class takes care of analyzing the input after each KeyEvent.
![example](https://raw.githubusercontent.com/gxstxxv/MonkeyType/main/pictures/Bildschirmfoto%202024-05-10%20um%2013.13.23.png)

Input errors are output as shown in the following example.
![example](https://raw.githubusercontent.com/gxstxxv/MonkeyType/main/pictures/Bildschirmfoto%202024-05-10%20um%2013.13.53.jpeg)

By using the ansi_cursor_reset code (“\033[H”), no line breaks are necessary for the output.
![example](https://raw.githubusercontent.com/gxstxxv/MonkeyType/main/pictures/Bildschirmfoto%202024-05-10%20um%2013.15.05.png)
![example](https://raw.githubusercontent.com/gxstxxv/MonkeyType/main/pictures/Bildschirmfoto%202024-05-10%20um%2013.15.23.png)
