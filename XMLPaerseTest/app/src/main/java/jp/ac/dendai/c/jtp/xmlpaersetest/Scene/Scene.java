package jp.ac.dendai.c.jtp.xmlpaersetest.Scene;

import android.app.Activity;
import android.app.Dialog;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

import jp.ac.dendai.c.jtp.xmlpaersetest.Game;
import jp.ac.dendai.c.jtp.xmlpaersetest.MyDialog.BranchDialog;
import jp.ac.dendai.c.jtp.xmlpaersetest.R;

/**
 * Created by Goto on 2016/05/20.
 */
public class Scene implements IScene{
    protected LinkedList<String> nextId;
    protected String imageId;
    protected String textId;
    protected String id;
    protected  boolean readFlag;
    protected int value;
    protected boolean proc_skip;

    public Scene(String id){
        nextId = new LinkedList<>();
        this.id = id;
    }

    public void setProcSkip(boolean b){
        proc_skip = b;
    }

    public boolean getProcSkip(){
        return proc_skip;
    }

    public Scene(){
        nextId = new LinkedList<>();
    }

    protected void copy(Scene sc){
        sc.id = id;
        sc.value = value;
        sc.imageId = imageId;
        sc.textId = textId;
        sc.nextId = nextId;
        sc.readFlag = readFlag;
    }

    @Override
    public void setTextId(String n){
        textId = n;
    }

    @Override
    public void setValue(int n) {
        value = n;
    }

    @Override
    public void addNextId(String sc) {
        nextId.add(sc);
    }

    @Override
    public String draw(Activity act, Game game) {
        return null;
    }

    @Override
    public boolean getReadFlag() {
        return false;
    }

    @Override
    public void setId(String n) {
        id = n;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setImageId(String n) {
        imageId = n;
    }

    @Override
    public int getNextNum() {
        return 0;
    }
}
