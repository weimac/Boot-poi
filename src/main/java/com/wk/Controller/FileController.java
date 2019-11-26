package com.wk.Controller;

import com.wk.po.Weiuser;
import com.wk.service.FileService;
import com.wk.utils.ExcelUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Company:qianfeng
 * @Auther:weiMac
 * @Date:2019/11/25
 * @Time:21:27
 */
@Controller
public class FileController {


    @Autowired
    private FileService fileService;

    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("download")
    public String down(){
        return "download";
    }


    @RequestMapping("/import")

    public String Import(MultipartFile file){

         fileService.importFile(file);

         return "download";

    }

    @RequestMapping("/down")
    public void exportExcel(HttpServletResponse response){
        //根据条件查询数据库数据list
        List<Weiuser> list =fileService.export();
        //设置表名，引脚名，文件格式，及写入list数据到excel中
        ExcelUtils.exportExcel(list,"微信用户信息统计表","Weiuser", Weiuser.class,"Weiuser.xls",response);
    }


}
