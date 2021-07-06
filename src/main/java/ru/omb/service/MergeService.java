package ru.omb.service;

import com.opencsv.CSVReader;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.omb.entity.FirstObject;
import ru.omb.entity.SecondObject;
import ru.omb.entity.ThirdObject;
import ru.omb.exception.CsvIllegalArgumentException;

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

    private static final Logger LOG = LoggerFactory.getLogger(MergeService.class);

    public void zipOut(String archiveName) throws IOException {
        String dir = System.getProperty("user.dir") + "/upload-dir/";
        ZipFile zip = new ZipFile(dir + archiveName);
        Enumeration entries = zip.entries();
        while(entries.hasMoreElements()) {
            ZipEntry entry  = (ZipEntry) entries.nextElement();
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

    // Нахождение всех csv файлов в папке upload-dir
    public List<String> findCSVFile(String dirCsv) {
        String dir = System.getProperty("user.dir") + dirCsv;
        File fileDir = new File(dir);
        List<String> listCSVFile = new ArrayList<>();
        String[] listFile = fileDir.list();
        for (String file : listFile) {
            if (file.substring(file.length() - 3).equalsIgnoreCase("csv")) {
                listCSVFile.add(file);
            }
        }
        return listCSVFile;
    }

    // Заполнение данными первого объекта
    public FirstObject readDataLineToFirstObject(String dirCsv)  {
        FirstObject firstObject = new FirstObject();
        try {
            String dir = System.getProperty("user.dir") + dirCsv;
            List<String> listCSV = findCSVFile(dirCsv);
            for (String file : listCSV) {
                FileReader filereader = new FileReader(dir + file);
                CSVReader csvReader = new CSVReader(filereader);
                String[] nextRecord;
                while ((nextRecord = csvReader.readNext()) != null) {
                    for (int i = 0; (i + 1)< nextRecord.length; i++) {
                        if (nextRecord[i].equalsIgnoreCase("mark01")) {
                            if (!nextRecord[i + 1].equals("")) {
                                try {
                                    if (firstObject.getMark01() != null) {
                                        firstObject.setMark01(firstObject.getMark01() + Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("В первый объект добавлено значение {} к метке mark01", nextRecord[i + 1]);
                                    } else {
                                        firstObject.setMark01(Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("В первый объект добавлено значение {} к метке mark01", nextRecord[i + 1]);
                                    }
                                } catch (NumberFormatException nfe) {
                                    throw new CsvIllegalArgumentException(nextRecord[i + 1] , "mark01", nfe);
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("mark17")) {
                            if (!nextRecord[i + 1].equals("")) {
                                try {
                                    if (firstObject.getMark17() != null) {
                                        firstObject.setMark17(firstObject.getMark17() + Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("В первый объект добавлено значение {} к метке mark17", nextRecord[i + 1]);
                                    } else {
                                        firstObject.setMark17(Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("В первый объект добавлено значение {} к метке mark17", nextRecord[i + 1]);
                                    }
                                } catch (NumberFormatException nfe) {
                                    throw new CsvIllegalArgumentException(nextRecord[i + 1] , "mark17", nfe);
                                }
                            }

                        } else if (nextRecord[i].equalsIgnoreCase("mark23")) {
                            if (!nextRecord[i + 1].equals("")) {
                                try {
                                    if (firstObject.getMark23() != null) {
                                        firstObject.setMark23(firstObject.getMark23() + Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("В первый объект добавлено значение {} к метке mark23", nextRecord[i + 1]);
                                    } else {
                                        firstObject.setMark23(Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("В первый объект добавлено значение {} к метке mark23", nextRecord[i + 1]);
                                    }
                                } catch (NumberFormatException nfe) {
                                    throw new CsvIllegalArgumentException(nextRecord[i + 1] , "mark23", nfe);
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("mark35")) {
                            if (!nextRecord[i + 1].equals("")) {
                                try {
                                    if (firstObject.getMark35() != null) {
                                        firstObject.setMark35(firstObject.getMark35() + Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("В первый объект добавлено значение {} к метке mark35", nextRecord[i + 1]);
                                    } else {
                                        firstObject.setMark35(Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("В первый объект добавлено значение {} к метке mark35", nextRecord[i + 1]);
                                    }
                                } catch (NumberFormatException nfe) {
                                    throw new CsvIllegalArgumentException(nextRecord[i + 1] , "mark35", nfe);
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("markFV")) {
                            if (!nextRecord[i + 1].equals("")) {
                                try {
                                    if (firstObject.getMarkFV() != null) {
                                        firstObject.setMarkFV(firstObject.getMarkFV() + Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("В первый объект добавлено значение {} к метке markFV", nextRecord[i + 1]);
                                    } else {
                                        firstObject.setMarkFV(Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("В первый объект добавлено значение {} к метке markFV", nextRecord[i + 1]);
                                    }
                                } catch (NumberFormatException nfe) {
                                    throw new CsvIllegalArgumentException(nextRecord[i + 1] , "markFV", nfe);
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("markFX")) {
                            if (!nextRecord[i + 1].equals("")) {
                                try {
                                    if (firstObject.getMarkFX() != null) {
                                        firstObject.setMarkFX(firstObject.getMarkFX() + Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("В первый объект добавлено значение {} к метке markFV", nextRecord[i + 1]);
                                    } else {
                                        firstObject.setMarkFX(Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("В первый объект добавлено значение {} к метке markFV", nextRecord[i + 1]);
                                    }
                                } catch (NumberFormatException nfe) {
                                    throw new CsvIllegalArgumentException(nextRecord[i + 1] , "markFХ", nfe);
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("markFT")) {
                            if (!nextRecord[i + 1].equals("")) {
                                try {
                                    if (firstObject.getMarkFT() != null) {
                                        firstObject.setMarkFT(firstObject.getMarkFT() + Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("В первый объект добавлено значение {} к метке markFT", nextRecord[i + 1]);
                                    } else {
                                        firstObject.setMarkFT(Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("В первый объект добавлено значение {} к метке markFT", nextRecord[i + 1]);
                                    }
                                } catch (NumberFormatException nfe) {
                                    throw new CsvIllegalArgumentException(nextRecord[i + 1] , "markFT", nfe);
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
        return firstObject;
    }

    // Заполнение данными второго объекта
    public SecondObject readDataLineToSecondObject(String dirCsv)  {
        SecondObject secondObject = new SecondObject();
        try {
            String dir = System.getProperty("user.dir") + dirCsv;
            List<String> listCSV = findCSVFile(dirCsv);
            for (String file : listCSV) {
                FileReader filereader = new FileReader(dir + file);
                CSVReader csvReader = new CSVReader(filereader);
                String[] nextRecord;
                while ((nextRecord = csvReader.readNext()) != null) {
                    for (int i = 0; (i + 1) < nextRecord.length; i++) {
                        if (nextRecord[i].equalsIgnoreCase("mark01")) {
                            if (!nextRecord[i + 1].equals("")) {
                                try {
                                    if (secondObject.getMark01() != null) {
                                        secondObject.setMark01(secondObject.getMark01() + Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("Во второй объект добавлено значение {} к метке mark01", nextRecord[i + 1]);
                                    } else {
                                        secondObject.setMark01(Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("Во второй объект добавлено значение {} к метке mark01", nextRecord[i + 1]);
                                    }
                                } catch (NumberFormatException nfe) {
                                    throw new CsvIllegalArgumentException(nextRecord[i + 1], "mark01", nfe);
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("mark17")) {
                            if (!nextRecord[i + 1].equals("")) {
                                try {
                                    if (secondObject.getMark17() != null) {
                                        secondObject.setMark17(secondObject.getMark17() + Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("Во второй объект добавлено значение {} к метке mark17", nextRecord[i + 1]);
                                    } else {
                                        secondObject.setMark17(Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("Во второй объект добавлено значение {} к метке mark17", nextRecord[i + 1]);
                                    }
                                } catch (NumberFormatException nfe) {
                                    throw new CsvIllegalArgumentException(nextRecord[i + 1], "mark17", nfe);
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("mark23")) {
                            if (!nextRecord[i + 1].equals("")) {
                                try {
                                    if (secondObject.getMark23() != null) {
                                        secondObject.setMark23(secondObject.getMark23() + Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("Во второй объект добавлено значение {} к метке mark23", nextRecord[i + 1]);
                                    } else {
                                        secondObject.setMark23(Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("Во второй объект добавлено значение {} к метке mark23", nextRecord[i + 1]);
                                    }
                                } catch (NumberFormatException nfe) {
                                    throw new CsvIllegalArgumentException(nextRecord[i + 1], "mark23", nfe);
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("mark35")) {
                            if (!nextRecord[i + 1].equals("")) {
                                try {
                                    if (secondObject.getMark35() != null) {
                                        secondObject.setMark35(secondObject.getMark35() + Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("Во второй объект добавлено значение {} к метке mark35 ", nextRecord[i + 1]);
                                    } else {
                                        secondObject.setMark35(Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("Во второй объект добавлено значение {} к метке mark35", nextRecord[i + 1]);
                                    }
                                } catch (NumberFormatException nfe) {
                                    throw new CsvIllegalArgumentException(nextRecord[i + 1], "mark35", nfe);
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("markFV")) {
                            if (!nextRecord[i + 1].equals("")) {
                                try {
                                    if (secondObject.getMarkFV() != null) {
                                        secondObject.setMarkFV(secondObject.getMarkFV() + Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("Во второй объект добавлено значение {} к метке markFV", nextRecord[i + 1]);
                                    } else {
                                        secondObject.setMarkFV(Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("Во второй объект добавлено значение {} к метке markFV", nextRecord[i + 1]);
                                    }
                                } catch (NumberFormatException nfe) {
                                    throw new CsvIllegalArgumentException(nextRecord[i + 1], "markFV", nfe);
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("markFX")) {
                            if (!nextRecord[i + 1].equals("")) {
                                try {
                                    if (secondObject.getMarkFX() != null) {
                                        secondObject.setMarkFX(secondObject.getMarkFX() + Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("Во второй объект добавлено значение {} к метке markFX", nextRecord[i + 1]);
                                    } else {
                                        secondObject.setMarkFX(Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("Во второй объект добавлено значение {} к метке markFX", nextRecord[i + 1]);
                                    }
                                } catch (NumberFormatException nfe) {
                                    throw new CsvIllegalArgumentException(nextRecord[i + 1], "markFХ", nfe);
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("markFT")) {
                            if (!nextRecord[i + 1].equals("")) {
                                try {
                                    if (secondObject.getMarkFT() != null) {
                                        secondObject.setMarkFT(secondObject.getMarkFT() + Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("Во второй объект добавлено значение {} к метке markFT", nextRecord[i + 1]);
                                    } else {
                                        secondObject.setMarkFT(Integer.valueOf(nextRecord[i + 1]));
                                        LOG.info("Во второй объект добавлено значение {} к метке markFT", nextRecord[i + 1]);
                                    }
                                } catch (NumberFormatException nfe) {
                                    throw new CsvIllegalArgumentException(nextRecord[i + 1], "markFT", nfe);
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
    public ThirdObject readDataLineToThirdObject(String dirCsv)  {
        ThirdObject thirdObject = new ThirdObject();
        List<Integer> mark01 = new ArrayList<>();
        List<Integer> mark17 = new ArrayList<>();
        List<Integer> mark23 = new ArrayList<>();
        List<Integer> mark35 = new ArrayList<>();
        List<Integer> markFV = new ArrayList<>();
        List<Integer> markFX = new ArrayList<>();
        List<Integer> markFT = new ArrayList<>();
        try {
            String dir = System.getProperty("user.dir") + dirCsv;
            List<String> listCSV = findCSVFile(dirCsv);
            for (String file : listCSV) {
                FileReader filereader = new FileReader(dir + file);
                CSVReader csvReader = new CSVReader(filereader);
                String[] nextRecord;
                while ((nextRecord = csvReader.readNext()) != null) {
                    for (int i = 0; (i + 1) < nextRecord.length; i++) {
                        if (nextRecord[i].equalsIgnoreCase("mark01")) {
                            if (!nextRecord[i + 1].equals("")) {
                                try {
                                    mark01.add(Integer.valueOf(nextRecord[i + 1]));
                                    LOG.info("В третий объект добавлено значение {} в список к метке mark01", nextRecord[i + 1]);
                                } catch (NumberFormatException nfe) {
                                    throw new CsvIllegalArgumentException(nextRecord[i + 1], "mark01", nfe);
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("mark17")) {
                            if (!nextRecord[i + 1].equals("")) {
                                try {
                                    mark17.add(Integer.valueOf(nextRecord[i + 1]));
                                    LOG.info("В третий объект добавлено значение {} в список к метке mark17", nextRecord[i + 1]);
                                } catch (NumberFormatException nfe) {
                                    throw new CsvIllegalArgumentException(nextRecord[i + 1], "mark01", nfe);
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("mark23")) {
                            if (!nextRecord[i + 1].equals("")) {
                                try {
                                    mark23.add(Integer.valueOf(nextRecord[i + 1]));
                                    LOG.info("В третий объект добавлено значение {} в список к метке mark23", nextRecord[i + 1]);
                                } catch (NumberFormatException nfe) {
                                    throw new CsvIllegalArgumentException(nextRecord[i + 1], "mark23", nfe);
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("mark35")) {
                            if (!nextRecord[i + 1].equals("")) {
                                try {
                                    mark35.add(Integer.valueOf(nextRecord[i + 1]));
                                    LOG.info("В третий объект добавлено значение {} в список к метке mark35", nextRecord[i + 1]);
                                } catch (NumberFormatException nfe) {
                                    throw new CsvIllegalArgumentException(nextRecord[i + 1], "mark35", nfe);
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("markFV")) {
                            if (!nextRecord[i + 1].equals("")) {
                                try {
                                    markFV.add(Integer.valueOf(nextRecord[i + 1]));
                                    LOG.info("В третий объект добавлено значение {} в список к метке markFV", nextRecord[i + 1]);
                                } catch (NumberFormatException nfe) {
                                    throw new CsvIllegalArgumentException(nextRecord[i + 1], "markFV", nfe);
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("markFX")) {
                            if (!nextRecord[i + 1].equals("")) {
                                try {
                                    markFX.add(Integer.valueOf(nextRecord[i + 1]));
                                    LOG.info("В третий объект добавлено значение {} в список к метке markFX", nextRecord[i + 1]);
                                } catch (NumberFormatException nfe) {
                                    throw new CsvIllegalArgumentException(nextRecord[i + 1], "markFX", nfe);
                                }
                            }
                        } else if (nextRecord[i].equalsIgnoreCase("markFT")) {
                            if (!nextRecord[i + 1].equals("")) {
                                try {
                                    markFT.add(Integer.valueOf(nextRecord[i + 1]));
                                    LOG.info("В третий объект добавлено значение {} в список к метке markFT", nextRecord[i + 1]);
                                } catch (NumberFormatException nfe) {
                                    throw new CsvIllegalArgumentException(nextRecord[i + 1], "markFT", nfe);
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
