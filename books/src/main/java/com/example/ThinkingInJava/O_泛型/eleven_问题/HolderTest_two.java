package com.example.ThinkingInJava.O_泛型.eleven_问题;

/**
 * Created by heshixiyang on 2017/1/20.
 */
public class HolderTest_two {

    public static class HolderInt{
        private int item;

        public HolderInt(int item) {
            this.item = item;
        }

        public int getItem() {
            return item;
        }

        public void setItem(int item) {
            this.item = item;
        }
    }

    public static class HolderLong{
        private long item;

        public HolderLong(long item) {
            this.item = item;
        }

        public long getItem() {
            return item;
        }

        public void setItem(long item) {
            this.item = item;
        }
    }
    public static class HolderByte{
        private byte item;

        public HolderByte(byte item) {
            this.item = item;
        }

        public byte getItem() {
            return item;
        }

        public void setItem(byte item) {
            this.item = item;
        }
    }
    public static class HolderFloat{
        private float item;

        public HolderFloat(float item) {
            this.item = item;
        }

        public float getItem() {
            return item;
        }

        public void setItem(float item) {
            this.item = item;
        }
    }

    /*
    * 练习30
    * */
    public static void main(String[] args) {
        HolderInt holderInt=new HolderInt(1);
        HolderLong holderLong=new HolderLong(1L);
        HolderByte holderByte=new HolderByte((byte) 1);
        HolderFloat holderFloat=new HolderFloat(1.1f);

        holderInt.setItem(2);
        holderInt.setItem(new Integer(2));
        holderInt.getItem();

        holderLong.setItem(2l);
        holderLong.setItem(new Long(2l));
        holderLong.getItem();

        holderByte.setItem((byte) 1);
        holderByte.setItem(new Byte((byte) 1));
        holderByte.getItem();

        holderFloat.setItem(1.2f);
        holderFloat.setItem(new Float(1.2F));
        holderFloat.getItem();
    }
}
