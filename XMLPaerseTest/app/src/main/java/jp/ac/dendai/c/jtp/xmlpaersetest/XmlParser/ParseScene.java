package jp.ac.dendai.c.jtp.xmlpaersetest.XmlParser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.HashMap;

import jp.ac.dendai.c.jtp.xmlpaersetest.Scene.BranchScene;
import jp.ac.dendai.c.jtp.xmlpaersetest.Scene.Next;
import jp.ac.dendai.c.jtp.xmlpaersetest.Scene.NormalScene;
import jp.ac.dendai.c.jtp.xmlpaersetest.Scene.Op.Operation;
import jp.ac.dendai.c.jtp.xmlpaersetest.Scene.ProcBranchScene;
import jp.ac.dendai.c.jtp.xmlpaersetest.Scene.ProcScene;
import jp.ac.dendai.c.jtp.xmlpaersetest.Scene.Scene;

/**
 * Created by Goto on 2016/05/20.
 */
public class ParseScene {
    public static void parse(XmlPullParser xpp,HashMap<String,Scene> hmp) throws XmlPullParserException,IOException{
        boolean isProcBranch = false;
        int eventId = xpp.getEventType();
        String type = getId("type", xpp);
        String id = getId("id",xpp);
        Scene sc = null;
        if(hmp.containsKey(id)){
            sc = hmp.get(id);
        }

        switch (type){
            case "normal":
                sc = new NormalScene(sc);
                sc.setId(id);
                sc.setTextId(getId("text", xpp));
                sc.setImageId(getId("image", xpp));
                sc.setProcSkip(false);
                isProcBranch = false;
                break;
            case "branch":
                sc = new BranchScene(sc);
                sc.setId(id);
                sc.setProcSkip(false);
                isProcBranch = false;
                break;
            case "proc_branch":
                sc = new ProcBranchScene(sc);
                sc.setId(id);
                ((ProcBranchScene)sc).setRegistId(Integer.valueOf(getId("regist", xpp)));
                ((ProcBranchScene)sc).setCons(ProcBranchScene.parsCondision(getId("condition", xpp)));
                sc.setProcSkip(true);
                isProcBranch = true;
                break;
            case "proc":
                sc = new ProcScene(sc);
                sc.setId(id);
                ((ProcScene)sc).setRegistIdAssign(Integer.valueOf(getId("regist_assign", xpp)));
                ((ProcScene)sc).setRegistIdOperand(Integer.valueOf(getId("regist_operand", xpp)));
                ((ProcScene)sc).setOp(Operation.valueOf(getId("op", xpp)));
                ((ProcScene)sc).setValue(Integer.valueOf(getId("value", xpp)));
                sc.setProcSkip(true);
                isProcBranch = false;
                break;
        }

        hmp.put(sc.getId(),sc);

        while(eventId != XmlPullParser.END_TAG || !xpp.getName().equals("Scene")){
            if(eventId ==XmlPullParser.START_TAG && xpp.getName().equals("Next")){
                String l_id = getId("id",xpp);
                Scene s = new Scene(l_id);
                sc.addNextId(l_id);
                if(!hmp.containsKey(l_id)){
                    hmp.put(l_id, s);
                }
                if(isProcBranch){
                    if(getId("value",xpp) != null) {
                        ((ProcBranchScene)sc).addNextItem(new Next(l_id,Integer.valueOf(getId("value",xpp))));
                    }
                    else {
                        ((ProcBranchScene)sc).addNextItem(new Next(l_id,0));
                    }
                }
            }
            eventId = xpp.next();
        }
    }

    public static String getId(String tag,XmlPullParser xpp){
        return xpp.getAttributeValue(null, tag);
    }
}
