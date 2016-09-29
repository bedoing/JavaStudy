package com.duwei.encrypt;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Ƶ�ʷ������ƽ⿭������
 * http://blog.csdn.net/axi295309066/article/details/52491077
 */
public class FrequencyAnalysis {
    //Ӣ������ִ��������ַ�
    private static final char MAGIC_CHAR = 'e';
    //�ƽ����ɵ�����ļ���
    private static final int DE_MAX_FILE = 4;

    public static void main(String[] args) throws Exception {
        //����1��ͳ���ַ�����
        //printCharCount("article1_en.txt");

        //�����ļ�
        //int key = 3;
        //encryptFile("article1.txt", "article1_en.txt", key);

        //��ȡ���ܺ���ļ�
        String artile = file2String("article1_en.txt");
        //���ܣ������ɶ����ѡ�ļ���
        decryptCaesarCode(artile, "article1_de.txt");
    }

    public static void printCharCount(String path) throws IOException{
        String data = file2String(path);
        List<Entry<Character, Integer>> mapList = getMaxCountChar(data);
        for (Entry<Character, Integer> entry : mapList) {
            //���ǰ��λ��ͳ����Ϣ
            System.out.println("�ַ�'" + entry.getKey() + "'����" + entry.getValue() + "��");
        }
    }

    public static void encryptFile(String srcFile, String destFile, int key) throws IOException {
        String artile = file2String(srcFile);
        //�����ļ�
        String encryptData = MyEncrypt.encrypt(artile, key);
        //������ܺ���ļ�
        string2File(encryptData, destFile);
    }

    /**
     * �ƽ⿭������
     * @param input ����Դ
     * @return ���ؽ��ܺ������
     */
    public static void decryptCaesarCode(String input, String destPath) {
        int deCount = 0;//��ǰ�������ɵı�ѡ�ļ���
        //��ȡ����Ƶ����ߵ��ַ���Ϣ�����ִ���Խ��Խ��ǰ��
        List<Entry<Character, Integer>> mapList = getMaxCountChar(input);
        for (Entry<Character, Integer> entry : mapList) {
            //���ƽ����ļ���ѡ��
            if (deCount >= DE_MAX_FILE) {
                break;
            }

            //���ǰ��λ��ͳ����Ϣ
            System.out.println("�ַ�'" + entry.getKey() + "'����" + entry.getValue() + "��");

            ++deCount;
            //���ִ�����ߵ��ַ���MAGIC_CHAR��ƫ������Ϊ��Կ
            int key = entry.getKey() - MAGIC_CHAR;
            System.out.println("�²�key = " + key + "�� �������ɵ�" + deCount + "����ѡ�ļ�" + "\n");
            String decrypt = MyEncrypt.decrypt(input, key);

            String fileName = "de_" + deCount + destPath;
            string2File(decrypt, fileName);
        }
    }

    //ͳ��String����������ַ�
    public static List<Entry<Character, Integer>> getMaxCountChar(String data) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] array = data.toCharArray();
        for (char c : array) {
            if(!map.containsKey(c)) {
                map.put(c, 1);
            }else{
                Integer count = map.get(c);
                map.put(c, count + 1);
            }
        }

        //���ͳ����Ϣ
        /*for (Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "����" + entry.getValue() +  "��");
        }*/

        //��ȡ��ȡ���ֵ
        int maxCount = 0;
        for (Entry<Character, Integer> entry : map.entrySet()) {
            //��ͳ�ƿո�
            if (/*entry.getKey() != ' ' && */entry.getValue() > maxCount) { 
                maxCount = entry.getValue();
            }
        }

        //mapת����list��������
        List<Entry<Character, Integer>> mapList = new ArrayList<Map.Entry<Character,Integer>>(map.entrySet());
        //�����ַ����ִ�������
        Collections.sort(mapList, new Comparator<Entry<Character, Integer>>(){
            @Override
            public int compare(Entry<Character, Integer> o1,
                    Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return mapList;
    }

    public static String file2String(String path) throws IOException {
        FileReader reader = new FileReader(new File(path));
        char[] buffer = new char[1024];
        int len = -1;
        StringBuffer sb = new StringBuffer();
        while ((len = reader.read(buffer)) != -1) {
            sb.append(buffer, 0, len);
        }
        return sb.toString();
    }

    public static void string2File(String data, String path){
        FileWriter writer = null;
        try {
            writer = new FileWriter(new File(path));
            writer.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}