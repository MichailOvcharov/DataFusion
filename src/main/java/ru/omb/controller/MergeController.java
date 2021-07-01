package ru.omb.controller;

import au.com.bytecode.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.omb.entity.*;
import ru.omb.storage.StorageService;
import ru.omb.service.MergeService;

import java.io.FileWriter;
import java.io.*;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.*;


@Controller
public class MergeController {

    @Autowired
    private MergeService mergeService;

    public static void main(String[] args) throws IOException {
        // Запись в архив
//        ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("C:\\Users\\Michail\\Desktop\\DataFusion\\upload-dir\\archive2.zip"));
//        ZipEntry entry = new ZipEntry("Резюме_ОвчаровМБ.doc");
//        zout.putNextEntry(entry);
//        FileInputStream fis = new FileInputStream("C:\\Users\\Michail\\Desktop\\DataFusion\\upload-dir\\Резюме_ОвчаровМБ.doc");
//        byte[] buffer = new byte[fis.available()];
//        fis.read(buffer);
//        zout.write(buffer);
//        zout.closeEntry();
//        zout.close();
        // Помещаем в архив 2 файла
//        String dir = System.getProperty("user.dir") + "/csvTest/";
//        ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(dir + "archive3.zip"));
//        ZipEntry entry = new ZipEntry("csvFile1.csv");
//        zout.putNextEntry(entry);
//        FileInputStream fis = new FileInputStream(dir +"csvFile1.csv");
//        byte[] buffer = new byte[fis.available()];
//        fis.read(buffer);
//        zout.write(buffer);
//        ZipEntry entry2 = new ZipEntry("csvFile2.csv");
//        zout.putNextEntry(entry2);
//        FileInputStream fis2 = new FileInputStream(dir + "csvFile2.csv");
//        byte[] buffer2 = new byte[fis2.available()];
//        fis2.read(buffer2);
//        zout.write(buffer2);
//        zout.closeEntry();
//        zout.close();
        // Чтение данных из архива
//        ZipInputStream zin = new ZipInputStream(new FileInputStream("C:\\Users\\Michail\\Desktop\\DataFusion\\upload-dir\\archive.zip"));
//        ZipEntry entry;
//        while((entry = zin.getNextEntry()) != null) {
//            System.out.println(entry.getName());
//            System.out.println(entry.getSize());
//        }
//        zin.close();
//        ZipFile zip = new ZipFile("C:\\Users\\Michail\\Desktop\\DataFusion\\upload-dir\\archive3.zip");
//        Enumeration entries = zip.entries();
//        while(entries.hasMoreElements()) {
//            ZipEntry entry  = (ZipEntry) entries.nextElement();
//            System.out.println(entry .getName());
//            System.out.println(entry .getSize());
//            if (!entry .isDirectory()) {
//                write(zip.getInputStream(entry), new BufferedOutputStream(new FileOutputStream(
//                        "C:\\Users\\Michail\\Desktop\\DataFusion\\upload-dir\\" + entry.getName())));
//            }
//        }
    }

    private final StorageService storageService;

    @Autowired
    public MergeController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/")
    @RequestMapping(produces = "application/json; charset=UTF-8")
    public @ResponseBody JsonItog handleFileUpload(@RequestParam("file") MultipartFile file,
                                 RedirectAttributes redirectAttributes) throws IOException {
        storageService.store(file);
        String fileName = file.getOriginalFilename();
        mergeService.zipOut(fileName);
        FirstObject firstObject = mergeService.readDataLineToFirstObject();
        SecondObject secondObject = mergeService.readDataLineToSecondObject();
        ThirdObject thirdObject = mergeService.readDataLineToThierdObject();
        JsonItog jsonItog = new JsonItog();
        jsonItog.setFirstObject(firstObject);
        jsonItog.setSecondObject(secondObject);
        jsonItog.setThirdObject(thirdObject);
        return jsonItog;
    }

    @GetMapping("/")
    public  String listUploadedFiles(Model model) {
        return "test-csv";
    }
}
