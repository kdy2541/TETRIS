package Tetris;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Form {
    public Text a;
    public Text b;
    public Text c;
    public Text d;
    Color color;
    private String name;
    public int form = 1;

    public Form(Text a, Text b, Text c, Text d) {//텍스트로변경
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Form(Text a, Text b, Text c, Text d, String name) {//텍스트로변경
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.name = name;
        switch(name){
            case "j":
                color = Color.SLATEGRAY;
                break;
            case "l":
                color = Color.DARKGOLDENROD;
                break;
            case "o":
                color = Color.INDIANRED;
                break;
            case "s":
                color = Color.FORESTGREEN;
                break;
            case "t":
                color = Color.CADETBLUE;
                break;
            case "z":
                color = Color.HOTPINK;
                break;
            case "i":
                color = Color.SANDYBROWN;
                break;
        }
        this.a.setFill(color);
        this.b.setFill(color);
        this.c.setFill(color);
        this.d.setFill(color);
    }


    //색설정




    public String getName(){
        return name;
    }

    public void changeForm(){
        if(form !=4){
            form++;
        }else{
            form = 1;
        }

    }


}
