package tiger.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tiger.model.Url;
import tiger.service.UrlService;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UrlController
 * @Description TODO
 * @Author tiger
 * @Date 2019/10/31 21:04
 * @Version 1.0
 **/
@RestController
@RequestMapping("/url")
public class UrlRestController {

    @Autowired
    private UrlService urlService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addUrl(@RequestParam("name") String name, @RequestParam("desc") String description) {
        Url url = new Url();
        url.setUrl(name);
        url.setDescription(description);
        urlService.addUrl(url);
    }

    @RequestMapping("/delete/{id}")
    public void deleteUrl(@PathVariable("id") int id) {
        urlService.deleteUrl(id);
    }

    @RequestMapping("/get/{id}")
    public Url getUrl(@PathVariable("id") int id) {
        return urlService.getUrl(id);
    }

    @RequestMapping("/getByName")
    public List<Url> getUrlByName(@RequestParam("name") String name) {
        return urlService.getByName(name);
    }

    @RequestMapping("/getUrls/{pageNumber}/{pageSize}")
    public Map<String, Object> getUrlByPage(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize) {
        return urlService.getUrlByPage(pageNumber, pageSize);
    }
}
