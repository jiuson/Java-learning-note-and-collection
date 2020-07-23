package com.javabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: java-base
 * @Author chali
 * @Description
 * @Date 2020/7/20 5:42 下午
 */
public class TestEnum {
    
    public enum E {
        PASSED(1, "是否通过"),
        SUBJECTS(2, "科目通过数量"),
        SCORE(3, "分数"),
        RANK(2, "名次"),
        ONLINE(3, "网申");

        private final int value;
        private final String desc;

        E(int value, String dec) {
            this.value = value;
            this.desc = dec;
        }

        public static List<Map<Integer, String>> listProtocolRefundCondition() {
            List<Map<Integer, String>> protocolRefundConditionList = new ArrayList<>(4);
            for (E o : E.values()) {
                Map<Integer, String> condition = new HashMap<>(1);
                condition.put(o.value, o.desc);
                protocolRefundConditionList.add(condition);
            }
            return protocolRefundConditionList;
        }
    }

    public static void main(String[] args) {
        List<Map<Integer, String>> conditionList = E.listProtocolRefundCondition();
        System.out.println(conditionList);
    }
}
