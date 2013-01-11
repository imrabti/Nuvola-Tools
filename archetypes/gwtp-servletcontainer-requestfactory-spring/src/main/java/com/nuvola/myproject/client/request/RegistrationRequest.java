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

package com.nuvola.myproject.client.request;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.nuvola.myproject.client.request.proxy.UserProxy;
import com.nuvola.myproject.server.service.impl.RegistrationServiceImpl;
import com.nuvola.myproject.server.util.SpringServiceLocator;

@Service(value = RegistrationServiceImpl.class, locator = SpringServiceLocator.class)
public interface RegistrationRequest extends RequestContext {
    Request<Void> register(UserProxy userProxy);
}
