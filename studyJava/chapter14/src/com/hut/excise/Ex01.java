package com.hut.excise;

import javax.sound.midi.SoundbankResource;
import java.util.ArrayList;
import java.util.Comparator;

public class Ex01 {
    public static void main(String[] args) {
        news new1 = new news("我是海蒂诗是哦我奇偶偶奇偶了陌陌");
        news new2 = new news(" as 打卡了卡掉");

        ArrayList arrayList = new ArrayList();
        arrayList.add(new1);
        arrayList.add(new2);

        int size = arrayList.size();
        for (int i = size - 1; i >= 0; i--) {
            news new_ = (news) arrayList.get(i);

            if (new_.getTitle().length() < 15) {
                System.out.println("不够十五字！");
            } else {
                new_.setTitle(new_.getTitle().substring(0, 15));
                System.out.println(arrayList.get(i));
            }
        }
    }
}
    class news {
        private String title;
        private String contends;

        public news(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContends() {
            return contends;
        }

        public void setContends(String contends) {
            this.contends = contends;
        }

        @Override
        public String toString() {
            return "title='" + title;
        }
    }