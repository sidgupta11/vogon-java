package org.zlogic.vogon.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class JspControllerDiffblueTest {
    @Test
    public void testIndexModelAndView() {
        ModelAndView actualIndexModelAndViewResult = (new JspController()).indexModelAndView();
        assertEquals("ModelAndView [view=\"main\"; model={configuration=null}]", actualIndexModelAndViewResult.toString());
        assertTrue(actualIndexModelAndViewResult.isReference());
    }

    @Test
    public void testFragmentModelAndView() {
        ModelAndView actualFragmentModelAndViewResult = (new JspController()).fragmentModelAndView("Fragment");
        assertEquals("ModelAndView [view=\"fragments/Fragment\"; model={configuration=null}]",
                actualFragmentModelAndViewResult.toString());
        assertTrue(actualFragmentModelAndViewResult.isReference());
    }
}

