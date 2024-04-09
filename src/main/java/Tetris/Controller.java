package Tetris;

import Setting.SizeConstants;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Controller {
    // Getting the numbers and the MESH from HelloApplication
    public static int MOVE = SizeConstants.MOVE;
    public static int SIZE = SizeConstants.SIZE;
    public static int XMAX = SizeConstants.XMAX;
    public static int YMAX = SizeConstants.YMAX;
    public static double fontSize = SizeConstants.fontSize;
    public static int[][] MESH = SizeConstants.MESH;


    public static void MoveRight(Form form) {
        if (form.a.getX() + MOVE <= XMAX - SIZE && form.b.getX() + MOVE <= XMAX - SIZE
                && form.c.getX() + MOVE <= XMAX - SIZE && form.d.getX() + MOVE <= XMAX - SIZE) {
            int movea = MESH[((int) form.a.getX() / SIZE) + 1][((int) form.a.getY() / SIZE)];
            int moveb = MESH[((int) form.b.getX() / SIZE) + 1][((int) form.b.getY() / SIZE)];
            int movec = MESH[((int) form.c.getX() / SIZE) + 1][((int) form.c.getY() / SIZE)];
            int moved = MESH[((int) form.d.getX() / SIZE) + 1][((int) form.d.getY() / SIZE)];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                form.a.setX(form.a.getX() + MOVE);
                form.b.setX(form.b.getX() + MOVE);
                form.c.setX(form.c.getX() + MOVE);
                form.d.setX(form.d.getX() + MOVE);
            }
        }
    }

    public static void MoveLeft(Form form) {
        if (form.a.getX() - MOVE >= 0 && form.b.getX() - MOVE >= 0 && form.c.getX() - MOVE >= 0
                && form.d.getX() - MOVE >= 0) {
            int movea = MESH[((int) form.a.getX() / SIZE) - 1][((int) form.a.getY() / SIZE)];
            int moveb = MESH[((int) form.b.getX() / SIZE) - 1][((int) form.b.getY() / SIZE)];
            int movec = MESH[((int) form.c.getX() / SIZE) - 1][((int) form.c.getY() / SIZE)];
            int moved = MESH[((int) form.d.getX() / SIZE) - 1][((int) form.d.getY() / SIZE)];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                form.a.setX(form.a.getX() - MOVE);
                form.b.setX(form.b.getX() - MOVE);
                form.c.setX(form.c.getX() - MOVE);
                form.d.setX(form.d.getX() - MOVE);
            }
        }
    }


    public static Form makeText(boolean colorBlindMode) {
        int block = (int) (Math.random() * 100);
        String name;
        Text a = new Text(0, 0, "X"), b = new Text(0, 0, "X"), c = new Text(0, 0, "X"),
                d = new Text(0, 0, "X");//Rectangle --> Text
        a.setFont(Font.font(fontSize));
        b.setFont(Font.font(fontSize));
        c.setFont(Font.font(fontSize));
        d.setFont(Font.font(fontSize));//fontsize설정
        if (block < 15) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2 - SIZE);
            b.setY(SIZE);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            d.setY(SIZE);
            name = "j";
        } else if (block < 30) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2 - SIZE);
            b.setY(SIZE);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            d.setY(SIZE);
            name = "l";
        } else if (block < 45) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2 - SIZE);
            c.setY(SIZE);
            d.setX(XMAX / 2);
            d.setY(SIZE);
            name = "o";
        } else if (block < 60) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 - SIZE);
            d.setY(SIZE);
            name = "s";
        } else if (block < 75) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            name = "t";
        } else if (block < 90) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2 + SIZE);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE + SIZE);
            d.setY(SIZE);
            name = "z";
        } else {
            a.setX(XMAX / 2 - SIZE - SIZE);
            b.setX(XMAX / 2 - SIZE);
            c.setX(XMAX / 2);
            d.setX(XMAX / 2 + SIZE);
            name = "i";
        }

        if (colorBlindMode) {
            // 각 블록에 대해 다른 색상 지정
            switch (name) {
                case "j":
                    a.setFill(Color.RED);
                    b.setFill(Color.RED);
                    c.setFill(Color.RED);
                    d.setFill(Color.RED);
                    break;
                case "l":
                    a.setFill(Color.GREEN);
                    b.setFill(Color.GREEN);
                    c.setFill(Color.GREEN);
                    d.setFill(Color.GREEN);
                    break;
                case "o":
                    a.setFill(Color.BLUE);
                    b.setFill(Color.BLUE);
                    c.setFill(Color.BLUE);
                    d.setFill(Color.BLUE);
                    break;
                case "s":
                    a.setFill(Color.ORANGE);
                    b.setFill(Color.ORANGE);
                    c.setFill(Color.ORANGE);
                    d.setFill(Color.ORANGE);
                    break;
                case "t":
                    a.setFill(Color.PURPLE);
                    b.setFill(Color.PURPLE);
                    c.setFill(Color.PURPLE);
                    d.setFill(Color.PURPLE);
                    break;
                case "z":
                    a.setFill(Color.YELLOW);
                    b.setFill(Color.YELLOW);
                    c.setFill(Color.YELLOW);
                    d.setFill(Color.YELLOW);
                    break;
                case "i":
                    a.setFill(Color.BLACK);
                    b.setFill(Color.BLACK);
                    c.setFill(Color.BLACK);
                    d.setFill(Color.BLACK);
                    break;
            }
        } else {
            // 일반 모드인 경우 기존 색상 사용
            switch (name) {
                case "j":
                    a.setFill(Color.SLATEGRAY);
                    b.setFill(Color.SLATEGRAY);
                    c.setFill(Color.SLATEGRAY);
                    d.setFill(Color.SLATEGRAY);
                    break;
                case "l":
                    a.setFill(Color.DARKGOLDENROD);
                    b.setFill(Color.DARKGOLDENROD);
                    c.setFill(Color.DARKGOLDENROD);
                    d.setFill(Color.DARKGOLDENROD);
                    break;
                case "o":
                    a.setFill(Color.INDIANRED);
                    b.setFill(Color.INDIANRED);
                    c.setFill(Color.INDIANRED);
                    d.setFill(Color.INDIANRED);
                    break;
                case "s":
                    a.setFill(Color.FORESTGREEN);
                    b.setFill(Color.FORESTGREEN);
                    c.setFill(Color.FORESTGREEN);
                    d.setFill(Color.FORESTGREEN);
                    break;
                case "t":
                    a.setFill(Color.CADETBLUE);
                    b.setFill(Color.CADETBLUE);
                    c.setFill(Color.CADETBLUE);
                    d.setFill(Color.CADETBLUE);
                    break;
                case "z":
                    a.setFill(Color.HOTPINK);
                    b.setFill(Color.HOTPINK);
                    c.setFill(Color.HOTPINK);
                    d.setFill(Color.HOTPINK);
                    break;
                case "i":
                    a.setFill(Color.SANDYBROWN);
                    b.setFill(Color.SANDYBROWN);
                    c.setFill(Color.SANDYBROWN);
                    d.setFill(Color.SANDYBROWN);
                    break;
            }
        }

        return new Form(a, b, c, d, name, colorBlindMode);
    }
    public static Form makeText(String name, boolean colorBlindMode) {
        Text a = new Text(0, 0, "X"), b = new Text(0, 0, "X"), c = new Text(0, 0, "X"),
                d = new Text(0, 0, "X");//Rectangle --> Text
        a.setFont(Font.font(fontSize));
        b.setFont(Font.font(fontSize));
        c.setFont(Font.font(fontSize));
        d.setFont(Font.font(fontSize));//fontsize설정
        if (name=="j") {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2 - SIZE);
            b.setY(SIZE);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            d.setY(SIZE);
        } else if (name=="l") {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2 - SIZE);
            b.setY(SIZE);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            d.setY(SIZE);
        } else if (name=="o") {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2 - SIZE);
            c.setY(SIZE);
            d.setX(XMAX / 2);
            d.setY(SIZE);
        } else if (name=="s") {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 - SIZE);
            d.setY(SIZE);
        } else if (name=="t") {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
        } else if (name=="z") {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2 + SIZE);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE + SIZE);
            d.setY(SIZE);
        } else {
            a.setX(XMAX / 2 - SIZE - SIZE);
            b.setX(XMAX / 2 - SIZE);
            c.setX(XMAX / 2);
            d.setX(XMAX / 2 + SIZE);
        }

        if (colorBlindMode) {
            // 각 블록에 대해 다른 색상 지정
            switch (name) {
                case "j":
                    a.setFill(Color.RED);
                    b.setFill(Color.RED);
                    c.setFill(Color.RED);
                    d.setFill(Color.RED);
                    break;
                case "l":
                    a.setFill(Color.GREEN);
                    b.setFill(Color.GREEN);
                    c.setFill(Color.GREEN);
                    d.setFill(Color.GREEN);
                    break;
                case "o":
                    a.setFill(Color.BLUE);
                    b.setFill(Color.BLUE);
                    c.setFill(Color.BLUE);
                    d.setFill(Color.BLUE);
                    break;
                case "s":
                    a.setFill(Color.ORANGE);
                    b.setFill(Color.ORANGE);
                    c.setFill(Color.ORANGE);
                    d.setFill(Color.ORANGE);
                    break;
                case "t":
                    a.setFill(Color.PURPLE);
                    b.setFill(Color.PURPLE);
                    c.setFill(Color.PURPLE);
                    d.setFill(Color.PURPLE);
                    break;
                case "z":
                    a.setFill(Color.YELLOW);
                    b.setFill(Color.YELLOW);
                    c.setFill(Color.YELLOW);
                    d.setFill(Color.YELLOW);
                    break;
                case "i":
                    a.setFill(Color.BLACK);
                    b.setFill(Color.BLACK);
                    c.setFill(Color.BLACK);
                    d.setFill(Color.BLACK);
                    break;
            }
        } else {
            // 일반 모드인 경우 기존 색상 사용
            switch (name) {
                case "j":
                    a.setFill(Color.SLATEGRAY);
                    b.setFill(Color.SLATEGRAY);
                    c.setFill(Color.SLATEGRAY);
                    d.setFill(Color.SLATEGRAY);
                    break;
                case "l":
                    a.setFill(Color.DARKGOLDENROD);
                    b.setFill(Color.DARKGOLDENROD);
                    c.setFill(Color.DARKGOLDENROD);
                    d.setFill(Color.DARKGOLDENROD);
                    break;
                case "o":
                    a.setFill(Color.INDIANRED);
                    b.setFill(Color.INDIANRED);
                    c.setFill(Color.INDIANRED);
                    d.setFill(Color.INDIANRED);
                    break;
                case "s":
                    a.setFill(Color.FORESTGREEN);
                    b.setFill(Color.FORESTGREEN);
                    c.setFill(Color.FORESTGREEN);
                    d.setFill(Color.FORESTGREEN);
                    break;
                case "t":
                    a.setFill(Color.CADETBLUE);
                    b.setFill(Color.CADETBLUE);
                    c.setFill(Color.CADETBLUE);
                    d.setFill(Color.CADETBLUE);
                    break;
                case "z":
                    a.setFill(Color.HOTPINK);
                    b.setFill(Color.HOTPINK);
                    c.setFill(Color.HOTPINK);
                    d.setFill(Color.HOTPINK);
                    break;
                case "i":
                    a.setFill(Color.SANDYBROWN);
                    b.setFill(Color.SANDYBROWN);
                    c.setFill(Color.SANDYBROWN);
                    d.setFill(Color.SANDYBROWN);
                    break;
            }
        }

        return new Form(a, b, c, d, name, colorBlindMode);
    }
    public static Form waitingTextMake(boolean colorBlindMode){
        Form waitObj = makeText(colorBlindMode);

        waitObj.a.setX(waitObj.a.getX()+SIZE*7);
        waitObj.b.setX(waitObj.b.getX()+SIZE*7);
        waitObj.c.setX(waitObj.c.getX()+SIZE*7);
        waitObj.d.setX(waitObj.d.getX()+SIZE*7);
        waitObj.a.setY(waitObj.a.getY()+150);
        waitObj.b.setY(waitObj.b.getY()+150);
        waitObj.c.setY(waitObj.c.getY()+150);
        waitObj.d.setY(waitObj.d.getY()+150);
        waitObj.a.setUserData("waita");
        waitObj.b.setUserData("waitb");
        waitObj.c.setUserData("waitc");
        waitObj.d.setUserData("waitd");

        return new Form(waitObj.a, waitObj.b, waitObj.c, waitObj.d, waitObj.getName(),colorBlindMode);
    }
}