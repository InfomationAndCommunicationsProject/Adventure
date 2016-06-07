package jp.ac.dendai.c.jtp.xmlpaersetest;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import jp.ac.dendai.c.jtp.xmlpaersetest.Scene.BranchScene;
import jp.ac.dendai.c.jtp.xmlpaersetest.Scene.NormalScene;
import jp.ac.dendai.c.jtp.xmlpaersetest.Scene.Scene;
import jp.ac.dendai.c.jtp.xmlpaersetest.XmlParser.ParseScene;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Goto on 2016/05/20.
 */
public class Game {
    public static int[] regist = new int[128];
    private final static String firstScene = "5";
    private Activity act;
    private HashMap<String,Scene> structureData;
    private Scene now;
    private ImageView iv;
    public ToggleButton tb;
    private CheckBox cb;
    public volatile boolean skipFlag;
    private Handler handler;

    public Game(Activity activity){
        handler = new Handler(){
            public void handleMessage(Message msg){
                if(msg.what == 0) {
                    next();
                }
                else if(msg.what == 1){
                    tb.setChecked(false);
                    skipFlag = false;
                    iv.setClickable(true);
                }
            }
        };
        skipFlag = false;
        act = activity;
        structureData = new HashMap<>();
        initialize();
        now = structureData.get(firstScene);
        iv = (ImageView)act.findViewById(R.id.imageView);
        tb = (ToggleButton)act.findViewById(R.id.toggleButton);
        cb = (CheckBox)act.findViewById(R.id.checkBox);
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    skipFlag = true;
                    iv.setClickable(false);
                    (new Thread(new SkipThread())).start();
                }
                else{
                    skipFlag = false;
                }
            }
        });
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
        next();
    }

    public Scene getScene(String id){
        return structureData.get(id);
    }

    public void next() {
        if(!now.getProcSkip())
            cb.setChecked(now.getReadFlag());
        String s;
        do{
            s = now.draw(act, this);
            if (structureData.containsKey(s)) {
                now = structureData.get(s);
            } else {
                now = structureData.get(firstScene);
            }
        }while(now.getProcSkip());
        debugPrintInfo();
    }

    public void setNext(String s){
        if(structureData.containsKey(s)) {
            now = structureData.get(s);
        }
        else {
            now = structureData.get(firstScene);
        }
        next();
        next();
    }

    public void debugPrintInfo(){
        String s = "";
        int n = 0;
        for(int m : regist){
            s += "["+n+":"+m +"] ";
            n++;
        }
        Log.d("debugPrintInfo",s);
    }

    private void initialize(){
        XmlPullParser xmlPullParser = Xml.newPullParser();
        try {
            xmlPullParser.setInput(act.getAssets().open("structure.xml"), "UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        int eventType = XmlPullParser.END_DOCUMENT;;
        try {
            eventType = xmlPullParser.getEventType();
        }catch (XmlPullParserException e){
            e.printStackTrace();
        }
        while(eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG && xmlPullParser.getName().equals("Scene")) {
                String id = "scene" + xmlPullParser.getAttributeValue(null, "id");
                try {
                    ParseScene.parse(xmlPullParser,structureData);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }
            }
            try {
                eventType = xmlPullParser.next();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for(String s : structureData.keySet()){
            Log.d("要素", "["+ s + structureData.get(s).toString() + "]");
        }
    }

    public Scene getNow(){
        return now;
    }

    class SkipThread implements Runnable{
        @Override
        public void run() {
            while(now.getReadFlag() && skipFlag && now.getNextNum()<=1){
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(0);
            }
            handler.sendEmptyMessage(1);
        }
    }
}
