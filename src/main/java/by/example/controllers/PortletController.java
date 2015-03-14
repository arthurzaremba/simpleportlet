package by.example.controllers;


import com.liferay.portal.kernel.util.ParamUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.*;
import java.util.List;
import java.util.Random;

@Controller(value="sample")
@RequestMapping(value="VIEW")
public class PortletController {

    @RenderMapping
    public String showForm(RenderRequest request, RenderResponse response) throws Exception {
        return "view";
    }

    @RenderMapping(params = "action=renderToPrinter")
    public String doPrinterView(RenderRequest request, RenderResponse response){
        return "printer";
    }

    @ActionMapping(params = "action=firstMethod")
    public void doHandle(ActionRequest actionRequest, ActionResponse actionResponse){

        Long number = ParamUtil.getLong(actionRequest,"number");
        Long randomLong = new Random().nextLong();

        actionRequest.setAttribute("number",number);
        actionRequest.setAttribute("random",randomLong);
        actionRequest.setAttribute("result", number * randomLong);

        actionResponse.setRenderParameter("action", "renderToPrinter");

    }

}