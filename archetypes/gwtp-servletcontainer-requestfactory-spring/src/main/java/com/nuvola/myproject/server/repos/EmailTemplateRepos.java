package com.nuvola.myproject.server.repos;

import com.nuvola.myproject.server.business.EmailTemplate;
import com.nuvola.myproject.shared.type.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailTemplateRepos extends JpaRepository<EmailTemplate, Long> {
    public EmailTemplate findByCode(Email code);
}
