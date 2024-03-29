/**
 * Copyright 2012 Nuvola Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.nuvola.myproject.server.controller;

import com.nuvola.myproject.server.service.ReportService;
import com.nuvola.myproject.shared.dto.ReportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;

@Controller
@RequestMapping("/report")
public class ReportController {
     @Autowired
     ReportService reportService;

     @RequestMapping(method = RequestMethod.POST, produces = "application/pdf")
     @ResponseStatus(HttpStatus.OK)
     public void generateReport(@RequestParam ReportDTO reportDTO, HttpServletResponse response) {
          try {
               response.addHeader("Content-Disposition", "inline; filename="+reportDTO.getReportName()+".pdf");

               BufferedOutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
               byte[] result =  reportService.generatePdf(reportDTO);

               outputStream.write(result, 0, result.length);
               outputStream.flush();
               outputStream.close();
          } catch(Exception e){
               throw new RuntimeException(e);
          }
     }
}
