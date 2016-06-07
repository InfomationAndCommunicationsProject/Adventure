package jp.ac.dendai.c.jtp.xmlpaersetest.Scene.Op;

import jp.ac.dendai.c.jtp.xmlpaersetest.Game;

/**
 * Created by Goto on 2016/06/02.
 */
public enum Operation {
    Assign{
        @Override
        public void proc(int registId, int value) {
            Game.regist[registId] = value;
        }
    },
    Add{
        @Override
        public void proc(int registId, int value) {
            Game.regist[registId] += value;
        }
    },
    Sub{
        @Override
        public void proc(int registId, int value) {
            Game.regist[registId] -= value;
        }
    },
    Mult{
        @Override
        public void proc(int registId, int value) {
            Game.regist[registId] *= value;
        }
    },
    Div{
        @Override
        public void proc(int registId, int value) {
            Game.regist[registId] /= value;
        }
    },
    Mod{
        @Override
        public void proc(int registId, int value) {
            Game.regist[registId] %= value;
        }
    },
    Regist_Add{
        @Override
        public void proc(int registId, int value) {
            Game.regist[registId] += Game.regist[value];
        }
    },
    Regist_Sub{
        @Override
        public void proc(int registId, int value) {
            Game.regist[registId] -= Game.regist[value];
        }
    },
    Regist_Mult{
        @Override
        public void proc(int registId, int value) {
            Game.regist[registId] *= Game.regist[value];
        }
    },
    Regist_Div{
        @Override
        public void proc(int registId, int value) {
            Game.regist[registId] /= Game.regist[value];
        }
    },
    Regist_Mod{
        @Override
        public void proc(int registId, int value) {
            Game.regist[registId] %= Game.regist[value];
        }
    };

    public abstract void proc(int registId,int value);
}
