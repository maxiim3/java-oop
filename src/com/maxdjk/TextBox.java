package com.maxdjk;

public class TextBox extends UIControl {


    //    ........       F I E L D S      ........

    private  String text = ""; // Field | class level variable


    //    ........       C O N S T R U C T O R      ........

//    public TextBox() {
//        super(true);
//    }


    //    ........       M E T H O D S      ........


    @Override
    public void render() {
        System.out.println("TextBox");
    }

    @Override
    public String toString(){
        return text;
    }

    public void clear() {
        this.text = ""; //clear the text --> set the text to an empty string
    }


    //    ........       G E T T E R S  &  S E T T E R S     ........

    public void setText(String text) { // text is a parameter here
        this.text = text; // We declare text field == text parameter.
        // We use this.text (to point the field) for not being confuse, because both the parameter and the field have the same name.
    }

    public String getText(){
        return text;
    }


    //END
}
