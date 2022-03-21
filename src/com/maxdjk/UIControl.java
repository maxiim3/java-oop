package com.maxdjk;

public abstract class UIControl {
    // We set that Ui control have Enable/Disable methods.
    // By default it is enabled.
    //The enable(), disable() method will switch over the boolean value of isEnabled
    //We also need a getter to read the status of isEnable field.


    //    ........       F I E L D S      ........

    private boolean isEnabled = true; //is True by default


    //    ........       C O N S T R U C T O R      ........

//    public UIControl(boolean isEnabled) {
//        this.isEnabled = isEnabled;
//    }

    //    ........       M E T H O D S      ........

    public abstract void render();

    public void enable(){
        isEnabled = true;
    }

    public void disable(){
        isEnabled = false;
    }


    //    ........       G E T T E R S      ........

    public boolean isEnabled(){ //Method and field have the same name.
        return isEnabled;
    }

    //END
}
