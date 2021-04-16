package tree;

import org.junit.Test;

import java.util.*;

/**
 * 数据压缩
 */
public class HuffmanCode {
    /**
     * 赫夫曼树对应的编码表
     */
    static Map<Byte, String> huffmanCode = new HashMap<>();
    /**
     * 存放路径
     */
    static StringBuilder stringBuilder = new StringBuilder();

    public static byte[] huffmanZip(byte[] bytes){
        List<Nodes> nodes = getNodes(bytes);
        Nodes no = creatHuffmanTree(nodes);
        preOrder(no);

        Map<Byte, String> codes = getCodes(no);
//        System.out.println("ASC" + "\t\t赫夫曼编码");
//        for (Map.Entry<Byte, String> entry : codes.entrySet()) {
//            System.out.println(entry.getKey() + "\t\t" + entry.getValue());
//        }
        //System.out.println("赫夫曼表\n" + codes);
        return zip(bytes, codes);
    }

    /**
     * node结点放入list中
     *
     * @param bytes
     * @return
     */
    public static List<Nodes> getNodes(byte[] bytes) {
        List<Nodes> list = new ArrayList<>();
        /**
         * byte：数据本身
         * Integer： 出现的次数
         */
        Map<Byte, Integer> map = new HashMap<>();
        for (byte b : bytes) {
            Integer count = map.get(b);
            if (count == null) {     //第一次出现
                map.put(b, 1);
            } else {                 //不等于空 该数据计数 + 1；
                map.put(b, count + 1);
            }
        }

        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            list.add(new Nodes(entry.getKey(), entry.getValue()));
        }
        return list;
    }

    /**
     * 创建赫夫曼树
     *
     * @param list
     * @return
     */
    public static Nodes creatHuffmanTree(List<Nodes> list) {
        /**
         * 当集合中只有一条数据就结束
         * 根节点
         */
        while (list.size() > 1) {
            /**
             * 从小到大
             */
            Collections.sort(list);
            /**
             * 获取最小的
             */
            Nodes lifeNodes = list.get(0);
            Nodes rightNodes = list.get(1);
            /**
             * 创建一颗新树
             */
            Nodes parent = new Nodes(null, lifeNodes.weight + rightNodes.weight);
            parent.life = lifeNodes;
            parent.right = rightNodes;
            list.remove(lifeNodes);
            list.remove(rightNodes);
            list.add(parent);
        }
        return list.get(0);
    }

    /**
     * 前序遍历
     * @param root  根结点
     */
    public static void preOrder(Nodes root) {
        if (root != null) {
            root.preOrder();
        } else {
            throw new RuntimeException("结点为空...");
        }
    }

    public static Map<Byte, String> getCodes(Nodes root) {
        if (root != null) {
            getCodes(root.life, "0", stringBuilder);
            getCodes(root.right, "1", stringBuilder);
        }
        return huffmanCode;
    }

    /**
     * 创建赫夫曼字符串
     *
     * @param node           传入的结点
     * @param code           life = 0; right = 1;
     * @param stringBuilder1 拼接路径
     */
    public static void getCodes(Nodes node, String code, StringBuilder stringBuilder1) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder1);
        stringBuilder2.append(code);
        if (node != null) {    //如果传入的结点不是空的
            if (node.data == null) {  //如果是非叶子结点
                getCodes(node.life, "0", stringBuilder2);
                getCodes(node.right, "1", stringBuilder2);
            } else {
                huffmanCode.put(node.data, stringBuilder2.toString());
            }
        }
    }

    /**
     * 压缩赫夫曼编码
     *
     * @param bytes 原始字符串对应的byte[]
     * @param map   生成赫夫曼编码的map
     * @return    赫夫曼编码对应的byte[]   八位一个
     *          10101000(补码)->10100111(-1)->11011000(取反)->-88
     */
    public static byte[] zip(byte[] bytes, Map<Byte, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        /**
         * 利用HuffmanCode 将bytes 转成赫夫曼编码对应的字符串
         */
        for (byte a : bytes) {
            stringBuilder.append(map.get(a));
        }
        System.out.println(stringBuilder);
        /**
         * 一个byte 是八位
         * .'. 一个byte[]放入八个
         *  统计byte[]的长度
         *      如果数据长度 % 8 = 0
         *      说明刚好数组的长度就是 数据长度 / 8
         *      % 8 !=0
         *      说明 数组的长度 后面 多出的数据 需要再加一个长度放入
         */
        int leng;
        if (stringBuilder.length() % 8 == 0) {
            leng = stringBuilder.length() / 8;
        } else {
            leng = stringBuilder.length() / 8 + 1;
        }

        byte[] huffmanCodeByte = new byte[leng];
        /**
         * 计数 byte[第几个]
         */
        int index = 0;
        /**
         * 每次取出8个
         */
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String str = null;
            /**
             * if 说明stringBuilder里的数据 不足 八个
             *      就直接取出剩下的
             * else 说明 从 i 到 i+8 取出中间的数据
             */
            if (i + 8 > stringBuilder.length()) {
                str = stringBuilder.substring(i);
            } else {
                str = stringBuilder.substring(i, i + 8);
            }
            huffmanCodeByte[index] = (byte) Integer.parseInt(str, 2);
            index++;
        }
        return huffmanCodeByte;
    }

    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        /**
         * 放入byte数组中
         */
        byte[] bytes = str.getBytes();
        System.out.println("压缩前的长度:"+bytes.length);
        System.out.println(Arrays.toString(bytes));

        byte[] zip = huffmanZip(bytes);
        System.out.println(Arrays.toString(zip));
        System.out.println("压缩后的长度:"+zip.length);
    }

    @Test
    public void test(){
        String str = "1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100";
//        byte i = (byte)Integer.parseInt(str, 2);
//        System.out.println(i);
        
        String n = null;
        for (int i1 = 0; i1 < str.length(); i1+=8) {
            if (i1+8>str.length()) {
                n = str.substring(i1);
            }else {
                str.substring(i1, i1 + 8);
            }
        }
        System.out.println(n);
    }
}

class Nodes implements Comparable<Nodes> {
    Byte data;     //存放数据本身
    int weight;    //权值 出现次数
    Nodes life;
    Nodes right;

    public Nodes(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Nodes{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    public void preOrder() {
        System.out.println(this);
        if (this.life != null) {
            this.life.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public int compareTo(Nodes o) {
        return this.weight - o.weight;
    }
}

