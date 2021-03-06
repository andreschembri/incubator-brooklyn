/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package brooklyn.catalog.internal;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

import brooklyn.catalog.CatalogItem.CatalogBundle;

public class CatalogBundleDto implements CatalogBundle {
    private String symbolicName;
    private String version;
    private String url;

    public CatalogBundleDto() {}

    public CatalogBundleDto(String name, String version, String url) {
        if (name == null && version == null) {
            Preconditions.checkNotNull(url, "url");
        } else {
            Preconditions.checkNotNull(name, "name");
            Preconditions.checkNotNull(version, "version");
        }

        this.symbolicName = name;
        this.version = version;
        this.url = url;
    }

    @Override
    public boolean isNamed() {
        return symbolicName != null && version != null;
    }

    @Override
    public String getSymbolicName() {
        return symbolicName;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("symbolicName", symbolicName)
                .add("version", version)
                .add("url", url)
                .toString();
    }
}
