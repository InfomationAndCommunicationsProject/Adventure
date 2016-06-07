package jp.ac.dendai.c.jtp.xmlpaersetest.Scene.Op;

import jp.ac.dendai.c.jtp.xmlpaersetest.Game;

/**
 * Created by Goto on 2016/06/02.
 */
public enum Conditions {
    n{
        @Override
        public boolean proc(int regist, int value) {
            return Game.regist[regist] != value;
        }
    },
    e{
        @Override
        public boolean proc(int regist, int value) {
            return Game.regist[regist] == value;
        }
    },
    l{
        @Override
        public boolean proc(int regist, int value) {
            return Game.regist[regist] < value;
        }
    },
    g{
        @Override
        public boolean proc(int regist, int value) {
            return Game.regist[regist] > value;
        }
    },
    le{
        @Override
        public boolean proc(int regist, int value) {
            return Game.regist[regist] <= value;
        }
    },
    ge{
        @Override
        public boolean proc(int regist, int value) {
            return Game.regist[regist] >= value;
        }
    },
    r_n{
        @Override
        public boolean proc(int regist, int value) {
            return Game.regist[regist] != Game.regist[value];
        }
    },
    r_e{
        @Override
        public boolean proc(int regist, int value) {
            return Game.regist[regist] == Game.regist[value];
        }
    },
    r_l{
        @Override
        public boolean proc(int regist, int value) {
            return Game.regist[regist] < Game.regist[value];
        }
    },
    r_g{
        @Override
        public boolean proc(int regist, int value) {
            return Game.regist[regist] > Game.regist[value];
        }
    },
    r_le{
        @Override
        public boolean proc(int regist, int value) {
            return Game.regist[regist] <= Game.regist[value];
        }
    },
    r_ge{
        @Override
        public boolean proc(int regist, int value) {
            return Game.regist[regist] >= Game.regist[value];
        }
    };

    public abstract boolean proc(int regist,int value);
}
