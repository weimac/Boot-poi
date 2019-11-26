package com.wk.service;

import com.wk.po.Weiuser;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Description:
 * @Company:qianfeng
 * @Auther:weiMac
 * @Date:2019/11/25
 * @Time:20:45
 */
public interface FileService {

    String importFile(MultipartFile file);

    List<Weiuser> export();


}
