package test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import test.vo.TestVo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping(value="/")
    public String index(Model model){
        model.addAttribute("test", "1234");
        model.addAttribute("name", "spring-jstl-view");
        return "index";
    }

    @RequestMapping(value="/json", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> json(){
        Map<String, String> m = new HashMap<String, String>();
        m.put("test", "test json");
        return m;
    }

    /**
     * JSON 방식으로 request body 요청을 처리
     * @param name
     * @return
     */

    @RequestMapping(value="/vo-json", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public Map<String, String> postJson(
            @RequestBody TestVo testVo //auto-converting to TestVo
    ){
        Map<String, String> m = new HashMap<String, String>();
        m.put("test", "1234");
        m.put("testVo", testVo.getName());
        return m;
    }

    /**
     * Form 방식의 요청을 처리
     * @param name
     * @return
     */
    @RequestMapping(value="/form-json", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    @ResponseBody
    public Map<String, String> postFormJson(
            @RequestBody String name){
        Map<String, String> m = new HashMap<String, String>();
        m.put("test", "1234");
        m.put("name", name);
        return m;
    }

    /**
     * File upload 처리
     * @return
     */
    @RequestMapping(value="/file-upload", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity handleUpload(
            @RequestParam("file") MultipartFile file) {

        if (file == null || file.isEmpty()) {
            new ResponseEntity("no file", HttpStatus.BAD_REQUEST);
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get("/upload-folder" + file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity(String.format("file: %s has been successfully upoloaded", file.getName()), HttpStatus.OK);
    }

}
