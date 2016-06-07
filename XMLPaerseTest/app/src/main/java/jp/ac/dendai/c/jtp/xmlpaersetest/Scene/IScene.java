package jp.ac.dendai.c.jtp.xmlpaersetest.Scene;

import android.app.Activity;

import jp.ac.dendai.c.jtp.xmlpaersetest.Game;

/**
 * Created by Goto on 2016/06/02.
 */
public interface IScene {
    public String draw(Activity act,Game game);
    public boolean getReadFlag();
    public void setId(String n);
    public String getId();
    public void setImageId(String n);
    public int getNextNum();
    public void setTextId(String n);
    public void setValue(int n);
    public void addNextId(String sc);
}
