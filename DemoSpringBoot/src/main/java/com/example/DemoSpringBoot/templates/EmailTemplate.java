package com.example.DemoSpringBoot.templates;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class EmailTemplate {
    private String template;
    // private Map<String, String> replacementParams;

    private InputStream stream;

    /**
     * REMINDER: IF IT CANNOT GET THE HTML FILE -> RUN MVN CLEAN INSTALL
     * @param customtemplate
     * @throws Exception
     */

    public EmailTemplate(String customtemplate) throws Exception {
        try {
            this.template = setTemplate(customtemplate);
        } catch (Exception e) {
            this.template = "Empty in Email Template";
            throw e;
        }
    }

    private String setTemplate(String customtemplate) throws Exception {
        stream = this.getClass().getResourceAsStream(customtemplate);
        String content = "Empty in Set Template";
        try {
            content = new String(stream.readAllBytes());
        } catch (IOException e) {
            throw new Exception("Could not read template: " + customtemplate);
        }

        return content;
    }

    public String getTemplate(Map<String, String> replacements) {
        System.out.println(replacements);
        String cTemplate = this.template;

        for (Map.Entry<String, String> entry : replacements.entrySet()) {
            cTemplate = cTemplate.replace("{{" + entry.getKey() + "}}", entry.getValue());
        }

        return cTemplate;
    }
}
