package by.example.controllers;


import by.example.simpleportlet.dao.domain.Category;
import by.example.simpleportlet.dao.domain.Link;
import by.example.simpleportlet.dao.jpa.CategoryRepository;
import by.example.simpleportlet.dao.jpa.LinkRepository;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.Random;

@Controller(value = "sample")
@RequestMapping(value = "VIEW")
public class PortletController {

    private static Log _log = LogFactoryUtil.getLog(PortletController.class);

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @RenderMapping
    public String renderCategories(RenderRequest request, RenderResponse response) {
        request.setAttribute("categoriesList", categoryRepository.findAll());
        return "categories";
    }

    @RenderMapping(params = "action=renderLinks")
    public String renderLinks(@RequestParam("categoryId") Long categoryId, RenderRequest request, RenderResponse response) {
        System.out.println("Category id selected is " + categoryId);
        request.setAttribute("linksList", linkRepository.findByCategoryId(categoryId));
        request.setAttribute("selectedCategoryId", categoryId);
        request.setAttribute("categoriesList", categoryRepository.findAll());
        return "categories";
    }

    @RenderMapping(params = "action=renderAddCategory")
    public String renderAddCategory(RenderRequest request, RenderResponse response) throws Exception {
        return "add_category";
    }

    @ActionMapping(params = "action=addNewCategory")
    public void addNewCategory(@RequestParam("title") String title, ActionRequest actionRequest, ActionResponse actionResponse) {
        categoryRepository.save(new Category(title));
        actionResponse.setRenderParameter("action", "renderCategories");
    }

    @RenderMapping(params = "action=renderAddLink")
    public String renderAddLink(@RequestParam("categoryId") Long categoryId, RenderRequest request, RenderResponse response) throws Exception {
        request.setAttribute("categoryId", categoryId);
        return "add_link";
    }

    @ActionMapping(params = "action=addNewLink")
    public void addNewLink(@RequestParam("categoryId") Long categoryId, @RequestParam("title") String title, ActionRequest actionRequest, ActionResponse actionResponse) {
        linkRepository.save(new Link(categoryId, title));
        actionRequest.setAttribute("linksList", linkRepository.findByCategoryId(categoryId));
        actionRequest.setAttribute("selectedCategoryId", categoryId);
        actionResponse.setRenderParameter("action", "renderCategories");
    }


    @RenderMapping(params = "action=renderToPrinter")
    public String doPrinterView(RenderRequest request, RenderResponse response) {
        return "printer";
    }

    @ActionMapping(params = "action=firstMethod")
    public void doHandle(ActionRequest actionRequest, ActionResponse actionResponse) {

        Long number = ParamUtil.getLong(actionRequest, "number");
        Long randomLong = new Random().nextLong();

        actionRequest.setAttribute("number", number);
        actionRequest.setAttribute("random", randomLong);
        actionRequest.setAttribute("result", number * randomLong);

        actionResponse.setRenderParameter("action", "renderToPrinter");

    }

    @ActionMapping(params = "action=addTrash")
    public void doHandleddddd(@RequestParam("number") Long number, ActionRequest actionRequest, ActionResponse actionResponse) {

        Long randomLong = new Random().nextLong();

        actionRequest.setAttribute("number", number);
        actionRequest.setAttribute("random", randomLong);
        actionRequest.setAttribute("result", number * randomLong);

        actionResponse.setRenderParameter("action", "renderToPrinter");
    }

}