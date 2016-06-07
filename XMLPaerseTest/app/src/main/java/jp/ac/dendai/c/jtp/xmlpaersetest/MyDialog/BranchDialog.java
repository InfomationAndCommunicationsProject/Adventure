package jp.ac.dendai.c.jtp.xmlpaersetest.MyDialog;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import java.util.LinkedList;

import jp.ac.dendai.c.jtp.xmlpaersetest.Game;
import jp.ac.dendai.c.jtp.xmlpaersetest.R;

/**
 * Created by Goto on 2016/05/20.
 */
public class BranchDialog extends DialogFragment{
    private Dialog dialog;
    private Game game;
    private String[] nexts;
    private String ownerScene;
    private Activity act;

    public void setGameInstance(Game game){
        this.game = game;
    }

    public void setBranchElements(LinkedList<String> nexts){
        this.nexts = nexts.toArray(new String[0]);
    }

    public void setOwnerScene(String owner){
        ownerScene = owner;
    }
    public void setActivity(Activity act){
        this.act = act;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        dialog = new Dialog(getActivity(), R.style.TransparentDialogTheme);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        dialog.setContentView(R.layout.branch_dialog);
        dialog.setCanceledOnTouchOutside(false);
        setCancelable(false);
        Button bt;
        for(int n = 0;n < nexts.length;n++){
            switch (n) {
                case 1:
                    bt = (Button) dialog.findViewById(R.id.button1);
                    break;
                case 2:
                    bt = (Button) dialog.findViewById(R.id.button2);
                    break;
                case 3:
                    bt = (Button) dialog.findViewById(R.id.button3);
                    break;
                default:
                    bt = (Button) dialog.findViewById(R.id.button0);
                    break;
            }
            bt.setVisibility(Button.VISIBLE);
            bt.setOnClickListener(new BranchOnClickListener(n));
            bt.setText(act.getResources().getIdentifier("scene_"+ownerScene+"_branch_"+nexts[n],"string",act.getPackageName()));
        }
        return dialog;
    }

    private class BranchOnClickListener implements View.OnClickListener {
        private int n;
        public BranchOnClickListener(int n){
            this.n = n;
        }
        @Override
        public void onClick(View v) {
            game.setNext(nexts[n]);
            dismiss();
        }
    }
}
