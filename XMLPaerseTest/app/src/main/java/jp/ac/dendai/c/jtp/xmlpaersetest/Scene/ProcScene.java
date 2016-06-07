package jp.ac.dendai.c.jtp.xmlpaersetest.Scene;

import android.app.Activity;

import java.util.LinkedList;

import jp.ac.dendai.c.jtp.xmlpaersetest.Game;
import jp.ac.dendai.c.jtp.xmlpaersetest.Scene.Op.Operation;

/**
 * Created by Goto on 2016/06/02.
 */
public class ProcScene extends Scene {
    private Operation op;
    private int registId_Assign;
    private int registId_Operand;

    public  ProcScene(Scene sc){
        if(sc != null)
            sc.copy(this);
    }

    public ProcScene(){
        nextId = new LinkedList<>();
    }

    public ProcScene(String id, String next){
        nextId = new LinkedList<>();
        this.id = id;
        this.nextId.add(next);
    }

    @Override
    public String draw(Activity act, Game game) {
        op.proc(registId_Assign,registId_Operand,value);
        return nextId.getFirst();
    }

    @Override
    public boolean getReadFlag() {
        return readFlag;
    }

    @Override
    public void setId(String n) {
        this.id = n;
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
        return 1;
    }

    public void setOp(Operation op) {
        this.op = op;
    }

    public void setRegistIdAssign(int registId) {
        this.registId_Assign = registId;
    }
    public void setRegistIdOperand(int registId){
        this.registId_Operand = registId;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }
}
