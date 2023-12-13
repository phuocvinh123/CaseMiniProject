package com.cg.service.productImg;


import com.cg.model.Product;
import com.cg.model.ProductImg;
import com.cg.repository.ProductImgRepository;
import com.cg.utils.UploadUtils;
import com.cloudinary.Cloudinary;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Transactional
@AllArgsConstructor
@Service
public class ProductImgService {
    private final Cloudinary cloudinary;
    @Autowired
    private ProductImgRepository productImgRepository;

    private final UploadUtils uploadUtil;

    public ProductImg saveAvatar(MultipartFile avatar) throws IOException {
        var file = new ProductImg();
        productImgRepository.save(file);

        var uploadResult = cloudinary.uploader().upload(avatar.getBytes(), uploadUtil.buildImageUpLoadParams(file));

        String fileUrl = (String) uploadResult.get("secure_url");
        String fileFormat = (String) uploadResult.get("format");

        file.setFileName(file.getId() + "." + fileFormat);
        file.setFileUrl(fileUrl);
        file.setFileFolder(UploadUtils.IMAGE_UPLOAD_FOLDER);
        file.setCloudId(file.getFileFolder() + "/" + file.getId());

        productImgRepository.save(file);
        return file;
    }

    public void delete(String fileUrl) {
        productImgRepository.deleteProductImgByFileUrl(fileUrl);
    }

    public void deleteById(String id) {
        productImgRepository.deleteById(Long.valueOf(id));
    }

}
