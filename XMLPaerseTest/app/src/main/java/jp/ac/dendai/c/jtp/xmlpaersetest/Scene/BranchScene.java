package jp.ac.dendai.c.jtp.xmlpaersetest.Scene;

import android.app.Activity;

import java.util.LinkedList;

import jp.ac.dendai.c.jtp.xmlpaersetest.Game;
import jp.ac.dendai.c.jtp.xmlpaersetest.MyDialog.BranchDialog;

/**
 * Created by Goto on 2016/06/02.
 */
public class BranchScene extends Scene {
    public BranchScene(Scene sc){
        if(sc != null)
            sc.copy(this);
    }

    public BranchScene(){
        nextId = new LinkedList<>();
    }

    public BranchScene(String id, String[] next){
        this.id = id;
        nextId = new LinkedList<String>();
        for(String s : next){
            nextId.add(s);
        }
    }

    @Override
    public int getNextNum(){
        return nextId.size();
    }

    public void addNextId(String n){
        nextId.add(n);
    }

    @Override
    public boolean getReadFlag(){
        return readFlag;
    }

    @Override
    public void setId(String n){
        id = n;
    }

    @Override
    public String getId(){
        return id;
    }

    @Override
    public void setImageId(String n){
        imageId = n;
    }

    @Override
    public String draw(Activity act, Game game) {
        BranchDialog dialog = new BranchDialog();
        dialog.setGameInstance(game);
        dialog.setBranchElements(nextId);
        dialog.setOwnerScene(id);
        dialog.setActivity(act);
        dialog.show(act.getFragmentManager(), "tag");
        return null;
    }
}
