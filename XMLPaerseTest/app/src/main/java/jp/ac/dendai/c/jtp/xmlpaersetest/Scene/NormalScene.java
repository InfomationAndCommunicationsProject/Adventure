package jp.ac.dendai.c.jtp.xmlpaersetest.Scene;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

import jp.ac.dendai.c.jtp.xmlpaersetest.Game;
import jp.ac.dendai.c.jtp.xmlpaersetest.R;

/**
 * Created by Goto on 2016/06/02.
 */
public class NormalScene extends Scene{

    public NormalScene(){
        readFlag = false;
        nextId = new LinkedList<>();
    }

    public NormalScene(Scene sc){
        if(sc != null)
            sc.copy(this);
    }

    public NormalScene(String id, String next){
        this.id = id;
        nextId = new LinkedList<>();
        this.nextId.add(next);
    }

    public boolean getReadFlag(){
        return readFlag;
    }

    public void setId(String n){
        id = n;
    }
    public String getId(){
        return id;
    }

    public void setImageId(String n){
        imageId = n;
    }

    @Override
    public int getNextNum() {
        return 1;
    }

    @Override
    public String draw(Activity act,Game game){
        if(!readFlag && game.tb.isChecked())
            game.tb.performClick();
        String s;
        TextView tv = (TextView) act.findViewById(R.id.MessageBox);
        ImageView iv = (ImageView)act.findViewById(R.id.imageView);
        String temp = (String)act.getResources().getText(act.getResources().getIdentifier("text_"+textId, "string", act.getPackageName()));

        for(int n = 0;n < Game.regist.length;n++){
            temp = temp.replace("$regist"+n+"$",String.valueOf(Game.regist[n]));
        }
        tv.setText(temp);
        iv.setImageResource(act.getResources().getIdentifier("scene"+imageId,"drawable",act.getPackageName()));
        readFlag = true;
        return nextId.getFirst();
    }

    @Override
    public String toString(){
        String s = "";
        for(String sl : nextId){
            s += "["+sl+"]";
        }
        return s;
    }
}
