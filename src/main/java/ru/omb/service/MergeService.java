package ru.omb.service;

import com.opencsv.CSVReader;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.springframework.stereotype.Service;
import ru.omb.entity.FirstObject;
import ru.omb.entity.SecondObject;
import ru.omb.entity.ThirdObject;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.io.FileWriter;
import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

@Service
public class MergeService {

//    public static void main(String[] args) {
//        String[] listFile = createFirstObject();
//        List<String> listCSV = findCSVFile2();
//        for (String csvFile :listCSV) {
//            readDataLineByLine(csvFile);
//        }
//         readDataLineByLine(listCSV.get(0));
//        Integer i = null;
//        System.out.println(i);
//    }

    public void zipOut(String archiveName) throws IOException {
        String dir = System.getProperty("user.dir") + "/upload-dir/";
        ZipFile zip = new ZipFile(dir + archiveName);
        Enumeration entries = zip.entries();
        while(entries.hasMoreElements()) {
            ZipEntry entry  = (ZipEntry) entries.nextElement();
//            System.out.println(entry .getName());
//            System.out.println(entry .getSize());
            if (!entry .isDirectory()) {
                write(zip.getInputStream(entry), new BufferedOutputStream(new FileOutputStream(
                        dir + entry.getName())
                        )
                );
            }
        }
    }

    private static void write(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[102400];
        int len;
        while ((len = in.read(buffer)) >= 0)
            out.write(buffer, 0, len);
        out.close();
        in.close();
    }

    public List<String> findCSVFile() {
        String dir = System.getProperty("user.dir") + "/upload-dir/";
        File fileDir = new File(dir);
        List<String> listCSVFile = new ArrayList<>();
        String[] listFile = fileDir.list();
        for (String file: listFile) {
            if (file.substring(file.length() - 3).equals("csv")) {
                listCSVFile.add(file);
//                System.out.println(file);
            }
        }
        return listCSVFile;
    }

    // Заполненеие данными первого объекта
    public FirstObject readDataLineToFirstObject()  {
        FirstObject firstObject = new FirstObject();
        try {
            String dir = System.getProperty("user.dir") + "/upload-dir/";
            List<String> listCSV = findCSVFile();
            for (String file : listCSV) {
                FileReader filereader = new FileReader(dir + file);
                CSVReader csvReader = new CSVReader(filereader);
                String[] nextRecord;
                while ((nextRecord = csvReader.readNext()) != null) {
                    for (int i = 0; i < nextRecord.length; i++) {
                        System.out.print(nextRecord[i] + "\t");
                        if (nextRecord[i].equalsIgnoreCase("mark01") && (i < nextRecord.length)) {
                            if (!nextRecord[i + 1].equals("")) {
                                if (firstObject.getMark01() != null) {
                                    firstObject.setMark01(firstObject.getMark01() + Integer.valueOf(nextRecord[i + 1]));
                                } else {
                                    firstObject.setMark01(Integer.valueOf(nextRecord[i + 1]));
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("mark17") && (i < nextRecord.length)) {
                            if (!nextRecord[i + 1].equals("")) {
                                if (firstObject.getMark17() != null) {
                                    firstObject.setMark17(firstObject.getMark17() + Integer.valueOf(nextRecord[i + 1]));
                                } else {
                                    firstObject.setMark17(Integer.valueOf(nextRecord[i + 1]));
                                }
                            }

                        } else if (nextRecord[i].equalsIgnoreCase("mark23") && (i < nextRecord.length)) {
                            if (!nextRecord[i + 1].equals("")) {
                                if (firstObject.getMark23() != null) {
                                    firstObject.setMark23(firstObject.getMark23() + Integer.valueOf(nextRecord[i + 1]));
                                } else {
                                    firstObject.setMark23(Integer.valueOf(nextRecord[i + 1]));
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("mark35") && (i < nextRecord.length)) {
                            if (!nextRecord[i + 1].equals("")) {
                                if (firstObject.getMark35() != null) {
                                    firstObject.setMark35(firstObject.getMark35() + Integer.valueOf(nextRecord[i + 1]));
                                } else {
                                    firstObject.setMark35(Integer.valueOf(nextRecord[i + 1]));
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("markFV") && (i < nextRecord.length)) {
                            if (!nextRecord[i + 1].equals("")) {
                                if (firstObject.getMarkFV() != null) {
                                    firstObject.setMarkFV(firstObject.getMarkFV() + Integer.valueOf(nextRecord[i + 1]));
                                } else {
                                    firstObject.setMarkFV(Integer.valueOf(nextRecord[i + 1]));
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("markFX") && (i < nextRecord.length)) {
                            if (!nextRecord[i + 1].equals("")) {
                                if (firstObject.getMarkFX() != null) {
                                    firstObject.setMarkFX(firstObject.getMarkFX() + Integer.valueOf(nextRecord[i + 1]));
                                } else {
                                    firstObject.setMarkFX(Integer.valueOf(nextRecord[i + 1]));
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("markFT") && (i < nextRecord.length)) {
                            if (!nextRecord[i + 1].equals("")) {
                                if (firstObject.getMarkFT() != null) {
                                    firstObject.setMarkFT(firstObject.getMarkFT() + Integer.valueOf(nextRecord[i + 1]));
                                } else {
                                    firstObject.setMarkFT(Integer.valueOf(nextRecord[i + 1]));
                                }
                            }
                        }
                    }
                    System.out.println();
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return firstObject;
    }

    // Заполнение данными второго объекта
    public SecondObject readDataLineToSecondObject()  {
        SecondObject secondObject = new SecondObject();
        try {
            String dir = System.getProperty("user.dir") + "/upload-dir/";
            List<String> listCSV = findCSVFile();
            for (String file : listCSV) {
                FileReader filereader = new FileReader(dir + file);
                CSVReader csvReader = new CSVReader(filereader);
                String[] nextRecord;
                while ((nextRecord = csvReader.readNext()) != null) {
                    for (int i = 0; i < nextRecord.length; i++) {
                        if (nextRecord[i].equalsIgnoreCase("mark01") && (i < nextRecord.length)) {
                            if (!nextRecord[i + 1].equals("")) {
                                if (secondObject.getMark01() != null) {
                                    secondObject.setMark01(secondObject.getMark01() + Integer.valueOf(nextRecord[i + 1]));
                                } else {
                                    secondObject.setMark01(Integer.valueOf(nextRecord[i + 1]));
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("mark17") && (i < nextRecord.length)) {
                            if (!nextRecord[i + 1].equals("")) {
                                if (secondObject.getMark17() != null) {
                                    secondObject.setMark17(secondObject.getMark17() + Integer.valueOf(nextRecord[i + 1]));
                                } else {
                                    secondObject.setMark17(Integer.valueOf(nextRecord[i + 1]));
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("mark23") && (i < nextRecord.length)) {
                            if (!nextRecord[i + 1].equals("")) {
                                if (secondObject.getMark23() != null) {
                                    secondObject.setMark23(secondObject.getMark23() + Integer.valueOf(nextRecord[i + 1]));
                                } else {
                                    secondObject.setMark23(Integer.valueOf(nextRecord[i + 1]));
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("mark35") && (i < nextRecord.length)) {
                            if (!nextRecord[i + 1].equals("")) {
                                if (secondObject.getMark35() != null) {
                                    secondObject.setMark35(secondObject.getMark35() + Integer.valueOf(nextRecord[i + 1]));
                                } else {
                                    secondObject.setMark35(Integer.valueOf(nextRecord[i + 1]));
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("markFV") && (i < nextRecord.length)) {
                            if (!nextRecord[i + 1].equals("")) {
                                if (secondObject.getMarkFV() != null) {
                                    secondObject.setMarkFV(secondObject.getMarkFV() + Integer.valueOf(nextRecord[i + 1]));
                                } else {
                                    secondObject.setMarkFV(Integer.valueOf(nextRecord[i + 1]));
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("markFX") && (i < nextRecord.length)) {
                            if (!nextRecord[i + 1].equals("")) {
                                if (secondObject.getMarkFX() != null) {
                                    secondObject.setMarkFX(secondObject.getMarkFX() + Integer.valueOf(nextRecord[i + 1]));
                                } else {
                                    secondObject.setMarkFX(Integer.valueOf(nextRecord[i + 1]));
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("markFT") && (i < nextRecord.length)) {
                            if (!nextRecord[i + 1].equals("")) {
                                if (secondObject.getMarkFT() != null) {
                                    secondObject.setMarkFT(secondObject.getMarkFT() + Integer.valueOf(nextRecord[i + 1]));
                                } else {
                                    secondObject.setMarkFT(Integer.valueOf(nextRecord[i + 1]));
                                }
                            }
                        }
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return secondObject;
    }

    // Заполнение данными третьего объекта
    public ThirdObject readDataLineToThierdObject()  {
        ThirdObject thirdObject = new ThirdObject();
        List<Integer> mark01 = new ArrayList<>();
        List<Integer> mark17 = new ArrayList<>();
        List<Integer> mark23 = new ArrayList<>();
        List<Integer> mark35 = new ArrayList<>();
        List<Integer> markFV = new ArrayList<>();
        List<Integer> markFX = new ArrayList<>();
        List<Integer> markFT = new ArrayList<>();
        try {
            String dir = System.getProperty("user.dir") + "/upload-dir/";
            List<String> listCSV = findCSVFile();
            for (String file : listCSV) {
                FileReader filereader = new FileReader(dir + file);
                CSVReader csvReader = new CSVReader(filereader);
                String[] nextRecord;
                while ((nextRecord = csvReader.readNext()) != null) {
                    for (int i = 0; i < nextRecord.length; i++) {
                        if (nextRecord[i].equalsIgnoreCase("mark01") && (i < nextRecord.length)) {
                            if (!nextRecord[i + 1].equals("")) {
                                mark01.add(Integer.valueOf(nextRecord[i + 1]));
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("mark17") && (i < nextRecord.length)) {
                            if (!nextRecord[i + 1].equals("")) {
                                mark17.add(Integer.valueOf(nextRecord[i + 1]));
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("mark23") && (i < nextRecord.length)) {
                            if (!nextRecord[i + 1].equals("")) {
                                mark23.add(Integer.valueOf(nextRecord[i + 1]));
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("mark35") && (i < nextRecord.length)) {
                            if (!nextRecord[i + 1].equals("")) {
                                mark35.add(Integer.valueOf(nextRecord[i + 1]));
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("markFV") && (i < nextRecord.length)) {
                            if (!nextRecord[i + 1].equals("")) {
                                markFV.add(Integer.valueOf(nextRecord[i + 1]));
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("markFX") && (i < nextRecord.length)) {
                            if (!nextRecord[i + 1].equals("")) {
                                markFX.add(Integer.valueOf(nextRecord[i + 1]));
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("markFT") && (i < nextRecord.length)) {
                            if (!nextRecord[i + 1].equals("")) {
                                markFT.add(Integer.valueOf(nextRecord[i + 1]));
                            }
                        }
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        // Сортировка в порядке убывывания
        Collections.sort(mark01, Collections.reverseOrder());
        Collections.sort(mark17, Collections.reverseOrder());
        Collections.sort(mark23, Collections.reverseOrder());
        Collections.sort(mark35, Collections.reverseOrder());
        Collections.sort(markFT, Collections.reverseOrder());
        Collections.sort(markFV, Collections.reverseOrder());
        Collections.sort(markFX, Collections.reverseOrder());
        thirdObject.setMark01(mark01);
        thirdObject.setMark17(mark17);
        thirdObject.setMark23(mark23);
        thirdObject.setMark35(mark35);
        thirdObject.setMarkFT(markFT);
        thirdObject.setMarkFV(markFV);
        thirdObject.setMarkFX(markFX);
        return thirdObject;
    }
}
