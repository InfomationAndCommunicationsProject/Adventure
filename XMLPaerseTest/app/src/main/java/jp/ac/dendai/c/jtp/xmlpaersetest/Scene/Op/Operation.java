package jp.ac.dendai.c.jtp.xmlpaersetest.Scene.Op;

import jp.ac.dendai.c.jtp.xmlpaersetest.Game;

/**
 * Created by Goto on 2016/06/02.
 */
public enum Operation {
    Assign{
        @Override
        public void proc(int regist_assign,int regist_operand,int value) {
            Game.regist[regist_assign] = value;
        }
    },
    Add{
        @Override
        public void proc(int regist_assign,int regist_operand,int value) {
            Game.regist[regist_assign] = Game.regist[regist_operand] + value;
        }
    },
    Sub{
        @Override
        public void proc(int regist_assign,int regist_operand,int value) {
            Game.regist[regist_assign] = Game.regist[regist_operand] - value;
        }
    },
    Mult{
        @Override
        public void proc(int regist_assign,int regist_operand,int value) {
            Game.regist[regist_assign] = Game.regist[regist_operand] * value;
        }
    },
    Div{
        @Override
        public void proc(int regist_assign,int regist_operand,int value) {
            Game.regist[regist_assign] = Game.regist[regist_operand] / value;
        }
    },
    Mod{
        @Override
        public void proc(int regist_assign,int regist_operand,int value) {
            Game.regist[regist_assign] = Game.regist[regist_operand] % value;
        }
    },
    And{
        @Override
        public void proc(int regist_assign,int regist_operand,int value) {
            Game.regist[regist_assign] = Game.regist[regist_operand] & value;
        }
    },
    Or{
        @Override
        public void proc(int regist_assign,int regist_operand,int value) {
            Game.regist[regist_assign] = Game.regist[regist_operand] | value;
        }
    },
    Xor{
        @Override
        public void proc(int regist_assign,int regist_operand,int value) {
            Game.regist[regist_assign] = Game.regist[regist_operand] ^ value;
        }
    },
    LShift{
        @Override
        public void proc(int regist_assign,int regist_operand,int value) {
            Game.regist[regist_assign] = Game.regist[regist_operand] << value;
        }
    },
    RShift{
        @Override
        public void proc(int regist_assign,int regist_operand,int value) {
            Game.regist[regist_assign] = Game.regist[regist_operand] >> value;
        }
    },
    Regist_Add{
        @Override
        public void proc(int regist_assign,int regist_operand,int value) {
            Game.regist[regist_assign] = Game.regist[regist_operand] + Game.regist[value];
        }
    },
    Regist_Sub{
        @Override
        public void proc(int regist_assign,int regist_operand,int value) {
            Game.regist[regist_assign] = Game.regist[regist_operand] - Game.regist[value];
        }
    },
    Regist_Mult{
        @Override
        public void proc(int regist_assign,int regist_operand,int value){
            Game.regist[regist_assign] = Game.regist[regist_operand] * Game.regist[value];
        }
    },
    Regist_Div{
        @Override
        public void proc(int regist_assign,int regist_operand,int value){
            Game.regist[regist_assign] = Game.regist[regist_operand] / Game.regist[value];
        }
    },
    Regist_Mod{
        @Override
        public void proc(int regist_assign,int regist_operand,int value){
            Game.regist[regist_assign] = Game.regist[regist_operand] % Game.regist[value];
        }
    },
    Regist_And{
        @Override
        public void proc(int regist_assign,int regist_operand,int value){
            Game.regist[regist_assign] = Game.regist[regist_operand] & Game.regist[value];
        }
    },
    Regist_Or{
        @Override
        public void proc(int regist_assign,int regist_operand,int value){
            Game.regist[regist_assign] = Game.regist[regist_operand] | Game.regist[value];
        }
    },
    Regist_Xor{
        @Override
        public void proc(int regist_assign,int regist_operand,int value){
            Game.regist[regist_assign] = Game.regist[regist_operand] ^ Game.regist[value];
        }
    },
    Regist_LShift{
        @Override
        public void proc(int regist_assign,int regist_operand,int value){
            Game.regist[regist_assign] = Game.regist[regist_operand] << Game.regist[value];
        }
    },
    Regist_RShift{
        @Override
        public void proc(int regist_assign,int regist_operand,int value){
            Game.regist[regist_assign] = Game.regist[regist_operand] >> Game.regist[value];
        }
    };

    public abstract void proc(int regist_assign,int regist_operand,int value);
}
