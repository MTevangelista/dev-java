package com.infnet.CloudServiceDevJavaATProduct.service;

import com.infnet.CloudServiceDevJavaATProduct.model.Product;
import com.infnet.CloudServiceDevJavaATProduct.repository.IProductRepository;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class ProductService {
    
    @Autowired
    IProductRepository repository;
    
    public Product save(Product product) {  
        return repository.save(product);
    }
    
//    public String uploadFile(MultipartFile multipartFile) {
//
//        String fileUrl = "";
//        try {
//            File file = convertMultiPartToFile(multipartFile);
//            String fileName = file.getName();
//            fileUrl = "C:/file/" + fileName; 
//        } catch (Exception e) {
//           e.printStackTrace();
//        }
//        return fileUrl;
//    }
    
    public String prepareImgURL(MultipartFile multipartFile) throws IOException {
        String path = "C:/CloudServiceDevJavaAtImgFolder/";
        String fileUrl = "";
        String fileName;
        File file;
        
        file = convertToFile(multipartFile);
        fileName = file.getName();
        fileUrl = path + fileName;
        return fileUrl;
    }
    
//    private File convertMultiPartToFile(MultipartFile file) throws IOException {
//        new File("C:/file/").mkdirs();
//        File convFile = new File("C:/file/"+file.getOriginalFilename());
//        FileOutputStream fos = new FileOutputStream(convFile);
//        fos.write(file.getBytes());
//        fos.close();
//        return convFile;
//    }
    
    public File convertToFile(MultipartFile multipartFile) throws IOException {
        String path = "C:/CloudServiceDevJavaAtImgFolder/";
        new File(path).mkdirs();
        File convertedFile;
        FileOutputStream fileOutputStream;
        
        convertedFile = new File(path+multipartFile.getOriginalFilename());
        fileOutputStream = new FileOutputStream(convertedFile);
        fileOutputStream.write(multipartFile.getBytes());
        fileOutputStream.close();
        return convertedFile;
    }
    
    public List<Product> getAll(){
        return (List<Product>) repository.findAll();
    }
    
    public Product getById(int id) {
        return repository.findById(id).get();
    }
    
    public Product getByCode(int code) {
        return repository.getByCode(code);
    }
    
    public void delete(Integer id) {
        repository.deleteById(id);
    }
    
}

