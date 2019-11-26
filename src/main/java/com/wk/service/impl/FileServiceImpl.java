package com.wk.service.impl;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import com.wk.mapper.WeiuserMapper;
import com.wk.po.Weiuser;
import com.wk.service.FileService;
import com.wk.utils.ExcelUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * @Description:
 * @Company:qianfeng
 * @Auther:weiMac
 * @Date:2019/11/25
 * @Time:20:46
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    public WeiuserMapper weiuserMapper;

    @Override
    public String importFile(MultipartFile file) {


        List<Weiuser> list= ExcelUtils.importExcel( file,0,1,Weiuser.class);


        for(int i=0;i<list.size();i++){

            weiuserMapper.insertSelective(list.get(i));

        }
        System.out.println(list.size());
        //System.out.println(list.get(3));

        return "导入成功";
    }

    @Override
    public List<Weiuser> export() {

        List<Weiuser> list=weiuserMapper.selectAll();


        return list;
    }



}
