package jp.ac.dendai.c.jtp.xmlpaersetest.Scene;

import android.app.Activity;

import java.util.LinkedList;

import jp.ac.dendai.c.jtp.xmlpaersetest.Game;
import jp.ac.dendai.c.jtp.xmlpaersetest.Scene.Op.Conditions;

/**
 * Created by Goto on 2016/06/02.
 */
public class ProcBranchScene extends Scene {
    private Conditions cons;
    private int registId;
    private LinkedList<Next> nextValues;

    public ProcBranchScene(Scene sc){
        if(sc != null)
            sc.copy(this);
        nextValues = new LinkedList<>();
    }

    @Override
    public String draw(Activity act, Game game) {
        String result = nextValues.getLast().nextId;
        for(Next s : nextValues){
            boolean ans = cons.proc(registId,s.value);
            if(ans == true) {
                result = s.nextId;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean getReadFlag() {
        return readFlag;
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
        return nextId.size();
    }

    public void setCons(Conditions cons) {
        this.cons = cons;
    }

    public void setRegistId(int registId) {
        this.registId = registId;
    }

    public static Conditions parsCondision(String s){
        return Conditions.valueOf(s);
    }

    public void addNextItem(Next n){
        nextValues.add(n);
    }
}
