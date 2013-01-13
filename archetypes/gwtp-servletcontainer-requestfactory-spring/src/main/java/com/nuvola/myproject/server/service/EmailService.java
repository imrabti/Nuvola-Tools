package com.nuvola.myproject.server.service;

import com.nuvola.myproject.shared.dto.EmailDTO;
import com.nuvola.myproject.shared.type.Email;

import java.util.Map;

public interface EmailService {
    public EmailDTO populateEmail(Email code, String to, String from, Map<String, String> params, String cc,
                                  String bcc) throws Exception;
}
