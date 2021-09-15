package controllers;


import models.Country;
import models.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import services.ICountryService;
import services.ICityService;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
public class CityController {
    @Autowired
    private ICityService cityService;

    @Autowired
    private ICountryService countryService;

    @ModelAttribute("country")
    public Iterable<Country> classes() {
        return countryService.findAll();
    }
    @GetMapping({"/home","/"})
    public ModelAndView home(@RequestParam(defaultValue = "0") int pageNumber) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("cities", cityService.findAll(PageRequest.of(pageNumber,3,Sort.by("name"))));
        return modelAndView;
    }

    @GetMapping("/findByName")
    public ModelAndView findByName(@RequestParam String findName) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("cities", cityService.findAllByName(findName));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@RequestParam MultipartFile uppImg, @Valid @ModelAttribute City city, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("create");
        }
        String nameImg = uppImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppImg.getBytes(), new File("D:\\JavaProject\\Test_Spring_QLThanhPho\\src\\main\\webapp\\img/" + nameImg));
            String urlImg = "/i/img/" + nameImg;
            city.setImg(urlImg);
        } catch (IOException e) {
            System.err.println("chưa uppload file");
        }

            cityService.save(city);
            ModelAndView modelAndView = new ModelAndView("redirect:/home");
            return modelAndView;

    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        City city = cityService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@RequestParam MultipartFile uppImg, @Valid @ModelAttribute City city, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("edit");
        }
        String nameImg = uppImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppImg.getBytes(), new File("D:\\JavaProject\\Test_Spring_QLThanhPho\\src\\main\\webapp\\img/" + nameImg));
            String urlImg = "/i/img/" + nameImg;
            city.setImg(urlImg);
        } catch (IOException e) {
            System.err.println("chưa uppload file");
        }

            cityService.save(city);
            ModelAndView modelAndView = new ModelAndView("redirect:/home");
            return modelAndView;

    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Integer id){
        cityService.delete(cityService.findById(id).get());
        return new ModelAndView("redirect:/home");
    }


    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable int id){
        City city = cityService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("city", city);
        return modelAndView;
    }
}
