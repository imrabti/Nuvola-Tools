package com.nuvola.myproject.server.service.impl;

import com.nuvola.myproject.server.business.EmailTemplate;
import com.nuvola.myproject.server.repos.EmailTemplateRepos;
import com.nuvola.myproject.server.service.EmailService;
import com.nuvola.myproject.shared.dto.EmailDTO;
import com.nuvola.myproject.shared.type.Email;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private VelocityEngine velocityEngine;

    @Autowired
    private EmailTemplateRepos emailTemplateRepos;

    public EmailDTO populateEmail(Email code,String to, String from, Map<String, String> params, String cc,
                                  String bcc) throws Exception {

        velocityEngine.init();
        VelocityContext context = new VelocityContext();

        Iterator<String> itValue = params.values().iterator();
        Iterator<String> itKey = params.keySet().iterator();

        while (itValue.hasNext()) {
            context.put(itKey.next(), itValue.next());
        }

        EmailTemplate emailTemplate = emailTemplateRepos.findByCode(code);
        String template = emailTemplate.getMessage();

        StringWriter contenuWriter = new StringWriter();
        velocityEngine.evaluate(context, contenuWriter, "", template);
        String message = contenuWriter.toString();

        EmailDTO resultMail = new EmailDTO();
        resultMail.setSubject(emailTemplate.getSubject());
        resultMail.setFrom(from);
        resultMail.setTo(to);
        resultMail.setCc(cc);
        resultMail.setBcc(bcc);
        resultMail.setMessage(message);

        return resultMail;
    }
}
